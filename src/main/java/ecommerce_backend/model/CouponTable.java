package ecommerce_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.bytecode.enhance.spi.EnhancementInfo;
import org.springframework.jmx.export.annotation.ManagedNotification;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CouponTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int couponId;

    @NotBlank(message = "Coupon code cannot be empty")
    @Size(min = 3, max = 20, message = "Coupon code must be between 3 and 20 characters")
    @Column(unique = true, nullable = false)
    private String code;

    @Min(value = 1, message = "Discount must be at least 1")
    @Max(value = 100, message = "Discount cannot exceed 100")
    private double discount;

    @Future(message = "Expiry date must be in the future")
    private LocalDate expiryDate;

    private boolean active;

    @ManyToMany
    @JoinTable(
            name = "coupon_products",
            joinColumns = @JoinColumn(name = "coupon_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductTable> products;

    public CouponTable(){};

    public CouponTable(String code, double discount, LocalDate expiryDate, boolean active, List<ProductTable> prodcts) {
        this.code = code;
        this.discount = discount;
        this.expiryDate = expiryDate;
        this.active = active;
        this.products = prodcts;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<ProductTable> getProducts() {
        return products;
    }

    public void setProducts(List<ProductTable> products) {
        this.products = products;
    }
}
