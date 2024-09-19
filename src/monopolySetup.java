import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class monopolySetup extends JPanel {

	JFrame frame = new JFrame();
	Tile tiles[] = new Tile[40];
	String names[] ={"go", "baltic", "chest", "medditaranian", "income tax", "oriental", "vermont", "chance", "conneticut", "jail", "st.Charles", "electric company", "states", "virginia"
			, "st.James Place", "chest", "tennessee", "new York", "free Parking", "Kentucky", "chance", "Indiana", "Illinois", "atlantic", "ventnor", "water Works",
			"marvin Gardens", "go to jail", "pacific", "north Carolina", "chest", "Pensylvania", "chance", "park place", "luxury tax", "boardwalk"};
	int cost[] = {0, 60, 0, 60, 0, 100, 0, 100, 120, 0, 140, 150, 140, 160, 180, 0, 180, 200, 0, 220, 0, 220, 240, 260, 260, 150, 280, 0, 300, 300, 0, 320, 0, 350, 0, 400};
	Color colors[] = {new Color(20, 120, 50), new Color(66, 40, 14), new Color(20, 80, 140), new Color(66, 40, 14), new Color(147, 151, 143), new Color(50, 168, 168), new Color(166, 111, 50), 
						new Color(50, 168, 168), new Color(50, 168, 168), new Color(255, 102, 0), new Color(202, 0, 202), new Color(255), new Color(202, 0, 202), new Color(202, 0, 202), new Color(253, 177, 0),
						new Color(20, 80, 140), new Color(253, 177, 0), new Color(253, 177, 0), new Color(180, 60, 20), new Color(255, 0, 0), new Color(166, 111, 50), new Color(255, 0, 0), new Color(255, 0, 0),
						new Color(214, 228, 24), new Color(214, 228, 24), new Color(246, 255, 105), new Color(214, 228, 24), new Color(0, 50, 255), new Color(0, 255, 75), new Color(0, 255, 75), new Color(20, 80, 140),
						new Color(0, 255, 75), new Color(166, 111, 50), new Color(0, 255, 20), new Color(125), new Color(0, 255, 20)};
	int xs[] = {900, 800, 700, 600, 500, 400, 300, 200, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 900, 900, 900, 900, 900, 900, 900, 900};
	int ys[] = {900, 900, 900, 900, 900, 900, 900, 900, 900, 900, 800, 700, 600, 500, 400, 300, 200, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 200, 300, 400, 500, 600, 700, 800};
	
	@Override
public void paintComponent(Graphics g) {
	System.out.println("" + cost.length);
	System.out.println(xs.length);
	System.out.println(ys.length);
		draw(g);
			Setup();
			

	}
public monopolySetup() {
	
}
	
	public void Setup() {

		
for(int i = 0; i<36; i++) {
tiles[i] =  new Tile(cost[i], names[i], new Color(0), true, xs[i], ys[i]);
}


	
}
	   public void draw(Graphics g) {
		  
		   for(int i = 0; i<36; i++) {
			g.setColor(colors[i]);
			   g.fillRect(xs[i], ys[i], 100, 100);
			  g.setColor(Color.black);
			   g.drawString("cost" + cost[i], xs[i] + 25, ys[i]+25);
			   g.drawString(names[i], xs[i]+10, ys[i]+50);
		  }
	   }
}
