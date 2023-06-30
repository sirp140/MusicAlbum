public class AlbumManager {
    public static void main(String[] args) {
    	/*
    	 * creates an instance of the MusicCollection class and 
    	 * an instance of the AlbumGUI class, passing the musicCollection 
    	 * object as a parameter to the AlbumGUI constructor.
    	 */
    	
    	String sourceName = "data.txt";
    	
        MusicCollection musicCollection = new MusicCollection();
        //call loadData to read the file	
      	musicCollection.loadData(sourceName);
        
        AlbumGUI albumGUI = new AlbumGUI(musicCollection);
        
    }
}