package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class LionTests {

    @Mock
    Feline feline;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFoodCallDI() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getKittensDI() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void whenExceptionThrown_thenAssettionSucceeds() {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion _lion = new Lion("test", feline);
        });
        String actual = exception.getMessage();
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        assertEquals(expected, actual, "Текст ошибки при создании объекта отличается");
    }

}
