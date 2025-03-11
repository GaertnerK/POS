package records;

import enums.Gender;

import java.time.LocalDate;

public record Person(int id, String firstname, String lastname, int age, LocalDate birthday, Gender gender, int salary, Address address, String email, String telNumber, String department, String skills) {
    @Override
    public String toString() {
        return id + ". " + firstname + " " + lastname + "; " + birthday + "; " + gender + "; " + salary + "€; " + address + "; " + email + "; " + telNumber + "; " + department + "; Skills:" + skills;
    }
}
