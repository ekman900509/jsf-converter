/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyConverter.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Currency implements CurrencyDTO, Serializable {

    private static final long serialVersionUID = 16247164401L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String currency;
    private double rate;
    private double resultt;

    
    public Currency(){
        
    }
    
    public Currency(double rate, String currency){
        this.rate = rate;
        this.currency = currency;
    }
    
    @Override
    public double getRate(){
        return rate;
    }
    
    @Override
    public String getCurrency(){
        return currency;
    }
    
    @Override
    public void setResultt(double resultt){
        this.resultt = resultt;
    }
    
    @Override
    public double getResultt(){
        return resultt;
    }
/*
    public void setCurrencyNo(Integer currencyNo) {
        this.currencyNo = currencyNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return new Integer(currencyNo).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        return this.currencyNo == other.currencyNo;
    }

    @Override
    public String toString() {
        return "currencyConverter.model.Currency[ id=" + currencyNo + " ]";
    }
*/
    
}
