package monopolyPackage;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Property extends Tile {

	int cost;
	int owner;
	int houses;
	JLabel label;

	public Property(Color color, String name, int cost, int xPos, int yPos) {
		super(color, name, xPos, yPos);
		// TODO Auto-generated constructor stub
		this.cost = cost;
		owner = -1;
		label = new JLabel();
		label.setBounds(xPos, yPos, 100, 25);
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		Board.bInstance.add(label);
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g);
		g.setColor(Color.black);
		g.drawString("$" + cost, xPos + 27, yPos + 70);
	}

}
