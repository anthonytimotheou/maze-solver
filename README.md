# maze-solver
This is a console program that attempts to solve a maze.

Tasks To Do
===========
* Validating input to the program and communications between layers, all input is assumed sanitised already.
* More appropriate exception hierarachy for each layer of abstraction. 
* Unit test each layer. Input, output and algorithm.
* Jar command line, adding arguments for solving and output file name plus tidy up and checking arguments.
* Look at converting 2 dimensional aleady here matrix into List<> with a look up to conserve memory adding scalability at the cost of performance.
* Convert mixed indent to 2 space. Change IntelliJ project settings. 

Busy Developer Technical Explanation
====================================
This program has three layers, input, output and solving. The input is responsible for reading the maze from any format into a Maze abstracted format. The solving layer is then applied using a strategy pattern to use the selected algorithm. The current implemented algorithm is a recursive divide and conquer method that chooses based on the Euclidean distance to the end point. Finally, the output layer is responsible for converting the solved maze into the correct output and outputting this to console. 

Maze file format
================

The input is a maze description file in plain text.  
 1 - denotes walls
 0 - traversable passage way

INPUT:
<HEIGHT> <WIDTH><CR>
<START_I> <START_J><CR>		(i,j) location of the start. (0,0) is upper left and (height-1,width-1) is lower right
<END_I> <END_J><CR>		(i,j) location of the end
<HEIGHT> rows where each row has <WIDTH> {0,1} integers space delimited

OUTPUT:
 the maze with a path from start to end
 walls marked by '#', passages marked by ' ', path marked by 'X', start/end marked by 'S'/'E'

Example file:  
10 10
1 1
8 8
1 1 1 1 1 1 1 1 1 1
1 0 0 0 0 0 0 0 0 1
1 0 1 0 1 1 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 0 1 0 1 1 1
1 0 1 0 0 1 0 1 0 1
1 0 1 0 0 0 0 0 0 1
1 0 1 1 1 0 1 1 1 1
1 0 1 0 0 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1

OUTPUT:
##########
\#SXX     #
\# #X######
\# #XX    #
\# ##X# ###
\# # X# # #
\# # XX   #
\# ###X####
\# #  XXXE#
##########
