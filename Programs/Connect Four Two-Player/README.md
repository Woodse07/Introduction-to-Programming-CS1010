#### Connect Four is a two-player connection game in which the players first choose a disc colour (red or yellow) and then take turns dropping their coloured discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the gird column, i.e., the coloured disc falls down the vertical grid column until it  land on the bottom of the vertical grid or on top of another colour disc.</br>
The objective of the game is to connect four of one's own discs of the same colour next to each other vertically, horizontally, or diagonally before your opponent. The game is a draw if the vertical grid is filled with player discs and no player has won [see Figure 1: Connect Four game play animation] [and see Wikipedia page: Connect Four].</br>
Connect Four game playing animation.</br>
Figure 1: Connect Four game play animation.</br>
Write a Java program which implements the Connect Four two-player connection game. Your program must allow a user to choose the type of each player involved in the Connect Four game, either a Human Player (a user) or a Random AI Player (a computer). A Human Player will be prompted (asked) by the game for their choice of grid column to drop their disc into on each of their turns. A Random AI Player will always select a non-full gird column at random to drop its disc into on each of its turns. Your solution must use the following classes and interface which you have to design and implement:</br>
Connect4Game class</br>
A class whose objects represent an executing Connect Four two-player game application. The class will allow a user to start a new Connect Four game involving two players whose types are chosen by the user. This class consists of a mainline which handles user input. The class creates a grid using the connect4Grid interface and a human player and a computer player using the player abstract class.</br>
Connect4Grid interface</br>
An interface with the following (abstract) methods:</br>
public void emptyGrid();</br>
public String toString();</br>
public boolean isValidColumn(int column);</br>
public boolean isColumnFull(int column);</br>
public void dropPiece(ConnectPlayer player, int column);</br>
public boolean didLastPieceConnect4();</br>
public boolean isGridFull();   </br>
Connect4Grid2DArray class </br>
This class implements the Connect4Grid interface and provides appropriate functionality for each of the methods in the interface</br>
ConnectPlayer abstract class</br>
An abstract class that provides the operations (methods) which any type of Connect Four Player class must override.</br>
C4HumanPlayer class</br>
A class which extends the ConnectPlayer abstract class and whose objects represent a human player (a user) who is involved in a Connect Four game.</br>
C4RandomAIPlayer class</br>
A class which extends the ConnectPlayer abstract class and whose objects represent Random AI Player (a computer) which is involved in a Connect Four game.</br>
