planetaryjetskis
================

CatMouse Game

Simple 2D game to test out using the MVC architectural pattern, and using Design Patterns from the GOF.

Proposal:

Game Name: CatMouse

- MAIN MENU	
	  Top of window has File menu.
	File menu contains an exit command.
	  Initial screen is black with 8-bit music playing.
	Initial screen has two selections, Start and Highscores.
	Selections are chosen by the up and down arrow keys and enter key.
	Highscores shows a list of high scores, until enter is pressed, then returns to main screen. 
	Highscores list contains made up scores and any player scores.
	After Start button is selected, game prompts user to choose map size.	
	Map size is chosen with arrow keys and enter key.
	After map size is chosen, user is prompted to select difficulty in the same way. 
	After Difficulty is chosen, user presses enter once more to start game.

- GAME
	Player starts as a mouse, on one end of a maze.
	Cheese starts on the other end of the maze.
	Cat(s) start in between the player and the cheese.
	Maze consists of walls, doors, and passable area.
	  Passable area is black. 
	Walls are colored squares. 
	Doors are colored squares with a black mouse hole in them.	
	Top of screen shows the elapsed time in seconds.
	The start of the game will play another 8-bit song. 
	If the game is lost, the game stops and asks if the player would like to replay with a “y/n” selection.
	If player chooses to replay, the game starts from the beginning of game play with same map and difficulty.
	If player chooses not to replay, the game starts back at the main start screen. 
	If the game is won, a victory sound is played and the time display flashes showing the game winning time.
	After a certain amount of time(~5 Seconds), the screen will turn black and prompt the user for a name to put onto the Highscores list. 
	After entering name and pressing enter, the Highscores list will appear. 	
	If win time is lower than the made up scores, the players win will appear on the Highscores list. 
	This is the original Highscores screen from before game start, so pressing enter will bring player back to the main start screen.

- GAMEPLAY

	Cats initially wander. 
	Player moves through the passable area with the 4 arrow keys without moving through walls. 
	When a cat is within a certain radius of the player(size chosen by difficulty), the cat will begin to chase the player. 
	Cat will move slightly faster than the player.
	As cat is chasing, the music changes to something with more vigor, but still 8-bit.
	Player can try to evade cat or move through a door.
	Entering a door will cause the player to disappear and reappear at another door.
	Moving through a door will disable any chasing cats for 5 seconds. 
	If player appears at a door and there is another cat nearby, that cat will chase the player.	
	The ‘Q’ key can be pressed at anytime to quit the game.
	Quitting will forfeit game and return to main menu.

-GAME RULES
	  	Game is won when player reaches the cheese.
	Game is lost if player is eaten by cat.
	Cats cannot move through or use the doors.
	Player can use the doors freely
	Score is the elapsed time, shorter is better.
