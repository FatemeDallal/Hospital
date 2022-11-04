public class Medicine {
    private String nameOfMedicine;
    private String priceOfMedicine;
    private String dateOfManufacture;
    private String dateOfExpiration;

    public Medicine(String nameOfMedicine, String priceOfMedicine,
                    String dateOfManufacture, String dateOfExpiration) {
        this.nameOfMedicine = nameOfMedicine;
        this.priceOfMedicine = priceOfMedicine;
        this.dateOfManufacture = dateOfManufacture;
        this.dateOfExpiration = dateOfExpiration;
    }

    public String getNameOfMedicine() {
        return nameOfMedicine;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "nameOfMedicine='" + nameOfMedicine ;
    }
}
