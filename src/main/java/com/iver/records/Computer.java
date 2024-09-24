package com.iver.records;

import com.iver.enums.OperationSystemName;

import java.time.LocalDate;
import java.util.List;

public record Computer(
        String macAddress,
        int storageSize,
        LocalDate firstStartTime,
        OperationSystemName operationSystemName,
        List<MemoryTab> memoryTabs,
        Processor processor
) {
}
