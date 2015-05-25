package com.anthonytimotheou;

import com.anthonytimotheou.ex.MazeException;
import com.anthonytimotheou.model.Maze;
import com.anthonytimotheou.model.MazeCoordinate;
import com.anthonytimotheou.solvestrategy.MazeStrategy;
import com.anthonytimotheou.solvestrategy.RecursiveMazeStrategy;

import java.io.IOException;
import java.util.List;

/**
 * The initial starting point of the program.
 */
public class Main {

  /**
   * Main method to execute maze solver.
   * @param args array of arguments given which is currently just the maze input file name
   * @throws IOException exception from handling files
   * @throws MazeException Maze exception used here for validating arguments given
   */
    public static void main(String[] args) throws IOException, MazeException {
      // Check correct number of arguments is supplied
      if (args.length != 1) {
        throw new MazeException("An incorrect number of arguments was supplied to MazeSolver. Length is " + args.length);
      }

      // Construct required variables
      String lMazeFileName = args[0];

      // Check maze file name is not null
      if (lMazeFileName == null || lMazeFileName.equals("")) {
        throw new MazeException("Supplied Maze filename was empty or null.");
      }

      // Read maze from input file
      Maze lMaze = Maze.createMaze(lMazeFileName);

      // Solve maze using specified strategy
      MazeStrategy lMazeSolutionStrategy = new RecursiveMazeStrategy();
      List<MazeCoordinate> lMazePath = lMazeSolutionStrategy.solveMaze(lMaze);

      // Output maze to standard out
      System.out.print(lMaze.outputMazeToString(lMazePath));
    }
}