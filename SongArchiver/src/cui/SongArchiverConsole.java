package cui;

import java.util.Arrays;
import java.util.Scanner;

import domain.SongController;
import dto.SongDTO;
import enums.SongStatus;

public class SongArchiverConsole {
	private final SongController sc;
	private Scanner input;

	private String[] mainMenu = new String[] { "Show all songs", "Add new song", "Remove song" };

	public SongArchiverConsole(SongController sc) {
		this.sc = sc;
		this.input = new Scanner(System.in);
	}

	public void start() {
		int choice;
		do {
			System.out.println();
			choice = chooseFromMenu("Main Menu", mainMenu, true);

			switch (choice) {
			case 1 -> printAllSongs();
			case 2 -> addSong();
			case 3 -> removeSong();
			}
		} while (choice != 0);

	}

	private void addSong() {
		boolean valid = false;
		String title = null;

		do {
			try {
				System.out.printf("Please enter the song's title: ");
				title = input.nextLine();
				if (title == null || title.isBlank())
					throw new IllegalArgumentException("Every song needs a title.");
				valid = true;
			} catch (IllegalArgumentException iae) {
				System.err.println(iae.getMessage());
			}
		} while (!valid);

		String[] statusOptions = Arrays.stream(SongStatus.values()).map(status -> status.name()).toArray(String[]::new);
		int statusChoice = chooseFromMenu("Choose song status:", statusOptions, false);

		int bpm = chooseInt("What is the song's BPM?", 1, Integer.MAX_VALUE);

		sc.addSong(new SongDTO(title, SongStatus.values()[statusChoice - 1].name(), bpm));
	}

	private void removeSong() {
		System.out.println("Not implemented yet.");
	}

	private void printAllSongs() {
		int counter = 1;
		for (SongDTO song : sc.getAllSongs()) {

			System.out.printf("%d. %s%s [%s]%n", counter, song.title(),
					song.bpm() == -1 ? "" : String.format(" - %dbpm", song.bpm()), song.status());
			counter++;
		}
	}

	private int chooseInt(String prompt, int min, int max) {
		boolean valid = false;
		int choice = 0;
		do {
			System.out.println(prompt);
			System.out.printf("Your choice: ");
			try {
				choice = Integer.parseInt(input.nextLine());
				if (choice > max || choice < min)
					throw new IllegalArgumentException(
							String.format("Please enter a number between %d and %d", min, max));
				valid = true;
			} catch (NumberFormatException nfe) {
				System.err.println("Please enter a number");
			} catch (IllegalArgumentException iae) {
				System.err.println(iae.getMessage());
			}
		} while (!valid);
		return choice;
	}

	private int chooseFromMenu(String menu, String[] options, boolean exit) {
		for (int i = 0; i < options.length; i++) {
			menu += String.format("%n%d. %s", i + 1, options[i]);
		}
		if (exit)
			menu += String.format("%n0. EXIT");
		menu += String.format("%nYour choice: ");

		boolean stop = false;
		int choice = -1;
		do {
			try {
				System.out.print(menu);
				choice = Integer.parseInt(input.nextLine());
				if (choice < 0 || choice > options.length || (choice == 0 && !exit))
					throw new IllegalArgumentException("Invalid choice");
				stop = true;
			} catch (NumberFormatException nfe) {
				System.err.println("Please enter a valid number.");
			} catch (IllegalArgumentException iae) {
				System.err.println(iae.getMessage());
			}
		} while (!stop);
		return choice;
	}

}
