/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyConverter.controller;

import currencyConverter.model.Currency;
import currencyConverter.model.CurrencyDTO;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;


@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class EJBFacade {
    @PersistenceContext(unitName = "currencyConverterPU")
    private EntityManager em;
    
    public CurrencyDTO findRate(String currency){
        CurrencyDTO found = em.find(Currency.class, currency);
        if (found == null) {
            throw new EntityNotFoundException("No rate of currency: "+currency);
        }
        return found;
    }
    
    
    public CurrencyDTO findCurrency(int currencyNo) {
        CurrencyDTO found =  em.find(Currency.class, currencyNo);
        if (found == null) {
            throw new EntityNotFoundException("No account with number " + currencyNo);
        }
        return found;
    }
    
    CurrencyDTO createCurrency(double rate, String currency){
        Currency newCurrency = new Currency(rate, currency);
        em.persist(newCurrency);
        
        return newCurrency;
    }
}
