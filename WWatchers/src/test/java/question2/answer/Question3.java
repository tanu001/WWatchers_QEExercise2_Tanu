package com.QEExecise2;

import java.util.Arrays;
import java.util.Random;

public class Question3 {
	public static void main(String[] args) {
	 /*
	  * Generate 500 random numbers and create a method 
	  * to print the nth smallest number in a programming language of your choice.
     */
	int start = 100;
    int end = 1001;
    int counter = 500;

    int smallest;
    int greatest;
    int randomInt ;

    int numbers [] = new int[counter];
    Random random = new Random(); 

    randomInt = random.nextInt(end-start) + start;
    numbers [0] = randomInt;

    smallest = randomInt;
    greatest = randomInt;



    for(int i=1;i<counter;i++) {

        numbers[i] = random.nextInt(end-start) + start;

        smallest = Math.min(smallest,numbers[i]);
        greatest = Math.max(greatest,numbers[i]);

  

    }
    System.out.println("Random numbers: " + Arrays.toString(numbers) + "\n\n");
   // System.out.println( "th Greatest : " + greatest + "\n");
    System.out.println( "th Smallest : " + smallest + "\n");

}
}
