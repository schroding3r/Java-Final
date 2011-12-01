package banking;
import java.util.Scanner;
public class Main 
{
	public static void main(String Args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("1)GUI\n2)CLI");
		int c=scanner.nextInt();
		switch(c)
		{
			case 1:{
					System.out.println("Starting GUI...");
					GUI gui = new GUI();
					gui.main();
					break;
					}
			case 2:{
					System.out.println("Starting CLI...");
					Interact.menu();
					break;
					}
		}
	}
}