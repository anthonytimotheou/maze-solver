package com.anthonytimotheou.move;

import com.anthonytimotheou.helpers.MathHelper;
import com.anthonytimotheou.model.Maze;

/**
 * Represents a left move on the maze map.
 */
public class LeftMove extends Move {

  public LeftMove(int pX, int pY, Maze pMaze) {
    super(pX, pY, pMaze);
  }

  @Override
  public boolean moveCondition() {
    return mX != 0; // check you have not reached the left wall of the map
  }

  @Override
  public int recursiveXChange() {
    return mX-1; // move one step to the left on the map
  }

  @Override
  public int recursiveYChange() {
    return mY;
  }

  @Override
  public int euclideanDistance() {
    // calculate the idstnace of one move to the left on the map
    return MathHelper.calculateEuclideanDistance(mX-1, mY, mMaze.getMazeWidth(), mMaze.getMazeHeight());
  }
}
