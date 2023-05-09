import java.util.regex.Pattern;

public class Address {
    private String city;
    private String street;
    private String houseNumber;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws AddressException {
        if (city != null) {
            if (Pattern.matches("[A-Z]{1}[a-z]{1,12}(\\h){0,1}[A-Z]{0,1}[a-z]{0,12}", city)) {
                this.city = city;
            } else {
                throw new AddressException("incorrect data about city");
            }
        } else {
            throw new AddressException("city is null");
        }

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws AddressException {
        if (street != null) {
            if (Pattern.matches("[A-Z]{1}[a-z]{1,12}", street)) {
                this.street = street;
            } else {
                throw new AddressException("incorrect data about street");
            }
        } else{
            throw new AddressException(" street is null");
        }
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) throws AddressException {
        if (houseNumber != null) {
            if (Pattern.matches("[0-9]{1,4}[a-z]{0,1}", houseNumber)) {
                this.houseNumber = houseNumber;
            } else {
                throw new AddressException("incorrect data about  houseNumber");
            }
        } else{
            throw new AddressException("houseNumber is null");
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }
}
