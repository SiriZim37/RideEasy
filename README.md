# RideEasy

RideEasy is a modern taxi booking Android app built with Kotlin and Jetpack Compose.  
It allows users to easily book rides by selecting their origin and destination on a map, choose a transport type, and view detailed route information with real-time updates.

---

## Features

- Select pickup and drop-off locations via map interface with pinned markers
- Choose from multiple transport types including motorbike taxi, normal taxi, big taxi, and van
- Display the optimal route on the map after selecting transport
- Bottom sheet interface to show transport options and booking details
- Real-time route updates and travel info display
- Chat feature to communicate with driver (planned/in progress)
- Modern UI built with Jetpack Compose for smooth and reactive experience

---

## Tech Stack

- Kotlin
- Jetpack Compose
- Android Architecture Components (ViewModel, State)
- Google Maps SDK for Android
- Kotlin Coroutines for asynchronous operations
- Hilt for Dependency Injection (if applicable)

---


## Project Structure

- `/app` - Main Android app module
- `/ui` - Compose UI components and screens
- `/viewmodel` - ViewModels managing UI state and logic
- `/data` - Data sources and repositories (network, database)
- `/di` - Dependency injection setup (Hilt modules)
- `/navigation` - Navigation components and routes

---

## Getting Started


### Prerequisites

- Android Studio Bumblebee or later
- Android device or emulator running API 21+
- Google Maps API Key (required)


- Reference the API key in your `AndroidManifest.xml` inside the `<application>` tag:

```xml
<meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="${MAPS_API_KEY}" />

### Google Maps API Key Setup

1. Go to [Google Cloud Console](https://console.cloud.google.com/).
2. Create a new project or select your existing project.
3. Enable the **Maps SDK for Android** API.
4. Create an API key and restrict it to Android apps by adding your app’s package name and SHA-1 certificate fingerprint.
5. Copy the generated API key.

### Configure the API Key in Your Project

- Add your API key in the `local.properties` file:

