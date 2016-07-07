package System;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Font;
import java.net.URL;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JSlider;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Label;
import javax.swing.JProgressBar;

/**
 * Main board's GUI codes.
 * @author Raoqi
 * */
public class Board {

	JFrame frame;
	JPanel contentPanel = new JPanel();
	CardLayout cl_contentPanel = new CardLayout(0,0);
	JButton btnClose = new JButton("Close");
	JTextField routeStr;
	JButton addJourneyBtn = new JButton("Add");
	JButton resJourneyBtn = new JButton("Reset");
	DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel();
	DefaultComboBoxModel<String> trainModel = new DefaultComboBoxModel();
	
	DefaultComboBoxModel<String> traininfoModel = new DefaultComboBoxModel();
	DefaultComboBoxModel<String> driverinfoModel = new DefaultComboBoxModel();
	DefaultComboBoxModel<String> statusinfoModel = new DefaultComboBoxModel();
	JButton refreshBtn = new JButton("Refresh");
	JLabel timetableText = new JLabel("");
	JComboBox journeyComboBox = new JComboBox();
	JButton assignBtnOk = new JButton("");
	JPanel trainPanel = new JPanel();
	JButton btnNewTrainRegister = new JButton("<html>\r\n<center>\r\nTrain\r\n<br>\r\n<br>\r\nRegister\r\n</center>\r\n</html>");
	JButton MapBtn = new JButton("<html>\r\n<center>\r\nCheck\r\n<br>\r\n<br>\r\nMap\r\n</center>\r\n</html>");
	JButton refreshTrain = new JButton("Refresh");
	JLabel trainMessage = new JLabel("");
	JComboBox comboBox_1 = new JComboBox();
	private final JPanel panel_2 = new JPanel();
	JLabel trainInforLabel = new JLabel("");
	JPanel panel_3 = new JPanel();
	JLabel driverInfoLabel = new JLabel("");
	JComboBox trainComboBox = new JComboBox();
	JButton assignDriverBtn = new JButton("");
	JButton trainInfoRefreshBtn = new JButton("Refresh");
	JComboBox driverComboBox = new JComboBox();
	JButton driverRefreshBtn = new JButton("Refresh");
	JButton btnDriverRegister = new JButton("<html>\r\n<center>\r\nDriver\r\n<br>\r\n<br>\r\nRegister\r\n</center>\r\n</html>");
	JButton btnDriverLogin = new JButton("<html>\r\n<center>\r\nDriver\r\n<br>\r\n<br>\r\nLogin\r\n</center>\r\n</html>");
	JComboBox statuscomboBox = new JComboBox();
	JButton statusRefreshBtn = new JButton("Refresh");
	private final JPanel panel_6 = new JPanel();
	private final JLabel lblNewLabel_2 = new JLabel("Name:");
	JLabel driverNameLabel = new JLabel("");
	JLabel driverAgeLabel = new JLabel("");
	private final JLabel lblAge = new JLabel("Age:");
	JLabel driverPhoneLabel = new JLabel("");
	private final JLabel lblPhone = new JLabel("Phone:");
	JLabel driverAddressLabel = new JLabel("");
	private final JLabel lblAddress = new JLabel("Address:");
	private final JPanel panel_7 = new JPanel();
	private final JLabel label = new JLabel("Name:");
	JLabel trainNameLabel = new JLabel("");
	private final JLabel lblSpeed = new JLabel("Speed:");
	JLabel trainSpeedLabel = new JLabel("");
	private final JPanel panel_8 = new JPanel();
	JButton trainstateBtn = new JButton("Stoped");
	public JProgressBar trainprogressBar = new JProgressBar();
	public JLabel boardCurrStaLbl = new JLabel("");
	public JButton engineResetBtn = new JButton("");
	JButton engineBtn = new JButton("");
	JLabel journeyLabel = new JLabel("");
	public JTextField nextTrainToCheck;
	public JButton btnCheckNextStation = new JButton("check");
	
	/**
	 * Create the application.
	 */
	public Board() {
		initialize();
		this.frame.setVisible(true);
		this.frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1147, 798);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("TRAIN_SYSTEM");
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		controlPanel.setBounds(12, 13, 1112, 42);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		final JButton journeyButton = new JButton("Journey");
		journeyButton.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		journeyButton.setBackground(Color.MAGENTA);
		
		
		controlPanel.add(journeyButton);
		
		final JButton trainButton = new JButton("Train");
		trainButton.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		trainButton.setBackground(Color.GREEN);
		controlPanel.add(trainButton);
		
		final JButton driverButton = new JButton("Driver");
		driverButton.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		
		driverButton.setBackground(Color.GREEN);
		controlPanel.add(driverButton);
		
		final JButton statusBtn = new JButton("Status");
		statusBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		
		statusBtn.setBackground(Color.GREEN);
		controlPanel.add(statusBtn);
		btnClose.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		
			btnClose.setBackground(Color.LIGHT_GRAY);
			controlPanel.add(btnClose);
			
			journeyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					journeyButton.setBackground(Color.MAGENTA);
					trainButton.setBackground(Color.GREEN);
					driverButton.setBackground(Color.GREEN);
					statusBtn.setBackground(Color.GREEN);
					cl_contentPanel.show(contentPanel,"journey");
				}
			});
			
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl_contentPanel.show(contentPanel, "empty");
					trainButton.setBackground(Color.GREEN);
					journeyButton.setBackground(Color.GREEN);
					driverButton.setBackground(Color.GREEN);
					statusBtn.setBackground(Color.GREEN);
					
				}
			});
			
			trainButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					trainButton.setBackground(Color.MAGENTA);
					journeyButton.setBackground(Color.GREEN);
					driverButton.setBackground(Color.GREEN);
					cl_contentPanel.show(contentPanel,"deposit");
					statusBtn.setBackground(Color.GREEN);
				}
			});
			
			driverButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					driverButton.setBackground(Color.MAGENTA);
					trainButton.setBackground(Color.GREEN);
					journeyButton.setBackground(Color.GREEN);
					statusBtn.setBackground(Color.GREEN);
					cl_contentPanel.show(contentPanel,"withdraw");
				}
			});
			
			statusBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					statusBtn.setBackground(Color.MAGENTA);
					trainButton.setBackground(Color.GREEN);
					journeyButton.setBackground(Color.GREEN);
					driverButton.setBackground(Color.green);
					cl_contentPanel.show(contentPanel,"status");
				}
			});
		
		
		contentPanel.setBounds(12, 79, 1112, 677);
		frame.getContentPane().add(contentPanel);
		
		contentPanel.setLayout(cl_contentPanel);
		
		JPanel jouneyPanel = new JPanel();
		jouneyPanel.setBackground(Color.WHITE);
		contentPanel.add(jouneyPanel, "journey");
		
		trainPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Train management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(trainPanel, "deposit");
		trainPanel.setLayout(null);
		
		
		journeyComboBox.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		
		journeyComboBox.setModel(comboBoxModel);
		journeyComboBox.setBounds(104, 539, 306, 48);
		trainPanel.add(journeyComboBox);
		
		
		
		refreshBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		refreshBtn.setBackground(Color.MAGENTA);
		refreshBtn.setBounds(104, 600, 306, 48);
		trainPanel.add(refreshBtn);
		
		
		comboBox_1.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		comboBox_1.setBounds(617, 539, 306, 48);
		comboBox_1.setModel(trainModel);
		trainPanel.add(comboBox_1);
		
		
		
		refreshTrain.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		refreshTrain.setBackground(Color.MAGENTA);
		refreshTrain.setBounds(617, 600, 306, 48);
		trainPanel.add(refreshTrain);
		
		
		URL url = Board.class.getResource("/image/assign.png");
		jouneyPanel.setLayout(null);
		assignBtnOk.setIcon(new ImageIcon(url));
		assignBtnOk.setBounds(460, 564, 125, 63);
		trainPanel.add(assignBtnOk);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Timetable", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(104, 35, 306, 479);
		trainPanel.add(panel);
		panel.setLayout(null);
		timetableText.setFont(new Font("Tekton Pro", Font.PLAIN, 17));
		
		
		timetableText.setBounds(12, 28, 282, 438);
		panel.add(timetableText);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Train Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(617, 35, 306, 479);
		trainPanel.add(panel_1);
		panel_1.setLayout(null);
		trainMessage.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		trainMessage.setBounds(12, 26, 282, 440);
		
		panel_1.add(trainMessage);
		
		
		btnNewTrainRegister.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		btnNewTrainRegister.setBackground(Color.GREEN);
		btnNewTrainRegister.setBounds(970, 46, 115, 175);
		trainPanel.add(btnNewTrainRegister);
		
		
		MapBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		MapBtn.setBackground(Color.GREEN);
		MapBtn.setBounds(970, 264, 115, 175);
		trainPanel.add(MapBtn);
		
		
		JLabel lblNewLabel = new JLabel("");
		URL url2 = Board.class.getResource("/image/route.PNG");
		jouneyPanel.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(url2));
		lblNewLabel.setBounds(56, 53, 973, 580);
		jouneyPanel.add(lblNewLabel);
		
		routeStr = new JTextField();
		routeStr.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		routeStr.setBounds(253, 646, 529, 31);
		jouneyPanel.add(routeStr);
		routeStr.setColumns(10);
		
		JLabel lblAddNewJourney = new JLabel("Add new Journey here:");
		lblAddNewJourney.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblAddNewJourney.setBounds(87, 653, 154, 16);
		jouneyPanel.add(lblAddNewJourney);
		
		
		addJourneyBtn.setBackground(Color.GREEN);
		addJourneyBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		addJourneyBtn.setBounds(816, 646, 97, 25);
		jouneyPanel.add(addJourneyBtn);
		resJourneyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				routeStr.setText("");
			}
		});
		
		
		resJourneyBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		resJourneyBtn.setBackground(Color.ORANGE);
		resJourneyBtn.setBounds(932, 646, 97, 25);
		jouneyPanel.add(resJourneyBtn);
		
		JLabel lblUpcomingTrainsOf = new JLabel("Check upcoming trains of Station:");
		lblUpcomingTrainsOf.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblUpcomingTrainsOf.setBounds(607, 20, 221, 16);
		jouneyPanel.add(lblUpcomingTrainsOf);
		
		nextTrainToCheck = new JTextField();
		nextTrainToCheck.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		nextTrainToCheck.setColumns(10);
		nextTrainToCheck.setBounds(840, 13, 63, 31);
		jouneyPanel.add(nextTrainToCheck);
		
		
		btnCheckNextStation.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		btnCheckNextStation.setBackground(Color.GREEN);
		btnCheckNextStation.setBounds(932, 15, 97, 25);
		jouneyPanel.add(btnCheckNextStation);
		
		JPanel driverPanel = new JPanel();
		driverPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Driver management", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(driverPanel, "withdraw");
		driverPanel.setLayout(null);
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Train Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(108, 35, 306, 479);
		
		driverPanel.add(panel_2);
		trainInforLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 17));
		trainInforLabel.setBounds(12, 28, 282, 438);
		
		panel_2.add(trainInforLabel);
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Driver Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(621, 35, 306, 479);
		
		driverPanel.add(panel_3);
		driverInfoLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		driverInfoLabel.setBounds(12, 26, 282, 440);
		
		panel_3.add(driverInfoLabel);
		trainComboBox.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		trainComboBox.setBounds(108, 539, 306, 48);
		trainComboBox.setModel(traininfoModel);
		
		driverPanel.add(trainComboBox);
		assignDriverBtn.setBounds(466, 564, 125, 63);
		url = Board.class.getResource("/image/assign.png");
		
		assignDriverBtn.setIcon(new ImageIcon(url));
		assignDriverBtn.setBounds(460, 564, 125, 63);
		
		driverPanel.add(assignDriverBtn);
		trainInfoRefreshBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		trainInfoRefreshBtn.setBackground(Color.MAGENTA);
		trainInfoRefreshBtn.setBounds(108, 600, 306, 48);
		
		driverPanel.add(trainInfoRefreshBtn);
		driverComboBox.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		driverComboBox.setBounds(621, 539, 306, 48);
		driverComboBox.setModel(driverinfoModel);
		
		driverPanel.add(driverComboBox);
		driverRefreshBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		driverRefreshBtn.setBackground(Color.MAGENTA);
		driverRefreshBtn.setBounds(621, 600, 306, 48);
		
		driverPanel.add(driverRefreshBtn);
		
		
		btnDriverRegister.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		btnDriverRegister.setBackground(Color.GREEN);
		btnDriverRegister.setBounds(970, 47, 115, 175);
		driverPanel.add(btnDriverRegister);
		
		
		btnDriverLogin.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		btnDriverLogin.setBackground(Color.GREEN);
		btnDriverLogin.setBounds(970, 271, 115, 175);
		driverPanel.add(btnDriverLogin);
		
		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new TitledBorder(null, "Check status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(statusPanel, "status");
		statusPanel.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 13, 1088, 635);
		statusPanel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Train Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(12, 83, 1064, 552);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "Driver Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(36, 34, 396, 221);
		
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		lblNewLabel_2.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(23, 37, 56, 25);
		
		panel_6.add(lblNewLabel_2);
		driverNameLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		driverNameLabel.setBounds(91, 37, 271, 25);
		
		panel_6.add(driverNameLabel);
		driverAgeLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		driverAgeLabel.setBounds(91, 82, 271, 25);
		
		panel_6.add(driverAgeLabel);
		lblAge.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblAge.setBounds(23, 82, 56, 25);
		
		panel_6.add(lblAge);
		driverPhoneLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		driverPhoneLabel.setBounds(91, 120, 271, 25);
		
		panel_6.add(driverPhoneLabel);
		lblPhone.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblPhone.setBounds(23, 120, 56, 25);
		
		panel_6.add(lblPhone);
		driverAddressLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		driverAddressLabel.setBounds(91, 158, 271, 25);
		
		panel_6.add(driverAddressLabel);
		lblAddress.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblAddress.setBounds(23, 158, 56, 25);
		
		panel_6.add(lblAddress);
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Train Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(36, 296, 396, 221);
		
		panel_5.add(panel_7);
		label.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		label.setBounds(23, 37, 56, 25);
		
		panel_7.add(label);
		trainNameLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		trainNameLabel.setBounds(91, 37, 271, 25);
		
		panel_7.add(trainNameLabel);
		lblSpeed.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblSpeed.setBounds(23, 75, 56, 25);
		
		panel_7.add(lblSpeed);
		trainSpeedLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		trainSpeedLabel.setBounds(91, 75, 271, 25);
		
		panel_7.add(trainSpeedLabel);
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operation Board", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(458, 34, 594, 483);
		
		panel_5.add(panel_8);
		
		JLabel label_1 = new JLabel("Journey route:");
		label_1.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		label_1.setBounds(36, 40, 172, 39);
		panel_8.add(label_1);
		
		
		journeyLabel.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		journeyLabel.setBounds(146, 40, 436, 39);
		panel_8.add(journeyLabel);
		
		JLabel lblCurrentStation = new JLabel("Next station:");
		lblCurrentStation.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		lblCurrentStation.setBounds(36, 71, 112, 39);
		panel_8.add(lblCurrentStation);
		
		
		trainstateBtn.setForeground(Color.BLACK);
		trainstateBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		trainstateBtn.setBackground(Color.RED);
		trainstateBtn.setBounds(170, 106, 299, 50);
		panel_8.add(trainstateBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(45, 179, 537, 2);
		panel_8.add(separator);
		trainprogressBar.setForeground(Color.GREEN);
		trainprogressBar.setBounds(47, 203, 535, 39);
		panel_8.add(trainprogressBar);
		
		url = DriverBoard.class.getResource("/image/engine_big.jpg");
		engineBtn.setIcon(new ImageIcon(url));
		engineBtn.setBounds(107, 308, 148, 148);
		panel_8.add(engineBtn);
		
		boardCurrStaLbl.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		boardCurrStaLbl.setBounds(146, 71, 143, 39);
		panel_8.add(boardCurrStaLbl);
		
		url = DriverBoard.class.getResource("/image/reset.jpg");
		engineResetBtn.setIcon(new ImageIcon(url));
		engineResetBtn.setBounds(351, 308, 148, 148);
		panel_8.add(engineResetBtn);
		
		JLabel lblNewLabel_1 = new JLabel("Select train:");
		lblNewLabel_1.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(12, 42, 115, 16);
		panel_4.add(lblNewLabel_1);
		
		
		statuscomboBox.setFont(new Font("Tekton Pro", Font.PLAIN, 16));
		statuscomboBox.setBounds(147, 22, 764, 48);
		statuscomboBox.setModel(statusinfoModel);
		panel_4.add(statuscomboBox);
		statusRefreshBtn.setBounds(941, 21, 135, 48);
		panel_4.add(statusRefreshBtn);
		statusRefreshBtn.setFont(new Font("Tekton Pro", Font.PLAIN, 18));
		statusRefreshBtn.setBackground(Color.MAGENTA);
		
		JPanel emptyPanel = new JPanel();
		emptyPanel.setBounds(0, 0, 10, 10);
		contentPanel.add(emptyPanel,"empty");
		
	}
}
