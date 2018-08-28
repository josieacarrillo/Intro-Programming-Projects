//package com.gradescope.psa6part2;
/* Filename: PSA6Part2.java
* Created by: CSE 8A Staff
* Date: Winter 2018
*/

/*----------- Program Description: ------------
* program description goes here
*
*
*/
public class PSA6Part2
{
    public static void zeroBelow(int[] toModify, int threshold)
    {
      for(int i = 0; i< toModify.length; i++){
        int value = toModify[i];
        if(value < threshold){
          toModify[i] = 0;

        }
      }

    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 6, 3, 7, 8};
        int threshold = 6;
        System.out.print("The original array was: [");
        for (int elem : test) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
        zeroBelow(test, threshold);
        System.out.print("After zeroBelow with threshold 6 it is: [");
        for (int elem : test) {
            System.out.print(elem + " ");
        }
        System.out.println("]");
    }
}
