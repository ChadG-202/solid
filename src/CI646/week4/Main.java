package CI646.week4;

import CI646.books.Author;
import CI646.books.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * CI346
 * Entry point for the Week 4 Lab Session.
 */
public class Main {

    public static void main(String[] args) {
        try {
            String[] contents = readLines("etc/pg1459.txt");
            DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date dob = formatter.parse("09/26/1888");
            Author a = new Author("Thomas", "Stearns", "Eliot", dob);
            Book b = new Book("Prufrock and Other Observations", a, contents);
            b.save();
            Optional<Book> anotherBook = Book.read(b.getTitle()+".ser");
            if(anotherBook.isPresent()){
                b = anotherBook.get();
                b.printInfo();
                for(int i=0;i<b.getLength();i++) {
                    System.out.println("------------------------------------------------- ");
                    b.printHeader();
                    System.out.println("------------------------------------------------- \n");

                    b.printPage();
                    b.turnPage();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer lines = new StringBuffer();
        List<String> pages = new ArrayList<String>();
        String line;
        int linesRead = 0;
        int linesPerPage = 50;
        while ((line = bufferedReader.readLine()) != null) {
            lines.append(line);
            lines.append("\n");
            linesRead++;
            if(linesRead >= linesPerPage) {
                pages.add(lines.toString());
                lines.delete(0, lines.length());
                linesRead = 0;
            }
        }
        if(lines.length()>0) {
            pages.add(lines.toString());
        }
        bufferedReader.close();
        return pages.toArray(new String[pages.size()]);
    }
}
