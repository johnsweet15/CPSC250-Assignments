package Robot;

import java.io.*;
import java.util.*;

public class Robot {
	
	private static int row;
	private static int col;
	
	public static void move(String dir, int distance){
		if(dir.equals("N"))
			row = row - distance;
		if(dir.equals("S"))
			row = row + distance;
		if(dir.equals("E"))
			col = col + distance;
		if(dir.equals("W"))
			col = col - distance;
	}
	
	public static void readInstructions(String input, String output){
		try{
			File fileIn = new File(input);
			File fileOut = new File(output);
			
			Scanner scanner = new Scanner(fileIn);
			PrintWriter writer = new PrintWriter(fileOut);
			
			try{
				while(scanner.hasNextLine()){
					String str = scanner.nextLine();
					Scanner scan = new Scanner(str);

					int height = scan.nextInt();
					int width = scan.nextInt();
					row = scan.nextInt();
					col = scan.nextInt();
					
					if(height <= 0 || width <= 0){
						scan.close();
						scanner.close();
						writer.close();
						throw new InvalidRobotInstructionException();
					}
					
					if(row > height || col > width)
						writer.println("terminated");
					
					else{
						while(scan.hasNext()){
							String dir = scan.next();
							int distance = scan.nextInt();
							
							if(!(dir.equals("N") || dir.equals("S") || dir.equals("E") || dir.equals("W"))){
								scan.close();
								scanner.close();
								writer.close();
								throw new InvalidRobotInstructionException();
							}
							else
								move(dir, distance);
						}
							
						if(row < 0 || row > height || col < 0 || col > width)
							writer.println("terminated");
						else
							writer.println(row + " " + col);
						scan.close();	
					}		
				}
				
				scanner.close();
				writer.close();
			}
			catch(InputMismatchException e){
				scanner.close();
				writer.close();
				throw new InvalidRobotInstructionException();
			}
			catch(NoSuchElementException e){
				scanner.close();
				writer.close();
				throw new InvalidRobotInstructionException();
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Input file not found.");
		}
	}
}
