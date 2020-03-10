//package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteFrame extends JFrame{
Container c;
JLabel lblRollNo;
JTextField txtRollNo;
JButton btnDelete,btnBack,btnView;
JPanel p1,p2;

DeleteFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
lblRollNo=new JLabel("Enter your roll no");
txtRollNo=new JTextField(3);
p1.add(lblRollNo);
p1.add(txtRollNo);
c.add(p1);

p2=new JPanel();
btnDelete=new JButton("Delete");
btnBack=new JButton("Back");
btnView=new JButton("View");
p2.add(btnDelete);
p2.add(btnBack);
p2.add(btnView);
c.add(p2);

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String rolno=txtRollNo.getText();
if(rolno.length()==0){ 
Toolkit.getDefaultToolkit().beep(); 
JOptionPane.showMessageDialog(new JDialog(),"ROLL_NO CANNOT BE EMPTY", "Warning",JOptionPane.WARNING_MESSAGE);
txtRollNo.requestFocus();
}
else{
try{
int rollno=Integer.parseInt(rolno); 
new DbHandler().validateDelete(rollno);
}
catch(NumberFormatException e){
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"ENTER A VALID ROLL_NO", "Warning",JOptionPane.WARNING_MESSAGE);
} }
txtRollNo.setText("");
txtRollNo.requestFocus();
} } );//Save Button


btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a=new HomeFrame();
dispose();
} } );

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewFrame a=new ViewFrame();
dispose();
} } );

setSize(400,200);
setTitle("DELETE STUDENT");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}//EOF AddFrame