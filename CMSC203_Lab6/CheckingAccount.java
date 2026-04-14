public class CheckingAccount extends BankAccount
{
    private static final double FEE = 0.15;

    public CheckingAccount(String name, double amount)
    {
        super(name, amount);

        String newNumber = super.getAccountNumber() + "-10";
        setAccountNumber(newNumber);
    }

    @Override
    public boolean withdraw(double amount)
    {
        double total = amount + FEE;

        boolean completed = super.withdraw(total);

        return completed;
    }
}