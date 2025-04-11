package View.TrackProgress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * CalendarView provides a simple stub implementation of a calendar-based UI.
 * This class creates a GUI that displays the current month/year and allows the user to select a date.
 */
public class CalendarView extends JFrame {
    private JLabel calendarLabel;
    private JTextField dateInputField;
    private JButton selectButton;
    private JLabel selectedDateLabel;

    /**
     * Constructor - sets up the GUI components.
     */
    public CalendarView() {
        setTitle("Calendar View");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create main panel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Header: Display current month and year
        LocalDate currentDate = LocalDate.now();
        calendarLabel = new JLabel("Calendar for " + currentDate.getMonth() + " " + currentDate.getYear(), SwingConstants.CENTER);
        panel.add(calendarLabel, BorderLayout.NORTH);

        // Center panel: Display day names (stub for calendar grid)
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(new JLabel("Mon  Tue  Wed  Thu  Fri  Sat  Sun"));
        panel.add(centerPanel, BorderLayout.CENTER);

        // Bottom panel: Input for date selection
        JPanel bottomPanel = new JPanel(new FlowLayout());
        dateInputField = new JTextField(10);
        selectButton = new JButton("Select Date");
        selectedDateLabel = new JLabel("Selected Date: ");

        bottomPanel.add(new JLabel("Enter date (YYYY-MM-DD):"));
        bottomPanel.add(dateInputField);
        bottomPanel.add(selectButton);
        bottomPanel.add(selectedDateLabel);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);
        pack(); // Adjust frame size based on content

        // Set up the action listener for the Select Date button.
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Select Date button clicked"); // Debug statement
                selectDateAction();
            }
        });
    }

    /**
     * Action performed when the user clicks the "Select Date" button.
     * It parses the entered date and displays it on the GUI.
     */
    private void selectDateAction() {
        String input = dateInputField.getText();
        System.out.println("Date input received: " + input); // Debug statement
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate selected = LocalDate.parse(input, formatter);
            selectedDateLabel.setText("Selected Date: " + selected.toString());
            System.out.println("Selected Date updated to: " + selected.toString()); // Debug statement
        } catch (Exception ex) {
            ex.printStackTrace(); // Print the exception to the console for debugging
            JOptionPane.showMessageDialog(this, "Invalid date format. Please enter date as YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Main method to run the CalendarView GUI.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarView().setVisible(true);
            }
        });
    }
}
