package org.dbbeans.scheduler;

import org.dbbeans.util.Dates;

import java.sql.Date;

public class GeneralProcessor {

    private final Date today = Dates.getCurrentDate();

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
        for (Daily daily: Daily.getAll())
            daily.executeAssociatedActions(scheduler);
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
