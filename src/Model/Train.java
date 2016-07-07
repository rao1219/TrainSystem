package Model;
import java.io.Serializable;

import System.InvalidTrainException;
/**
 * This Train information is the basic train model and holds train's information.
 * Besides, the Train can change its status or get information of next station.
 * @author Raoqi
 * */
public class Train implements Serializable {
	private String name;
	private boolean isAssigned;
	private int journey;
	private int driver;
	private boolean hasDriver;
	private int process;
	private boolean start;
	private boolean running;
	private int speed;
	private char nextStation;
	
	public char getNextStation() {
		return nextStation;
	}
	public void setNextStation(char nextStation) {
		this.nextStation = nextStation;
	}
	public boolean isRunning(){
		return this.running;
	}
	public void run(){
		this.running = true;
	}
	public void terminate(){
		this.running = false;
	}
	
	public boolean getState(){
		return this.start;
	}
	public void start(){
		this.start  = true;
	}
	
	public void stop(){
		this.start = false;
	}
	
	public int getProcess() {
		return process;
	}
	public void setProcess(int process) {
		this.process = process;
	}
	public boolean hasDriver(){
		return hasDriver;
	}
	public void setDriver(int d){
		this.hasDriver = true;
		this.driver = d;
	}
	public int getDriver(){
		return this.driver;
	}
	
	public int getJourney(){
		return this.journey;
	}
	public boolean isAssigned() {
		return isAssigned;
	}
	public void setAssigned(int t) {
		this.journey = t;
		this.isAssigned = true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	/**
	 * Get information of next station.
	 * */
	
	public char getNextStation(int process,String route){
		int len = route.length();
		int index = (int) (len*1.0*process/100 +1);
		
		this.setNextStation(route.charAt(index));
		return route.charAt(index);
	}
	
	public Train(String name,int speed){
		this.name = name;
		this.speed = speed;
		this.isAssigned = false;
		this.process = 0;
		this.start = true;
		this.setNextStation('S');
	}
	/**
	 * To register a new train to the system.
	 * */
	public static Train register(String n,int s) throws InvalidTrainException {
		String name = n;
		int speed = s;
		if(s>500||s<=0)
			 throw new InvalidTrainException("Invalid speed!");
		else {
			return new Train(name, speed);
		}
	}
}
