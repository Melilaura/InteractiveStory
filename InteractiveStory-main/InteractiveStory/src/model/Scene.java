package model;

import java.util.ArrayList;
import processing.core.PApplet;
import view.Main;

public class Scene extends PApplet {

	private String[] text;
	// String palabra;
	// Main newords;

	// private ArrayList<Main> newWords;

	public void setup (PApplet app) {

		text = app.loadStrings("history/History.txt");

		if (text != null) {

			String[] newLines = new String[text.length];
			for (int i = 0; i < text.length; i++) {

				String currentWord = text[i];
				if (currentWord != null) {
					currentWord = text[i].toUpperCase();
				}
				newLines[i] = currentWord;

				// String[] sa3 = concat(newLines,palabra);
			}
			saveStrings("history/History.txt", newLines);
			
			return;

		}
	}

}
