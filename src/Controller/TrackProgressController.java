// TrackProgressController.java
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
    private final Connection conn;
    private final TrackProgressView view;
    private final List<WorkoutEntry> sessions = new ArrayList<>();

    public TrackProgressController(User user) throws DBError {
        this.user = user;
        this.view = new TrackProgressView();
        this.conn = new DbController().getConn();

        loadSessions();
        view.updateTable(sessions);

        view.getAddButton().addActionListener(e -> onAdd());
        view.getDeleteButton().addActionListener(e -> onDelete());
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
        String workout = view.getWorkoutName();
        int sets       = view.getSets();
        int reps       = view.getReps();
        int weight     = view.getWeight();

        if (workout.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Workout name cannot be blank.");
            return;
        }
        if (sets < 1) {
            JOptionPane.showMessageDialog(view, "You must do at least one set.");
            return;
        }
        if (reps < 1) {
            JOptionPane.showMessageDialog(view, "Reps must be at least 1.");
            return;
        }
        if (weight < 1) {
            JOptionPane.showMessageDialog(view, "Weight must be positive.");
            return;
        }

        String sql = """
            INSERT INTO Workouts
              (user_id, Workout_Name, `Date`, Sets, Average_Reps, Average_Weight)
            VALUES (?,?,?,?,?,?)
            """;
        try (PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setLong(1, Long.parseLong(user.getUserID()));
            st.setString(2, workout);
            st.setDate(3, view.getDate());
            st.setInt(4, sets);
            st.setInt(5, reps);
            st.setInt(6, weight);

            if (st.executeUpdate() == 1) {
                ResultSet keys = st.getGeneratedKeys();
                WorkoutEntry w = new WorkoutEntry(
                        Long.parseLong(user.getUserID()),
                        workout, view.getDate(), sets, reps, weight
                );
                if (keys.next()) w.setId(keys.getLong(1));
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

    private void onDelete() {
        int row = view.getTable().getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(view, "Please select a workout to delete.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(
                view, "Really delete this workout?", "Confirm Delete", JOptionPane.YES_NO_OPTION
        );
        if (confirm != JOptionPane.YES_OPTION) return;

        WorkoutEntry w = sessions.get(row);
        String sql = "DELETE FROM Workouts WHERE id = ?";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setLong(1, w.getId());
            if (st.executeUpdate() == 1) {
                sessions.remove(row);
                view.updateTable(sessions);
                JOptionPane.showMessageDialog(view, "Workout deleted.");
            } else {
                JOptionPane.showMessageDialog(view, "Delete failed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error deleting workout.");
        }
    }

    // expose view for tests
    public TrackProgressView getView() {
        return view;
    }

    public List<WorkoutEntry> getSessions() {
        return sessions;
    }
}
