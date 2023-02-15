import java.util.Scanner;

public abstract class Location 
{
	protected Player player;
	protected String name;
	
	Scanner input = new Scanner(System.in);
	
	Location(Player player)		// constaction'ın içine nesneyi de atabiliyoruz.
	{
		this.player = player;
	}
	
	
	public abstract boolean getLocation();
	
	
	
	
	
	
	
	
	public Player getPlayer()		// Türü olarak sınıfının ismini yazdım.
	{
		return player;
	}
	
	public void setPlayer(Player p)		// Türü olarak sınıfının ismini yazdım.
	{
		this.player = p;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		this.name = n;
	}

}
