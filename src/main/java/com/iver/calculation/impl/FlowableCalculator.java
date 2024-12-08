package com.iver.calculation.impl;

import com.iver.calculation.Calculator;
import com.iver.records.Computer;
import com.iver.util.CustomSubscriber;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;
import java.util.Map;

public class FlowableCalculator implements Calculator {

    private CustomSubscriber subscriber;

    public FlowableCalculator(CustomSubscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public Map<Integer, Long> calculate(List<Computer> computers) {
        Flowable<Computer> flowable = Observable.fromIterable(computers).toFlowable(BackpressureStrategy.BUFFER);
        flowable
                .subscribeOn(Schedulers.computation())
                .subscribe(subscriber);
        return subscriber.getResults();
    }

    @Override
    public String calculatorName() {
        return "Flowable calculator";
    }
}
