package org.dbbeans.scheduler;

public interface Scheduler {

    void run();

    void reportException(Throwable throwable, RegistryEntry registryEntry);
}
