// Generated by BeanMaker, on April 1, 2018 2:28:35 AM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import java.util.Arrays;
import java.util.List;

import org.dbbeans.util.Strings;

public abstract class MonthlyOnDayParametersBase {
	public List<String> getNamingFields() {
		return Arrays.asList("id");
	}

	public List<String> getOrderingFields() {
		return Arrays.asList("id");
	}

	public String getOrderByFields() {
		return Strings.concatWithSeparator(", ", getOrderingFields());
	}
}

