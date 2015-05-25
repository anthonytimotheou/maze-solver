package com.anthonytimotheou.solvestrategy;

import com.anthonytimotheou.model.Maze;
import com.anthonytimotheou.model.MazeCoordinate;

import java.util.List;

/**
 * Maze solution strategy used to find the path from start to end of the maze.
 */
public interface MazeStrategy {

  /**
   * Solve the given maze returning a list of the path from start to finish of the maze.
   * @param pMaze
   * @return
   */
    public List<MazeCoordinate> solveMaze(Maze pMaze);
}
