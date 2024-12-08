package com.iver;

import com.iver.calculation.Calculator;
import com.iver.calculation.impl.*;
import com.iver.generator.Generator;
import com.iver.generator.impl.ComputerGenerator;
import com.iver.generator.impl.MemoryTabGenerator;
import com.iver.generator.impl.ProcessorGenerator;
import com.iver.records.Computer;
import com.iver.records.MemoryTab;
import com.iver.records.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {

    private final Random random = new Random();
    private final Generator<Processor> processorGenerator = new ProcessorGenerator(random, false);
    private final Generator<Processor> withDelayProcessorGenerator = new ProcessorGenerator(random, true);
    private final Generator<MemoryTab> memoryTabGenerator = new MemoryTabGenerator(random);
    private final Generator<Computer> computerGenerator = new ComputerGenerator(memoryTabGenerator, processorGenerator, random);
    private final Generator<Computer> withDelayComputerGenerator = new ComputerGenerator(memoryTabGenerator, withDelayProcessorGenerator, random);

    private final List<Calculator> calculators = List.of(
            new CircularCalculator(),
            new StandardStreamApiCalculator(),
            new CustomStreamApiCalculator(),
            new ParallelStreamApiCalculator(),
            new ParallelStreamApiCustomCalculator(),
            new ParallelStreamApiCustomSpliteratorCalculator()
    );

    public static void main(String[] args) {
        App app = new App();
        app.calculate();
    }

    private void calculate() {
        int[] collectionSizes = {5000, 50000, 250000};
        var computersCollections = generateComputers(collectionSizes, computerGenerator);
        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        calculators.forEach(calculator -> {
                    println("Calculator name: " + calculator.calculatorName());
                    for (var computerCollection : List.of(computersCollections, withDelayComputersCollections)) {
                        if (computerCollection == withDelayComputersCollections) {
                            println("Collection with delays");
                        }
                        computerCollection.forEach(collection -> {
                            println("\n\nCollection size: " + collection.size() + "\n");
                            var startTime = System.nanoTime();
                            calculator.calculate(collection);
                            var resultTime = System.nanoTime() - startTime;
                            println("Result time: " + resultTime);
                        });
                    }
                }
        );
    }

    private List<List<Computer>> generateComputers(int[] sizes, Generator<Computer> generator) {
        List<List<Computer>> computers = new ArrayList<>();

        IntStream.range(0, sizes.length).forEachOrdered(it -> {
            computers.add(generator.generate(sizes[it]));
        });

        return computers;
    }

    private void println(String str) {
        System.out.println(str);
    }
}
