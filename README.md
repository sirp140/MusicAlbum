# Music Collection Management System

This is a Java program that allows you to manage a collection of songs. It provides functionality to add or modify song, remove song, search songs by artist, and save the collection to a file.

## Music Class

The `MusicAlbum` class represents a single music album. 

The class provides getter and setter methods for accessing and modifying the attributes, as well as a `toString()` method for displaying the album details.

## MusicCollection Class

The `MusicCollection` class manages the collection of music albums. It has the following features:

- Stores the albums in an array of `MusicAlbum` objects.
- Provides methods to add or modify albums, remove albums, search albums by artist, and save the collection to a file.
- Includes a `loadData()` method to read album data from a file and populate the collection.
- Uses a dynamic array to accommodate a variable number of albums.
- Supports a maximum of 7 albums in the initial array, but automatically expands the array if needed.

## AlbumGUI Class

The `AlbumGUI` class is responsible for creating a graphical user interface (GUI) to interact with the music collection. It uses Swing components to display the collection, handle user input, and invoke the appropriate methods in the `MusicCollection` class.

The GUI provides the following features:

- Displaying the list of albums in the collection.
- Adding or modifying albums by entering the title, artist, and release year.
- Removing albums by specifying the title.
- Searching for albums by artist.
- Saving the collection to a file.
- Exiting the program.

## AlbumManager Class

The `AlbumManager` class contains the `main()` method and serves as the entry point for the program. It creates an instance of the `MusicCollection` class, loads album data from a file using the `loadData()` method, and creates an instance of the `AlbumGUI` class, passing the `MusicCollection` object as a parameter to the constructor.

## Usage

1. Compile and run the `AlbumManager` class.
2. The GUI window will open, displaying the current collection of albums.
3. Use the provided buttons to perform various operations, such as adding or modifying albums, removing albums, searching albums by artist, saving the collection, and exiting the program.
4. Follow the on-screen prompts and input the required information.
5. The collection will be updated based on the chosen operation, and the GUI will reflect the changes.

Note: The program expects album data to be stored in a file named "data.txt" in a specific format: each line should contain the album's title, artist, and release year separated by commas.

## Video Walkthrough
![Screen Shot 2023-06-30 at 12 35 57 PM](https://github.com/sirp140/MusicAlbum/assets/85513412/9a739346-174b-4b6c-ade6-e33b749a3c6a)




![Screen Shot 2023-06-30 at 12 37 35 PM](https://github.com/sirp140/MusicAlbum/assets/85513412/b32329d1-6eda-49af-b252-7ffe4d57bddc)




![Screen Shot 2023-06-30 at 12 38 17 PM](https://github.com/sirp140/MusicAlbum/assets/85513412/cb2486ba-26f4-48cf-9899-57bd7585de79)





