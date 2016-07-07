package System;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.awt.Robot;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import System.InvalidTrainException;
import Model.Driver_;
import Model.Graph;
import Model.Journey;
import Model.Runner;
import Model.Station;
import System.Board;
import Model.Train;
/**
 *   This Action class implements user actions.
	 Containing all the actionListener of core buttons.
 *  @author Raoqi
 * 
 * */

public class Action {
	private Board board;
	private Graph graph;
	private Database db;
	private TrainRegister trainRegister;
	private MapWindow mapWindow;
	private DriverRegister driverRegister;
	private DriverBoard driverBoard;
	private int trainIndex;
	private Timer timer;
	public Action(Board board,Graph g,Database db){
		this.board = board;
		this.graph = g;
		this.db = db;
		timer = new Timer();
	}
	/**
	 * All action listener will be added when invoking this function.
	 * */
	public final void actionToDo(){
		//board.comboBoxModel.addElement("ABC"); 
		
		board.refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				board.comboBoxModel.removeAllElements();
				
				ArrayList<Journey> journeys = new ArrayList<Journey>();
				journeys = db.getJourneyList();
				for(Journey j:journeys){
					String rou = j.toRouteString();
					board.comboBoxModel.addElement(rou);
				}
			}
		});
		board.trainInfoRefreshBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				board.traininfoModel.removeAllElements();
				ArrayList<Train> trains = new ArrayList<Train>();
				trains = db.getTrainList();
				for(Train t:trains){
					board.traininfoModel.addElement(t.getName());
				}
			}
		});
		
		board.driverRefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.driverinfoModel.removeAllElements();
				ArrayList<Driver_> drivers = new ArrayList<Driver_>();
				drivers = db.getDriverList();
				for(Driver_ d:drivers){
					board.driverinfoModel.addElement(d.getName());
				}
			}
		});
		
		board.driverComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(board.driverComboBox.getSelectedItem()==null){
						throw new InvalidTrainException("NULL");
					}
					ArrayList<Driver_> drivers = db.getDriverList();
					int index = board.driverComboBox.getSelectedIndex();
					Driver_ currDriver = drivers.get(index);
					String content = "<html>";
					content += "<center>";
					if(currDriver.getGener()==1){
						
						content += " Mr.";
					}else if(currDriver.getGener()==2){
						content += " Ms.";
					}
					content += currDriver.getName();
					content += "</center>";
					content += "<br><br>";
					content += "Phone: ";
					content += currDriver.getPhone();
					content += "<br><br>";
					content += "Address:";
					content += currDriver.getAddress();
					content += "<br><br>";
					content += "</html>";
					board.driverInfoLabel.setText(content);
				} catch (InvalidTrainException ex) {
				}
			}
		});
		
		board.journeyComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if(board.journeyComboBox.getSelectedItem() ==null){
						throw new InvalidTrainException("Null");
					}
					String journey = (String) board.journeyComboBox.getSelectedItem();
					//System.out.println(journey);
					board.timetableText.setText(" ");
					String content = "<html>";
					for(int i=0;i<journey.length()-1;i++) {
						content += (7+i+":00"+"~"+(8+i)+":00");
						content += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>";
						content += journey.charAt(i);
						content += "-"+journey.charAt(i+1);
						content += "</strong>";
						content += "<br><br>";
					}
					content +="</html>";
					
					board.timetableText.setText(content);
				}catch(InvalidTrainException ex){
					
				}
			}
		});
		
		board.trainComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if(board.trainComboBox.getSelectedItem() == null){
						throw new InvalidTrainException("NULL");
					}
					int index = board.trainComboBox.getSelectedIndex();
					ArrayList<Train> trains = db.getTrainList();
					ArrayList<Journey> journeys = db.getJourneyList();
					ArrayList<Driver_> drivers = db.getDriverList();
					//System.out.println(index);
					Train train = trains.get(index);
					String content = "<html>";
					content += "Train's name: ";
					content += train.getName();
					content += "<br><br>";
					content += "Train's speed: ";
					content += train.getSpeed();
					content += "<br><br>";
					content += "Has Journey?:";
					
					
					if(train.isAssigned()){
						content += "  Yes";
						content += "<br><br>";
						content += "Journey:";
						content += journeys.get(train.getJourney()).toRouteString();
						content += "<br><br>";
						
					}
					else{
						content += "  No";
						content += "<br><br>";
					}
					content += "Has Driver?:";
					if(train.hasDriver()){
						content += " Yes";
						content += "<br><br>"; 
						content += "Driver:";
						content += drivers.get(train.getDriver()).getName();
						content += "<br><br>"; 
					}
					else{
						content += " No";
						content += "<br><br>";
					}
					content += "</html>";
					
					board.trainInforLabel.setText(content);
				}catch(InvalidTrainException ex){
					
				}
				
			}
		});
		
		board.btnDriverRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				driverRegister = new DriverRegister();
				driverRegister.setLocationRelativeTo(null);;
				driverRegister.regist.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						try{
							int gender = 0;
							if(driverRegister.rdbtnMan.isSelected()){
								gender = 1;
							}else if(driverRegister.rdbtnWoman.isSelected()){
								gender = 2;
							}
							if(!driverRegister.chckbxNewCheckBox.isSelected()){
								throw new InvalidTrainException("You should agree the terms of train system!");
							}
							int age = (int) driverRegister.age.getValue();
							String password,confirm,phone,address;
							password = driverRegister.passwordField.getText();
							confirm = driverRegister.passwordField_1.getText();
							phone = driverRegister.phone.getText();
							address = driverRegister.address.getText();
							Driver_ driver = Driver_.register(driverRegister.nameText.getText(), gender, age, password, confirm,phone,address);
							if(!db.isDriverValid(driver)){
								throw new InvalidTrainException("Sorry.You have already registed.");
							}
							db.addTriDriver(driver);
							JOptionPane.showMessageDialog(null,"Successful!","Successful!",JOptionPane.PLAIN_MESSAGE);
							driverRegister.dispose();
						}catch(InvalidTrainException ex){
							JOptionPane.showMessageDialog(null,ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
						}
					}
				});
			}
		});
		
		board.btnNewTrainRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				trainRegister = new TrainRegister();
				trainRegister.setLocationRelativeTo(null);
				trainRegister.ok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String trainName = trainRegister.text.getText();
						int speed = (int) trainRegister.spinner.getValue();
						
						Train train;
						try{
							train = Train.register(trainName, speed);
							if(db.isTrainValid(train) ==true){
								db.addTrain(train);
							}else{
								throw new InvalidTrainException("Train's name has been signed before!");
							}
							
							JOptionPane.showMessageDialog(null,"Successful!","Successful!",JOptionPane.PLAIN_MESSAGE);
							trainRegister.dispose();
						}catch(InvalidTrainException ex){
							JOptionPane.showMessageDialog(null,ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
						}
					}
				});
				trainRegister.reset.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						trainRegister.text.setText("");
					}
				});
			}
		});
		
		board.MapBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mapWindow = new MapWindow();
				mapWindow.ok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						mapWindow.dispose();
					}
				});
			}
		});
		
		board.addJourneyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					//Add new journey route
					String route = board.routeStr.getText();
					Vector<Character> states = new Vector<Character>();//
					states = graph.getAllStates();
					if(route.charAt(0)!='S'||route.charAt(route.length()-1)!='S'){
						throw new InvalidTrainException("Route must start from S and end with S!");
					}
					
					if(route.length()>13){
						throw new InvalidTrainException("Route length too long!");
					}
					
					if(route.length()<=1||route.equals("")){
						throw new InvalidTrainException("Empty input!");
					}
					
					for(int i=1;i<route.length();i++) {
						boolean valid = false;
						char curr = route.charAt(i);
						for(Character c:states){
							if(c == curr){
								valid = true;
								break;
							}
						}
						if(valid ==false){
							throw new InvalidTrainException("You can only input the station name in the graph!");
						}
						Vector<Character> connects = new Vector<Character>();
						
						valid = false;
						connects = graph.getConnects(route.charAt(i-1));
						for(Character c:connects){
							if(c == curr){
								valid =true;
								break;
							}
						}
						if(valid ==false){
							throw new InvalidTrainException("Invalid route!");
						}
						//System.out.println(connects);
					}
					Journey journey = new Journey();
					for(int i=0;i<route.length();i++){
						Station station = new Station(route.charAt(i));
						journey.add(station);
					}
					if(db.isJourneyValid(journey) ==true){
						db.addJourney(journey);
					}
					else{
						//board.routeStr.setText(" ");;
						throw new InvalidTrainException("Unsuccessful! This journey has been assigned before!");
					}
					JOptionPane.showMessageDialog(null,"OK.You added a new journey just now.","Success!",JOptionPane.PLAIN_MESSAGE);
				}catch(InvalidTrainException exe){
					 JOptionPane.showMessageDialog(null,exe.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
				}catch(Exception ex){
					 System.out.println(ex.getMessage());
				}
			}
		});
		
		board.statusRefreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				board.statusinfoModel.removeAllElements();
				ArrayList<Train> trainList = db.getTrainList();
				for(Train t:trainList){
					board.statusinfoModel.addElement(t.getName());
				}
			}
		});
		board.refreshTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				board.trainModel.removeAllElements();
				ArrayList<Train> trainList = db.getTrainList();
				for(Train t:trainList){
					board.trainModel.addElement(t.getName());
				}
			}
		});
		
		board.statuscomboBox.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try{
					if(board.statuscomboBox.getSelectedItem()==null){
						throw new InvalidTrainException("NULL");
					}
					Train train = db.getTrainList().get(board.statuscomboBox.getSelectedIndex());
					Driver_ driver = db.getDriverList().get(train.getDriver());
					board.driverAddressLabel.setText(driver.getAddress());
					board.driverAgeLabel.setText(""+driver.getAge());
					board.driverPhoneLabel.setText(driver.getPhone());
					board.trainNameLabel.setText(train.getName());
					board.trainSpeedLabel.setText(""+train.getSpeed());
					board.trainprogressBar.setValue(train.getProcess());
					board.driverNameLabel.setText(driver.getName());
					String journey = "";
					String originJourney = db.getJourneyList().get(train.getJourney()).toRouteString();
					for(int i=0;i<originJourney.length();i++){
						char c = originJourney.charAt(i);
						journey+= c;
						if(i<originJourney.length()-1)
							journey+="-->";
					}
					board.journeyLabel.setText(journey);
					if(train.isRunning()){
						board.trainstateBtn.setBackground(Color.GREEN);
						board.trainstateBtn.setText("Running");
					}else{
						board.trainstateBtn.setBackground(Color.RED);
						board.trainstateBtn.setText("Stoped");
					}
				}catch(InvalidTrainException ex){
					
				}
			}
		});
		
		board.comboBox_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if(board.comboBox_1.getSelectedItem()==null){
						throw new InvalidTrainException("Null selection");
					}
					int index = board.comboBox_1.getSelectedIndex();
					ArrayList<Train> trains = db.getTrainList();
					ArrayList<Journey> journeys = db.getJourneyList();
					//System.out.println(index);
					Train train = trains.get(index);
					String content = "<html>";
					content += "Train's name: ";
					content += train.getName();
					content += "<br><br>";
					content += "Train's speed: ";
					content += train.getSpeed();
					content += "<br><br>";
					content += "Has Journey?:";
					
					
					if(train.isAssigned()){
						content += "  Yes";
						content += "<br><br>";
						content += "Journey:";
						content += journeys.get(train.getJourney()).toRouteString();
						content += "<br><br>";
					}
					else{
						content += "  No";
						content += "<br><br>";
					}
					content += "</html>";
					
					board.trainMessage.setText(content);
				}catch(InvalidTrainException ex){
					
				}
			}
		});
		
		board.assignDriverBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if(board.trainComboBox.getSelectedItem()==null){
						throw new InvalidTrainException("Please select the train!");
					}
					else if(board.driverComboBox.getSelectedItem()== null){
						throw new InvalidTrainException("Please select the driver!");
					}
					ArrayList<Train> trains = db.getTrainList();
					ArrayList<Driver_> drivers = db.getDriverList();
					int trainIndex = board.trainComboBox.getSelectedIndex();
					int driverIndex = board.driverComboBox.getSelectedIndex();
					
					if(trains.get(trainIndex).hasDriver()){
						
						throw new InvalidTrainException("This train has been assigned before!");
					}
					if(drivers.get(driverIndex).hasTrain()){
						throw new InvalidTrainException("The driver has been assigned before!");
					}
					if(!trains.get(trainIndex).isAssigned()){
						throw new InvalidTrainException("This train has not been assigned to a route.Please assign first!");
					}
					
					trains.get(trainIndex).setDriver(driverIndex);
					drivers.get(driverIndex).setTrain(trainIndex);
					db.setDriverList(drivers);
					db.setTrainList(trains);
					JOptionPane.showMessageDialog(null,"OK!","Successful!",JOptionPane.PLAIN_MESSAGE);
					
				}catch(InvalidTrainException ex){
					JOptionPane.showMessageDialog(null,ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		this.board.assignBtnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					if((board.comboBox_1.getSelectedItem()==null)||(board.journeyComboBox.getSelectedItem()==null)){
						throw new InvalidTrainException("Refresh first!");
					}
					int trainIndex = board.comboBox_1.getSelectedIndex();
					int journeyIndex = board.journeyComboBox.getSelectedIndex();
					ArrayList<Train> trains = db.getTrainList();
					ArrayList<Journey> journeys = db.getJourneyList();
					
					if(trains.get(trainIndex).isAssigned()){
						throw new InvalidTrainException("This train has been assigned already!");
					}
					else{
						trains.get(trainIndex).setAssigned(journeyIndex);
						db.setTrainList(trains);
						JOptionPane.showMessageDialog(null,"OK!","Successful!",JOptionPane.PLAIN_MESSAGE);
					}
				}catch(InvalidTrainException ex){
					JOptionPane.showMessageDialog(null,ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		board.btnDriverLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try{
					String name = JOptionPane.showInputDialog("Plase input your name:", "");
					if(name.replace(" ", "").equals("")||name==null){
						throw new InvalidTrainException("Empty name.");
					}
					String password = JOptionPane.showInputDialog("And your password:", "");
					
					ArrayList<Driver_> drivers = db.getDriverList();
					Driver_ driver = new Driver_();
					boolean nameValid = false;
					for(Driver_ d: drivers){
						String driName = d.getName().replace(" ", "").replace("\r", "").replace("\n", "");
						if(driName.equals(name)){
							nameValid = true;
							if(!d.getPassword().equals(password)){
								throw new InvalidTrainException("Wrong password!");
							}
							else{
								driver = d;
								break;
							}
						}
					}
					if(nameValid ==false){
						throw new InvalidTrainException("This driver has not been registed!");
					}
					if(!driver.hasTrain()){
						throw new InvalidTrainException("The driver hasn't been assigned a train! Please assign first.");
					}
					JOptionPane.showMessageDialog(null,"OK!","Successful!",JOptionPane.PLAIN_MESSAGE);
					driverBoard = new DriverBoard(driver);
					driverBoard.setLocationRelativeTo(null);
					
					Train train = db.getTrainList().get(driver.getTrain());
					driverBoard.trainName.setText(train.getName());
					driverBoard.trainSpeed.setText(""+train.getSpeed());
					driverBoard.progressBar.setValue(train.getProcess());
					String journey = "";
					String originJourney = db.getJourneyList().get(train.getJourney()).toRouteString();
					driverBoard.currStationLbl.setText(""+train.getNextStation(train.getProcess(), originJourney));
					for(int i=0;i<originJourney.length();i++){
						char c = originJourney.charAt(i);
						journey+= c;
						if(i<originJourney.length()-1)
							journey+="-->";
					}
					trainIndex = driver.getTrain();
					driverBoard.journeyRoute.setText(journey);
					if(train.isRunning()){
						driverBoard.lblRunning.setText("Running");
						driverBoard.lblRunning.setBackground(Color.green);
						driverBoard.currStationLbl.setText(""+train.getNextStation(train.getProcess(), originJourney));
					}else{
						driverBoard.lblRunning.setText("Stoped");
						driverBoard.lblRunning.setBackground(Color.red);
						driverBoard.currStationLbl.setText(""+train.getNextStation(train.getProcess(), originJourney));
					}
					
					driverBoard.engineBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Train train = db.getTrainList().get(trainIndex);
							String originJourney = db.getJourneyList().get(train.getJourney()).toRouteString();
							String currStation = ""+train.getNextStation(train.getProcess(), originJourney);
							driverBoard.currStationLbl.setText(currStation);
							board.boardCurrStaLbl.setText(currStation);
							if(!train.isRunning()){
								if(train.getState() == true){
									train.run();
									
									driverBoard.lblRunning.setText("Running");
									driverBoard.lblRunning.setBackground(Color.green);
									board.trainstateBtn.setText("Running");
									board.trainstateBtn.setBackground(Color.green);
									timer = new Timer();
									timer.scheduleAtFixedRate(new Runner(trainIndex, db, driverBoard,board), 1000, 1000);
								}
								else if(train.getState() == false){
									driverBoard.lblRunning.setText("Stoped");
									driverBoard.lblRunning.setBackground(Color.red);
									timer.cancel();
									JOptionPane.showMessageDialog(null,"End","Warning!",JOptionPane.PLAIN_MESSAGE);
								}
							}
							else{
								train.terminate();
								timer.cancel();
								driverBoard.lblRunning.setText("Stoped");
								driverBoard.lblRunning.setBackground(Color.red);
								board.trainstateBtn.setText("Stoped");
								board.trainstateBtn.setBackground(Color.red);
								JOptionPane.showMessageDialog(null,"Cancel","Warning!",JOptionPane.PLAIN_MESSAGE);
							}
						}
					});
					
					
					driverBoard.update.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try{
								ArrayList<Driver_> drivers = db.getDriverList();
								String name = driverBoard.nameText.getText().replace(" ", "").replace("\r", "").replace("\n", "");
								boolean found = false;
								for(Driver_ d:drivers){
									if(name.equals(d.getName())){
										found = true;
										d.setAddress(driverBoard.address.getText());
										d.setAge((int)driverBoard.age.getValue());
										d.setPhone(driverBoard.phone.getText());
									}
									if(!driverBoard.passwordField.getText().replace(" ", "").replace("\r", "").replace("\n", "").equals("")){
										if(!driverBoard.passwordField.getText().equals(driverBoard.passwordField_1.getText())){
											throw new InvalidTrainException("The two input passwords are not the same!");
										}
										else if(driverBoard.passwordField.getText().length()<6){
											throw new InvalidTrainException("Password too simple!");
										}
										else {
											d.setPassword(driverBoard.passwordField.getText());
										}
									}
								}
								if(!found){
									throw new InvalidTrainException("You have no right to change the name!");
								}
								JOptionPane.showMessageDialog(null,"OK!","Successful!",JOptionPane.PLAIN_MESSAGE);
							}catch(InvalidTrainException ex){
								JOptionPane.showMessageDialog(null,ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
							}
						}
					});
					
				}catch(InvalidTrainException ex){
					JOptionPane.showMessageDialog(null,ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
				}catch(NullPointerException ex){
					JOptionPane.showMessageDialog(null,"Empty name.","Warning!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		board.engineResetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					Train train = db.getTrainList().get(trainIndex);
					String originJourney = db.getJourneyList().get(train.getJourney()).toRouteString();
					train.setProcess(0);
					String currStation = ""+train.getNextStation(train.getProcess(), originJourney);
					board.boardCurrStaLbl.setText(currStation);
					driverBoard.currStationLbl.setText(currStation);
					driverBoard.lblRunning.setText("Stoped");
					board.trainstateBtn.setText("Stoped");
					
					board.trainprogressBar.setValue(0);
					driverBoard.progressBar.setValue(0);
					
				}catch(Exception ex){
				}
			}
		});
		
		board.engineBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					Train train = db.getTrainList().get(trainIndex);
					String originJourney = db.getJourneyList().get(train.getJourney()).toRouteString();
					String currStation = ""+train.getNextStation(train.getProcess(), originJourney);
					board.boardCurrStaLbl.setText(currStation);
					driverBoard.currStationLbl.setText(currStation);
					if(!train.isRunning()){
						if(train.getState() == true){
							train.run();
							
							driverBoard.lblRunning.setText("Running");
							driverBoard.lblRunning.setBackground(Color.green);
							board.trainstateBtn.setText("Running");
							board.trainstateBtn.setBackground(Color.green);
							timer = new Timer();
							timer.scheduleAtFixedRate(new Runner(trainIndex, db, driverBoard,board), 1000, 1000);
						}
						else if(train.getState() == false){
							driverBoard.lblRunning.setText("Stoped");
							driverBoard.lblRunning.setBackground(Color.red);
							timer.cancel();
							JOptionPane.showMessageDialog(null,"End","Warning!",JOptionPane.PLAIN_MESSAGE);
						}
					}
					else{
						train.terminate();
						timer.cancel();
						driverBoard.lblRunning.setText("Stoped");
						driverBoard.lblRunning.setBackground(Color.red);
						board.trainstateBtn.setText("Stoped");
						board.trainstateBtn.setBackground(Color.red);
						JOptionPane.showMessageDialog(null,"Cancel","Warning!",JOptionPane.PLAIN_MESSAGE);
					}
					
				}catch(Exception ex){
				}
			}
		});
		
		this.board.btnCheckNextStation.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try{
					String nextStationCheck = board.nextTrainToCheck.getText();
					if(nextStationCheck.length()!=1){
						throw new InvalidTrainException("You should only input one character of station name.");
					}
					Vector<Character> states = graph.getAllStates();
					boolean valid = false;
					for(Character c:states){
						if(nextStationCheck.charAt(0)==(c)){
							valid = true;
						}
					}
					if(!valid){
						throw new InvalidTrainException("You should only input station name existed in the graph.");
					}
					
					ArrayList<Train> trains = db.getTrainList();
					ArrayList<Train> trainRes = new ArrayList<Train>();
					for(Train t:trains){
						if(t.getNextStation()==nextStationCheck.charAt(0)){
							trainRes.add(t);
						}
					}
					String result;
					if(trainRes.size()==0){
						result = "There's no upcoming train at this station!";
					}
					else{
						result = "There's "+trainRes.size()+" upcoming trains at this station.\n";
						for(Train t:trainRes){
							result+="------------------------------------"+"\n";
							result+="Name: "+t.getName()+"\n";
							result+="Speed: "+t.getSpeed()+"\n";
						}
					}
					JOptionPane.showMessageDialog(null,result,"Successful!",JOptionPane.PLAIN_MESSAGE);
				}catch(InvalidTrainException ex){
					JOptionPane.showMessageDialog(null,ex.getMessage(),"Warning!",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		
		this.board.frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("hhhhhhh");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				db.writeFile();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
//		Robot robot = null;
//		try {
//			robot = new Robot();
//		} catch (AWTException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
	}
	
	
}
