package Abstract;

import Entities.Player;

public interface PlayerService 
{
	void add(Player player);
	void save(Player player);
	void delete(Player player);
	void update(Player player);
}
