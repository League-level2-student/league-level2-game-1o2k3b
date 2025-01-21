import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class hello {
public static void main(String[] args) {
hello h = new hello();
h.run();
}
public void run() {
String options[][] = { {"film", "tech"}, {"Science", "Math" }, {"Tech", "PE" }, {"Film", "PE"}, {"Social Studies", "Spanish"}, 
		{"Social Studies", "Science"}, {"Math", "Social Studies" }, {"Spanish", "Math" }, {"Club", "Film" }, {"Club", "PE" }};
Random r = new Random();
String nouns[] = {"badger", "tiger", "monkey", "donkey", "Kangaroo", "cheetah", "rabbit", "wolf", "Lion", "turtle"};
String adjectives[] = {"rambunctious", "idiotic", "gargantuan", "lazy", "speedy", "small", "stupid", "fun", "funny", "rich"};
JFrame frame = new JFrame();
JPanel panel = new JPanel();
frame.add(panel);
frame.setVisible(true);
frame.setSize(200, 200);
int p = r.nextInt(10);
int z = r.nextInt(10);

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
for(int i = 0; i<options.length; i++) {
		JOptionPane.showOptionDialog
		(frame.getContentPane(), "Which Class?", "Question " + (i+1), 0, JOptionPane.INFORMATION_MESSAGE, null, options[i], null);
}
JOptionPane.showMessageDialog(null, "you are a " + nouns[p] + " " + nouns[z] + "!");
}
}
