package question;
import java.util.ArrayList;

public class Sale implements Subject{
	public ArrayList<SaleLineItem> items = new ArrayList<SaleLineItem>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	public void removeObserver(Observer o){
		observers.remove(o);
	}
    public void registerObserver(Observer o){
    	observers.add(o);
    }
    public void notifyObservers(){
    	for(Observer o:observers) o.update(this);
    }
    public double getTotal(){
    	double total=0;
    	for(SaleLineItem item:items){
    		total=total+item.getSubTotal();
    	}
    	return total;
    }
    
}