Rohan Matta, Brett Cunningham, Sydney Black, Ryan Zanoni

## M03-A04 Contributions:
| Name                         | Contribution                                                   |
|------------------------------|----------------------------------------------------------------|
| Brett Cunningham (Team Lead) | Worked on initial usecase                                      |
| Rohan Matta                  | Worked on initial usecase                                      |
| Sydney Black                 | Worked on initial usecase                                      |
| Ryan Zanoni                  | Worked on initial usecase, set up database and log in function |

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

Login details:
login: admin
password: password

login: test_user
password: password



# Sydney Black: 
### Command Pattern:
- The Command Pattern is used to encapsulate actions such as logging a workout and starting a warm-up.
- Classes Implementing the Command Pattern:
    - `LogWorkoutCommand`: Encapsulates the action of logging a workout in the ProgressTracker model.
    - `StartWarmUpCommand`: Encapsulates the action of starting a warm-up using the WarmUpService model.
- The commands are executed in the `WarmUpCreateController`, where they are triggered by user interactions with the view.

### Factory Method Pattern:
- The Factory Method Pattern is used to abstract the creation of different warm-up plans.
- Classes Implementing the Factory Method Pattern:
    - `WarmUpPlanFactory`: A factory responsible for creating specific warm-up plans, such as `CardioWarmUp`, `StrengthWarmUp`, or `FlexibilityWarmUp`.
- Why it was used: The Factory Method pattern provides flexibility in adding new types of warm-up plans without modifying existing code, improving scalability.

# Brett Cunningham:
### Observer Pattern:
Implementation:
- The Observer Pattern is implemented to provide real-time updates for progress tracking. When progress data is updated, all registered observers are automatically notified.
#### Classes/Interfaces Involved:
- Observer (interface): Located in the Observer package; defines the update method.
- Subject (interface): Located in the Observer package; defines methods to register, remove, and notify observers.
- ProgressSubject (class): Located in the Model.TrackProgress package; manages ProgressData and notifies observers upon updates.
- TrackProgressView (class): Located in the View.TrackProgress package; implements the Observer interface and updates the user interface in response to progress changes.
#### Purpose:
- Ensures that UI elements reflecting fitness progress (e.g., workout trends and dashboards) remain current without requiring manual refreshes.
### Calendar UI:
Implementation:
- The Calendar UI pattern is used to provide an intuitive date-selection interface for logging workout sessions. This design pattern enhances usability by simulating a calendar view where users can pick specific dates.
#### Classes/Interfaces Involved:
- CalendarView (class): Located in the View (or View.TrackProgress if integrated) folder; displays a basic monthly calendar and allows the user to select a date.
#### Purpose:
- Provides a user-friendly method for users to select a date for logging workouts which improves the overall user experience and efficiency when interacting with the fitness tracking application.

## Ryan Zanoni
## Builder Pattern
Implementation:
- The builder pattern allows us to quickly construct ticket values in a readable way
### Classes Involved
- Model.Support.Ticket
### Purpose
- Ensures ticket creation is seamless and easy for dev experience
## Chat Pattern
Implementation:
- The Chat pattern allows us to effectively communicate with users
### Classes Involved
- SupportTicketView
- TicketListView
- TicketController
- Ticket
- User
- Support User
### Purpose
Simplifies communication with users

# Rohan Matta
## Composite Pattern
Implementation:
- This pattern is used to manage posts and social media accounts
### Classes Involved
- Post, SocialMediaAccount, PostComponent
### Purpose
- Simplifies the process of managing multiple posts and accounts by allowing them to be more flexible and scalable
## Wizard Pattern
Implementation:
- This pattern is used to guide users through a series of steps to complete a task
### Classes Involved
- ShareProgressWizardPattern.java
- ShareProgressWizardPattern.form
### Purpose
- Simplifies the process of sharing progress by breaking it down into smaller, manageable steps