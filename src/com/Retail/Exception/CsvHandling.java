package com.Retail.Exception;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
//Class which handle the .csv file format exceptions
public class CsvHandling {
	String str;
	 static final String  Csv="csv";

	public CsvHandling(String str) {
		super();
		this.str = str;
	}
//method to check weather the file is .csv or not
	public boolean checkError() {
		if(!(str.isEmpty())) {
			String[]  Csvsplit= str.split("\\.");
			System.out.println("The file extension provided in the path is "+Csvsplit[1]);
		if (Csvsplit[1].equals(Csv)) {
			return true;
		}
		return false;

	}else {
		System.out.println("File path cannot be empty");
		return false;
	}

}
}
