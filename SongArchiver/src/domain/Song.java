package domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

import enums.SongStatus;

public class Song implements Comparable<Song> {
	private String title;
	private int bpm;

	private SongStatus status;
	private Collection<Recording> recordings;

	/*
	 * CONSTRUCTORS
	 */

	public Song(String title, SongStatus status, int bpm) {
		setTitle(title);
		setStatus(status);
		setBPM(bpm);
		recordings = new HashSet<Recording>();
	}

	public Song(String title) {
		this(title, SongStatus.WORK_IN_PROGRESS, 0);
	}

	/*
	 * RECORDINGS
	 */
	public void addRecording(Recording recording) {
		recordings.add(recording);
	}

	/*
	 * COMPARING
	 */

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (getClass() != o.getClass())
			return false;
		Song s = (Song) o;
		return title.equals(s.title) && status == s.status && bpm == s.bpm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, status, bpm);
	}

	@Override
	public int compareTo(Song s) {
		int result = title.compareTo(s.title);
		return result == 0 ? status.compareTo(s.status) : result;
	}

	/*
	 * GETTERS - SETTERS
	 */

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title == null || title.isBlank())
			throw new IllegalArgumentException("Please provide a song name.");
		this.title = title;
	}

	public SongStatus getStatus() {
		return status;
	}

	public void setStatus(SongStatus status) {
		this.status = status;
	}

	public Collection<Recording> getRecordings() {
		return recordings;
	}

	public void setBPM(int bpm) {
		if (bpm <= 0)
			throw new IllegalArgumentException("Invalid BPM");
		this.bpm = bpm;
	}

	public int getBPM() {
		return bpm;
	}
}
