package com.iver.util;

import com.iver.records.Computer;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Subscription;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomSubscriber implements FlowableSubscriber<Computer> {

    private final long BUFFER_SIZE = 10L;
    private Map<Integer, Long> results;
    private Subscription subscription;

    @Override
    public void onSubscribe(@NonNull Subscription s) {
        this.subscription = s;
        results = new ConcurrentHashMap<>();
        subscription.request(BUFFER_SIZE);
    }

    @Override
    public void onNext(Computer computer) {
        var coreNumber = computer.processor().coreNumber();
        var valueByCoreNumber = results.getOrDefault(coreNumber, 0L);
        valueByCoreNumber++;
        results.put(coreNumber, valueByCoreNumber);
        subscription.request(1L);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

    }

    public Map<Integer, Long> getResults() {
        return results;
    }
}