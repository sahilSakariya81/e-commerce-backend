package ecommerce_backend.DTO;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.List;

public class CouponDTO {
    private String code;
    private int discount;
    private boolean active;
    private LocalDate expiryDate;

    private List<Integer> productIds;

    CouponDTO(){};

    public CouponDTO(String code, int discount, boolean active, LocalDate expiryDate, List<Integer> productIds) {
        this.code = code;
        this.discount = discount;
        this.active = active;
        this.expiryDate = expiryDate;
        this.productIds = productIds;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
    }
}
