import java.awt.Color;

import javax.swing.*;

public class Tile {

String name;
int cost;
int houses;
Color color;
boolean isOwned = false;
boolean isProperty;

public Tile(int cost, String name, Color color, Boolean isProperty) {
	this.cost = cost;
	this.name = name;
	this.color = color;
}

}
