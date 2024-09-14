/**
 *
 */
public class Payment
{
    private  String month;
    private  double amount;

    public Payment(String month, double amount)
    {
        this.amount = amount;
        this.month = month;
    }

    public Payment(double amount)
    {
        this.amount = amount; // set amount
    }

    public String getMonth()
    {
        return month; // return month
    }

    public double getAmount()
    {
        return amount; // return amount
    }

    public String toString() // toString
    {
        return "\n Month: " + month + "\n Amount: €" + amount;
    }

    public void print() // print
    {
        System.out.println(toString());
    }
}