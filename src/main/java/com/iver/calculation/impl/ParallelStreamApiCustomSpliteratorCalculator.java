package com.iver.calculation.impl;

import com.iver.calculation.Calculator;
import com.iver.records.Computer;
import com.iver.util.CustomCollector;
import com.iver.util.CustomSpliterator;

import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class ParallelStreamApiCustomSpliteratorCalculator implements Calculator {
    @Override
    public Map<Integer, Long> calculate(List<Computer> computers) {
        return StreamSupport.stream(new CustomSpliterator<>(computers), true).collect(new CustomCollector());
    }

    @Override
    public String calculatorName() {
        return "Stream API calculator with custom collectors, parallel stream and custom spliterator";
    }
}