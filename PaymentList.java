/**
 *
 */
public class PaymentList extends ObjectList
{
    public PaymentList(int size) {
        super(size); // get size from objectlist (super)
    }

    public Payment getPayment(int k) {
        return (Payment) getObject(k); // change object to a payment object
    }

    public double calculateTotalPaid() {
        double totalPaid = 0;
        for (int i = 0; i < getTotal(); i++) {
            // loop through payments and sum to get the total
            totalPaid = getPayment(i).getAmount();
        }
        return totalPaid; // return the sum of all payments in the list
    }
}