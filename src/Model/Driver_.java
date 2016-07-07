package Model;

import java.io.Serializable;

import System.InvalidTrainException;
/**
 * This Driver_ class is the driver model containing basic driver information and related functions.
 * @author Raoqi
 * */
public class Driver_ implements Serializable{
	private String name;
	private int gener;
	private int age;
	private String password;
	private String phone;
	private String address;
	private int train;
	private boolean hasTrain;
	
	public boolean hasTrain(){
		return this.hasTrain;
	}
	public void setTrain(int t){
		this.train = t;
		this.hasTrain =true;
	}
	public int getTrain(){
		return this.train;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGener() {
		return gener;
	}
	public void setGener(int gener) {
		this.gener = gener;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Driver_(String name,int gener,int age,String password,String phone,String address){
		this.name = name;
		this.gener = gener;
		this.age = age;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	public Driver_(){
		
	}
	/**
	 * To register a new driver to the system.
	 * */
	public static Driver_ register(String name,int gener,int age,String password,String confirm,String phone,String address) throws InvalidTrainException{
		if(name.replace(" ", "").equals("")){
			throw new InvalidTrainException("The driver name is empty!");
		}
		else if(!password.equals(confirm)){
			throw new InvalidTrainException("The two input passwords are not the same!");
		}else if(gener ==0){
			throw new InvalidTrainException("Please select gender!");
		}
		else if(password.length()<6){
			throw new InvalidTrainException("Too simple password");
		}else if(age>150||age<16){
			throw new InvalidTrainException("Sorry, you are not allowed to regist as a driver.");
		}
		else if(phone.length()<10){
			throw new InvalidTrainException("Phone number is invalid!");
		}
		else if(address.replace(" ", "").equals("")){
			throw new InvalidTrainException("Empty address!");
		}
		else {
			return new Driver_(name, gener, age, password,phone,address);
		}
	}
	
}