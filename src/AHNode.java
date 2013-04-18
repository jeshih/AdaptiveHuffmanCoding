
/**
 * @author CIS121 staff
 * Node class for Adaptive Huffman Coding compression
 */
public class AHNode implements Comparable<AHNode> {
	
	private int weight;
	private char charValue;
	private String encoding;
	private AHNode parent; //parent of the root node is always null
	private AHNode leftChild; //leftChild of a leaf is always null
	private AHNode rightChild; //rightChild of a leaf is always null
	private AHNode leftSibling; //leftSibling of a leaf is NOT necessarily null
	private AHNode rightSibling; //rightSibling of the root is always null
	
	public AHNode() {
		this.weight = 0;
		this.charValue = 0;
		this.encoding = "";
		this.parent = null;
		this.leftChild = null;
		this.rightChild = null;
		this.leftSibling = null;
		this.rightSibling = null;
	}

	// getters
	public int getWeight() {
		return this.weight;
	}
	
	public char getCharValue() {
		return this.charValue;
	}
	
	public String getEncoding() {
		return this.encoding;
	}
	
	public AHNode getParent() {
		return this.parent;
	}
	
	public AHNode getLeftChild() {
		return this.leftChild;
	}
	
	public AHNode getRightChild() {
		return this.rightChild;
	}
	
	public AHNode getLeftSibling() {
		return this.leftSibling;
	}
	
	public AHNode getRightSibling() {
		return this.rightSibling;
	}

	// setters
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setCharValue(char charValue) {
		this.charValue = charValue;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public void setParent(AHNode parent) {
		this.parent = parent;
	}
	
	public void setLeftChild(AHNode leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(AHNode rightChild) {
		this.rightChild = rightChild;
	}
	
	public void setLeftSibling(AHNode leftSibling) {
		this.leftSibling = leftSibling;
	}
	
	public void setRightSibling(AHNode rightSibling) {
		this.rightSibling = rightSibling;
	}
	
	public String toString() {
		return "weight: " + this.weight + ", character: " + 
			   this.charValue + ", encoding" + this.encoding;
	}
	
	public boolean isLeaf() {
		return (this.getLeftChild() == null && this.getRightChild() == null);
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + charValue;
		result = prime * result
				+ ((encoding == null) ? 0 : encoding.hashCode());
		result = prime * result + weight;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AHNode))
			return false;
		AHNode other = (AHNode) obj;
		if (charValue != other.charValue)
			return false;
		if (encoding == null) {
			if (other.encoding != null)
				return false;
		} else if (!encoding.equals(other.encoding))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	@Override
	public int compareTo(AHNode otherNode) {
		if (this.weight < otherNode.getWeight()) {
			return -1;
		} else if (this.weight == otherNode.getWeight()) {
			return 0;
		} else {
			return 1;
		}
	}
	
}

