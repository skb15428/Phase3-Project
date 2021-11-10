package com.stockmarket.stockpro.Entities;

// import java.time.LocalDateTime;
// import java.util.List;

import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.OneToMany;
// import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StockExchange")
public class StockExchange {
	public StockExchange() {
		super();
	}

	@Id
	@GeneratedValue
	private long id;
	private String Name;
	// @OneToMany(targetEntity = Companystockexchangemap.class)
	// private List<Companystockexchangemap> compstockmap;

	// public List<Companystockexchangemap> getCompstockmap() {
	// 	return compstockmap;
	// }

	// public void setCompstockmap(List<Companystockexchangemap> compstockmap) {
	// 	this.compstockmap = compstockmap;
	// }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

}
