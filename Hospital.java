// **Fateme Dallal**
import java.util.Scanner;
import java.util.ArrayList;

public class Hospital {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        PatientUserPanel patientPanel = new PatientUserPanel();
        DoctorUserPanel doctorPanel = new DoctorUserPanel();
        AdminUserPanel adminPanel = new AdminUserPanel();

        System.out.println("////////////////////////////////////////\n**Welcome to Bahman Hospital**\n" +
                "////////////////////////////////////////");

        while (true)
        {
            // منوی اصلی
            System.out.println("\nDefine your role\nEnter code\n\n1.Patient\n" +
                    "2.Doctor\n3.Management\n4.Contact us\n5.Exit");
            int codeOfRole = inp.nextInt();

            switch (codeOfRole){

                // ورود به پنل کاربری بیمار
                case 1:
                    patientPanel.operationPatient();

                    break;

                //ورود به پنل کاربری دکتر
                case 2:
                    doctorPanel.operationDoctor();

                    break;

                // ورود به پنل کاربری مدیر
                case 3:
                    adminPanel.operationAdmin();

                    break;

                // نمایش ایمیل سازنده
                case 4:
                    System.out.println("dallalfateme2512003@gmail.com");

                    break;

                // خروج
                case 5:
                    System.out.println("**Thank you for choosing us**");
                    System.exit(0);


                // ارور برای ورود دستور نا معتبر
                default:
                    System.out.println("The code entered is incorrect");

            }

            System.out.println("\n//////////////////////////////////////////////////////////////////////////////////////");

        }
    }
}

