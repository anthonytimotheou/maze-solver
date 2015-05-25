package com.anthonytimotheou.solvestrategy;

import com.anthonytimotheou.model.Maze;
import com.anthonytimotheou.model.MazeCoordinate;
import com.anthonytimotheou.model.MazeTerrain;
import com.anthonytimotheou.move.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Recursive maze solving strategy. Solves the maze by systematically attempting each allowable move
 * choosing the first move to test based on the euclidean distance to the end point.
 */
public class RecursiveMazeStrategy implements MazeStrategy {
  Maze mMaze;

  /** 2 dimensional array of whether a cell has been visited */
  boolean[][] mAlreadyVisited;

  /** List of maze path that solves starting point to end point */
  List<MazeCoordinate> mCorrectPath = new ArrayList<>();

  @Override
  public List<MazeCoordinate> solveMaze(Maze pMaze) {
    // 2 dimensional array of the correct path of the maze
    mMaze = pMaze;

    // 2 dimensional array of already visited maze positions
    mAlreadyVisited = new boolean[pMaze.getMazeHeight()][pMaze.getMazeWidth()];

    // call recursive solve
    recursiveSolve(pMaze.getStartingPoint().getX(), pMaze.getStartingPoint().getY());

    return mCorrectPath;
  }

  private boolean recursiveSolve(int pX, int pY) {
    // If the end is reached exit
    if (pX == mMaze.getEndPoint().getX() && pY == mMaze.getEndPoint().getY()) {
      return true;
    }

    // If this co ordinate is a wall or has already been visited then do nothing
    if (mMaze.getMazeTerrain().get(pY).get(pX) == MazeTerrain.WALL || mAlreadyVisited[pY][pX]) {
      return false;
    }

    // Set was here
    mAlreadyVisited[pY][pX] = true;

    // Construct the next move list on the fly
    List<Move> lMoveList = new ArrayList<>();
    lMoveList.add(new LeftMove(pX, pY, mMaze));
    lMoveList.add(new RightMove(pX, pY, mMaze));
    lMoveList.add(new TopMove(pX, pY, mMaze));
    lMoveList.add(new BottomMove(pX, pY, mMaze));

    // Sort the order of move choices based on euclidean distance to the end point
    Collections.sort(lMoveList, new EuclideanDistanceMoveComparator());

    // Loop through each method testing the condition and recursively calling if necessary
    for (Move lMove : lMoveList) {
      if (lMove.moveCondition()) {
        if (recursiveSolve(lMove.recursiveXChange(), lMove.recursiveYChange())) {
          mCorrectPath.add(new MazeCoordinate(pX, pY));
          return true;
        }
      }
    }

    return false;
  }

}
