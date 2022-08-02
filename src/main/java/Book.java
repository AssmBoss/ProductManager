public class Book extends Product {
    private String author;
    private String bookName;

    public Book(int id, String name, int price, String author, String bookName) {
        super(id, name, price);
        this.author = author;
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
