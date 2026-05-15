package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LionParamTests {
    @Mock
    Feline feline;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void doesHaveManeFemaleReturnsFalse(String mane, boolean expected) throws Exception{
        Lion lion = new Lion(mane, feline);
        Boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual, "Пол животного определен не верно");
    }

}