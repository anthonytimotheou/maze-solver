package com.anthonytimotheou.move;

import com.anthonytimotheou.helpers.MathHelper;
import com.anthonytimotheou.model.Maze;

/**
 * Represents a right move on the maze map.
 */
public class RightMove extends Move {

  public RightMove(int pX, int pY, Maze pMaze) {
    super(pX, pY, pMaze);
  }

  @Override
  public boolean moveCondition() {
    return mX != mMaze.getMazeWidth(); // check you have not moved past the right wall of the map
  }

  @Override
  public int recursiveXChange() {
    return mX+1; // move across the width axis by one step
  }

  @Override
  public int recursiveYChange() {
    return mY;
  }

  @Override
  public int euclideanDistance() {
    // calculate distance of a move one step to the right
    return MathHelper.calculateEuclideanDistance(mX + 1, mY, mMaze.getMazeWidth(), mMaze.getMazeHeight());
  }
}