
public class Music {
	
	//Fields
	private String title; //title of the music album
	private String artist; //artist of the music album
	private int releaseYear; //release year of the music album
	
	
	//constructor:
	public Music(String albumTitle, String albumArtist, int albumReleaseYear) {
		title = albumTitle;
		artist = albumArtist;
		releaseYear = albumReleaseYear;
		
	}
	
	//getter methods
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public int getReleaseYear() {
		return releaseYear;
	}
	
	
	//setter methods
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public void setArtist(String newArtist) {
		artist = newArtist;
	}
	
	public void setReleaseYear(int newReleaseYear) {
		releaseYear = newReleaseYear;
	}
	
	public String toString() {
		return title + " by " + artist + " (" + releaseYear + ")";
	}

}
