package com.acc.wrapper;

public class DateIdWrapper {

	private int dateId;


	public DateIdWrapper(int dateId) {
        super();
        this.dateId = dateId;
    }

    public DateIdWrapper() {
        super();

    }

	public int getDateId() {
		return dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}



	@Override
	public String toString() {
		return "DateIdWrapper [dateId=" + dateId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dateId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateIdWrapper other = (DateIdWrapper) obj;
		if (dateId != other.dateId)
			return false;
		return true;
	}



}
