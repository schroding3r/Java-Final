package banking;
public abstract class Account
{
	public double balance = 0.0;
	public int numberOfTransactions = 0;
	public double interestRate = 0;
	public int accountNumber = 0;
	public int feeCost = 0;
	public int freeTransactions = 0;
	public double minBalance = 0;
	private boolean inRed = false; //tracks if a premium account is in red or not
	public boolean premium = false;
	public Account()
	{
	}
	public abstract void withdraw(double a);
	public abstract void deposit(double a);
	public abstract void compoundInterest();
	public void setInterestRate(int a)
	{
		interestRate=a;
	}
	public double getBalance()
	{
		return balance;
	}
	public int getTransactions()
	{
		return numberOfTransactions;
	}
	public boolean vPremStat()
	{
		if(premium)
		{
			if(balance>minBalance)
			{
				if(inRed==true)
				{
					inRed=false;
					return false;
				}
				else return false;
			}
			else
			{
				if(inRed==false)
				{
					balance-=feeCost; //charge fee for going below minimum balance
					inRed=true; //set flag to mark below min balance
					return true;
				}
				else return true;
			}
		}
		else return false;
	}
	public void debugDump()
	{
		System.out.println("b: "+balance+" nt: "+numberOfTransactions+" bm: "+interestRate+" an: "+accountNumber+" p: "+inRed);
	}
	public String actSum() //create a account-descriptive textline
	{
		return(balance+":"+numberOfTransactions+":"+interestRate+":"+accountNumber+":"+inRed+":"+premium+"#");
	}
}