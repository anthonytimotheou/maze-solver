package com.anthonytimotheou.move;

import com.anthonytimotheou.helpers.MathHelper;
import com.anthonytimotheou.model.Maze;

/**
 * Represents a upwards move on the maze map.
 */
public class TopMove extends Move {

  public TopMove(int pX, int pY, Maze pMaze) {
    super(pX, pY, pMaze);
  }

  @Override
  public boolean moveCondition() {
    return mY != 0; // Make sure you can not move upwards when at the top of the map
  }

  @Override
  public int recursiveXChange() {
    return mX;
  }

  @Override
  public int recursiveYChange() {
    return mY - 1; // Move one step upwards on the map
  }

  @Override
  public int euclideanDistance() {
    // Calculate distance of one move upwards
    return MathHelper.calculateEuclideanDistance(mX, mY-1, mMaze.getMazeWidth(), mMaze.getMazeHeight());
  }
}
