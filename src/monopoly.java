import java.util.ArrayList;

public class monopoly {

	
	
	ArrayList<String> chararcters = new ArrayList<String>();
	
	int boardSpace = 0;
	
	public static void main(String[] args) {
		monopolySetup s = new monopolySetup();
		s.Setup();
	}

}







// instead of getting the location of a player to get the space they're on in the board I do vice versa, and use the space theyre on to get there location.