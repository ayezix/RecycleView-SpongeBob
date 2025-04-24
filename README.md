# SpongeBob SquarePants Character Viewer

An Android application that displays a list of SpongeBob SquarePants characters using RecyclerView. The app features a search functionality and interactive character cards.

## Features

- Display of 10 main SpongeBob SquarePants characters
- Material Design UI with CardView
- Search functionality to filter characters by name
- Interactive cards with toast messages on click
- Smooth scrolling and efficient list management

## Screenshots

![image](https://github.com/user-attachments/assets/852e9b15-a5a8-4558-9ea5-679455142e2c)

This project was done by Nimrod Aharon, Yehuda Ekoz and Ran Azulay


## Requirements

- Android Studio Arctic Fox or later
- Minimum SDK: 24 (Android 7.0)
- Target SDK: 34 (Android 14)

## Setup Instructions

1. Clone the repository:
```bash
git clone git clone [https://github.com/ayezix/RecycleView-Spongebob-Squarepants](https://github.com/ayezix/RecycleView-SpongeBob).git
```

2. Open the project in Android Studio

3. Add character images to the `app/src/main/res/drawable/` directory with the following names:
- spongebob.png
- patrick_star.png
- squidward.png
- mr_krabs.png
- sandy_cheeks.png
- plankton.png
- gary_snail.png
- mrs_puff.png
- pearl_krabs.png
- larry_lobster.png

4. Build and run the project

## Project Structure

- `MainActivity.java` - Main activity that handles the RecyclerView and search functionality
- `Character.java` - Model class for character data
- `CharacterAdapter.java` - RecyclerView adapter with search implementation
- `activity_main.xml` - Main layout with search bar and RecyclerView
- `item_character.xml` - Layout for individual character items

## Dependencies

```gradle
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.recyclerview:recyclerview:1.3.2'
implementation 'androidx.cardview:cardview:1.0.0'
```



## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request 
