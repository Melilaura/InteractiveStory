package view;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
	
	public static void main(String[] args) {
		PApplet.main("view.Main");
	}
	
	

	//SCENE IMAGES
	
	PImage FIRST;
	PImage SECOND;
	PImage SCENE;
	PImage FINAL;
	PImage BACKGROUND;
	PImage PARALLAX;
	
	//OBJECTS
	
		PImage HAT;
		PImage RIDDINHOOD;
		PImage NOSE;
		PImage EYES;
		PImage EAR;
		PImage SAQUITO;
	
	
	//VARIABLES
	
	int state;
	
	public void settings () {
		
		size (1147,700);
		state = 1 ;                                   

	}
	
	public void setup () {
		
		//SCENE IMAGES
		
		 FIRST= loadImage ("data/FirstWindow.png");
		 SECOND= loadImage ("data/HistoryWindow.png");
		 SCENE= loadImage ("data/Scene.png");
		 FINAL= loadImage ("data/FinalWindow.jpg");
		 BACKGROUND=loadImage ("data/Background.png");
		 PARALLAX=loadImage ("data/Parallax.png");
		 
		 //OBJECT IMAGES
		 HAT= loadImage ("data/Hat.png");
		 RIDDINHOOD= loadImage ("data/RiddinHood.png");
		 NOSE= loadImage ("data/Nose.png");
		 EYES= loadImage ("data/Eyes.png");
		 EAR=loadImage ("data/Ear.png");
		 SAQUITO=loadImage ("data/Saquito.png");
		
	}
	
	public void draw () {
		
		background(30,46,28);
		
		
		
		switch (state) {

		case 1: 
			image(BACKGROUND,0,0);
			image (FIRST, 0,0);
			float fgX= map(mouseX,0,width,0,-100);
			image(FIRST,fgX,0);

			break;

		case 2:
			image(BACKGROUND,0,0);
			image (SECOND, 0,0);
			float sgX= map(mouseX,0,width,0,-100);
			image(SECOND,sgX,0);
			
			
			break;


		case 3:	
			image (PARALLAX, 0,0);
			float bgX= map(mouseX,0,width,0,-100);
			image(PARALLAX,bgX,0);
			image (SCENE, 0,0);
			
			
			break;

		case 4:
			image (FINAL, 0,0);
			break;
			
		}
		
	}
	
	
	public void mousePressed () {

		println (mouseX, mouseY);

		switch (state) {

		case 1:
			if (mouseX > 1060 && mouseX < 1147
					&& mouseY > 0 && mouseY < 700 ) 
				state = 2;
			
			
			break;

		case 2:

			if (mouseX > 1060 && mouseX < 1147
					&& mouseY > 0 && mouseY < 700 ) 
				state = 3;

			break;}

//		case 3:
//			if (mouseX > 460 && mouseX <500
//					&& mouseY > 246 && mouseY <400) 
//				image (HAT,460 ,246);
//
//			break;}
//

	}
	
}
