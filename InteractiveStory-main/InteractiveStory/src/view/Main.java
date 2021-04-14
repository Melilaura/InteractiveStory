package view;

import java.util.ArrayList;

import model.Scene;
import controller.Controller;
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("view.Main");
	}

	// SCENE IMAGES

	PImage FIRST;
	PImage SECOND;
	PImage SCENE;
	PImage FINAL;
	PImage BACKGROUND;
	PImage PARALLAX;

	// BUTTON
	PImage BUTTON;

	// OBJECTS

	PImage HAT;
	PImage RIDDINHOOD;
	PImage NOSE;
	PImage EYES;
	PImage EAR;
	PImage SAQUITO;

	boolean hat;
	boolean riddinhood;
	boolean nose;
	boolean eyes;
	boolean ear;
	boolean saquito;

	// VARIABLES

	int state;
	int clickcounter1;
	int clickcounter2;
	int clickcounter3;
	int clickcounter4;
	int clickcounter5;
	int clickcounter6;

	int clickcounter;
	// FINISH BOOLEAN

	boolean FINISH;

	Scene palabra;
	
	Controller controller;

	String[] wordsInteraction;

	private ArrayList<String> words;

	public void settings() {

		size(1147, 700);
		state = 1;

	}

	public void setup() {

		// SCENE IMAGES

		FIRST = loadImage("data/FirstWindow.png");
		SECOND = loadImage("data/HistoryWindow.png");
		SCENE = loadImage("data/Scene.png");
		FINAL = loadImage("data/FinalWindow.jpg");
		BACKGROUND = loadImage("data/Background.png");
		PARALLAX = loadImage("data/Parallax.png");

		// BUTTON
		BUTTON = loadImage("data/FinalButton.png");

		// OBJECT IMAGES
		HAT = loadImage("data/Hat.png");
		RIDDINHOOD = loadImage("data/RiddinHood.png");
		NOSE = loadImage("data/Nose.png");
		EYES = loadImage("data/Eyes.png");
		EAR = loadImage("data/Ear.png");
		SAQUITO = loadImage("data/Saquito.png");

		// OBJECT BOOLEAN

		hat = false;
		riddinhood = false;
		saquito = false;
		nose = false;
		eyes = false;
		ear = false;

		// CLICK COUNTER
		clickcounter1 = 0;
		clickcounter2 = 0;
		clickcounter3 = 0;
		clickcounter4 = 0;
		clickcounter5 = 0;
		clickcounter6 = 0;

		// FINISH BOOLEAN

		palabra = new Scene();

		wordsInteraction = new String[6];
		words = new ArrayList<String>();

	}

	public void draw() {

		background(30, 46, 28);

		switch (state) {

		case 1:

			image(BACKGROUND, 0, 0);
			image(FIRST, 0, 0);
			float fgX = map(mouseX, 0, width, 0, -100);
			image(FIRST, fgX, 0);

			break;

		case 2:

			image(BACKGROUND, 0, 0);
			image(SECOND, 0, 0);
			float sgX = map(mouseX, 0, width, 0, -100);
			image(SECOND, sgX, 0);

			break;

		case 3:

			image(PARALLAX, 0, 0);
			float bgX = map(mouseX, 0, width, 0, -100);
			image(PARALLAX, bgX, 0);
			image(SCENE, 0, 0);

			clickcounter = clickcounter1 + clickcounter2 + clickcounter3 + clickcounter4 + clickcounter5
					+ clickcounter6;
			textSize(35);
			fill(230, 53, 37);
			text(clickcounter + "/6", 135, 445);

			if (hat == true) {

				image(HAT, 449, 227);
				clickcounter1 = 1;
				wordsInteraction[0] = "gorrito";
				words.add("gorrito");

			}

			if (riddinhood == true) {

				image(RIDDINHOOD, 756, 280);
				clickcounter2 = 1;

				wordsInteraction[1] = "Caperucita";
				words.add("Caperucita");
			}

			if (saquito == true) {

				image(SAQUITO, 470, 330);
				clickcounter3 = 1;
				wordsInteraction[2] = "camison";
				words.add("camison");
			}

			if (nose == true) {

				image(NOSE, 600, 300);
				clickcounter4 = 1;
				wordsInteraction[3] = "boca";
				words.add("boca");
			}

			if (eyes == true) {

				image(EYES, 512, 283);
				clickcounter5 = 1;
				wordsInteraction[4] = "ojos";
				words.add("ojos");
			}

			if (ear == true) {

				image(EAR, 442, 302);
				clickcounter6 = 1;

				wordsInteraction[5] = "orejas";
				words.add("orejas");
			}

			if (clickcounter == 6) {

				image(BUTTON, 125, 499);
				FINISH = true;

			}

			break;

		case 4:

			image(FINAL, 0, 0);

			palabra.setup(this);
			sensible();
			break;

		}

	}

	public void sensible() {

		String[] newLines = new String[wordsInteraction.length];
		for (int i = 0; i < wordsInteraction.length; i++) {

			String currentWord = wordsInteraction[i];
			if (currentWord != null) {
				currentWord = wordsInteraction[i].toLowerCase();
			}
			newLines[i] = currentWord;

		}

		saveStrings("history/History.txt", newLines);

	}

	public void mousePressed() {

		println(mouseX, mouseY);

		switch (state) {

		case 1:
			if (mouseX > 1060 && mouseX < 1147 && mouseY > 0 && mouseY < 700)

				state = 2;
			break;

		case 2:

			if (mouseX > 1060 && mouseX < 1147 && mouseY > 0 && mouseY < 700)

				state = 3;
			break;

		case 3:
			if (mouseX > 448 && mouseX < 621 && mouseY > 227 && mouseY < 354)

				hat = true;

			if (mouseX > 755 && mouseX < 854 && mouseY > 279 && mouseY < 489)

				riddinhood = true;

			if (mouseX > 479 && mouseX < 630 && mouseY > 356 && mouseY < 410)

				saquito = true;

			if (mouseX > 614 && mouseX < 630 && mouseY > 314 && mouseY < 325)

				nose = true;
			clickcounter = +1;

			if (mouseX > 527 && mouseX < 587 && mouseY > 297 && mouseY < 309)

				eyes = true;

			if (mouseX > 465 && mouseX < 497 && mouseY > 307 && mouseY < 329)

				ear = true;

			if (FINISH == true && mouseX > 125 && mouseX < 232 && mouseY > 500 && mouseY < 587)

				state = 4;
			break;

		case 4:

			if (mouseX > 248 && mouseX < 542 && mouseY > 403 && mouseY < 496)

				exit();
			break;

		}

	}

}
