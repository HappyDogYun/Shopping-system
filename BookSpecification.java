package question;

public class BookSpecification implements Cloneable{
	public String isbn;
	public String title;
    public double price;
    public int type;
    public BookSpecification(String s1,String s2,double d,int t){
    	isbn=s1; title=s2; price=d; type=t;
    }
    public double getPrice(){
    	return price;
    }
    public String toString(){
    	return String.format("isbn:%-15stitle:%-20sprice:%-15stype:%-20s", isbn,title,price,type);
    }
    public Object clone(){
    	BookSpecification book = null;
		try {
			book = (BookSpecification)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    	return book;
    }
}
