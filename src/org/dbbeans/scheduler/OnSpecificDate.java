// Generated by BeanMaker, on April 1, 2018 4:18:32 AM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OnSpecificDate extends OnSpecificDateBase {
	public OnSpecificDate() { }

	public OnSpecificDate(final long id) {
		super(id);
	}

	public OnSpecificDate(final OnSpecificDate onSpecificDateModel) {
		super(onSpecificDateModel);
	}

	protected OnSpecificDate(final long id, final long idRegistryEntry, final Date when) {
		super(id, idRegistryEntry, when);
	}

	protected OnSpecificDate(final ResultSet rs) throws SQLException {
		super(rs);
	}

}
