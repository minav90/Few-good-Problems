import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadDictionary {
	
	public ArrayList<String> getDictionary() throws FileNotFoundException
	{

		ArrayList<String> nodes = new ArrayList<String>();
		String thisLine;
		BufferedReader bIS = new BufferedReader(new FileReader("./dictionary.txt"));
		 try {
			while ((thisLine = bIS.readLine()) != null) {
			        nodes.add(thisLine);
			     }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
		return nodes;
	
	}
	
			   
}
