
public class SafeHouse extends NormalLoc
{

	SafeHouse(Player player) 
	{
		super(player , "Guvenli ev"); // Dışarıdan name almadığım için name değerini ben veriyorum "Guvenli ev".
									  // NormalLoc'tan extends etmiştik. Const'a bak anlarsın.
	
	}
	
	
	@Override
	public boolean getLocation()
	{
		player.setHealth(player.getrHealth()); // hangi karakteri seçtiysek onun sağlığını yenileyecek
		System.out.println("Su an guvenli evdesiniz.");
		System.out.println("Caniniz fullendi !!");
		return true;
	}
	
}
