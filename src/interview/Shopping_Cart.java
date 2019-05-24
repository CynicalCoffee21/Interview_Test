package interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shopping_Cart {
	private static final String Apple = "Apple";
	private static final String Orange = "Orange";
	
	public static void main(String[] args) throws FileNotFoundException{
		int Acount = 0, Ocount = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a filename containing a shopping list: ");
		String filename = scan.next();
		
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file);
		fileScanner.useDelimiter(",");
		
		String item = "";
		int count = 0;
		while( fileScanner.hasNext() ) {
			item = fileScanner.next();
			if(count == 0) {
				item = item.substring(1);					
			}
			if(!fileScanner.hasNext()) {
				item = item.substring(0, item.length()-1);	
			}
			if(item.equals(Apple)) {
				Acount++;
			}
			else if(item.equals(Orange)) {
				Ocount++;
			}
			else {
				System.out.println("Invalid item ignored.");
			}
			System.out.println(item);
			count++;
		}
		Acount *= 60;
		Ocount *= 25;
		double totalCost = (Acount + Ocount);
		
		System.out.println("Total cost = \u00a3" + String.format("%.2f", totalCost/100)); //Test file should have 6 of each so that equals 5.10
		fileScanner.close();															  //file1x5 should be 5 times file 1, so 25.50
		scan.close();
	}
	
}
