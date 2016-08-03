package extractor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class FileCSV {
	
	 public static void toCSV(String[] row2write,String name) throws IOException{

	    	File file = new File( name+".csv");  
	        if ( !file.exists() ){
	            file.createNewFile();
	        }
	        CsvWriter csvOutput = new CsvWriter(new FileWriter(file, true), ',');
	        
	        for(String temp : row2write){
	   		 	csvOutput.write(temp);
	        }
	        csvOutput.endRecord();
	        csvOutput.flush();
	        csvOutput.close();

		}
    public static void toCSV(ArrayList<String[]> stuff,String fileName) throws IOException{
		for(int i = 0; i < stuff.size(); i++){
			toCSV(stuff.get(i), fileName);
		}
		
	}
    /**Saves data to a CSV File*/
    
    public static ArrayList<String[]> fromCSV(String name) throws IOException{
    	ArrayList<String[]> records = new ArrayList<String[]>();
    	String[] line = new String[137];
		CsvReader file = new CsvReader(name);
		
		
		while (file.readRecord())
		{
			int i = 0;
			for(String a : file.getRawRecord().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")){
				
				//if(i < 137)
				line[i] = a;
				//else line[136] = ","+line[136];
				i++;
			}
			records.add(line);
			line = new String[137];
		}

		file.close();
		return records;
	}
    /**Reads data from a CSV File*/

}
