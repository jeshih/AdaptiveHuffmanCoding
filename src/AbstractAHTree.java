import java.util.Map;


/**
 * @author CIS121 staff
 *	AHTree class for adaptive Huffman coding
 */
public abstract class AbstractAHTree {
	
	public static char NYT_CHAR = '\0';
	
	/*
	 * Inserts a new character into the tree.
	 * Should only be used when the input character is not already in the tree.
	 */
	public abstract void insert(char c);
	
	/*
	 * After updating the weight of the given character, percolates the results up
	 * the tree while making sure to maintain the sibling property.
	 * Should only be used when the input character is already in the tree.
	 */
	public abstract void updateTree(char c);
	
	
	/*
	 * Returns the encoding of a given character.
	 * If the character is not in the tree, returns null.
	 */
	public abstract String getEncoding(char c);
	
	/*
	 * Returns a String representation of the 8-bit binary ASCII value of the given character. 
	 */
	protected String convertASCIIToBinaryString(char c) {
		return String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
	}
	
	/*
	 * Sets the root of the tree.
	 */
   	public abstract void setRoot(AHNode newRoot);
  
   	/*
   	 * Returns the root of the tree.
   	 */
	public abstract AHNode getRoot();

}
