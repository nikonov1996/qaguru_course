package demoqa.model;

import demoqa.service.RandomTestData;

import static demoqa.service.RandomTestData.getRandomGender;

public class RegisterUser {

    private String firstName;
    private String lastName;
    private String gender;
    private String phone;

    private String email;
    private String month;
    private String year;
    private String day;
    private String subject;
    private String hobbie;
    private String picture;

    private String address;
    private String[] stateAndCity;

    public String getEmail() {
        return email;
    }

    public RegisterUser withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public RegisterUser withAddress(String address) {
        this.address = address;
        return this;
    }

    public RegisterUser withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterUser withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public RegisterUser withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RegisterUser withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public RegisterUser withMonth(String month) {
        this.month = month;
        return this;
    }

    public String getYear() {
        return year;
    }

    public RegisterUser withYear(String year) {
        this.year = year;
        return this;
    }

    public String getDay() {
        return day;
    }

    public RegisterUser withDay(String day) {
        this.day = day;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public RegisterUser withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getHobbie() {
        return hobbie;
    }

    public RegisterUser withHobbie(String hobbie) {
        this.hobbie = hobbie;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public RegisterUser withPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String[] getStateAndCity() {
        return stateAndCity;
    }

    public RegisterUser withStateAndCity(String[] stateAndCity) {
        this.stateAndCity = stateAndCity;
        return this;
    }

}
