package com.anthonytimotheou.ex;

/**
 * Represents all Maze related exceptions.
 */
public class MazeException extends Exception {
  // TODO AT 25/05/2015 - Make exceptions a hierarchy encapsulating input, output and solving errors
  public MazeException(String message) {
    super(message);
  }
}
