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

      noiseArray[i].setValue(rand.nextInt(32768*2)-32768);

    }
    return sound;
  }

  /**
   *
   */
  public Sound pluck (int soundLength)
  {
    SoundSample[] whitenoise = this.getSamples();
    Sound result = new Sound(soundLength);
    SoundSample[] resultArray = result.getSamples();
    for(int i = 0; i < resultArray.length; i++){
    int indexVal = whitenoise[i].getValue();
    int newVal = (int)(((indexVal+(indexVal+1))/2)*0.996);
    resultArray[i].setValue(newVal);


    }

return result;


  }




  /**
   *
   */
//  public boolean sameSound(Sound s)
} // this } is the end of class Sound, put all new methods before this
