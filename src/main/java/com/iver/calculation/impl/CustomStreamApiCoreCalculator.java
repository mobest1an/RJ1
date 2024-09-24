package com.iver.calculation.impl;

import com.iver.calculation.CoreCalculator;
import com.iver.records.Computer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomStreamApiCoreCalculator implements CoreCalculator {
    @Override
    public Map<Integer, Long> calculate(List<Computer> computers) {
        return computers.stream().collect(Collectors.groupingBy(it -> it.processor().coreNumber(), Collectors.counting()));
    }

    @Override
    public String calculatorName() {
        return "Stream API calculator with custom collectors";
    }
}
