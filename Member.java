/**
 
Write a description of class Member here.*
@author (your name)
@version (a version number or a date)
*/
public class Member extends Person
{
    PaymentList paymentlist;
    private Payment payment;
    private int maxNoOfPayments = 12;
    boolean paid;

    Member(String name, String address, String phone)
    {
        this.name = name;
        this.address = address; 
        this.phone = phone;
        this.paymentlist = new PaymentList(maxNoOfPayments);
    }

    public boolean makePayment(Payment p)
    {
        // if not paid
        if (!paid) {
            // Ensure paymentlist is not null
            if (paymentlist == null) {
                paymentlist = new PaymentList(10); // You might need to adjust the size
            }
            paymentlist.add(p);
            // Check if the number of payments has reached the maximum
            if (paymentlist.getTotal() >= maxNoOfPayments) {
                paid = true; // Set paid to true if the maximum number of payments is reached
            }
            return true; // Payment successful
        } else {
            System.out.println("This member has already paid in full.");
            return false; // Payment unsuccessful
        }
    }

    public PaymentList getPayment()
    {
        return paymentlist; // return paymentlist
    }

    public String toString()
    {
        String result = "";// loop through payments
        for (int i = 0; i < paymentlist.getTotal(); i++) {
            result = paymentlist.getPayment(i).toString() + "\n";
        }
        return " Name: " + name + "\n Phone: " + phone + "\n Address: " + address + " \nPayment Info: " + result;
    }

    public void print()
    {
        System.out.println(toString());
    }
}