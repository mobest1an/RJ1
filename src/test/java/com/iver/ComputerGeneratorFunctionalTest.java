package com.iver;

import com.iver.generator.Generator;
import com.iver.generator.impl.ComputerGenerator;
import com.iver.generator.impl.MemoryTabGenerator;
import com.iver.generator.impl.ProcessorGenerator;
import com.iver.records.Computer;
import com.iver.records.MemoryTab;
import com.iver.records.Processor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerGeneratorFunctionalTest extends CommonFunctionalTest {

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

        Generator<MemoryTab> memoryTabGenerator = new MemoryTabGenerator(memoryTabRandomMock);
        Generator<Processor> processorGenerator = new ProcessorGenerator(processorRandomMock);
        Generator<Computer> computerGenerator = new ComputerGenerator(memoryTabGenerator, processorGenerator, computerRandomMock);

        Computer actualComputer = computerGenerator.generate(1).get(0);
        Computer expectedComputer = stubTwoCoreComputer(actualComputer.macAddress());

        assertEquals(expectedComputer, actualComputer);
    }
}
