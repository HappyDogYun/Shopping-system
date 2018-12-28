package question;

import java.util.ArrayList;

public class BookCatalog {
    public ArrayList<BookSpecification> books;
    public BookCatalog(){
    	books=new ArrayList<BookSpecification>();
    }
    public void add(BookSpecification a){
    	books.add(a);
    }
    public BookSpecification getBookSpecification(String s){
    	for(int i=0;i<books.size();i++){
    		if(s.equals(books.get(i).isbn)) return books.get(i);
    	}
    	return null;
    }
}
