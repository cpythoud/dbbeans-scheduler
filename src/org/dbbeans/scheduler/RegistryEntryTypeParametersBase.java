// Generated by BeanMaker, on March 31, 2018 2:21:12 AM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import java.util.Arrays;
import java.util.List;

import org.dbbeans.util.Strings;

public abstract class RegistryEntryTypeParametersBase {
	public List<String> getNamingFields() {
		return Arrays.asList("code");
	}

	public List<String> getOrderingFields() {
		return Arrays.asList("code");
	}

	public String getOrderByFields() {
		return Strings.concatWithSeparator(", ", getOrderingFields());
	}
}

