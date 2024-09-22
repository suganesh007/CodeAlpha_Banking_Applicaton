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

    // specific string
    //void print(int arrayValue)
    //{
    //    System.out.println(question[arrayValue]);
    //}

    // print all string
    void printAll()
    {
        System.out.println("\n");
        for (int i = 0; i < ques_length; i++)
        {
            System.out.println((i+1) + " " + question[i]);
        }
        System.out.println("\n");
    }

}


class functions
{

    private static float Curr_Balance = 0;

    @SuppressWarnings("resource")
    static int ErrorCheck(int start, int limit)
    {
        
        Scanner in = new Scanner(System.in);
        int option = 0;
        boolean ValidInput = false;
        while(!ValidInput)
        {
            try
            {
                System.out.print("Enter the value = ");
                option = in.nextInt();
                if (option >= start && option <= limit)
                {
                    ValidInput = true;
                }
                else if (option > 10000 && start == 1 && limit == 10000)
                {
                    System.err.println("Limited Exceeds above 10,000");
                }
                else
                System.err.println("you entered the wrong Value !");
            }

            catch (InputMismatchException e)
            {
                System.err.println("only numbers are allowed !");
                in.next();
            }
        }
        return option;
    }

    void Deposit(int deposit_amount)
    {
        if (deposit_amount > 0)
        {
            Curr_Balance += deposit_amount;
        }
        else
        {
            System.err.println("Invalid Amount");
        }

    }

    void Withdrawal(int withdraw_amount)
    {
        if (withdraw_amount > 0 && Curr_Balance >= withdraw_amount)
        {
            Curr_Balance -= withdraw_amount;
            System.err.println("Withdrawal amount is rs." + withdraw_amount);
        }
        else if (Curr_Balance <= 0)
        {
            System.err.println("You have 0.00 balance");
        }
        else
        {
            System.err.println("Invalid Amount");
        }

    }

    void BalanceCheck()
    {
        System.err.println("Your current Balance is rs." + Curr_Balance);
    }

    void Exit()
    {
        System.out.println("Thanks for the Using !");
        System.exit(0);
    }

}


// main
public class Banking_Application
{
    public static void main (String[] arr)
    {

        while (true) 
        {
            Question_cls o1 = new Question_cls(4);o1.question[0] = new StringBuilder("Deposit");o1.question[1] = new StringBuilder("Withdrawal");o1.question[2] = new StringBuilder("Balance Check");o1.question[3] = new StringBuilder("Exit program");
            o1.printAll();
            

            // asking input
            functions funct = new functions();
            System.err.println("Enter the from 1 to 4 :");
            int option = functions.ErrorCheck(1, 4);


            // options based functions are called
            switch (option) 
            {
                case 1 ->
                {
                    System.err.println("Enter the Deposit amount (limit only 10,000) :");
                    int amount_deposit = functions.ErrorCheck(1, 10000);
                    funct.Deposit(amount_deposit);
                }
                case 2 -> 
                {
                    System.err.println("Enter the WithDraw amount (limit only 10,000):");
                    int amount_withdraw = functions.ErrorCheck(1, 10000);
                    funct.Withdrawal(amount_withdraw);
                }
                case 3 -> funct.BalanceCheck();
                case 4 -> funct.Exit();
                default -> 
                {    
                }
            }
            
        }
    }
}