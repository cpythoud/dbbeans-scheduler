// Generated by BeanMaker, on April 1, 2018 2:28:35 AM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import org.dbbeans.sql.DBTransaction;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthlyOnDay extends MonthlyOnDayBase {
	public MonthlyOnDay() { }

	public MonthlyOnDay(final long id) {
		super(id);
	}

	public MonthlyOnDay(final MonthlyOnDay monthlyOnDayModel) {
		super(monthlyOnDayModel);
	}

	protected MonthlyOnDay(final long id, final long idRegistryEntry, final int onDay, final int everyXMonth, final Date start, final long idEnding) {
		super(id, idRegistryEntry, onDay, everyXMonth, start, idEnding);
	}

	protected MonthlyOnDay(final ResultSet rs) throws SQLException {
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

