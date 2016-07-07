package System;

import java.awt.Color;
import java.awt.EventQueue;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.DocFlavor.URL;
import javax.swing.*;
/**
 * Map window GUI.
 * @author Raoqi
 * */
public class MapWindow extends JFrame{
	JButton ok;
	JTextField text = null;
	
 	public MapWindow(){
		super("MAP");
		//this.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
			panel.setLayout(null);
		this.setContentPane(panel);
		//clear.addActionListener(this);
				ok=new JButton("OK");
				ok.setBounds(0, 592, 961, 39);
				panel.add(ok);
				ok.setBackground(Color.GREEN);
				ok.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
				ok.setLayout(new GridLayout(1,3));
				
				JLabel map = new JLabel("");
				java.net.URL url = MapWindow.class.getResource("/image/route.PNG");
				map.setIcon(new ImageIcon(url));
				map.setBounds(12, 13, 949, 566);
				panel.add(map);
		this.setSize(959,666);
		this.setResizable(false);
		this.setVisible(true);
		
 	}
 	
}
