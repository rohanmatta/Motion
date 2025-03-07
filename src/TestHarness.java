import Controller.WarmUpCreateController;
import Controller.TrackProgressController;
import Model.WarmupAndRecovery.WarmUpPlan;
import Model.TrackProgress.ProgressData;
import Model.TrackProgress.WorkoutSession;
import View.WarmupAndRecovery.ClientLogin;
import View.WarmupAndRecovery.TrainerLogin;
import View.WarmupAndRecovery.ViewWarmUpOptions;
import View.TrackProgress.LogWorkoutView;
import View.TrackProgress.TrackProgressView;
import java.util.List;


public class TestHarness {

    public static void main(String[] args) {
        // 1. Test ClientLogin (simulate client login)
        System.out.println("Testing ClientLogin...");
        ClientLogin clientLoginView = new ClientLogin();
        // Simulate client login with test credentials
        clientLoginView.simulateLogin("clientUsername", "password");

        // 2. Test TrainerLogin (simulate trainer login)
        System.out.println("\nTesting TrainerLogin...");
        TrainerLogin trainerLoginView = new TrainerLogin();
        // Simulate trainer login with test credentials
        trainerLoginView.simulateLogin("trainerUsername", "password");

        // 3. Test WarmUpCreateController (create a warm-up plan)
        System.out.println("\nTesting WarmUpCreateController...");
        WarmUpCreateController warmUpController = new WarmUpCreateController();
        WarmUpPlan warmUpPlan = warmUpController.createPlan("12345");  // Simulate creating a warm-up plan for client

        // 4. Display created plan
        System.out.println("\nDisplaying WarmUpPlan details...");
        warmUpPlan.displayPlanDetails();  // This will call the stubbed method and print plan details

        // 5. Test updatePlan method
        System.out.println("\nTesting updatePlan method...");
        String newDetails = "Updated Warmup Plan";
        warmUpController.updatePlan(warmUpPlan, newDetails);
        warmUpPlan.displayPlanDetails(); // Display updated plan

        // 6. Test getPlan method (simulate retrieving the plan)
        System.out.println("\nTesting getPlan method...");
        WarmUpPlan retrievedPlan = warmUpController.getPlan("12345");
        System.out.println("Retrieved Plan: " + retrievedPlan);

        // 7. Test displayPlan method (simulate displaying plan)
        System.out.println("\nTesting displayPlan method...");
        warmUpController.displayPlan(retrievedPlan);

        // 8. Test deletePlan method (simulate deleting the plan)
        System.out.println("\nTesting deletePlan method...");
        warmUpController.deletePlan("12345");
        System.out.println("Plan deleted successfully.");

        // 9. Test ViewWarmUpOptions (view warm-up options)
        System.out.println("\nTesting ViewWarmUpOptions...");
        ViewWarmUpOptions viewWarmUpOptions = new ViewWarmUpOptions();
        // Simulate displaying the warm-up options for the user
        viewWarmUpOptions.showOptions();


        //..............................
        //TRACKING PROGRESS FLOW TESTING
        //..............................

        // Setting up the controller and views
        TrackProgressController trackProgressController = new TrackProgressController();
        LogWorkoutView logWorkoutView = new LogWorkoutView(trackProgressController);
        TrackProgressView trackProgressView = new TrackProgressView();

        // Test Logging a Workout
        System.out.println("\nLogging a Workout...");
        logWorkoutView.displayWorkoutLogForm();

        // Test Retrieving Progress Data
        System.out.println("\nRetrieving Progress Data...");
        ProgressData progressData = trackProgressController.getProgress(1);
        if (progressData != null) {
            System.out.println("Progress data retrieved.");
        } else {
            System.out.println("Progress data is null.");
        }

        // Test Fetching Workout Sessions
        System.out.println("\nFetching Workout Sessions...");
        List<WorkoutSession> sessions = trackProgressController.getUserWorkoutSessions(1);
        if (!sessions.isEmpty()) {
            System.out.println("Retrieved " + sessions.size() + " workout session(s).");
        } else {
            System.out.println("No workout sessions found.");
        }

        // Test Displaying Progress Trends
        System.out.println("\nDisplaying Progress Trends...");
        trackProgressView.displayProgressTrends();

        System.out.println("\nTEST HARNESS FINISHED!");


    }
}
