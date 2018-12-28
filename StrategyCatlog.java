package question;
import java.util.HashMap;

public class StrategyCatlog {
    public HashMap<Integer,IPricingStrategy> strategies;
    public StrategyCatlog(){
    	strategies=new HashMap<Integer,IPricingStrategy>();
    }
}
