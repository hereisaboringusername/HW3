public class Book {
    private int totalPages;
    private double price;
    private String name;
    private BookTypes bookType;

    public Book(int totalPages, double price, String name, BookTypes bookType) {
        this.totalPages = totalPages;
        this.price = price;
        this.name = name;
        this.bookType = bookType;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookTypes getBookType() {
        return bookType;
    }

    public void setBookType(BookTypes bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "totalPages=" + totalPages +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", bookType=" + bookType +
                '}';
    }
}
