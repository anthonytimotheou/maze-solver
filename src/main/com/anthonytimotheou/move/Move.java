package com.anthonytimotheou.move;

import com.anthonytimotheou.model.Maze;

/**
 * Encapsulates a move at a current point in time on the map. Holds information and behaviour to decide
 * whether to use this move or not.
 */
public abstract class Move {
  protected final Maze mMaze;
  protected final int mX;
  protected final int mY;

  /**
   * Construct the current move using the current x and y position and the Map properties object.
   *
   * @param pX current position on the x axis of the map
   * @param pY current position on the y axis of the map
   * @param pMaze current maze being solved
   */
  public Move(int pX, int pY, Maze pMaze) {
    mX = pX;
    mY = pY;
    mMaze = pMaze;
  }

  /**
   * Specifies the conditions of whether this move is allowed or not.
   * @return
   */
  public abstract boolean moveCondition();

  /**
   * Specifies the change of width change of this move
   * @return
   */
  public abstract int recursiveXChange();

  /**
   * Specifies the height change of this move
   * @return
   */
  public abstract int recursiveYChange();

  /**
   * Specifies the euclidean distance of this move.
   * @return
   */
  public abstract int euclideanDistance();
}