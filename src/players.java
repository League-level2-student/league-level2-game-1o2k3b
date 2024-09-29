import java.util.ArrayList;

import javax.swing.JLabel;

public class players {
pieces p;
money m;
properties prop;
boxes b;

	players(pieces p, properties prop, boxes b, money m) {
		for(int i = 0; i<4; i++) {
		this.p = p;
		this.prop = prop;
		this.b = b;
		this.m = m;
		}
	}
}
