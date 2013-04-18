
/**
 * @author CIS121 staff
 * Decoder for Adaptive Huffman Compression
 */
public class Decode {

  /**
   * decode takes in a string which represents an adaptive Huffman encoding of some input text (ex: "011101010"), 
   * and an empty AbstractAHTree, and outputs the original text String
   * @param encoding    string version of bit encoding of text
   * @param tree        empty AbstractAHTree
   * @return            return the original string from the decoding!
   */
  public static String decode(String encoding, AbstractAHTree tree) {
	  // TODO
	  return null;
  }


  /**
   * convertASCIItoChar takes in a string of length 8 representing a binary number in the range 0-255 
   * and outputs the char represented by that ASCII value
   * @param bin         string representing 8 bits (ex: "00101110" = 46)
   * @return            return the char value of the input number (ex: "00101110" = '.')
   */
  public static char convertASCIIToChar(String bin){
    int value = Integer.parseInt(bin, 2);
    return ((char) value);
  }
	

}
