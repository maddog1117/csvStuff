package extractor;

import java.util.ArrayList;

public class Finalizer {

	public static ArrayList<String[]> finnish(ArrayList<String[]> stuff, ArrayList<Event> master){
		ArrayList<String[]> finalized = new ArrayList<String[]>();
		for(String[] s : stuff){
			if(master.isEmpty())break;
			for(Event m : master){
				try{
					if(Long.parseLong(s[0]) == m.getEventID()){
						finalized.add(s);
						//stuff.remove(s);
						master.remove(m);
						break;
					}
				}catch(NumberFormatException e){
					/*if(s[0].equalsIgnoreCase("eventid"))
						finalized.add(s);*/
				}
			}
		}
		return finalized;
	}
}
