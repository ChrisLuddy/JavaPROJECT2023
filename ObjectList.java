import java.io.*;
/**
 *
 */
public class ObjectList implements Serializable
{
    private Object[] objectlist;
    private int total;// counter

    public ObjectList(int size)
    {
        this.objectlist = new Object[size]; // set size
        this.total = 0;
    }

    public boolean add(Object p){
        // to add an object
        //ClubFullException would be inmplemented here if full
        if (total < objectlist.length) {
            objectlist[total] = p;
            total++;
            return true;
        } else {
            int newLength = objectlist.length  + 1;
            Object[] newArray = new Object[newLength];
            // Copy elements from the old array to new
            System.arraycopy(objectlist, 0, newArray, 0, objectlist.length);
            // Update the reference to the new array
            objectlist = newArray;
            // Add the new object to the resized array
            objectlist[total] = p;
            total++; // incement the total
            return true;
        }
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        if(total == objectlist.length)
        {
            // if full return true
            //ClubFullException would be inmplemented here
            return true;
        }
        else {
            // else false
            return false;
        }
    }

    public Object getObject(int k) {
        // get object
        if (k >= 0 && k < total) {
            return objectlist[k]; // from object list get k
        } else {
            return null;
        }
    }

    public int getTotal() {
        return total;
    }

    public boolean remove(int k)
    {
        // remove method
        if (!isEmpty() && k >= 0 && k < total) {
            // Start a loop from index 'k' to the second last element in list
            for (int i = k; i < total - 1; i++) {
                // Shift each element to the left
                objectlist[i] = objectlist[i + 1];
            }
            // Set last in list to null to remove copy element
            objectlist[total - 1] = null;
            total--; // decrement the total
            return true; // return true as removed worked
        } else {
            return false; // return false if not worked
        }
    }
}