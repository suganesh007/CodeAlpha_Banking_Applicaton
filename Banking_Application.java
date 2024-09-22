import java.util.InputMismatchException;
import java.util.Scanner;

class Question_cls
{   
    int ques_length = 5;
    StringBuilder[] question = new StringBuilder[ques_length];

    // set length
    public Question_cls(int length) 
    {
        this.ques_length = length;
    }

    // print all string
    void printAll()
    {
        System.out.println("\n");
        for (int i = 0; i < ques_length; i++)
        {
            System.out.println((i + 1) + " " + question[i]);
        }
        System.out.println("\n");
    }
}

class functions
{
    private float Curr_Balance = 0; // Now non-static to allow multiple instances

    @SuppressWarnings("resource")
    static int ErrorCheck(int start, int limit)
    {
        Scanner in = new Scanner(System.in);
        int option = 0;
        boolean validInput = false;
        while(!validInput)
        {
            try
            {
                System.out.print("Enter the value = ");
                option = in.nextInt();
                if (option >= start && option <= limit)
                {
                    validInput = true;
                }
                else if (option > 10000 && start == 1 && limit == 10000)
                {
                    System.err.println("Limit Exceeds above 10,000");
                }
                else
                {
                    System.err.println("You entered the wrong value!");
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Only numbers are allowed!");
                in.next(); // Clear invalid input
            }
        }
        return option;
    }

    void Deposit(int depositAmount)
    {
        if (depositAmount > 0)
        {
            Curr_Balance += depositAmount;
            System.err.println("Deposited Rs." + depositAmount);
        }
        else
        {
            System.err.println("Invalid amount.");
        }
    }

    void Withdrawal(int withdrawAmount)
    {
        if (withdrawAmount > 0 && Curr_Balance >= withdrawAmount)
        {
            Curr_Balance -= withdrawAmount;
            System.err.println("Withdrew Rs." + withdrawAmount);
        }
        else if (Curr_Balance < withdrawAmount)
        {
            System.err.println("Insufficient balance. Your current balance is Rs." + Curr_Balance);
        }
        else
        {
            System.err.println("Invalid amount.");
        }
    }

    void BalanceCheck()
    {
        System.err.println("Your current balance is Rs." + Curr_Balance);
    }

    void Exit()
    {
        System.out.println("Thanks for using the Banking Application!");
        System.exit(0);
    }
}

// Main
public class Banking_Application
{
    public static void main (String[] arr)
    {
        // Move the question object outside the loop to avoid re-creation
        Question_cls o1 = new Question_cls(4);
        o1.question[0] = new StringBuilder("Deposit");
        o1.question[1] = new StringBuilder("Withdrawal");
        o1.question[2] = new StringBuilder("Balance Check");
        o1.question[3] = new StringBuilder("Exit program");

        // Create one instance of functions
        functions funct = new functions();

        while (true) 
        {
            o1.printAll();

            // Asking input
            System.err.println("Enter a value from 1 to 4:");
            int option = functions.ErrorCheck(1, 4);

            // Options based functions are called
            switch (option) 
            {
                case 1 -> {
                    System.err.println("Enter the deposit amount (limit: Rs. 10,000):");
                    int amount_deposit = functions.ErrorCheck(1, 10000);
                    funct.Deposit(amount_deposit);
                }
                case 2 -> {
                    System.err.println("Enter the withdraw amount (limit: Rs. 10,000):");
                    int amount_withdraw = functions.ErrorCheck(1, 10000);
                    funct.Withdrawal(amount_withdraw);
                }
                case 3 -> funct.BalanceCheck();
                case 4 -> funct.Exit();
            }
        }
    }
}