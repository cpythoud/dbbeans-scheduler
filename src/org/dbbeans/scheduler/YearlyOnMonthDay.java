// Generated by BeanMaker, on April 1, 2018 5:31:29 PM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import org.dbbeans.sql.DBTransaction;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class YearlyOnMonthDay extends YearlyOnMonthDayBase {
	public YearlyOnMonthDay() { }

	public YearlyOnMonthDay(final long id) {
		super(id);
	}

	public YearlyOnMonthDay(final YearlyOnMonthDay yearlyOnMonthDayModel) {
		super(yearlyOnMonthDayModel);
	}

	protected YearlyOnMonthDay(final long id, final long idRegistryEntry, final long idWeekdayPlaceInMonth, final long idWeekday, final long idMonth, final int everyXYear, final Date start, final long idEnding) {
		super(id, idRegistryEntry, idWeekdayPlaceInMonth, idWeekday, idMonth, everyXYear, start, idEnding);
	}

	protected YearlyOnMonthDay(final ResultSet rs) throws SQLException {
		super(rs);
	}

	public boolean hasEnding() {
		return !isIdEndingEmpty();
	}

	@Override
	protected void preDeleteExtraDbActions(DBTransaction transaction) {
		if (hasEnding())
			getEnding().delete(transaction);
	}
}

