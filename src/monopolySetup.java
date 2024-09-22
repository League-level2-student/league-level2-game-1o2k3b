import java.awt.*;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

public class monopolySetup extends JPanel implements ActionListener {

	JFrame frame = new JFrame();
	JLabel money = new JLabel();
	int cash = 1500;
	players p = new players();
	int boardspace = 0;
	int i = 0;
	Random r = new Random();
	
	Tile tiles[] = new Tile[40];
	JButton button = new JButton();
	String names[] ={"go", "baltic", "chest", "medditaranian", "income tax", "oriental", "chance", "vermont", "conneticut", "jail", "st.Charles", "electric company", "states", "virginia"
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
		draw(g);
			

			

	}

	
	public void setup() {
		frame.setSize(1000, 1050);
		frame.setVisible(true);
		frame.add(this);
		this.setLayout(null);
		this.add(button);
		this.add(p.one);
		this.add(money);
		p.one.setBounds(900, 900, 25, 25);
		money.setBounds(150, 150, 200, 50);
		money.setText("money: " + cash);
		button.setBounds(500, 500, 100, 50);
		p.one.setOpaque(true);
		p.one.setBackground(Color.black);
		button.setText("roll");
		button.addActionListener(this);
		
for(i = 0; i<36; i++) {
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


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == button) {
		int ran = r.nextInt(12)+1;
		
		boardspace += ran;
		boardspace%=36;
		String buying = JOptionPane.showInputDialog("buy " + names[boardspace] + " for " + cost[boardspace] + " dollars?");
if(buying.equals("yes")) {
	cash-=cost[boardspace];
	money.setText("money: " + cash);
}
		System.out.println(boardspace);
		p.one.setBounds(xs[boardspace], ys[boardspace], 25, 25);
		}
	}
}
