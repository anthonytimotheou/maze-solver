package com.anthonytimotheou.move;

import com.anthonytimotheou.helpers.MathHelper;
import com.anthonytimotheou.model.Maze;

/**
 * Represents a downwards move on the maze map.
 */
public class BottomMove extends Move {

  public BottomMove(int pX, int pY, Maze pMaze) {
    super(pX, pY, pMaze);
  }

  @Override
  public boolean moveCondition() {
    return mY != mMaze.getMazeHeight();
  }

  @Override
  public int recursiveXChange() {
    return mX;
  }

  @Override
  public int recursiveYChange() {
    return mY + 1;
  }

  @Override
  public int euclideanDistance() {
    return MathHelper.calculateEuclideanDistance(mX, mY+1, mMaze.getMazeWidth(), mMaze.getMazeHeight());
  }
}