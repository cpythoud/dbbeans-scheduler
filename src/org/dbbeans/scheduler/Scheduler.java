package org.dbbeans.scheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface Scheduler {

    void run();

    void reportException(Throwable throwable, RegistryEntry registryEntry);

    SchedulerParameters getParameters();

    default void log(Level level, String message) {
        Logger logger = getParameters().logger;
        if (logger != null)
            logger.log(level, message);
    }

    default void executeNow(String code) {
        RegistryEntry.get(code).execute(this);
    }
}
