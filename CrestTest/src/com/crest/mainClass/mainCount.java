package com.crest.mainClass;

import com.crest.wordcount.*;

public class mainCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wordCount wc = new wordCount();
		wc.frequency(args[0],args[1]);
	}

}
