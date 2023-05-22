This repo represents the coursework for CS 5010, the Fall 2022 Edition!

Name: Sahith Kota

Email: kota.sah@northeastern.edu Preferred Name: Sahith

About/Overview
This Project deals with developing a board game that is loosely inspired by kill doctor lucky. In this milestone, we will be implementing the actual game play for our game. We will use the model that we created in Milestone 1 and improved in Milestone 2 and the simple text-based controller that we created in Milestone 2.

List of Features
Specify total number of players to be added at the start of the game.
Adds a human player at the space of their choice.
Adds a computer player at first room(Armory).
Creates a image of the world map in .png format in res folder.
Move the current player to a neighbor room. This counts as a turn.
Display information of the player including where they are in the world and what items they are carrying.
Display information of a space including including the items,players in the room, neighbors of the room and whether pet is present in the current room.
The current player is able to look around the space that they are currently in.Player would know where they were (the name of the space), who was in the room with the player (the other players), what items were laying around the space, as well as information about other spaces that you could see from there.Player would be able to see into neighboring spaces to be able to identify what space it was as well as what players and items were in the neighboring space. This counts as a turn.
Attacking the target. If an attack is seen by another player (human or computer), it is automatically stopped and no damage is done. Unseen attacks are always successful in which case the appropriate number of hit points (determined by the item used in the attempt) is removed from the target character. This counts as a turn.
The current player is able to pick an item which is present in the current space. This counts as a turn.
Move the pet around the world and this counts as a turn.
Move the target to another space in the world following the order of the rooms in the world specification after each turn.
Hiding visibility of space to another player, if pet occupies that space.
After each turn, pet moves to another space in the world following the order of the rooms in the world specification. They move according to DFS path traversal.
Provide clues to the player at the start of their turn, which inculdes where the player is in the world, items the player is carrying and its damage power, target location in the world and if pet is present in the current players room.
How to Run
To Run Jar File: java -jar jarFileName args; (java -jar MileStone3.jar res/mansion.txt 5) //5 is total number of turns

# CS 5010 Semester Project

This repo represents the coursework for CS 5010, the Fall 2022 Edition!

**Name:** Sahith Kota

**Email:** kota.sah@northeastern.edu
**Preferred Name:** Sahith



### About/Overview

This Project deals with developing a board game that is loosely inspired by kill doctor lucky. In this milestone, we will be implementing the actual game play for our game. We will use the model that we created in Milestone 1 and improved in Milestone 2 and the simple text-based controller that we created in Milestone 2.

### List of Features

1. Specify total number of players to be added at the start of the game.
2. Adds a human player at the space of their choice.
3. Adds a computer player at first room(Armory).
4. Creates a image of the world map in .png format in res folder.
5. Move the current player to a neighbor room. This counts as a turn.
6. Display information of the player including where they are in the world and what items they are carrying.
7. Display information of a space including including the items,players in the room, neighbors of the room and whether pet is present in the current room.
8. The current player is able to look around the space that they are currently in.Player would know where they were (the name of the space), who was in the room with the player (the other players), what items were laying around the space, as well as information about other spaces that you could see from there.Player would be able to see into neighboring spaces to be able to identify what space it was as well as what players and items were in the neighboring space. This counts as a turn.
9. Attacking the target. If an attack is seen by another player (human or computer), it is automatically stopped and no damage is done. Unseen attacks are always successful in which case the appropriate number of hit points (determined by the item used in the attempt) is removed from the target character. This counts as a turn.
10. The current player is able to pick an item which is present in the current space. This counts as a turn.
11. Move the pet around the world and this counts as a turn.
12. Move the target to another space in the world following the order of the rooms in the world specification after each turn.
13. Hiding visibility of space to another player, if pet occupies that space.
14. After each turn, pet moves to another space in the world following the order of the rooms in the world specification. They move according to DFS path traversal.
15. Provide clues to the player at the start of their turn, which inculdes where the player is in the world, items the player is carrying and its damage power, target location in the world and if pet is present in the current players room.

### How to Run

To Run Jar File:
java -jar jarFileName args;
(java -jar MileStone3.jar res/mansion.txt 5)
//5 is total number of turns

### How to Use the Program

A call is made to driver class which gives control to the controller. Controller executes the necessary model commands based on user input. For example, if user wants to add a human player, he enters the respective command for that and enter inputs to add a player.

### Example Runs

1. res/ExampleRunComputerAttack.txt = a computer-controlled player making an attempt on the target character's life(turns = 5)
2. res/ExampleRunComputerWin.txt = a computer-controlled player winning the game by killing the target character(turns = 100)
3. res/ExampleRunHumanAttack.txt = a human-player making an attempt on the target character's life(turns = 5)
4. res/ExampleRunHumanWin.txt = a human-player winning the game by killing the target character(turns = 5)
5. res/ExampleRunMovePetDFS.txt = if you implement the extra credit be sure that you include evidence of this in your example run(turns = 8)
6. res/ExampleRunNoWin.txt = the target character escaping with his life and the game ending when there is one computer player(turns = 5)
7. res/ExampleRunPetInNeighbor.txt = the target character's pet effect on the visibility of a space from neighboring spaces(turns = 5)
8. res/ExampleRunPetMove.txt = the player moving the target character's pet(turns=5)
9. res/ExampleRun.txt = Example run for milestone 1 and 2.

### Design/Model Changes

Milestone 2
I implemented all the methods from world interface in ConcreteWorld method. I added random interface and random implemetation class to test my computer player.

Milestone 3
I added two new command classes: AttackTarget and MovePet. Added a Pet interface and implemented it in PetImplementation class. I added a new method romveItem in PlayerImplemetation class, as the items is removed from player when he makes an attempt to attack target.

### Assumptions

Milestone 2
Players are added in a specific room and with specific items limit by the user.
Controller asks users to add players at the beginning before starting the game.

Milestone 3
Computer Player is added in first room(Armory).
Provide clues to the player at the start of their turn, which inculdes where the player is in the world, items the player is carrying and its damage power, target location in the world and if pet is present in the current players room.

### Limitations

Implemented all the requirements mentioned in milestone-1, milestone-2 and milestone-3.


### Citations
[1] GeeksforGeeks. 2022. Depth First Search or DFS for a Graph - GeeksforGeeks. [online] Available at: <https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/> [Accessed 1 April 2022].
