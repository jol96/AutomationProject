package api.models;

public class ProductRequest {
    private String title;
    private String description;
    private String isbn;
    private String author;
    private Double listPrice;
    private Double price;
    private Double price50;
    private Double price100;
    private int categoryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice50() {
        return price50;
    }

    public void setPrice50(Double price50) {
        this.price50 = price50;
    }

    public Double getPrice100() {
        return price100;
    }

    public void setPrice100(Double price100) {
        this.price100 = price100;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
