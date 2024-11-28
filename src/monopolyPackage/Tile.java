package monopolyPackage;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
Color color;
String name;
int xPos;
int yPos;
public Tile(Color color, String name, int xPos, int yPos) {
	super();
	this.color = color;
	this.name = name;
	this.xPos = xPos;
	this.yPos = yPos;
}
public void draw(Graphics g) {
	// TODO Auto-generated method stub

		g.setColor(color);
		g.fillRect(xPos, yPos, 100, 100);
		g.setColor(Color.black);
		g.drawString(name, xPos + 10, yPos + 50);
}




}
