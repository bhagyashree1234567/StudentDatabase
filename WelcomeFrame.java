//package p1;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class WelcomeFrame extends JFrame{
Container c;
JButton btnStart;
JLabel lblWelcome,lblSaurabh,lblDate,lblThanks;
JPanel p1,p2;

WelcomeFrame(){
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
BufferedImage img=null;
try{
img=ImageIO.read(new File("C:/JAVA_APPLICATION/KULDEEP/kuldeep.png"));
}catch(IOException e){
System.out.println("Error");
e.printStackTrace();
}
Image diag=img.getScaledInstance(400,250,Image.SCALE_SMOOTH) ;
ImageIcon imageIcon=new ImageIcon(diag);
setContentPane(new File(imageIcon));
p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
lblWelcome=new JLabel("     STUDENT DATABASE");
lblSaurabh=new JLabel("DEVELOPED BY SAURABH SINGH     ");
lblDate=new JLabel("DATE: 21 JAN 2018                       ");
lblThanks=new JLabel("THANK YOU KAMAL SIR");
p1.add(lblWelcome);
p1.add(lblSaurabh);
p1.add(lblDate);
p1.add(lblThanks);
c.add(p1);


p2=new JPanel();
btnStart=new JButton("Start");
//btnAbout=new JButton("About");
p2.add(btnStart);
//p2.add(btnAbout);
c.add(p2);

Font font1 = new Font("SansSerif", Font.BOLD, 25);
lblWelcome.setFont(font1);
Font font2 = new Font("SansSerif", Font.BOLD, 14);
lblSaurabh.setFont(font2);
lblDate.setFont(font2);
lblThanks.setFont(font2);
setSize(400,250);
setTitle("WELCOME FRAME");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

btnStart.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a=new HomeFrame();
dispose();
} } );

/*btnAbout.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
AboutFrame a=new AboutFrame();
dispose();
} } );*/

}//EOF Welcome Constructor


public static void main(String args[]){
WelcomeFrame h=new WelcomeFrame();
}//End of Main class
}//End of Welcome Class
 