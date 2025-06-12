package domain;

import java.util.ArrayList;
import java.util.List;

public class SongRepository {
	private List<Song> songs;

	public SongRepository() {
		songs = new ArrayList<Song>();
	}

	/*
	 * CREATE
	 */
	public void addSong(Song song) {
		if (songs.contains(song))
			throw new IllegalArgumentException("This song already exists. Please change existing song or delete it.");
		songs.add(song);
	}

	/*
	 * READ
	 */
	/**
	 * Gets a song by its title
	 * @param title the unique title of the song to search for
	 * @return the song with the specified title
	 * @throws NoSuchElementException - if no song with title present
	 */
	public Song getSong(String title) {
		return songs.stream().filter(s -> s.getTitle().equals(title)).findAny().orElseThrow();
	}
	
	/**
	 * Get all songs in the songRepository.
	 * @return An ArrayList of all songs in the songRepository
	 */
	public List<Song> getSongs() {
		return songs;
	}

	/*
	 * UPDATE
	 */

	/*
	 * DELETE
	 */
	public void removeSong(Song song) {
		songs.remove(song);
	}
}
