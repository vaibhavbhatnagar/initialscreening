package com.crest.wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.crest.readwrite.fileReadWrite;
public class wordCount {
	
	public void  frequency( String directoryName, String outputFile) {
		
		Map<String, Integer> wordcount = new HashMap<String, Integer>(); 
		fileReadWrite frw = new fileReadWrite();
		ArrayList<File> files = frw.listFile(directoryName);
		
		for(File readFile : files){
			try (BufferedReader br = new BufferedReader(new FileReader(readFile))) {
	
				for(String line = br.readLine(); line != null; line = br.readLine()){
					for (String val : line.toLowerCase().split(" ")) {
						Integer freq = wordcount.get(val);
						wordcount.put(val, (freq == null) ? 1 : freq + 1);
		            }
	            } 
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		printInFile(wordcount, outputFile);
	}
	
	public void printInFile(Map<String, Integer> map, String outputFile) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    
		    try (PrintWriter out = (new PrintWriter(new FileWriter(outputFile,true)))) {
	
				String line = "Word = " + entry.getKey() + ", Count = " + entry.getValue();
				out.write(line);
                out.println();
            } catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
