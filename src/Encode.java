import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/**
 * @author CIS121 staff
 * Encoder for Adaptive Huffman Compression
 */
public class Encode {

	/*
	 * Encodes FileInputStream input using adaptive Huffman coding.
	 * Takes an empty AbstractAHTree tree as an input.
	 * Returns a String of 0's and 1's representing the encoded text.
	 * After this method returns, tree should be the root of an AbstractAHTree that was constructed
	 * in the process of encoding.
	 */
	@SuppressWarnings("finally")
	public static String encodeFile(FileInputStream input, AbstractAHTree tree) throws IOException{
		String output = "";
		InputStream file = input;
		Reader reader = null;
		int inc = 0;
		
		try{
			reader = new InputStreamReader(file,"US-ASCII");
		}
		catch(UnsupportedEncodingException uee){
		}
		try{
			while ((inc = reader.read())!= -1){
				if (tree.getEncoding((char)inc) == null){
					StringBuilder temps = new StringBuilder(output);
					
					temps.append(tree.getEncoding(tree.NYT_CHAR)); 
					temps.append(tree.convertASCIIToBinaryString((char)inc));
					System.out.println(tree.convertASCIIToBinaryString((char)inc));
					
					tree.insert((char)inc);					
					output = temps.toString();
				}
				else{
					StringBuilder temps = new StringBuilder(output);
					temps.append(tree.getEncoding((char)inc));
					output = temps.toString();
					
					tree.updateTree((char)inc);
				}

			}
		}
		finally{
			reader.close();
			return output;
		}
	}

}
