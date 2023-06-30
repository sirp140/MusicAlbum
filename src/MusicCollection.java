import java.io.*;
public class MusicCollection<albumArray>{
	
	
	private int numAlbums;
	private Music[] albumArray;
	private String sourceName;
	private boolean modified;
	
	public MusicCollection() {
		numAlbums  = 0;
		albumArray = new Music[7];
	}
	
	public String toString() {
		String printCollection = "";
		int index = 1;
		
		printCollection += ("Total Songs = " + numAlbums + '\n' + "Album length = " + albumArray.length + '\n');
		
		for (int i = 0; i < numAlbums; i++) {
			
			printCollection += ("Song " + index + ": " + albumArray[i].getTitle() + " by " + albumArray[i].getArtist() + 
					" (year: " + albumArray[i].getReleaseYear() + ")" + '\n');
			index++;
		}
		
		return printCollection;
	}
	
	public void addOrModifyAlbum(String title, String artist, String releaseYear) {
		//compare it to each albumArray title
		boolean status = false;
		for (int i = 0; i < numAlbums; i++) {
			if(title.equals(albumArray[i].getTitle())) {
				status = true;
				
				//found title and modify the artist, release year
				albumArray[i].setArtist(artist);
				
				int yearReleased = Integer.parseInt(releaseYear);
				albumArray[i].setReleaseYear(yearReleased);
			}
		}
		
		if (status == false) {
			//title is not found add album to collection
			int yearReleased = Integer.parseInt(releaseYear);
			albumArray[numAlbums] = new Music(title, artist, yearReleased);
			numAlbums++;
		}
		
		if (numAlbums == 7) {
			Music[] createNewArr = new Music[albumArray.length * 2];
		}
		
		//copy new array
		
	}
	
	public void loadData (String filename)
	{
		try 
		{
			FileReader readFile = new FileReader(filename);
			BufferedReader readBuff = new BufferedReader(readFile);
			
		     String storeString;
		     sourceName = filename; //to use in save()
		     
		     while ((storeString = readBuff.readLine()) != null) 
		     {
				
				//remove white spaces
				//str = str.replaceAll("\\s+", "");
		
				//use the addOrModify method above to insert it into the collection. 
				String[] storeSplit = storeString.split(",");	
				addOrModifyAlbum(storeSplit[0],storeSplit[1], storeSplit[2]);
		     }
		     readBuff.close();
		
		}
		catch(IOException e) 
		{
			
			System.out.println(filename + " is not found or it's empty! " + "Let's make new collection.");
		}
	}
	
	public void removeSong(String title) {
		int trackIndex = 0;
		
		for(int i = 0; i < numAlbums; i++) {
			if(title.equals(albumArray[i].getTitle())) {
				trackIndex = i;
				
				Music[] newArray = new Music[albumArray.length -1];
				System.arraycopy(albumArray,  0,  newArray,  0, i);
				System.arraycopy(albumArray, i+1, newArray, i, albumArray.length - i - 1);
				
				albumArray = newArray;
				numAlbums--;
			}
		}
		
		
	}
	
	
	public String getAlbumsByArtist(String artist) {
		
		artist = artist.toUpperCase();
		String storeList = ""; //accumulator
		
		for (int i = 0; i < numAlbums; i++) {
			if(artist.equals(albumArray[i].getArtist())) {
				storeList += (albumArray[i].getTitle() + '\n');
			}
		}
		return storeList;
		
	}
	
	public void save() {
		try 
		{
			//Initializing Filewriter object.
		      FileWriter writer = new FileWriter(sourceName);
		      
		     
		      for(int i = 0; i < numAlbums; i++) 
		      {
					writer.write (albumArray[i].getTitle() + "," + albumArray[i].getArtist() + "," + albumArray[i].getReleaseYear());
					writer.write("\r\n");
			 }
		      writer.close();
			
		}
		catch (IOException e) 
		{
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}	
		
	}
	
	

}