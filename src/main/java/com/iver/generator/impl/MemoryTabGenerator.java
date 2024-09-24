package com.iver.generator.impl;

import com.iver.generator.Generator;
import com.iver.records.MemoryTab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MemoryTabGenerator implements Generator<MemoryTab> {

    private final Random random;

    public MemoryTabGenerator(Random random) {
        this.random = random;
    }

    @Override
    public List<MemoryTab> generate(int size) {
        var memTabs = new ArrayList<MemoryTab>();

        IntStream.range(0, size).forEach(it -> {
            memTabs.add(generateMemoryTab());
        });

        return memTabs;
    }

    private MemoryTab generateMemoryTab() {
        return new MemoryTab(
                generateSize(),
                generateSpeed()
        );
    }

    private int generateSize() {
        int[] sizes = {1, 2, 4, 8, 16, 32, 64};
        return 1024 * sizes[random.nextInt(sizes.length)];
    }

    private int generateSpeed() {
        return 1000 * random.nextInt(1, 8);
    }
}
