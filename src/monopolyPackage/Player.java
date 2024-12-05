package monopolyPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

public class Player {
ArrayList<Property> properties = new ArrayList<>(); 
int money = 1500;
String name;
Color color;
int playerNumber;
int currentTile = 0;
public Player(String name, Color color, int playerNumber) {
	super();
	this.name = name;
	this.color = color;
	this.playerNumber = playerNumber;
}
public void draw(Graphics g) {
	// TODO Auto-generated method stub
	int x = Board.tiles.get(currentTile).xPos;
	int y = Board.tiles.get(currentTile).yPos;
	g.setColor(color);
	if(playerNumber==1 || playerNumber==3) {
		x+=70;
	}
	if(playerNumber==2 || playerNumber==3) {
		y+=70;
	}
	g.fillRect(x, y, 30, 30);
}


}
