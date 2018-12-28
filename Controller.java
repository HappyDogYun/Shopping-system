package question;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Controller {
    public static void addBook(String s1,String s2,double d,int i){
    	BookSpecification b = new BookSpecification(s1,s2,d,i);
    	Globalvariable.booklog.add(b);
    }
    public static void  addCompositeStrategy(String s1,int s3,String s4){
    	 CompositeStrategy co = new  CompositeStrategy(s1,s4);
    	 Globalvariable.stratelog.strategies.put(s3, co);
    }
    public static void  addSimpleStrategy(String s1,int s2,int s3,double s4){
    	switch(s2){
    	case 0:
    		 FlatRateStrategy f=new  FlatRateStrategy(s1,s4);
    		 Globalvariable.stratelog.strategies.put(s3, f);
    		 break;
    	case 1:
    		 PercentageStrategy p=new  PercentageStrategy(s1,(int) s4);
    		 Globalvariable.stratelog.strategies.put(s3, p);
    		break;
    	}
    }
    public static int deleteStrategy(String s){
    	int flag =0;
    	for(int i: Globalvariable.stratelog.strategies.keySet()){
    		if( Globalvariable.stratelog.strategies.get(i).getStrategyNumber().equals(s)){
    			 Globalvariable.stratelog.strategies.remove(i);
    			 flag =1;
    			 break;
    		}	
    	}
    	return flag;
    }
    public static void deleteStrategy1(String s){
    	//int flag =0;
    	for(int i: Globalvariable.stratelog.strategies.keySet()){
    		//如果是组合类型
            if(Globalvariable.stratelog.strategies.get(i).getStrategyType()==3) {
            	if(Globalvariable.stratelog.strategies.get(i).getData().indexOf(s)!=-1) {
            		String n = Globalvariable.stratelog.strategies.get(i).getStrategyNumber();
            		int start = Globalvariable.stratelog.strategies.get(i).getData().indexOf(s);
            		int end = Globalvariable.stratelog.strategies.get(i).getData().indexOf(s)+s.length();
            		String s1 ;
            		if(start == 0)
                           s1 = Globalvariable.stratelog.strategies.get(i).getData().substring(end+1);
            		else
            		{ 
            			String t2;
            			String t1 = Globalvariable.stratelog.strategies.get(i).getData().substring(0, start-1);
            			if(end!= Globalvariable.stratelog.strategies.get(i).getData().length())
            		       t2 = Globalvariable.stratelog.strategies.get(i).getData().substring(end+1);
            			else 
            				t2="";
            			s1 = t1+t2;
            		}
            		CompositeStrategy c = new CompositeStrategy(n,s1);
            		Globalvariable.stratelog.strategies.put(i, c);
            	}  	
            }
    	}
        //return flag;
    }
    public static int buyBook(String s1,int i, Sale sale){
    	int flag1 = 0;
    	int flag=0;
    	for( BookSpecification book : Globalvariable.booklog.books){
			if(s1.equals(book.isbn)){
				flag1 = 1;
				BookSpecification b = (BookSpecification)book.clone();
				for( SaleLineItem item:sale.items){
		    		if(s1.equals(item.getIsbn())){
		    			item.setCopies(item.getCopies()+i);
		    			flag=1;
		    			break;
		    		}   			
		    	}
				if(flag==0){
					 SaleLineItem newitem = new SaleLineItem(i,b);
	    		   	 sale.items.add(newitem);
				}
				break;
			}
    	}
    	
    	sale.notifyObservers();
    	return flag1;
    }

 }
