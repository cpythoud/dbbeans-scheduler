// Generated by BeanMaker, on April 1, 2018 5:31:29 PM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.beanmaker.util.BeanInternals;
import org.beanmaker.util.DBQueries;
import org.beanmaker.util.DbBeanInterface;
import org.beanmaker.util.ErrorMessage;
import org.beanmaker.util.FormatCheckHelper;
import org.beanmaker.util.IdNamePair;
import org.beanmaker.util.ToStringMaker;

import org.dbbeans.sql.DBQueryRetrieveData;
import org.dbbeans.sql.DBQuerySetup;
import org.dbbeans.sql.DBQuerySetupProcess;
import org.dbbeans.sql.DBTransaction;

import org.dbbeans.sql.queries.BooleanCheckQuery;

import org.dbbeans.util.Dates;
import org.dbbeans.util.SimpleInputDateFormat;
import org.dbbeans.util.Strings;

public abstract class YearlyOnMonthDayBase extends DbBean implements DbBeanInterface {
	private long id;
	private long idRegistryEntry;
	private long idWeekdayPlaceInMonth;
	private long idWeekday;
	private long idMonth;
	private int everyXYear;
	private String everyXYearStr = "";
	private Date start;
	private String startStr = "";
	private long idEnding;

	protected static final String DATABASE_TABLE_NAME = "schdlr_yearly_on_month_day";
	protected static final String DATABASE_FIELD_LIST = "schdlr_yearly_on_month_day.id, schdlr_yearly_on_month_day.id_registry_entry, schdlr_yearly_on_month_day.id_weekday_place_in_month, schdlr_yearly_on_month_day.id_weekday, schdlr_yearly_on_month_day.id_month, schdlr_yearly_on_month_day.every_x_year, schdlr_yearly_on_month_day.start, schdlr_yearly_on_month_day.id_ending";

	protected final BeanInternals yearlyOnMonthDayInternals = new BeanInternals("org-dbbeans-scheduler-YearlyOnMonthDay");
	protected static final YearlyOnMonthDayParameters YEARLY_ON_MONTH_DAY_PARAMETERS = new YearlyOnMonthDayParameters();

	public YearlyOnMonthDayBase() { }

	public YearlyOnMonthDayBase(final long id) {
		setId(id);
	}

	public YearlyOnMonthDayBase(final YearlyOnMonthDayBase yearlyOnMonthDayModel) {
		id = 0;
		idRegistryEntry = yearlyOnMonthDayModel.idRegistryEntry;
		idWeekdayPlaceInMonth = yearlyOnMonthDayModel.idWeekdayPlaceInMonth;
		idWeekday = yearlyOnMonthDayModel.idWeekday;
		idMonth = yearlyOnMonthDayModel.idMonth;
		setEveryXYear(yearlyOnMonthDayModel.everyXYear);
		setStart(yearlyOnMonthDayModel.start);
		idEnding = yearlyOnMonthDayModel.idEnding;
	}

	protected YearlyOnMonthDayBase(final long id, final long idRegistryEntry, final long idWeekdayPlaceInMonth, final long idWeekday, final long idMonth, final int everyXYear, final Date start, final long idEnding) {
		this.id = id;
		this.idRegistryEntry = idRegistryEntry;
		this.idWeekdayPlaceInMonth = idWeekdayPlaceInMonth;
		this.idWeekday = idWeekday;
		this.idMonth = idMonth;
		setEveryXYear(everyXYear);
		setStart(start);
		this.idEnding = idEnding;
	}

	protected YearlyOnMonthDayBase(final ResultSet rs) throws SQLException {
		this(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getInt(6), rs.getDate(7), rs.getLong(8));
	}

	@Override
	public void setId(final long id) {
		class DataFromDBQuery implements DBQuerySetupProcess {
			long idRegistryEntry = 0;
			long idWeekdayPlaceInMonth = 0;
			long idWeekday = 0;
			long idMonth = 0;
			int everyXYear = 0;
			Date start = null;
			long idEnding = 0;
			boolean idOK = false;

			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setLong(1, id);
			}

			@Override
			public void processResultSet(final ResultSet rs) throws SQLException {
				if (rs.next()) {
					idRegistryEntry = rs.getLong(1);
					idWeekdayPlaceInMonth = rs.getLong(2);
					idWeekday = rs.getLong(3);
					idMonth = rs.getLong(4);
					everyXYear = rs.getInt(5);
					start = rs.getDate(6);
					idEnding = rs.getLong(7);
					idOK = true;
				}
			}
		}

		if (id <= 0)
			throw new IllegalArgumentException("id = " + id + " <= 0");

		final DataFromDBQuery dataFromDBQuery = new DataFromDBQuery();
		dbAccess.processQuery("SELECT id_registry_entry, id_weekday_place_in_month, id_weekday, id_month, every_x_year, start, id_ending FROM schdlr_yearly_on_month_day WHERE id=?", dataFromDBQuery);

		if (!dataFromDBQuery.idOK)
			throw new IllegalArgumentException("id = " + id + " does not exist");

		initExtraDbActions(id);

		this.id = id;
		this.idRegistryEntry = dataFromDBQuery.idRegistryEntry;
		this.idWeekdayPlaceInMonth = dataFromDBQuery.idWeekdayPlaceInMonth;
		this.idWeekday = dataFromDBQuery.idWeekday;
		this.idMonth = dataFromDBQuery.idMonth;
		this.everyXYear = dataFromDBQuery.everyXYear;
		everyXYearStr = String.valueOf(everyXYear);
		this.start = dataFromDBQuery.start;
		startStr = convertDateToString(start);
		this.idEnding = dataFromDBQuery.idEnding;

		postInitActions();
	}

	protected void initExtraDbActions(final long id) { }

	protected void postInitActions() { }

	@Override
	public void resetId() {
		id = 0;
	}

	public void refreshFromDataBase() {
		if (id == 0)
			throw new IllegalArgumentException("Cannot refresh bean not yet commited to database");

		setId(id);
	}

	@Override
	public boolean equals(final Object object) {
		if (id == 0)
			return false;

		if (object instanceof YearlyOnMonthDay)
			return ((YearlyOnMonthDay) object).getId() == id;

		return false;
	}

	@Override
	public int hashCode() {
		if (id == 0)
			return -1;

		return 31 * ((int) (id ^ (id >>> 32))) + 17;
	}

	@Override
	public String toString() {
		final ToStringMaker stringMaker = new ToStringMaker(this);
		stringMaker.addField("idRegistryEntry", idRegistryEntry);
		stringMaker.addField("idWeekdayPlaceInMonth", idWeekdayPlaceInMonth);
		stringMaker.addField("idWeekday", idWeekday);
		stringMaker.addField("idMonth", idMonth);
		stringMaker.addField("everyXYear", everyXYear);
		stringMaker.addField("everyXYearStr", everyXYearStr);
		stringMaker.addField("start", start);
		stringMaker.addField("startStr", startStr);
		stringMaker.addField("idEnding", idEnding);
		return stringMaker.toString();
	}

	public void setIdRegistryEntry(final long idRegistryEntry) {
		this.idRegistryEntry = idRegistryEntry;
	}

	public void setRegistryEntry(final RegistryEntry registryEntry) {
		if (registryEntry.getId() == 0)
			throw new IllegalArgumentException("Cannot accept uninitialized RegistryEntry bean (id = 0) as argument.");

		idRegistryEntry = registryEntry.getId();
	}

	public void setIdWeekdayPlaceInMonth(final long idWeekdayPlaceInMonth) {
		this.idWeekdayPlaceInMonth = idWeekdayPlaceInMonth;
	}

	public void setWeekdayPlaceInMonth(final WeekdayPlaceInMonth weekdayPlaceInMonth) {
		if (weekdayPlaceInMonth.getId() == 0)
			throw new IllegalArgumentException("Cannot accept uninitialized WeekdayPlaceInMonth bean (id = 0) as argument.");

		idWeekdayPlaceInMonth = weekdayPlaceInMonth.getId();
	}

	public void setIdWeekday(final long idWeekday) {
		this.idWeekday = idWeekday;
	}

	public void setWeekday(final Weekday weekday) {
		if (weekday.getId() == 0)
			throw new IllegalArgumentException("Cannot accept uninitialized Weekday bean (id = 0) as argument.");

		idWeekday = weekday.getId();
	}

	public void setIdMonth(final long idMonth) {
		this.idMonth = idMonth;
	}

	public void setMonth(final Month month) {
		if (month.getId() == 0)
			throw new IllegalArgumentException("Cannot accept uninitialized Month bean (id = 0) as argument.");

		idMonth = month.getId();
	}

	public void setEveryXYear(final int everyXYear) {
		this.everyXYear = everyXYear;
		everyXYearStr = Integer.toString(everyXYear);
	}

	public void setEveryXYearStr(final String everyXYearStr) {
		this.everyXYearStr = everyXYearStr;
	}

	public void setStart(final Date start) {
		if (start == null)
			this.start = null;
		else
			this.start = new Date(start.getTime());
		startStr = convertDateToString(start);
	}

	public void setStartStr(final String startStr) {
		this.startStr = startStr;
	}

	public void setIdEnding(final long idEnding) {
		this.idEnding = idEnding;
	}

	public void setEnding(final Ending ending) {
		if (ending.getId() == 0)
			throw new IllegalArgumentException("Cannot accept uninitialized Ending bean (id = 0) as argument.");

		idEnding = ending.getId();
	}

	@Override
	public long getId() {
		return id;
	}

	public long getIdRegistryEntry() {
		return idRegistryEntry;
	}

	public RegistryEntry getRegistryEntry() {
		return new RegistryEntry(idRegistryEntry);
	}

	public long getIdWeekdayPlaceInMonth() {
		return idWeekdayPlaceInMonth;
	}

	public WeekdayPlaceInMonth getWeekdayPlaceInMonth() {
		return new WeekdayPlaceInMonth(idWeekdayPlaceInMonth);
	}

	public long getIdWeekday() {
		return idWeekday;
	}

	public Weekday getWeekday() {
		return new Weekday(idWeekday);
	}

	public long getIdMonth() {
		return idMonth;
	}

	public Month getMonth() {
		return new Month(idMonth);
	}

	public int getEveryXYear() {
		return everyXYear;
	}

	public String getEveryXYearStr() {
		return everyXYearStr;
	}

	public Date getStart() {
		if (start == null)
			return null;

		return new Date(start.getTime());
	}

	public String getStartStr() {
		return startStr;
	}

	public String getStartFormatted() {
		if (isStartEmpty()) {
			if (isStartRequired())
				throw new IllegalArgumentException("Cannot display bad data");
			return "";
		}

		if (!isStartOK())
			throw new IllegalArgumentException("Cannot display bad data");

		return formatDate(convertStringToDate(startStr));
	}

	public long getIdEnding() {
		return idEnding;
	}

	public Ending getEnding() {
		return new Ending(idEnding);
	}

	public String getIdRegistryEntryLabel() {
		return yearlyOnMonthDayInternals.getLabel("idRegistryEntry");
	}

	public String getIdWeekdayPlaceInMonthLabel() {
		return yearlyOnMonthDayInternals.getLabel("idWeekdayPlaceInMonth");
	}

	public String getIdWeekdayLabel() {
		return yearlyOnMonthDayInternals.getLabel("idWeekday");
	}

	public String getIdMonthLabel() {
		return yearlyOnMonthDayInternals.getLabel("idMonth");
	}

	public String getEveryXYearLabel() {
		return yearlyOnMonthDayInternals.getLabel("everyXYear");
	}

	public String getStartLabel() {
		return yearlyOnMonthDayInternals.getLabel("start");
	}

	public String getIdEndingLabel() {
		return yearlyOnMonthDayInternals.getLabel("idEnding");
	}

	public boolean isIdRequired() {
		return true;
	}

	public boolean isIdRegistryEntryRequired() {
		return true;
	}

	public boolean isIdWeekdayPlaceInMonthRequired() {
		return true;
	}

	public boolean isIdWeekdayRequired() {
		return true;
	}

	public boolean isIdMonthRequired() {
		return true;
	}

	public boolean isEveryXYearRequired() {
		return true;
	}

	public boolean isStartRequired() {
		return true;
	}

	public boolean isIdEndingRequired() {
		return false;
	}

	public boolean isIdToBeUnique() {
		return true;
	}

	public boolean isIdRegistryEntryToBeUnique() {
		return false;
	}

	public boolean isIdWeekdayPlaceInMonthToBeUnique() {
		return false;
	}

	public boolean isIdWeekdayToBeUnique() {
		return false;
	}

	public boolean isIdMonthToBeUnique() {
		return false;
	}

	public boolean isEveryXYearToBeUnique() {
		return false;
	}

	public boolean isStartToBeUnique() {
		return false;
	}

	public boolean isIdEndingToBeUnique() {
		return false;
	}

	@Override
	public void updateDB() {
		preUpdateConversions();

		if (id == 0) {
			createRecord();
			return;
		}

		if (id > 0) {
			updateRecord();
			return;
		}

		assert (false) : "id < 0 ?!?";
	}

	public long updateDB(final DBTransaction transaction) {
		if (YEARLY_ON_MONTH_DAY_PARAMETERS.USE_CACHE)
			throw new UnsupportedOperationException("Cannot cache intermediate updates.");

		preUpdateConversions(transaction);

		if (id == 0) {
			id = createRecord(transaction);
			return id;
		}

		if (id > 0) {
			updateRecord(transaction);
			return id;
		}

		assert (false) : "id < 0 ?!?";
		return -1;
	}

	@Override
	public void preUpdateConversions() {
		preUpdateConversions(null);
	}

	protected void preUpdateConversions(final DBTransaction transaction) {
		if (!isDataOK(transaction))
			throw new IllegalArgumentException(ErrorMessage.toStrings(getErrorMessages()));

		everyXYear = Strings.getIntVal(everyXYearStr);
		if (!Strings.isEmpty(startStr))
			start = convertStringToDate(startStr);
		else
			start = null;
	}

	@Override
	public boolean isDataOK() {
		return isDataOK(null);
	}

	protected boolean isDataOK(final DBTransaction transaction) {
		yearlyOnMonthDayInternals.clearErrorMessages();
		boolean ok = true;

		ok = checkDataForIdRegistryEntry(transaction) && ok;
		ok = checkDataForIdWeekdayPlaceInMonth(transaction) && ok;
		ok = checkDataForIdWeekday(transaction) && ok;
		ok = checkDataForIdMonth(transaction) && ok;
		ok = checkDataForEveryXYear() && ok;
		ok = checkDataForStart() && ok;
		ok = checkDataForIdEnding(transaction) && ok;

		return ok;
	}

	protected boolean checkDataForIdRegistryEntry() {
		return checkDataForIdRegistryEntry(null);
	}

	protected boolean checkDataForIdRegistryEntry(final DBTransaction transaction) {
		if (isIdRegistryEntryEmpty()) {
			if (isIdRegistryEntryRequired()) {
				yearlyOnMonthDayInternals.addErrorMessage(id, "idRegistryEntry", getIdRegistryEntryLabel(), getIdRegistryEntryEmptyErrorMessage());
				return false;
			}
		} else if (!isIdRegistryEntryOK(transaction)) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idRegistryEntry", getIdRegistryEntryLabel(), getIdRegistryEntryBadFormatErrorMessage());
			return false;
		} else if (isIdRegistryEntryToBeUnique() && !isIdRegistryEntryUnique()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idRegistryEntry", getIdRegistryEntryLabel(), getIdRegistryEntryNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	protected boolean checkDataForIdWeekdayPlaceInMonth() {
		return checkDataForIdWeekdayPlaceInMonth(null);
	}

	protected boolean checkDataForIdWeekdayPlaceInMonth(final DBTransaction transaction) {
		if (isIdWeekdayPlaceInMonthEmpty()) {
			if (isIdWeekdayPlaceInMonthRequired()) {
				yearlyOnMonthDayInternals.addErrorMessage(id, "idWeekdayPlaceInMonth", getIdWeekdayPlaceInMonthLabel(), getIdWeekdayPlaceInMonthEmptyErrorMessage());
				return false;
			}
		} else if (!isIdWeekdayPlaceInMonthOK(transaction)) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idWeekdayPlaceInMonth", getIdWeekdayPlaceInMonthLabel(), getIdWeekdayPlaceInMonthBadFormatErrorMessage());
			return false;
		} else if (isIdWeekdayPlaceInMonthToBeUnique() && !isIdWeekdayPlaceInMonthUnique()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idWeekdayPlaceInMonth", getIdWeekdayPlaceInMonthLabel(), getIdWeekdayPlaceInMonthNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	protected boolean checkDataForIdWeekday() {
		return checkDataForIdWeekday(null);
	}

	protected boolean checkDataForIdWeekday(final DBTransaction transaction) {
		if (isIdWeekdayEmpty()) {
			if (isIdWeekdayRequired()) {
				yearlyOnMonthDayInternals.addErrorMessage(id, "idWeekday", getIdWeekdayLabel(), getIdWeekdayEmptyErrorMessage());
				return false;
			}
		} else if (!isIdWeekdayOK(transaction)) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idWeekday", getIdWeekdayLabel(), getIdWeekdayBadFormatErrorMessage());
			return false;
		} else if (isIdWeekdayToBeUnique() && !isIdWeekdayUnique()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idWeekday", getIdWeekdayLabel(), getIdWeekdayNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	protected boolean checkDataForIdMonth() {
		return checkDataForIdMonth(null);
	}

	protected boolean checkDataForIdMonth(final DBTransaction transaction) {
		if (isIdMonthEmpty()) {
			if (isIdMonthRequired()) {
				yearlyOnMonthDayInternals.addErrorMessage(id, "idMonth", getIdMonthLabel(), getIdMonthEmptyErrorMessage());
				return false;
			}
		} else if (!isIdMonthOK(transaction)) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idMonth", getIdMonthLabel(), getIdMonthBadFormatErrorMessage());
			return false;
		} else if (isIdMonthToBeUnique() && !isIdMonthUnique()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idMonth", getIdMonthLabel(), getIdMonthNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	protected boolean checkDataForEveryXYear() {
		if (isEveryXYearEmpty()) {
			if (isEveryXYearRequired()) {
				yearlyOnMonthDayInternals.addErrorMessage(id, "everyXYear", getEveryXYearLabel(), getEveryXYearEmptyErrorMessage());
				return false;
			}
		} else if (!isEveryXYearOK()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "everyXYear", getEveryXYearLabel(), getEveryXYearBadFormatErrorMessage());
			return false;
		} else if (isEveryXYearToBeUnique() && !isEveryXYearUnique()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "everyXYear", getEveryXYearLabel(), getEveryXYearNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	protected boolean checkDataForStart() {
		if (isStartEmpty()) {
			if (isStartRequired()) {
				yearlyOnMonthDayInternals.addErrorMessage(id, "start", getStartLabel(), getStartEmptyErrorMessage());
				return false;
			}
		} else if (!isStartOK()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "start", getStartLabel(), getStartBadFormatErrorMessage());
			return false;
		} else if (isStartToBeUnique() && !isStartUnique()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "start", getStartLabel(), getStartNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	protected boolean checkDataForIdEnding() {
		return checkDataForIdEnding(null);
	}

	protected boolean checkDataForIdEnding(final DBTransaction transaction) {
		if (isIdEndingEmpty()) {
			if (isIdEndingRequired()) {
				yearlyOnMonthDayInternals.addErrorMessage(id, "idEnding", getIdEndingLabel(), getIdEndingEmptyErrorMessage());
				return false;
			}
		} else if (!isIdEndingOK(transaction)) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idEnding", getIdEndingLabel(), getIdEndingBadFormatErrorMessage());
			return false;
		} else if (isIdEndingToBeUnique() && !isIdEndingUnique()) {
			yearlyOnMonthDayInternals.addErrorMessage(id, "idEnding", getIdEndingLabel(), getIdEndingNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	public boolean isIdRegistryEntryEmpty() {
		return idRegistryEntry == 0;
	}

	public boolean isIdWeekdayPlaceInMonthEmpty() {
		return idWeekdayPlaceInMonth == 0;
	}

	public boolean isIdWeekdayEmpty() {
		return idWeekday == 0;
	}

	public boolean isIdMonthEmpty() {
		return idMonth == 0;
	}

	public boolean isEveryXYearEmpty() {
		return Strings.isEmpty(everyXYearStr);
	}

	public boolean isStartEmpty() {
		return Strings.isEmpty(startStr);
	}

	public boolean isIdEndingEmpty() {
		return idEnding == 0;
	}

	public String getIdRegistryEntryEmptyErrorMessage() {
		return yearlyOnMonthDayInternals.getRequiredErrorMessage("idRegistryEntry");
	}

	public String getIdWeekdayPlaceInMonthEmptyErrorMessage() {
		return yearlyOnMonthDayInternals.getRequiredErrorMessage("idWeekdayPlaceInMonth");
	}

	public String getIdWeekdayEmptyErrorMessage() {
		return yearlyOnMonthDayInternals.getRequiredErrorMessage("idWeekday");
	}

	public String getIdMonthEmptyErrorMessage() {
		return yearlyOnMonthDayInternals.getRequiredErrorMessage("idMonth");
	}

	public String getEveryXYearEmptyErrorMessage() {
		return yearlyOnMonthDayInternals.getRequiredErrorMessage("everyXYear");
	}

	public String getStartEmptyErrorMessage() {
		return yearlyOnMonthDayInternals.getRequiredErrorMessage("start");
	}

	public String getIdEndingEmptyErrorMessage() {
		return yearlyOnMonthDayInternals.getRequiredErrorMessage("idEnding");
	}

	public boolean isIdRegistryEntryOK() {
		return isIdRegistryEntryOK(null);
	}

	protected boolean isIdRegistryEntryOK(final DBTransaction transaction) {
		if (transaction == null)
			return RegistryEntry.isIdOK(idRegistryEntry);

		return RegistryEntry.isIdOK(idRegistryEntry, transaction);
	}

	public boolean isIdWeekdayPlaceInMonthOK() {
		return isIdWeekdayPlaceInMonthOK(null);
	}

	protected boolean isIdWeekdayPlaceInMonthOK(final DBTransaction transaction) {
		if (transaction == null)
			return WeekdayPlaceInMonth.isIdOK(idWeekdayPlaceInMonth);

		return WeekdayPlaceInMonth.isIdOK(idWeekdayPlaceInMonth, transaction);
	}

	public boolean isIdWeekdayOK() {
		return isIdWeekdayOK(null);
	}

	protected boolean isIdWeekdayOK(final DBTransaction transaction) {
		if (transaction == null)
			return Weekday.isIdOK(idWeekday);

		return Weekday.isIdOK(idWeekday, transaction);
	}

	public boolean isIdMonthOK() {
		return isIdMonthOK(null);
	}

	protected boolean isIdMonthOK(final DBTransaction transaction) {
		if (transaction == null)
			return Month.isIdOK(idMonth);

		return Month.isIdOK(idMonth, transaction);
	}

	public boolean isEveryXYearOK() {
		return FormatCheckHelper.isIntNumber(everyXYearStr);
	}

	public boolean isStartOK() {
		return validateDateFormat(startStr);
	}

	public boolean isIdEndingOK() {
		return isIdEndingOK(null);
	}

	protected boolean isIdEndingOK(final DBTransaction transaction) {
		if (transaction == null)
			return Ending.isIdOK(idEnding);

		return Ending.isIdOK(idEnding, transaction);
	}

	public String getIdRegistryEntryBadFormatErrorMessage() {
		return yearlyOnMonthDayInternals.getBadFormatErrorMessage("idRegistryEntry");
	}

	public String getIdWeekdayPlaceInMonthBadFormatErrorMessage() {
		return yearlyOnMonthDayInternals.getBadFormatErrorMessage("idWeekdayPlaceInMonth");
	}

	public String getIdWeekdayBadFormatErrorMessage() {
		return yearlyOnMonthDayInternals.getBadFormatErrorMessage("idWeekday");
	}

	public String getIdMonthBadFormatErrorMessage() {
		return yearlyOnMonthDayInternals.getBadFormatErrorMessage("idMonth");
	}

	public String getEveryXYearBadFormatErrorMessage() {
		return yearlyOnMonthDayInternals.getBadFormatErrorMessage("everyXYear");
	}

	public String getStartBadFormatErrorMessage() {
		return yearlyOnMonthDayInternals.getBadFormatErrorMessage("start");
	}

	public String getIdEndingBadFormatErrorMessage() {
		return yearlyOnMonthDayInternals.getBadFormatErrorMessage("idEnding");
	}

	public boolean isIdRegistryEntryUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_yearly_on_month_day WHERE id_registry_entry=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setLong(1, idRegistryEntry);
				stat.setLong(2, id);
			}
		});
	}

	public boolean isIdWeekdayPlaceInMonthUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_yearly_on_month_day WHERE id_weekday_place_in_month=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setLong(1, idWeekdayPlaceInMonth);
				stat.setLong(2, id);
			}
		});
	}

	public boolean isIdWeekdayUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_yearly_on_month_day WHERE id_weekday=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setLong(1, idWeekday);
				stat.setLong(2, id);
			}
		});
	}

	public boolean isIdMonthUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_yearly_on_month_day WHERE id_month=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setLong(1, idMonth);
				stat.setLong(2, id);
			}
		});
	}

	public boolean isEveryXYearUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_yearly_on_month_day WHERE every_x_year=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setInt(1, everyXYear);
				stat.setLong(2, id);
			}
		});
	}

	public boolean isStartUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_yearly_on_month_day WHERE start=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setDate(1, start);
				stat.setLong(2, id);
			}
		});
	}

	public boolean isIdEndingUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_yearly_on_month_day WHERE id_ending=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setLong(1, idEnding);
				stat.setLong(2, id);
			}
		});
	}

	public String getIdRegistryEntryNotUniqueErrorMessage() {
		return yearlyOnMonthDayInternals.getNotUniqueErrorMessage("idRegistryEntry");
	}

	public String getIdWeekdayPlaceInMonthNotUniqueErrorMessage() {
		return yearlyOnMonthDayInternals.getNotUniqueErrorMessage("idWeekdayPlaceInMonth");
	}

	public String getIdWeekdayNotUniqueErrorMessage() {
		return yearlyOnMonthDayInternals.getNotUniqueErrorMessage("idWeekday");
	}

	public String getIdMonthNotUniqueErrorMessage() {
		return yearlyOnMonthDayInternals.getNotUniqueErrorMessage("idMonth");
	}

	public String getEveryXYearNotUniqueErrorMessage() {
		return yearlyOnMonthDayInternals.getNotUniqueErrorMessage("everyXYear");
	}

	public String getStartNotUniqueErrorMessage() {
		return yearlyOnMonthDayInternals.getNotUniqueErrorMessage("start");
	}

	public String getIdEndingNotUniqueErrorMessage() {
		return yearlyOnMonthDayInternals.getNotUniqueErrorMessage("idEnding");
	}

	@Override
	public List<ErrorMessage> getErrorMessages() {
		return yearlyOnMonthDayInternals.getErrorMessages();
	}

	@Override
	public void reset() {
		idRegistryEntry = 0;
		idWeekdayPlaceInMonth = 0;
		idWeekday = 0;
		idMonth = 0;
		everyXYear = 0;
		everyXYearStr = "";
		start = null;
		startStr = "";
		idEnding = 0;
		yearlyOnMonthDayInternals.clearErrorMessages();
	}

	@Override
	public void fullReset() {
		reset();
		id = 0;
	}

	@Override
	public void delete() {
		final DBTransaction transaction = createDBTransaction();
		delete(transaction);
		transaction.commit();

		postDeleteActions();

		if (YEARLY_ON_MONTH_DAY_PARAMETERS.USE_CACHE)
			YEARLY_ON_MONTH_DAY_PARAMETERS.CACHE_SET.delete(id);

		fullReset();
	}

	public void delete(final DBTransaction transaction) {
		preDeleteExtraDbActions(transaction);
		transaction.addUpdate("DELETE FROM schdlr_yearly_on_month_day WHERE id=?", new DBQuerySetup() {
				@Override
				public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
					stat.setLong(1, id);
				}
			});
		deleteExtraDbActions(transaction);
	}

	protected void preDeleteExtraDbActions(final DBTransaction transaction) { }

	protected void deleteExtraDbActions(final DBTransaction transaction) { }

	protected void postDeleteActions() { }

	private class RecordCreationSetup implements DBQuerySetup {
		@Override
		public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
			stat.setLong(1, idRegistryEntry);
			stat.setLong(2, idWeekdayPlaceInMonth);
			stat.setLong(3, idWeekday);
			stat.setLong(4, idMonth);
			stat.setInt(5, everyXYear);
			stat.setDate(6, start);
			if (idEnding == 0)
				stat.setNull(7, java.sql.Types.INTEGER);
			else
				stat.setLong(7, idEnding);
		}
	}

	private class RecordUpdateSetup extends RecordCreationSetup {
		@Override
		public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
			super.setupPreparedStatement(stat);
			stat.setLong(8, id);
		}
	}

	private void createRecord() {
		final DBTransaction transaction = createDBTransaction();
		id = createRecord(transaction);
		transaction.commit();
		postCreateActions();
		updateCaching();
	}

	private long createRecord(final DBTransaction transaction) {
		preCreateExtraDbActions(transaction);
		final long id = transaction.addRecordCreation("INSERT INTO schdlr_yearly_on_month_day (id_registry_entry, id_weekday_place_in_month, id_weekday, id_month, every_x_year, start, id_ending) VALUES (?, ?, ?, ?, ?, ?, ?)", new RecordCreationSetup());
		createExtraDbActions(transaction, id);
		return id;
	}

	protected void preCreateExtraDbActions(final DBTransaction transaction) { }

	protected void createExtraDbActions(final DBTransaction transaction, final long id) { }

	protected void postCreateActions() { }

	private void updateRecord() {
		final DBTransaction transaction = createDBTransaction();
		updateRecord(transaction);
		transaction.commit();
		postUpdateActions();
		updateCaching();
	}

	private void updateRecord(final DBTransaction transaction) {
		preUpdateExtraDbActions(transaction);
		transaction.addUpdate("UPDATE schdlr_yearly_on_month_day SET id_registry_entry=?, id_weekday_place_in_month=?, id_weekday=?, id_month=?, every_x_year=?, start=?, id_ending=? WHERE id=?", new RecordUpdateSetup());
		updateExtraDbActions(transaction);
	}

	protected void preUpdateExtraDbActions(final DBTransaction transaction) { }

	protected void updateExtraDbActions(final DBTransaction transaction) { }

	protected void postUpdateActions() { }

	private void updateCaching() {
		if (YEARLY_ON_MONTH_DAY_PARAMETERS.USE_CACHE)
			YEARLY_ON_MONTH_DAY_PARAMETERS.CACHE_SET.submit((YearlyOnMonthDay) this);
	}

	protected String formatDate(final Date date) {
		return DateFormat.getDateInstance(DateFormat.LONG, yearlyOnMonthDayInternals.getLocale()).format(date);
	}

	protected Date convertStringToDate(final String str) {
		return Dates.getDateFromYYMD(str, "-");
	}

	protected String convertDateToString(final Date date) {
		if (date == null)
			return "";

		return date.toString();
	}

	protected boolean validateDateFormat(final String str) {
		final SimpleInputDateFormat simpleInputDateFormat = new SimpleInputDateFormat(SimpleInputDateFormat.ElementOrder.YYMD, "-");
		return simpleInputDateFormat.validate(str);
	}

	public static List<YearlyOnMonthDay> getAll() {
		return getAll(YEARLY_ON_MONTH_DAY_PARAMETERS.getOrderByFields());
	}

	protected static List<YearlyOnMonthDay> getAll(final String orderBy) {
		return getSelection(null, orderBy, null);
	}

	private static class GetSelectionQueryProcess implements DBQueryRetrieveData<List<YearlyOnMonthDay>> {
		@Override
		public List<YearlyOnMonthDay> processResultSet(final ResultSet rs) throws SQLException {
			final List<YearlyOnMonthDay> list = new ArrayList<YearlyOnMonthDay>();

			while (rs.next())
				list.add(new YearlyOnMonthDay(rs.getLong(1), rs.getLong(2), rs.getLong(3), rs.getLong(4), rs.getLong(5), rs.getInt(6), rs.getDate(7), rs.getLong(8)));


			return list;
		}
	}

	protected static List<YearlyOnMonthDay> getSelection(final String whereClause) {
		return getSelection(whereClause, null);
	}

	protected static List<YearlyOnMonthDay> getSelection(final String whereClause, final DBQuerySetup setup) {
		return getSelection(whereClause, YEARLY_ON_MONTH_DAY_PARAMETERS.getOrderByFields(), setup);
	}

	protected static List<YearlyOnMonthDay> getSelection(final String whereClause, final String orderBy, final DBQuerySetup setup) {
		if (whereClause == null && setup != null)
			throw new IllegalArgumentException("Cannot accept setup code without a WHERE clause.");

		final StringBuilder query = new StringBuilder();
		query.append("SELECT id, id_registry_entry, id_weekday_place_in_month, id_weekday, id_month, every_x_year, start, id_ending FROM schdlr_yearly_on_month_day");
		if (whereClause != null)
			query.append(" WHERE ").append(whereClause);
		if (orderBy != null)
			query.append(" ORDER BY ").append(orderBy);

		if (whereClause == null || setup == null)
			return dbAccess.processQuery(query.toString(), new GetSelectionQueryProcess());

		return dbAccess.processQuery(query.toString(), setup, new GetSelectionQueryProcess());
	}

	private static class GetSelectionCountQueryProcess implements DBQueryRetrieveData<Long> {
		@Override
		public Long processResultSet(final ResultSet rs) throws SQLException {
			rs.next();
			return rs.getLong(1);
		}
	}

	protected static long getSelectionCount(final String whereClause) {
		return getSelectionCount(whereClause, null);
	}

	protected static long getSelectionCount(final String whereClause, final DBQuerySetup setup) {
		final String query = "SELECT COUNT(id) FROM schdlr_yearly_on_month_day WHERE " + whereClause;

		if (setup == null)
			return dbAccess.processQuery(query, new GetSelectionCountQueryProcess());

		return dbAccess.processQuery(query, setup, new GetSelectionCountQueryProcess());
	}

	public static List<IdNamePair> getIdNamePairs(final List<String> dataFields, final List<String> orderingFields) {
		return getIdNamePairs(null, dataFields, orderingFields);
	}

	protected static List<IdNamePair> getIdNamePairs(final String whereClause, final List<String> dataFields, final List<String> orderingFields) {
		return DBQueries.getIdNamePairs(db, "schdlr_yearly_on_month_day", whereClause, dataFields, orderingFields);
	}

	public static long getCount() {
		return DBQueries.getLongCount(db, "schdlr_yearly_on_month_day");
	}

	public static boolean isIdOK(final long id) {
		return DBQueries.isIdOK(db, "schdlr_yearly_on_month_day", id);
	}

	public static boolean isIdOK(final long id, final DBTransaction transaction) {
		return DBQueries.isIdOK(transaction, "schdlr_yearly_on_month_day", id);
	}

	public static String getHumanReadableTitle(final long id) {
		if (id == 0)
			return "";

		return DBQueries.getHumanReadableTitle(db, "schdlr_yearly_on_month_day", id, YEARLY_ON_MONTH_DAY_PARAMETERS.getNamingFields());
	}

	public static List<YearlyOnMonthDay> getList(final ResultSet rs) throws SQLException {
		final List<YearlyOnMonthDay> list = new ArrayList<YearlyOnMonthDay>();

		while (rs.next())
			list.add(new YearlyOnMonthDay(rs));


		return list;
	}

	@Override
	public void setLocale(final Locale locale) {
		yearlyOnMonthDayInternals.setLocale(locale);
	}

}

