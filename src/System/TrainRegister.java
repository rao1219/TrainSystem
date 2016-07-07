package System;

import java.awt.Color;
import java.awt.EventQueue;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
/**
 * Train register GUI.
 * @author Raoqi
 */
public class TrainRegister extends JFrame{

	JButton reset;
	JButton ok;
	JTextField text = null;
	JProgressBar progressBar = new JProgressBar();
	JSpinner spinner = new JSpinner();
	private JComboBox trainType;
	JSlider slider = new JSlider();
	
 	public TrainRegister(){
		super("TRAIN_REGISTER");
		JPanel panel = new JPanel();
			panel.setLayout(null);
		this.setContentPane(panel);
		text = new JTextField();
		text.setText("TRAIN");
		text.setLocation(108, 23);
		panel.add(text);
		text.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		text.setLayout(new GridLayout(1,1));
		text.setSize(673,39);
		reset = new JButton("RESET");
		reset.setBounds(411, 222, 370, 39);
		panel.add(reset);
		reset.setBackground(Color.YELLOW);
		reset.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		reset.setLayout(new GridLayout(1,1));
		progressBar.setForeground(new Color(51, 153, 255));
		//clear.addActionListener(this);
		progressBar.setValue(450);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				progressBar.setValue((int) spinner.getValue());
				slider.setValue((int) spinner.getValue());
			}
		});
		spinner.setValue(450);
				ok=new JButton("OK");
				ok.setBounds(12, 222, 370, 39);
				panel.add(ok);
				ok.setBackground(Color.GREEN);
				ok.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				ok.setLayout(new GridLayout(1,3));
				
				JLabel lblTrainsName = new JLabel("Train's name:");
				lblTrainsName.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblTrainsName.setBounds(12, 23, 769, 39);
				panel.add(lblTrainsName);
				
				JLabel lblDriversName = new JLabel("Train type:");
				lblDriversName.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblDriversName.setBounds(12, 77, 769, 39);
				panel.add(lblDriversName);
				
				trainType = new JComboBox();
				trainType.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(trainType.getSelectedIndex() ==0){
							progressBar.setValue(450);
							spinner.setValue(450);
						}
						if(trainType.getSelectedIndex() ==1){
							progressBar.setValue(400);
							spinner.setValue(400);
						}
						if(trainType.getSelectedIndex() ==2){
							progressBar.setValue(300);
							spinner.setValue(300);
						}
						if(trainType.getSelectedIndex() ==3){
							progressBar.setValue(150);
							spinner.setValue(150);
						}
						
					}
				});
				trainType.setModel(new DefaultComboBoxModel(new String[] {"CRH2C high-speed train", "CRH3 hign-speed train", "RHSS middle-speed train", "XX125 low-speed train"}));
				trainType.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				trainType.setBounds(108, 77, 673, 39);
				panel.add(trainType);
				
				JLabel lblTrainSpeed = new JLabel("Train speed:");
				lblTrainSpeed.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblTrainSpeed.setBounds(12, 129, 95, 39);
				panel.add(lblTrainSpeed);
				
				
				progressBar.setMaximum(500);
				progressBar.setBackground(Color.WHITE);
				progressBar.setBounds(108, 129, 554, 39);
				panel.add(progressBar);
				
				spinner.setModel(new SpinnerNumberModel(0, 0, 500, 1));
				spinner.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				spinner.setBounds(674, 129, 58, 39);
				panel.add(spinner);
				
				JLabel lblKmh = new JLabel("km/h");
				lblKmh.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblKmh.setBounds(744, 123, 49, 45);
				panel.add(lblKmh);
				
				
				slider.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						spinner.setValue((int)slider.getValue());
					}
				});
				slider.setMaximum(500);
				slider.setBounds(12, 181, 769, 26);
				panel.add(slider);
		this.setSize(799,309);
		this.setResizable(false);
		this.setVisible(true);
 	}
}
