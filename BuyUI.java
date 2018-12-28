package question;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BuyUI extends JDialog{
	public BuyUI(JFrame jframe,String title){
    	super(jframe,title);
    	BuyUI bu = this;
    	Container container = this.getContentPane();
    	container.setBackground(new Color(80,80,80));
    	this.setBounds(50, 50, 500, 300);
    	container.setLayout(new GridLayout(2,1,10,10));
   
    	DefaultTableModel tablemodel =new DefaultTableModel();
    	
    	JTable jt = new JTable(tablemodel);
    	//jt.setFont(new Font("黑体", Font.BOLD, 12));
    	jt.setBackground(new Color(80,80,80));//设置背景颜色
    	jt.setForeground(new java.awt.Color(255, 255, 255));//设置字体颜色，但标题不会改变
    	jt.setSelectionBackground(new java.awt.Color(255,255,255));//设置选择行的颜色
    	jt.getTableHeader().setBackground(new Color(80,80,80));  
    	jt.getTableHeader().setFont(new Font("黑体", Font.BOLD, 15));
    	jt.getTableHeader().setForeground(new Color(255,255,255));
    	
    	JScrollPane js = new JScrollPane(jt);
    	js.setBackground(new Color(80,80,80));//设置背景颜色
    	tablemodel.addColumn("编号");
    	tablemodel.addColumn("题目");
    	tablemodel.addColumn("价格");
    	tablemodel.addColumn("类型");
    	
    	for(BookSpecification b :Globalvariable.booklog.books){
    		String[] s={b.isbn,b.title,String.valueOf(b.price),String.valueOf(b.type)};
    		tablemodel.addRow(s);
    	}
    	container.add(js);
        
    	JPanel jp= new JPanel(new GridLayout(1,2,10,10));
        JPanel jp1=new JPanel(new GridLayout(3,1,20,20));
        JPanel jp11=new JPanel(new GridLayout(1,3,10,10));
        JPanel jp12=new JPanel(new GridLayout(1,3,10,10));
        
        JLabel jl1=new JLabel("编号:",JLabel.CENTER);
        jl1.setFont(new Font("黑体", Font.BOLD, 25));
        jl1.setForeground(new Color(255,255,255));
        
        JLabel jl2=new JLabel("数量:",JLabel.CENTER);
        jl2.setFont(new Font("黑体", Font.BOLD, 25));
        jl2.setForeground(new Color(255,255,255));
        
        JLabel jl3=new JLabel("本",JLabel.CENTER);
        jl3.setFont(new Font("黑体", Font.BOLD, 25));
        jl3.setForeground(new Color(255,255,255));
        
        JTextField jt1=new JTextField();
        JTextField jt2=new JTextField();
        
        JButton jb=new JButton("加入购物车");
        jb.setFont(new Font("黑体", Font.BOLD, 20));
    	jb.setBackground(new Color(80,80,80));//设置按钮背景颜色
    	jb.setForeground(new Color(255,255,255));//设置按钮字体颜色
    	jb.setFocusPainted(false);
    	
    	JButton jb1=new JButton("支付");
        jb1.setFont(new Font("黑体", Font.BOLD, 20));
    	jb1.setBackground(new Color(80,80,80));//设置按钮背景颜色
    	jb1.setForeground(new Color(255,255,255));//设置按钮字体颜色
    	jb1.setFocusPainted(false);
    	
    	
    	
        jp11.add(jl1);jp11.add(jt1);//jp11.add(new Label(""));
        jp11.setBackground(new Color(80,80,80));
        
        jp12.add(jl2);jp12.add(jt2);jp12.add(jl3);
        jp12.setBackground(new Color(80,80,80));
        
        jp1.add(jp11);jp1.add(jp12);jp1.add(jb);jp1.add(jb1);
        jp1.setBackground(new Color(80,80,80));
        jp.add(jp1);
        
        container.add(jp);
        container.setBackground(new Color(80,80,80));//设置背景颜色
        Sale sale = new Sale();		
    	//sale.registerObserver(car);
		
        jb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(jt1.getText().isEmpty()||jt2.getText().isEmpty()){
        			JOptionPane.showMessageDialog(null,"输入错误，请重试！","提示消息",JOptionPane.WARNING_MESSAGE);
        		}
        		else{
        			if(Controller.buyBook(jt1.getText(),Integer.parseInt(jt2.getText()),sale) == 0 ){
        				JOptionPane.showMessageDialog(null,"没有此图书！","提示消息",JOptionPane.WARNING_MESSAGE);
        			}
        			else{
        				ShoppingCarUI car = new ShoppingCarUI();
               			car.update(sale);    	
        			}		            
        		}
        	}
        });
        
        jb1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		bu.dispose();
        		JOptionPane.showMessageDialog(null,"付款成功，我们将尽快为你安排发货！","提示消息",JOptionPane.WARNING_MESSAGE);
        	}
        });
	}
}
