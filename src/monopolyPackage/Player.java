package monopolyPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Player implements ActionListener {
ArrayList<Property> properties = new ArrayList<>(); 
int money = 1500;
String name;
Color color;
int playerNumber;
int currentTile = 0;
int num = 0;
int boxX[] = {250, 650, 250, 650};
int boxY[] = {225, 225, 675, 675};
JButton propertyButton = new JButton("properties");

public Player(String name, Color color, int playerNumber) {
	super();
	this.name = name;
	this.color = color;
	this.playerNumber = playerNumber;
	propertyButton.setOpaque(true);
	propertyButton.setBounds(boxX[playerNumber], boxY[playerNumber]+65, 90, 35);
	propertyButton.addActionListener(this);
	Board.getBoard().add(propertyButton);
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
	
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(boxX[playerNumber], boxY[playerNumber], 150, 100);
		g.setColor(Color.black);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		g.drawString("money: " + money , boxX[playerNumber], boxY[playerNumber]+40);
		g.setFont(new Font("Times New Roman", Font.BOLD, 25));
		g.drawString("player " + name, boxX[playerNumber], boxY[playerNumber]+20);
	
	num++;
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getSource()==propertyButton) {
		String propertyString = "";
		for(Property p:properties) {
			propertyString+=p.name + "\n";
		}

		JOptionPane.showMessageDialog(null, propertyString);
	}
}


}
