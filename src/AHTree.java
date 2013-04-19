import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AHTree extends AbstractAHTree{
	public AHNode root; //root node of tree
	public ArrayList<Character> existchar;
	public AHNode nyt;
	public Map<Character, AHNode> nodeTree;
	
	public AHTree(){
		nyt = new AHNode();
		nodeTree = new HashMap<Character,AHNode>();
		existchar = new ArrayList<Character>();
		root = new AHNode();
		
		setRoot(nyt);
	}
	
	
	/*
	 * Inserts a new character into the tree.
	 * Should only be used when the input character is not already in the tree.
	 */
	@Override
	public void insert(char c) {
		AHNode temp = new AHNode();
		AHNode connection = new AHNode();
		connection.set
		temp.setCharValue(c);
		temp.setLeftSibling(nyt)
		temp.setParent(parent)
		
		
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
		if (existchar.contains(c)){
			return
		}
		else{ //character has not been added to the tree yet
			return null;
		}
	}

	
	/*
	 * Sets the root of the tree.
	 */
	@Override
	public void setRoot(AHNode newRoot) {
		root = newRoot;
	}


  
   	/*
   	 * Returns the root of the tree.
   	 */
	@Override
	public AHNode getRoot() {
		return root;
	}

}
