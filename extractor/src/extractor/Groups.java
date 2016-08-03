package extractor;

import java.util.ArrayList;

public class Groups {

	private ArrayList<Group> groups = new ArrayList<Group>();
	
	public void addGroup(Group g){
		if(!exists(g)){
			groups.add(g);
		}
	}
	
	private boolean exists(Group g){
		for(Group gr : groups){
			if(gr.getName().equals(g.getName())){
				gr.addEvent(g.getEvent(0));
				gr.addTargets(g.getTT());
				return true;
			}
		}
		return false;
		
	}
	
	public ArrayList<Group> getGroups(){
		return groups;
	}
	
	public String toString(){
		String r="";
		for(Group g : groups){
			r+=g+"\n";
		}
		return r;
	}
}
