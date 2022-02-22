
package CI646.books;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.Optional;

public interface BookPersister extends Serializable{
    public void save();
    public static Optional<Book> read(Path path) {
        try {
            FileInputStream fin = new FileInputStream(path.toString());
            ObjectInputStream ois = new ObjectInputStream(fin);
            return Optional.of((Book) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
