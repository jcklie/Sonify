package com.bragi.sonify;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI(){
		initComponents();
	}
	
	/**
	 * build gui
	 */
	private void initComponents() {
		setTitle("BragiSoft - Sonify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));
		contentPane.add(inputField);
		contentPane.add(inputButton);
		contentPane.add(outputField);
		contentPane.add(outputButton);
		contentPane.add(genreChooser);
		contentPane.add(startSonification);
		pack();
	}

	private JPanel contentPane;
	private JTextField inputField = new JTextField();
	private JTextField outputField = new JTextField();
	private String[] genres = { "Drama", "Kinderbuch", "Lyrik", "Roman", "Sachbuch" };
	private JComboBox<String> genreChooser = new JComboBox<String>(genres);
	private JButton inputButton = new JButton("Eingabedatei auswählen");
	private JButton outputButton = new JButton("Ausgabedatei auswählen");
	private JButton startSonification = new JButton("Audifizierung starten");
}

