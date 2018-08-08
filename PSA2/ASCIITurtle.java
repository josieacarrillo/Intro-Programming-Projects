//package com.gradescope.psa2part2;
// The Line above is for the autograder on gradescope.
// You should keep it commented out until you are ready to submit.
// Just before you submit, uncomment the line (by removing the //)
// and save the file, but do not recompile it.
// If you need to make changes to your code and
// run it, add the comment back so Java will ignore this line on your account.
// Every time you resubmit, uncomment it again and save before you upload.

/**
* XXX Add your header comment here
*/

/**
* A simple "Turtle" class that draws text "art" to the screen
*/
public class ASCIITurtle
{
    // The current symbol to be drawn
    private char symbol;

    /**
    * Make a new ASCIITurtle with the default symbol *
    */
    public ASCIITurtle()
    {
        symbol = '*';
    }
    /**
    * Make a new ASCIITurtle with the specified symbol
    * @param s The symbol to be drawn
    */
    public ASCIITurtle(char s)
    {
        symbol = s;
    }

    /**
    * Draw numSymbols number of the current symbol
    */
    public void draw(int numSymbols)
    {
        for (int i = 0; i < numSymbols; i++) {
            System.out.print(symbol);
        }
    }

    /**
    *  Move the cursor to the right by numSpaces
    */
    public void makeSpace(int numSpaces)
    {
        for (int i = 0; i < numSpaces; i++) {
            System.out.print(" ");
        }
    }

    /**
    *  Move the cursor to the next line
    */
    public void newline()
    {
        System.out.print("\t\n");
    }

    /**
    * Change the symbol drawn
    * @param newSymbol The new symbol
    */
    public void setSymbol(char newSymbol)
    {
        symbol = newSymbol;
    }

    /////////////////// student-defined methods ///////////////////////

    /*
    * drawCenteredLine - Draws a centered (in a 40-char width field)
    * line of the given length and the given symbol.
    */
    public void drawCenteredLine(int length, char symbolToUse)
    {
        // ADD YOUR CODE HERE.
        // REMEMBER, you must use ONLY calls to other methods in this class.
        // You may NOT directly call System.out.println.

        this.setSymbol('|');
        this.draw(1);
        this.makeSpace(15);

        this.setSymbol(symbolToUse);

        this.draw(length);
        this.makeSpace(15);
        this.setSymbol('|');
        this.draw(1);
        this.newline();

    }

}
