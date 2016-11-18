package CI346.books;

import java.io.*;
import java.util.Optional;

/**
 * This class represents a Book. It contains the code to print various details
 * of the book and to save and retrieve books using serialization.
 * Created by jb259 on 21/10/16.
 *
 */
public class Book implements Serializable {

    private String title;
    private Author author;
    private int currentPage = 0;
    private String[] contents;

    public Book(String title, Author author, String[] contents) {
        this.title = title;
        this.author = author;
        this.contents = contents;
    }

    public void printPage() {
        System.out.println(getCurrentPage());
    }

    public void printHeader() {
        System.out.println(getAuthor().getName()+", "+getTitle());
    }

    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle()+" ["+contents.length+" pages]");
        sb.append("\n");
        sb.append(getAuthor().getName());
        sb.append("\n");
        System.out.println(sb.toString());
    }

    public int getLength() {
        return contents.length;
    }

    public void save() {
        try {
            FileOutputStream fout = new FileOutputStream(title+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Optional<Book> read(String path) {
        try {
            FileInputStream fin = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fin);
            return Optional.of((Book) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void turnPage() {
        currentPage++;
    }

    public String getCurrentPage() {
        return contents[currentPage%contents.length];
    }

}
