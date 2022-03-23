package HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class HW3 {

        public static void main(String[] args) {
                // try-catch block for proper exception handling
                try {
                        // Create a stream of HW3.txt file to redirect standard err and out
                        PrintStream logStream = new PrintStream(HW3Constants.OUT_FILE_NAME);
                        // Redirect standard out to HW3.txt
                        System.setOut(logStream);
                        // Redirect standard err to HW3.txt
                        System.setErr(logStream);
                } catch (FileNotFoundException e) {
                        // If failed to redirect err and out to HW3.txt
                        System.err.println("Failed to redirect STDERR or STDOUT ");
                        e.printStackTrace();
                        System.exit(1);
                }

                // Declare an ArrayList to hold objects of String
                List<String> stringArrayList = new ArrayList<String>();
                // Declare an LinkedList to hold objects of String
                List<String> stringLinkedList = new LinkedList<String>();

                // try-catch block for proper exception handling
                try {
                        // Open the String.txt file for reading
                        Scanner file = new Scanner(new File(HW3Constants.FILENAME1));

                        // Read strings line-by-line
                        while (file.hasNext()) {
                                // Read a line
                                String line = file.nextLine();

                                System.out.println("Read '" + line + "' from " + HW3Constants.FILENAME1 + " file.\n");

                                // Add the line String object to ArrayList stringArrayList
                                stringArrayList.add(line);

                                // Add the line String object to LinkedList stringLinkedList
                                stringLinkedList.add(line);
                        }

                        // Close the file
                        file.close();

                } catch (IOException e) {
                        // If failed to open String.txt file
                        System.err.println("Failed to open '" + HW3Constants.FILENAME1 + "' file.");
                        e.printStackTrace();
                        System.exit(1);
                }

                // Declare an ArrayList to hold objects of Book
                List<Book> bookArrayList = new ArrayList<Book>();
                // Declare an LinkedList to hold objects of Book
                List<Book> bookLinkedList = new LinkedList<Book>();

                // try-catch block for proper exception handling
                try {
                        // Open the Book.txt file for reading
                        Scanner file = new Scanner(new File(HW3Constants.FILENAME2));

                        // Read strings line-by-line
                        while (file.hasNext()) {
                                // Read a line
                                String line = file.nextLine();

                                System.out.println("Read '" + line + "' from " + HW3Constants.FILENAME2 + " file.\n");

                                // Split the line string into tokens by using comma as separator
                                String[] tokens = line.split(HW3Constants.SEPARATOR);

                                // Extract book name from tokens
                                String name = tokens[0];

                                // Extract book type from tokens
                                BookTypes type = null;
                                if (tokens[1].equals("HARDBACK")) {
                                        type = BookTypes.HARDBACK;
                                } else if (tokens[1].equals("SOFTBACK")) {
                                        type = BookTypes.SOFTBACK;
                                } else if (tokens[1].equals("ELECTRONIC")) {
                                        type = BookTypes.ELECTRONIC;
                                }

                                // Extract number of pages from tokens
                                int noOfPages = Integer.parseInt(tokens[2]);

                                // Extract book price from tokens
                                double price = Double.parseDouble(tokens[3]);

                                try {
                                        // Create an object of Book using the above details
                                        Book book = new Book(noOfPages, price, name, type);

                                        // Add the Book object to ArrayList bookArrayList
                                        bookArrayList.add(book);

                                        // Add the Book object to LinkedList bookLinkedList
                                        bookLinkedList.add(book);
                                } catch (BookException e) {
                                        System.err.println("Failed to create a Book object..");
                                        e.printStackTrace();
                                        System.out.println("\n");
                                }
                        }

                        // Close the file
                        file.close();

                } catch (IOException e) {
                        // If failed to open Book.txt file
                        System.err.println("Failed to open '" + HW3Constants.FILENAME2 + "' file.");
                        e.printStackTrace();
                        System.exit(1);
                }

                // Use isEmpty() method to ArrayList
                System.out.println("Output of stringArrayList.isEmpty():\n" + stringArrayList.isEmpty() + "\n");
                System.out.println("Output of bookArrayList.isEmpty():\n" + bookArrayList.isEmpty() + "\n");
                System.out.println("\n");

                // Use remove() method to ArrayList
                System.out.println("Output of stringArrayList.remove(1):\n" + stringArrayList.remove(1) + "\n");
                System.out.println("Output of bookArrayList.remove(1):\n" + bookArrayList.remove(1) + "\n");
                System.out.println("\n");

                // Use size() method to ArrayList
                System.out.println("Output of stringArrayList.size():\n" + stringArrayList.size() + "\n");
                System.out.println("Output of bookArrayList.size():\n" + bookArrayList.size() + "\n");
                System.out.println("\n");

                // add() method already has been used above while populating the ArrayLists

                // Use iterator to ArrayList
                System.out.println("Using iterator on stringArrayList:");
                for (String string : stringArrayList) {
                        System.out.println(string);
                }
                System.out.println("\n");

                System.out.println("Using iterator on bookArrayList:");
                for (Book book : bookArrayList) {
                        System.out.println(book);
                }
                System.out.println("\n");

                // Use ListIterator to ArrayList
                System.out.println("Using ListIterator on stringArrayList (to iterate in reverse order):");
                ListIterator<String> iterator1 = stringArrayList.listIterator(stringArrayList.size());
                // Print out in reverse order
                while (iterator1.hasPrevious()) {
                        System.out.println(iterator1.previous());
                }
                System.out.println("\n");

                System.out.println("Using ListIterator on bookArrayList (to iterate in reverse order):");
                ListIterator<Book> iterator2 = bookArrayList.listIterator(bookArrayList.size());
                // Print out in reverse order
                while (iterator2.hasPrevious()) {
                        System.out.println(iterator2.previous());
                }
                System.out.println("\n");

                // add() method already has been used above while populating the LinkedLists

                // Use ListIterator to LinkedLists
                System.out.println("Using ListIterator on stringLinkedList (to iterate in reverse order):");
                ListIterator<String> iterator3 = stringLinkedList.listIterator(stringLinkedList.size());
                // Print out in reverse order
                while (iterator3.hasPrevious()) {
                        System.out.println(iterator3.previous());
                }
                System.out.println("\n");

                System.out.println("Using ListIterator on bookLinkedList (to iterate in reverse order):");
                ListIterator<Book> iterator4 = bookLinkedList.listIterator(bookLinkedList.size());
                // Print out in reverse order
                while (iterator4.hasPrevious()) {
                        System.out.println(iterator4.previous());
                }
                System.out.println("\n");

                // Use iterator to LinkedLists
                System.out.println("Using iterator on stringLinkedList:");
                for (String string : stringLinkedList) {
                        System.out.println(string);
                }
                System.out.println("\n");

                System.out.println("Using iterator on bookLinkedList:");
                for (Book book : bookLinkedList) {
                        System.out.println(book);
                }
                System.out.println("\n");

        }

}
