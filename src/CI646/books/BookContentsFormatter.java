package CI646.books;

public class BookContentsFormatter extends BookFormatter{

    public BookContentsFormatter(Book book) {
        super(book);
    }

    @Override
    public String format() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<book.getLength();i++) {
            sb.append("------------------------------------------------- \n");
            sb.append(formatHeader()+"\n");
            sb.append("------------------------------------------------- \n");

            sb.append(formatPage());

            book.turnPage();
        }
        return sb.toString();
    }

    @Override
    public String formatInfo() {
        return book.getTitle();
    }
    
}
