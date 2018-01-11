import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CountWords {

	public static void main(String[] args){
		
		ArrayList<String> list = new ArrayList<String>();
		
		try{
			File fileIn = new File("input.txt");
			File fileOut = new File("output.txt");
			
			Scanner scanner = new Scanner(fileIn);
			PrintWriter writer = new PrintWriter(fileOut);
			
			while(scanner.hasNext()){
				String str = scanner.next();
				str = str.toLowerCase();
				
				if(!(list.contains(str)))
					list.add(str);
			}
			
			Collections.sort(list);
			
			String numWords = Integer.toString(list.size()) + " words total:";
			writer.printf("%3d", numWords);
			writer.println("");
			
			for(String s: list){
				writer.println(s);
			}
			
			scanner.close();
			writer.close();
		}
		catch(IOException e){
			
		}	
	}
}
