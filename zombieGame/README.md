# Project-Z: Zombie Survival Text Adventure 🧟‍♂️

**Project-Z** is a narrative-driven survival game built in Java, where you play as *Jason*, a 31-year-old survivor navigating a post-apocalyptic world overrun by zombies. With limited supplies and time running out, every decision can mean life or death.

---

## 🎮 Gameplay Overview

You start in a battered **Safehouse**, where you must gather supplies and plan your escape. As you progress through the **Street**, **Garage**, **Docks**, and beyond, you’ll face tough choices, manage your backpack inventory, use weapons, and survive encounters with the undead.

### Features
- 🧠 Choice-based storytelling
- 🎒 Backpack system (items, food, weapons)
- ❤️ Health & damage mechanics
- ⚔️ Basic attack system (pistol, machete)
- 📍 Scene transitions (Safehouse → Street → ...)
- 🗺️ Designed for expansion into a full survival journey

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 17+ recommended)
- **Interface:** Text-based CLI (Command Line)
- **IDE:** Compatible with IntelliJ, VS Code, Eclipse

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Syed-OS/Project-Z.git
cd Project-Z
```

### 2. Compile the Code

```bash
javac zombieGame/*.java
```

### 3. Run the Game

```bash
java zombieGame.GameEngine
```

---

## 🗂️ Folder Structure

```
Project-Z/
└── zombieGame/
    ├── GameEngine.java      # Main controller
    ├── Safehouse.java       # First scenario
    ├── Street.java          # Second scenario
    ├── Player.java          # Player data + health/damage
    ├── Backpack.java        # Inventory system
    ├── Scenario.java        # Interface for game scenes
    └── README.md
```

---

## 🔮 Planned Features

- Zombie encounter system with randomized risk  
- More challenging scenarios and longer narrative arcs  
- Save/load system  
- Expanded map (garage, car, docks, sea, island)  
- Sound & animation (for Android version)

---

## 📱 Future Goal

Once the Java CLI version is complete, the goal is to **port Project-Z into an Android game**, turning this survival adventure into a mobile experience.

---

## 👤 Author

**Syed Mahir Ahamed**  
*Game Designer & Java Developer*

---

## 📄 License

This project is licensed under the **MIT License**.  
See the `LICENSE` file for full details.
