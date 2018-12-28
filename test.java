package question;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class test extends JFrame implements ActionListener
{
	/*EmployeeInfoInput*/
	private JMenuBar bar = new JMenuBar() ;
	
	//一级目录EmployeeInfoInput Search
	private JMenu EmInfoInput = new JMenu("EmployeeInfoInput") ;
	private JMenu Search = new JMenu("Search") ;
	
	//二级目录CommissionEmployee BasePlusEmployee AverageEarningSearch
	private JMenuItem ComEmployee = new JMenuItem("CommissionEmployee") ;
	private JMenuItem BasePlusEmployee = new JMenuItem("BasePlusCommisionEmployee") ;
	private JMenuItem AverEarningSearch = new JMenuItem("AverageEarningSearch") ;
	
	//员工详细信息 firstName lastName socialSecurityNumber grossSales commissionRate baseSalary
	private JLabel FNLable = new JLabel("firstName") ;
	private JTextField FNText = new JTextField(20) ;
	
	private JLabel LNLable = new JLabel("lastName") ;
	private JTextField LNText = new JTextField(20) ;
	
	private JLabel SSNLable = new JLabel("socialSecurityNumber") ;
	private JTextField SSNText = new JTextField(20) ;
	
	//CommissionEmployee
	private JDialog ComEmployeeDialog = new JDialog(this, true) ;
	
	private JLabel CGSLable = new JLabel("grossSales") ;
	private JTextField CGSText = new JTextField(20) ;
	
	private JLabel CComRateLable = new JLabel("commissionRate") ;
	private JTextField CComRateText = new JTextField(20) ;
	
	private JButton ComEmployeeOk = new JButton("Ok") ;
	private JButton ComEmployeeReset = new JButton("Reset") ;
	
	//BasePlusCommissonEmployee
	private JDialog BasePlusEmDialog = new JDialog(this, true) ;
	
	private JLabel BGSLable = new JLabel("grossSales") ;
	private JTextField BGSText = new JTextField(20) ;
	
	private JLabel BComRateLable = new JLabel("commissionRate") ;
	private JTextField BComRateText = new JTextField(20) ;
	
	private JLabel BSLable = new JLabel("BaseSalary") ;
	private JTextField BSText = new JTextField(20) ;
	
	private JButton BEmployeeOk = new JButton("Ok") ;
	private JButton BEmployeeReset = new JButton("Reset") ;
	
	//平均工资
	private JDialog AverDialog = new JDialog(this, true) ;
	private JLabel AverLabel = new JLabel("") ;
	private JButton AverOk = new JButton("Ok") ;
	
	//错误显示
	private JDialog ErrorDialog = new JDialog(this, true) ;
	private JLabel Error = new JLabel("Invalid input! Try again!") ;
	private JButton ErrorOk = new JButton("Ok") ;
	
	private int total ; // 员工总数
	private Employee[] em = new Employee[100] ;//存储员工,最多能存储100个
	
	//构造方法
	public test()
	{
		total = 0 ;	//初始化为0
		
		setLocation(500, 300) ;
		setTitle("Employee Information Input") ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		setSize(400, 200) ;
//		set Layout
//		setLayout(new GridLayout(1, 1)) ;
		
		//add JMenuItem to JMenu
		EmInfoInput.add(ComEmployee) ;
		EmInfoInput.add(BasePlusEmployee) ;
		
		Search.add(AverEarningSearch) ;
		
		//add JMenu to JMenuBar
		bar.add(EmInfoInput) ;
		bar.add(Search) ;
		
		//add JMenuBar to JFrame
		setJMenuBar(bar) ;
		
		//add listener to each JMenuItem
		ComEmployee.addActionListener(this) ;
		BasePlusEmployee.addActionListener(this) ;
		AverEarningSearch.addActionListener(this) ;
		
		ComEmployeeOk.addActionListener(this);
		ComEmployeeReset.addActionListener(this);
		
		BEmployeeOk.addActionListener(this);
		BEmployeeReset.addActionListener(this);
		
		AverOk.addActionListener(this);
		
		ErrorOk.addActionListener(this);
		
		//remove the highlighting around the button text
		BEmployeeOk.setFocusPainted(false);
		BEmployeeReset.setFocusPainted(false);
		ComEmployeeOk.setFocusPainted(false);
		ComEmployeeReset.setFocusPainted(false);
		AverOk.setFocusPainted(false);
		ErrorOk.setFocusPainted(false);
		
		setVisible(true) ;
	}
	
	//针对每一个JDialog将组件加入进去
	public void ComEmInput()
	{
		ComEmployeeDialog.setLocation(300, 200);
		ComEmployeeDialog.setTitle("CommissionEmployee");
		ComEmployeeDialog.setLayout(new GridLayout(0, 2, 5, 5)) ;
		
		//add items to ComEmployeeDialog
		ComEmployeeDialog.add(FNLable) ;
		ComEmployeeDialog.add(FNText) ;
		
		ComEmployeeDialog.add(LNLable) ;
		ComEmployeeDialog.add(LNText) ;
		
		ComEmployeeDialog.add(SSNLable) ;
		ComEmployeeDialog.add(SSNText) ;
		
		ComEmployeeDialog.add(CGSLable) ;
		ComEmployeeDialog.add(CGSText) ;
		
		ComEmployeeDialog.add(CComRateLable) ;
		ComEmployeeDialog.add(CComRateText) ;
		
		ComEmployeeDialog.add(ComEmployeeOk) ;
		ComEmployeeDialog.add(ComEmployeeReset) ;
		
		ComEmployeeDialog.pack();
		
		FNText.setText("") ;
		LNText.setText("") ;
		SSNText.setText("") ;
		CGSText.setText("") ;
		CComRateText.setText("");
	}
	
	public void BasePlusEmInput()
	{
		BasePlusEmDialog.setLocation(300, 200);
		BasePlusEmDialog.setTitle("BasePlusCommissionEmployee");
		BasePlusEmDialog.setLayout(new GridLayout(0, 2, 5, 5)) ;
		
		//add items to BasePlusEmDialog
		BasePlusEmDialog.add(FNLable) ;
		BasePlusEmDialog.add(FNText) ;
		
		BasePlusEmDialog.add(LNLable) ;
		BasePlusEmDialog.add(LNText) ;
		
		BasePlusEmDialog.add(SSNLable) ;
		BasePlusEmDialog.add(SSNText) ;
		
		BasePlusEmDialog.add(BGSLable) ;
		BasePlusEmDialog.add(BGSText) ;
		
		BasePlusEmDialog.add(BComRateLable) ;
		BasePlusEmDialog.add(BComRateText) ;
		
		BasePlusEmDialog.add(BSLable) ;
		BasePlusEmDialog.add(BSText) ;
		
		BasePlusEmDialog.add(BEmployeeOk) ;
		BasePlusEmDialog.add(BEmployeeReset) ;
		
		BasePlusEmDialog.pack();
		
		FNText.setText("") ;
		LNText.setText("") ;
		SSNText.setText("") ;
		BGSText.setText("") ;
		BComRateText.setText("");
		BSText.setText("");
	}
	
	public void Aver()
	{
		AverDialog.setLocation(550, 300);
		AverDialog.setTitle("AverageEarning");
		//
		
		AverDialog.add(AverLabel) ;
		AverDialog.add(AverOk) ;
		
		AverDialog.setLayout(new GridLayout(2, 1));
		AverDialog.pack();
	}
	
	public void Error()
	{
		ErrorDialog.setTitle("Error");
		ErrorDialog.setLocation(200, 200);
		ErrorDialog.setSize(600, 200);
		
		ErrorDialog.add(Error) ;
		ErrorDialog.add(ErrorOk) ;
		
		ErrorDialog.setLayout(new GridLayout(2, 1));
		ErrorDialog.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if (e.getSource() == ComEmployee)
		{
			ComEmInput() ;//调用这个方法
			ComEmployeeDialog.setVisible(true);
		}
		
		if (e.getSource() == BasePlusEmployee)
		{
			BasePlusEmInput() ;//调用这个方法
			BasePlusEmDialog.setVisible(true);
		}
		
		if (e.getSource() == AverEarningSearch)
		{
			Aver() ;//调用这个方法
			
			double sum = 0.0 ;
			double average = 0.0 ;
			
			if (total != 0 )
			{
				for (int i = 0; i < total; i ++)
				{
					sum += em[i].earning() ;
				}
				average = (double)(sum / (double)total) ;
			}
			else
			{
				average = 0.0 ;
			}
			AverLabel.setText("The average earning is " + average);	
			AverDialog.setSize(200, 100);
			AverDialog.setVisible(true);
		}
		//确认和取消按钮
		if (e.getSource() == ComEmployeeOk)
		{
			String first = FNText.getText() ;
			String last = LNText.getText() ;
			String number = SSNText.getText() ;
			String grossSales = CGSText.getText() ;
			String comRate = CComRateText.getText() ;
			//不为空
			if ((!first.trim().equals("")) && (!last.trim().equals("")) && (!number.trim().equals("")) &&
					(!grossSales.trim().equals("")) && (!comRate.trim().equals("")))
			{
				CommissionEmployee temp = new CommissionEmployee(first, last, number, Double.parseDouble(grossSales), Double.parseDouble(comRate)) ;
				em[total] = temp ;
				total ++ ;
				ComEmployeeDialog.setVisible(false);
			}
			else
			{
				Error() ;
				ErrorDialog.setVisible(true);
			}
		}
		
		if (e.getSource() == BEmployeeOk)
		{
			String first = FNText.getText() ;
			String last = LNText.getText() ;
			String number = SSNText.getText() ;
			String grossSales = BGSText.getText() ;
			String comRate = BComRateText.getText() ;
			String baseSalary = BSText.getText() ;
			
			if ((!first.trim().equals("")) && (!last.trim().equals("")) && (!number.trim().equals("")) &&
					(!grossSales.trim().equals("")) && (!comRate.trim().equals("")) && (!baseSalary.trim().equals("")))
			{
				BasePlusCommissionEmployee temp = new BasePlusCommissionEmployee(first, last, number, Double.parseDouble(grossSales), Double.parseDouble(comRate), Double.parseDouble(baseSalary)) ;
				em[total] = temp ;
				total ++ ;
				BasePlusEmDialog.setVisible(false);
			}
			else
			{
				Error() ;
				ErrorDialog.setVisible(true);
			}
		}
		
		if (e.getSource() == ErrorOk)
		{
			ErrorDialog.setVisible(false);
		}
		
		if (e.getSource() == AverOk)
		{
			AverLabel.setText("____");
			AverDialog.setVisible(false);
		}
		
		if (e.getSource() == ComEmployeeReset)
		{
			FNText.setText("") ;
			LNText.setText("") ;
			SSNText.setText("") ;
			CGSText.setText("") ;
			CComRateText.setText("");
		}
		
		if (e.getSource() == BEmployeeReset)
		{
			FNText.setText("") ;
			LNText.setText("") ;
			SSNText.setText("") ;
			BGSText.setText("") ;
			BComRateText.setText("");
			BSText.setText("");
		}
	}
	
	public static void main(String[] args)
	{
		test test = new test() ;
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
