package com.iver.calculation.impl;

import com.iver.calculation.Calculator;
import com.iver.records.Computer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamApiCalculator implements Calculator {
    @Override
    public Map<Integer, Long> calculate(List<Computer> computers) {
        return computers.parallelStream().collect(Collectors.toConcurrentMap(it -> it.processor().coreNumber(), it -> 1L, Long::sum));
    }

    @Override
    public String calculatorName() {
        return "Stream API calculator with default collectors, parallel stream and default spliterator";
    }
}
