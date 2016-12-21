/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyConverter.model;


public interface CurrencyDTO {
    
    /**
     *
     * @return
     */
    
    double getRate();
    
    String getCurrency();
    
    void setResultt(double resultt);
    
    double getResultt();
}
