import java.util.ArrayList;

public class Appointment extends Person{
   private Patient patientt ;
   private Doctor Doctorr;
   private String Date;
   public Appointment() {
        patientt = new Patient();
        Doctorr =new Doctor();
    }
    public Patient getPatientt() {
        return patientt;
    }

    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        Date = date;
    }

    public void setPatientt(Patient patientt) {
        this.patientt = patientt;
    }

    public Doctor getDoctorr() {
        return Doctorr;
    }

    public void setDoctorr(Doctor doctorr) {
        Doctorr = doctorr;
    }
}
