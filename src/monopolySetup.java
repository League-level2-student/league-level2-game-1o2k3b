import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class monopolySetup extends JPanel {

	JFrame frame = new JFrame();
	Tile tiles[] = new Tile[40];
	String names[] ={"go", "baltic", "chest", "medditaranian", "income tax", "reading railroad", "oriental", "vermont", "chance", "conneticut", "jail", "st.Charles", "electric company", "states", "virginia"
			, "pensylvania railroad", "st.James Place", "chest", "tennessee", "new York", "free Parking", "Kentucky", "chance", "Indiana", "Illinois", "B. and O. Railroad", "atlantic", "ventnor", "water Works",
			"marvin Gardens", "go to jail", "pacific", "north Carolina", "chest", "Pensylvania", "short line", "chance", "park place", "luxury tax", "boardwalk"};
	int cost[] = {60, 60, 100, 100, 120, 140, 150, 140, 160, 180, 180, 200, 220, 220, 240, 260, 260, 150, 280, 300, 300, 320, 350, 400};
	Color colors[] = {new Color(20, 120, 50), new Color(66, 40, 14), new Color(20, 80, 140), new Color(66, 40, 14), new Color(147, 151, 143), new Color(255), new Color(50, 168, 168), new Color(166, 111, 50), 
			new Color(50, 168, 168), new Color(50, 168, 168), new Color(255)};

	
	
public monopolySetup() {
	
}
	
	public void Setup() {
		frame.setSize(1100, 1100);
		frame.setVisible(true);
		frame.add(this);
		this.setLayout(null);
		
		
for(int i = 0; i<40; i++) {
tiles[i] =  new Tile(cost[i], names[i], colors[i], true);
}
		
		
	}
	
}
