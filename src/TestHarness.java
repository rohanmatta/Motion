import Controller.ShareProgressController;
import Controller.TicketController;
import Controller.WarmUpCreateController;
import Controller.TrackProgressController;
import Model.Login.User;
import Model.ShareProgress.Post;
import Model.ShareProgress.SocialMediaAccount;
import Model.Support.Message;
import Model.Support.SupportUser;
import Model.Support.Ticket;
import Model.WarmupAndRecovery.WarmUpPlan;
import Model.TrackProgress.ProgressData;
import Model.TrackProgress.WorkoutSession;
import View.Support.TicketView;
import View.WarmupAndRecovery.ClientLogin;
import View.WarmupAndRecovery.TrainerLogin;
import View.WarmupAndRecovery.ViewWarmUpOptions;
import View.TrackProgress.LogWorkoutView;
import View.TrackProgress.TrackProgressView;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

        //..............................
        //TRACKING SHARE PROGRESS FLOW TESTING
        //..............................

        System.out.println("\nTRACKING SHARE PROGRESS FLOW TESTING...");

        // Create instance of ShareProgressController
        ShareProgressController shareProgressController = new ShareProgressController();

        // Simulate creating social media account
        SocialMediaAccount socialMediaAccount = new SocialMediaAccount("acc001", "Twitter", "fitnessTest", "Password123!");

        // Create and publish a post about a workout
        Post progressPost1 = new Post("post001", "Just finished a 5k run!", "Twitter", LocalDateTime.now(), "Feeling energized after my run!!");
        socialMediaAccount.publishPost(progressPost1);

        // Create and publish another post about a workout
        Post progressPost2 = new Post("post002", "Just hit a new PR on squats!", "Twitter", LocalDateTime.now(), "Hard work pays off!");
        socialMediaAccount.publishPost(progressPost2);

        // Test ShareProgressView to display the social media posts
        shareProgressController.getUserProgress().displaySocialMediaPosts(socialMediaAccount);

        //..............................
        //MESSAGE SUPPORT TICKET FLOW TESTING
        //..............................

        System.out.println("\nMESSAGE SUPPORT TICKET FLOW TESTING...");

        // Set up initial state and users
        User ticketUser = new User();
        ticketUser.setUserName("TicketUser");
        ticketUser.setUserID("test123");
        TicketController controller = new TicketController(ticketUser);
        SupportUser supportUser = new SupportUser();
        supportUser.setUserName("testSupport");
        supportUser.setUserPassword("test");
        TicketView ticketView = new TicketView(controller);

        // Add new ticket
        System.out.println("\nAdding new ticket");
        ticketView.newTicket("Support request 1", ticketUser, supportUser);

        // Verify ticket was added to list
        System.out.println("\nList of tickets after adding new ticket");
        ticketView.listTickets();

        // Get the created ticket
        Ticket ticket = ticketView.getTicket();
        System.out.println("\nCreated ticket");
        System.out.println(ticket);

        // Add new message to the ticket
        ticket.addMessage(new Message("Support request information", ticketUser));
        System.out.println("\nTicket with added message");
        System.out.println(ticket.getMessages());

        // Add support user response
        ticket.addMessage(new Message("Support team response", supportUser));
        System.out.println("\nTicket with support message");
        System.out.println(ticket.getMessages());

        // ............................
        // DISPLAYING COMPOSITE PATTERN
        // ............................

        // Create individual posts
        Post post1 = new Post("post001", "Completed a 5k run!", "Twitter", LocalDateTime.now(), "Feeling great!");
        Post post2 = new Post("post002", "Hit a new PR on squats!", "Instagram", LocalDateTime.now(), "Hard work pays off!");
        Post post3 = new Post("post003", "Yoga session completed!", "Facebook", LocalDateTime.now(), "Relaxed and refreshed!");

        // Create a social media account
        SocialMediaAccount account1 = new SocialMediaAccount("acc001", "Twitter", "fitnessUser", "password123", new ArrayList<>(), new ArrayList<>());

        // Add posts to the account
        account1.addComponent(post1);
        account1.addComponent(post2);

        // Create another social media account
        SocialMediaAccount account2 = new SocialMediaAccount("acc002", "Instagram", "workoutUser", "password456", new ArrayList<>(), new ArrayList<>());

        // Add a post to the second account
        account2.addComponent(post3);

        // Nest the second account into the first account
        account1.addComponent(account2);

        // Display the composite structure
        System.out.println("Displaying Composite Pattern:");
        account1.display();
    }
}
