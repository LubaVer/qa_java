package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTests {
    Feline feline;

    @BeforeEach
    public void init() {
        this.feline = new Feline();
    }

    @Test
    public void eatMeatFeline_MeatFood() throws Exception{
        List<String> actual = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual, "Неподходящие продукты для хищника");
    }

    @Test
    public void getFamilyCats() {
        String actual = feline.getFamily();
        String expected = "Кошачьи";
        assertEquals(expected, actual, "Животное не относится к семейству кошачих");
    }

    @Test
    public void getKittensDefaultOneBaby(){
        int actual = 1;
        int expected = feline.getKittens();
        assertEquals(expected, actual, "Должен быть один котенок");
    }

    @Test
    public void getKittensFiveBaby(){
        int actual = 5;
        int expected = feline.getKittens(5);
        assertEquals(expected, actual, "Неверное количество котят");
    }

}
