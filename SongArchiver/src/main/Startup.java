package main;

import cui.SongArchiverConsole;
import domain.SongController;

public class Startup {

	public static void main(String[] args) {
		new SongArchiverConsole(new SongController()).start();
	}

}
