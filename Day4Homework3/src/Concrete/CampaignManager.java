package Concrete;

import Abstract.CampaignService;
import Entities.Campaign;
import Entities.Game;

public class CampaignManager implements CampaignService
{
	Campaign[] campaigns;
	
	@Override
	public void applyDiscount(Game game, Campaign campaign) 
	{
		System.out.println("\n" + campaign.getName() + " is applied to " + game.getName() + " with " 
								+ campaign.getDiscount() + "% discount!" + "\nOld Price: " + game.getPrice() 
								+ "\nNew Price: " + (game.getPrice() - (game.getPrice() * campaign.getDiscount() / 100)));	
	}

	@Override
	public void add(Campaign campaign) 
	{
		System.out.println("\n" + campaign.getName() + " is successfully added. \nDiscount Rate: " + campaign.getDiscount() + "%");
	}

	@Override
	public void update(Campaign campaign) 
	{
		System.out.println("\n" + campaign.getName() + " is successfully updated.");
	}

	@Override
	public void delete(Campaign campaign) 
	{
		System.out.println("\n" + campaign.getName() + " is successfully deleted.");
	}

	@Override
	public void getAllCampaigns(Campaign[] campaigns) 
	{
		System.out.println("\n############ ALL CAMPAIGNS ############");
		
		for (Campaign campaign : campaigns) 
		{
			System.out.print("\nCampaign ID: " + campaign.getId() + "\nCampaign Name: " + campaign.getName() + " || Discount Rate: " + campaign.getDiscount() 
			+ "\n--------------------------------------------\n");
		}
	}
	
}
