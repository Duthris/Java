package Concrete;

import Abstract.GameService;
import Entities.Campaign;
import Entities.Game;

public class GameManager implements GameService
{
	Game[] games;

	@Override
	public void add(Game game) 
	{
		System.out.println(game.getName() + " is added in games!");
	}

	@Override
	public void update(Game game) 
	{
		System.out.println(game.getName() + " is updated successfully!");
	}

	@Override
	public void delete(Game game) 
	{
		System.out.println(game.getName() + " is deleted from games!");
	}
	
	@Override
	public void getAllGames(Game[] games)
	{
		System.out.println("\n############ ALL GAMES ############");
		
		for (Game game : games) 
		{
			System.out.print("\nGame ID: " + game.getId() + "\nGame Name: " + game.getName() + "\nPrice: " + game.getPrice() 
			+ "\n--------------------------------------------\n");
		}
	}

}
