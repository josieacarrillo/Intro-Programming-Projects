//package com.gradescope.psa1part2;
// The Line above is for the autograder on gradescope.
// You should keep it commented out until you are ready to submit.
// Just before you submit, uncomment the line (by removing the //)
// and save the file, but do not recompile it.
// If you need to make changes to your code and
// run it, add the comment back so Java will ignore this line on your account.
// Every time you resubmit, uncomment it again and save before you upload.

/**
* Class: Part2Warmup
* A warm up problem for part 2, done in part 1, and can be done collaboratively
* You can submit this file for feedback from the autograder during part 2.
* It will not be part of your part 2 grade.
*
* Make sure to include your name, PID, and emails here.
*/
public class Part2Warmup
{
    public static void main(String[] args)
    {


        // Make a new turtle with the default symbol (*)

        ASCIITurtle  myTurtle = new ASCIITurtle();


        myTurtle.setSymbol('-');
        myTurtle.draw(5);

        myTurtle.newline();

        myTurtle.setSymbol('*');  // enclose characters in single quotes
        myTurtle.draw(1);
        myTurtle.makeSpace(3);
        myTurtle.draw(1);
        myTurtle.newline();
        myTurtle.draw(1);
        myTurtle.makeSpace(3);
        myTurtle.draw(1);
        myTurtle.newline();
        myTurtle.setSymbol('-');
        myTurtle.draw(5);
    }

}
