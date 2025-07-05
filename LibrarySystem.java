import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayInfo() {
        System.out.println(title + " by " + author + (isIssued ? " [Issued]" : " [Available]"));
    }
}

class Library {
    Book[] books;
    int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(String title, String author) {
        if (count < books.length) {
            books[count++] = new Book(title, author);
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full.");
        }
    }

    public void showBooks() {
        if (count == 0) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("--- Book List ---");
        for (int i = 0; i < count; i++) {
            System.out.print((i + 1) + ". ");
            books[i].displayInfo();
        }
    }

    public void issueBook(int index) {
        if (index >= 0 && index < count) {
            if (!books[index].isIssued) {
                books[index].isIssued = true;
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }

    public void returnBook(int index) {
        if (index >= 0 && index < count) {
            if (books[index].isIssued) {
                books[index].isIssued = false;
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book was not issued.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library(100);

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = input.nextLine();
                    System.out.print("Enter author name: ");
                    String author = input.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    library.showBooks();
                    break;
                case 3:
                    library.showBooks();
                    System.out.print("Enter book number to issue: ");
                    int issueIndex = input.nextInt() - 1;
                    library.issueBook(issueIndex);
                    break;
                case 4:
                    library.showBooks();
                    System.out.print("Enter book number to return: ");
                    int returnIndex = input.nextInt() - 1;
                    library.returnBook(returnIndex);
                    break;
                case 5:
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        input.close();
    }
}
