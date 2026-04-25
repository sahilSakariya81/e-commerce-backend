package ecommerce_backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
public class UserAddressTable {

    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    private int a_id;

    @Positive(message = "House number must be positive")
    private int houseNumber;

    @NotBlank(message = "Society name cannot be empty")
    @Size(max = 100, message = "Society name too long")
    private String societyName;

    @NotBlank(message = "Area cannot be empty")
    @Size(max = 100, message = "Area name too long")
    private String area;

    @NotBlank(message = "City cannot be empty")
    @Size(max = 50)
    private String city;

    @NotBlank(message = "State cannot be empty")
    @Size(max = 50)
    private String state;

    @Min(value = 100000, message = "Invalid PIN code")
    @Max(value = 999999, message = "Invalid PIN code")
    private int cityPinCode;

    public UserAddressTable(int houseNumber, String societyName, String area, String city, String state, int cityPinCode) {
        this.houseNumber = houseNumber;
        this.societyName = societyName;
        this.area = area;
        this.city = city;
        this.state = state;
        this.cityPinCode = cityPinCode;
    }

    UserAddressTable(){};

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCityPinCode() {
        return cityPinCode;
    }

    public void setCityPinCode(int cityPinCode) {
        this.cityPinCode = cityPinCode;
    }
}
