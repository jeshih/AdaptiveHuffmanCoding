import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AHTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		AHTree testtree = new AHTree();

		testtree.insert('a');
		testtree.updateTree('a');
		testtree.printNeat();
		testtree.insert('b');
		testtree.printNeat();
		testtree.insert('c');
		testtree.printNeat();
		testtree.insert('d');
		testtree.printNeat();
		testtree.updateTree('a');
		testtree.printNeat();
		testtree.updateTree('d');

		System.out.println("printing out updated tree");
		testtree.printNeat();
		testtree.printMap();
	}

}
