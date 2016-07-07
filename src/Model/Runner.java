package Model;

import java.util.TimerTask;

import System.Board;
import System.Database;
import System.DriverBoard;
import System.InvalidTrainException;

/**
 * This Runner class control train's running task.
 * @author Raoqi
 * */
public class Runner extends TimerTask{
	private int trainIndex;
	private Database db;
	private DriverBoard dvb;
	private Board bd;

	public Runner(int trainIndex, Database db, DriverBoard dvb,Board bd){
		this.trainIndex = trainIndex;
		this.db = db;
		this.dvb = dvb;
		this.bd = bd;
	}
	/**
	 * To run a train.
	 * */
	public void run(){
		Train train = db.getTrainList().get(trainIndex);
		int curr = train.getProcess();
		
		if(curr > 100){
			train.stop();
			this.cancel();
		}
		else{
			train.start();
			curr = train.getProcess()+1;
			train.setProcess(curr);
			dvb.progressBar.setValue(curr);
			bd.trainprogressBar.setValue(curr);
		}
	}
	
}
