package com.quintrix.huang.training;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


public class Filer {
	public static void createFile(String filename) {
		try {
			File fileObj = new File(filename);
			if (fileObj.createNewFile()) {
				System.out.println("File created: " + fileObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred during file creation.");
			e.printStackTrace();
		}
		
	}
}
