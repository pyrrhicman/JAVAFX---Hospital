package sample;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Patient {
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty socialid;
    private SimpleStringProperty gender;
    private SimpleStringProperty age;
    private LocalDate birthday;
    private LocalDate dateofregistration;
    private SimpleStringProperty phonenumber;
    private SimpleStringProperty city;
    private SimpleStringProperty address;
    private SimpleStringProperty postalcode;



    public Patient(String firstname,
                   String lastname,
                   String socialid,
                   String gender,
                   String age,
                   LocalDate birthday,
                   LocalDate dateofregistration,
                   String phonenumber,
                   String city,
                   String address,
                   String postalcode) {

        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.socialid = new SimpleStringProperty(socialid);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleStringProperty(age);
        this.birthday = birthday;
        this.dateofregistration = dateofregistration;
        this.phonenumber = new SimpleStringProperty(phonenumber);
        this.city = new SimpleStringProperty(city);
        this.address = new SimpleStringProperty(address);
        this.postalcode = new SimpleStringProperty(postalcode);
    }
    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDateofregistration() {
        return dateofregistration;
    }

    public void setDateofregistration(LocalDate dateofregistration) {
        this.dateofregistration = dateofregistration;
    }

    public String getPostalcode() {
        return postalcode.get();
    }

    public SimpleStringProperty postalcodeProperty() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode.set(postalcode);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getSocialid() {
        return socialid.get();
    }

    public SimpleStringProperty socialidProperty() {
        return socialid;
    }

    public void setSocialid(String socialid) {
        this.socialid.set(socialid);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getPhonenumber() {
        return phonenumber.get();
    }

    public SimpleStringProperty phonenumberProperty() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber.set(phonenumber);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
