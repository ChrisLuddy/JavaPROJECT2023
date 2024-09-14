/**
 *
 */
public class BookList extends ObjectList
{
    BookList(int size)
    {
        super(size); // get size from objectlist (super)
    }

    public Book getBook(int b) {
        return (Book) getObject(b); // cast Book object getObject b from params
    }
}