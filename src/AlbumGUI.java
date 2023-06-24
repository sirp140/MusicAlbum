import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlbumGUI {
	
	private AlbumCollection albumList;
	private JFrame window;
	
	final int WINDOW_WIDTH = 350; // Window width  
	 final static int WINDOW_HEIGHT = 250;      // Window height 
	 private JPanel panel;
	 
	 private ImageIcon image1;
	private JLabel imageLabel1; //to show an image
	
	 private static String[] arr = new String[5];
	 private static JList albumjList;
	 
	 public AlbumGUI(AlbumCollection al)
	 {
		 albumList = al;
		 showWindow();
	 }
	 
	 public void showWindow() {
		 
		//Create a window
		 window = new JFrame();
		 
		 //set the title
		 window.setTitle("Music Collection");
		 
		 //set the size
		 window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		 
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 window.getContentPane().setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));
		 
		 
		 readFile();
		 
		 //forTesting ftest = new forTesting(); //create object 
		 
         panel = new JPanel();//panel to hold the components
		 
		 albumjList = new JList(arr); //create the list
		 
		 albumjList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 
		 albumjList.addListSelectionListener((ListSelectionListener) new ListListener());
		 
		 //Create Add/Modify button
		 JButton addButton = new JButton("Add/Modify DVD");
		 //add listener for add button
		 addButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 doAddOrModifyAlbum();
			 }
			 
		 });
		 
		 panel.add(addButton);
	     
		 //Add the panel to the window's content pane.
	      window.getContentPane().add(panel);
		 
		// Display the window
		 window.pack();
		 window.setVisible(true);
		 
		 
	 }
	 
	 
	 public static void readFile() {
		 int i = 0;
		 String filename = "testdata.txt";
			
		 try {
			 FileReader readFile = new FileReader(filename);
			 BufferedReader readBuff = new BufferedReader(readFile);
				
			 String storeString;
			 //sourceName = filename; //to use in save()
			     
			 while ((storeString = readBuff.readLine()) != null) 
			 {
				 arr[i] = storeString;
			    
				 //JOptionPane.showMessageDialog(window, arr[i]);
			    i++;
			 }
			 readBuff.close();
			}
		 
		 //If the file cannot be found, start with an empty array for your collection.
		 catch(IOException e) {
			 System.out.println(filename + " is not found or it's empty! " + "Let's make new collection.");
			}
		 
	 }
	 
	 private class ListListener implements ListSelectionListener{
		 public void valueChanged(ListSelectionEvent e) {
			 
			 String userSelected = (String)albumjList.getSelectedValue();
			 
			 JOptionPane.showMessageDialog(window, "Album selected: \n" + userSelected);
			 
				image1 = new ImageIcon(getClass().getResource("/Users/sirpreetkaur/Desktop/starTrek.jpeg"));
				imageLabel1 = new JLabel(image1);
				panel.add(imageLabel1);
					
		 }
	 }
	 
	 private void doAddOrModifyAlbum() {

			// Request the title
			String title = JOptionPane.showInputDialog("Enter title");
			if (title == null) {
				return;		// dialog was cancelled
			}
			title = title.toUpperCase();
			
			// Request the rating
			String artist = JOptionPane.showInputDialog("Enter artist for " + title);
			if (artist == null) {
				return;		// dialog was cancelled
			}
			artist = artist.toUpperCase();
			
			// Request the running time
			String releaseYear = JOptionPane.showInputDialog("Enter release year for " + title);
			if (releaseYear == null) {
			}
			
	                // Add or modify the DVD (assuming the rating and time are valid
	                albumList.addOrModifyAlbum(title, title, releaseYear);
	                
	                // Display current collection to the console for debugging
	                //label1 = new JLabel("Adding/Modifying: " + title + "," + rating + "," + time);
	                JOptionPane.showMessageDialog(window,"Adding/Modifying: " + title + "," + artist + "," + releaseYear);
	                JOptionPane.showMessageDialog(window, "Updated Music Album collection: \n \n" + albumList);
			
		}
		
	 
	 

}
