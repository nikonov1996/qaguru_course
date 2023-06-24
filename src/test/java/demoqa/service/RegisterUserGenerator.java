package demoqa.service;

import demoqa.model.RegisterUser;

import static demoqa.service.RandomTestData.*;

public class RegisterUserGenerator {

    public static RegisterUser generateRegisterUser(){
        return new RegisterUser()
                .withFirstName(getRandomName())
                .withLastName(getRandomLastName())
                .withEmail(getRandomEmail())
                .withPhone(getPhoneNumberWithLength(10))
                .withGender(getRandomGender())
                .withAddress(getRandomAddress())
                .withStateAndCity(getRandomStateAndCity())
                .withDay(getRandomDay())
                .withMonth(getRandomMonth())
                .withYear(getRandomYear(2023,1996))
                .withHobbie(getRandomHobbie())
                .withSubject(getRandomSubject())
                .withPicture("file.jpg");
    }
}
