# FetchItemsApp

## Overview

**FetchItemsApp** is an Android application that demonstrates how to fetch and display a list of items grouped by their `listId`. The app uses the MVVM architecture with LiveData for data observation, providing a responsive UI.


## Installation

To clone and run the project, follow these steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/ZoraizDev/fetchItems.git
Open the project in Android Studio.

Sync the Gradle files to ensure all dependencies are downloaded.

Run the app on an emulator or physical device.

## Project Structure
The project is organized as follows:



### Directory Details

- **fetchitemsapp/**: Contains all Java/Kotlin code for the application.
  - **data/**: This package holds the data models and repositories, which handle data operations and data management.
    - **model/**: Contains the data models used throughout the app.
    - **repository/**: Contains repository classes that manage data operations and provide a clean API for data access.
  - **ui/**: This package contains all UI-related components.
    - **adapter/**: Contains adapters for RecyclerViews, managing how data is displayed in lists.
    - **viewmodel/**: Contains ViewModels that handle UI logic and data preparation for the views.
  - **domain/**: This layer holds domain classes, representing the business logic and rules of the application.
  - **main/**: Contains the main activity and other related classes.
- **res/**: Contains various resources such as layouts, drawables, and other assets used in the app.
- **AndroidManifest.xml**: The manifest file that provides essential information about the app to the Android build system, the Android operating system, and Google Play.
- **build.gradle**: These files define the build configuration at the module and project levels.
- **proguard-rules.pro**: Configuration for ProGuard, which optimizes and obfuscates the code.
- **settings.gradle**: Defines the modules included in the project.


## Directory Breakdown
data/: Contains model classes and repository classes responsible for fetching data from a data source.

model/: Data classes representing the entities used in the application.
repository/: Classes that handle data operations and provide a clean API to the ViewModel.
ui/: Contains UI components and adapters for displaying data.

adapter/: Adapters for the RecyclerView and other UI components.
viewmodel/: ViewModel classes responsible for preparing and managing UI-related data.
domain/: Contains domain-related logic, if applicable.

main/: The entry point of the application, including the MainActivity.
