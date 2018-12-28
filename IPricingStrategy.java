package question;


public interface IPricingStrategy {
	public String getStrategyNumber();
	public int getStrategyType();
    public String getData();
	public double getSubTotal(SaleLineItem item);
}
