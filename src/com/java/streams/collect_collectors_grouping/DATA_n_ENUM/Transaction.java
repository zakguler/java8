package com.java.streams.collect_collectors_grouping.DATA_n_ENUM;


public class Transaction {
	
	public enum Currency {
		EUR, USD, JPY, GBP, CHF
	}


    private final Currency currency;
    private final double value;

    public Transaction(Currency currency, double value) {
      this.currency = currency;
      this.value = value;
    }

    public Currency getCurrency() {
      return currency;
    }

    public double getValue() {
      return value;
    }

    @Override
    public String toString() {
      return currency + " " + value;
    }

  }


