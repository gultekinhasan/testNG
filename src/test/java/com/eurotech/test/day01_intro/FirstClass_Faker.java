package com.eurotech.test.day01_intro;

import com.github.javafaker.Faker;

public class FirstClass_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println("faker.animal().name() = " + faker.animal().name());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.gameOfThrones().character() = " + faker.gameOfThrones().character());
        System.out.println("faker.number().digits(6) = " + faker.number().digits(6));
        for (int i = 0; i < 100; i++) {
            System.out.println(i+1+"- country = " + faker.address().country());
        }
    }
}
