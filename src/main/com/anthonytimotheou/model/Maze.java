package com.anthonytimotheou.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates a Maze behaviour and properties. Including terrain parsing and output. This separates the
 * move solving logic from input and output of the maze as the algorithm can work on an abstract representation.
 */
public class Maze {
  public static final String FILE_SEPERATOR_CHARACTER = " ";

  private static final String WALL_INPUT_CHARACTER = "1";
  private static final String PASSAGE_INPUT_CHARACTER = "0";

  private static final String WALL_OUTPUT_CHARACTER = "#";
  private static final String PASSAGE_OUTPUT_CHARACTER = " ";

  private static final String START_OUTPUT_CHARACTER = "S";
  private static final String END_OUTPUT_CHARACTER = "E";
  private static final String SOLUTION_OUTPUT_CHARACTER = "X";

  private final int mMazeWidth;
  private final int mMazeHeight;

  private final MazeCoordinate mStartingPoint;
  private final MazeCoordinate mEndPoint;

  /** 2 dimensional array of the maze terrain showing walls and passages **/
  private List<List<MazeTerrain>> mMazeTerrain = new ArrayList<>();

  /**
   * Construct a Maze object from a file name.
   * @param pFileName Path to file including file name
   * @throws IOException represents an error to do with reading a file
   */
  private Maze(String pFileName) throws IOException {
    BufferedReader lFileReader = new BufferedReader(new FileReader(pFileName));

    // Read first line for dimensions
    String[] lDimensionsString = lFileReader.readLine().split(FILE_SEPERATOR_CHARACTER);
    mMazeHeight = Integer.parseInt(lDimensionsString[0]);
    mMazeWidth = Integer.parseInt(lDimensionsString[1]);

    // Read second line for starting point
    mStartingPoint = MazeCoordinate.createMazeCoordinates(lFileReader.readLine());

    // Read third line for end point
    mEndPoint = MazeCoordinate.createMazeCoordinates(lFileReader.readLine());

    String lCurrentMazeRow = lFileReader.readLine();

    // Read maze converting it to a maze object to allow different file formats in the future
    while (lCurrentMazeRow != null) {
      List<MazeTerrain> lColumnArray = new ArrayList<>();

      String[] lCurrentMazeColumnArray = lCurrentMazeRow.split(FILE_SEPERATOR_CHARACTER);

      for (String lCurrentCell : lCurrentMazeColumnArray ) {
        // Set the correct terrain value
        if (lCurrentCell.equals(WALL_INPUT_CHARACTER)) {
          lColumnArray.add(MazeTerrain.WALL);
        } else if (lCurrentCell.equals(PASSAGE_INPUT_CHARACTER)) {
          lColumnArray.add(MazeTerrain.PASSAGE);
        }
      }

      // Add the column array to the row array
      mMazeTerrain.add(lColumnArray);

      // Read the next line
      lCurrentMazeRow = lFileReader.readLine();
    }
  }

  /**
   * Output this maze to a String format
   * @param pMazeSolution The list of co-ordinates that is the maze solution
   * @return Maze output solution in a designated format
   */
  public String outputMazeToString(List<MazeCoordinate> pMazeSolution) {
    List<List<String>> lMazeOutput = new ArrayList<>();

    // Two step process to output the maze to it's output format
    for (List<MazeTerrain> lMazeRow : mMazeTerrain) {
      List<String> lOutputMazeRow = new ArrayList<>();
      for (MazeTerrain lMazeCell : lMazeRow) {
        if (lMazeCell == MazeTerrain.PASSAGE) {
          lOutputMazeRow.add(PASSAGE_OUTPUT_CHARACTER);
        } else if (lMazeCell == MazeTerrain.WALL) {
          lOutputMazeRow.add(WALL_OUTPUT_CHARACTER);
        }
      }
      lMazeOutput.add(lOutputMazeRow);
    }

    // Add maze solution
    for (MazeCoordinate lCurrentPath : pMazeSolution) {
      lMazeOutput.get(lCurrentPath.getY()).set(lCurrentPath.getX(), SOLUTION_OUTPUT_CHARACTER);
    }

    // Add starting point
    lMazeOutput.get(mStartingPoint.getY()).set(mStartingPoint.getX(), START_OUTPUT_CHARACTER);

    // Add ending point
    lMazeOutput.get(mEndPoint.getY()).set(mEndPoint.getX(), END_OUTPUT_CHARACTER);

    // Convert array to a string
    StringBuffer lMazeStringOutput = new StringBuffer();
    for (List<String> lCurrentRowTerrain : lMazeOutput) {
      for (String lCurrentCellTerrain : lCurrentRowTerrain) {
        lMazeStringOutput.append(lCurrentCellTerrain);
      }
      lMazeStringOutput.append("\n");
    }

    return lMazeStringOutput.toString();
  }

  /**
   * Create a Maze object from a file path including the name.
   * @param pFilename file path including name
   * @return Maze string
   * @throws IOException exception with reading or writing the file.
   */
  public static Maze createMaze(String pFilename) throws IOException {
    Maze lMaze = new Maze(pFilename);
    return lMaze;
  }

  /**
   * Get starting co-ordinate position on a two d plane starting with (0,0)
   * @return Coordinate object
   */
  public MazeCoordinate getStartingPoint() {
    return mStartingPoint;
  }

  /**
   * Get end co-ordinate position on a two d plane starting with (0,0)
   * @return Coordinate object
   */
  public MazeCoordinate getEndPoint() {
    return mEndPoint;
  }

  /**
   * Get 2 dimensional array of the maze layout
   * @return 2 dimensional array of maze terrain
   */
  public List<List<MazeTerrain>> getMazeTerrain() {
    return mMazeTerrain;
  }

  /**
   * Get the maze height as an integer.
   * @return height of the maze
   */
  public int getMazeHeight() {
    return mMazeHeight;
  }

  /**
   * Get maze width as an integer.
   * @return width of the maze
   */
  public int getMazeWidth() {
    return mMazeWidth;
  }
}
