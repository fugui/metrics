package com.codahale.metrics;

import java.util.concurrent.TimeUnit;

@Deprecated
public class SlidingTimeWindowReservoir implements Reservoir {

    private io.dropwizard.metrics5.SlidingTimeWindowReservoir delegate;

    public SlidingTimeWindowReservoir(long window, TimeUnit windowUnit) {
        this(new io.dropwizard.metrics5.SlidingTimeWindowReservoir(window, windowUnit));
    }

    public SlidingTimeWindowReservoir(long window, TimeUnit windowUnit, Clock clock) {
        this(new io.dropwizard.metrics5.SlidingTimeWindowReservoir(window, windowUnit, clock.transform()));
    }

    public SlidingTimeWindowReservoir(io.dropwizard.metrics5.SlidingTimeWindowReservoir delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.dropwizard.metrics5.Reservoir getDelegate() {
        return delegate;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public void update(long value) {
        delegate.update(value);
    }

    @Override
    public Snapshot getSnapshot() {
        return new Snapshot.Adapter(delegate.getSnapshot());
    }
}
