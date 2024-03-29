package dataaccess;

import java.io.BufferedReader;	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
	
	public FileOperations() {
		
	}
	
	//it writes given text to a .txt file
	public void writeToFile(String text, String fileName) {
		File file = new File(System.getProperty("user.home") + "/Desktop/" + fileName);
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(file))) { 
	        bWriter.write(text);
	        bWriter.write("\n");
	        bWriter.flush();
	      }
	      catch (IOException e) {
	         e.printStackTrace();
	      }
	}
	
	//it reads a .txt file and returns it as a string
	public String readFromFile(String fileName){
		String myFileString = null;
		try(BufferedReader bReader = new BufferedReader(new FileReader(System.getProperty("user.home") + "/Desktop/" + fileName))) {
			StringBuilder sBuilder = new StringBuilder();
			
			String line;
			
			while ((line = bReader.readLine()) != null) {
				sBuilder.append(line);
				sBuilder.append("\n");
			}
			myFileString = sBuilder.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return myFileString;
    }
	
}
