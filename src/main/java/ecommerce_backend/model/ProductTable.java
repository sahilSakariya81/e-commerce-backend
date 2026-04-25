package ecommerce_backend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class ProductTable {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int pid;

    @NotBlank(message = "Product name cannot be empty")
    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
    private String productName;

    @Positive(message = "Price must be greater than 0")
    private double price;

    @Positive(message = "Current price must be greater than 0")
    private double currentPrice;

    @Min(value = 0, message = "Discount cannot be negative")
    @Max(value = 100, message = "Discount cannot exceed 100")
    private double discount;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "Category is required")
    private CategoryTable category;

    public ProductTable(String productName, double price, double currentPrice, double discount, int stock, String description, CategoryTable category) {
        this.productName = productName;
        this.price = price;
        this.currentPrice = currentPrice;
        this.discount = discount;
        this.stock = stock;
        this.description = description;
        this.category = category;
    }

    public ProductTable(){};

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryTable getCategory() {
        return category;
    }

    public void setCategory(CategoryTable category) {
        this.category = category;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
