/*******************************************************************************
 * Copyright (c) 2012 BragiSoft, Inc.
 * This source is subject to the BragiSoft Permissive License.
 * Please see the License.txt file for more information.
 * All other rights reserved.
 * 
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Contributors:
 * Martin Kießling - Everything
 * 
 *******************************************************************************/

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

/**
 * This class is the GUI of the sonificator.
 * 
 * @author Martin Kießling
 */
public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	/* components */
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
	 * constructor of GUI
	 */
	public GUI(String title) {
		super(title);
		initComponents();
		setVisible(true);
	}

	/**
	 * This function initializes the GUI compoments
	 */
	private void initComponents() {
		// initialize contentPane
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

		// add components to contentPane
		contentPane.add(inputField);
		contentPane.add(inputButton);
		contentPane.add(outputField);
		contentPane.add(outputButton);
		contentPane.add(genreChooser);
		contentPane.add(startSonificationButton);

		pack();

		// add actionListeners to buttons
		inputButton.addActionListener(this);
		outputButton.addActionListener(this);
		startSonificationButton.addActionListener(this);
	}

	/**
	 * Overrides the actionPerformed-method and determines which button was
	 * pressed to start the right action.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object src = arg0.getSource();
		if (src == inputButton) {
			inputFile = new FileChooser(this).inputFile();
			if (inputFile != null) {
				inputField.setText(inputFile.getAbsolutePath());
			}
		} else if (src == outputButton) {
			outputFile = new FileChooser(this).outputFile();
			if (outputFile != null) {
				outputField.setText(outputFile.getAbsolutePath());
			}
		} else if (src == startSonificationButton) {
			// Do something
		}
	}

	/**
	 * The main-method creates a new Instance of GUI.
	 */
	public static void main(String[] args) {
		new GUI("Brafisoft - Sonify");
	}

	/**
	 * This class is a simple FileChooser.
	 * 
	 * @param file
	 *            is whether the input or the output file
	 * @param FilenameFilter
	 *            filters only textfiles for the open-dialog
	 * @author Martin Kießling
	 */
	private class FileChooser extends FileDialog {
		// TODO: bug, when choosing a file from recently used
		// GtkFileDialogPeer.java throws NullPointerException. Test under
		// Windows necessary to see if Fthe problem exists.

		private static final long serialVersionUID = 1L;

		/* variables */
		private File file;
		private FilenameFilter filterTXT = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String s) {
				return (s.toLowerCase().endsWith(".txt"));
			}
		};

		/**
		 * constructor of FileChooser
		 */
		public FileChooser(JFrame frame) {
			super(frame);
		}

		/**
		 * This method returns a file which is meant to be the input-file.
		 * 
		 * @return returns the input-file
		 */
		public File inputFile() {
			this.setMode(FileDialog.LOAD);
			this.setMultipleMode(false);
			this.setTitle("Eingabedatei auswählen...");
			this.setFilenameFilter(filterTXT);
			this.setVisible(true);
			if (this.getFiles()[0] != null) {
				file = this.getFiles()[0];
				return file;
			}
			return null;
		}

		/**
		 * This method returns a file which is meant to be the output-file.
		 * 
		 * @return returns the output-file
		 */
		public File outputFile() {
			this.setMode(FileDialog.SAVE);
			this.setFile(".mid");
			this.setTitle("Ausgabedatei auswählen...");
			this.setVisible(true);
			if (this.getFiles()[0] != null) {
				file = this.getFiles()[0];
				return file;
			}
			return null;
		}
	}
}