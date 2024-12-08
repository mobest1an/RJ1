package com.iver.util;

import com.iver.records.Computer;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomObserver implements Observer<Computer> {

    private Map<Integer, Long> results;

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        results = new ConcurrentHashMap<>();
    }

    @Override
    public void onNext(@NonNull Computer computer) {
        var coreNumber = computer.processor().coreNumber();
        var valueByCoreNumber = results.getOrDefault(coreNumber, 0L);
        valueByCoreNumber++;
        results.put(coreNumber, valueByCoreNumber);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onComplete() {
    }

    public Map<Integer, Long> getResults() {
        return results;
    }
}