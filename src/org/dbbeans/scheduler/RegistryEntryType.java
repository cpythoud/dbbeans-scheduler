// Generated by BeanMaker, on March 31, 2018 2:21:12 AM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistryEntryType extends RegistryEntryTypeBase {
	public RegistryEntryType() { }

	public RegistryEntryType(final long id) {
		super(id);
	}

	public RegistryEntryType(final RegistryEntryType registryEntryTypeModel) {
		super(registryEntryTypeModel);
	}

	protected RegistryEntryType(final long id, final String code, final String javaClass) {
		super(id, code, javaClass);
	}

	protected RegistryEntryType(final ResultSet rs) throws SQLException {
		super(rs);
	}

}
