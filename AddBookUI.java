package question;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;;

public class AddBookUI extends JDialog{
    public AddBookUI(JFrame jframe,String title){
    	super(jframe,title,true);
    	AddBookUI jd = this;
    	this.setBounds(100, 100, 500, 350);
    	Container container = this.getContentPane();  	
        container.setLayout(new FlowLayout(1,10,10));
        container.setBackground(new Color(80,80,80));
        
        JPanel p1=new JPanel(new GridLayout(3,2,10,10));
        p1.setBackground(new Color(80,80,80));
        JPanel p2=new JPanel(new GridLayout(1,2,10,10));
        p2.setBackground(new Color(80,80,80));
        JPanel p3=new JPanel(new GridLayout(3,1,10,10));
        p3.setBackground(new Color(80,80,80));        
        JPanel p4=new JPanel(new GridLayout(5,1,10,10));
        p4.setBackground(new Color(80,80,80));
        
        JLabel jl1=new JLabel("编号:",JLabel.CENTER);
        jl1.setFont(new Font("黑体", Font.BOLD, 15));
        jl1.setForeground(new Color(255,255,255));
        JLabel jl2=new JLabel("题目:",JLabel.CENTER);
        jl2.setFont(new Font("黑体", Font.BOLD, 15));
        jl2.setForeground(new Color(255,255,255));
        JLabel jl3=new JLabel("价格:",JLabel.CENTER);
        jl3.setFont(new Font("黑体", Font.BOLD, 15));
        jl3.setForeground(new Color(255,255,255));
        JLabel jl4=new JLabel("类型:",JLabel.CENTER);
        jl4.setFont(new Font("黑体", Font.BOLD, 15));
        jl4.setForeground(new Color(255,255,255));
    	
        JTextField jt1=new JTextField(15);
    	JTextField jt2=new JTextField();
    	JTextField jt3=new JTextField();
    	
    	JRadioButton jr1=new JRadioButton("1.非教材类计算机图书");
    	JRadioButton jr2=new JRadioButton("2.教材类图书");
    	JRadioButton jr3=new JRadioButton("3.连环画类图书");
    	JRadioButton jr4=new JRadioButton("4.养生类图书");
    	JRadioButton jr5=new JRadioButton("5.其他");
    	
    	ButtonGroup group=new ButtonGroup();
    	
    	group.add(jr1);group.add(jr2);group.add(jr3);
    	group.add(jr4);group.add(jr5);
    	
    	JButton jb=new JButton("添加");
    	jb.setFont(new Font("黑体", Font.BOLD, 15));
    	jb.setBackground(new Color(80,80,80));//设置按钮背景颜色
    	jb.setForeground(new Color(255,255,255));//设置按钮字体颜色
    	jb.setFocusPainted(false);
    	JButton jb1 = new JButton("重置");
    	jb1.setFont(new Font("黑体", Font.BOLD, 15));
    	jb1.setBackground(new Color(80,80,80));//设置按钮背景颜色
    	jb1.setForeground(new Color(255,255,255));//设置按钮字体颜色
    	jb1.setFocusPainted(false);
    	
    	p1.add(jl1);p1.add(jt1);
    	p1.add(jl2);p1.add(jt2);
    	p1.add(jl3);p1.add(jt3);
    	p3.add(jl4);p4.add(jr1);
    	p4.add(jr2);p4.add(jr3);
    	p4.add(jr4);p4.add(jr5);
    	p2.add(p3);p2.add(p4);
    	
    	container.add(p1);
    	container.add(p2);
    	container.add(jb);
    	container.add(jb1);
    	
    	jb.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(jt1.getText().isEmpty()||jt2.getText().isEmpty()||jt3.getText().isEmpty()||
    					(!jr1.isSelected()&&!jr2.isSelected()&&!jr3.isSelected()&&!jr4.isSelected()&&!jr5.isSelected())) 
    			{
    				JOptionPane.showMessageDialog(null,"请输入完整的信息！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			}else {
    			int typenumber=0;
    			if(jr1.isSelected())typenumber=1;
    			else if(jr2.isSelected())typenumber=2;
    			else if(jr3.isSelected())typenumber=3;
    			else if(jr4.isSelected())typenumber=4;
    			else if(jr5.isSelected())typenumber=5;
    			jd.dispose();
    			Controller.addBook(jt1.getText(),jt2.getText(),Double.parseDouble(jt3.getText()),typenumber);
    			JOptionPane.showMessageDialog(null,"添加成功！","提示消息",JOptionPane.WARNING_MESSAGE); 
    			
    			}
    		}
    	});
    	jb1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    		   jt1.setText("");
    		   jt2.setText("");
    		   jt3.setText("");
    		}
    	});
    }
}
