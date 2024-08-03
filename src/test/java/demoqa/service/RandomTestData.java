package demoqa.service;

import com.github.javafaker.Faker;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class RandomTestData {

    private static Faker instance;
    public static Faker getFackerInctance(){
        if (instance == null){
            instance = new Faker();
        }
        return instance;
    }

    private static String randomArrayValue(String[] arr){
        return arr[(int)Math.floor(Math.random()* arr.length)];
    }

    public static int getRandomNumber(int max, int min){
        int range = max-min+1;
        return (int) (Math.random() * range) + min;
    }

    public static String getRandomName(){
        return getFackerInctance().name().firstName();
    }

    public static String getRandomLastName(){
        return getFackerInctance().name().lastName();
    }

    public static String getRandomEmail(){
        return getFackerInctance().internet().emailAddress();
    }

    public static String getRandomAddress(){
        return getFackerInctance().address().fullAddress();
    }

    public static String getPhoneNumberWithLength(int length){
        return getFackerInctance().number().digits(length);
    }
    public static String getRandomYear(int max, int min){
        return Integer.toString(getRandomNumber(max,min));
    }

    public static String getRandomDay(){
        return Integer.toString(getRandomNumber(29,1));
    }

    public static String getRandomMonth(){
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return randomArrayValue(months);
    }

    public static String getRandomGender(){
        String[] genders = {"Male","Female","Other"};
        return randomArrayValue(genders);
    }

    public static String getRandomHobbie(){
        String[] hobbies = {"Sports","Reading","Music"};
        return randomArrayValue(hobbies);
    }

    public static String getRandomSubject(){
        String[] subjects = {
                "English", "Commerce",
                "Economics", "Maths", "Arts"};
        return randomArrayValue(subjects);
    }

    public static String[] getRandomStateAndCity(){
        String[] states = {"NCR","Haryana"};
        HashMap<String,String[]> statesAndCities = new HashMap<>();
        statesAndCities.put("NCR",new String[]{"Delhi","Noida"});
        statesAndCities.put("Haryana",new String[]{"Karnal","Panipat"});

        String returnState = randomArrayValue(states);
        String returnCity = randomArrayValue(statesAndCities.get(returnState));
        return new String[]{returnState, returnCity};
    }

}
