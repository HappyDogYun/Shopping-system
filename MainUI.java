package question;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainUI extends JFrame{
	
	public static ShoppingCarUI car = new ShoppingCarUI();
    
	public void CreateJFrame(String title){
    	JFrame jf = new JFrame(title);
    	jf.setBounds(700, 200, 400, 500);
    	Container container=jf.getContentPane();
    	container.setLayout((new GridLayout(3,1)));
    	
    	JButton jb1=new JButton("购买图书");
    	jb1.setFont(new Font("黑体", Font.BOLD, 40));
    	jb1.setBackground(new Color(80,80,80));//设置按钮背景颜色
    	jb1.setForeground(new Color(255,255,255));//设置按钮字体颜色
    	jb1.setFocusPainted(false);
    	
    	JButton jb2=new JButton("增加图书");
    	jb2.setFont(new Font("黑体", Font.BOLD, 40));
    	jb2.setBackground(new Color(80,80,80));//设置按钮背景颜色
    	jb2.setForeground(new Color(255,255,255));//设置按钮字体颜色
    	jb1.setFocusPainted(false);
    	
    	JButton jb3=new JButton("策略调整");
    	jb3.setFont(new Font("黑体", Font.BOLD, 40));
    	jb3.setBackground(new Color(80,80,80));//设置按钮背景颜色
    	jb3.setForeground(new Color(255,255,255));//设置按钮字体颜色
    	
    	container.add(jb1);
    	container.add(jb2);
    	container.add(jb3);
    	
    	jf.setVisible(true);
    	jb1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			BuyUI b = new BuyUI(jf,"购买图书");
    			b.setVisible(true);
    		}
    	});
    	jb2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			AddBookUI a=new AddBookUI(jf, "增加图书");
    			a.setVisible(true);
    		}
    	});
    	jb3.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			StrategiesUI jd=new StrategiesUI(jf,"策略调整");
    			jd.setVisible(true);
    		}
    	});
    }
	public static void main(String[] args) {
		Controller.addBook("001", "UML与模式应用", 18, 2);
		Controller.addBook("002", "Java与模式", 34, 1);
		Controller.addBook("003", "HeadFirst设计模式", 58, 1);
		Controller.addBook("004", "爱丽丝历险记", 30, 3);
		Controller.addBook("005", "煲汤大全", 20, 4);
		
		Controller.addSimpleStrategy("Discount001", 0, 2, 1);
		Controller.addSimpleStrategy("Discount002", 1, 3, 7);
		Controller.addSimpleStrategy("Discount003", 1, 1, 3);
		Controller.addCompositeStrategy("Discount004", 4, "Discount001&Discount003");
		
		MainUI test = new MainUI();
		test.CreateJFrame("主页面");
	}

}
