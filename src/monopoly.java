import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

public class monopoly extends JPanel {
	monopolySetup s = new monopolySetup();
	JFrame frame = new JFrame();
	void setup() {
		frame.setSize(1000, 1050);
		frame.setVisible(true);
		frame.add(s);
		this.setLayout(null);
	}

	
	ArrayList<String> chararcters = new ArrayList<String>();

	int boardSpace = 0;
	
	public static void main(String[] args) {
monopoly m = new monopoly();
m.setup();

	}

}







// instead of getting the location of a player to get the space they're on in the board I do vice versa, and use the space theyre on to get there location.