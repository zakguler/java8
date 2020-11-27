package com.java.common_DATA;

import java.util.Objects;

public class Z_Transaction {

	private String referenceCode;
	private int year;
	private int value;

	public Z_Transaction(String referenceCode, int year, int value) {
		this.referenceCode = referenceCode;
		this.year = year;
		this.value = value;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = hash * 31 + (referenceCode == null ? 0 : referenceCode.hashCode());
		hash = hash * 31 + year;
		hash = hash * 31 + value;
		return hash;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Z_Transaction)) {
			return false;
		}
		Z_Transaction o = (Z_Transaction) other;
		boolean eq = Objects.equals(referenceCode, o.getReferenceCode());
		eq = eq && year == o.getYear();
		eq = eq && value == o.getValue();
		return eq;
	}

	@SuppressWarnings("boxing")
	@Override
	public String toString() {
		return String.format("{%s, year: %d, value: %d}", referenceCode, year, value);
	}

}
