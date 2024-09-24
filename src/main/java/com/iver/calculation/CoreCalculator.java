package com.iver.calculation;

import com.iver.records.Computer;

import java.util.List;
import java.util.Map;

public interface CoreCalculator {
    Map<Integer, Long> calculate(List<Computer> computers);
    String calculatorName();
}
