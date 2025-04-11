package View.TrackProgress;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * CalendarView provides a simple stub implementation of a calendar-based UI.
 * This class simulates displaying a calendar and allows the user to select a date.
 */
public class CalendarView {

    /**
     * Displays a stub of the current month's calendar.
     */
    public void displayCalendar() {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Calendar for " + currentDate.getMonth() + " " + currentDate.getYear());
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        // Additional logic to print a calendar grid can be added here.
    }

    /**
     * Simulates user selection of a date based on input.
     *
     * @param dateInput A String representing a date (e.g., "2025-04-15") in ISO_LOCAL_DATE format.
     * @return The selected LocalDate.
     */
    public LocalDate selectDate(String dateInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate selectedDate = LocalDate.parse(dateInput, formatter);
        System.out.println("Selected Date: " + selectedDate);
        return selectedDate;
    }
}
