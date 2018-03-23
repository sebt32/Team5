import javax.swing.JFrame;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class GuiView extends JPanel {

	static JFrame frmMain;
	static Container pane;
	static JPanel pnlCalendar;
	static JLabel lblTitle,  lblDesc, lblStart, lblEnd, lblDay, lblMonth, lblYear;
	static JScrollPane stblCalendar;
	static JButton btnAdd, btnDisplayAll, btnCancel;
	static JComboBox cmbStartTime, cmbStartTime1, cmbEndTime, cmbEndTime1, cmbMonth;
    static JTextField txtTitle, txtDay, txtYear;
    static JTextPane txtDesc;
	


    
   
    public static void CreateandShowGUI() {

    	//Prepare frame
        frmMain = new JFrame();
        frmMain.setSize(500, 500);
        pane = frmMain.getContentPane();
        pane.setLayout(null);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create controls
        lblTitle = new JLabel ("Title");
        lblDesc = new JLabel ("Description");
        lblStart = new JLabel ("Start time");
        lblEnd = new JLabel ("End Time");
        lblDay = new JLabel ("Day");
        lblMonth = new JLabel ("Month");
        lblYear = new JLabel ("Year");
        btnAdd = new JButton ("Add");
        btnDisplayAll = new JButton ("Display All");
        btnCancel = new JButton ("Cancel");
        cmbStartTime = new JComboBox();
        cmbStartTime1 = new JComboBox();
        cmbEndTime = new JComboBox();
        cmbEndTime1 = new JComboBox();
        cmbMonth = new JComboBox();
        txtTitle = new JTextField();
        txtDay = new JTextField();
        txtYear = new JTextField();
        txtDesc = new JTextPane();
        
        pnlCalendar = new JPanel(null);

        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Appointment System"));
        //Register action listeners
        //cmbStartTime.addActionListener(new cmbStartTime_Action());
        //cmbStartTime1.addActionListener(new cmbStartTime1_Action());
        //cmbEndTime.addActionListener(new cmbYear_Action());
        //cmbEndTime1.addActionListener(new cmbYear_Action());
        //cmbMonth.addActionListener(new cmbMonth_Action());
      
        cmbMonth.setMaximumRowCount(12);
		cmbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
		cmbMonth.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				actionPerformed(evt);
			}
		});
		
		cmbStartTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cmbStartTime1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cmbEndTime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cmbEndTime1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        
        //Add controls to pane
        pane.add(pnlCalendar);
        pnlCalendar.add(lblTitle);
        pnlCalendar.add(lblDesc);
        pnlCalendar.add(lblStart);
        pnlCalendar.add(lblEnd);
        pnlCalendar.add(lblDay);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(btnAdd);
        pnlCalendar.add(btnDisplayAll);
        pnlCalendar.add(btnCancel);
        pnlCalendar.add(cmbStartTime);
        pnlCalendar.add(cmbStartTime1);
        pnlCalendar.add(cmbEndTime);
        pnlCalendar.add(cmbEndTime1);
        pnlCalendar.add(cmbMonth);
        pnlCalendar.add(txtTitle);
        pnlCalendar.add(txtDay);
        pnlCalendar.add(txtYear);
        pnlCalendar.add(txtDesc);
       
        //Set bounds
        pnlCalendar.setBounds(0, 0, 720, 535);
        lblTitle.setBounds(40, 50, 80, 20);
        lblDesc.setBounds(40, 320, 80, 20);
        lblStart.setBounds(40, 120, 80, 20);
        lblEnd.setBounds(40, 150, 60, 25);
        lblDay.setBounds(40, 180, 50, 25);
        lblMonth.setBounds(40, 210, 58, 25);
        lblYear.setBounds(40, 240, 53, 25);
        btnAdd.setBounds(11, 430, 100, 25);
        btnDisplayAll.setBounds(200, 430, 100, 25);
        btnCancel.setBounds(380, 430, 100, 25);
        cmbStartTime.setBounds(120, 120, 50, 20);
        cmbStartTime1.setBounds(175, 120, 60, 20);
        cmbEndTime.setBounds(120, 150, 50, 20);
        cmbEndTime1.setBounds(175, 150, 60, 20);
        cmbMonth.setBounds(120, 210, 100, 20);
        txtTitle.setBounds(120, 51, 350, 20);
        txtDay.setBounds(120, 180, 50, 20);
        txtYear.setBounds(120, 240, 50, 20);
        txtDesc.setBounds(120, 297, 350, 80);
        
      //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        
        
        //Allow/disallow buttons
        btnAdd.setEnabled(true);
        btnDisplayAll.setEnabled(true);
        btnCancel.setEnabled(true);
        
        frmMain.setContentPane(pnlCalendar);
        
        // private boolean validateTextFields()
    	//{
    	//	if(txtTitle.getText().equals("") || txtDesc.getText().equals("") || txtDay.getText().equals("") ||
    	//			txtYear.getText().equals("")) {
    	//		
    	//		return false;
    	//	}
    	//	else {
    	//		return true;
    	//	}
    	// }
        
        
        
        
     
     
       
       
       

    }

 
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateandShowGUI();
            }
        });
  
    
        
    }
}