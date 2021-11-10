package com.stockmarket.stockpro.Repository;

// import java.math.BigInteger;
// import java.util.ArrayList;
import java.util.List;
// import java.util.Set;
// import org.hibernate.type.LongType;
// import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// import com.fasterxml.jackson.databind.util.JSONPObject;
import com.stockmarket.stockpro.Entities.Company;
import com.stockmarket.stockpro.Entities.CompanyStockExchangeMap;
import com.stockmarket.stockpro.Entities.StockExchange;

import javax.persistence.EntityManager;
// import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
// import javax.persistence.*;
import javax.transaction.Transactional;

// import org.hibernate.type.LongType;
// import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class CompanyStockExchangeMapRepository2 {
    @Autowired
    CompanyStockExchangeMapRepository cstkmaprep;
    @Autowired
    CompanyRepository cmprep;
    @Autowired
    StockExchangeRepository stkrep;

    @PersistenceContext
    EntityManager entityManager;

    // public Object[] retlist(String cmpname,String exchangename, String compcode
    // ){
    public void retlist(String cmpname, String exchangename, String compcode) {

        Company c = new Company();
        StockExchange se = new StockExchange();
        Query q1 = entityManager.createQuery(" select c from Company c where c.Name  =:name", Company.class);
        q1.setParameter("name", cmpname);

        // System.out.println(cmpname + exchangename +"params in retlist");
        System.out.println(exchangename + "exchange params in retlist");

        c = (Company) q1.getSingleResult();// returns
        System.out.println("Look here array" + c.getId());

        // return x;

        Query q2 = entityManager.createQuery(" select c from Stockexchange c where c.Name  =:name", StockExchange.class);
        q2.setParameter("name", exchangename);

        se = (StockExchange) q2.getSingleResult();
        System.out.println("Look here array" + c.getClass().getTypeName());

        CompanyStockExchangeMap csmap = new CompanyStockExchangeMap();
        csmap.setCompany(c);
        csmap.setStockexchange(se);
        csmap.setCompanyCode(compcode);
        entityManager.persist(csmap);

    }

    public String readlist(String companyid) {

        /*
         * 
         * Query q1 = entityManager.
         * createQuery(" select c from Companystockexchangemap csmap where csmap.company  =:companyid"
         * , Companystockexchangemap.class); q1.setParameter("companyid", companyid);
         * Companystockexchangemap cstkmap = new Companystockexchangemap();
         * Stockexchange exch = new Stockexchange();
         * 
         * cstkmap =(Companystockexchangemap) q1.getSingleResult();
         * 
         * Query q2 = entityManager.
         * createQuery(" select c from Stockexchange exch where exch.id  =:stockexchangeid"
         * , Stockexchange.class); q2.setParameter("stockexchangeid",
         * cstkmap.getStockexchange());
         * 
         * 
         * 
         * 
         * exch=(Stockexchange) q2.getSingleResult();
         * 
         * 
         * 
         * Query q3 = entityManager.
         * createQuery(" select c from Company cmp where cmp.id  =:companyid",
         * Company.class); q3.setParameter("stockexchangeid",
         * cstkmap.getStockexchange()); Company cc = new Company(); cc=(Company)
         * q3.getSingleResult();
         * 
         * 
         * companycodes = exch.getName() +":"+ cstkmap.getCompanyCode() +":" +
         * cc.getName(); return companycodes;
         */
        String companycodes = " ";
        Query q1 = entityManager.createNativeQuery(
                "select  distinct cmp.name as n1, exch.name as n2  ,cmpexch.Company_Code as n3 from company cmp  , STOCK_EXCHANGE exch , \r\n"
                        + "	    			company_stockexchangemap  cmpexch  where cmp.id =:companyid  and  exch.id in \r\n"
                        + "	    			(select  a.stockexchange_ID from company_stockexchangemap a  where a.company_id =:companyid)");

        q1.setParameter("companyid", companyid);

        String x = "";

        @SuppressWarnings("unchecked")
        List<Object[]> results = q1.getResultList();
        // Object[] result = results.get(0);
        System.out.println(results);
        for (Object[] r : results) {
            companycodes = companycodes + "\\r\\n" + r[0] + "checkout" + r[1] + r[2];
            x = "{\"name\": \"" + r[0] + "\", \"exchange\": \"" + r[1] + "\",\"Companybcode\":\"" + r[2] + "\"}";

            System.out.println(r[0] + "checkout" + r[1] + r[2]);
        }

        return x;

    }

}
