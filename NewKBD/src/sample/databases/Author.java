package sample.databases;

public class Author {
    private int autorId;
    private String authorLastName;
    private String authorFirstName;
    private String authorCountry;
    private String birthday;

    public int getAutorId() {
        return autorId;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public String getBirthday() {
        return birthday;
    }

    public Author(int autorId, String authorLastName, String authorFirstName, String authorCountry, String birthday) {
        this.autorId = autorId;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
        this.authorCountry = authorCountry;
        this.birthday = birthday;
    }
}
