package Model;

import java.io.Serializable;
/**
 * This Station class is a basic model that holds station information.
 * @author Raoqi
 * */
public class Station implements Serializable{
	private char name;
	
	public Station(char name){
		this.name = name;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}
	
}
