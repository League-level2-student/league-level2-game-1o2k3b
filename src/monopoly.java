import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.*;

public class monopoly extends JPanel {



	
	ArrayList<String> chararcters = new ArrayList<String>();

	int boardSpace = 0;
	
	public static void main(String[] args) {
monopoly m = new monopoly();
monopolySetup s = new monopolySetup();
s.setup();

	}

}







// instead of getting the location of a player to get the space they're on in the board I do vice versa, and use the space theyre on to get there location.