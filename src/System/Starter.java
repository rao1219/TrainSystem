package System;

import java.awt.EventQueue;

import Model.Graph;

/**
 * This class is to launch the whole system.
 * */
public class Starter {
	public static void main(String[] args) {
		
		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Action act = new Action(new Board(),new Graph(),new Database());
					act.actionToDo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
