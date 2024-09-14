import java.util.Scanner;
import java.io.*;
// for saving
/**
 * 
 */
public class MenuInterface implements Serializable
{   
    //serializeBookClub catch IOException
    private static void serializeBookClub(BookClub bookClub) {
        // create a file path to a file so the data can be saved and loaded
        String filePath = "C:\\bookClub.ser";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(bookClub);
            System.out.println("BookClub object has been serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //deserializeBookClub catch IOException / not found 
    private static BookClub deserializeBookClub() {
        // create a file path to a file so the data can be saved and loaded
        String filePath = "C:\\Users\\alanj\\OneDrive\\Desktop\\BookClub\\bookClub.ser";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (BookClub) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) 
    {
        // Load BookClub from serialized data
        BookClub bookClub  = deserializeBookClub();
        // Serialize the loaded BookClub (update the data)
        serializeBookClub(bookClub );
        if (bookClub == null) {
            // If not available, create a BookClub
            System.out.println("BookClub could not load");
            bookClub  = new BookClub();
        }  
        else {
            System.out.println("BookClub loaded");
        }
        // create scanner
        Scanner scanner = new Scanner(System.in);
        // int for user reesponse 
        int response;

        //members / adding and creating 
        Member newMember1 = new Member("Tom", "Cork", "0895436722");
        Member newMember2 = new Member("Anthony","Cork","0892627333");
        Member newMember3 = new Member("Robert","Cork","0895487482");
        Member newMember4 = new Member("Adam","Cork","0893456455");
        bookClub.getMembersList().add(newMember1);
        bookClub.getMembersList().add(newMember2);
        bookClub.getMembersList().add(newMember3);
        bookClub.getMembersList().add(newMember4);

        // payments / adding and creating 
        Payment newPayment1 = new Payment("October" , 5.00);
        Payment newPayment2 = new Payment("October" , 5.00);
        Payment newPayment3 = new Payment("October" , 5.00);
        Payment newPayment4 = new Payment("November" , 5.00);
        Payment newPayment5 = new Payment("November" , 5.00);
        Payment newPayment6 = new Payment("November" , 5.00);
        Payment newPayment7 = new Payment("December" , 5.00);
        Payment newPayment8 = new Payment("December" , 5.00);
        Payment newPayment9 = new Payment("December" , 5.00);
        Payment newPayment10 = new Payment("December" , 60.00);
        newMember1.makePayment(newPayment1);
        newMember1.makePayment(newPayment4);
        newMember1.makePayment(newPayment7);
        newMember2.makePayment(newPayment2);
        newMember2.makePayment(newPayment5);
        newMember2.makePayment(newPayment8);
        newMember3.makePayment(newPayment3);
        newMember3.makePayment(newPayment6);
        newMember3.makePayment(newPayment9);
        newMember4.makePayment(newPayment10);

        //book choices / adding and creating 
        Book newBook1 = new Book("Eva's Friend" ,"Horror", "Pat Barker");
        Book newBook2 = new Book("Emma And Her Ghost" , "Horror" , "Julian Baggini");
        Book newBook3 = new Book("Simon Williams how to improve" , "Life Improvement" , "George Bernard Shaw");
        Book newBook4 = new Book("Sandy Winters a Day in the life" , "LifeStyle" , "Adam Scott");
        bookClub.getBookList().add(newBook1);
        bookClub.getBookList().add(newBook2);
        bookClub.getBookList().add(newBook3);
        bookClub.getBookList().add(newBook4);

        // The loop continues until user chooses option 8
        do {
            // meniu options
            System.out.println("Menu:");
            System.out.println("[1] Add a Member");
            System.out.println("[2] Members monthly payments");
            System.out.println("[3] List all Members (including thier book choice)");
            System.out.println("[4] Find a Book");
            System.out.println("[5] Remove a Member (Book choice also removed and if paid in full they may need a refund)");
            System.out.println("[6] Get number of payment made (per Member)");
            System.out.println("[7] Get total payments made (for entire club)");
            System.out.println("[8] Quit");
            //get user choice
            response = scanner.nextInt();
            // handles choice using switch statement
            switch(response)
            {
                case 1: 
                    // using scanner to get member details
                    System.out.println("Enter member details:");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Address: ");
                    String address = scanner.next();
                    System.out.print("Phone: ");
                    String phone = scanner.next();
                    // book details
                    System.out.println("\nEnter book details:");
                    System.out.print("title: ");
                    String title = scanner.next();
                    System.out.print("genre: ");
                    String genre = scanner.next();
                    System.out.print("writer: ");
                    String writer = scanner.next();
                    Member newMember5 = new Member(name,address,phone);
                    Book newBook5 = new Book(title,genre,writer);
                    bookClub.getBookList().add(newBook5);
                    // adding member and book if total is not gone over 5 members 
                    // promp the user , if they would like to increase the total or max members by one
                    do {
                        // Check if the total number of members is 5
                        if (bookClub.getMembersList().getTotal() > 5) {
                            // if total is 5 ask user would they like to add another member 
                            System.out.println("Maximum number of members reached (5). Do you want to add another member? (Y/N)");
                            char addAnotherMember = scanner.next().charAt(0);
                            if (!(addAnotherMember == 'Y' || addAnotherMember == 'y')) {
                                // code for adding over 5 members would be put here but max members is 5 in the BookClub
                                // but for now we can call the ClubFullException
                                System.out.println("Maximum number of members reached. Exiting member addition.");
                                break; // Exit the loop
                            }
                        }
                        // Prompt user for new member details
                        System.out.println("Enter details for the new member:");
                        // Create a new member and add to the list
                        Member newMember = new Member(name, address, phone);
                        bookClub.getMembersList().add(newMember);
                        System.out.println("Member added successfully!");
                        // Payment
                        System.out.println("\nWould you like to make the payment for:\n[1] The full year (€60)\n[2] Per month (€5):");
                        int paymentChoice = scanner.nextInt();
                        Payment payment = null;
                        // set to null at start 
                        if (paymentChoice == 1) {
                            // Paying for the full year
                            payment = new Payment("Jan-Dec", 60.0);
                            if (payment != null) {
                                // if payment has value
                                newMember.makePayment(payment);
                                newMember.paid = true;
                                System.out.println("Payment made");
                            }
                        } else if (paymentChoice == 2) {
                            // Paying per month
                            // use scanner to see how much they will pay 
                            System.out.print("Month: ");
                            String month = scanner.next();
                            System.out.print("Amount: ");
                            Double amount = scanner.nextDouble();
                            payment = new Payment(month, amount);
                            // if payment made then makepayment and print payment made
                            newMember.makePayment(payment);
                            System.out.println("Payment made");
                        } else {
                            // not processed
                            System.out.println("Invalid choice. Payment not processed.");
                            break; // break
                        }
                    } 
                    // while loop that continues while the total number of members
                    // is less than the maximum number of members allowed
                    while (bookClub.getMembersList().getTotal() < bookClub.maxNoOfMembers);
                    // print amount of members and book sin bookclub
                    System.out.println("Total number of books in the book list: " + bookClub.getBookList().getTotal());
                    System.out.println("Total number of members in the mmeber list: " + bookClub.getMembersList().getTotal());
                    break; 

                case 2: 
                    System.out.println("Members monthly payment");
                    MemberList memberList1 = bookClub.getMembersList();
                    BookList bookList1 = bookClub.getBookList();
                    for (int i = 0; i < memberList1.getTotal(); i++) {
                        Member member = memberList1.search(i);

                        System.out.println("\n\nMember " + (i + 1) + ":");
                        System.out.println(member.toString());
                    }
                    break;
                case 3:
                    MemberList memberList = bookClub.getMembersList();
                    BookList bookList = bookClub.getBookList();
                    System.out.println("List of all Members (including their book choice):");

                    for (int i = 0; i < memberList.getTotal(); i++) {
                        Member member = memberList.search(i);

                        // Check if the book list is long enough
                        if (i < bookList.getTotal()) {
                            Book bookChoice = bookList.getBook(i);
                            if (member != null) {
                                System.out.println("\n\nMember " + (i + 1) + ":");
                                System.out.print(member.toString());
                                if (bookChoice != null) {
                                    System.out.print("Book choice: \n");
                                    System.out.println(bookChoice.toString());
                                } else {
                                    System.out.println("No book choice for Member " + (i + 1));
                                    System.out.println(member.getPayment());
                                }
                            }
                        } else {
                            // Handle the case where there's no corresponding book for the member
                            System.out.println("Member " + (i + 1) + ":");
                            System.out.println(member.toString());
                            System.out.println("No book choice for Member " + (i + 1));
                        }
                    }
                    break;

                case 4:
                    //Search for a book by index (year)
                    int k = 0;
                    // flag var to control the while loop
                    while (k == 0) {
                        System.out.println("Enter the year to search for a book(index):");
                        // read inputed index
                        int searchYear = scanner.nextInt();
                        Book foundBookByYear = bookClub.getBookList().getBook(searchYear);
                        if (foundBookByYear != null) {
                            // if book found then print book found + book
                            System.out.println("Book found:");
                            System.out.println(foundBookByYear.toString());
                            // k++ to stop loop
                            k++;
                        } else {
                            // book not found
                            System.out.println("Book not found for the given index.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter the name of the member to remove:");
                    // get name from input
                    String memberNameToRemove = scanner.next();
                    MemberList m = bookClub.getMembersList();
                    // Find the index of the member in the MemberList
                    int memberIndexToRemove = -1;
                    // loop through members 
                    for (int i = 0; i < m.getTotal(); i++) {
                        Member member = m.search(i);
                        // Check if the current member is not null and has the name to be removed
                        if (member != null && member.getName().equals(memberNameToRemove)) {
                            memberIndexToRemove = i;
                            break; // Found the member, no need to continue searching
                        }
                    }
                    // if member wasnt found
                    if (memberIndexToRemove != -1) {
                        // Member found, now remove the member and their book choice
                        Member removedMember = m.search(memberIndexToRemove);
                        m.remove(memberIndexToRemove);
                        // If the member has paid in full, issue a refund
                        if (removedMember.paid) {
                            double refundAmount = removedMember.getPayment().calculateTotalPaid();
                            System.out.println("Refunding €" + refundAmount + " to " + removedMember.getName());
                            // Perform the refund logic here, e.g., update account balance or issue a refund payment
                        }
                        // Remove the book choice
                        if (memberIndexToRemove < bookClub.getBookList().getTotal()) {
                            bookClub.getBookList().remove(memberIndexToRemove);
                        }
                        System.out.println("Member removed successfully");
                    } else {
                        System.out.println("Member not found.");
                    }
                    // print amount of members and books in the books club 
                    System.out.println("Total number of books in the book list: " + bookClub.getBookList().getTotal());
                    System.out.println("Total number of members in the member list: " + bookClub.getMembersList().getTotal());
                    break;
                case 6: 
                    //Get number of payment made (per Member)
                    MemberList memberList3 = bookClub.getMembersList();
                    // loop through each member
                    for (int i = 0; i < memberList3.getTotal(); i++) {
                        // get member at i
                        Member member = memberList3.search(i);
                        // set payment list of the member to the member's payment list
                        member.paymentlist = member.getPayment();
                        // number of payments int
                        int numberOfPayments = member.paymentlist.getTotal();
                        // print number of payments made by
                        System.out.println("Number of payments made by " + member.getName() + ": " + numberOfPayments);
                    }
                    break;
                case 7: 
                    MemberList memberList2 = bookClub.getMembersList();
                    System.out.println("Total Payments for club:");
                    double total_amount = 0.0;
                    // get total cal of Payments
                    for (int i = 0; i < memberList2.getTotal(); i++) {
                        Member member = memberList2.search(i);
                        // Print the amount paid by each member
                        double memberTotal = member.getPayment().calculateTotalPaid();
                        System.out.println(member.getName() + ": €" + memberTotal);
                        // Accumulate the total amount for all members
                        total_amount += memberTotal;
                    }
                    // print Total Amount for all members
                    System.out.println("Total Amount for all members: €" + total_amount);
                    break;
                case 8: 
                    // if user choice is 8 then print exit and exit application 
                    System.out.println("Exit");
                    break;
            }
            // display warning if user entered an invalid option 
            if (response > 8) {
                System.out.println("Warning: You entered a choice over 8. Please choose a valid option.");
            }
        } 
        // Continue the loop until the user chooses to exit
        while (response != 8);
        // Close the Scanner
        scanner.close();
    }
}