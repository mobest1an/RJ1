package com.iver.calculation.impl;

import com.iver.calculation.Calculator;
import com.iver.records.Computer;
import com.iver.util.CustomCollector;

import java.util.List;
import java.util.Map;

public class ParallelStreamApiCustomCalculator implements Calculator {
    @Override
    public Map<Integer, Long> calculate(List<Computer> computers) {
        return computers.parallelStream().collect(new CustomCollector());
    }

    @Override
    public String calculatorName() {
        return "Stream API calculator with custom collectors, parallel stream and default spliterator";
    }
}
