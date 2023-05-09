import java.util.regex.Pattern;

public class Human {
    private  int age;
    private String name;
    private String surname;
    private  Address address;

    public Human() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0 && age<120){
            this.age = age;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws HumanException {
        if(name!=null) {
            if (Pattern.matches("[A-Z]{1}[a-z]{1,12}",name)) {
                this.name = name;
            }else {
                throw new HumanException("incorrect data about name");
            }
        }else {
            throw new HumanException("name is null");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws HumanException {
        if(surname!=null) {
            if (Pattern.matches("[A-Z]{1}[a-z]{1,12}",surname)) {
                this.surname =surname;
            }else {
                throw new HumanException("incorrect data about  surname");
            }

        }else {
            throw new HumanException("surname is null");
        }

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) throws AddressException {
        if (address!= null) {
            this.address = address;
        }
        else {
            throw new AddressException("address is null");
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
}
