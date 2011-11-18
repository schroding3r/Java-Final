package banking;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Interact 
{
	public static void menu()
	{
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		while(running)
		{
			System.out.println("\rBanking (Root Menu) ("+DB.getActiveDB()+")\r" +
					"1)Create Record\r" +
					"2)View Record\r" +
					"3)Delete Record\r" +
					"5)Delete Active DB (WARNING: NO CONFIRMATION)\r" +
					"6)Change Active DB\r" +
					"0)Exit");
			switch(keyboard.nextInt())
			{
				case 0:running=false;break;
				case 1:createRecord();break;
				case 2:System.out.println("Record Number?");viewRecord(keyboard.nextInt());break;
				case 5:System.out.println("Deleting DB...");DB.deleteDB();break;
				case 6:System.out.println("Changing Active DB...New DB?");DB.setActiveDB(keyboard.next());break;
			}
		}
	}
	public void clearScreen() //may not be needed, may be used to simulate updating terminal
	{
		for(int i=0;i<50;i++){System.out.println("");};
	}
	public static void createRecord()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Starting Balance?");
		double balance = keyboard.nextDouble();
		System.out.println("Interest Rate?");
		double interestRate = keyboard.nextDouble();
		boolean inRed = false;
		System.out.println("Acct Premium? (Y/N)");
		String choice = keyboard.next();
		boolean premium = false;
		if(choice=="Y") premium = true;
		int accountNumber=DB.nextActNum();
		System.out.println("Assigned Acct. Number: "+accountNumber);
		int numberOfTransactions=0;
		DB.saveRecord(balance+":"+numberOfTransactions+":"+interestRate+":"+accountNumber+":"+inRed+":"+premium+"#");
		System.out.println("\rRecord Created Successfully");
	}
	public static void viewRecord(int r)
	{
		prettyPrintRec(DB.actRetrive(r, false));
	}
	public static void prettyPrintRec(String rec)
	{
		StringTokenizer st = new StringTokenizer(rec,":",false);
		while(st.hasMoreTokens())
		{
			System.out.println("Balance: "+st.nextToken());
			System.out.println("Num of Transactions: "+st.nextToken());
			System.out.println("Interest Rate: "+st.nextToken());
			System.out.println("Account Number: "+st.nextToken());
			st.nextToken(); //Internal variable (isRed) Doesn't need displayed
			System.out.println("Premium: "+st.nextToken());
			
		}
	}
}
