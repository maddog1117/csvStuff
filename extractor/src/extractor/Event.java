package extractor;

public class Event {
	
	long id = -1;
	int tt = -1;

	public Event(long e0, int target34) {
		id = e0;
		tt = target34;
	}
	
	public long getEventID(){
		return id;
	}
	
	public int getTargetID(){
		return tt;
	}
	
	public String toString(){
		return id+"";
	}
	
}
