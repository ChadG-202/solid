package CI346.books;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jb259 on 21/10/16.
 */
public class Author implements Serializable {
    private String firstName;
    private String middleName;
    private String surname;
    private Date dateOfBirth;

    public Author(String firstName, String middleName, String surname, Date dob) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.dateOfBirth = dob;
    }

    public String getName() {
        StringBuilder n = new StringBuilder();
        if(!firstName.isEmpty()) n.append(firstName.charAt(0) + ". ");
        if(!middleName.isEmpty()) n.append(middleName.charAt(0) + ". ");
        n.append(surname);
        return n.toString();
    }

    public String getFirstName() { return firstName;}

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getMiddleName() { return middleName;}
}
