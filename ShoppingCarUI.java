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
	public JFrame jf = new JFrame("���ﳵ");
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
    	jt.setFont(new Font("����", Font.BOLD, 15));
    	jt.setForeground(new java.awt.Color(255, 255, 255));//����������ɫ�������ⲻ��ı�
    	jt.setSelectionBackground(new java.awt.Color(255,255,255));//����ѡ���е���ɫ
    	jt.getTableHeader().setBackground(new Color(80,80,80));  
    	jt.getTableHeader().setFont(new Font("����", Font.BOLD, 15));
    	jt.getTableHeader().setForeground(new Color(255,255,255));
    	
    	JScrollPane js = new JScrollPane(jt);
    	js.setBackground(new Color(80,80,80));
    	
    	tablemodel.addColumn("����");
    	tablemodel.addColumn("����");
    	for(SaleLineItem items :sale.items){
    		String[] s={items.getTitle(),String.valueOf(items.getCopies())};
    		tablemodel.addRow(s);
    	}
    //	jp.add(new JLabel("���ﳵ"));
    	jp.add(js);
    	//jp.add(new JLabel("�ܼ�:"+String.format("%.1f", sale.getTotal())+"Ԫ",JLabel.RIGHT));
    	DecimalFormat    df   = new DecimalFormat("######0.00");   
    	JLabel Jl1 = new JLabel("ͼ���ܼ�:   "+df.format(sale.getTotal())+"Ԫ",JLabel.CENTER);
    	Jl1.setFont(new Font("����", Font.BOLD, 20));
    	Jl1.setForeground(new Color(255,255,255));
    	jp.add(Jl1);
    	jf.add(jp);
    	jf.setVisible(true);
//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    	JButton jb=new JButton("ȷ�ϸ���");
//        jb.setFont(new Font("����", Font.BOLD, 20));
//     	jb.setBackground(new Color(80,80,80));//���ð�ť������ɫ
//     	jb.setForeground(new Color(255,255,255));//���ð�ť������ɫ
//     	jb.setFocusPainted(false);
//     	jf.add(jb);
//     	
//    	jb.addActionListener(new ActionListener(){
//    		public void actionPerformed(ActionEvent e){
//    			jf.dispose();	
//    			JOptionPane.showMessageDialog(null,"����ɹ������ǽ�����Ϊ�㰲�ŷ�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
//    		}
//    	});
//    	
    }
}
