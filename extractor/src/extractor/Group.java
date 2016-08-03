package extractor;

import java.util.ArrayList;

public class Group {

	private String name = "";
	private ArrayList<String> events = new ArrayList<String>();
	private int[] tt = new int[22];
	private double[] tp = new double[22];
	
	public Group(String n, String e, String target){
		name = n;
		events.add(e);
		tt[Integer.parseInt(target)-1] = 1;
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
