package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 * GUI of Driver register board.
 * @author Raoqi
 * */
public class DriverRegister extends JFrame{
	JTextField text = null;
	JTextField nameText;
	JPasswordField passwordField;
	JPasswordField passwordField_1;
	JSpinner age = new JSpinner();
	JRadioButton rdbtnMan = new JRadioButton("Man");
	JRadioButton rdbtnWoman = new JRadioButton("Madam");
	JButton regist = new JButton("Regist");
	JCheckBox chckbxNewCheckBox = new JCheckBox("I agree to the terms of Train System.");
	JTextField phone;
	JTextField address;
	
 	public DriverRegister(){
		super("DRIVER_REGISTER");
		JPanel panel = new JPanel();
			panel.setLayout(null);
		this.setContentPane(panel);
		nameText = new JTextField();
		nameText.setLocation(88, 23);
		panel.add(nameText);
		nameText.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		nameText.setLayout(new GridLayout(1,1));
		nameText.setSize(242,39);
				
				JLabel lblTrainsName = new JLabel("Name:");
				lblTrainsName.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblTrainsName.setBounds(12, 23, 210, 39);
				panel.add(lblTrainsName);
				
				JLabel lblSex = new JLabel("Gender:\r\n");
				lblSex.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblSex.setBounds(12, 75, 108, 39);
				panel.add(lblSex);
				rdbtnMan.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				rdbtnMan.setBounds(88, 82, 60, 25);
				panel.add(rdbtnMan);
				
				rdbtnWoman.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				rdbtnWoman.setBounds(174, 82, 83, 25);
				panel.add(rdbtnWoman);
				
				ButtonGroup group = new ButtonGroup();
				group.add(rdbtnMan);
				group.add(rdbtnWoman);
				
				JLabel lblAge = new JLabel("Age:\r\n\r\n");
				lblAge.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblAge.setBounds(12, 127, 108, 39);
				panel.add(lblAge);
				
				
				
				age.setModel(new SpinnerNumberModel(16, null, 200, 1));
				age.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				age.setBounds(88, 127, 242, 39);
				panel.add(age);
				
				
				regist.setBackground(Color.GREEN);
				regist.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				regist.setBounds(12, 479, 332, 39);
				panel.add(regist);
				
				JLabel lblPassword = new JLabel("Password:\r\n\r\n");
				lblPassword.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblPassword.setBounds(12, 188, 74, 39);
				panel.add(lblPassword);
				
				passwordField = new JPasswordField();
				passwordField.setBounds(88, 188, 242, 39);
				panel.add(passwordField);
				
				JLabel lblConfirm = new JLabel("Confirm:\r\n\r\n");
				lblConfirm.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblConfirm.setBounds(12, 249, 74, 39);
				panel.add(lblConfirm);
				
				passwordField_1 = new JPasswordField();
				passwordField_1.setBounds(88, 249, 242, 39);
				panel.add(passwordField_1);
				

				chckbxNewCheckBox.setFont(new Font("Tekton Pro", Font.PLAIN, 14));
				chckbxNewCheckBox.setBounds(35, 431, 283, 25);
				panel.add(chckbxNewCheckBox);
				
				JLabel textPhone = new JLabel("Phone:");
				textPhone.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				textPhone.setBounds(12, 311, 74, 39);
				panel.add(textPhone);
				
				phone = new JTextField();
				phone.setBounds(88, 311, 242, 39);
				panel.add(phone);
				
				JLabel lblAddress = new JLabel("Address:");
				lblAddress.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				lblAddress.setBounds(12, 368, 74, 39);
				panel.add(lblAddress);
				
				address = new JTextField();
				address.setBounds(88, 368, 242, 39);
				panel.add(address);
		this.setSize(362,577);
		this.setResizable(false);
		this.setVisible(true);
 	}
}
