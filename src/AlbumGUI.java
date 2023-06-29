import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlbumGUI {
	
	private MusicCollection musicList;
	
	private JFrame window;
	final int WINDOW_WIDTH = 350; // Window width  
	final static int WINDOW_HEIGHT = 250;      // Window height 
	private JPanel panel;
	 
	private static String[] arr = new String[5];
	private static JList albumjList;
	
	String sourceName = "data.txt";
	 
	 public AlbumGUI(MusicCollection ml)
	 {
		 musicList = ml;
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
		 
         panel = new JPanel();//panel to hold the components
		 
		 albumjList = new JList(arr); //create the list
		 
		 //readFile();
		 
		 //forTesting ftest = new forTesting(); //create object 
		 
        
		 
		// albumjList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 
		 //albumjList.addListSelectionListener((ListSelectionListener) new ListListener());
		 
		 //Create Add/Modify button
		 JButton addButton = new JButton("Add/Modify Song");
		 //add listener for add button
		 addButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 doAddOrModifyAlbum();
			 }
		 });
		 
		//Create Remove button
		 JButton removeButton = new JButton("Remove Song");
		 //add listener for remove button
		 removeButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 doRemoveMusic();
			 }
		 });
		 
		//Create Albums by artist button
		 JButton musicByArtistButton = new JButton("Album By Artist");
		 musicByArtistButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 getMusicByArist();
			 }
			 
		 });

		 
	
		 //JLabel l = new JLabel("<html>DVDs in the list: <br>" + musicList.toString() + "</html>");
		 JTextArea textArea = new JTextArea("Albums in the list:\n" + musicList.toString());
		 textArea.setEditable(false);
		 textArea.setLineWrap(true);
		 textArea.setWrapStyleWord(true);

		 JScrollPane scrollPane = new JScrollPane(textArea);
		 scrollPane.setPreferredSize(new Dimension(300, 200)); // Set the preferred size to allow for proper line wrapping
		 
		 //panel.add(l);
		 //panel.add(albumjList);
		 
		 panel.add(scrollPane, BorderLayout.CENTER);
		 
		 
		 panel.add(addButton);
		 panel.add(removeButton);
		 
		 
		 panel.add(musicByArtistButton);
		 //panel.add(saveButton);
		// panel.add(exitButton);
		 
	     
		 //Add the panel to the window's content pane.
	      window.getContentPane().add(panel);
		 
		// Display the window
		 window.pack();
		 window.setVisible(true);
		 
		 
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
	                musicList.addOrModifyAlbum(title, title, releaseYear);
	                
	             
	                
	                // Display current collection to the console for debugging
	                //label1 = new JLabel("Adding/Modifying: " + title + "," + rating + "," + time);
	                JOptionPane.showMessageDialog(window,"Adding/Modifying: " + title + "," + artist + "," + releaseYear);
	                JOptionPane.showMessageDialog(window, "Updated Music Album collection: \n \n" + musicList);
			
		}
	 
	 private void doRemoveMusic() {
			// Request the title
				String title = JOptionPane.showInputDialog("Enter title");
				if (title == null) {
					return;		// dialog was cancelled
				}
				title = title.toUpperCase();
				
		                // Remove the matching DVD if found
		                 musicList.removeSong(title);
		                
		                // Display current collection to the console for debugging
		                JOptionPane.showMessageDialog(window, "Removing: " + title);
		                JOptionPane.showMessageDialog(window,musicList);
			 
		 }
	 
	 private void getMusicByArist() {

			// Request the artist name
			String artistName = JOptionPane.showInputDialog("Enter artist:");
			if (artistName == null) {
				return;		// dialog was cancelled
			}
			artistName = artistName.toUpperCase();
			
	                String results = musicList.getAlbumsByArtist(artistName);
	                JOptionPane.showMessageDialog(window, "Songs by " + artistName + ": \n"  + results);
	                //JOptionPane.showMessageDialog(window, results);

		}
	 
	 

	 
	 
	 
}
