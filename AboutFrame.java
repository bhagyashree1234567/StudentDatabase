import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AboutFrame extends JFrame{
Container c;

JLabel lblWelcome;
JPanel p1;

AboutFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));

String str="STUDENT DATABSE APPLIVATION \n"+"developed by SAURABH SINGH\n"
+"\nTHANK YOU KAMAL SIR";
p1=new JPanel();
lblWelcome=new JLabel("STUDENT DATABASE");
p1.add(lblWelcome);
c.add(p1);

Font font1 = new Font("SansSerif", Font.BOLD, 20);
lblWelcome.setFont(font1);
setSize(400,250);
setTitle("ABOUT FRAME");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
double d=1;
for(int i=0;i<2000000000;i++){
for(int j=0;j<2000000000;j++){
d*=j;
}
}

HomeFrame h=new HomeFrame();
dispose();
}//EOF Welcome Constructor



}//End of Welcome Class