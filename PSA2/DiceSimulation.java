//package com.gradescope.psa3part2;
// The Line above is for the autograder on gradescope.
// You should keep it commented out until you are ready to submit.
// Just before you submit, uncomment the line (by removing the //)
// and save the file, but do not recompile it.
// If you need to make changes to your code and
// run it, add the comment back so Java will ignore this line on your account.
// Every time you resubmit, uncomment it again and save before you upload.

import java.util.Random;

public class DiceSimulation{

	/*
 		TODO : ADD METHOD HEADER
 	*/
	public int getTotal(int numRolls, Random rand){
		int rolls = 0;
	//	int value1 = 0;
		//int value2 = 0;
		int total = 0;
		while (rolls < numRolls){
			int value1 = rand.nextInt(6);
			value1 = value1 + 1;

			int value2 = rand.nextInt(6);
			value2 = value2 + 1;

			System.out.println(value1 + " and " + value2);
			total = value1 + value2;
			total+= total;
			 rolls++;
		}

		return total; // XXX - CHANGE THIS RETURN VALUE TO RETURN THE TOTAL
		           // VALUE OF ALL THE ROLLS - XXX
	}



	/*
 		TODO : ADD METHOD HEADER
 	*/
	public int numRollsNeeded(int target, Random rand){
		// Write your code here
		int sum = 0;
		int rolls = 0;

		while (sum < target){

			int value1 = rand.nextInt(6);
			value1 = value1 + 1;

			System.out.println(value1);

			//rolls++;
			//sum = value1;
			sum = sum + value1;
			rolls++;

		}


		return rolls; // XXX - CHANGE THIS RETURN VALUE TO RETURN THE TOTAL NUMBER
		          //OF ROLLS THAT WERE NEEDED TO MEET OR EXCEED THE SUM - XXX
	}

}
