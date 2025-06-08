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
			throw new IllegalArgumentException("This song already exists. Please change existing song or delete it.")
		songs.add(song);
	}

	/*
	 * READ
	 */
	public Song getSong(String title) {
		return songs.stream().filter(s -> s.getTitle().equals(title)).findAny().orElseThrow();
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
