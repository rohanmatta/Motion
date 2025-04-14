package View.TrackProgress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CalendarView extends JFrame {
    private JLabel calendarLabel;
    private JTextField dateInputField;
    private JButton selectButton;
    private JLabel selectedDateLabel;

    /**
     * Constructor that sets up the GUI components.
     */
    public CalendarView() {
        setTitle("Calendar View");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel(new BorderLayout());

        // Header
        LocalDate currentDate = LocalDate.now();
        calendarLabel = new JLabel("Calendar for " + currentDate.getMonth() + " " + currentDate.getYear(), SwingConstants.CENTER);
        panel.add(calendarLabel, BorderLayout.NORTH);

        // Center panel
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(new JLabel("Mon  Tue  Wed  Thu  Fri  Sat  Sun"));
        panel.add(centerPanel, BorderLayout.CENTER);

        // Bottom panel
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
        pack();


        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Select Date button clicked"); // Debug statement
                selectDateAction();
            }
        });
    }


    private void selectDateAction() {
        String input = dateInputField.getText();
        System.out.println("Date input received: " + input); // Debug statement
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate selected = LocalDate.parse(input, formatter);
            selectedDateLabel.setText("Selected Date: " + selected.toString());
            System.out.println("Selected Date updated to: " + selected.toString()); // Debug statement
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Invalid date format. Please enter date as YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalendarView().setVisible(true);
            }
        });
    }
}
