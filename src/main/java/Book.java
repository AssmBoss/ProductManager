public class Book extends Product {
    private String author;
    private String bookName;

    public Book(int id, String name, int price, String author, String bookName) {
        super(id, name, price);
        this.author = author;
        this.bookName = bookName;
    }


    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (author.contains(search)) {
            return true;
        }
        return false;
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
