package com.iver.calculation.impl;

import com.iver.calculation.Calculator;
import com.iver.records.Computer;
import com.iver.util.CustomObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;
import java.util.Map;

public class ObservableCalculator implements Calculator {
    private final CustomObserver customObserver;

    public ObservableCalculator(CustomObserver customObserver) {
        this.customObserver = customObserver;
    }

    @Override
    public Map<Integer, Long> calculate(List<Computer> computers) {
        Observable<Computer> observable = Observable.fromIterable(computers);
        observable
                .subscribeOn(Schedulers.computation())
                .subscribe(customObserver);
        return customObserver.getResults();
    }

    @Override
    public String calculatorName() {
        return "Observable calculator";
    }
}
