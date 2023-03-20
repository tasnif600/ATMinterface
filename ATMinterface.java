import java.util.Scanner;

class BankAccount {
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String cName, String CId) {
        customerName = cName;
        customerId = CId;
    }

    public final void clrscr() {
        try {
            try {
                final String os = System.getProperty("os.name");
                if (os.contains("windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (final Exception e) {

            }

        } catch (final Exception es) {
        }
    }

    void checkId() {
        clrscr();
        System.out.println("welcome" + customerName);
        System.out.println();
        System.out.println("please enter the customer ID or Pin:");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(customerId)) {
            clrscr();
            ShowMenu();
            id.close();
        } else {
            System.out.println("= = = = = = = = = = = ");
            System.out.println("wrong login!!");
            System.out.println("= = = = = = = = = = =");
            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            clrscr();
            System.out.println("= = = = = = = = = =");
            System.out.println("Sufficant Balance not available for the withdrawl!");
            System.out.println("= = = = = = = = = =");
        }
    }

    void getprevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited:" + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw:" + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction occured");
        }
    }

    public void transfer(double amount, BankAccount acc) {
        if (this.balance < amount) {
            clrscr();
            System.out.println("= = = = = = = = =");
            System.out.println("Transfer fails due to insufficient balance!");
            System.out.println("= = = = = = = = =");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.customerName + " becomes $" + this.balance);
            System.out.println("Account of " + acc.customerName + " becomes $" + acc.balance);
            System.out.println("\n");
        }
    }

    private void ShowMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println(" welcome " + customerName);
        System.out.println(" your Id is " + customerId);
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("A.Check Balance");
            System.out.println("B.Deposit");
            System.out.println("C.Withdrow");
            System.out.println("D.prev transcation");
            System.out.println("E.Transfer");
            System.out.println("F.Exit");
            System.out.println("= = = = = = = = = =");
            System.out.println("Enter the option");
            System.out.println("= = = = = = = = = =");
            option = sc.next().charAt(0);
            option = Character.toUpperCase(option);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    clrscr();
                    System.out.println("= = = = = = = = =");
                    System.out.println(" Balance " + balance);
                    System.out.println("= = = = = = = = =");
                    System.out.println("\n");
                    break;

                case 'B':
                    clrscr();
                    System.out.println("= = = = = = = = =");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("= = = = = = = = =");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    clrscr();
                    System.out.println("= = = = = = = = = =");
                    System.out.println("Enter the amount to withdraw");
                    System.out.println("= = = = = = = = = = =");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    clrscr();
                    System.out.println("= = = = = = = = = =");
                    getprevTransaction();
                    System.out.println("= = = = = = = = = =");

                case 'E':
                    clrscr();
                    System.out.println("= = = = = = = = = =");
                    System.out.println("To whom");
                    BankAccount bb = new BankAccount("Rahul", "1100");
                    System.out.println(bb.customerName);
                    System.out.println("= = = = = = = = = =");
                    System.out.println("Amount to transfer");
                    double am = sc.nextDouble();
                    System.out.println("= = = = = = = = = =");
                    transfer(am, bb);
                    break;

                case 'F':
                    clrscr();
                    System.out.println("= = = = = = = = = =");
                    break;
                default:
                    clrscr();
                    System.out.println("Invalid option !!! please enter again");
            }
        } while (option != 'F');
        System.err.println("Thank you for using our services");
        sc.close();
    }
}

public class ATMinterface {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(" Md Atif ", "1110");
        ba.checkId();
    }
}
