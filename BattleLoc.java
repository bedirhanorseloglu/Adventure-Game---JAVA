
public abstract class BattleLoc extends Location
{
	Obstacle obstacle;  // Bu sınıfta canavar sınıfını kullanacağım için çağırdım.
	String award;
	Location location;
	
	BattleLoc(Player player , String name , Obstacle obstacle , String award)
	{
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}
	
	
	
	@Override
	public boolean getLocation()
	{
		int obsCount = obstacle.obsCount();
		System.out.println("Su an bulundugunuz yer: " + this.getName()); // this. getName() dedik çünkü birden fazla getName() metodu var.
		System.out.println("Dikkatli ol ! Burada " + obsCount + " tane " + obstacle.getName() + " yasiyor !");
		System.out.println("<S>avas mi istersin <K>acmak mi ?");
		String selCase = input.next();
		selCase = selCase.toUpperCase(); // Küçük har girerse diye.
		
		if(selCase.equals("S") )
		{
			if(combat(obsCount))
			{
				System.out.println(this.getName() + " bolgesindeki tum " + obstacle.getName() + "'leri(lari) oldurdunuz...");
				
				if(this.award.equals("Food") && player.getInv().isFood() == false)
				{
					System.out.println(this.award + " kazandiniz!");
					player.getInv().setFood(true);
				}
				
				if(this.award.equals("Water") && player.getInv().isWater() == false)
				{
					System.out.println(this.award + " kazandiniz!");
					player.getInv().setWater(true);
				}
				
				if(this.award.equals("Firewood") && player.getInv().isFirewood() == false)
				{
					System.out.println(this.award + " kazandiniz!");
					player.getInv().setFirewood(true);
				}
				
				return true;
			}
			
			if(player.getHealth() <= 0) 
			{
				System.out.println("OLDUNUZ !!!");
				return false;
			}	
		}
		return true;
	}
	
	
	
	public boolean combat(int obsCount)
	{
		for(int i = 0 ; i < obsCount ; i++)
		{
			int defObsHealth = obstacle.getHealth(); // Her for döngüsünde canavarın canı yenilensin diye.
			playerStats();
			enemyStats();
			System.out.println();
			
			while(player.getHealth() > 0 && obstacle.getHealth() > 0)
			{
				System.out.println("<V>ur veya <G>eri cekil:");
				String selCase2 = input.next();
				selCase2 = selCase2.toUpperCase();
				
				if(selCase2.equals("V"))
				{
					System.out.println("Canavara hasar verdiniz...");
					obstacle.setHealth((obstacle.getHealth() - player.TotalDamage()));
					
					if(obstacle.getHealth() > 0)
					{
						System.out.println();
						System.out.println("Canvar size hasar verdi...");
						player.setHealth((player.getHealth() - (obstacle.getDamage()-player.getInv().getArmor())));
						afterHit();	
					}					
				}
				
				else 
				{
					System.out.println("Canavara vurmaktan geri cekildiniz...");
					return false;
				}
				
				
		} // while bitti
			
			if(obstacle.getHealth() <= 0 && player.getHealth() > 0)
			{
				System.out.println("Dusmani yendiniz...");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Guncel paraniz:" + player.getMoney());
				obstacle.setHealth(defObsHealth);
			}
			
			else
			{
				return false;
			}
			System.out.println("-------------------------------");
		} // for bitti.
		
		return true;
	} // metod bitti
	
	
	
	public void playerStats()
	{
		System.out.println("OYUNCU DEGERLERI:\n--------------");
		System.out.println("Can:" + player.getHealth());
		System.out.println("Hasar:" + player.TotalDamage());
		System.out.println("Para:" + player.getMoney());
		if(player.getInv().getDamage() != 0)
		{
			System.out.println("Silah:" + player.getInv().getWeaponName());
		}
		
		if(player.getInv().getArmor() != 0)
		{
			System.out.println("Zirh:" + player.getInv().getArmorName());
		}
		System.out.println("-----------------------------------------------");
	}
	
	
	
	public void enemyStats()
	{
		System.out.println("DUSMAN DEGERLERI:\n-------------");
		System.out.println("Can:" + obstacle.getHealth());
		System.out.println("Hasar:" + obstacle.getDamage());
		System.out.println("Oldururseniz alacaginiz odul:" + obstacle.getAward());
	}
	
	
	
	public void afterHit()
	{
		System.out.println("Oyuncu cani:" + player.getHealth());
		System.out.println(obstacle.getName() + " Cani:" + obstacle.getHealth());
	}
	
	
	
}
