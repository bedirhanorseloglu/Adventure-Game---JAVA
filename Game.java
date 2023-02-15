import java.util.Scanner;

public class Game 
{
	Player player;		// Nesne oluşturduk.
	Location location;
	
	
	Scanner input = new Scanner(System.in);
	
	public void login()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Macera oynumuza hos geldiniz :)");
		System.out.println("Oyunu kazanmak icin tum yerlere gitmeli , oradaki esyalari toplamali ve topladiktan sonra guvenli eve geri donmelisin.");
		System.out.print("Baslamak icin adinizi giriniz:");
		String yourName = input.nextLine();	
		System.out.println("Hosgeldin " + yourName + " " +":)");
		player = new Player(yourName); 		// üstte nesneyi "player" nesnesini oluşturmuştuk. Eşittirin karşısını buraya yazdım.
		player.selectCha();
		
		start();
	}
	
	
	public void start()
	{
		while(true)
		{
			System.out.println();
			System.out.println("==========================================");
			System.out.println();
			System.out.println("Eylem gerceklesecek yeri seciniz.");
			System.out.println("1.Guvenli ev ---> Caniniz fullenir.");
			System.out.println("2.Magara ---> Karsiniza zombi cikabilir. Tum dusmanlari oldurursen food kazanirsin.");
			System.out.println("3.Orman ---> Karsiniz vampir cikabilir. Tum dusmanlari oldurursen firewood kazanirsin.");
			System.out.println("4.Nehir ---> Karsiniza ayi cikabilir. Tum dusmanlari oldurursen water kazanirsin.");
			System.out.println("5.Magaza ---> Silah veya zirh alabilirsiniz. ");
			System.out.print("Seciminiz:");
			int selLoc = input.nextInt();
			
			while(selLoc < 1 || selLoc > 5)
			{
				System.out.println("Lutfen gecerli bir lokasyon sec !!!");
				System.out.println("Seciminiz:");
				selLoc = input.nextInt();
			}
			
			switch(selLoc)
			{
			  case 1:
				  location = new SafeHouse(player);
				  break;
				  
			  case 2:
				  location = new Cave(player);
				  break;
				  
			  case 3:
				  location = new Forest(player);
				  break;
				  
			  case 4:
				  location = new River(player);
				  break;
				  
			  case 5 :
				  location = new ToolStore(player);
				  break;
				  
			  default:
					  location = new SafeHouse(player);
			}
			
			
			if(location.getClass().getName().equals("SafeHouse"))
				if(player.getInv().isFirewood() == true && player.getInv().isFood() == true && player.getInv().isWater() == true)
				{
					System.out.println("Tebrikler oyunu kazandiniz :)");
					break;
				}
			
			
			if(! location.getLocation())
			{
				System.out.println("OYUN BITTI !!!");
				break;
			}
		}
		
		
		
		
	}
}
