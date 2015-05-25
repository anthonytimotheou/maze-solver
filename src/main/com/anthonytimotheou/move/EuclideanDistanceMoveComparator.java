package com.anthonytimotheou.move;

import java.util.Comparator;

/**
 * Move comparator based on the distance to the end point so that the shortest
 * allowable move is chosen.
 */
public class EuclideanDistanceMoveComparator implements Comparator<Move> {

  @Override
  public int compare(Move o1, Move o2) {
    if (o1.euclideanDistance() == o2.euclideanDistance()) {
      return 0; // both objects are equal
    } else if (o1.euclideanDistance() > o2.euclideanDistance()){
      return 1; // first object is greater then second
    } else {
      return -1; // second object is greater than first
    }
  }
}
