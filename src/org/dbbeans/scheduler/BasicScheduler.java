package org.dbbeans.scheduler;

import org.dbbeans.util.Exceptions;

public enum  BasicScheduler implements Scheduler {
    INSTANCE;

    @Override
    public void run() {
        new GeneralProcessor(this);
    }

    @Override
    public void reportException(Throwable throwable, RegistryEntry registryEntry) {
        System.err.println("----------------------------------------");
        System.err.println(registryEntry);
        System.err.println();
        System.err.println(Exceptions.getStackTrace(throwable));
        System.err.println("----------------------------------------");
    }

    @Override
    public SchedulerParameters getParameters() {
        return new SchedulerParameters();
    }
}
