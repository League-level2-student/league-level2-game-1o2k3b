import java.util.ArrayList;

import javax.swing.JLabel;

public class players {
pieces p;
money m;
properties prop;
boxes b;
PropertyDisplay propD;
JLabel propDisplay[] = new JLabel[4];


	players(pieces p, properties prop, boxes b, money m, PropertyDisplay propD) {
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
