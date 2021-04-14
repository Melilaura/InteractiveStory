package controller;

import model.Scene;
import view.Main;
import processing.core.PApplet;

public class Controller {
	
	Scene scene;
	boolean tipo;

	public Controller(PApplet app) {
		
		scene = new Scene();
		tipo = true;
		
	}
	
	public void Words(PApplet app) {
		
		
		scene.setup(app);
		
	}
	
}
