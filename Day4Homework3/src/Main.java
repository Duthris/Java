import java.util.Date;

import Adapters.MernisServiceAdapter;
import Concrete.CampaignManager;
import Concrete.GameManager;
import Concrete.PlayerManager;
import Concrete.SaleManager;
import Entities.Campaign;
import Entities.Game;
import Entities.Player;
import Entities.Sale;

public class Main 
{

	public static void main(String[] args) 
	{
		Game rdr2 = new Game();
		rdr2.setId(1);
		rdr2.setName("Red Dead Redemption 2");
		rdr2.setPrice(199);
		
		Game csgo = new Game();
		csgo.setId(2);
		csgo.setName("Counter Strike - Global Offensive");
		csgo.setPrice(60);
		
		Game witcher3 = new Game();
		witcher3.setId(3);
		witcher3.setName("The Witcher 3");
		witcher3.setPrice(49);
		
		
		
		Player player1 = new Player();
		player1.setId(1);
		player1.setFirstName("Anýl");
		player1.setLastName("Yalýmdemir");
		player1.setDateOfBirth(new Date(2000,7,20));
		player1.setNationalityId("12345678910");
		player1.setBalance(200);
		
		Player player2 = new Player();
		player2.setId(2);
		player2.setFirstName("Engin");
		player2.setLastName("Demiroð");
		player2.setDateOfBirth(new Date(1985,1,7));
		player2.setNationalityId("28861499108");
		player2.setBalance(300);
		
		
		
		Campaign summerCampaign = new Campaign();
		summerCampaign.setId(1);
		summerCampaign.setName("Summer Campaign");
		summerCampaign.setDiscount(15);
		
		Campaign winterCampaign = new Campaign();
		winterCampaign.setId(2);
		winterCampaign.setName("Winter Campaign");
		winterCampaign.setDiscount(12);
		
		Campaign blackFridayCampaign = new Campaign();
		blackFridayCampaign.setId(3);
		blackFridayCampaign.setName("Black Friday Campaign");
		blackFridayCampaign.setDiscount(20);
		
		
		Game[] games = {rdr2, csgo, witcher3};
		
		Campaign[] campaigns = {summerCampaign, winterCampaign, blackFridayCampaign};
		
		
		GameManager gameManager = new GameManager();
		gameManager.add(rdr2);
		gameManager.add(csgo);
		gameManager.add(witcher3);
		gameManager.update(witcher3);
		gameManager.update(csgo);
		gameManager.getAllGames(games);
		
		PlayerManager playerManager = new PlayerManager(new MernisServiceAdapter());
		playerManager.add(player1);
		playerManager.update(player1);
		playerManager.delete(player1);
		playerManager.add(player2);
		playerManager.save(player2);
		playerManager.update(player2);
		
		CampaignManager campaignManager = new CampaignManager();
		campaignManager.add(summerCampaign);
		campaignManager.add(winterCampaign);
		campaignManager.add(blackFridayCampaign);
		campaignManager.update(blackFridayCampaign);
		campaignManager.getAllCampaigns(campaigns);
		campaignManager.applyDiscount(witcher3, blackFridayCampaign);
		
		SaleManager saleManager = new SaleManager();
		saleManager.sale(player2, witcher3);
		saleManager.saleWithDiscount(player2, rdr2, blackFridayCampaign);
	}

}
