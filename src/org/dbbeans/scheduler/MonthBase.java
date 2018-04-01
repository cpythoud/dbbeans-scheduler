// Generated by BeanMaker, on April 1, 2018 5:19:43 PM CEST
// Library Version #0.9.12-beta

package org.dbbeans.scheduler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.beanmaker.util.BeanInternals;
import org.beanmaker.util.DBQueries;
import org.beanmaker.util.DbBeanInterface;
import org.beanmaker.util.ErrorMessage;
import org.beanmaker.util.IdNamePair;
import org.beanmaker.util.ToStringMaker;

import org.dbbeans.sql.DBQueryRetrieveData;
import org.dbbeans.sql.DBQuerySetup;
import org.dbbeans.sql.DBQuerySetupProcess;
import org.dbbeans.sql.DBTransaction;

import org.dbbeans.sql.queries.BooleanCheckQuery;

import org.dbbeans.util.Strings;

public abstract class MonthBase extends DbBean implements DbBeanInterface {
	private long id;
	private String code = "";

	protected static final String DATABASE_TABLE_NAME = "schdlr_months";
	protected static final String DATABASE_FIELD_LIST = "schdlr_months.id, schdlr_months.code";

	protected final BeanInternals monthInternals = new BeanInternals("org-dbbeans-scheduler-Month");
	protected static final MonthParameters MONTH_PARAMETERS = new MonthParameters();

	public MonthBase() { }

	public MonthBase(final long id) {
		setId(id);
	}

	public MonthBase(final MonthBase monthModel) {
		id = 0;
		code = monthModel.code;
	}

	protected MonthBase(final long id, final String code) {
		this.id = id;
		this.code = code;
	}

	protected MonthBase(final ResultSet rs) throws SQLException {
		this(rs.getLong(1), rs.getString(2));
	}

	@Override
	public void setId(final long id) {
		class DataFromDBQuery implements DBQuerySetupProcess {
			String code = null;
			boolean idOK = false;

			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setLong(1, id);
			}

			@Override
			public void processResultSet(final ResultSet rs) throws SQLException {
				if (rs.next()) {
					code = rs.getString(1);
					idOK = true;
				}
			}
		}

		if (id <= 0)
			throw new IllegalArgumentException("id = " + id + " <= 0");

		final DataFromDBQuery dataFromDBQuery = new DataFromDBQuery();
		dbAccess.processQuery("SELECT code FROM schdlr_months WHERE id=?", dataFromDBQuery);

		if (!dataFromDBQuery.idOK)
			throw new IllegalArgumentException("id = " + id + " does not exist");

		initExtraDbActions(id);

		this.id = id;
		this.code = dataFromDBQuery.code;

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

		if (object instanceof Month)
			return ((Month) object).getId() == id;

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
		stringMaker.addField("code", code);
		return stringMaker.toString();
	}

	public void setCode(final String code) {
		this.code = code;
	}

	@Override
	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getCodeLabel() {
		return monthInternals.getLabel("code");
	}

	public boolean isIdRequired() {
		return true;
	}

	public boolean isCodeRequired() {
		return true;
	}

	public boolean isIdToBeUnique() {
		return true;
	}

	public boolean isCodeToBeUnique() {
		return true;
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
		if (MONTH_PARAMETERS.USE_CACHE)
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

	}

	@Override
	public boolean isDataOK() {
		return isDataOK(null);
	}

	protected boolean isDataOK(final DBTransaction transaction) {
		monthInternals.clearErrorMessages();
		boolean ok = true;

		ok = checkDataForCode() && ok;

		return ok;
	}

	protected boolean checkDataForCode() {
		if (isCodeEmpty()) {
			if (isCodeRequired()) {
				monthInternals.addErrorMessage(id, "code", getCodeLabel(), getCodeEmptyErrorMessage());
				return false;
			}
		} else if (!isCodeOK()) {
			monthInternals.addErrorMessage(id, "code", getCodeLabel(), getCodeBadFormatErrorMessage());
			return false;
		} else if (isCodeToBeUnique() && !isCodeUnique()) {
			monthInternals.addErrorMessage(id, "code", getCodeLabel(), getCodeNotUniqueErrorMessage());
			return false;
		}

		return true;
	}

	public boolean isCodeEmpty() {
		return Strings.isEmpty(code);
	}

	public String getCodeEmptyErrorMessage() {
		return monthInternals.getRequiredErrorMessage("code");
	}

	public boolean isCodeOK() {
		return true;
	}

	public String getCodeBadFormatErrorMessage() {
		return monthInternals.getBadFormatErrorMessage("code");
	}

	public boolean isCodeUnique() {
		return !dbAccess.processQuery("SELECT id FROM schdlr_months WHERE code=? AND id <> ?", new BooleanCheckQuery() {
			@Override
			public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
				stat.setString(1, code);
				stat.setLong(2, id);
			}
		});
	}

	public String getCodeNotUniqueErrorMessage() {
		return monthInternals.getNotUniqueErrorMessage("code");
	}

	@Override
	public List<ErrorMessage> getErrorMessages() {
		return monthInternals.getErrorMessages();
	}

	@Override
	public void reset() {
		code = "";
		monthInternals.clearErrorMessages();
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

		if (MONTH_PARAMETERS.USE_CACHE)
			MONTH_PARAMETERS.CACHE_SET.delete(id);

		fullReset();
	}

	public void delete(final DBTransaction transaction) {
		preDeleteExtraDbActions(transaction);
		transaction.addUpdate("DELETE FROM schdlr_months WHERE id=?", new DBQuerySetup() {
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
			stat.setString(1, code);
		}
	}

	private class RecordUpdateSetup extends RecordCreationSetup {
		@Override
		public void setupPreparedStatement(final PreparedStatement stat) throws SQLException {
			super.setupPreparedStatement(stat);
			stat.setLong(2, id);
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
		final long id = transaction.addRecordCreation("INSERT INTO schdlr_months (code) VALUES (?)", new RecordCreationSetup());
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
		transaction.addUpdate("UPDATE schdlr_months SET code=? WHERE id=?", new RecordUpdateSetup());
		updateExtraDbActions(transaction);
	}

	protected void preUpdateExtraDbActions(final DBTransaction transaction) { }

	protected void updateExtraDbActions(final DBTransaction transaction) { }

	protected void postUpdateActions() { }

	private void updateCaching() {
		if (MONTH_PARAMETERS.USE_CACHE)
			MONTH_PARAMETERS.CACHE_SET.submit((Month) this);
	}

	public static List<Month> getAll() {
		return getAll(MONTH_PARAMETERS.getOrderByFields());
	}

	protected static List<Month> getAll(final String orderBy) {
		return getSelection(null, orderBy, null);
	}

	private static class GetSelectionQueryProcess implements DBQueryRetrieveData<List<Month>> {
		@Override
		public List<Month> processResultSet(final ResultSet rs) throws SQLException {
			final List<Month> list = new ArrayList<Month>();

			while (rs.next())
				list.add(new Month(rs.getLong(1), rs.getString(2)));


			return list;
		}
	}

	protected static List<Month> getSelection(final String whereClause) {
		return getSelection(whereClause, null);
	}

	protected static List<Month> getSelection(final String whereClause, final DBQuerySetup setup) {
		return getSelection(whereClause, MONTH_PARAMETERS.getOrderByFields(), setup);
	}

	protected static List<Month> getSelection(final String whereClause, final String orderBy, final DBQuerySetup setup) {
		if (whereClause == null && setup != null)
			throw new IllegalArgumentException("Cannot accept setup code without a WHERE clause.");

		final StringBuilder query = new StringBuilder();
		query.append("SELECT id, code FROM schdlr_months");
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
		final String query = "SELECT COUNT(id) FROM schdlr_months WHERE " + whereClause;

		if (setup == null)
			return dbAccess.processQuery(query, new GetSelectionCountQueryProcess());

		return dbAccess.processQuery(query, setup, new GetSelectionCountQueryProcess());
	}

	public static List<IdNamePair> getIdNamePairs(final List<String> dataFields, final List<String> orderingFields) {
		return getIdNamePairs(null, dataFields, orderingFields);
	}

	protected static List<IdNamePair> getIdNamePairs(final String whereClause, final List<String> dataFields, final List<String> orderingFields) {
		return DBQueries.getIdNamePairs(db, "schdlr_months", whereClause, dataFields, orderingFields);
	}

	public static long getCount() {
		return DBQueries.getLongCount(db, "schdlr_months");
	}

	public static boolean isIdOK(final long id) {
		return DBQueries.isIdOK(db, "schdlr_months", id);
	}

	public static boolean isIdOK(final long id, final DBTransaction transaction) {
		return DBQueries.isIdOK(transaction, "schdlr_months", id);
	}

	public static String getHumanReadableTitle(final long id) {
		if (id == 0)
			return "";

		return DBQueries.getHumanReadableTitle(db, "schdlr_months", id, MONTH_PARAMETERS.getNamingFields());
	}

	public static List<Month> getList(final ResultSet rs) throws SQLException {
		final List<Month> list = new ArrayList<Month>();

		while (rs.next())
			list.add(new Month(rs));


		return list;
	}

	@Override
	public void setLocale(final Locale locale) {
		monthInternals.setLocale(locale);
	}

}
