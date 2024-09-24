package com.iver;

import com.iver.calculation.CoreCalculator;
import com.iver.calculation.impl.CircularCoreCalculator;
import com.iver.calculation.impl.CustomStreamApiCoreCalculator;
import com.iver.calculation.impl.StandardStreamApiCoreCalculator;
import com.iver.generator.impl.ComputerGenerator;
import com.iver.generator.impl.MemoryTabGenerator;
import com.iver.generator.impl.ProcessorGenerator;
import com.iver.records.Computer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {

    private final Random random = new Random();
    private final ProcessorGenerator processorGenerator = new ProcessorGenerator(random);
    private final MemoryTabGenerator memoryTabGenerator = new MemoryTabGenerator(random);
    private final ComputerGenerator computerGenerator = new ComputerGenerator(memoryTabGenerator, processorGenerator, random);

    private final List<CoreCalculator> calculators = List.of(new CircularCoreCalculator(), new StandardStreamApiCoreCalculator(), new CustomStreamApiCoreCalculator());

    public static void main(String[] args) {
        App app = new App();
        app.calculate();
    }

    private void calculate() {
        int[] collectionSizes = {5000, 50000, 250000};
        var computersCollections = generateComputers(collectionSizes);

        for (List<Computer> collection : computersCollections) {

            println("\n\nCollection size: " + collection.size() + "\n");

            for (CoreCalculator calculator : calculators) {
                println("Calculator name: " + calculator.calculatorName());
                var startTime = System.nanoTime();
                calculator.calculate(collection);
                var resultTime = System.nanoTime() - startTime;
                println("Result time: " + resultTime);
            }
        }
    }

    private List<List<Computer>> generateComputers(int[] sizes) {
        List<List<Computer>> computers = new ArrayList<>();

        IntStream.range(0, sizes.length).forEachOrdered(it -> {
            computers.add(computerGenerator.generate(sizes[it]));
        });

        return computers;
    }

    private void println(String str) {
        System.out.println(str);
    }
}
