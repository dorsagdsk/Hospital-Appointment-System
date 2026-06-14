public class predcrtion {
    private Patient ppppatient ;
    private Doctor  Dddddoctor;
    private  String noskha , date1;
    public predcrtion() {
        ppppatient = new Patient();
        Dddddoctor =new Doctor();
    }
    public Patient getPpppatient() {return ppppatient;
    }
    public void setPpppatient(Patient ppppatient) {
        this.ppppatient = ppppatient;
    }
    public Doctor getDddddoctor() {
        return Dddddoctor;
    }
    public void setDddddoctor(Doctor dddddoctor) {
        Dddddoctor = dddddoctor;
    }
    public String getNoskha() {
        return noskha;
    }
    public void setNoskha(String noskha) {
        this.noskha = noskha;
    }

    public String getDate1() {return date1;}

    public void setDate1(String date1) {this.date1 = date1;}
}
