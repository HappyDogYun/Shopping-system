package question;
public class PercentageStrategy implements IPricingStrategy{
    private int discountPercentage;
    public String strategyNumber;
    public String getStrategyNumber(){return strategyNumber;}
    public int getStrategyType(){return strategyType;}
    public int strategyType=2;
    public PercentageStrategy(String Number,int discount){
    	discountPercentage=discount;
    	strategyNumber=Number;
    }
    public double getSubTotal(SaleLineItem item){
    	return (item.getPrice()*(1-discountPercentage*0.01))*item.getCopies();
    }
    public String getData(){
		return ""+discountPercentage;
	}
}
