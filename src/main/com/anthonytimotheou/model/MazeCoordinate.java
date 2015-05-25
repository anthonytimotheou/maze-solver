package com.anthonytimotheou.model;

/**
 * Encapsulates a 2 dimensional co ordinate on the maze as x and y co ordinates.
 */
public class MazeCoordinate {
    private int mXCoordinate;
    private int mYCoordinate;

  /**
   * Construct a maze co ordinate from a String with the format 'Y X' on the
   * co ordinate system.
   * @param pMazeCoordinates
   */
    private MazeCoordinate(String pMazeCoordinates) {
      String[] lPositionArray = pMazeCoordinates.split(Maze.FILE_SEPERATOR_CHARACTER);
      mYCoordinate = Integer.parseInt(lPositionArray[0]);
      mXCoordinate = Integer.parseInt(lPositionArray[1]);
    }

  /**
   * Construct a Maze co ordinate system setting x and y values on construction
   * @param pX width co ordinate
   * @param pY height co ordinate
   */
    public MazeCoordinate(int pX, int pY) {
      mXCoordinate = pX;
      mYCoordinate = pY;
    }

  /**
   * Get height co ordinate
   * @return integer
   */
    public int getY() {
        return mYCoordinate;
    }

  /**
   * Get width co ordinate
   * @return integer
   */
    public int getX() {
        return mXCoordinate;
    }

  /**
   * Method to create a maze co ordinate from a single string line with format 'Y X'.
   * @param pLine Single string line
   * @return
   */
    public static MazeCoordinate createMazeCoordinates(String pLine) {
      MazeCoordinate lMazeCoordinate = new MazeCoordinate(pLine);
      return lMazeCoordinate;
    }
}
