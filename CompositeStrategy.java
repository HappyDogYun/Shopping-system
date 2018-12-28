package question;
import java.util.ArrayList;

public class CompositeStrategy implements IPricingStrategy{	
	public ArrayList<IPricingStrategy> strategies;  //策略组合
	public String strategyNumber;                   //策略编号
	public String getStrategyNumber(){return strategyNumber;}
	public int getStrategyType(){return strategyType;} //策略类型，组合类型
	public int strategyType=3;
	public String data;
	public CompositeStrategy(String Number,String s){
		strategies=new ArrayList<IPricingStrategy>();
	    strategyNumber=Number;
	    data=s;
	    String[] list=s.split("\\&");
	    for(int i=0;i<list.length;i++){
	    	for(IPricingStrategy ips:Globalvariable.stratelog.strategies.values()){
	    		if(ips.getStrategyNumber().equals(list[i])){
	    			strategies.add(ips);break;
	    		}
	    	}
	    }
	}
	public double getSubTotal(SaleLineItem item){
		double sum=strategies.get(0).getSubTotal(item);
		for(IPricingStrategy ips:strategies){
			ips.getSubTotal(item);
			if(sum>ips.getSubTotal(item)) sum=ips.getSubTotal(item);
		}
		return sum;
	}
	public String getData(){
		return ""+data;
    }
}