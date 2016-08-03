package extractor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class FileCSV {
	
	 public static void toCSV(String row,String name, String[] header ) throws IOException{
	    	String[] row2write = row.split(",");

			boolean isNew = false;
	    	File file = new File( name+".csv");  
	        if ( !file.exists() ){
	        	isNew=true;
	            file.createNewFile();
	        }
	        CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');
	        if(isNew){
	        	for(String temp : header){
	        		 csvOutput.write(temp);
	            }
		        csvOutput.endRecord();
	        }
	        for(String temp : row2write){
	   		 	csvOutput.write(temp);
	        }
	        csvOutput.endRecord();
	        csvOutput.flush();
	        csvOutput.close();

		}
    public static void toCSV(ArrayList<ArrayList<String>> stuff,String fileName) throws IOException{
    	int size = stuff.get(0).size();
    	String[] header = stuff.get(0).toArray(new String[size]);
		for(int i = 1; i < header.length; i++){
			String str="";
			for(String s : stuff.get(i)){
				str = s+",";
			}
			toCSV(str.substring(0, str.length()-1), fileName, header);
		}
		
	}
    /**Saves data to a CSV File*/
    
    public static ArrayList<ArrayList<String>> fromCSV(String name) throws IOException{
    	ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		CsvReader file = new CsvReader(name);

		while (file.readRecord())
		{
			int i = 0;
			for(String a : file.getRawRecord().split("\\,")){
				try{
					records.get(i).add(a);
				}catch(IndexOutOfBoundsException e){
					records.add(new ArrayList<String>());
					records.get(i).add(a);
				}
				i++;
			}
				
		}

		file.close();
		return records;
	}
    /**Reads data from a CSV File*/

}
