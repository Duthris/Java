package Abstract;

import Entities.Campaign;
import Entities.Game;
import Entities.Player;

public interface SaleService 
{
	void sale(Player player, Game game);
	void saleWithDiscount(Player player, Game game, Campaign campaign);
}
