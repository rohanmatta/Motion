Rohan Matta, Brett Cunningham, Sydney Black, Ryan Zanoni

## M04-A03 Contributions: (UPDATE THIS)
| Name                         | Contribution                        |
|------------------------------|-------------------------------------|
| Brett Cunningham (Team Lead) | Worked on Tracking Progress Usecase |
| Rohan Matta                  | Worked on Sharing Progress Usecase  |
| Sydney Black                 | Worked on initial Main Menu         |
| Ryan Zanoni                  | Worked on Refactoring Code          |

Use Cases Scoped for Design and Implementation (Track Progress System - Athlete)
1. The athlete logs into the system to access their workout history and to have progress tracking features.
2. Athlete Views Workout History
3. The athlete selects a past session to review details including sets, reps, duration, calories burned, and personal notes.
4. Athlete logs a New Workout Session
5. The athlete inputs workout details, including exercise type, sets, reps, duration, calories burned, and weight lifted.
6. Athlete views Progress Trends
7. The athlete views/analyzes overall performance trends, including average sets, reps, duration, and calories burned across workouts.
8. Athlete Updates Workout Notes
9. The athlete adds or modifies notes on past workout sessions to track progress and make edits.

Use Cases Scoped for Design and Implementation (Share Progress System - User)

1. The user logs into the system to access their workout history and sharing features.
2. User Views Shareable Workouts
    - The user selects a past workout session from their history to share with others.
3. User Adds Captions or Hashtags
    - The user inputs captions, hashtags, or additional details to personalize the shared workout.
4. User Reviews the Post
    - The user reviews the selected workout and added details to ensure accuracy before sharing.
5. User Confirms and Shares the Post
    - The user confirms the post details and shares the workout on their desired platform.

Make sure your project includes a README.TXT file
and that this file describes your refactoring 
implementations i.e. the class or classes used and who implemented them.

Refactoring Implementations:
1. No indication of login attempt if it fails - New Label in LoginView.java 
2. Reference to personal table in ticket - Removed in TicketController.java
3. Message chat display does not show 2 column view if only one person has sent a message - Reimplemented display logic in SupportTicketView.java 
4. DB errors just print to console and the app effectively crashes - Added message dialog system
5. There are no permission checks on the ticket messaging system yet - Added check in UI
6. Ticket list view does not filter by permissions - added check before 
7. Password is stored in plain text - Added bcrypt hashing in LoginController.java
8. No way to get back to list view from chat - Added Back button
9. Ticket view doesn’t filter out archived conversations - Implemented archive list
10. All queries select all columns - Fixed queries in TicketController.java
11. No menu screen to chose app flow - Implemented app flow


Use Cases:
- Support Ticket
- Tracking Progress
- Sharing Progress
 
Login details:
login: admin
password: password

login: test_user
password: password

es the process of sharing progress by breaking it down into smaller, manageable steps