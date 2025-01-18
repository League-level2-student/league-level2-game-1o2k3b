package monopolyPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	static final String names[] = { "go", "baltic", "chest", "medditaranian", "income tax", "oriental", "chance",
			"vermont", "conneticut", "jail", "st.Charles", "electrical", "states", "virginia", "st.James Place",
			"chest", "tennessee", "new York", "free Parking", "Kentucky", "chance", "Indiana", "Illinois", "atlantic",
			"ventnor", "water Works", "marvin Gardens", "go to jail", "pacific", "north Carolina", "chest",
			"Pensylvania", "chance", "park place", "luxury tax", "boardwalk" };
	static Map<Color, String[]> map = new HashMap<>();
	static final String sets[][] = { { "baltic", "medditaranian" }, { "oriental", "vermont", "conneticut" },
			{ "st.Charles", "states", "virginia" }, { "st.James Place", "tennessee", "new York" },
			{ "Kentucky", "Indiana", "Illinois" }, { "atlantic", "ventnor", "marvin Gardens" },
			{ "pacific", "north Carolina", "Pensylvania" }, { "park place", "boardwalk" } };
	static final int cost[] = { 0, 60, 0, 60, 0, 100, 0, 100, 120, 0, 140, 150, 140, 160, 180, 0, 180, 200, 0, 220, 0,
			220, 240, 260, 260, 150, 280, 0, 300, 300, 0, 320, 0, 350, 0, 400 };
	static Map<Color, String> colorToString = new HashMap();

	static final Color colors[] = { new Color(20, 120, 50), // go
			new Color(66, 40, 14), // brown
			new Color(20, 80, 140), // chest
			new Color(66, 40, 14), // brown
			new Color(147, 151, 143), // income tax
			new Color(50, 168, 168), // light blue
			new Color(166, 111, 50), // chance
			new Color(50, 168, 168), // light blue
			new Color(50, 168, 168), // light blue
			new Color(255, 102, 0), // jail
			new Color(202, 0, 202), // pink
			new Color(255), // electric
			new Color(202, 0, 202), // pink
			new Color(202, 0, 202), // pink
			new Color(253, 177, 0), // orange
			new Color(20, 80, 140), // chance
			new Color(253, 177, 0), // orange
			new Color(253, 177, 0), // orange
			new Color(180, 60, 20), // free parking
			new Color(255, 0, 0), // red
			new Color(166, 111, 50), // chance
			new Color(255, 0, 0), // red
			new Color(255, 0, 0), // red
			new Color(214, 228, 24), // yellow
			new Color(214, 228, 24), // yellow
			new Color(246, 255, 105), // water works
			new Color(214, 228, 24), // yellow
			new Color(0, 50, 255), // go to jail
			new Color(0, 255, 75), // green
			new Color(0, 255, 75), // green
			new Color(20, 80, 140), // chest
			new Color(0, 255, 75), // green
			new Color(166, 111, 50), // chance
			new Color(0, 0, 128), // dark blue
			Color.blue, // luxury tax
			new Color(0, 0, 128) };// dark blue
	static final int boardX[] = { 900, 800, 700, 600, 500, 400, 300, 200, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 200,
			300, 400, 500, 600, 700, 800, 900, 900, 900, 900, 900, 900, 900, 900, 900 };
	static final int boardY[] = { 900, 900, 900, 900, 900, 900, 900, 900, 900, 900, 800, 700, 600, 500, 400, 300, 200,
			100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 200, 300, 400, 500, 600, 700, 800 };
	Color pColor[] = { Color.red, Color.pink, Color.cyan, Color.blue };
	static final ArrayList<Tile> tiles = new ArrayList<>();
	static final ArrayList<Player> players = new ArrayList<>();
	static Turn turn = new Turn();
	static final JFrame frame = new JFrame();
	JButton button = new JButton();
	Timer time = new Timer(1000 / 60, this);

	static Board bInstance;

	public Board() {
		// TODO map.put("", sets[]);
		map.put(new Color(66, 40, 14), sets[0]);
		map.put(new Color(50, 168, 168), sets[1]);
		map.put(new Color(202, 0, 202), sets[2]);
		map.put(new Color(253, 177, 0), sets[3]);
		map.put(new Color(255, 0, 0), sets[4]);
		map.put(new Color(214, 228, 24), sets[5]);
		map.put(new Color(0, 255, 75), sets[6]);
		map.put(new Color(0, 0, 128), sets[7]);

		colorToString.put(new Color(66, 40, 14), "Brown");
		colorToString.put(new Color(50, 168, 168), "Light Blue");
		colorToString.put(new Color(202, 0, 202), "purple");
		colorToString.put(new Color(253, 177, 0), "orange");
		colorToString.put(new Color(255, 0, 0), "Red");
		colorToString.put(new Color(214, 228, 24), "yellow");
		colorToString.put(new Color(0, 255, 75), "green");
		colorToString.put(new Color(0, 0, 128), "dark blue");

		bInstance = this;
		for (int i = 0; i < names.length; i++) {
			if (cost[i] == 0) {
				tiles.add(new Tile(colors[i], names[i], boardX[i], boardY[i]));
			} else {
				tiles.add(new Property(colors[i], names[i], cost[i], boardX[i], boardY[i]));
			}

		}
		for (int i = 0; i < 4; i++) {
			players.add(new Player(JOptionPane.showInputDialog("what will be your name Player " + (i + 1) + "?"),
					pColor[i], i));

		}
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1000, 1000));
		this.setLayout(null);
		frame.pack();
		frame.setVisible(true);
		this.add(button);
		button.setBounds(400, 450, 200, 100);
		button.setOpaque(true);
		button.setBackground(Color.LIGHT_GRAY);
		button.setText("player " + players.get(turn.whichPlayer).name + "'s turn.");
		button.addActionListener(this);

		time.start();
	}

	static public Board getBoard() {
		return bInstance;
	}

	@Override
	public void paintComponent(Graphics g) {
		for (Tile tile : tiles) {
			tile.draw(g);
		}
		for (Player play : players) {
			play.draw(g);

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// runs the turn system within the turn class

		if (arg0.getSource() == time) {
			repaint();
		} else {
			turn.roll();

			if (tiles.get(players.get(turn.whichPlayer).currentTile) instanceof Property) {
				// TODO: if not owned by anyone....
				if (((Property) tiles.get(players.get(turn.whichPlayer).currentTile)).owner == -1) {
					turn.purchase();
				} else if (((Property) tiles
						.get(players.get(turn.whichPlayer).currentTile)).owner != Turn.whichPlayer) {
					// find out which tile it is an perform the right action...
					turn.pay();
				}

			}
			if (tiles.get(players.get(turn.whichPlayer).currentTile).name.equals("chance")) {
				turn.chance();
			}
			if (tiles.get(players.get(turn.whichPlayer).currentTile).name.equals("chest")) {
				turn.chest();
			}
			if (tiles.get(players.get(turn.whichPlayer).currentTile).name.equals("income tax")) {
				turn.incomeTax();
			}
			turn.updateWhichPlayer();
			button.setText("player " + players.get(turn.whichPlayer).name + "'s turn.");
		}

	}
	// TODO:.. land on Jail... skip it?

}
