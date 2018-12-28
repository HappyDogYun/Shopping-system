package question;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;  
public class ShoppingCarUI implements Observer{
	public JFrame jf = new JFrame("购物车");
	public void update(Sale sale){
    	jf.setBounds(300, 100, 300, 200);
    	//jf.setLayout(new GridLayout(3,1));
    	JPanel jp = new JPanel();
    	jp.setBackground(new Color(80,80,80));
    	
    	BoxLayout bl = new BoxLayout(jp,BoxLayout.Y_AXIS);
    	jp.setLayout(bl);
    	DefaultTableModel tablemodel = new DefaultTableModel();
    	
    	JTable jt=new JTable(tablemodel);
    	jt.setBackground(new Color(80,80,80));
    	jt.setFont(new Font("黑体", Font.BOLD, 15));
    	jt.setForeground(new java.awt.Color(255, 255, 255));//设置字体颜色，但标题不会改变
    	jt.setSelectionBackground(new java.awt.Color(255,255,255));//设置选择行的颜色
    	jt.getTableHeader().setBackground(new Color(80,80,80));  
    	jt.getTableHeader().setFont(new Font("黑体", Font.BOLD, 15));
    	jt.getTableHeader().setForeground(new Color(255,255,255));
    	
    	JScrollPane js = new JScrollPane(jt);
    	js.setBackground(new Color(80,80,80));
    	
    	tablemodel.addColumn("书名");
    	tablemodel.addColumn("数量");
    	for(SaleLineItem items :sale.items){
    		String[] s={items.getTitle(),String.valueOf(items.getCopies())};
    		tablemodel.addRow(s);
    	}
    //	jp.add(new JLabel("购物车"));
    	jp.add(js);
    	//jp.add(new JLabel("总价:"+String.format("%.1f", sale.getTotal())+"元",JLabel.RIGHT));
    	DecimalFormat    df   = new DecimalFormat("######0.00");   
    	JLabel Jl1 = new JLabel("图书总价:   "+df.format(sale.getTotal())+"元",JLabel.CENTER);
    	Jl1.setFont(new Font("黑体", Font.BOLD, 20));
    	Jl1.setForeground(new Color(255,255,255));
    	jp.add(Jl1);
    	jf.add(jp);
    	jf.setVisible(true);
//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	JButton jb=new JButton("确认付款");
//        jb.setFont(new Font("黑体", Font.BOLD, 20));
//     	jb.setBackground(new Color(80,80,80));//设置按钮背景颜色
//     	jb.setForeground(new Color(255,255,255));//设置按钮字体颜色
//     	jb.setFocusPainted(false);
//     	jf.add(jb);
//     	
//    	jb.addActionListener(new ActionListener(){
//    		public void actionPerformed(ActionEvent e){
//    			jf.dispose();	
//    			JOptionPane.showMessageDialog(null,"付款成功，我们将尽快为你安排发货！","提示消息",JOptionPane.WARNING_MESSAGE);
//    		}
//    	});
//    	
    }
}
