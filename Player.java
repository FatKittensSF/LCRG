
public class Player {
	int chips = 40;
	int playerID;
	boolean playable = true;
	public Player(int playerID)
	{
		this.playerID = playerID;
	}
	public void addChips(int chip)
	{
		chips += chip;
	}
	
	public int removeChips(int chip)
	{
		if(chip > chips)
		{
			System.out.println("player: " + playerID + " is now out of the game");
			playable = false;
			return chips;
			
		}
		else 
		{
			chips -= chip;
			return chip;
		}
		
		
	}
	
	public boolean playerStillPlaying()
	{
		return playable;
	}

}
