package extractor;

import java.util.ArrayList;

public class Group {

	private String name = "";
	private ArrayList<Event> events = new ArrayList<Event>();
	private int[] tt = new int[22];
	private double[] tp = new double[22];
	
	public Group(String n58, String e0, String target34) throws NumberFormatException{
		name = n58;
		events.add(new Event(Long.parseLong(e0),Integer.parseInt(target34)));
		try{
			tt[Integer.parseInt(target34)-1] = 1;
		}catch(NumberFormatException ex){
			System.out.println(target34);
		}
	}
	public void addTargets(int[] i){
		int ind = -1;
		for(int t : i){
			ind++;
			tt[ind]+=t;
		}
		calcPercents();
	}
	private void calcPercents(){
		double totalT = 0;
		for(double t : tt){
			totalT+=(double)t;
		}
		int i = -1;
		for(double t : tt){
			i++;
			tp[i] = (double)t/(double)totalT;
		}
	}
	
	public double getTypePercent(int type){
		return tp[type];
	}
	
	public int[] getTT(){
		return tt;
	}
	public void addEvent(Event s){
		events.add(s);
	}
	
	public String getName(){
		return name;
	}

	public Event getEvent(int i) {
		return events.get(i);
	}
	
	public ArrayList<Event> getEvents(){
		return events;
	}
	
	public Event getAndRemove(int i, int targ){
		ArrayList<Event> eventsTarget = new ArrayList<Event>();
		Event temp = new Event(-1,targ);
		int count=0;
		for(Event e : events){
			if(e.getTargetID() == targ){
				eventsTarget.add(e);
				count++;
			}
		}
		
		System.out.println(count+": count: "+eventsTarget.size()+": size");
		try{
			temp = eventsTarget.get(i);
			events.remove(temp);
		}catch(IndexOutOfBoundsException e){
			
		}
		return temp;
	}
	
	public String toString(){
		String r = "";
		for(Event s : events)r+=s+" ";
		
		return getName()+" Events:"+r;
	}
}
