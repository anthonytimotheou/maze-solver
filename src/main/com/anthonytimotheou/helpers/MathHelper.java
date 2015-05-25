package com.anthonytimotheou.helpers;

/**
 * Created by anthony on 25/05/2015.
 */
public class MathHelper {

  public static int calculateEuclideanDistance(int pX1, int pY1, int pX2, int pY2) {
    return (int) Math.sqrt((Math.pow(pX2 - pX1, 2) + Math.pow(pY2 - pY1, 2)));
  }

}
