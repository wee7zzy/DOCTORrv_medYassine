package code.Doctorrv.model;

public class Doctor extends User {

    private String specialite;

    public Doctor(String name, String specialite,String email, String phone, String password) {
        super(name, email, phone, password);
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
