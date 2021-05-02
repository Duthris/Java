package Entities;

import java.util.Date;

import Abstract.Entity;

public class Sale implements Entity 
{
	private Date saleTime;
	private int id;
	private String playerName;
	private String gameName;
	private String customerName;
	
	public Sale()
	{
		
	}

	public Sale(Date saleTime, int id, String playerName, String gameName, String customerName) 
	{
		this.saleTime = saleTime;
		this.id = id;
		this.playerName = playerName;
		this.gameName = gameName;
		this.customerName = customerName;
	}

	public Date getSaleTime() 
	{
		return saleTime;
	}

	public void setSaleTime(Date saleTime)
	{
		this.saleTime = saleTime;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	public String getGameName()
	{
		return gameName;
	}

	public void setGameName(String gameName) 
	{
		this.gameName = gameName;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	
	
	
	
}
