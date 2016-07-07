package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.print.DocFlavor.URL;
import javax.swing.*;

import Model.Driver_;

import javax.swing.border.TitledBorder;
/**
 * Main GUI of driver board.
 * @author Raoqi
 * */
public class DriverBoard extends JFrame{
	JTextField text = null;
	JTextField nameText;
	JPasswordField passwordField;
	JPasswordField passwordField_1;
	JSpinner age = new JSpinner();
	JButton update = new JButton("Update");
	JTextField phone;
	JTextField address;
	JLabel trainName = new JLabel("");
	JLabel trainSpeed = new JLabel("");
	JLabel journeyRoute = new JLabel("");
	JLabel currStationLbl = new JLabel("");
	JButton engineBtn = new JButton("");
	public JProgressBar progressBar = new JProgressBar();
	public JButton lblRunning = new JButton("Running");
	
 	public DriverBoard(Driver_ d){
		super("DRIVER_BOARD");
		JPanel panel = new JPanel();
			panel.setLayout(null);
		this.setContentPane(panel);
				
		this.setSize(888,530);
		this.setResizable(false);
		this.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Edit Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 13, 355, 470);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTrainsName = new JLabel("Name:");
		lblTrainsName.setBounds(12, 31, 210, 39);
		panel_1.add(lblTrainsName);
		lblTrainsName.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		
		nameText = new JTextField();
		nameText.setBounds(88, 31, 242, 39);
		panel_1.add(nameText);
		
		nameText.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		nameText.setLayout(new GridLayout(1,1));
		
		nameText.setText(d.getName());
		
		JLabel lblAge = new JLabel("Age:\r\n\r\n");
		lblAge.setBounds(12, 93, 108, 39);
		panel_1.add(lblAge);
		lblAge.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		age.setBounds(88, 93, 242, 39);
		panel_1.add(age);
		
		
		age.setModel(new SpinnerNumberModel(16, null, 200, 1));
		age.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		age.setValue(d.getAge());
		
		JLabel textPhone = new JLabel("Phone:");
		textPhone.setBounds(12, 159, 74, 39);
		panel_1.add(textPhone);
		textPhone.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		
		phone = new JTextField();
		phone.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		phone.setBounds(88, 159, 242, 39);
		panel_1.add(phone);
		phone.setText(d.getPhone());
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 216, 74, 39);
		panel_1.add(lblAddress);
		lblAddress.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		
		address = new JTextField();
		address.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		address.setBounds(88, 216, 242, 39);
		panel_1.add(address);
		address.setText(d.getAddress());
		update.setBounds(12, 413, 332, 39);
		panel_1.add(update);
		
		
		update.setBackground(Color.GREEN);
		update.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		
		JLabel lblPassword = new JLabel("Password:\r\n\r\n");
		lblPassword.setBounds(12, 276, 74, 39);
		panel_1.add(lblPassword);
		lblPassword.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 276, 242, 39);
		panel_1.add(passwordField);
		
		JLabel lblConfirm = new JLabel("Confirm:\r\n\r\n");
		lblConfirm.setBounds(12, 337, 74, 39);
		panel_1.add(lblConfirm);
		lblConfirm.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(88, 337, 242, 39);
		panel_1.add(passwordField_1);
		
		JLabel lblStayEmptyIf = new JLabel("(Stay empty if not to change.)");
		lblStayEmptyIf.setFont(new Font("Tekton Pro", Font.PLAIN, 14));
		lblStayEmptyIf.setBounds(88, 389, 228, 15);
		panel_1.add(lblStayEmptyIf);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Train Operation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(379, 13, 491, 460);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTrainsName_1 = new JLabel("Train's name:");
		lblTrainsName_1.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblTrainsName_1.setBounds(12, 33, 98, 39);
		panel_2.add(lblTrainsName_1);
		
		
		trainName.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		trainName.setBounds(122, 33, 338, 39);
		panel_2.add(trainName);
		
		JLabel lblTrainsSpeed = new JLabel("Train's speed:");
		lblTrainsSpeed.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblTrainsSpeed.setBounds(12, 74, 98, 39);
		panel_2.add(lblTrainsSpeed);
		
		trainSpeed.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		trainSpeed.setBounds(122, 74, 98, 39);
		panel_2.add(trainSpeed);
		
		JLabel labelRoute = new JLabel("Journey route:");
		labelRoute.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		labelRoute.setBounds(12, 115, 98, 39);
		panel_2.add(labelRoute);
		
		
		journeyRoute.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		journeyRoute.setBounds(122, 115, 357, 39);
		panel_2.add(journeyRoute);
		progressBar.setForeground(Color.GREEN);
		
		progressBar.setValue(30);
		progressBar.setBounds(23, 278, 437, 39);
		panel_2.add(progressBar);
		
		JLabel lblSstart = new JLabel("S(Start)");
		lblSstart.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblSstart.setBounds(12, 320, 98, 39);
		panel_2.add(lblSstart);
		
		JLabel lblSend = new JLabel("S(End)");
		lblSend.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblSend.setBounds(422, 320, 98, 39);
		panel_2.add(lblSend);
		
		
		lblRunning.setBackground(Color.GREEN);
		lblRunning.setForeground(Color.BLACK);
		lblRunning.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblRunning.setBounds(145, 191, 192, 50);
		panel_2.add(lblRunning);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 254, 439, 2);
		panel_2.add(separator);
		
		JLabel lblState = new JLabel("Next station:");
		lblState.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblState.setBounds(12, 157, 149, 39);
		panel_2.add(lblState);
		
		java.net.URL url = DriverBoard.class.getResource("/image/engine.jpg");
		
		engineBtn.setIcon(new ImageIcon(url));
		
		engineBtn.setBounds(188, 343, 104, 104);
		panel_2.add(engineBtn);
		
		
		currStationLbl.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		currStationLbl.setBounds(132, 157, 98, 39);
		panel_2.add(currStationLbl);
 	}
}
