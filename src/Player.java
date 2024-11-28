import java.util.ArrayList;

import javax.swing.JLabel;

public class Player {
pieces p;
money m;
Property prop;
boxes b;
PropertyDisplay propD;
JLabel propDisplay[] = new JLabel[4];


	Player(pieces p, Property prop, boxes b, money m, PropertyDisplay propD) {
		for(int i = 0; i<4; i++) {
		this.p = p;
		this.prop = prop;
		this.b = b;
		this.m = m;
		this.propD = propD;
		this.propDisplay[i] = new JLabel();
		}
		
	}
}
