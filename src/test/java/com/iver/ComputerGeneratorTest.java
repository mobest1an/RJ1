package com.iver;

import com.iver.enums.OperationSystemName;
import com.iver.generator.Generator;
import com.iver.generator.impl.ComputerGenerator;
import com.iver.generator.impl.MemoryTabGenerator;
import com.iver.generator.impl.ProcessorGenerator;
import com.iver.records.Computer;
import com.iver.records.MemoryTab;
import com.iver.records.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerGeneratorTest {

    private Random memoryTabRandom;
    private Random processorRandom;
    private Random computerRandom;

    @BeforeEach
    void init() {
        memoryTabRandom = Mockito.mock(Random.class);
        processorRandom = Mockito.mock(Random.class);
        computerRandom = Mockito.mock(Random.class);
    }

    private void mockMemoryTabSizes() {
        int SIZES_ARRAY_LENGTH = 7;
        Mockito.when(memoryTabRandom.nextInt(SIZES_ARRAY_LENGTH)).thenReturn(1);
    }

    private void mockMemoryTabSpeed() {
        Mockito.when(memoryTabRandom.nextInt(1, 8)).thenReturn(1);
    }

    private void mockProcessorCoreNumbers() {
        int CORE_ARRAY_LENGTH = 6;
        Mockito.when(processorRandom.nextInt(CORE_ARRAY_LENGTH)).thenReturn(1);
    }

    private void mockProcessorSpeed() {
        Mockito.when(processorRandom.nextInt(1000, 7000)).thenReturn(4200);
    }

    private void mockComputerStorageSize() {
        int CORE_ARRAY_LENGTH = 5;
        Mockito.when(computerRandom.nextInt(CORE_ARRAY_LENGTH)).thenReturn(1);
    }

    private void mockComputerFirstStartTime() {
        Mockito.when(computerRandom.nextInt(365 * 5)).thenReturn(365);
    }

    private void mockComputerOperationSystemName() {
        int OPERATION_SYSTEM_NAME_VALUES_LENGTH = 3;
        Mockito.when(computerRandom.nextInt(OPERATION_SYSTEM_NAME_VALUES_LENGTH)).thenReturn(1);
    }

    private void mockComputerMemoryTabs() {
        Mockito.when(computerRandom.nextInt(1, 4)).thenReturn(2);
    }

    @Test
    void testGenerate() {
        mockMemoryTabSizes();
        mockMemoryTabSpeed();
        mockProcessorCoreNumbers();
        mockProcessorSpeed();
        mockComputerStorageSize();
        mockComputerFirstStartTime();
        mockComputerOperationSystemName();
        mockComputerMemoryTabs();

        Generator<MemoryTab> memoryTabGenerator = new MemoryTabGenerator(memoryTabRandom);
        Generator<Processor> processorGenerator = new ProcessorGenerator(processorRandom);
        Generator<Computer> computerGenerator = new ComputerGenerator(memoryTabGenerator, processorGenerator, computerRandom);

        Computer actualComputer = computerGenerator.generate(1).get(0);
        Computer expectedComputer = new Computer(
                actualComputer.macAddress(),
                256,
                LocalDate.now().minusDays(365),
                OperationSystemName.WINDOWS,
                List.of(
                        new MemoryTab(
                                2048,
                                1000
                        ),
                        new MemoryTab(
                                2048,
                                1000
                        )
                ),
                new Processor(
                        2,
                        4200
                )
        );

        assertEquals(expectedComputer, actualComputer);
    }
}
