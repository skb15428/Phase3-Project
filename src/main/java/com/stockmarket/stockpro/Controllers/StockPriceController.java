package com.stockmarket.stockpro.Controllers;

import java.io.IOException;
import java.net.URI;
// import java.util.HashMap;
import java.util.List;
// import java.util.Map;
// import java.util.Map.Entry;
// import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.stockmarket.stockpro.Entities.StockPrice;
import com.stockmarket.stockpro.Repository.StockPriceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StockPriceController {
    @Autowired
    StockPriceRepository stkpricerepo;
    /*
     * { "exchangename": "bse", "companycode": "TCS",
     * 
     * "datee ": "2014-01-01T23:28:56.782Z", "timee" :"10:20:00" } expected json
     * format
     */

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/addstockprices", method = RequestMethod.POST, headers = "Accept=application/json")

    public ResponseEntity<Object> stockpriceapi(@RequestBody StockPrice stockprice)
            throws AddressException, MessagingException, ClassNotFoundException, IOException {

        StockPrice stkprice = stkpricerepo.save(stockprice);
        // make sure your entity class properties of user are in lower case and match
        // the json,to avoid errors
        System.out.println(stkprice + "check this " + stkprice.getCompanycode());

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(stkprice.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/getstockprices", method = RequestMethod.GET, headers = "Accept=application/json")

    public List<StockPrice> getstockprice()
            throws AddressException, MessagingException, ClassNotFoundException, IOException {

        List<StockPrice> stkprice = stkpricerepo.findAll();
        // make sure your entity class properties of user are in lower case and match
        // the json,to avoid errors
        return stkprice;
    }
}
