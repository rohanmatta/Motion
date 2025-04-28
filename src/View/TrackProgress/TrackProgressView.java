// TrackProgressView.java
package View.TrackProgress;

import Model.TrackProgress.WorkoutEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
import java.util.List;

public class TrackProgressView extends JFrame {
    private final JSpinner dateSpinner   = new JSpinner(new SpinnerDateModel());
    private final JTextField nameField   = new JTextField(15);
    private final JSpinner setsSpinner   = new JSpinner(new SpinnerNumberModel(3, 1, 20, 1));
    private final JSpinner repsSpinner   = new JSpinner(new SpinnerNumberModel(10, 0, 100, 1));
    private final JSpinner weightSpinner = new JSpinner(new SpinnerNumberModel(45, -1000, 500, 1));
    private final JButton addButton      = new JButton("Add Workout");
    private final JButton deleteButton   = new JButton("Delete Workout");
    private final JButton backButton     = new JButton("Back");
    private final DefaultTableModel tableModel;
    private final JTable table;

    public TrackProgressView() {
        super("Track Progress");
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));

        tableModel = new DefaultTableModel(
                new String[]{"Date","Workout","Sets","Reps","Weight"}, 0
        );
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Form Layout
        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        form.add(new JLabel("Date:"));     form.add(dateSpinner);
        form.add(new JLabel("Workout:"));  form.add(nameField);
        form.add(new JLabel("Sets:"));     form.add(setsSpinner);
        form.add(new JLabel("Reps:"));     form.add(repsSpinner);
        form.add(new JLabel("Weight:"));   form.add(weightSpinner);
        form.add(backButton);
        form.add(addButton);
        form.add(deleteButton);

        setLayout(new BorderLayout(8,8));
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // getters for controller and tests
    public JSpinner   getDateSpinner()   { return dateSpinner; }
    public JTextField getNameField()     { return nameField; }
    public JSpinner   getSetsSpinner()   { return setsSpinner; }
    public JSpinner   getRepsSpinner()   { return repsSpinner; }
    public JSpinner   getWeightSpinner() { return weightSpinner; }
    public JButton    getAddButton()     { return addButton; }
    public JButton    getDeleteButton()  { return deleteButton; }
    public JButton    getBackButton()    { return backButton; }
    public JTable     getTable()         { return table; }

    public Date  getDate()        { return new Date(((java.util.Date) dateSpinner.getValue()).getTime()); }
    public String getWorkoutName() { return nameField.getText().trim(); }
    public int    getSets()        { return (Integer) setsSpinner.getValue(); }
    public int    getReps()        { return (Integer) repsSpinner.getValue(); }
    public int    getWeight()      { return (Integer) weightSpinner.getValue(); }

    /**
     * Refreshes the table with a new list of entries
     */
    public void updateTable(List<WorkoutEntry> entries) {
        tableModel.setRowCount(0);
        for (WorkoutEntry e : entries) {
            tableModel.addRow(new Object[]{
                    e.getDate(), e.getWorkoutName(), e.getSets(), e.getReps(), e.getWeight()
            });
        }
    }
}
