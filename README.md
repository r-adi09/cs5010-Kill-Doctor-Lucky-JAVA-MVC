# CS 5010 Semester Project

This repo represents the coursework for CS 5010, the Fall 2022 Edition!

**Name:** Rajeshwari Adi

**Email:** adi.r@northeastern.edu

**Preferred Name:** Raji



### About/Overview

This Project deals with developing a board game that is loosely inspired by kill doctor lucky. In this milestone, I will be developing the view for the model and controller which was already developed in the previous milestones. I have made significant changes to the controller too. With this milestone, I have fully implemented the project using MVC principles.


### List of Features

Specify total number of players to be added at the start of the game.
Adds a human player at the space of their choice.
Adds a computer player at first room(Armory).
Creates a image of the world map in .png format in res folder.
Move the current player to a neighbor room. This counts as a turn.
Display information of the player including where they are in the world and what items they are carrying.
Display information of a space including including the items, players in the room, neighbors of the room and whether pet is present in the current room.
The current player is able to look around the space that they are currently in.Player would know where they were (the name of the space), who was in the room with the player (the other players), what items were laying around the space, as well as information about other spaces that you could see from there.Player would be able to see into neighboring spaces to be able to identify what space it was as well as what players and items were in the neighboring space. This counts as a turn.
Attacking the target. If an attack is seen by another player (human or computer), it is automatically stopped and no damage is done. Unseen attacks are always successful in which case the appropriate number of hit points (determined by the item used in the attempt) is removed from the target character. This counts as a turn.
The current player is able to pick an item which is present in the current space. This counts as a turn.
Move the pet around the world and this counts as a turn.
Move the target to another space in the world following the order of the rooms in the world specification after each turn.
Hiding visibility of space to another player, if pet occupies that space.
After each turn, pet moves to another space in the world following the order of the rooms in the world specification. They move according to DFS path traversal.
Provide clues to the player at the start of their turn, which includes where the player is in the world, items the player is carrying and its damage power, target location in the world and if pet is present in the current players room.



### How to Run

To Run Jar File: java -jar jarFileName args; (java -jar MilesStone4.jar res/mansion.txt 5) //5 is total number of turns



### How to Use the Program

Once the driver class is run, a Graphical user interface view is displayed and guides the user on how to play the game.
A call is made to driver class which gives control to the controller. Controller executes the necessary model commands based on user input. For example, if user wants to add a human player, he enters the respective command for that and enter inputs to add a player.



### Example Runs

res/ExampleRunComputerAttack.txt = a computer-controlled player making an attempt on the target character's life(turns = 5)
res/ExampleRunComputerWin.txt = a computer-controlled player winning the game by killing the target character(turns = 100)
res/ExampleRunHumanAttack.txt = a human-player making an attempt on the target character's life(turns = 5)
res/ExampleRunHumanWin.txt = a human-player winning the game by killing the target character(turns = 5)
res/ExampleRunMovePetDFS.txt = if you implement the extra credit be sure that you include evidence of this in your example run(turns = 8)
res/ExampleRunNoWin.txt = the target character escaping with his life and the game ending when there is one computer player(turns = 5)
res/ExampleRunPetInNeighbor.txt = the target character's pet effect on the visibility of a space from neighboring spaces(turns = 5)
res/ExampleRunPetMove.txt = the player moving the target character's pet(turns=5)
res/ExampleRun.txt = Example run for milestone 1 and 2.


### Design/Model Changes

Milestone-4 I have modified a few methods in the model class and made significant changes to the controller which was being used previously.

### Assumptions

Milestone-4 Computer player is always added to Room Armory in the beginning. Players can choose the item limit that they want. Maximum items a player can choose is 10.



### Limitations

I implemented all the requirements mentioned in milestone-4.
There are no limitations in this project.



### Citations

[1] GeeksforGeeks. 2022. Depth First Search or DFS for a Graph - GeeksforGeeks. [online] Available at: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/ [Accessed 1 April 2022].

[2] StackOverflow. 2022. Remove blank space in image JAVA - StackOverflow. [online] Available at: https://stackoverflow.com/questions/36811382/remove-blank-space-in-image-java [Accessed 24 April 2022].
