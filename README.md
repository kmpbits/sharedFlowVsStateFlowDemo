# StateFlow vs SharedFlow in Kotlin Multiplatform (KMP)

This project is a hands-on demo created for my Medium article: **"StateFlow vs SharedFlow: A Racing Analogy in Kotlin Multiplatform"**.

It demonstrates the practical differences between `StateFlow` and `SharedFlow` using a Formula 1 Pit Stop metaphor.

## 🏎️ The Analogy

In this app:
- **StateFlow (`lapCount`)**: Represents the current state of the race. Just like a scoreboard, it always holds the latest lap number. When a new observer joins, they immediately see the current lap.
- **SharedFlow (`pitStopAlert`)**: Represents a one-time event or command. When the team calls "Box, Box!", it's an event sent to the driver. If the driver isn't listening at that exact moment, they might miss the call (depending on replay configuration).

## 🛠️ Project Structure

- **`:shared`**: Contains the core logic.
    - `PitStopViewModel.kt`: The common ViewModel implementation using `StateFlow` and `SharedFlow`.
    - `iosMain`: Contains a `PitStopViewModelWrapper` to make it easier to consume flows from Swift.
- **`:composeApp`**: The Android implementation using Jetpack Compose.
- **`iosApp`**: The iOS implementation using SwiftUI (consuming the shared ViewModel).

## 🚀 Getting Started

### Android
To run the Android app:
```bash
./gradlew :composeApp:assembleDebug
```
Or simply use the **Run** button in Android Studio.

### iOS
1. Open `iosApp/iosApp.xcworkspace` in Xcode.
2. Select your simulator/device and press **Run**.

## 📖 Read the Full Article
For a deep dive into the code and the concepts behind it, check out my article on Medium:
[Link to your Medium article here]

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html).
