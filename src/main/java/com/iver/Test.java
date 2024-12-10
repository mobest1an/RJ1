package com.iver;

import com.iver.calculation.impl.*;
import com.iver.generator.Generator;
import com.iver.generator.impl.ComputerGenerator;
import com.iver.generator.impl.MemoryTabGenerator;
import com.iver.generator.impl.ProcessorGenerator;
import com.iver.records.Computer;
import com.iver.records.MemoryTab;
import com.iver.records.Processor;
import com.iver.util.CustomObserver;
import com.iver.util.CustomSubscriber;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 2, timeUnit = TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
public class Test {

    private final Random random = new Random();
    private final Generator<Processor> processorGenerator = new ProcessorGenerator(random, false);
    private final Generator<Processor> withDelayProcessorGenerator = new ProcessorGenerator(random, true);
    private final Generator<MemoryTab> memoryTabGenerator = new MemoryTabGenerator(random);
    private final Generator<Computer> computerGenerator = new ComputerGenerator(memoryTabGenerator, processorGenerator, random);
    private final Generator<Computer> withDelayComputerGenerator = new ComputerGenerator(memoryTabGenerator, withDelayProcessorGenerator, random);

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchCircularCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        CircularCalculator calculator = new CircularCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchCircularCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        CircularCalculator calculator = new CircularCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchCircularCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        CircularCalculator calculator = new CircularCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchCircularCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        CircularCalculator calculator = new CircularCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchCircularCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        CircularCalculator calculator = new CircularCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchCircularCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        CircularCalculator calculator = new CircularCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStreamApiCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        CustomStreamApiCalculator calculator = new CustomStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStreamApiCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        CustomStreamApiCalculator calculator = new CustomStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStreamApiCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        CustomStreamApiCalculator calculator = new CustomStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStreamApiCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        CustomStreamApiCalculator calculator = new CustomStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStreamApiCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        CustomStreamApiCalculator calculator = new CustomStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStreamApiCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        CustomStreamApiCalculator calculator = new CustomStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchFlowableCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        FlowableCalculator calculator = new FlowableCalculator(new CustomSubscriber());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchFlowableCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        FlowableCalculator calculator = new FlowableCalculator(new CustomSubscriber());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchFlowableCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        FlowableCalculator calculator = new FlowableCalculator(new CustomSubscriber());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchFlowableCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        FlowableCalculator calculator = new FlowableCalculator(new CustomSubscriber());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {

            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchFlowableCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        FlowableCalculator calculator = new FlowableCalculator(new CustomSubscriber());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchFlowableCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        FlowableCalculator calculator = new FlowableCalculator(new CustomSubscriber());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchObservableCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ObservableCalculator calculator = new ObservableCalculator(new CustomObserver());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchObservableCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ObservableCalculator calculator = new ObservableCalculator(new CustomObserver());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchObservableCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ObservableCalculator calculator = new ObservableCalculator(new CustomObserver());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchObservableCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ObservableCalculator calculator = new ObservableCalculator(new CustomObserver());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchObservableCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ObservableCalculator calculator = new ObservableCalculator(new CustomObserver());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchObservableCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ObservableCalculator calculator = new ObservableCalculator(new CustomObserver());
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of( withDelayComputersCollections)) {

            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCalculator calculator = new ParallelStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {

            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCalculator calculator = new ParallelStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {

            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCalculator calculator = new ParallelStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCalculator calculator = new ParallelStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {

            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCalculator calculator = new ParallelStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCalculator calculator = new ParallelStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCustomCalculator calculator = new ParallelStreamApiCustomCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCustomCalculator calculator = new ParallelStreamApiCustomCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCustomCalculator calculator = new ParallelStreamApiCustomCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCustomCalculator calculator = new ParallelStreamApiCustomCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCustomCalculator calculator = new ParallelStreamApiCustomCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCustomCalculator calculator = new ParallelStreamApiCustomCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomSpliteratorCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCustomSpliteratorCalculator calculator = new ParallelStreamApiCustomSpliteratorCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {

            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomSpliteratorCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCustomSpliteratorCalculator calculator = new ParallelStreamApiCustomSpliteratorCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {

            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomSpliteratorCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCustomSpliteratorCalculator calculator = new ParallelStreamApiCustomSpliteratorCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomSpliteratorCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCustomSpliteratorCalculator calculator = new ParallelStreamApiCustomSpliteratorCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomSpliteratorCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        ParallelStreamApiCustomSpliteratorCalculator calculator = new ParallelStreamApiCustomSpliteratorCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchParallelStreamApiCustomSpliteratorCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        ParallelStreamApiCustomSpliteratorCalculator calculator = new ParallelStreamApiCustomSpliteratorCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStandardStreamApiCalculator500() {
        int[] collectionSizes = {500};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        StandardStreamApiCalculator calculator = new StandardStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStandardStreamApiCalculator500Delay() {
        int[] collectionSizes = {500};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        StandardStreamApiCalculator calculator = new StandardStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStandardStreamApiCalculator5000() {
        int[] collectionSizes = {5000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        StandardStreamApiCalculator calculator = new StandardStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStandardStreamApiCalculator5000Delay() {
        int[] collectionSizes = {5000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        StandardStreamApiCalculator calculator = new StandardStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStandardStreamApiCalculator50000() {
        int[] collectionSizes = {50000};

        var computersCollections = generateComputers(collectionSizes, computerGenerator);

        StandardStreamApiCalculator calculator = new StandardStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(computersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void benchStandardStreamApiCalculator50000Delay() {
        int[] collectionSizes = {50000};

        var withDelayComputersCollections = generateComputers(collectionSizes, withDelayComputerGenerator);

        StandardStreamApiCalculator calculator = new StandardStreamApiCalculator();
//        System.out.println("Calculator name: " + calculator.calculatorName());

        for (var computerCollection : List.of(withDelayComputersCollections)) {
            computerCollection.forEach(collection -> {
//                System.out.println("\n\nCollection size: " + collection.size() + "\n");
                calculator.calculate(collection);
            });
        }
    }

    private List<List<Computer>> generateComputers(int[] sizes, Generator<Computer> generator) {
        List<List<Computer>> computers = new ArrayList<>();

        IntStream.range(0, sizes.length).forEachOrdered(it -> {
            computers.add(generator.generate(sizes[it]));
        });

        return computers;
    }
}
