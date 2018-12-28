package question;

public class FlatRateStrategy implements IPricingStrategy{
    private double discountPerBook;
    public String strategyNumber;
    public int getStrategyType(){return strategyType;}
    public String getStrategyNumber(){return strategyNumber;}
    public int strategyType=1;
    public FlatRateStrategy(String Number,double discount){
    	discountPerBook=discount;
    	strategyNumber=Number;
    }
    public double getSubTotal(SaleLineItem item){
    	return (item.getPrice()-discountPerBook)*item.getCopies();
    }
    public String getData(){
		return ""+discountPerBook;
	}
}
