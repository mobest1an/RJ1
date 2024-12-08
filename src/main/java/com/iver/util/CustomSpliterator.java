package com.iver.util;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomSpliterator<T> implements Spliterator<T> {
    private final int LIMIT = 2;
    private final List<T> list;
    int index;

    public CustomSpliterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action) {
        boolean isFinished = index >= list.size();
        while (!isFinished) {
            isFinished = (index >= list.size() - 1);
            action.accept(list.get(index));
            index++;
        }
        return false;
    }

    @Override
    public Spliterator<T> trySplit() {
        int currentSize = list.size() - index;
        if (currentSize < LIMIT) {
            return null;
        }

        int splitIndex = index + currentSize / 2;
        Spliterator<T> spliterator = new CustomSpliterator<>(list.subList(index, splitIndex));
        index = splitIndex;
        return spliterator;
    }

    @Override
    public long estimateSize() {
        return list.size() - index;
    }

    @Override
    public int characteristics() {
        return SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }
}