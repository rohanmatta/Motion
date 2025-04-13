Rohan Matta, Brett Cunningham, Sydney Black, Ryan Zanoni

## M02-A03 Contributions:
| Name                         | Contribution                                              |
|------------------------------|-----------------------------------------------------------|
| Brett Cunningham (Team Lead) | TrackProgress method stubs and content in testharness     |
| Rohan Matta                  | ShareProgress method stubs and content in testharness     |
| Sydney Black                 | WarmupAndRecovery method stubs and content in testharness |
| Ryan Zanoni                  | Support/MessageTicket method stubs and content in testharness |

NEED TO FILL THIS IN \/

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



Sydney Black: 
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

Brett Cunningham:
## Observer Pattern:
Implementation:
- The Observer Pattern is implemented to provide real-time updates for progress tracking. When progress data is updated, all registered observers are automatically notified.
#### Classes/Interfaces Involved:
- Observer (interface): Located in the Observer package; defines the update method.
- Subject (interface): Located in the Observer package; defines methods to register, remove, and notify observers.
- ProgressSubject (class): Located in the Model.TrackProgress package; manages ProgressData and notifies observers upon updates.
- TrackProgressView (class): Located in the View.TrackProgress package; implements the Observer interface and updates the user interface in response to progress changes.
#### Purpose:
- Ensures that UI elements reflecting fitness progress (e.g., workout trends and dashboards) remain current without requiring manual refreshes.
## Calendar UI:
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