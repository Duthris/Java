package Concrete;

import Abstract.PlayerCheckService;
import Entities.Player;

public class PlayerCheckManager implements PlayerCheckService
{
	@Override
	public boolean checkIfRealPlayer(Player player) 
	{
		return true;
	}
}
