package Controller;

import Model.DB.DBError;
import Model.Login.User;
import Model.TrackProgress.WorkoutEntry;
import View.MainMenuView;
import View.TrackProgress.TrackProgressView;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrackProgressController {
    private final User user;
    private Connection conn;
    private final TrackProgressView view;
    private final List<WorkoutEntry> sessions = new ArrayList<>();

    public TrackProgressController(User user) throws DBError {
        this.user = user;
        this.view = new TrackProgressView();
        this.conn = new DbController().getConn();

        // initial load and render
        loadSessions();
        view.updateTable(sessions);

        // add‐workout wiring
        view.getAddButton().addActionListener(e -> onAdd());

        // back‐to‐menu wiring
        view.getBackButton().addActionListener(e -> {
            view.dispose();
            new MainMenuView(user);
        });
    }

    private void loadSessions() {
        sessions.clear();
        String sql = """
            SELECT id, Workout_Name, `Date`, Sets, Average_Reps, Average_Weight
              FROM Workouts
             WHERE user_id = ?
             ORDER BY `Date` DESC
            """;

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setLong(1, Long.parseLong(user.getUserID()));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                WorkoutEntry w = new WorkoutEntry();
                w.setId(rs.getLong("id"));
                w.setUserId(Long.parseLong(user.getUserID()));
                w.setWorkoutName(rs.getString("Workout_Name"));
                w.setDate(rs.getDate("Date"));
                w.setSets(rs.getInt("Sets"));
                w.setReps(rs.getInt("Average_Reps"));
                w.setWeight(rs.getInt("Average_Weight"));
                sessions.add(w);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error loading sessions");
        }
    }

    private void onAdd() {
        String sql = """
            INSERT INTO Workouts
              (user_id, Workout_Name, `Date`, Sets, Average_Reps, Average_Weight)
            VALUES (?,?,?,?,?,?)
            """;
        try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setLong(1, Long.parseLong(user.getUserID()));
            st.setString(2, view.getWorkoutName());
            st.setDate(3, view.getDate());
            st.setInt(4, view.getSets());
            st.setInt(5, view.getReps());
            st.setInt(6, view.getWeight());

            if (st.executeUpdate() == 1) {
                ResultSet keys = st.getGeneratedKeys();
                WorkoutEntry w = new WorkoutEntry(
                        Long.parseLong(user.getUserID()),
                        view.getWorkoutName(),
                        view.getDate(),
                        view.getSets(),
                        view.getReps(),
                        view.getWeight()
                );
                if (keys.next()) {
                    w.setId(keys.getLong(1));
                }
                sessions.add(0, w);
                view.updateTable(sessions);
                JOptionPane.showMessageDialog(view, "Workout added!");
            } else {
                JOptionPane.showMessageDialog(view, "Insert failed");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Invalid input or DB error");
        }
    }

    public List<WorkoutEntry> getSessions() {
        return sessions;
    }
}
