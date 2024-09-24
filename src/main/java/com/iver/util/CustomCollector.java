package com.iver.util;

import com.iver.records.Computer;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollector implements Collector<Computer, Map<Integer, Long>, Map<Integer, Long>> {

    @Override
    public Supplier<Map<Integer, Long>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Integer, Long>, Computer> accumulator() {
        return (result, computer) -> {
            var coreNumber = computer.processor().coreNumber();
            var valueByCoreNumber = result.getOrDefault(coreNumber, 0L);
            valueByCoreNumber++;
            result.put(coreNumber, valueByCoreNumber);
        };
    }

    @Override
    public BinaryOperator<Map<Integer, Long>> combiner() {
        return (map1, map2) -> {
            map2.forEach((k, v) -> map1.merge(k, v, Long::sum));
            return map1;
        };
    }

    @Override
    public Function<Map<Integer, Long>, Map<Integer, Long>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.UNORDERED);
    }
}
