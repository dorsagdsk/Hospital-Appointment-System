import java.util.*;
import java.util.regex.*;
public class Asid {
    public static Patient patients = new Patient();
    public static Doctor doctors = new Doctor();
    static ArrayList<Patient> patientsArrayList = new ArrayList<>();
    static ArrayList<Doctor> doctorArrayList = new ArrayList<>();
    static ArrayList<Appointment> appointmentArrayList = new ArrayList<>();


    public static void main(String[] args) {
        String[] months = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };
        Calendar calendar = Calendar.getInstance(
        );
        System.out.println("\n==============================================================================");
        System.out.println("            /ᐠ｡ꞈ｡ᐟ\\ Welcome to the sami Hospital for DEATH /ᐠ｡ꞈ｡ᐟ\\");
        System.out.println("================================================================================");
        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        System.out.println("\n\n\n\n");
        menu1();
    }//(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
    public static void menu1() {        /// main menu
        System.out.println("\t\t\t================================");
        System.out.println("\t\t\t|  doctor           [1]         |");
        System.out.println("\t\t\t================================ ");
        System.out.println("\t\t\t|  patient          [2]         |");
        System.out.println("\t\t\t================================ ");
        System.out.println("\t\t\t|  exit              [3]        |");
        System.out.println("\t\t\t================================ ");
        System.out.println("\t\t\t ....choose one option....(");
        Scanner input = new Scanner(System.in);
        boolean is = false;
        while (!is) {
            String key = input.next();
            switch (key) {
                case "1":
                    menu_3();
                    is = true;
                    break;
                case "2":
                    menu_2();
                    is = true;
                    break;
                case "3":
                    System.exit(0);
                    is = true;
                    break;
                default:
                    System.out.println(" u enter a wrong option try again");
                    break;
            }
        }
    }//(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((
    public static void menu_2() {  // menu for register and login patient
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\t|        log in as patient   [1]    |");
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\t|        register as patient [2]    |");
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\t|        back to menu        [3]    |");
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\tchoose one of these option...........");
        Scanner input = new Scanner(System.in);
        boolean state = false;
        while (!state) {
            String key = input.next();
            switch (key) {
                case "1":
                    login();
                    state = true;
                    break;
                case "2":
                    register();
                    state = true;
                    break;
                case "3":
                    menu1();
                    state = true;
                    break;
                default:
                    System.out.println(" u enter a wrong option try again");
                    break;
            }
        }
    }//(((((((((((((((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))))))))))))

    public static void menu_3() {// menu for register and login doctor
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\t|        log in as doctor    [1]    |");
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\t|        register as doctor  [2]    |");
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\t|        back to menu        [3]    |");
        System.out.println("\t\t\t=====================================");
        System.out.println("\t\t\tchoose one of these option...........");
        Scanner input = new Scanner(System.in);
        boolean state = false;
        while (!state) {
            String key = input.next();
            switch (key) {
                case "1":
                    login1();
                    state = true;
                    break;
                case "2":
                    register1();
                    state = true;
                    break;
                case "3":
                    menu1();
                    state = true;
                    break;
                default:
                    System.out.println(" u enter a wrong option try again");
                    break;
            }
        }
    }//===============================================================================

    public static void register() {// for patient
        Patient patient = new Patient();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR NAME :          |");
        patient.setName(input.nextLine());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR LASTNAME:       |");
        patient.setLastname(input.nextLine());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR ADRESS:         |");
        patient.setAdress(input.nextLine());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR USERNAME:       |");
        boolean iss = false;
        boolean ismatch;
        int s = patientsArrayList.size();
        if (patientsArrayList.size() == 0) {
            String user = input.nextLine();
            patient.setUsername(user);
        } else {
            while (!iss) {
                int c = 0;
                String user = input.nextLine();
                for (Patient value : patientsArrayList) {
                    String user1 = value.getUsername();
                    ismatch = user.equals(user1);
                    if (!ismatch) {
                        c++;
                    }
                }
                if (c == s) {
                    iss = true;
                    patient.setUsername(user);
                }
                if (!iss) System.out.println("Sorry,this username is already taken.");
            }
        }
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR PASSWORD        |");
        patient.setPassword(input.nextLine());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR PHONE NUMBER:   |");
        while (true) {
            patient.setPhone_number(input.nextLine());
            if (regexcheck(patient.getPhone_number())) {
                break;
            } else
                System.out.println("\t\t your phone number is not correct try again");
        }
        System.out.println("\t\t\t=============================");
        patientsArrayList.add(patient);
        patients = patient;

        menu1();
    }//((((((((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))

    public static boolean regexcheck(String phone_number) {
        boolean check;
        check = Pattern.matches("[^a-zA-Z&&[0-9]]{11}", phone_number);
        return check;
    }//((((((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))))

    public static void login() {//for petient

        String test1, test2;
        // Patient bimarrr = new Patient();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t===========================");
        System.out.println("\t\t\t| ENTER YOUR USERNAME:    |");
        String user = scanner.nextLine();
        System.out.println("\t\t\t==========================|");
        System.out.println("\t\t\t| ENTER YOUR PASSWORD:    |");
        String pass = scanner.nextLine();
        System.out.println("\t\t\t===========================");
        boolean is = false;
        for (Patient patient : patientsArrayList) {
            test1 = patient.getUsername();
            test2 = patient.getPassword();
            if (test1.compareTo(user) == 0) if (test2.compareTo(pass) == 0) {
                patients = patient;
                is = true;
                pmenu();
                break;
            }
        }
        if (!is) {
            System.out.println("\t\t\t\n=============================");
            System.out.println("\t\t\t u enter your info wrong       ");
            System.out.println("\t\t\t  to back to menu press 1      ");
            System.out.println("\t\t\t  if u want try again press 2  ");
            System.out.println("\t\t\t===============================");
            boolean g = false;
            while (!g) {
                String f = scanner.next();
                switch (f) {
                    case "1":
                        menu_2();
                        g = true;
                        break;
                    case "2":
                        login();
                        break;
                    default:
                        System.out.println("enter a right number");
                        break;
                }
            }
        }
    }//((((((((((((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))))))

    public static void pmenu() { // patient menu
        System.out.println("\t\t\t ==============================");
        System.out.println("\t\t\t |get a Appointment         [1 |");
        System.out.println("\t\t\t |back to menu              [2]|");
        System.out.println("\t\t\t |show a list of appointment[3]|");
        System.out.println("\t\t\t ==============================");
        Scanner input = new Scanner(System.in);
        boolean state = false;
        while (!state) {
            String key = input.next();
            switch (key) {

                case "1":
                    APPOINTMENTTT();
                    state = true;
                    break;
                case "2":
                    menu1();
                    state = true;
                    break;
                case "3":
                    list_appintment();
                    state = true;
                    break;
                default:
                    System.out.println(" u enter a wrong option try again");
                    break;
            }
        }
    }//==================================================================================

    public static void register1() { // for doctor
        Doctor doctor = new Doctor();
        Scanner input = new Scanner(System.in);
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR NAME :          |");
        doctor.setName(input.nextLine());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR LASTNAME:       |");
        doctor.setLastname(input.nextLine());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR USERNAME:       |");
        boolean iss = false;
        boolean ismatch;
        int s = doctorArrayList.size();
        if (doctorArrayList.size() == 0) {
            String user = input.nextLine();
            doctor.setUsername(user);
        } else {
            while (!iss) {
                int c = 0;
                String user = input.nextLine();
                for (Doctor value : doctorArrayList) {
                    String user1 = value.getUsername();
                    ismatch = user.equals(user1);
                    if (!ismatch) {
                        c++;
                    }
                }
                if (c == s) {
                    iss = true;
                    doctor.setUsername(user);
                }
                if (!iss) System.out.println("Sorry,this username is already taken.");
            }
        }
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR PASSWORD        |");
        doctor.setPassword(input.nextLine());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER A CAPACITY:          |");
        doctor.setCapacity(input.nextInt());
        System.out.println("\t\t\t=============================");
        System.out.println("\t\t\t|ENTER YOUR PHONE NUMBER:   |");
        doctor.setPhone_number(input.nextLine());
        while (true) {
            doctor.setPhone_number(input.nextLine());
            if (regexcheck((doctor.getPhone_number()))) {
                break;
            } else System.out.println("\t\t your phone number is not correct try again");
        }
        System.out.println("\t\t\t==============================");
        System.out.println("\t\t\t| enter your expertise:       ");
        System.out.println("\t\t\t| general[1],cardiologist[2]  ");
        System.out.println("\t\t\t|neurologist[3],psychiatrist[4]");
        System.out.println("\t\t\t==============================");
        boolean state = false;
        while (!state) {
            String key = input.next();
            switch (key) {
                case "1":
                    Doctor.Expertise general = Doctor.Expertise.General;
                    doctor.set_EXPERTISE(general);
                    state = true;
                    break;
                case "2":
                    Doctor.Expertise cardiologist = Doctor.Expertise.Cardiologist;
                    doctor.set_EXPERTISE(cardiologist);
                    state = true;
                    break;
                case "3":
                    Doctor.Expertise neurologist = Doctor.Expertise.Neurologist;
                    doctor.set_EXPERTISE(neurologist);
                    state = true;
                    break;
                case "4":
                    Doctor.Expertise psychiatrist = Doctor.Expertise.Psychiotrist;
                    doctor.set_EXPERTISE(psychiatrist);
                    state = true;
                    break;
                default:
                    System.out.println(" u enter a wrong option try again");
                    System.out.println("\n\n");
                    System.out.println("\t\t\t==============================");
                    System.out.println("\t\t\t| enter your expertise:       ");
                    System.out.println("\t\t\t| general[1],cardiologist[2]  ");
                    System.out.println("\t\t\t|neurologist[3],psychiatrist[4]");
                    System.out.println("\t\t\t==============================");
                    break;
            }
        }
        doctorArrayList.add(doctor);
        doctors = doctor;
        menu1();
    }//((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))

    public static void login1() {//for doctor
        String test1, test2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t===========================");
        System.out.println("\t\t\t| ENTER YOUR USERNAME:    |");
        String user = scanner.nextLine();
        System.out.println("\t\t\t==========================|");
        System.out.println("\t\t\t| ENTER YOUR PASSWORD:    |");
        String pass = scanner.nextLine();
        System.out.println("\t\t\t===========================");
        boolean is = false;
        for (Doctor value : doctorArrayList) {
            test1 = value.getUsername();
            test2 = value.getPassword();
            if (test1.compareTo(user) == 0) if (test2.compareTo(pass) == 0) {
                doctors = value;
                is = true;
                dmenu();
                break;
            }
        }
        if (!is) {
            System.out.println("\t\t\t\n=============================");
            System.out.println("\t\t\t u enter your info wrong       ");
            System.out.println("\t\t\t  to back to menu press 1      ");
            System.out.println("\t\t\t  if u want try again press 2  ");
            System.out.println("\t\t\t===============================");
            boolean g = false;
            while (!g) {
                String f = scanner.next();
                switch (f) {
                    case "1":
                        menu_3();
                        g = true;
                        break;
                    case "2":
                        login1();
                        break;
                    default:
                        System.out.println("enter a right number");
                        break;
                }
            }

        }
    }//==============================================================

    public static void dmenu() { // doctor menu
        Scanner in = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("\t\t\t================");
        System.out.println("\t\t\t|1)list patient|");
        System.out.println("\t\t\t|2)prediction  |");
        System.out.println("\t\t\t|3)back to menu|");
        System.out.println("\t\t\t================");
        int a = in.nextInt();
        switch (a) {
            case 1:
                list_patient();
                break;
            case 2:
              prediction();
                break;
            case 3:
                menu_3();
                break;
            default:
                dmenu();
                break;
        }
    }//////////////////////////////////////////////////////////////////////////////////////////////////

    public static void APPOINTMENTTT() { //patient get appointment
        Scanner input = new Scanner(System.in);
        Appointment appoin = new Appointment();
        for (int i = 0; i < doctorArrayList.size(); i++) {
            System.out.println("(╥﹏╥)================================================================================================(╥﹏╥)");
            System.out.println("number of DR:" + i + ")" + "  name:" + doctorArrayList.get(i).getName() + "\t\t" + "lastname:" + doctorArrayList.get(i).getLastname() + "\t\t" + "Expertise:" + doctorArrayList.get(i).get_EXPERTISE());
            System.out.println("\t\tdate:2022/" + (i + 4) + "/" + (i + 1) + "  till  2022/" + (i + 4) + "/" + (i + 29) + "\t(u can choose the date between the specified intervals) ");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("\n");
        }
        int x = 0, c = 0;
        String tarikh, asm, asm2;
        System.out.println("\t\t\t=================================");
        System.out.println("\t\t\t| ENTER DOCTOR'S NAME:          |");
        asm = input.nextLine();
        System.out.println("\t\t\t=================================");
        System.out.println("\t\t\t|ENTER THE DATE :               |");
        tarikh = input.nextLine();
        System.out.println("\t\t\t=================================");
        for (Doctor doctor : doctorArrayList) {
            asm2 = doctor.getName();
            if (asm.compareTo(asm2) == 0) {
                c = doctor.getCapacity();
            }
        }
        for (Appointment appointment : appointmentArrayList) {
            String b = appointment.getDate();
            if (b.compareTo(tarikh) == 0) {
                x++;
            }
        }
        if (x + 1 > c) {
            System.out.println("\t\t========");
            System.out.println("\t\t..full..");
            System.out.println("\t\t========");
            System.out.println("\n\n");
            System.out.println("\t\t=================");
            System.out.println("\t\tback to menu  <1>");
            System.out.println("\t\tanother doctor<2>");
            System.out.println("\t\t=================");
            boolean g = false;
            while (!g) {
                String f = input.next();
                switch (f) {
                    case "1":
                        menu1();
                        g = true;
                        break;
                    case "2":
                        APPOINTMENTTT();
                        break;
                    default:
                        System.out.println("enter a right number");
                        break;
                }
            }
        } else {
            for (Doctor doctor : doctorArrayList) {
                asm2 = doctor.getName();
                if (asm.compareTo(asm2) == 0) {
                    appoin.setDoctorr(doctor);
                    appoin.setDate(tarikh);
                    appoin.setPatientt(patients);
                }
            }
            appointmentArrayList.add(appoin);
            pmenu();
        }
    }//((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))))
    private static void list_appintment() { // here doctor can see the list of appintment
        Scanner input = new Scanner(System.in);
        int c = 0,i;
        for (i=0;i< appointmentArrayList.size();i++) {
            if (appointmentArrayList.get(i).getPatientt().getUsername().compareTo(patients.getUsername()) == 0) {
                System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
                System.out.println( "num"+i+"\t\t"+"patient name:" +appointmentArrayList.get(i).getPatientt().getName() + "\n" + "\t" + "doctor:" + appointmentArrayList.get(i).getDoctorr().getName() +

                        "\t\t date : " + appointmentArrayList.get(i).getDate());
                c++;
            }
        }
        if(c>0){
            System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑");
            System.out.println("if you want back enter                    [1]");
            System.out.println("if you want remove your appointment enter [2]");
            System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑");
            int k = input.nextInt();
            switch (k) {
                case 1:
                    menu_2();
                    break;
                case 2:
                    System.out.println("==============");
                    System.out.println("enter number ");
                    int check = input.nextInt();
                    appointmentArrayList.remove(check);
                    pmenu();
                    break;
                default:
                    pmenu();
                    break;
            }
        }

       else if (c == 0) {
            System.out.println("\t\t\t๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
            System.out.println("\t\t\t u don't have appointment");
            System.out.println("\t\t\t enter 1 to back to menu");
            System.out.println("\t\t\t๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑");
            boolean is = false;
            String a = input.next();
            while (!is) {
                if ("1".equals(a)) {
                    is = true;
                    pmenu();
                } else {
                    System.out.println("\t\t\tenter a right option");
                }
            }
        }
    }//(((((((((((((((((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))

    public static void list_patient() {// here doctor can see the list of her /his patient
        Scanner input = new Scanner(System.in);
        int c = 0,i;
        for (i=0;i< appointmentArrayList.size();i++) {
            if (appointmentArrayList.get(i).getDoctorr().getUsername().compareTo(doctors.getUsername()) == 0) {
                System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
                System.out.println("num:"+i+"\t\t"+"patient name:" + appointmentArrayList.get(i).getPatientt().getName() + "\t"  +
                        "\n" + "\t" + "doctor:" + appointmentArrayList.get(i).getDoctorr().getName() + "\t\t date : " + appointmentArrayList.get(i).getDate());
                c++;
            }
        }
            if (c > 0) {
                System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑");
                System.out.println("if you want back enter                    [1]");
                System.out.println("if you want remove your appointment enter [2]");
                System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑");
                boolean g = false;
                while (!g) {
                    String f = input.next();
                    if (Objects.equals(f, "1")) {
                       dmenu();
                        g = true;
                    } else if (Objects.equals(f, "2")) {
                        System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑");
                        System.out.println("enter number      :");
                        int check = input.nextInt();
                        appointmentArrayList.remove(check);
                        dmenu();
                    }
                }
            }
            if (c == 0) {
                System.out.println("\t\t\t๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
                System.out.println("\t\t\t u don't have patient    ");
                System.out.println("\t\t\t enter 1 to back to menu");
                System.out.println("\t\t\t๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑");
                boolean is = false;
                String a = input.next();
                while (!is) {
                    if ("1".equals(a)) {
                        is = true;
                        dmenu();
                    } else {
                        System.out.println("\t\t\t enter a right option");
                    }
                }

            }
        }//((((((((((((((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))))))))))
    public static void prediction(){ // here the doctor can write a prescription

        Scanner input = new Scanner(System.in);
        int c = 0,i;
        for (i=0;i< appointmentArrayList.size();i++) {
            if (appointmentArrayList.get(i).getDoctorr().getUsername().compareTo(doctors.getUsername()) == 0) {
                System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
                System.out.println("num:"+i+"\t\t"+"patient name:" + appointmentArrayList.get(i).getPatientt().getName() + "\t" +
                        "\n" + "\t" + "doctor:" + appointmentArrayList.get(i).getDoctorr().getName() + "\t\t date : " + appointmentArrayList.get(i).getDate());
                c++;
            }
        }
        System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
        if(c==0){
            System.out.println("  u don't have patient     ");
            System.out.println("  enter <1> to back to menu");
            System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
            boolean is = false;
            while (!is) {
                String a = input.next();
                if ("1".equals(a)) {
                    is = true;
                    dmenu();
                } else {
                    System.out.println("\t\t\t enter a right option");
                }
            }
        }//--------------------------------------------------------
        else{
            System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
            System.out.println("enter the number of patient");
            int b = input.nextInt();
            System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
            System.out.println("enter a predcrtion         ");
            input.nextLine();
            input.nextLine();
            System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
            System.out.println("enter a date               ");
            input.nextLine();
            System.out.println("๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡๑♡");
            System.out.println("finish................................................");
            appointmentArrayList.remove(b);
            System.out.println(" to back to menu enter 1 ");
            boolean is = false;
            while (!is) {
                String a = input.next();
                if ("1".equals(a)) {
                    is = true;
                    dmenu();
                } else {
                    System.out.println("\t\t\t enter a right option");
                }
            }
        }
    }
}













