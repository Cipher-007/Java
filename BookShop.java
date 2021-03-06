import java.util.Scanner;

class Publication
{
    int price;  
    String title; 
    int copies; 
    String author;

    Scanner KB = new Scanner(System.in); 

    //method to purchase books
    void deposit() 
        {
    int amt;
    System.out.println("Enter number of books/magazine you want to add to inventory : ");
    amt = KB.nextInt();
    copies = copies + amt;
        }

    //method to sell books
    void withdrawal() 
        {
            int amt;
            System.out.println("Enter number of books you want to sell : ");
            amt = KB.nextInt();
            if (copies>= amt) 
            {
                copies = copies - amt;
            } 
            else
            {
                System.out.println("The inventory only has "+copies+" available ");
            }
        }
}

class Magazine extends Publication
{
    Magazine(int p, String t, int c, String a)
    {   
        price = p;
        title = t;
        copies = c;
        issue = a;
    }

    // Author of the magazine.
    String issue;

    public String getIssue() 
    {
        return this.issue;
    }

    public void setIssue(String issue) 
    {
        this.issue = issue;
    }

    void display()
    {
        System.out.println("Title of the magazine:- "+title);
        System.out.println("Price is:- "+price);
        System.out.println("No of copies:- "+copies);
        System.out.println("Issue if the magazine is:- "+issue);
    }

    // Method to search by title
    boolean search(String acn) 
    {
        if (title.equals(acn)) 
        {
            display();
            return (true);
        }
        return (false);
    }
}

class Book extends Publication
{
    Book(int p, String t, int c, String a)
    {   
        price = p;
        title = t;
        copies = c;
        author = a;
    }

    // Author of the book.
    String author;

    public String getAuthor() 
    {
        return this.author;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    void display()
    {
        System.out.println("Title of book:- "+title);
        System.out.println("Price is:- "+price);
        System.out.println("No of copies:- "+copies);
        System.out.println("The author of the book is:- "+author);
    }

    // Method to search by title
    boolean search(String acn) 
    {
    if (title.equals(acn)) 
    {
        display();
        return (true);
    }
    return (false);
    }
}

public class BookShop
{
public static void main(String[] args) 
    {
        Scanner KB = new Scanner(System.in);
        Scanner emp = new Scanner(System.in);

        int cha;
        do
        {
            System.out.println("Main Menu\n1. For magazines\n 2. For books\n 3. Exit ");
            System.out.println("Ur Choice :"); cha = KB.nextInt();
            switch (cha) 
            {
                case 1:
                //create initial inventory
                System.out.print("How Many magazines you want to add to inventory: ");
                int n = KB.nextInt();
                Magazine C[] = new Magazine[n];
                for (int i = 0; i<C.length; i++) 
                {
                    int p;
                    String t;
                    int c; 
                    String a;

                    System.out.print("Enter the Price of the magazine: ");
                    p = emp.nextInt();
                    System.out.print("Enter the Title of the magazine:  ");
                    t = emp.next();
                    System.out.print("Enter the number of copies you want to add in inventory: ");
                    c = emp.nextInt();
                    System.out.print("Enter the issue of the magazine: ");
                    a = emp.next();

                    C[i] = new Magazine(p,t,c,a);
                }
                int ch;
                do
                {
                    System.out.println("Main Menu\n1. Display All\n 2. Search By title\n 3. Add to inventory\n 4. Sell\n 5.Exit ");
                    System.out.println("Ur Choice :"); ch = KB.nextInt();
                    switch (ch) 
                    {
                        case 1:
                            for (int i = 0; i<C.length; i++) 
                            {
                                C[i].display();
                            }
                        break;

                        case 2:
                            System.out.print("Enter the title of the magazine you want to search: ");
                            String acn = KB.next();
                            boolean found = false;
                            for (int i = 0; i<C.length; i++) 
                            {
                                found = C[i].search(acn);
                                if (found) 
                                {
                                    break;
                                }
                            }
                            if (!found) 
                            {
                                System.out.println("Search failed the magazine isn't in our inventory.");
                            }
                        break; 
                        case 3:
                            System.out.print("Enter the title of the magazine : ");
                            acn = KB.next();
                            found = false;
                            for (int i = 0; i<C.length; i++) 
                            {
                            found = C[i].search(acn);
                            if (found) 
                            {
                                C[i].deposit();
                                break;
                            }
                            }
                                if (!found) 
                            {
                                System.out.println("Search failed the magazine isn't in our inventory.");
                            }
                        break;

                        case 4:
                            System.out.print("Enter the title of the magazine : ");
                            acn = KB.next();
                            found = false;
                            for (int i = 0; i<C.length; i++) 
                            {
                                found = C[i].search(acn);
                                if (found) 
                                {
                                    C[i].withdrawal();
                                    break;
                                }
                            }
                            if (!found) 
                            {
                                System.out.println("Search failed the magazine isn't in our inventory");
                            }
                        break;

                        case 5:
                            System.out.println("Good Bye..");
                        break;
                    }
                }
                while (ch != 5);
                break;

                case 2:
                    //create initial inventory
                    System.out.print("How Many books you want to add to inventory: ");
                    int n1 = KB.nextInt();
                    Book B[] = new Book [n1];
                    for (int i = 0; i<B.length; i++) 
                    {
                    int p;
                    String t;
                    int c; 
                    String a;

                    System.out.print("Enter the Price of the book: ");
                    p = emp.nextInt();
                    System.out.print("Enter the Title of the book:  ");
                    t = emp.next();
                    System.out.print("Enter the number of copies you want to add in inventory: ");
                    c = emp.nextInt();
                    System.out.print("Enter the author of the book: ");
                    a = emp.next();

                    B[i] = new Book(p,t,c,a);
                    }
                    int cha1;
                    do
                    {
                        System.out.println("Main Menu\n1. Display All\n 2. Search By title\n 3. Add to inventory\n 4. Sell\n 5.Exit ");
                        System.out.println("Ur Choice :"); cha1 = KB.nextInt();
                        switch (cha1) 
                        {
                            case 1:
                                for (int i = 0; i<B.length; i++) 
                                {
                                    B[i].display();
                                }
                            break;

                            case 2:
                            System.out.print("Enter the title of the book you want to search: ");
                            String acn = KB.next();
                            boolean found = false;
                            for (int i = 0; i<B.length; i++) 
                            {
                                found = B[i].search(acn);
                                if (found) 
                                {
                                    break;
                                }
                            }
                            if (!found) 
                            {
                                System.out.println("Search failed the book isn't in our inventory.");
                            }
                            break; 

                            case 3:
                                System.out.print("Enter the title of the book : ");
                                acn = KB.next();
                                found = false;
                                for (int i = 0; i<B.length; i++) 
                                {
                                    found = B[i].search(acn);
                                    if (found) 
                                    {
                                        B[i].deposit();
                                        break;
                                    }
                                }
                                if (!found) 
                                {
                                    System.out.println("Search failed the book isn't in our inventory.");
                                }
                            break;

                            case 4:
                                System.out.print("Enter the title of the book : ");
                                acn = KB.next();
                                found = false;
                                for (int i = 0; i<B.length; i++) 
                                {
                                    found = B[i].search(acn);
                                    if (found) 
                                    {
                                        B[i].withdrawal();
                                        break;
                                    }
                                }
                                if (!found) 
                                {
                                    System.out.println("Search failed the book isn't in our inventory");
                                }
                            break;
                            case 5:
                                System.out.println("Good Bye..");
                            break;
                        }
                        }
                    while (cha1 != 5);
                break;
            }
        }
        while (cha != 3);
        KB.close();
        emp.close();
    }
}
