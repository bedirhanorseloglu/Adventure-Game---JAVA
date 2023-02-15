import java.util.Scanner;

public class Player 
{
	private int damage , health , money , rHealth;  // rHealth = oyun içindeki can
	private String playersName , chaName;
	Inventory ınv;		// Nesne oluşturduk.
	Scanner input = new Scanner(System.in);
	
	
	Player(String pN)
	{
		this.playersName = pN;
		this.ınv = new Inventory();
	}
	
	
	public void selectCha()
	{
		switch(chaMenu())
	  {
		case 1 :
			initPlayer("Samuray" , 5 , 21 , 15);
			break;
			
		case 2:
			initPlayer("Okcu" , 7 , 18 , 20);
			break;
			
		case 3:
			initPlayer("Sovalye" , 8 , 24 , 5);

			break;			
	  }
		System.out.println("Sectigin karakter: "+getName()+ " ; "+"Hasar:"+getDamage()+" ; "+"Saglik:"+getHealth()+" ; "+"Para:"+getMoney());

	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	public int chaMenu()
	{
		System.out.println("Lutfen bir karakter sec:");
		System.out.println("1- Samuray :\tHasar:5 \tSaglik:21\tPara:15");
		System.out.println("2- Okcu :\tHasar:7 \tSaglik:18\tPara:20");
		System.out.println("3- Sovalye :\tHasar:8 \tSaglik:24\tPara:5");
		System.out.print("Secimin:");
		int chaID = input.nextInt();
		
		while(chaID < 1 || chaID > 3)
		{
			System.out.println("Lutfen gecerli bir karakter sec !!");
			System.out.print("Secimin:");
			chaID = input.nextInt();
		}
		return chaID;
	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	public void initPlayer(String name , int damage , int health , int money)
	{
		setName(name);
		setDamage(damage);
		setHealth(health);
		setMoney(money);
		setrHealth(health);
	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	public int TotalDamage()
	{
		return this.getDamage() + this.getInv().getDamage();
	}
	
	// -------------------------------------------------------------------------------------------------------------
	
	
	public String getName()
	{
		return this.chaName;
	}
	
	public void setName(String n)
	{
		this.chaName = n;
	}
	
	
	public int getDamage( )
	{
		 return this.damage;
	}
	
	public void setDamage(int d)
	{
		this.damage = d;
	}
	
	
	public int getHealth()
	{
		return this.health;
	}
	
	public void setHealth(int h)
	{
		this.health = h;
	}
	
	
	public int getMoney()
	{
		return this.money;
	}
	
	public void setMoney(int m)
	{
		this.money = m;
	}
	
	
	
	public Inventory getInv()  // DİKKAT ET NESNENİN GETTER-SETTER'I
	{
		return ınv;
	}


	public void setInv(Inventory inv)
	{
		ınv = inv;
	}


	public int getrHealth() 
	{
		return rHealth;
	}


	public void setrHealth(int rHealth) 
	{
		this.rHealth = rHealth;
	}
	
	
	
	
}

	

