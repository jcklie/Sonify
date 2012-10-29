package com.bragi.sonify;

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

	private static final long serialVersionUID = 1L;

	/* compoments */
	private JPanel contentPane;
	private JTextField inputField;
	private JTextField outputField;
	private JComboBox<String> genreChooser;
	private JButton inputButton;
	private JButton outputButton;
	private JButton startSonificationButton;

	/* variables */
	private final String[] genres = { "Drama", "Kinderbuch", "Lyrik", "Roman",
			"Sachbuch" };
	private File inputFile;
	private File outputFile;

	/**
	 * constructor
	 */
	public GUI(String title) {
		super(title);
		initComponents();
		setVisible(true);
	}

	/**
	 * initializes the GUI compoments
	 */
	private void initComponents() {
		// initialize contenPane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(3, 2, 5, 5));

		// frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		setResizable(false);

		// initialize components
		inputField = new JTextField();
		outputField = new JTextField();
		inputButton = new JButton("Eingabedatei wählen");
		outputButton = new JButton("Ausgabedatei wählen");
		startSonificationButton = new JButton("Audifikation starten");
		genreChooser = new JComboBox<String>(genres);

		// add compoments to contentPane
		contentPane.add(inputField);
		contentPane.add(inputButton);
		contentPane.add(outputField);
		contentPane.add(outputButton);
		contentPane.add(genreChooser);
		contentPane.add(startSonificationButton);

		pack();

		/**
		 * listener
		 */
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

	/**
	 * action-performed methods
	 */
	private void inputButtonActionPerformed() {
		inputFile = new FileChooser(this).inputFile();
		if (inputFile != null) {
			inputField.setText(inputFile.getAbsolutePath());
		}
	}

	private void outputButtonActionPerformed() {
		outputFile = new FileChooser(this).outputFile();
		if (outputFile != null) {
			outputField.setText(outputFile.getAbsolutePath());
		}
	}

	private void startSonificationButtonActionPerformed() {
		//
	}

	/**
	 * main-method
	 */
	public static void main(String[] args) {
		new GUI("Brafisoft - Sonify");
	}

	class FileChooser extends FileDialog {

		/**
		 * This class is a simple FileChooser
		 */
		private static final long serialVersionUID = 1L;

		/* variables */
		private File[] files;
		private FilenameFilter filterTXT = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String s) {
				return (s.toLowerCase().endsWith(".txt"));
			}
		};

		/**
		 * constructor
		 */
		public FileChooser(JFrame frame) {
			super(frame);
		}

		/**
		 * input FileDialog
		 */
		public File inputFile() {
			this.setMode(FileDialog.LOAD);
			this.setMultipleMode(false);
			this.setTitle("Eingabedatei auswählen...");
			this.setFilenameFilter(filterTXT);
			this.setVisible(true);
			if (this.getFile() != null) {
				files = this.getFiles();
				return files[0];
			}
			return null;
		}

		/**
		 * output FileDialog
		 */
		public File outputFile() {
			this.setMode(FileDialog.SAVE);
			this.setTitle("Ausgabedatei auswählen...");
			this.setVisible(true);
			if (this.getFile() != null) {
				files = this.getFiles();
				return files[0];
			}
			return null;
		}
	}
}