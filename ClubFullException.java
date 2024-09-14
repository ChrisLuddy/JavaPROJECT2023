/**
 
: FINAL QUESTION: IF YOU WANTED TO USE AN EXCEPTION HOW WOULD YOU DO IT? 
What would you need to do in the calling method?
EXPLAIN in DETAIL. ?
This class ClubFullException would be implemented in cases where the book club is full
and a user would like to add another member, to avoid this we would have to remove an existing
member from the bookclub or increase the maximum amount of members allowed in the bookclub

*----------------------------------------------------------------------
 in the call method for ClubFullException I would add 

 try {
  // Call the method that adds a new member
  bookClub.getMembersList().add(newMember);



    } catch (ClubFullException e) {
    System.out.println("Error: " + e.getMessage());
    // Handle the exception
    // I would prompt the user to remove a member or increase the maximum members
    }


    ---------------------------------------------------------------------
    in the call method for the MenuInterface I would add 
    in the case 1 : (adding a member case)

    if (bookClub.getMembersList().getTotal() >= bookClub.maxNoOfMembers) {
            throw new ClubFullException("The book club is full. Cannot add more members.");
        }

         } catch (ClubFullException e) {
        System.out.println("Error: " + e.getMessage());
        // Handle the exception
        // I would prompt the user to remove a member or increase the maximum members
    }
 
*/
public class ClubFullException
{
    public ClubFullException()
    {
    }
}