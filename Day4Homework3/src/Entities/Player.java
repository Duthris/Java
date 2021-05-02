package Entities;

import java.util.Date;

import Abstract.Entity;

public class Player implements Entity 
{
	private int id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String nationalityId;
	private double balance;
	private Game[] games;
	
	public Player()
	{
		
	}
	
	public Player(int id, String firstName, String lastName, Date dateOfBirth, String nationalityId, double balance,
			Game[] games) 
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.nationalityId = nationalityId;
		this.balance = balance;
		this.games = games;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public Date getDateOfBirth() 
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) 
	{
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationalityId() 
	{
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) 
	{
		this.nationalityId = nationalityId;
	}

	public double getBalance() 
	{
		return balance;
	}

	public void setBalance(double balance) 
	{
		this.balance = balance;
	}

	public Game[] getGames() 
	{
		return games;
	}

	public void setGames(Game[] games) 
	{
		this.games = games;
	}
	
	
}
