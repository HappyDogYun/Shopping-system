package question;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StrategiesUI extends JDialog{
    public StrategiesUI(JFrame jf,String s){
    	super(jf,s,true);
    	StrategiesUI su = this;
    	this.setBounds(400, 200, 200, 300);
    	Container container = this.getContentPane();
    	container.setLayout((new GridLayout(3,1)));
    	container.setBackground(new Color(80,80,80));
    	
    	JButton jb1 = new JButton("����");
    	jb1.setFont(new Font("����", Font.BOLD, 20));
    	jb1.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb1.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb1.setFocusPainted(false);
    	
    	JButton jb2 = new JButton("ɾ��");
    	jb2.setFont(new Font("����", Font.BOLD,20));
    	jb2.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb2.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb2.setFocusPainted(false);
    	
    	JButton jb3 = new JButton("��ѯ");
    	jb3.setFont(new Font("����", Font.BOLD, 20));
    	jb3.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb3.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb3.setFocusPainted(false);
    	
    	container.add(jb1);container.add(jb2);container.add(jb3);
    	jb1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		AddStrategyUI ad = new AddStrategyUI(su);
        		ad.setVisible(true);
        	}
        });
    	jb2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		DeleteUI de = new DeleteUI(su);
        		de.setVisible(true);
        	}
        });
    	jb3.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		CheckUI ch=new CheckUI(su);
        		ch.setVisible(true);
        	}
        });
    }
}
class AddStrategyUI extends JDialog{
	public AddStrategyUI(JDialog jd){
		super(jd,"���������",true);
		this.setBounds(100, 100, 700, 300);
		this.setLayout(new GridLayout(5,1));
		Container c=this.getContentPane();
		c.setBackground(new Color(80,80,80));
		c.setLayout(new GridLayout(3,1));
		
		JPanel jp  = new JPanel();
		jp.setBackground(new Color(80,80,80));
		JPanel jp1 = new JPanel();
		jp1.setBackground(new Color(80,80,80));
		JPanel jp2 = new JPanel();
		jp2.setBackground(new Color(80,80,80));
		JPanel jp3 = new JPanel();
		jp3.setBackground(new Color(80,80,80));
		JPanel jp4 = new JPanel();
		jp4.setBackground(new Color(80,80,80));
		JPanel jp5 = new JPanel();
		jp5.setBackground(new Color(80,80,80));
		
		JTextField jt1 = new JTextField(15);
		JTextField jt2 = new JTextField(15);
		JTextField jt3 = new JTextField(15);
		
		JComboBox  jc  = new JComboBox(new MyComboBox());
		
		JLabel jl1 = new JLabel("���Ա�ţ�");
		jl1.setFont(new Font("����", Font.BOLD, 20));
    	jl1.setForeground(new Color(255,255,255));
    	
		JLabel jl2 = new JLabel("�������ͣ�");
		jl2.setFont(new Font("����", Font.BOLD, 20));
    	jl2.setForeground(new Color(255,255,255));
    	
		JLabel jl3 = new JLabel("����ͼ�����ͣ�");
		jl3.setFont(new Font("����", Font.BOLD, 20));
		jl3.setForeground(new Color(255,255,255));
    	
		JLabel jl4 = new JLabel("�ۿ۰ٷֱ�/ÿ���Żݶ�ȣ�");
		jl4.setFont(new Font("����", Font.BOLD, 20));
		jl4.setForeground(new Color(255,255,255));
    	
		JLabel jl5 = new JLabel("���Ǹ��Ӳ��ԣ������������ϣ��磺2&3)");
		jl5.setFont(new Font("����", Font.BOLD, 15));
		jl5.setForeground(new Color(255,255,255));
    	
		jp.add(jl1);
		jp.add(jt1);
		jp1.add(jl2);
		jp1.add(jc);
		jp2.add(jl3);
		jp2.add(jt2);
		jp3.add(jl4);
		jp3.add(jt3);
		jp5.add(jl5);
		
		JButton jb1=new JButton("����");
		jb1.setFont(new Font("����", Font.BOLD, 20));
    	jb1.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb1.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb1.setFocusPainted(false);
    	
		JButton jb2=new JButton("����");
		jb2.setFont(new Font("����", Font.BOLD, 20));
    	jb2.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb2.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb2.setFocusPainted(false);
		
    	jp4.add(jb1);
		jp4.add(jb2);
		c.add(jp);
		c.add(jp1);
		c.add(jp2);
		c.add(jp3);
		c.add(jp5);
		c.add(jp4);
		jb1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(jt1.getText().isEmpty()||jt2.getText().isEmpty()||jt3.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(null,"��������������Ϣ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
        		}
        		else {
        			jd.dispose();
        			JOptionPane.showMessageDialog(null,"��ӳɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
        		  if(jc.getSelectedIndex()==2){
        			Controller.addCompositeStrategy(jt1.getText(),Integer.parseInt(jt2.getText()),jt3.getText());
        		  }
        		  else{
        			Controller.addSimpleStrategy(jt1.getText(), jc.getSelectedIndex(), Integer.parseInt(jt2.getText()), Double.parseDouble(jt3.getText()));
        		  }
        		}
        	}
        });
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
			}
		});
	}
}
class DeleteUI extends JDialog{
	public DeleteUI(JDialog jd){
		super(jd,"ɾ������",true);
		this.setBounds(300, 500, 400, 100);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(1,3));
		container.setBackground(new Color(80,80,80));
		
		
		JLabel lb = new JLabel("���Ա�ţ�");
		lb.setBounds(0, 0, 10, 20);
		lb.setFont(new Font("����", Font.BOLD, 20));
		lb.setForeground(new Color(255,255,255));
		
		JTextField jt = new JTextField("");
		jt.setBounds(10, 0, 10, 20);
		jt.setBackground(new Color(255,255,255));
		
		JButton jb = new JButton("ȷ��ɾ��");
		jb.setFont(new Font("����", Font.BOLD, 20));
    	jb.setBackground(new Color(80,80,80));//���ð�ť������ɫ
    	jb.setForeground(new Color(255,255,255));//���ð�ť������ɫ
    	jb.setFocusPainted(false);
    	
		container.add(lb);container.add(jt);container.add(jb);
		
		jb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		if(Controller.deleteStrategy(jt.getText())==1) {
        			jd.dispose();
        			JOptionPane.showMessageDialog(null,"ɾ���ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); 
        		}
        		else {
        			JOptionPane.showMessageDialog(null,"û�д˱��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
        		}
        		Controller.deleteStrategy(jt.getText());
        		Controller.deleteStrategy1(jt.getText());
        	}
        });
	}
}
class CheckUI extends JDialog{
	public CheckUI(JDialog jd){
		super(jd,"�鿴",true);
		this.setBounds(200, 500, 600, 200);
		Container c=this.getContentPane();
		c.setBackground(new Color(80,80,80));
		
		DefaultTableModel tablemodel=new DefaultTableModel();
    	JTable jt = new JTable(tablemodel);
    	jt.setBackground(new Color(80,80,80));//���ñ�����ɫ
    	jt.setForeground(new java.awt.Color(255, 255, 255));//����������ɫ�������ⲻ��ı�
    	jt.setSelectionBackground(new java.awt.Color(255,255,255));//����ѡ���е���ɫ
    	jt.getTableHeader().setBackground(new Color(80,80,80));  
    	jt.getTableHeader().setFont(new Font("����", Font.BOLD, 15));
    	jt.getTableHeader().setForeground(new Color(255,255,255));
    	
    	JScrollPane js = new JScrollPane(jt);
    	js.setBackground(new Color(80,80,80));//���ñ�����ɫ

    	tablemodel.addColumn("���Ա��");
    	tablemodel.addColumn("��������");
    	tablemodel.addColumn("��������");
    	tablemodel.addColumn("�ٷֱ�/�Żݶ�");
    	for(int i :Globalvariable.stratelog.strategies.keySet()){
    		switch(Globalvariable.stratelog.strategies.get(i).getStrategyType()){
    		case 1:
    			String[] s1={Globalvariable.stratelog.strategies.get(i).getStrategyNumber(),"����ֵ�Żݲ���",""+i,Globalvariable.stratelog.strategies.get(i).getData()};
    			tablemodel.addRow(s1);
    			break;
    		case 2:
    			String[] s2={Globalvariable.stratelog.strategies.get(i).getStrategyNumber(),"�ٷֱ��ۿ۲���",""+i,Globalvariable.stratelog.strategies.get(i).getData()};
    			tablemodel.addRow(s2);
    			break;
    		case 3:
    			String[] s3={Globalvariable.stratelog.strategies.get(i).getStrategyNumber(),"��ϲ���",""+i,Globalvariable.stratelog.strategies.get(i).getData()};
    			tablemodel.addRow(s3);
    			break;
    		}
    	}
    	c.add(js);
	}
}
class MyComboBox extends AbstractListModel implements ComboBoxModel{
	String selecteditem=null;
	String[] s={"����ֵ�Żݲ���","�ٷֱ��ۿ۲���","��ϲ���"};
	public String getElementAt(int index){
		return s[index];
	}
	public int getSize(){
		return s.length;
	}
	public void setSelectedItem(Object item) {
		selecteditem=(String)item;
		
	}
	public String getSelectedItem() {
		return selecteditem;
	}
}
