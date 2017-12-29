package com.mohammed.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	/**
	 * ©Mohammed Qureshi 2014-2015
	 */
	
	private boolean[] keys = new boolean [180];
	public boolean up, down, left, right, escape, increasehealth, decreasehealth, increaseMoney, decreaseMoney;
	
	public void update(){
		up = keys[KeyEvent.VK_UP]|| keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN]|| keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT]|| keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT]|| keys[KeyEvent.VK_D];
		escape = keys[KeyEvent.VK_ESCAPE];
		
		//Test Keys
		increasehealth = keys[KeyEvent.VK_P];
		decreasehealth = keys[KeyEvent.VK_O];
		
		increaseMoney = keys[KeyEvent.VK_L];
		decreaseMoney = keys[KeyEvent.VK_K];
		
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
}
