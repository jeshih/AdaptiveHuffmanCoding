import java.util.ArrayList;


public class AHTree extends AbstractAHTree{
	public AHNode root; //root node of tree
	public ArrayList<Character> existchar;
	public AHNode nyt;
	public ArrayList<AHNode> nodeTree;
	
	public AHTree(){
		nyt = new AHNode();
		nodeTree = new ArrayList<AHNode>();
		existchar = new ArrayList<Character>();
		root = new AHNode();
	}
	
	
	/*
	 * Inserts a new character into the tree.
	 * Should only be used when the input character is not already in the tree.
	 */
	@Override
	public void insert(char c) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * After updating the weight of the given character, percolates the results up
	 * the tree while making sure to maintain the sibling property.
	 * Should only be used when the input character is already in the tree.
	 */
	@Override
	public void updateTree(char c) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * Returns the encoding of a given character.
	 * If the character is not in the tree, returns null.
	 */
	@Override
	public String getEncoding(char c) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * Sets the root of the tree.
	 */
	@Override
	public void setRoot(AHNode newRoot) {
		// TODO Auto-generated method stub
		
	}


  
   	/*
   	 * Returns the root of the tree.
   	 */
	@Override
	public AHNode getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

}
