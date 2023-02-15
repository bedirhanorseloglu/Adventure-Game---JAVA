
public class ToolStore extends NormalLoc
{
	ToolStore(Player player )
	{
		super(player , "Magaza");
	}
	
	
	@Override
	public boolean getLocation()
	{
		System.out.println("Su anki paraniz:" + player.getMoney());
		System.out.println("1. Silahlar");
		System.out.println("2. Zirhlar");
		System.out.println("3. CIKIS");
		System.out.print("Seciminiz:");
		int selTool = input.nextInt();  
		int selItemID;					
		
		switch (selTool)
		{
		case 1: 
			
			selItemID = weaponMenu();	// buyWeapon(weaponMenu()) yapmış olduk
			buyWeapon(selItemID);
			break;
			
		case 2:
			selItemID = armorMenu();
			buyArmor(selItemID);	
			break;
	
		}
		
		return true;
	}
	
// -------------------------------------------------------------------------------------------------------------
	
	public int weaponMenu()		// Burada silah menüsünü gösteriyoruz.
	{
		System.out.println("1. Tabanca\t < Para:25 - Hasar:2 >");
		System.out.println("2. Kilic\t < Para:35 - Hasar:3 >");
		System.out.println("3. Tufek\t < Para:45 - Hasar:7 >");
		System.out.println("4. CIKIS");
		System.out.print("Silah Seciminiz:");
		int selWeaponID = input.nextInt();
		return selWeaponID;
		
	}
	
// -------------------------------------------------------------------------------------------------------------
	
	public void buyWeapon(int item)		//Burada silah alıp damage'imizi arttıracağız.
	{
		int damage = 0 , price = 0;
		String weaponName = null;
		switch(item)
	  {
		case 1 :
			damage = 2;
			weaponName = "Tabanca";
			price = 25; 
			break;
			
		case 2 :
			damage = 3;
			weaponName = "Kilic";
			price = 35;
			break;
			
		case 3 :
			damage = 7;
			weaponName = "Tufek";
			price = 45;
			break;
			
		case 4 :
			System.out.println("Magazadan cikis yaptiniz.");
			break;
			
			default:
				System.out.println("Gecersiz Islem !!!!");
				break;
	  }
		
		if(player.getMoney() >= price && item != 4)
		{
			player.getInv().setDamage(damage);  // Player sınıfındaki getInv() methoduna git burada zaten "retrun ınv" var yani seni Inventory sınıfına götürüyor sonra  da Inventory sınıfındaki setDamage methoduna git ve içine damage'ı koy.
												// Yani aslında oyuncunun envanterindeki hasarı arttır diyoruz türkçe olarak.
			player.getInv().setWeaponName(weaponName);
			player.setMoney(player.getMoney() - price);
			System.out.print(weaponName + " " + "satin aldiniz." + " ");
			System.out.print("Onceki hasariniz:" + player.getDamage() + " - ");
			System.out.println("Yeni hasariniz:" + player.TotalDamage());
		}
		if(player.getMoney() < price)
		{
			System.out.println("Bakiye yetersiz !!!!!!!");
		}	
	}
	
// -------------------------------------------------------------------------------------------------------------
	
		public int armorMenu()		// Burada zırh menüsünü gösteriyoruz.
		{
			System.out.println("1. Hafif Zirh\t < Para:15 - Koruma:1 >");
			System.out.println("2. Orta Zirh\t < Para:25 - Koruma:3 >");
			System.out.println("3. Agir Zirh\t < Para:40 - Koruma:5 >");
			System.out.println("4. CIKIS");
			System.out.print("Zirh Seciminiz:");
			int selArmorID = input.nextInt();
			return selArmorID;
		}
		
//----------------------------------------------------------------------------------------------------------------
		
		public void buyArmor(int item)
		{
			int protect = 0 , price = 0;
			String armorName = null;
			switch(item)
		  {
			case 1 :
				protect = 1;
				armorName = "Hafif Zirh";
				price = 15; 
				break;
				
			case 2 :
				protect = 3;
				armorName = "Orta Zirh";
				price = 25;
				break;
				
			case 3 :
				protect = 5;
				armorName = "Agir Zirh";
				price = 40;
				break;
				
			case 4 :
				System.out.println("Magazadan cikis yaptiniz.");
				break;
				
				default:
					System.out.println("Gecersiz Islem !!!!");
					break;
		  }
			
			if(price > 0)
			{
				player.getInv().setArmor(protect); 
				player.getInv().setArmorName(armorName);
				player.setMoney(player.getMoney() - price);
				System.out.print(armorName + " " + "satin aldiniz." + " ");
				System.out.println("Kazanilan Koruma:" + (player.getInv().getArmor()) );
				System.out.println("Kalan para:" + player.getMoney());			
			}
			
			else
			{
				System.out.println("Bakiye yetersiz !!!!!!!");
			}	
		}
		
}
