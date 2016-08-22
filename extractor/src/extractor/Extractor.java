package extractor;

import java.io.IOException;
import java.util.ArrayList;

public class Extractor {

	public static void main(String[] args){
		/*
		 * String csvFile = "C:/Users/curt/Desktop/work/LEADIR/data/2015_GTD_CSV.csv";
		 * */
		ArrayList<String[]> stuff;
		ArrayList<Event> randomSample = new ArrayList<Event>();
		Groups groups = new Groups();
		
		String csvFilePath  = "C:\\Users\\curt\\Documents\\csvRandy\\csvStuff\\extractor\\res\\2015_GTD_CSV.csv";

		try {
			System.out.println("Read Start");
			stuff = FileCSV.fromCSV(csvFilePath);
			System.out.println("Read End");
			
			for(String[] s: stuff){
				try{
					groups.addGroup(new Group(s[58],s[0],s[34]));
				}catch(NumberFormatException e){
					//Don't add group
					//System.out.println(e);
				}
				
			}
			
			for(Group g : groups.getGroups()){
				//get array of targets attacked, and totals of those attacks
				int[] rows = g.getTT();
				System.out.println("Group: "+ g.getName());
				//loop through target types bucket(array)
				for(int b=0; b<22; b++){
					//get percent for target type(b)
					double targetPercent = g.getTypePercent(b);
					if(targetPercent > 0.0){
						//call now
						System.out.println("Target Type: "+b+": "+targetPercent*100+"%");
						int rand = (int)(Math.random() * (rows[b]+1));
						rows[b] --;
						randomSample.add(g.getAndRemove(rand,b));
						
					}else{
						//System.out.println("0: "+targetPercent);
					}
					//System.out.println(targetPercent);
				}
			}
			
			
			//System.out.println("Groups:"+groups);
			
			
			
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
