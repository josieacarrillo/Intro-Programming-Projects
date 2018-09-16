/* Filename: Sound.java
* Created by: CSE 8A Staff
* Date: Winter 2018
*/
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */

import java.util.Random;

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

  /**
   * Method to call student's implementation of whitenoise
   * @return a sound object of whitenoise
   */


  /**
   *
   */
  public static Sound whitenoise(int frequency, Random rand)

  {
  //  return whitenoise(frequency, new Random());
    int soundLength = (int)Math.ceil(22050.0/frequency);
    Sound sound = new Sound(soundLength);
    SoundSample[] noiseArray = sound.getSamples();
    for(int i = 0; i < noiseArray.length; i++){
    //  Random rand = new Random();
    int random = (rand.nextInt(32768*2)-32768);

      noiseArray[i].setValue(random);
      System.out.println(random);

    }
    return sound;
  }

  /**
   *
   */

   private static void shiftleft (SoundSample[] noiseArray)
   {


    int temp = noiseArray[0].getValue();

     for(int i = 0; i+1 < noiseArray.length; i++){

      int rightVal = noiseArray[i+1].getValue();
     noiseArray[i].setValue(rightVal);


}
 noiseArray[noiseArray.length-1].setValue(temp);
   }


  public Sound pluck (int soundLength)
  {
    SoundSample[] whitenoise = this.getSamples();
    Sound result = new Sound(soundLength);
    SoundSample[] resultArray = result.getSamples();

    //System.out.println("resultArray length:"+ resultArray.length);

    for(int i = 0; i < whitenoise.length; i++){

    //calculate and set new value in the last element of resultArray
      int firstVal = whitenoise[0].getValue();
      int secondVal = whitenoise[1].getValue();
      int finalVal= (int)(((firstVal+(secondVal))/2.0)*0.996);

      resultArray[resultArray.length-1].setValue(finalVal);

      //shift whitenoise array left
      Sound.shiftleft(whitenoise);
    //  System.out.println("whitenoise[0]:"+ whitenoise[0]);
      //  System.out.println("whitenoise[1]:"+ whitenoise[1]);

      //shift reultArray left
      Sound.shiftleft(resultArray);







    }

return result;


  }

  public static void main (String [] args) {
     Sound sound = Sound.whitenoise(1,new Random());

    sound.pluck(1000).explore();

    //String fileName = FileChooser.pickAFile();
    //Sound newSound = new Sound(fileName);
    //sound.sameSound(newSound);

  }

  public boolean sameSound(Sound s)
{

  SoundSample[] sArray = s.getSamples();
  SoundSample[] sound = this.getSamples();

  if(sound.length == sArray.length){
    for(int i = 0; i < sound.length; i++){
      if(sound[i].getValue() != sArray[i].getValue()){
        return false;
      }

    }
    return true;
  }else{
    return false;

  }





}


} // this } is the end of class Sound, put all new methods before this
