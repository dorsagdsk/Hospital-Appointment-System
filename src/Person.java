public class Person {
    private String Name;
    private String Lastname;
    private  String Username;
    private String Password;
    private String Phone_number;

    public Person() {

    }

    //=====================================
    public String getLastname() {
        return Lastname;
    }
    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }
    //======================================
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    //=====================================
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    //========================================
    public String getUsername() {
        return Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
    //=========================================
    public String getPhone_number() {
        return Phone_number;
    }
    public void setPhone_number(String Phone_number) {

        this.Phone_number = Phone_number;
    }

}
