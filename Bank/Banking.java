import java.util.Scanner;

class Banking
{
	static AccountData[] db;
	static Scanner scan = new Scanner(System.in);
	private class AccountData
	{
		 long accountNo;
		 String name;
		 int balance;
		 int pin;
		
		public AccountData() {}
		
		public AccountData(long accountNo, String name, int balance, int pin){
			this.accountNo = accountNo;
			this.name = name;
			this.balance = balance;
			this.pin = pin;
		}

	}
	
	public Banking(){
		AccountData kazuto = new AccountData(9876543210L, "Kazuto", 2000, 1234);
		AccountData asuna = new AccountData(9876543211L, "Asuna", 20000, 5678);
		AccountData kline = new AccountData(9876543212L, "Kline", 1000, 9101);
		AccountData silica = new AccountData(9876543213L, "Silica", 1500, 1121);	
		
		AccountData[] db = { kazuto, asuna, kline, silica };
		
		this.db = db;
	}
	
	public static AccountData findUser(int pin){
		for(AccountData a : db){
			if(pin == a.pin){
				return a;
			}
		}
		return null;
	}
	
	public static int getPin(){
		System.out.print("Enter your pin : ");
		int pin = scan.nextInt();
		
		while(pin < 999 || pin > 9999){
			System.out.println("Invalid Pin, Try Again\n");
			System.out.print("Enter your pin : ");
			pin = scan.nextInt();
		}
		
		return pin;
	} 
	
	public static void main(String[] args){
		boolean home = true;
		
		Banking bank = new Banking();
		
		do
		{
			System.out.println("Welcome to the Dummy Bank!!!");
			System.out.println("*****************************");
			System.out.println("Select the Process :");
			System.out.println("1. Deposit\n2. Withdraw\n3. Check Balanace\n4. Exit");
			System.out.print("\nEnter your process no : ");
			int input = scan.nextInt();
			
			switch (input)
			{
			case 1: {
				int pin = getPin();
				AccountData user = findUser(pin);
				System.out.println("\nAccount No : " + user.accountNo);
				System.out.println("Name : " + user.name);
				System.out.println("Balance : " + user.balance);
				System.out.print("\nEnter your Deposit amount : ");
				int amount = scan.nextInt();
				
				user.balance += amount;
				
				System.out.println("Current Balance : " + user.balance);
				
				System.out.println("*****Transaction Successful*****\n");
				break; 
				}
			case 2: { 
				int pin = getPin();
				AccountData user = findUser(pin);
				System.out.println("\nAccount No : " + user.accountNo);
				System.out.println("Name : " + user.name);
				System.out.println("Balance : " + user.balance);
				System.out.print("\nEnter your Withdraw amount : ");
				int amount = scan.nextInt();
				
				if(amount > user.balance){
					System.out.println("Invalid Transaction!!!\nTry Again!!!");
					break;
				}
				
				user.balance -= amount;
				System.out.println("Current Balance : " + user.balance);
				System.out.println("*****Transaction Successful*****\n");
				break;
				}
			case 3: { 
				int pin = getPin();
				AccountData user = findUser(pin);
				System.out.println("\nAccount No : " + user.accountNo);
				System.out.println("Name : " + user.name);
				System.out.println("Balance : " + user.balance);
				System.out.println("*****Transaction Successful*****\n");
				break; 
				}
			case 4: {
				home = false;
				break;
			}
			default: {
				System.out.println("Invalid Input!!!");
				break;
			}
			}
			
		}
		while (home);
		
		System.out.println("******Thanks for Visiting******");
	}
}
