package Concrete;

import Abstract.SaleService;
import Entities.Campaign;
import Entities.Game;
import Entities.Player;
import Entities.Sale;

public class SaleManager implements SaleService
{
	Sale[] sales;

	@Override
	public void sale(Player player, Game game) 
	{
		System.out.println("\n" + player.getFirstName() + " " + player.getLastName() + " bought " + game.getName()
							+ " ($" + game.getPrice() + ") \nNew Balance of " + player.getFirstName() + ": $" + (player.getBalance() - game.getPrice()));
		
		
	}

	@Override
	public void saleWithDiscount(Player player, Game game, Campaign campaign) 
	{
		System.out.println("\n" + player.getFirstName() + " " + player.getLastName() + " bought " + game.getName()
		+ " with the " + campaign.getName() + " Campaign. \nThe Price is Lowered from " + " ($" + game.getPrice() + ") to ($" + 
						(game.getPrice() - (game.getPrice() * campaign.getDiscount() / 100) + ") with " + campaign.getDiscount() + "% discount. "
								+ "\nNew Balance of " + player.getFirstName() + ": $" + (player.getBalance() - game.getPrice())));
	}

}
