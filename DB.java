package banking;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
public class DB
{
	private static String activeDB = "db.dat";
	public static void createFile()
	{
		try
		{
			FileWriter fstream = new FileWriter(activeDB);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write("");
			out.close();
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.getMessage());
		}
	}
	public static void actRetrive(int n)
	{
		try
		{
			Scanner scanner = new Scanner(new FileInputStream(activeDB));
			while(scanner.hasNextLine())
			{
				String record = scanner.next();
				StringTokenizer st = new StringTokenizer(record,":",false);
				int c=0;
				while(st.hasMoreTokens())
				{
					c++;
					String current = st.nextToken();
					if(c==4&&Integer.parseInt(current)==n)
					{
						System.out.println(record);
					}
				}
			}
			scanner.close();
		}
		catch(Exception e)
		{
			
			//System.err.println("Error: "+e.getCause());
		}
	}
	public static String actRetrive(int n,boolean clean) //overloaded to allow a string return
	{
		try
		{
			Scanner scanner = new Scanner(new FileInputStream(activeDB));
			while(scanner.hasNextLine())
			{
				String record = scanner.next();
				StringTokenizer st = new StringTokenizer(record,":",false);
				int c=0;
				while(st.hasMoreTokens())
				{
					c++;
					String current = st.nextToken();
					if(c==4&&Integer.parseInt(current)==n)
					{
						return(record);
					}
				}
			}
			scanner.close();
		}
		catch(Exception e)
		{
			
			//System.err.println("Error: "+e.getCause());
		}
		return null;
	}
	public static int nextActNum()
	{
		int i=0;
		try
		{
			Scanner scanner = new Scanner(new FileInputStream(activeDB));
			while(scanner.hasNextLine())
			{
				scanner.next();
				i++;
			}
			scanner.close();
		}
		catch(Exception e)
		{
			
			//System.err.println("Error: "+e.getCause());
		}
		return i;
	}
	public static void saveRecord(String actInfo)
	{
		try
		{
			FileWriter fstream = new FileWriter(activeDB,true); //the true tells it to append
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(actInfo+"\r\n");
			out.close();
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.getMessage());
		}
	}
	public static void readDB()
	{
		try
		{
			Scanner list = new Scanner(new File(activeDB)).useDelimiter("#");
			for(int c=0;list.hasNext();c++)
			{
				String current=list.next();
				current = current.trim();
				System.out.println(current);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error: "+e.getMessage();
		}
	}
	public static void deleteDB()
	{
		File db = new File(activeDB);
	    boolean success = db.delete();
	    if (!success)
	      throw new IllegalArgumentException("Delete: deletion failed");
	}
	public static String getActiveDB()
	{
		return activeDB;
	}
	public static void setActiveDB(String newDB)
	{
		activeDB=newDB;
	}

}