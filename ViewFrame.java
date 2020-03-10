//package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class ViewFrame extends JFrame{
Container c;
TextArea txtData;
JButton btnBack,btnUpdate,btnDelete;
JPanel p1,p2;

ViewFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));


p1=new JPanel();
txtData=new TextArea(8,50);
p1.add(txtData);
c.add(p1);

p2=new JPanel();
btnUpdate=new JButton("Update");
btnBack=new JButton("Back");
btnDelete=new JButton("Delete");
p2.add(btnUpdate);
p2.add(btnBack);
p2.add(btnDelete);
c.add(p2);

txtData.setText(new DbHandler().viewStudent());
txtData.setFocusable(false);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a=new HomeFrame();
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

Font font1 = new Font("SansSerif", Font.BOLD, 13);
txtData.setFont(font1);
setSize(400,250);
setTitle("VIEW STUDENT");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}//EOF AddFrame