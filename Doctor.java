public class Doctor {
    private String firstName;
    private String lastName;
    private String password;
    private String personalNumber;
    private String expertise;

    public Doctor(String firstName, String lastName, String password, String personalNumber, String expertise) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.personalNumber = personalNumber;
        this.expertise = expertise;
    }

    public String getPassword() {
        return password;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getExpertise() {
        return expertise;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", expertise='" + expertise + '\'' +
                '}'+"\n";
    }
}
