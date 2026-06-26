# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
Name: Pamela Kristy Aroyo
Student ID: 5026251055
Class: E


## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing. The player competes against the computer on a 3x3 board. The application requires login before playing, records game statistics to a MySQL database, and displays the Top 5 highest-scoring players.


## Features
- Login using username and password stored in database
- Play Tic-Tac-Toe against the computer using Swing GUI
- Record wins, losses, draws, and score after each game
- Display personal statistics fetched from database
- Display Top 5 scorers using JTable


## Database
Database used: MySQL


## How to Run
1. Create the database.
2. Import schema.sql.
3. Open the Java project.
4. Add JDBC driver.
5. Configure DatabaseManager.java.
6. Run Main.java.

   
## Class Explanation
Main: Entry point of the program. Opens the Login window when the application starts.

DatabaseManager: Handles JDBC connection to the MySQL database. Provides a getConnection() method used by all database operations.

Player: Model class that stores player data: id, username, wins, losses, draws, and score. Contains only a constructor and getters.

PlayerService: Handles all database operations related to players: login verification, updating statistics after each game, fetching a player by id, and retrieving the Top 5 scorers.

GameLogic: Contains all game rules: move validation, winner checking across 8 patterns, draw detection, and random computer move selection.

LoginFrame: Swing window for username and password input. Checks credentials against the database and opens the Main Menu on success.

MainMenuFrame: Swing window displaying the main menu after login. Navigates to Game, Statistics, Top 5 Scorers, or exits the program.

GameFrame: Swing window for playing the game. Connects the 3x3 button board to GameLogic, handles player and computer turns, and saves the result to the database when the game ends.

StatisticsFrame:Swing window that displays the current player's personal statistics. Fetches the latest data from the database every time it is opened.

TopScorersFrame:Swing window that displays the Top 5 highest-scoring players using JTable. Data is retrieved directly from the database.


## Screenshots
Login: 
<img width="215" height="109" alt="image" src="https://github.com/user-attachments/assets/808d9b19-de3c-4219-93f4-0e13239b5d0a" />

Main menu:
<img width="213" height="159" alt="image" src="https://github.com/user-attachments/assets/94bb019a-7392-47bc-8881-507f4f2dd262" />

Tic Tac Toe Game:
<img width="290" height="345" alt="image" src="https://github.com/user-attachments/assets/860ba32d-4b49-438f-a232-819cfa67dd6b" />

User statistic:
<img width="212" height="176" alt="image" src="https://github.com/user-attachments/assets/863779a0-559d-4152-9c53-6d16b24bfc8c" />

Top 5 scorer:
<img width="362" height="178" alt="image" src="https://github.com/user-attachments/assets/9d5004e3-4e9f-4674-a16d-20be24325752" />


## Video Link
YouTube: https://youtu.be/g4UWnZfsxR4 


