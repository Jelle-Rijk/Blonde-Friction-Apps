package domain;

import java.util.Collection;

import dto.SongDTO;

public class SongController {
	private SongRepository songRepo;

	public SongController() {
		this.songRepo = new SongRepository();
	}

	/*
	 * CREATE
	 */

	/**
	 * Adds a new song to the main SongRepository.
	 * 
	 * @param song A DTO of the song to add
	 */
	public void addSong(SongDTO song) {
		songRepo.addSong(SongDTO.convertToSong(song));
	}

	// Add a recording to a song

	/*
	 * READ
	 */

	// Retrieve songDTO from songRepo

	/**
	 * Retrieves all Songs as a collection of SongDTOs
	 * 
	 * @return collection of SongDTOs of all songs
	 */
	public Collection<SongDTO> getAllSongs() {
		return songRepo.getSongs().stream().map(song -> SongDTO.makeDTO(song)).toList();
	}

	// Retrieve all recordings from a song

	/*
	 * UPDATE
	 */

	// Change a song in the songRepo

	/*
	 * DELETE
	 */

	// Remove a song from the songRepo
}
