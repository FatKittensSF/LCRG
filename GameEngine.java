import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
	private int pot = 0;
	private ArrayList<Player> allPlayers;
	int currentPlayer;
	Player winner;
	Random rand = new Random();
	boolean gameState = true;
	public GameEngine(int players)
	{
		allPlayers = new ArrayList<Player>();
		currentPlayer = 0;
		for(int x = 0; x < players;x++)
		{
			allPlayers.add(new Player(x));
		}
	}
	
	public int getRoll()
	{
		int temp = 0;
		temp = rand.nextInt(5)+1;
		return temp;
	}
	
	public void playGame()
	{
		int[] rolls = new int[3];
		rolls[0] = getRoll();
		rolls[1] = getRoll();
		rolls[2] = getRoll();
		int temp = 0;
		for (Player x: allPlayers)
		{
			if (x.playerStillPlaying())
				{
					winner = x;
					temp++;
				}
		}
		
		if (temp >1){
			if(allPlayers.get(currentPlayer).playerStillPlaying()){
				for(int x: rolls)
				{
					if (x == 1)
					{
						System.out.println("you have Rolled a L");
						if(currentPlayer == 0) 
							{
								allPlayers.get(allPlayers.size()-1).addChips(1);
								
							}
						else if (currentPlayer !=0)
						{
							allPlayers.get(currentPlayer).removeChips(1);
							allPlayers.get(currentPlayer-1).addChips(1);
						}
					}
					
					else if (x == 3)
					{
						System.out.println("you gave rolled a C");
						{
							allPlayers.get(currentPlayer).removeChips(1);
							pot += 1;
						}
					}
					
					else if(x==5)
					{
						System.out.println("you have rolled a R");
						if (currentPlayer == allPlayers.size()-1)
							{
								allPlayers.get(0).addChips(1);
								allPlayers.get(currentPlayer).removeChips(1);
							}
					}
				}
			}
		}
		
		if (temp <2) gameState = false;
		if(currentPlayer == allPlayers.size()-1) currentPlayer = 0;
		else
		{
			currentPlayer++;
		}
	}
	
	
	public boolean gameOver()
	{
		return gameState;
	}
	
	public int getPlayer()
	{
		return currentPlayer;
	}

}
