import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.sql.*;
import java.text.*;


public class HomeFrame extends JFrame{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;
JLabel lblDate,lblWelcome;
JPanel p1,p2,p3;

HomeFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

p1=new JPanel();
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnDelete=new JButton("delete");
btnUpdate=new JButton("Update");

p1.add(btnAdd);
p1.add(btnView);
p1.add(btnUpdate);
p1.add(btnDelete);
c.add(p1);

p2=new JPanel();
lblWelcome=new JLabel("STUDENT DATABASE");
p2.add(lblWelcome);
c.add(p2);

p3=new JPanel();
String str=LocalDate.now().toString();
lblDate=new JLabel("DATE: "+str);
p3.add(lblDate);
c.add(p3);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
AddFrame a=new AddFrame();
dispose();
}});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
ViewFrame a=new ViewFrame();
dispose();
}});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
UpdateFrame a=new UpdateFrame();
dispose();
}});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
DeleteFrame a=new DeleteFrame();
dispose();
}});

Font font2 = new Font("SansSerif", Font.BOLD, 25);
lblWelcome.setFont(font2);
Font font1 = new Font("SansSerif", Font.BOLD, 15);
lblDate.setFont(font1);
setSize(400,200);
setTitle("Student Management System");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}//End of HomeFrame constructor


}//End of HomeFrame 


class DbHandler{

public void addStudent(int rollno,String name){
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="insert into student values(?,?)";
PreparedStatement pst=c.prepareStatement(sql);
pst.setInt(1,rollno);
pst.setString(2,name);
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r+" RECORD SUCCESFULLY UPDATED");
c.close();
}
catch(SQLException e){
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"PLESE SELECT ANY OTHER OTHER ROLL_NO", "Warning",JOptionPane.WARNING_MESSAGE);
}}//End of addERecord



public String viewStudent(){
StringBuffer sb=new StringBuffer();
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="select * from student ORDER BY rollno ASC";
//String sql="select * from ACCOUNTS1 ";
Statement stmt=c.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next()){
String rollno=rs.getString(1);
String name=rs.getString(2);
sb.append("Roll_No: "+rollno+"   |   Name: "+name+"\n");
}
rs.close();
c.close();
}catch(SQLException e){
System.out.println(e);
}
return sb.toString();
}//End of view student


public void updateStudent(int rollno,String name) {
try  {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

String sql = "UPDATE student SET name=? WHERE rollno = ?";
PreparedStatement pstmt = c.prepareStatement(sql);
pstmt.setString(1,name);
pstmt.setInt(2, rollno);
pstmt.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),"RECORD SUCCESFULLY UPDATED");
c.close();
}
catch (SQLException e) {
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"INVALID ROLL_NO", "Warning",JOptionPane.WARNING_MESSAGE);
} }//End of updateStudent


public void deleteStudent(int rollno) {
try  {
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "DELETE FROM student WHERE rollno = ?";
PreparedStatement pstmt = c.prepareStatement(sql);
pstmt.setInt(1, rollno);
pstmt.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),"RECORD SUCCESFULLY DELETED");
c.close();
}
catch (SQLException e) {
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"SOME PROBLEM OCCURED IN JDBC DTTRIVER", "Warning",JOptionPane.WARNING_MESSAGE);
}
} //End of Delete Student


public void validateDelete(int rollno){
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "SELECT * FROM student WHERE rollno=?";
PreparedStatement pstmt = c.prepareStatement(sql);
pstmt.setInt(1, rollno);
ResultSet rs=pstmt.executeQuery();
if(rs.next())
{
new DbHandler().deleteStudent(rollno);
}else{
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"THIS ROLL_NO NOT EXIST IN DATABASE", "Warning",JOptionPane.WARNING_MESSAGE);
}
c.close();
}catch(SQLException e){
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"SOME PROBLEM OCCURED IN JDBC DRIVER", "Warning",JOptionPane.WARNING_MESSAGE);
} }//End of validation of delete operation


public void validateUpdate(int rollno,String name){
try{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "SELECT * FROM student WHERE rollno=?";
PreparedStatement pstmt = c.prepareStatement(sql);
pstmt.setInt(1, rollno);
ResultSet rs=pstmt.executeQuery();
if(rs.next())
{
new DbHandler().updateStudent(rollno,name);
}else{
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"THIS ROLL_NO NOT EXIST IN DATABASE", "Warning",JOptionPane.WARNING_MESSAGE);
}
c.close();
}catch(SQLException e){
Toolkit.getDefaultToolkit().beep();
JOptionPane.showMessageDialog(new JDialog(),"SOME PROBLEM OCCURED IN JDBC DRIVER", "Warning",JOptionPane.WARNING_MESSAGE);
} }//End of validation of update


}//End of DbHandler
