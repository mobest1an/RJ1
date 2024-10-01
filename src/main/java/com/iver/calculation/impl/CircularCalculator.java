package com.iver.calculation.impl;

import com.iver.calculation.Calculator;
import com.iver.records.Computer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircularCalculator implements Calculator {
    @Override
    public Map<Integer, Long> calculate(List<Computer> computers) {
        Map<Integer, Long> result = new HashMap<>();

        for (Computer computer : computers) {
            var coreNumber = computer.processor().coreNumber();
            var valueByCoreNumber = result.getOrDefault(coreNumber, 0L);
            valueByCoreNumber++;
            result.put(coreNumber, valueByCoreNumber);
        }

        return result;
    }

    @Override
    public String calculatorName() {
        return "Iterative cycle through the collection";
    }
}
