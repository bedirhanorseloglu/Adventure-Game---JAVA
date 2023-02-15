import java.util.Random;

public class Obstacle
{
	private String name;
	private int damage , health , award , maxNumber;
	
	public Obstacle(String name , int damage , int health , int award , int maxNumber)
	{
		this.name = name;
		this.damage = damage;
		this.health = health;
		this.award = award;
		this.maxNumber = maxNumber;
	}
	
	
	
	public int obsCount()
	{
		Random random = new Random();
		return random.nextInt(this.maxNumber) + 1; // min 0 diye bir ekledik.
	}
	
	
	

	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		this.name = n;
	}
	
	
	
	public int getDamage()
	{
		return damage;
	}
	
	public void setDamage(int d)
	{
		this.damage = d;
	}
	
	
	
	public int getHealth()
	{
		return health;
	}
	
	public void setHealth(int h)
	{
		this.health = h;
	}
	
	
	
	public int getAward()
	{
		return award;
	}
	
	public void setAward(int a)
	{
		this.award = a;
	}
	
	
	
	public int getMaxNumber()
	{
		return maxNumber;
	}
	
	public void setNumber( int mN)
	{
		this.maxNumber = mN;
	}
	
	
	
	
	

}
