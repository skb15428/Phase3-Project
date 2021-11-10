package com.stockmarket.stockpro.Entities;

// import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CompanyStockexchangemap")
public class CompanyStockExchangeMap {
	public CompanyStockExchangeMap() {
		super();
	}

	@Id
	@GeneratedValue
	private long id;
	public String getCompanyCode() {
		return CompanyCode;
	}

	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}

	private String CompanyCode;
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	@ManyToOne(fetch = FetchType.LAZY)
	private StockExchange stockexchange;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public StockExchange getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(StockExchange stockexchange) {
		this.stockexchange = stockexchange;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

