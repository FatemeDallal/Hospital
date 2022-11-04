public class Secretary {
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String personalNumberDoctor;

    public Secretary(String firstName, String lastName, String persinalNumber, String personalNumberDoctor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = persinalNumber;
        this.personalNumberDoctor = personalNumberDoctor;
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", persinalNumber='" + personalNumber + '\'' +
                ", personalNumberDoctor='" + personalNumberDoctor + '\'' +
                '}';
    }
}
