
/**
 *
 */
public class MemberList extends ObjectList
{
    MemberList(int size)
    {
        super(size);   // get size from objectlist
    }

    public boolean add(Member m) // in book club
    {
        if (m instanceof Member) {
            // if full using ()isFull method
            //ClubFullException would be inmplemented here
            return super.add(m); // use objectlist to add m
        } else {
            System.out.println("Invalid object.");
            return false; // if m not instance of member
        }
    }

    public Member search(int b) {
        return (Member) getObject(b); // cast member using getObject to get b in params
    }

    public boolean remove(int r)
    {
        return super.remove(r); // use objectlist (super) to remove r
    }
}