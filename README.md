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
login: 
password: 

login: 
password:



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