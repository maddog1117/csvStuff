package extractor;

import java.util.ArrayList;

public class Group {

	private String name = "";
	private ArrayList<Event> events = new ArrayList<Event>();
	private int[] tt = new int[22];
	private double[] tp = new double[22];
	
	public Group(String n58, String e0, String target34){
		name = n58;
		events.add(new Event(e0,target34));
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
		int totalT = 0;
		for(int t : tt){
			totalT+=t;
		}
		int i = -1;
		for(int t : tt){
			i++;
			tp[i] = t/totalT;
		}
	}
	
	public double getTypePercent(int type){
		return tp[type];
	}
	
	public int[] getTT(){
		return tt;
	}
	public void addEvent(String s){
		events.add(s);
	}
	
	public String getName(){
		return name;
	}

	public String getEvent(int i) {
		return events.get(i);
	}
	
	public String toString(){
		String r = "";
		for(String s : events)r+=s+" ";
		
		return getName()+" Events:"+r;
	}
}
