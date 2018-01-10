package com.codahale.metrics;

import java.io.File;

@Deprecated
public interface CsvFileProvider {

    File getFile(File directory, String metricName);

    class Adapter implements io.dropwizard.metrics5.CsvFileProvider {

        private final CsvFileProvider delegate;

        public Adapter(CsvFileProvider delegate) {
            this.delegate = delegate;
        }

        @Override
        public File getFile(File directory, String metricName) {
            return delegate.getFile(directory, metricName);
        }
    }
}
