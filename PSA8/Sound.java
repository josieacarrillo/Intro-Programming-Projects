//package com.gradescope.psa8part2;
/* Filename: Sound.java
* Created by: CSE 8A Staff
* Date: Fall 2018
*/
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Sound extends SimpleSound
{

  /////////////// consructors ////////////////////////////////////

  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }

  /**
   * Constructor that takes the number of samples in
   * the sound
   * @param numSamples the number of samples desired
   */
  public Sound (int numSamples)
  {
    // let the parent class handle this
    super(numSamples);
  }

  /**
   * Constructor that takes the number of samples that this
   * sound will have and the sample rate
   * @param numSamples the number of samples desired
   * @param sampleRate the number of samples per second
   */
  public Sound (int numSamples, int sampleRate)
  {
    // let the parent class handle this
    super(numSamples,sampleRate);
  }

  /**
   * Constructor that takes a sound to copy
   */
  public Sound (Sound copySound)
  {
    // let the parent class handle this
    super(copySound);
  }

  ////////////////// methods ////////////////////////////////////

  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();

    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;

    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();

    return output;
  }


  public void concatenateSound(Sound firstSound, Sound secondSound)
  {
    SoundSample[] firstSoundArray = firstSound.getSamples();
    SoundSample[] secondSoundArray = secondSound.getSamples();


    int soundLength = (firstSoundArray.length + secondSoundArray.length);
      //System.out.println("firstSoundArray.length="+firstSoundArray.length);

    SoundSample[] newSoundArray = this.getSamples();
    //grabs each value of first array into new array
    for (int i = 0; i < firstSoundArray.length; i++){
      int first = firstSoundArray[i].getValue();
      newSoundArray[i].setValue(first);
    //  System.out.println("firstSoundArray[0]="+firstSoundArray[0]);
    //  System.out.println("newSoundArray[i]="+newSoundArray[i]);

    }
    //starts off where first array ends, places second array directly after
    for( int i = 0; i < secondSoundArray.length; i++){
    int second = secondSoundArray[i].getValue();
    //System.out.println("secondSoundArray[i]="+secondSoundArray[i]);

     newSoundArray[firstSoundArray.length + i].setValue(second);
      //System.out.println("newSoundArray[firstSoundArray.length + i]="+newSoundArray[firstSoundArray.length + i]);
//System.out.println("newNewSoundArray[i]="+newSoundArray[i]);
    }




}


  public void concatenateSound(Sound firstSound, Sound secondSound, int switchPoint)
  {
    SoundSample[] firstSoundArray = firstSound.getSamples();
    SoundSample[] secondSoundArray = secondSound.getSamples();

    int soundLength = firstSoundArray.length + secondSoundArray.length;

    SoundSample[] newSoundArray = this.getSamples();

    switchPoint = Math.min(firstSoundArray.length,switchPoint);
//if switchpoint is pos, place both arrays and their values into new array and sets extra values to 0
    if(switchPoint > 0){
    for(int i = 0; i < switchPoint && i < newSoundArray.length && i < firstSoundArray.length; i++){
      int first = firstSoundArray[i].getValue();
    newSoundArray[i].setValue(first);
    //System.out.println("newSoundArray[i]="+newSoundArray[i]);
  }


    for(int i = 0; i < secondSoundArray.length && switchPoint + i < newSoundArray.length; i++){
      int second = secondSoundArray[i].getValue();
      newSoundArray[switchPoint + i].setValue(second);
    }
    for(int i = switchPoint+secondSoundArray.length; i < newSoundArray.length; i++){
    newSoundArray[i].setValue(0);
}
// if switchPoint is negative, copies only second array into new array and sets extra values in new array to 0


  if(switchPoint <=0){
    for(int i = 0; i < secondSoundArray.length; i++){
    int  second = secondSoundArray[i].getValue();
      newSoundArray[i].setValue(second);
      System.out.println("newSoundArray[i]="+ newSoundArray[i]);
    }
    for(int i = secondSoundArray.length; i < newSoundArray.length; i++){
      newSoundArray[i].setValue(0);
     }
   }
 }
}

} // this } is the end of class Sound, put all new methods before this
