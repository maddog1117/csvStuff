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
    /**Saves data to a CSV File*/
    
    public static ArrayList<ArrayList<String>> fromCSV(String name) throws IOException{
    	ArrayList<ArrayList<String>> records = new ArrayList<ArrayList<String>>();
		CsvReader file = new CsvReader(name);

		while (file.readRecord())
		{
			int i = 0;
			for(String a : file.getRawRecord().split("\\,")){
				records.get(i).add(a);
				i++;
			}
				
		}

		file.close();
		return records;
	}
    /**Reads data from a CSV File*/

}
