import java.io.Serializable;
/**
 
*/
public class BookClub implements Serializable
{
    private  int year;
    int maxNoOfMembers = 5;
    private  BookList books;
    private  MemberList members;

    public BookClub()
    {
        this.maxNoOfMembers = 5;
        this.year = 0;
        this.members = new MemberList(maxNoOfMembers);
        this.books = new BookList(year); // year member is joining (index)
    }

    public MemberList getMembersList() {
        return members; // returns members obj
    }

    public BookList getBookList() {
        return books; // returns books obj
    }

    public int getTotalMembers() 
    {
        return maxNoOfMembers; // returns maxNoOfMembers
    }




}