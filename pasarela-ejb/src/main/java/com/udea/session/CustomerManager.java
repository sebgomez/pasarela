/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Customer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sebastián
 */
@Stateless
public class CustomerManager implements CustomerManagerLocal {

    @PersistenceContext(unitName = "com.udea_pasarela-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    
    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    @Override
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

}
