import javax.swing.JOptionPane;

public class Engine {
	
	public static void main(String[] args)
	{
		String x = JOptionPane.showInputDialog("please type the amount of players here");
		
		GameEngine game = new GameEngine(Integer.parseInt(x));
		while(game.gameOver())
		{
			System.out.println("the current Player is " + game.getPlayer());
			game.playGame();
			
	
		}
		System.out.println("the game is OVVVERRRRR");
		
	}

}
