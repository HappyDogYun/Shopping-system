package question;

public class PricingStrategyFactory{
    private static PricingStrategyFactory instance=null;
    public static synchronized PricingStrategyFactory getInstance(){
        if(instance==null){
               instance=new PricingStrategyFactory();
        }
        return instance;
    }
    private PricingStrategyFactory(){}
    
    private StrategyCatlog catlog=Globalvariable.stratelog;
    public IPricingStrategy getPricingStrategy(int bookType){
    	IPricingStrategy ips = null;
    	int flag=0;
    	for(int i:catlog.strategies.keySet()){
    		if(i==bookType) ips=(IPricingStrategy)catlog.strategies.get(i);
    		flag=1;
    	}
    	if(flag==0)ips=new NoDiscountStrategy();
    	return ips;
    }
    public void setCatlog(StrategyCatlog newcatlog){
    	catlog=newcatlog;
    }
}
