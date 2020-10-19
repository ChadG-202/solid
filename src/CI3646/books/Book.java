package CI3646.books;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by jb259 on 21/10/16.
 *
 */
public class Book implements BookPersister {

    private final String title;
    private final Author author;
    private final String[] contents;
    private int currentPage = 0;


    public Book(String title, Author author, String[] contents) {
        this.title = title;
        this.author = author;
        this.contents = contents;
    }

    public int getLength() {
        return contents.length;
    }

    @Override
    public void save() {
        try {
            FileOutputStream fout = new FileOutputStream(title+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Author getAuthor() {
        return author;
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
