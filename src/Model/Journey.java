package Model;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
/**
 * This Journey class is the basic model of route's journey.
 * @author Raoqi
 * */
public class Journey implements Serializable{
	
	public Vector<Station> route;
	
	public Journey(){
		route = new Vector<Station>();
	}
	public void add(Station s){
		route.add(s);
	}
	/**
	 * Transform a route to string for purpose of presentation.
	 * */
	public String toRouteString(){
		String str = "";
		for(Station s:route){
			str+= s.getName();
			
		}
		return str;
		
	}
	 
}
