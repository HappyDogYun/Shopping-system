package question;

public class NoDiscountStrategy implements IPricingStrategy{
	public String strategyNumber;
	public int strategyType=0;
	public String getData(){return "0";}
	public int getStrategyType(){return strategyType;}
	public String getStrategyNumber(){return strategyNumber;}
    public double getSubTotal(SaleLineItem item){
    	return item.getPrice()*item.getCopies();
    }
}