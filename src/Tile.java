import java.awt.Color;

import javax.swing.*;

public class Tile {

String name;
int cost;
int houses;
Color color;
boolean isOwned = false;
boolean isProperty;
int xs;
int ys;

public Tile(int cost, String name, Color color, Boolean isProperty, int xs, int ys) {
	this.cost = cost;
	this.name = name;
	this.color = color;
	this.xs = xs;
	this.ys = ys;
	
}

}
