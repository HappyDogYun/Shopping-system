package question;

public class SaleLineItem {
    private int copies;
    private BookSpecification bookSpec;
    private IPricingStrategy strategy;
    public SaleLineItem(int c,BookSpecification b){
    	copies=c;
    	bookSpec=b;
    	if(Globalvariable.stratelog.strategies.containsKey(bookSpec.type))strategy=Globalvariable.stratelog.strategies.get(bookSpec.type);
    	else strategy=new NoDiscountStrategy();
    }
    public void setCopies(int c){copies=c;}
    public int getCopies(){return copies;}
    public String getTitle(){return bookSpec.title;}
    public String getIsbn(){return bookSpec.isbn;}
    public double getPrice(){return bookSpec.price;}
    public double getSubTotal(){
    	return strategy.getSubTotal(this);
    }
}
