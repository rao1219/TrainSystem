package System;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;

import Model.Journey;
import Model.Train;
import Model.Driver_;
/**
 * This database class is a visual mini database implementation based on binary file IO.
 * @author Raoqi
 * */
public class Database {
	/**
	 * These arraylists store all information of journeys, trains and drivers.
	 * */
	private ArrayList<Journey> journeyList;
	private ArrayList<Train> trainList;
	private ArrayList<Driver_> driverList;
	
	public ArrayList<Driver_> getDriverList() {
		return driverList;
	}
	public void setDriverList(ArrayList<Driver_> driverList) {
		this.driverList = driverList;
	}
	public ArrayList<Train> getTrainList() {
		return trainList;
	}
	public void setTrainList(ArrayList<Train> trainList) {
		this.trainList = trainList;
	}
	public ArrayList<Journey> getJourneyList() {
		return journeyList;
	}
	public void setJourneyList(ArrayList<Journey> journeyList) {
		this.journeyList = journeyList;
	}
	
	public Database(){
		this.journeyList = new ArrayList<Journey>();
		this.trainList = new ArrayList<Train>();
		this.driverList = new ArrayList<Driver_>();
		init();
	}
	/**
	 * Using file IO using object Stream.
	 * */
	public void init() {
		FileInputStream freader,freaderTrain,freaderDriver;
		try{
			freader = new FileInputStream("JourneyInfo.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(freader);
			journeyList = (ArrayList<Journey>)objectInputStream.readObject();
			
			freaderTrain = new FileInputStream("Traininfo.txt");
			ObjectInputStream trainobjectInputStream = new ObjectInputStream(freaderTrain);
			trainList = (ArrayList<Train>)trainobjectInputStream.readObject();
			
			freaderDriver = new FileInputStream("DriverInfo.txt");
			ObjectInputStream objectInputStreamDriver = new ObjectInputStream(freaderDriver);
			driverList = (ArrayList<Driver_>)objectInputStreamDriver.readObject();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Searching the journey list to check whether the journey is valid.
	 * */
	public boolean isJourneyValid(Journey newJourney){
		boolean judge = true;
		for(Journey j:journeyList){
			
			//System.out.print(j.route.toString());
			//System.out.println(newJourney.toString());
			if (j.toRouteString().equals(newJourney.toRouteString())) {
				judge = false;
				break;
			}
		}
		return judge;
	}
	/**
	 * Searching the train list to check whether a new train is valid.
	 * */
	public boolean isTrainValid(Train newTrain){
		boolean judge = true;
		for(Train t:trainList){
			if(t.getName().equals(newTrain.getName())){
				judge = false;
				break;
			}
		}
		return judge;
	}
	/**
	 * Searching the driver list to check whether a new driver is valid.
	 * */
	public boolean isDriverValid(Driver_ newDrveDriver){
		boolean judge = true;
		for(Driver_ d: driverList){
			if(d.getName().equals(newDrveDriver.getName())){
				judge = false;
				break;
			}
		}
		return judge;
	}
	
	/**
	 * Store these arraylists to files.
	 * */
	public void writeFile(){
		try {
			FileOutputStream outStream = new FileOutputStream("JourneyInfo.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outStream);
			objectOutputStream.writeObject(journeyList);
			outStream.close();
			
			FileOutputStream outTrainStream = new FileOutputStream("Traininfo.txt");
			ObjectOutputStream objectOutputTrainStream = new ObjectOutputStream(outTrainStream);
			objectOutputTrainStream.writeObject(trainList);
			outTrainStream.close();
			
			FileOutputStream outStreamDriver = new FileOutputStream("DriverInfo.txt");
			ObjectOutputStream objectOutputStreamDriver = new ObjectOutputStream(outStreamDriver);
			objectOutputStreamDriver.writeObject(driverList);
			outStreamDriver.close();
			System.out.println("Saved success.");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void addJourney(Journey j){
		journeyList.add(j);
	}
	public void addTrain(Train t){
		trainList.add(t);
	}
	public void addTriDriver(Driver_ driver){
		driverList.add(driver);
	}
	
}
