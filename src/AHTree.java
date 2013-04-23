import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class AHTree extends AbstractAHTree{
	public AHNode root; //root node of tree
	public AHNode nyt;
	public Map<Character, AHNode> nodepoint;
	public LinkedList<AHNode> nodeTree;

	public AHTree(){
		nyt = new AHNode();
		nyt.setCharValue(NYT_CHAR);
		nodepoint = new HashMap<Character,AHNode>();
		nodeTree = new LinkedList<AHNode>();
		nodeTree.add(nyt);
		nodepoint.put(nyt.getCharValue(), nyt);

		root = new AHNode();

		root = nyt;
	}

	public void printMap(){
		for (char c : nodepoint.keySet()){
			System.out.println("Char: " +c + " -- " + nodepoint.get(c).getEncoding());
		}
	}
	
	public void printNeat(){
		AHNode temp = null;
		System.out.println("--");
		for (int i = 0; i < nodeTree.size(); i++){
			temp = nodeTree.get(i);
			System.out.println(temp);
			//			System.out.println("LS: " + temp.getLeftSibling() + ", RS: " + temp.getRightSibling());
		}
		System.out.println("--");

	}


	/*
	 * Inserts a new character into the tree.
	 * Should only be used when the input character is not already in the tree.
	 */
	@Override
	public void insert(char c) {
		System.out.println("ADDING " + c + " TO THE TREE");
		if (nodepoint.containsKey(c)){
			updateTree(c); //wrong function called
		}
		else{
			AHNode temp = new AHNode(); //node to add to tree
			AHNode nnyt = new AHNode(); //new nyt to be in the tree

			//change the new node's details
			nyt.setRightChild(temp);
			nyt.setLeftChild(nnyt);
			nyt.setLeftSibling(temp);

			temp.setCharValue(c);
			temp.setLeftSibling(nnyt);
			temp.setParent(nyt);
			temp.setRightSibling(nyt);
			temp.setWeight(1);

			
			
			//change connection's needed details
			nnyt.setParent(nyt);
			nnyt.setRightSibling(temp);
			//			connection.setWeight(1);

			nodepoint.put(c, temp);
			nodeTree.add(temp);
			nodeTree.add(nnyt);

			System.out.println("Changed's right child: " + nyt.getRightChild());
			checkProperty(nyt);

			fixEncodings();

			nyt = nnyt; //set the new nyt to be nyt
			nodepoint.put(NYT_CHAR, nyt);
		}
	}

	public void fixEncodings(){
		AHNode inspect = null;

		//set the encoding for the children of the root
		root.getRightChild().setEncoding("1");
		root.getLeftChild().setEncoding("0");

		for (int i = 3; i < nodeTree.size(); i++){
			inspect = nodeTree.get(i);
			if (inspect == inspect.getParent().getRightChild()){
				StringBuilder temps = new StringBuilder(inspect.getParent().getEncoding());
				temps.append('1'); //add 1 to the encoding of node being added
				inspect.setEncoding(temps.toString());
			}
			else{
				StringBuilder nyts = new StringBuilder(inspect.getParent().getEncoding());
				nyts.append('0'); //add 0 to the encoding of NYT
				inspect.setEncoding(nyts.toString());
			}
		}
	}

	public void checkProperty(AHNode inspect){ //goes up through the list and updates weights
		while (inspect !=null){
			System.out.println("Looking at:");
			//			System.out.println("Char: " + inspect.getCharValue() + ", Weight: " + inspect.getWeight());
			System.out.println(inspect);
			System.out.println("----");
			if (inspect == root){
				inspect.setWeight(inspect.getWeight()+1);
			}
			else if (inspect.getWeight() == inspect.getRightSibling().getWeight() && inspect.getRightSibling() != root){
				AHNode sameweight = findSameWeight(inspect.getWeight());

				System.out.println("Given: " + inspect);
				System.out.println("Comparing to: " + sameweight);

				if (inspect !=sameweight && inspect.getParent()!= sameweight && sameweight.getParent() != inspect){
					System.out.println("Swapping");
					swapLeaf(inspect,sameweight);
					inspect.setWeight(inspect.getWeight()+1);

					System.out.println("PRINTING OUT TREE after 1 swap");
					printNeat();
				}
			}
			else {
				System.out.println("Updating the weight");
				inspect.setWeight(inspect.getWeight()+1);
			}
			inspect = inspect.getParent();
		}
		//		updatePointers();
	}

	public boolean isParent(AHNode nod){
		if (nod.getLeftChild() == null && nod.getRightChild() == null){
			return true;
		}
		else return false;
	}

	public boolean isLeaf(AHNode nod){
		if (nod.getCharValue() == 0){
			return false;
		}
		else return true;
	}

	public void swapLeaf(AHNode add, AHNode old){
		AHNode temp = null;

		System.out.println("ADD is: " + add);
		System.out.println("OLD is: " + old);

		int intadd = nodeTree.indexOf(add); //index of the new node in tree
		int intold = nodeTree.indexOf(old); //index of the old node in tree
		nodeTree.remove(add);
		nodeTree.remove(old);
		nodeTree.add(intadd -1, old);
		nodeTree.add(intold, add);

		//FIX HERE -- SOMETHING WRONG WITH SIBLING PROPERTY

		temp = add.getLeftSibling();

		old.getLeftSibling().setRightSibling(add);
		temp.setRightSibling(old);
		add.setLeftSibling(old.getLeftSibling());		
		old.setLeftSibling(temp);

		temp = add.getRightSibling();

		old.getRightSibling().setLeftSibling(add);
		temp.setLeftSibling(old);
		add.setRightSibling(old.getRightSibling());
		old.setRightSibling(temp);



		AHNode parold = old.getParent(); //parent of old
		AHNode paradd = add.getParent(); //parent of add

		if (parold != paradd){
			if (paradd.getLeftChild() == add){
				paradd.setLeftChild(old);
			}
			else{
				paradd.setRightChild(old);
			}

			if (parold.getLeftChild() == old){
				parold.setLeftChild(add);
			}
			else{
				parold.setRightChild(add);
			}
		}
		else{
			paradd.setLeftChild(old);
			paradd.setRightChild(add);
		}
		add.setParent(parold);
		old.setParent(paradd);
	}

	public AHNode findSameWeight(int nodweight){
		AHNode temp = null;
		//		System.out.println(nodeTree);
		for (int i = 0; i < nodeTree.size(); i++){
			temp = nodeTree.get(i);
			if (temp.getWeight() == nodweight){
				break;
			}
		}
		return temp;
	}

	/*
	 * After updating the weight of the given character, percolates the results up
	 * the tree while making sure to maintain the sibling property.
	 * Should only be used when the input character is already in the tree.
	 */
	@Override
	public void updateTree(char c) {
		System.out.println("UPDATING A CHARACTER");
		AHNode upnode = nodepoint.get(c);
		checkProperty(upnode);
		fixEncodings();
		nodepoint.put(NYT_CHAR, nyt);
	}

	/*
	 * Returns the encoding of a given character.
	 * If the character is not in the tree, returns null.
	 */
	@Override
	public String getEncoding(char c) {
		if(!nodepoint.containsKey(c)){
			return null;
		}
		else{
			return nodepoint.get(c).getEncoding();
		}
	}


	/*
	 * Sets the root of the tree.
	 */
	@Override
	public void setRoot(AHNode newRoot) {
	}



	/*
	 * Returns the root of the tree.
	 */
	@Override
	public AHNode getRoot() {
		return root;
	}

}
