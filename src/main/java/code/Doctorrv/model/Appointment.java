package code.Doctorrv.model;

public class Appointment {

    private int id;
    private String motif;
    private String time;
    private String status;
    private int patient_id;
    private int doctor_id;
    private String appointment_date;

    public Appointment() {
    }

    public Appointment(int id, String motif, String time, String status) {
        this.id = id;
        this.motif = motif;
        this.time = time;
        this.status = status;
    }

    public Appointment(int id, String motif, String time, String status, int patient_id, int doctor_id, String appointment_date) {
        this.id = id;
        this.motif = motif;
        this.time = time;
        this.status = status;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.appointment_date = appointment_date;
    }

    //setters and getters


    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


