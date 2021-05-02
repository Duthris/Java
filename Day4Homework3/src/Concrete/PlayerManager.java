package Concrete;

import Abstract.PlayerCheckService;
import Abstract.PlayerService;
import Entities.Player;

public class PlayerManager implements PlayerService
{
	private PlayerCheckService playerCheckService;
	
	public PlayerManager(PlayerCheckService playerCheckService) 
	{
		this.playerCheckService = playerCheckService;
	}

	@Override
	public void add(Player player) 
	{
		if (playerCheckService.checkIfRealPlayer(player) == true)
		{
			System.out.println("\nValidation is succeed: " + player.getFirstName() + " is added successfully!");
		}
		
		else 
		{
			System.out.println("\nValidation Error: " + player.getFirstName() + " is NOT a valid person!");
		}
	}

	@Override
	public void save(Player player) 
	{
		if (playerCheckService.checkIfRealPlayer(player) == true)
		{
			System.out.println("\nValidation is succeed: " + player.getFirstName() + " is saved to db successfully!");
		}
		
		else 
		{
			System.out.println("\nValidation Error: " + player.getFirstName() + " is NOT a valid person!");
		}		
	}

	@Override
	public void delete(Player player) 
	{
		if (playerCheckService.checkIfRealPlayer(player) == true)
		{
			System.out.println("\nValidation is succeed: " + player.getFirstName() + " is deleted successfully!");
		}
		
		else 
		{
			System.out.println("\nValidation Error: " + player.getFirstName() + " is NOT a valid person!");
		}		
	}

	@Override
	public void update(Player player) 
	{
		if (playerCheckService.checkIfRealPlayer(player) == true)
		{
			System.out.println("\nValidation is succeed: " + player.getFirstName() + " is updated successfully!");
		}
		
		else 
		{
			System.out.println("\nValidation Error: " + player.getFirstName() + " is NOT a valid person!");
		}		
	}
	
}
