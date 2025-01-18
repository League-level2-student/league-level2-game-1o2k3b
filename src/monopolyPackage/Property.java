package monopolyPackage;

import java.awt.Color;
import java.awt.Graphics;

public class Property extends Tile {

	int cost;
	int owner;
	int houses;

	public Property(Color color, String name, int cost, int xPos, int yPos) {
		super(color, name, xPos, yPos);
		// TODO Auto-generated constructor stub
		this.cost = cost;
		owner = -1;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		g.setColor(Color.black);
		g.drawString("$" + cost, xPos + 27, yPos + 70);
	}

}
