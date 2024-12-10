package com.iver;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {

    public static void main(String[] args) throws RunnerException {
        Options jmhRunnerOptions = new OptionsBuilder()
                // set the class name regex for benchmarks to search for to the current class
                .include("\\.")
                .warmupIterations(3)
                .measurementIterations(3)
                // do not use forking or the benchmark methods will not see references stored within its class
                .forks(0)
                // do not use multiple threads
                .threads(1)
                .shouldDoGC(true)
                .shouldFailOnError(true)
                .shouldFailOnError(true)
                .jvmArgs("-server")
                .build();

        new Runner(jmhRunnerOptions).run();
    }
}
