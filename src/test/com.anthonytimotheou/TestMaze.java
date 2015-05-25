package com.anthonytimotheou;

import com.anthonytimotheou.model.*;
import com.anthonytimotheou.solvestrategy.MazeStrategy;
import com.anthonytimotheou.solvestrategy.RecursiveMazeStrategy;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * This class just runs through some common Maze types and outputs to console so the user
 * can see if the output looks correct.
 */
public class TestMaze {

  public static void printMaze(Maze pMaze) {
    for (List<MazeTerrain> lCurrentRowTerrain : pMaze.getMazeTerrain()) {
      for (MazeTerrain lCurrentCellTerrain : lCurrentRowTerrain) {
        System.out.print(lCurrentCellTerrain + " ");
      }
      // print new line
      System.out.println();
    }
  }

  @Test
  public void testInputMaze() throws IOException {
    Maze lMaze = Maze.createMaze("res/main/com/anthonytimotheou/input.txt");

    MazeStrategy lMazeSolutionStrategy = new RecursiveMazeStrategy();
    List<MazeCoordinate> lMazePath = lMazeSolutionStrategy.solveMaze(lMaze);

    System.out.println("-- MAZE OUTPUT START --");
    System.out.print(lMaze.outputMazeToString(lMazePath));
    System.out.println("-- MAZE OUTPUT END --\n\n");
  }

  @Test
  public void testSmallMaze() throws IOException {
    Maze lMaze = Maze.createMaze("res/main/com/anthonytimotheou/small.txt");

    MazeStrategy lMazeSolutionStrategy = new RecursiveMazeStrategy();
    List<MazeCoordinate> lMazePath = lMazeSolutionStrategy.solveMaze(lMaze);

    System.out.println("-- MAZE OUTPUT START --");
    System.out.print(lMaze.outputMazeToString(lMazePath));
    System.out.println("-- MAZE OUTPUT END --\n\n");
  }

  @Test
  public void testMediumMaze() throws IOException {
    Maze lMaze = Maze.createMaze("res/main/com/anthonytimotheou/medium_input.txt");

    MazeStrategy lMazeSolutionStrategy = new RecursiveMazeStrategy();
    List<MazeCoordinate> lMazePath = lMazeSolutionStrategy.solveMaze(lMaze);

    System.out.println("-- MAZE OUTPUT START --");
    System.out.print(lMaze.outputMazeToString(lMazePath));
    System.out.println("-- MAZE OUTPUT END --\n\n");
  }

  @Test
  public void testLargeMaze() throws IOException {
    Maze lMaze = Maze.createMaze("res/main/com/anthonytimotheou/large_input.txt");

    MazeStrategy lMazeSolutionStrategy = new RecursiveMazeStrategy();
    List<MazeCoordinate> lMazePath = lMazeSolutionStrategy.solveMaze(lMaze);

    System.out.println("-- MAZE OUTPUT START --");
    System.out.print(lMaze.outputMazeToString(lMazePath));
    System.out.println("-- MAZE OUTPUT END --\n\n");
  }

  @Test
  public void testSparseMaze() throws IOException {
    Maze lMaze = Maze.createMaze("res/main/com/anthonytimotheou/sparse_medium.txt");

    MazeStrategy lMazeSolutionStrategy = new RecursiveMazeStrategy();
    List<MazeCoordinate> lMazePath = lMazeSolutionStrategy.solveMaze(lMaze);

    System.out.println("-- MAZE OUTPUT START --");
    System.out.print(lMaze.outputMazeToString(lMazePath));
    System.out.println("-- MAZE OUTPUT END --\n\n");
  }

}
