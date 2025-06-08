package dto;

import domain.Song;
import enums.SongStatus;

public record SongDTO(String title, String status, int bpm) {
	public static SongDTO makeDTO(Song s) {
		return new SongDTO(s.getTitle(), s.getStatus().toString(), s.getBPM());
	}

	public static Song convertToSong(SongDTO song) {
		return new Song(song.title(), SongStatus.valueOf(song.status()), song.bpm());
	}
}
