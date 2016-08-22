package extractor;

import java.util.ArrayList;

public class Finalizer {

	public ArrayList<String[]> finishHim(ArrayList<String[]> stuff, ArrayList<Event> master){
		ArrayList<String[]> finalized = new ArrayList<String[]>();
		for(String[] s : stuff){
			if(master.isEmpty())break;
			for(Event m : master){
				if(Long.parseLong(s[0]) == m.getEventID()){
					finalized.add(s);
					stuff.remove(s);
					master.remove(m);
					break;
				}
			}
		}
		return finalized;
	}
}
