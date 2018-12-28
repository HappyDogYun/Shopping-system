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
    	
    	JButton jb1=new JButton("����ͼ��");
    	jb1.setFont(new Font("����", Font.BOLD, 40));
    	jb1.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb1.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb1.setFocusPainted(false);
    	
    	JButton jb2=new JButton("����ͼ��");
    	jb2.setFont(new Font("����", Font.BOLD, 40));
    	jb2.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb2.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb1.setFocusPainted(false);
    	
    	JButton jb3=new JButton("���Ե���");
    	jb3.setFont(new Font("����", Font.BOLD, 40));
    	jb3.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb3.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	
    	container.add(jb1);
    	container.add(jb2);
    	container.add(jb3);
    	
    	jf.setVisible(true);
    	jb1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			BuyUI b = new BuyUI(jf,"����ͼ��");
    			b.setVisible(true);
    		}
    	});
    	jb2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			AddBookUI a=new AddBookUI(jf, "����ͼ��");
    			a.setVisible(true);
    		}
    	});
    	jb3.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			StrategiesUI jd=new StrategiesUI(jf,"���Ե���");
    			jd.setVisible(true);
    		}
    	});
    }
	public static void main(String[] args) {
		Controller.addBook("001", "UML��ģʽӦ��", 18, 2);
		Controller.addBook("002", "Java��ģʽ", 34, 1);
		Controller.addBook("003", "HeadFirst���ģʽ", 58, 1);
		Controller.addBook("004", "����˿���ռ�", 30, 3);
		Controller.addBook("005", "������ȫ", 20, 4);
		
		Controller.addSimpleStrategy("Discount001", 0, 2, 1);
		Controller.addSimpleStrategy("Discount002", 1, 3, 7);
		Controller.addSimpleStrategy("Discount003", 1, 1, 3);
		Controller.addCompositeStrategy("Discount004", 4, "Discount001&Discount003");
		
		MainUI test = new MainUI();
		test.CreateJFrame("��ҳ��");
	}

}
