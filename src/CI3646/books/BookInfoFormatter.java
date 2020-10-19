package CI3646.books;

/**
 * Created by jb259 on 21/10/16.
 */
public class BookInfoFormatter extends BookFormatter {

    public BookInfoFormatter(Book book) {
        super(book);
    }

    @Override
    public String format() {
        return formatInfo();
    }

}
