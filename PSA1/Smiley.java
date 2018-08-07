//package com.gradescope.psa1part2;
// The Line above is for the autograder on gradescope.
// You should keep it commented out until you are ready to submit.
// Just before you submit, uncomment the line (by removing the //)
// and save the file, but do not recompile it.
// If you need to make changes to your code and
// run it, add the comment back so Java will ignore this line on your account.
// Every time you resubmit, uncomment it again and save before you upload.

/**
* TODO
* Make sure to include your name, PID, and emails here.
*/


public class Smiley
{
    public static void main(String[] args)
    {
        // Make a new turtle with the default symbol (*)
        ASCIITurtle myTurtle = new ASCIITurtle();
//make hair//
myTurtle.makeSpace(3);
myTurtle.setSymbol('|');
myTurtle.draw(3);
myTurtle.newline();
myTurtle.makeSpace(2);
myTurtle.setSymbol('*');
myTurtle.draw(5);
//make eyes//
myTurtle.newline();
myTurtle.draw(1);
myTurtle.makeSpace(1);
myTurtle.setSymbol('x');
myTurtle.draw(1);
myTurtle.makeSpace(3);
myTurtle.draw(1);
myTurtle.makeSpace(1);
myTurtle.setSymbol('*');
myTurtle.draw(1);
//make nose//
myTurtle.newline();
myTurtle.draw(1);
myTurtle.makeSpace(3);
myTurtle.setSymbol('>');
myTurtle.draw(1);
myTurtle.makeSpace(3);
myTurtle.setSymbol('*');
myTurtle.draw(1);
//make smile//
myTurtle.newline();
myTurtle.makeSpace(1);
myTurtle.draw(1);
myTurtle.setSymbol('\\');
myTurtle.draw(1);
myTurtle.setSymbol('_');
myTurtle.draw(3);
myTurtle.setSymbol('/');
myTurtle.draw(1);
myTurtle.setSymbol('*');
myTurtle.draw(1);
//make chin
myTurtle.newline();
myTurtle.makeSpace(3);
myTurtle.draw(3);
myTurtle.makeSpace(3);







        // draw the smiley face as instructed in the PSA instructions.//
    }

}
