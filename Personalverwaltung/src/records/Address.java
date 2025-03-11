package records;

public record Address(int streetNr, String street, String zipCode, String city, String state) {
    @Override
    public String toString() {
        return "Adresse(" + streetNr + "; " + street + "; " + zipCode + "; " + city + "; " + state + ")";
    }
}
