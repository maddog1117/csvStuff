package extractor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.csvreader.*;
import com.opencsv.*;

public class Extractor {

	public static void main(String[] args){
		/*
		 * String csvFile = "C:/Users/curt/Desktop/work/LEADIR/data/2015_GTD_CSV.csv";
		 * */
		
		String [] list = new String[20000];
		String csvFilePath = "C:/Users/curt/Desktop/work/LEADIR/data/2015_GTD_CSV.csv";
		String myList = null;
		
		try {
			CsvReader csvReader = new CsvReader("C:/Users/curt/Desktop/work/LEADIR/data/2015_GTD_CSV.csv");
			String[] headers = csvReader.getHeaders();
			
			boolean running = true;
			while(csvReader.readRecord()){
				myList = csvReader.get(0);
				//System.out.println(myList);
			}
			System.out.println(headers);
			/*for(int x=0; x<headers.length; x++){
				System.out.println(headers[x]);
			}*/
			
			CSVReader reader = new CSVReader(new FileReader(csvFilePath), ',');
			
			String[] nextLine;
			/*
			while((nextLine = reader.readNext()) != null){
				for(int x=0; x<nextLine.length; x++){
					list[x] = nextLine[x];
					System.out.println(nextLine[x]);
				}
			}
			
			if(nextLine == null){
				reader.close();
			}
			*/
			
			//List<String[]> myEntries = reader.readAll();
			/*for (String[] string : myEntries){
				System.out.println("what");
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		 * Steps:
		 * 
		 * 1. Read in file
		 * 2. Get total number of rows
		 * 3. Instantiate array to hold entire copy
		 * 4. Parse CSV, copy to new list
		 * 5. Read list, do statistics
		 * 	-Get a 10% sample from 2015 data->
		 * 		get a random 10% sample of attacks for each group
		 * 		->that 10% is comprised of a relative number of attacks of each target type (so a group only did 50 attacks, 40 police, 5 leaders, 3 civilians, 2 Religious leaders...the sample would be 4, 1, 1, 1.
		 */
		
		
		/*try {
			myList = readFile(csvFilePath, list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(myList);*/
		
		
	}
	
	public static String[] readFile(String csvFilePath, String[] list) throws ClassNotFoundException{
		return list;
		/*CSVReader reader = null;
		try{
			
			reader = new CSVReader(new FileReader(csvFilePath), ',');
			String[] nextLine;
			while((nextLine = reader.readNext()) != null){
				for(int x=0; x<nextLine.length; x++){
					list[x] = nextLine[x];
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return list;*/
		
	}
}
