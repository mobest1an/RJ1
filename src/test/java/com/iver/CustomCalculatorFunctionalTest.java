package com.iver;

import com.iver.calculation.impl.CustomStreamApiCalculator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomCalculatorFunctionalTest extends CommonFunctionalTest {

    @Test
    void testCalculate() {
        mockComputerGenerator();

        CustomStreamApiCalculator calculator = new CustomStreamApiCalculator();
        assertEquals(
                Map.of(2, 1L, 3, 1L),
                calculator.calculate(computerGeneratorMock.generate(2))
        );
    }
}
