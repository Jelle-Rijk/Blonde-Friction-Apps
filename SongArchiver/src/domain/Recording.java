package domain;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Objects;

import enums.RecordingType;

public class Recording implements Comparable<Recording> {
	public final static String RECORDING_DIRECTORY = Path.of("src", "data", "recordings").toString();

	private Song song;
	private RecordingType type;
	private LocalDate date;

	/*
	 * CONSTRUCTORS
	 */
	public Recording(Song song, RecordingType type, LocalDate date) {
		if (song == null)
			throw new IllegalArgumentException("Every recording needs to belong to a song.");
		this.song = song;
		setType(type);
		setDate(date);
	}

	public Recording(Song song, RecordingType type) {
		this(song, type, LocalDate.now());
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
		if (o.getClass() != getClass())
			return false;
		Recording r = (Recording) o;
		return song.equals(r.song) && type == r.type && date.equals(r.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(song, type, date);
	}

	@Override
	public int compareTo(Recording r) {
		return date.compareTo(r.date);
	}

	/*
	 * GETTERS - SETTERS
	 */
	private RecordingType getType() {
		return type;
	}

	public final void setType(RecordingType type) {
		this.type = type;
	}

	private LocalDate getDate() {
		return date;
	}

	public final void setDate(LocalDate date) {
		if (date == null)
			throw new IllegalArgumentException("Every recording needs a date.");
		this.date = date;
	}

	private Song getSong() {
		return song;
	}

	public final void setSong(Song song) {
		if (song == null)
			throw new IllegalArgumentException("Every recording needs a song.");
		this.song = song;
	}
}
