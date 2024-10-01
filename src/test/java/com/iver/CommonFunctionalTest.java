package com.iver;

import com.iver.enums.OperationSystemName;
import com.iver.generator.impl.ComputerGenerator;
import com.iver.records.Computer;
import com.iver.records.MemoryTab;
import com.iver.records.Processor;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public abstract class CommonFunctionalTest {

    protected Random memoryTabRandomMock;
    protected Random processorRandomMock;
    protected Random computerRandomMock;
    protected ComputerGenerator computerGeneratorMock;

    @BeforeEach
    void init() {
        memoryTabRandomMock = Mockito.mock(Random.class);
        processorRandomMock = Mockito.mock(Random.class);
        computerRandomMock = Mockito.mock(Random.class);
        computerGeneratorMock = Mockito.mock(ComputerGenerator.class);
    }

    protected void mockMemoryTabSizes() {
        int SIZES_ARRAY_LENGTH = 7;
        Mockito.when(memoryTabRandomMock.nextInt(SIZES_ARRAY_LENGTH)).thenReturn(1);
    }

    protected void mockMemoryTabSpeed() {
        Mockito.when(memoryTabRandomMock.nextInt(1, 8)).thenReturn(1);
    }

    protected void mockProcessorCoreNumbers() {
        int CORE_ARRAY_LENGTH = 6;
        Mockito.when(processorRandomMock.nextInt(CORE_ARRAY_LENGTH)).thenReturn(1);
    }

    protected void mockProcessorSpeed() {
        Mockito.when(processorRandomMock.nextInt(1000, 7000)).thenReturn(4200);
    }

    protected void mockComputerStorageSize() {
        int CORE_ARRAY_LENGTH = 5;
        Mockito.when(computerRandomMock.nextInt(CORE_ARRAY_LENGTH)).thenReturn(1);
    }

    protected void mockComputerFirstStartTime() {
        Mockito.when(computerRandomMock.nextInt(365 * 5)).thenReturn(365);
    }

    protected void mockComputerOperationSystemName() {
        int OPERATION_SYSTEM_NAME_VALUES_LENGTH = 3;
        Mockito.when(computerRandomMock.nextInt(OPERATION_SYSTEM_NAME_VALUES_LENGTH)).thenReturn(1);
    }

    protected void mockComputerMemoryTabs() {
        Mockito.when(computerRandomMock.nextInt(1, 4)).thenReturn(2);
    }

    protected void mockComputerGenerator() {
        Mockito.when(computerGeneratorMock.generate(2)).thenReturn(
                List.of(
                        stubTwoCoreComputer("1e:4b:37:f7:4c:e1"),
                        stubThreeCoreComputer("1e:4b:37:f7:4c:e1")
                )
        );
    }

    protected Computer stubTwoCoreComputer(String macAddress) {
        return new Computer(
                macAddress,
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
                ));
    }

    protected Computer stubThreeCoreComputer(String macAddress) {
        return new Computer(
                macAddress,
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
                        3,
                        4200
                ));
    }
}
