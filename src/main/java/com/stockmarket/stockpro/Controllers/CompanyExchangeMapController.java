package com.stockmarket.stockpro.Controllers;

// import java.net.URI;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

import com.stockmarket.stockpro.Repository.CompanyRepository;
import com.stockmarket.stockpro.Repository.CompanyStockExchangeMapRepository;
import com.stockmarket.stockpro.Repository.CompanyStockExchangeMapRepository2;
import com.stockmarket.stockpro.Repository.StockExchangeRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Import;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.CrossOrigin;
@RestController
public class CompanyExchangeMapController  {
	@Autowired
	 CompanyStockExchangeMapRepository cstkmaprep;
	@Autowired
	CompanyRepository cmprep;
	@Autowired
	CompanyStockExchangeMapRepository2 cstmap;
	
	StockExchangeRepository stkrep;
	@RequestMapping(value="/mapcompanycode/{companyname}/{exchangename}/{companycode}", method=RequestMethod.POST)
    public String mapcode(@PathVariable String companyname,@PathVariable String exchangename ,@PathVariable String companycode) {

	  System.out.println(companyname +"params in rest controller before retlist call");
	  cstmap.retlist(companyname, exchangename, companycode);
	  
	 
	  
	 return  companyname ;
		//return companyname;
	}
	

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value="/getcompanycode/{companyid}", method=RequestMethod.GET)
	public String getcode(@PathVariable String companyid) {
     
        
		return  cstmap.readlist(companyid);

	}

}
