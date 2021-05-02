package Abstract;

import Entities.Campaign;
import Entities.Game;

public interface CampaignService 
{
	void applyDiscount(Game game, Campaign campaign);
	void add(Campaign campaign);
	void update(Campaign campaign);
	void delete(Campaign campaign);
	void getAllCampaigns(Campaign[] campaigns);
}
