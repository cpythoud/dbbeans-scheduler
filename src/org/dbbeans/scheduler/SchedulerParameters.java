package org.dbbeans.scheduler;

import java.util.logging.Logger;

public final class SchedulerParameters {

    Logger logger = null;

    public SchedulerParameters setLoggerName(String loggerName) {
        logger = Logger.getLogger(loggerName);
        return this;
    }

    public SchedulerParameters copy() {
        SchedulerParameters copy = new SchedulerParameters();

        copy.logger = Logger.getLogger(logger.getName());
        // TODO: do not forget to deep copy any new field added to SchedulerParameter

        return copy;
    }
}
