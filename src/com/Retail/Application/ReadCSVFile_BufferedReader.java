package com.Retail.Application;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.Retail.Exception.CsvHandling;
import com.Retail.POJO.Paper;

public class ReadCSVFile_BufferedReader {
	// Delimiters used in the CSV file
	private static final String COMMA_DELIMITER = ",";
	static boolean   LoopVariable=true;
	private static final String PAPER="Paper";

	public static void main(String args[]) throws Exception {
		//Loop for executing program 
	 while(LoopVariable) {
		 //Parsing and checking weather the file is .csv or not
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter the file location");
			String str=br.readLine();
			CsvHandling c=new CsvHandling(str);
			boolean ErrorConstraint=c.checkError();
		 //if statement is executed when the file is .csv file
		 if (ErrorConstraint) {
	 
		try {
			// Reading the csv file
			br = new BufferedReader(new FileReader(str));
			}catch (Exception ee) {
			System.out.println("invalid file format");;
				}
			// Create List for holding paper objects
			List<Paper> Products = new ArrayList<Paper>();

			String line = "";

			br.readLine();
		//Parsing the .csv file
			while ((line = br.readLine()) != null) {
				String[] paperDetails = line.split(COMMA_DELIMITER);
				// condition to check file is not empty
				if (paperDetails.length > 0) {
					//Adding elements to the arraylist
					if (paperDetails[0].equals(PAPER)) {
						Paper Ppr = new Paper(Integer.parseInt(paperDetails[1]), paperDetails[2], paperDetails[3],
								Double.parseDouble(paperDetails[4]) - (0.01 * Double.parseDouble(paperDetails[5])),
								Double.parseDouble(paperDetails[5]));
						Products.add(Ppr);
					}
				}

			}
			/* Using Collection.sort to sort the elements of the list based on the Price calculated after the discount is applied*/
			for (int i = 0; i < Products.size(); i++) {

				Collections.sort(Products, new SortByPrice());

			}
			//to display the elements of the list which are paper category
			for (Paper Iterator : Products) {
				System.out
						.println(Iterator.getPart() + "   " + Iterator.getDescription() + "   " + Iterator.getUOM() + "   " + Iterator.getPrice());
			}
		
		
			try {
				br.close();
			} catch (IOException ie) {
				System.out.println("Error occured while closing the BufferedReader");
				ie.printStackTrace();
			}
		LoopVariable=false;
		}
	else {
		System.out.println("enter .csv extension files");
		
	}
		
	 }
	}
}
