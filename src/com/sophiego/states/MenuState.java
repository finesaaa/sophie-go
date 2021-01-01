package com.sophiego.states;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.sophiego.gfx.Assets;
import com.sophiego.gfx.Text;
import com.sophiego.main.Window;
import com.sophiego.ui.Button;
import com.sophiego.ui.Click;
import com.sophiego.states.State;

public class MenuState extends State {

	private Button button;
	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	public MenuState(Window window) {
		super(window);
		buttons.add(new Button("PLAY", Window.WIDTH/2 - 100, Window.HEIGHT/2 + 125 , new Click(){
			@Override
			public void onClick() {
				State.currentState = window.getLevelSelectorState();
			}
		}, Assets.font36));
//		buttons.add(new Button("CREDITS", Window.WIDTH/2, Window.HEIGHT/2 + 135, new Click(){
//			@Override
//			public void onClick() {
//				State.currentState = window.getLevelSelectorState();
//			}
//		}, Assets.font48));
		buttons.add(new Button("EXIT", Window.WIDTH/2 + 100, Window.HEIGHT/2 + 125, new Click(){
			@Override
			public void onClick() {
				System.exit(1);
			}
		}, Assets.font36));
	}

	@Override
	public void update() {
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).update();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.logo, Window.WIDTH/2 - Assets.LOGOSIZE/2, Window.HEIGHT/2 - 240, null);
		
		g.drawImage(Assets.ufo, -100 , Window.HEIGHT/2 - 30, null);
		g.drawImage(Assets.planet1, Window.WIDTH/2 + 180 , -100, null);
		
		g.setFont(Assets.fontTitle);
		Text.drawString(g, "Sophie Go", Window.WIDTH/2, Window.HEIGHT/2 + 35, true, new Color (0, 45, 42));
		for(int i = 0; i < buttons.size(); i++)
			buttons.get(i).render(g);
	}

}