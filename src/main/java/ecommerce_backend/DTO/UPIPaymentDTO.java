package ecommerce_backend.DTO;

public class UPIPaymentDTO {
    private int userId;
    private String amount;
    private String upiId;

    public UPIPaymentDTO(int userId, String amount, String upiId) {
        this.userId = userId;
        this.amount = amount;
        this.upiId = upiId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }


}
