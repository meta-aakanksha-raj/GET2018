package shopping;

import java.util.GregorianCalendar;

public enum Promocode {
	PROMOCODE1("code1", new GregorianCalendar(2018, 5, 20),
			new GregorianCalendar(2018, 8, 20)), PROMOCODE2("code2",
			new GregorianCalendar(2018, 5, 25), new GregorianCalendar(2018, 6,
					2)), PROMOCODE3("code3", new GregorianCalendar(2018, 6, 5),
			new GregorianCalendar(2018, 6, 18)), PROMOCODE4("code4",
			new GregorianCalendar(2018, 6, 15), new GregorianCalendar(2018, 9,
					20));

	private String code;
	private GregorianCalendar startDate, endDate;

	/**
	 * This is constructor of enum
	 * @param code
	 * @param startDate
	 * @param endDate
	 */
	private Promocode(String code, GregorianCalendar startDate,
			GregorianCalendar endDate) {
		this.code = code;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the startDate
	 */
	public GregorianCalendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public GregorianCalendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}
}
