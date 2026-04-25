package ecommerce_backend.DTO;

public class CardPaymentDTO {

    private int userId;
    private String amount;
    private String cardNo;
    private String expDate;
    private int cvv;

    public CardPaymentDTO(int userId, String amount, String cardNo, String expDate, int cvv) {
        this.userId = userId;
        this.amount = amount;
        this.cardNo = cardNo;
        this.expDate = expDate;
        this.cvv = cvv;
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

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
