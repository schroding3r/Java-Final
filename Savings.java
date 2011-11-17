package banking;

public class Savings extends Account
{
	public void withdraw(double a)
	{
		balance-=a;
		numberOfTransactions++;
		if(numberOfTransactions>freeTransactions||vPremStat())
		{
			balance-=feeCost;
		}
	}
	public void deposit(double a)
	{
		balance+=a;
		numberOfTransactions++;
		if(numberOfTransactions>freeTransactions||vPremStat())
		{
			balance-=feeCost;
		}
	}
	public void compoundInterest()
	{
		balance+=balance*(interestRate/100);
	}
}