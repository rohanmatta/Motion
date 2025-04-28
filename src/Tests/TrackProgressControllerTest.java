package Tests;

import Controller.TrackProgressController;
import Model.Login.User;
import Model.TrackProgress.WorkoutEntry;
import View.TrackProgress.TrackProgressView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackProgressControllerTest {

    private TrackProgressController controller;
    private TrackProgressView view;

    @BeforeEach
    void setUp() throws Exception {
        // create a test user
        User testUser = new User();
        testUser.setUserID("1");
        testUser.setUserName("testuser");

        // instantiate controller and grab its view
        controller = new TrackProgressController(testUser);
        view = controller.getView();
    }

    /**
     * TP-UT1: Accept a well-formed workout entry.
     */
    @Test
    void TP_UT1_validWorkoutEntry_createsEntry() {
        int before = controller.getSessions().size();

        // fill in valid data
        view.getNameField().setText("Bench Press");
        view.getSetsSpinner().setValue(3);
        view.getRepsSpinner().setValue(10);
        view.getWeightSpinner().setValue(135);
        view.getDateSpinner().setValue(Date.valueOf(LocalDate.now()));

        // simulate button click
        view.getAddButton().doClick();

        List<WorkoutEntry> sessions = controller.getSessions();
        assertEquals(before + 1, sessions.size(),
                "A new session should have been added");

        WorkoutEntry added = sessions.get(0);
        assertEquals("Bench Press", added.getWorkoutName());
        assertEquals(3, added.getSets());
        assertEquals(10, added.getReps());
        assertEquals(135, added.getWeight());
    }

    /**
     * TP-UT2: Reject zero or negative reps/weight.
     */
    @Test
    void TP_UT2_invalidRepsOrWeight_noNewEntry() {
        int before = controller.getSessions().size();

        // fill in invalid data
        view.getNameField().setText("Squat");
        view.getSetsSpinner().setValue(4);
        view.getRepsSpinner().setValue(0);
        view.getWeightSpinner().setValue(-10);
        view.getDateSpinner().setValue(Date.valueOf(LocalDate.now()));

        // simulate button click
        view.getAddButton().doClick();

        // since validation should block insertion, count remains the same
        assertEquals(before, controller.getSessions().size(),
                "No new session should be added when reps or weight are invalid");
    }
}
