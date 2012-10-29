package com.bragi.sonify;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;

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

	public GUI() {
		initComponents();
	}

	/**
	 * build gui
	 */
	private void initComponents() {
		// *************************************
		// set frame preferences
		// *************************************
		setTitle("BragiSoft - Sonify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));
		contentPane.add(inputField);
		contentPane.add(inputButton);
		contentPane.add(outputField);
		contentPane.add(outputButton);
		contentPane.add(genreChooser);
		contentPane.add(startSonificationButton);
		pack();

		// *************************************
		// listener
		// *************************************
		inputButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inputButtonActionPerformed();
			}
		});

		outputButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				outputButtonActionPerformed();
			}
		});

		startSonificationButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startSonificationButtonActionPerformed();
			}
		});
	}

	// *************************************
	// action-performed methods
	// *************************************
	private void inputButtonActionPerformed() {
		inputFile = new FileChooser(this).inputFile();
		inputField.setText(inputFile.getAbsolutePath());
	}

	private void outputButtonActionPerformed() {
		outputFile = new FileChooser(this).outputFile();
		outputField.setText(outputFile.getAbsolutePath());
	}

	private void startSonificationButtonActionPerformed() {
		//
	}

	// *************************************
	// variables, components, etc.
	// *************************************
	private JPanel contentPane;
	private JTextField inputField = new JTextField();
	private JTextField outputField = new JTextField();
	private String[] genres = { "Drama", "Kinderbuch", "Lyrik", "Roman",
			"Sachbuch" };
	private JComboBox<String> genreChooser = new JComboBox<String>(genres);
	private JButton inputButton = new JButton("Eingabedatei auswählen");
	private JButton outputButton = new JButton("Ausgabedatei auswählen");
	private JButton startSonificationButton = new JButton(
			"Audifizierung starten");
	private File inputFile;
	private File outputFile;
	
	
	
	class FileChooser extends FileDialog {

		/**
		 * This class is a simple FileChooser
		 */
		private static final long serialVersionUID = 1L;

		public FileChooser(JFrame frame) {
			super(frame);
		}

		// inputfile dialog
		public File inputFile() {
			this.setMode(FileDialog.LOAD);
			this.setMultipleMode(false);
			this.setFilenameFilter(filterTXT);
			this.setVisible(true);
			if (this.getFile() != null) {
				files = this.getFiles();
			}
			return files[0];
		}

		// outputfile dialog
		public File outputFile() {
			this.setMode(FileDialog.SAVE);
			this.setVisible(true);
			if (this.getFile() != null) {
				files = this.getFiles();
			}
			return files[0];
		}

		private File[] files;
		private FilenameFilter filterTXT = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String s) {
				return (s.toLowerCase().endsWith(".txt"));
			}
		};
	}
}