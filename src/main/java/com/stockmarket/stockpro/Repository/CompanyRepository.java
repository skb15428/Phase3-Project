package com.stockmarket.stockpro.Repository;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import com.stockmarket.stockpro.Entities.Company;
import com.stockmarket.stockpro.Entities.StockExchange;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
// import javax.persistence.TypedQuery;
// import javax.transaction.Transactional;

// import org.apache.catalina.Store;
// import org.springframework.stereotype.Repository;

// import com.stockexchange.phase3.*;

// import javassist.bytecode.SignatureAttribute.BaseType;

// import org.springframework.data.repository.CrudRepository;
@Repository
@Transactional
public class CompanyRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Company savecompany(String Name) {
        Company cmp = new Company(Name);
        entityManager.persist(cmp);
        return cmp;
    }

    public Company findcompany(Company c) {
        Company cmp = new Company();
        cmp = entityManager.find(Company.class, c);
        return cmp;
    }

    public List<Company> findcompanylist(String s) {
        Query q1 = entityManager.createQuery(" select c from Company c where c.Name like :searchKeyword",
                Company.class);

        q1.setParameter("searchKeyword", "%" + s + "%");

        @SuppressWarnings("unchecked")
        List<Company> companyList = (List<Company>)q1.getResultList();
        return companyList;

    }

    public StockExchange findexchange(StockExchange stockExchange) {
        StockExchange cmp = new StockExchange();
        cmp = entityManager.find(StockExchange.class, stockExchange);
        return cmp;
    }

}
