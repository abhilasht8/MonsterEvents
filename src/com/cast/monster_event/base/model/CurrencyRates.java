package com.cast.monster_event.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CURRENCY_RATES")
public class CurrencyRates {
	@Id
	@Column(name="country")
	private String country;
	
	@Column(name="exchange_rate")
	private double exchangeRate;

}
