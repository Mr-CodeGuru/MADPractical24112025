# MAD Practical 24/11/2025 - Android App

## Project Overview
This is a simple Android application developed for Mobile Application Development (MAD) practical exercise. The app demonstrates basic Android functionalities including activity navigation, animations, and UI interactions.

## Features

### 🏠 Main Activity Features

The main activity contains three interactive buttons, each with distinct functionality:

#### 1. **Open Second Activity Button**
- **Function**: Opens a new activity (SecondActivity)
- **Data Transfer**: Passes text from the main activity's TextView to the second activity
- **Implementation**: Uses Intent with extras to transfer data between activities
```kotlin
btnOpenSecondActivity.setOnClickListener {
    val intent = Intent(this, SecondActivity::class.java)
    intent.putExtra("TEXT_FROM_MAIN", textView.text.toString())
    startActivity(intent)
}
```

#### 2. **Start Animation Button**
- **Function**: Performs a smooth tween animation on the UVPCE logo image
- **Animation Effects**: 
  - Zoom In (1.2 seconds)
  - Rotate 360 degrees (2 seconds)
  - Zoom Out (1.2 seconds)
- **Implementation**: Uses custom XML animation resource
```kotlin
btnAnimation.setOnClickListener {
    val animation = AnimationUtils.loadAnimation(this, R.anim.tween_anim)
    animationImage.startAnimation(animation)
}
```

#### 3. **Change Background Color Button**
- **Function**: Opens a color selection menu
- **Color Options**: Red, Blue, Green
- **Implementation**: Uses AlertDialog with color selection
```kotlin
btnColorMenu.setOnClickListener {
    showColorMenu()
}

private fun showColorMenu() {
    val colors = arrayOf("Red", "Blue", "Green")
    
    AlertDialog.Builder(this)
        .setTitle("Choose Background Color")
        .setItems(colors) { _, which ->
            when (which) {
                0 -> mainLayout.setBackgroundColor(Color.RED)
                1 -> mainLayout.setBackgroundColor(Color.BLUE)
                2 -> mainLayout.setBackgroundColor(Color.GREEN)
            }
        }
        .setNegativeButton("Cancel", null)
        .show()
}
```

### 📱 Second Activity Features

#### **Text Display**
- **Function**: Receives and displays text passed from MainActivity
- **UI**: Shows received text in a styled TextView
- **Navigation**: Includes a "Go Back" button to return to MainActivity

```kotlin
val receivedText = intent.getStringExtra("TEXT_FROM_MAIN")
if (receivedText != null) {
    receivedTextView.text = receivedText
}

btnBack.setOnClickListener {
    finish()
}
```

## 🎨 Animation Details

### Tween Animation (tween_anim.xml)
The animation consists of three sequential phases:

1. **Zoom In Phase**
   - Duration: 1200ms
   - Scale: 1.0 → 1.8
   - Interpolator: Decelerate (smooth start)

2. **Rotation Phase**
   - Duration: 2000ms
   - Rotation: 0° → 360°
   - Interpolator: Linear (constant speed)
   - Start Offset: 800ms

3. **Zoom Out Phase**
   - Duration: 1200ms
   - Scale: 1.8 → 1.0
   - Interpolator: Accelerate (smooth finish)
   - Start Offset: 2400ms

## 📁 Project Structure

```
app/src/main/
├── java/com/exam/madpractical24112025/
│   ├── MainActivity.kt          # Main activity with three buttons
│   └── SecondActivity.kt        # Second activity for text display
├── res/
│   ├── layout/
│   │   ├── activity_main.xml    # Main activity layout
│   │   └── activity_second.xml  # Second activity layout
│   ├── anim/
│   │   └── tween_anim.xml       # Custom animation definition
│   └── drawable/
│       └── uvpce_logo.png       # Logo image for animation
└── AndroidManifest.xml          # App configuration
```

## 🛠️ Technical Implementation

### Dependencies
- Android SDK
- Kotlin
- AppCompat Library

### Key Components
- **Activities**: MainActivity, SecondActivity
- **Layouts**: LinearLayout with centered elements
- **Animations**: XML-based tween animations
- **Dialogs**: AlertDialog for color selection
- **Intents**: For activity navigation and data passing

## 🎯 Learning Objectives
This project demonstrates:
- ✅ Activity lifecycle and navigation
- ✅ Intent usage for data passing
- ✅ XML-based animations
- ✅ User interface interactions
- ✅ Dialog implementation
- ✅ Event handling

## 📸 App Screenshots

| Main Screen | Animation Demo | Color Menu | Second Activity |
|-------------|----------------|------------|-----------------|
| ![Main Screen](image1.png) | ![Animation](image2.png) | ![Color Menu](image3.png) | ![Second Activity](image4.png) |
| Shows the main interface with three functional buttons | Demonstrates the smooth tween animation on UVPCE logo | Color selection dialog with three options | Second activity displaying passed text |

---

**Developer**: [Your Name]  
**Course**: Mobile Application Development  
**Date**: 24/11/2025  
**Institution**: UVPCE