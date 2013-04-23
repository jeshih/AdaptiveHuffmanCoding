import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class EncodeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws IOException {
		AHTree ttree = new AHTree();
		Encode encoder = new Encode();
		FileInputStream stream = null;

		try {
			stream = new FileInputStream("test.txt");
		} finally {
			System.out.println(encoder.encodeFile(stream, ttree));
		}
	}

}
