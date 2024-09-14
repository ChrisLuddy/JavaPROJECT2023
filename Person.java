/**
 
*/
public class Person
{
    public  String name;
    public  String phone;
    public  String address;

    public Person()
    {
        // default constructor 
    }

    public Person(String name, String phone, String address)
    {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name; // returns name
    }

    public String getPhone() {
        return phone; // return phone 
    }

    public String getAddress() {
        return address; // return address 
    }

    public void setName(String name) {
        this.name = name; // set name
    }

    public void setPhone(String phone) {
        this.phone = phone; // set phone 
    }

    public void setAddress(String address) {
        this.address = address; // set address
    }

    public String toString()
    {
        return "Name: " + name + ",\n Phone: " + phone + ",\n Address: " + address;
    }

    public void print()
    {
        System.out.println(toString());
    }
}