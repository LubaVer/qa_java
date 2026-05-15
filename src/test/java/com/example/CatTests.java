package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    @Mock
    Feline feline;

    Cat cat;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.cat = new Cat(feline);
    }

    @Test
    public void getSoundMau() {
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual, "Кошка должна мяукать");
    }

    @Test
    public void getFoodCallDI() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }
}
