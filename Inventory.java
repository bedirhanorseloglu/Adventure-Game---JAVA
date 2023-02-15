
public class Inventory 
{
	private boolean water , food , firewood;
	private String weaponName , armorName;
	private int damage , armor;
	
	
	Inventory()
	{
		this.water = false;
		this.food = false;
		this.firewood = false;
		this.weaponName = null;
		this.armorName = null;
	}


	public boolean isWater() 
	{
		return water;
	}


	public void setWater(boolean w) 
	{
		this.water = w;
	}


	public boolean isFood() {
		return food;
	}


	public void setFood(boolean f) 
	{
		this.food = f;
	}


	public boolean isFirewood() 
	{
		return firewood;
	}


	public void setFirewood(boolean fi)
	{
		this.firewood = fi;
	}


	public String getWeaponName() 
	{
		return weaponName;
	}


	public void setWeaponName(String wN) 
	{
		this.weaponName = wN;
	}


	public String getArmorName()
	{
		return armorName;
	}


	public void setArmorName(String aN) 
	{
		this.armorName = aN;
	}


	public int getDamage() 
	{
		return damage;
	}


	public void setDamage(int d)
	{
		this.damage = d;
	}


	public int getArmor() 
	{
		return armor;
	}


	public void setArmor(int a) 
	{
		this.armor = a;
	}
	
	
	
	
}
