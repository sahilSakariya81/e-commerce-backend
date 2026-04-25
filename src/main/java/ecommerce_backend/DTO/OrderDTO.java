package ecommerce_backend.DTO;

import org.hibernate.tool.schema.spi.SchemaTruncator;

public class OrderDTO {

    private int userId;
    private String paymentMethod;
    private String couponCode;

    public OrderDTO(int userId, String paymentMethod, String couponCode) {
        this.userId = userId;
        this.paymentMethod = paymentMethod;
        this.couponCode = couponCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
}
