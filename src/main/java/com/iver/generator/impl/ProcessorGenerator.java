package com.iver.generator.impl;

import com.iver.generator.Generator;
import com.iver.records.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ProcessorGenerator implements Generator<Processor> {
    private final Random random;

    public ProcessorGenerator(Random random) {
        this.random = random;
    }

    @Override
    public List<Processor> generate(int size) {
        var processors = new ArrayList<Processor>();

        IntStream.range(0, size).forEach(it -> {
            processors.add(generateProcessor());
        });

        return processors;
    }

    private Processor generateProcessor() {
        return new Processor(
                generateCoreNumbers(),
                generateSpeed()
        );
    }

    private int generateCoreNumbers() {
        int[] coreNumbers = {1, 2, 4, 8, 16, 32};
        return coreNumbers[random.nextInt(coreNumbers.length)];
    }

    private int generateSpeed() {
        return random.nextInt(1000, 7000);
    }
}
