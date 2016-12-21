package currencyConverter.view;

import currencyConverter.controller.EJBFacade;
import currencyConverter.model.CurrencyDTO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("currencyManager")
@ConversationScoped
public class CurrencyManager implements Serializable{
    
    private static final long serialVersionUID = 16247164405L;
    @EJB
    private EJBFacade ejbFacade;

    //private CurrencyDTO currentCurrencies;
    private CurrencyDTO fromm;
    private Exception transactionFailure;
    private String currencyFrom;
    private String currencyTo;
    private Integer value;
    private double result;
    @Inject
    private Conversation conversation;
      
    
    
    private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    private void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    private void handleException(Exception e) {
        stopConversation();
        e.printStackTrace(System.err);
        transactionFailure = e;
    }
    
    
    public String convert(){
        try{
            fromm = ejbFacade.findRate(currencyFrom);
            CurrencyDTO too = ejbFacade.findRate(currencyTo);
            double rate_from = fromm.getRate();
            double rate_to = too.getRate();
            
            result = (rate_from/rate_to * value);
            fromm.setResultt(result);
            
        }catch(Exception e){
            handleException(e);
        }
        return jsf22Bugfix();
    }
    
 /*   
    public String findCurrency(){
        try{
            startConversation();
            transactionFailure = null;
            currentCurrencies = ejbFacade.findCurrency(searchCurrencies);
        } catch (Exception e){
            handleException(e);
        }
        return jsf22Bugfix();
    }
    */
    /**
     * This return value is needed because of a JSF 2.2 bug. Note 3 on page 7-10
     * of the JSF 2.2 specification states that action handling methods may be
     * void. In JSF 2.2, however, a void action handling method plus an
     * if-element that evaluates to true in the faces-config navigation case
     * causes an exception.
     *
     * @return an empty string.
     */
    private String jsf22Bugfix() {
        return "";
    }
    
    
    public void setCurrencyFrom(String currencyFrom){
        this.currencyFrom = currencyFrom;
    }
    
    public String getCurrencyFrom(){
        return null;
    }
    
    public void setCurrencyTo(String currencyTo){
        this.currencyTo = currencyTo;
    }
    
    public String getCurrencyTo(){
        return null;
    }
    
    public void setValue(Integer value){
        this.value = value;
    }
    
    public Integer getValue(){
        return null;
    }
    
    public void setResult(double result){
        this.result = result;
    }
    
    public double getResult(){
        return result;
    }
    
   /* 
    
    public void setSearchCurrencies(Integer searchCurrencies){
        this.searchCurrencies = searchCurrencies;
    }
    
    public Integer getSearchCurrencies(){
        return null;
    }
    */
    
    public CurrencyDTO getFromm(){
        return fromm;
    }


    
 
}
