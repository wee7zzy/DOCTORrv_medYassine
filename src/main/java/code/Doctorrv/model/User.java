package code.Doctorrv.model;

public class User {
    private String name;
    private String email;
    private String phone;
    private String password;




    public User(String name,String email,String phone, String password) {
        super();
        this.name = name;
        this.email=email;
        this.phone=phone;
        this.password = password;

    }

    //setters and getters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
