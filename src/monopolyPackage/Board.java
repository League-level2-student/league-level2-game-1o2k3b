package monopolyPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {
	static final String names[] = { "go", "baltic", "chest", "medditaranian", "income tax", "oriental", "chance",
			"vermont", "conneticut", "jail", "st.Charles", "electric company", "states", "virginia", "st.James Place",
			"chest", "tennessee", "new York", "free Parking", "Kentucky", "chance", "Indiana", "Illinois", "atlantic",
			"ventnor", "water Works", "marvin Gardens", "go to jail", "pacific", "north Carolina", "chest",
			"Pensylvania", "chance", "park place", "luxury tax", "boardwalk" };
	static final int cost[] = { 0, 60, 0, 60, 0, 100, 0, 100, 120, 0, 140, 150, 140, 160, 180, 0, 180, 200, 0, 220, 0,
			220, 240, 260, 260, 150, 280, 0, 300, 300, 0, 320, 0, 350, 0, 400 };
	static final Color colors[] = { new Color(20, 120, 50), new Color(66, 40, 14), new Color(20, 80, 140),
			new Color(66, 40, 14), new Color(147, 151, 143), new Color(50, 168, 168), new Color(166, 111, 50),
			new Color(50, 168, 168), new Color(50, 168, 168), new Color(255, 102, 0), new Color(202, 0, 202),
			new Color(255), new Color(202, 0, 202), new Color(202, 0, 202), new Color(253, 177, 0),
			new Color(20, 80, 140), new Color(253, 177, 0), new Color(253, 177, 0), new Color(180, 60, 20),
			new Color(255, 0, 0), new Color(166, 111, 50), new Color(255, 0, 0), new Color(255, 0, 0),
			new Color(214, 228, 24), new Color(214, 228, 24), new Color(246, 255, 105), new Color(214, 228, 24),
			new Color(0, 50, 255), new Color(0, 255, 75), new Color(0, 255, 75), new Color(20, 80, 140),
			new Color(0, 255, 75), new Color(166, 111, 50), new Color(0, 255, 20), new Color(125),
			new Color(0, 255, 20) };
	static final int boardX[] = { 900, 800, 700, 600, 500, 400, 300, 200, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 200,
			300, 400, 500, 600, 700, 800, 900, 900, 900, 900, 900, 900, 900, 900, 900 };
	static final int boardY[] = { 900, 900, 900, 900, 900, 900, 900, 900, 900, 900, 800, 700, 600, 500, 400, 300, 200,
			100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 200, 300, 400, 500, 600, 700, 800 };

	final ArrayList<Tile> tiles = new ArrayList<>();
	final ArrayList<Player> players = new ArrayList<>();
	final JFrame frame = new JFrame();

	public Board() {
		for (int i = 0; i < names.length; i++) {
			tiles.add(new Tile(colors[i], names[i], boardX[i], boardY[i]));
		}
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1000, 1000));
		frame.pack();
		frame.setVisible(true);


	}
	@Override
	public void paintComponent(Graphics g) {
for(Tile tile:tiles) {
	tile.draw(g);
}

	}
}
