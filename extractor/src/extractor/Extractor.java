package extractor;

import java.io.IOException;
import java.util.ArrayList;

public class Extractor {

	public static void main(String[] args){
		/*
		 * String csvFile = "C:/Users/curt/Desktop/work/LEADIR/data/2015_GTD_CSV.csv";
		 * */
		ArrayList<String[]> stuff;
		String csvFilePath  = "C:\\Users\\Cotty\\Documents\\GitHub\\csvStuff\\extractor\\res\\2015_GTD_CSV.csv";

		try {
			System.out.println("Read Start");
			stuff = FileCSV.fromCSV(csvFilePath);
			System.out.println("Read End");
			System.out.println("Write Start");
			FileCSV.toCSV(stuff, "Test");
			System.out.println("Write End");
		} catch (IOException e) {
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
	System.out.println("Done");
	}

}
