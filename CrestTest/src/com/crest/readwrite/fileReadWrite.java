package com.crest.readwrite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class fileReadWrite {
	
	public ArrayList<File> listFile(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        ArrayList<File> readFiles = new ArrayList<>();
        for (File file : fList){
            if (file.isFile()){
                readFiles.add(file);
            } else if (file.isDirectory()){
            	listFile(file.getAbsolutePath());
            }
        }
        
        return readFiles;
    }
	
	public void readFromDB() {
		
	}
	
	public void readWrite(String directoryName, String outputFile){
		
		ArrayList<File> readF = listFile(directoryName);
		
		for(File readFile : readF){
			try (BufferedReader br = new BufferedReader(new FileReader(readFile));
					PrintWriter out = (new PrintWriter(new FileWriter(outputFile,true)))) {
	
				for(String line = br.readLine(); line != null; line = br.readLine()){
	                out.append(line.toUpperCase());
	                out.println();
	            } 
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
