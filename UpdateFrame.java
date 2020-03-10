//package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateFrame extends JFrame{
Container c;
JLabel lblRollNo,lblName;
JTextField txtRollNo,txtName;
JButton btnSave,btnBack,btnView;
JPanel p1,p2;

UpdateFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));


p1=new JPanel();
lblRollNo=new JLabel("Enter your roll no");
lblName=new JLabel("Enter NEW name");
txtRollNo=new JTextField(3);
txtName=new JTextField(10);
p1.add(lblRollNo);
p1.add(txtRollNo);
p1.add(lblName);
p1.add(txtName);
c.add(p1);

p2=new JPanel();
btnSave=new JButton("Update");
btnBack=new JButton("Back");
btnView=new JButton("View");
p2.add(btnSave);
p2.add(btnBack);
p2.add(btnView);
c.add(p2);

btnSave.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String rolno=txtRollNo.getText();
String name=txtName.getText();
if(rolno.length()==0){ 
Toolkit.getDefaultToolkit().beep(); 
JOptionPane.showMessageDialog(new JDialog(),"ROLL_NO CANNOT BE EMPTY", "Warning",JOptionPane.WARNING_MESSAGE);
txtRollNo.requestFocus();
}
else if(name.length()==0){
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"NAME FIELD CANNOT BE EMPTY", "Warning",JOptionPane.WARNING_MESSAGE);
txtName.requestFocus();
}
else {
try{
int rollno=Integer.parseInt(rolno);
new DbHandler().validateUpdate(rollno,name);
}catch(NumberFormatException e){
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"ENTER A VALID ROLL_NO", "Warning",JOptionPane.WARNING_MESSAGE);
}catch(Exception e){
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"ROLL NUMBER CANNOT BE EMPTY", "Warning",JOptionPane.WARNING_MESSAGE);
}
txtRollNo.setText("");
txtName.setText("");
txtRollNo.requestFocus();
} } } );//Save Button


btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a=new HomeFrame();
dispose();
}});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewFrame a=new ViewFrame();
dispose();
} } );


setSize(400,200);
setTitle("UPDATE STUDENT");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}//EOF UpdateFrame