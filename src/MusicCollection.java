import java.io.*;
public class MusicCollection<albumArray>{
	
	//the current number of album
	private int numAlbums;
	
	//array to contain the albums
	private MusicAlbum[] albumArray;
	
	private String sourceName;
	
	private boolean modified;
	
	public MusicCollection() {
		numAlbums  = 0;
		albumArray = new MusicAlbum[7];
	}
	
	public String toString() {
		String printCollection = "";
		
		printCollection += ("Total Albums = " + numAlbums + '\n' + "album length = " + albumArray.length + '\n');
		
		for (int i = 0; i < numAlbums; i++) {
			printCollection += ("album " + i + " title: " + albumArray[i].getTitle() + " artist: " + albumArray[i].getArtist() + " year: " + albumArray[i].getReleaseYear());
			
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
			albumArray[numAlbums] = new MusicAlbum(title, artist, yearReleased);
			numAlbums++;
		}
		
		if (numAlbums == 7) {
			MusicAlbum[] createNewArr = new MusicAlbum[albumArray.length * 2];
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
				
				MusicAlbum[] newArray = new MusicAlbum[albumArray.length -1];
				System.arraycopy(albumArray,  0,  newArray,  0, i);
				System.arraycopy(albumArray, i+1, newArray, i, albumArray.length - i - 1);
				
				albumArray = newArray;
				numAlbums--;
			}
		}
		
		
	}
	
	
	public String getAlbumsByArtist(String artist) {
		String storeList = ""; //accumulator
		
		for (int i = 0; i < numAlbums; i++) {
			if(artist.equals(albumArray[i].getArtist())) {
				storeList += (albumArray[i].getTitle() + '\n');
			}
		}
		return storeList;
		
	}
	
	

}