package domain;

import enums.SongStatus;

public class Song {
	private String title;

	private SongStatus status;

	/*
	 * CONSTRUCTORS
	 */
	public Song(String title) {
		setTitle(title);
	}

	/*
	 * GETTERS - SETTERS
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		// TODO implement input checking
		this.title = title;
	}

	public SongStatus getStatus() {
		return status;
	}

	public void setStatus(SongStatus status) {
		this.status = status;
	}

}
