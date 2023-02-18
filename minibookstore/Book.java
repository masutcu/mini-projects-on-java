package mini_projects.minibookstore;

public class Book extends Product{
    //extend den dolayı parametreli const import edilmeli

    public Book(String name, String price, int stock, String autherName, String publisher, String isbn) {
        super(name, price, stock);
        this.autherName = autherName;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    private String autherName;
    private String publisher;
    private String isbn;

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
