import java.util.*;
public class Banking_App{
    private static double balance = 1000.00;
    static List<String> transaction_log = new ArrayList<>();
    private void withdraw(double value) 
    {
        System.out.println("Going to withdraw...");
        if(balance < value)
        {
            System.out.println("Alert: Attempting to withdraw cash greater than available balance of: " + balance);
            System.out.println("Sufficient Cash deposit required...");
            System.out.println("Returning to main menu...");
        }
        else {    
            try
            {
                balance -= value;
            }
            catch(Exception e){
                System.out.println("Caught exception!");
            };        

            System.out.println("~~Withdrawal Successfully Completed~~");
            transaction_log.add("Withdrawal: " + value);
        }
    }

    private void deposit(double value)
    {
        System.out.println("Going to deposit...");
        balance += value;
        System.out.println("~~Deposit Successfully Completed~~");
        transaction_log.add("Deposit: " + value);
        
    }

    private double getBalance()
    {
        return balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do
        {
            Banking_App bank = new Banking_App();
            System.out.println("");
            System.out.println("----------------------- BANKING APPLICATION -----------------------");
            System.out.println("Choose one of the following actions: ");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Transaction Log");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
    
            switch(choice)
            {
                case 1:
                System.out.println("");
                System.out.println("Available Balance in Bank Account: " + bank.getBalance());
                System.out.println("");
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 2:
                System.out.println("");
                System.out.println("Chosen Operation: Deposit");
                System.out.print("Please enter the amount to deposit: ");
                double dep_amount = sc.nextDouble();
                bank.deposit(dep_amount);
                System.out.println("");
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 3:
                System.out.println("");
                System.out.println("Chosen Operation: Withdrawal");
                System.out.print("Please enter the amount to withdraw: ");
                double withdrawal_amount = sc.nextDouble();
                bank.withdraw(withdrawal_amount);
                System.out.println("");
                break;
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                case 4:
                System.out.println("");
                System.out.println("Transaction Log:- ");
                for(int i = 0; i < transaction_log.size(); i++) 
                {
                    System.out.println((i+1) + " - " + transaction_log.get(i));
                }
                System.out.println("");
                break;
            }
        }
        while(choice != 0);

        sc.close();
        System.out.println("Banking Application Successfully Closed");
    }
};
