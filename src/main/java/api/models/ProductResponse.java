package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("author")
    private String author;

    @JsonProperty("listPrice")
    private double listPrice;

    @JsonProperty("price")
    private double price;

    @JsonProperty("price50")
    private int price50;

    @JsonProperty("price100")
    private int price100;

    @JsonProperty("categoryId")
    private int categoryId;

    @JsonProperty("productImages")
    private String productImages;


    // Getter and setter methods for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPrice50() {
        return price50;
    }

    public void setPrice50(int price50) {
        this.price50 = price50;
    }

    public int getPrice100() {
        return price100;
    }

    public void setPrice100(int price100) {
        this.price100 = price100;
    }

    public int getCategoryId() {
        return categoryId;
    }

}