package org.dbbeans.scheduler;

import java.util.logging.Level;

public class GeneralProcessor {

    private final Scheduler scheduler;

    public GeneralProcessor(Scheduler scheduler) {
        this.scheduler = scheduler;

        processOnSpecificDate();
        processDaily();
        processWeekly();
        processMonthlyOnDay();
        processMonthlyOnWeekday();
        processYearlyOnDay();
        processYearlyOnMonthDay();
    }

    private void processOnSpecificDate() {
        // TODO: insert appropriate code
    }

    private void processDaily() {
        scheduler.log(Level.FINER, "--- BEGIN PROCESSING DAILIES ---");
        for (Daily daily: Daily.getAll())
            daily.executeAssociatedActions(scheduler);
        scheduler.log(Level.FINER, "--- END PROCESSING DAILIES ---");
    }

    private void processWeekly() {
        // TODO: insert appropriate code
    }

    private void processMonthlyOnDay() {
        // TODO: insert appropriate code
    }

    private void processMonthlyOnWeekday() {
        // TODO: insert appropriate code
    }

    private void processYearlyOnDay() {
        // TODO: insert appropriate code
    }

    private void processYearlyOnMonthDay() {
        // TODO: insert appropriate code
    }
}
