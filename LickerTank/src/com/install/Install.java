package com.install;
import java.io.*;
import java.nio.charset.Charset;

import au.com.bytecode.opencsv.CSVWriter;

public class Install {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("properties.txt");
		 
		  if(f.exists()){
			  System.out.println("Properties File exists in the dir "+ System.getProperty("user.dir"));
			  
				System.out.println(PropValues.getPropValues());
				 
			  
			  
		  }
		  
		  else{
			  
			  
			  
			  
			  
			  System.out.println("Properties File not found! Please edit the new file called properties.txt in the dir "+ System.getProperty("user.dir"));
			  
			  f.createNewFile();
			  
			  
			  FileWriter pw = new FileWriter("properties.txt",true); 
			  BufferedWriter bw = new BufferedWriter(pw);
				
								
				bw.write("TempProbe1=serialnumber"+"\r\n");
				bw.write("TempProbe2=serialnumber"+"\r\n");
				bw.write("TempProbe3=serialnumber"+"\r\n");
				bw.close();
				
				
		  }
		
		
		
	}

}
