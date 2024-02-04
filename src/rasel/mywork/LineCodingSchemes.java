/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rasel.mywork;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.*;


/**
 *
 * @author Rasel Ahammed
 */
public class LineCodingSchemes extends JFrame{
    JPanel PN1;
    JButton BTN1;
    JRadioButton RBTN1, RBTN2, RBTN3, RBTN4, RBTN5, RBTN6;
    JTextField TF;
    JLabel LB;
    String str="";
    
    public LineCodingSchemes(){
        super("Line Coding Schemes");
        setBounds(350,150,750,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        LB = new JLabel("Insert a binary number : ");
        LB.setBounds(200,10,150,30);
        add(LB);
        
        TF = new JTextField();
        TF.setBounds(350,13,80,25);
        add(TF);
        
        RBTN1 = new JRadioButton("Unipolar NRZ");
        RBTN1.setBounds(150,60,100,15);
        add(RBTN1);
        
        RBTN2 = new JRadioButton("Polar NRZ");
        RBTN2.setBounds(200,100,90,15);
        add(RBTN2);
        
        RBTN3 = new JRadioButton("Polar RZ");
        RBTN3.setBounds(330,100,80,15);
        add(RBTN3);
        
        RBTN4 = new JRadioButton("Polar Biphase");
        RBTN4.setBounds(420,100,110,15);
        add(RBTN4);
        
        RBTN5 = new JRadioButton("Bipolar Schemes");
        RBTN5.setBounds(450,60,130,15);
        add(RBTN5);
        
        RBTN6 = new JRadioButton("Polar");
        RBTN6.setBounds(330, 60, 60, 15);
        add(RBTN6);
        
        PN1=new JPanel();
        PN1.setBounds(50, 150, 650, 300);
        PN1.setBackground(Color.GRAY);
        PN1.setLayout(null);
        add(PN1);
        
        RBTN2.setVisible(false);
        RBTN3.setVisible(false);
        RBTN4.setVisible(false);
        
        RBTN6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(TF.getText().compareTo("")==0){
                    JOptionPane.showMessageDialog(rootPane, "Input Field Is Empty. Please Insert Input.");
                    RBTN6.setSelected(false);
                }
                
                if(RBTN6.isSelected()==true){
                    if(RBTN1.isSelected()==true || RBTN5.isSelected()==true){
                        JOptionPane.showMessageDialog(rootPane, "Another Radio Button Is Selected.");
                        RBTN6.setSelected(false);
                    }
                    
                    else{
                        RBTN2.setVisible(true);
                        RBTN3.setVisible(true);
                        RBTN4.setVisible(true);
                    }
                }
                
                else{
                    RBTN2.setSelected(false);
                    RBTN3.setSelected(false);
                    RBTN4.setSelected(false);
                    RBTN2.setVisible(false);
                    RBTN3.setVisible(false);
                    RBTN4.setVisible(false);
                    PN1.setVisible(false);
                    PN1.setVisible(true);
                }
            }
        });
        
        RBTN1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(TF.getText().compareTo("")==0){
                    JOptionPane.showMessageDialog(rootPane, "Input Field Is Empty. Please Insert Input.");
                    RBTN1.setSelected(false);
                }
                
                if(RBTN1.isSelected()==true && (RBTN5.isSelected()==true || RBTN6.isSelected()==true)){
                    JOptionPane.showMessageDialog(rootPane, "Another Radio Button Is Selected.");
                    RBTN1.setSelected(false);
                }
                
                else
                {
                    if(RBTN1.isSelected()==true){

                        Graphics g = PN1.getGraphics();
                        Graphics2D g2d = (Graphics2D)g;
                        
                        g2d.setPaint(Color.BLACK);
                        g2d.setStroke(new BasicStroke(2));
                        g2d.draw(new Line2D.Double(50, 120, 50, 220));
                        g2d.draw(new Line2D.Double(50, 220, 550, 220));
                        
                        g2d.drawString("Amplitude", 25, 100);
                        g2d.drawString("Time", 570, 225);
                        g2d.drawString("0", 35, 220);
                        
                        str = TF.getText();
                        
                        int len = str.length();
                        int i,x=75,y=0;
                        
                        String s;
                        
                        if(str.compareTo("")!=0){
                            for(i  = 0;i<len-1;i++){
                                s = str.substring(i,i+1);
                                g2d.drawString(s, x, 150);
                                x = x + 50;
                            }
                            g2d.drawString(str.substring(i,i+1), x, 150);
                        }
                        
                        x=50;
                        y=0;
                        g2d.setPaint(Color.DARK_GRAY);
                        g2d.setStroke(new BasicStroke(4));

                        for(i=0;i<len;i++){

                            if(str.charAt(i)=='0'){
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, 220, x+j, 220));
                                        y = 220;
                                         Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                x = x + 50;
                            }

                            if(str.charAt(i)=='1'){
                                for(int j = 1; j<= 50; j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, 170, x+j, 170));
                                        y = 170;
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                x = x + 50;
                            }
                            

                                if(i<len-1 && str.charAt(i)!= str.charAt(i+1)){
                                    for(int j = 1;j <= 50;j++){
                                        try{
                                            if(str.charAt(i)=='0')
                                                g2d.draw(new Line2D.Double(x, y, x, y-j));

                                            if(str.charAt(i)=='1')
                                                g2d.draw(new Line2D.Double(x, y, x, y+j));
                                            Thread.sleep(10);
                                        } catch(InterruptedException ex) { }
                                    }
                                }
                            }
                        }

                        else{
                            PN1.setVisible(false);
                            PN1.setVisible(true);
                        }
                    }
                }
        });
        
        RBTN2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(RBTN2.isSelected() == true &&(RBTN3.isSelected() == true || RBTN4.isSelected() == true)){
                    JOptionPane.showMessageDialog(rootPane, "Another Radio Button Is Selected.");
                    RBTN2.setSelected(false);
                }
                
                if(RBTN2.isSelected() == true){
                        Graphics g = PN1.getGraphics();
                        Graphics2D g2d = (Graphics2D)g;

                        g2d.setPaint(Color.BLACK);
                        g2d.setStroke(new BasicStroke(2));
                        g2d.draw(new Line2D.Double(70, 50, 70, 250));
                        g2d.draw(new Line2D.Double(70, 100, 570, 100));
                        g2d.draw(new Line2D.Double(70, 200, 570, 200));
                        
                        g2d.drawString("Amplitude", 40, 40);
                        g2d.drawString("Time", 590, 105);
                        g2d.drawString("Time", 590, 205);
                        g2d.drawString("NRZ-L", 25, 105);
                        g2d.drawString("NRZ-I", 25, 205);
                        
                        
                        str = TF.getText();
                        
                        String s;
                        int i,x = 95,y = 0;
                        int len = str.length();
                        
                        if(str.compareTo("")!=0){
                            for(i  = 0;i<len-1;i++){
                                s = str.substring(i,i+1);
                                g2d.drawString(s, x, 60);
                                x = x + 50;
                            }
                            g2d.drawString(str.substring(i,i+1), x, 60);
                        }
                        
                        g2d.setPaint(Color.DARK_GRAY);
                        g2d.setStroke(new BasicStroke(4));
                        
                        x = 70;
                        for(i=0;i<len;i++){

                            if(str.charAt(i)=='0'){
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, 75, x+j, 75));
                                        y = 75;
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) {

                                    }
                                }
                                x = x + 50;
                            }

                            if(str.charAt(i)=='1'){
                                for(int j = 1; j<= 50; j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, 125, x+j, 125));
                                        y = 125;
                                        Thread.sleep(10);
                                    } 
                                    catch(InterruptedException ex){

                                    }
                                } 
                                x = x + 50;
                            }
                            
                            if(i<len-1 && str.charAt(i)!= str.charAt(i+1)){
                                for(int j = 1;j <= 50;j++){
                                    try{
                                        if(str.charAt(i)=='0')
                                            g2d.draw(new Line2D.Double(x, y, x, y+j));

                                        if(str.charAt(i)=='1')
                                            g2d.draw(new Line2D.Double(x, y, x, y-j));
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex) { }
                                }
                            }
                        }
                        
                        x=70;
                        y = 175;
                        int hold = 0;                   
                        
                        for(i=0;i<len;i++){
                            if(str.charAt(i)=='0'){
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x+j, y));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) {

                                    }
                                }
                            }

                            if(str.charAt(i)=='1'){
                                
                                if(y == 175){
                                    for(int j = 1;j <= 50;j++){
                                        try{
                                            g2d.draw(new Line2D.Double(x, y, x, y+j));
                                            Thread.sleep(10);
                                        }   catch(InterruptedException ex){ }
                                    }
                                    y = 225;
                                    hold = 1;
                                }
                                
                                if(hold == 0 && y == 225){
                                    for(int j = 1;j <= 50;j++){
                                        try{
                                            g2d.draw(new Line2D.Double(x, y, x, y-j));
                                            Thread.sleep(10);
                                        }   catch(InterruptedException ex){ }
                                    }
                                    y = 175;
                                }
                                
                                for(int j = 1; j<= 50; j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, y, x+j, y));
                                        Thread.sleep(10);
                                    } 
                                    catch(InterruptedException ex) {  }
                                }
                                hold = 0;
                            }
                            x = x + 50; 
                        }
                    }

                    else{
                        PN1.setVisible(false);
                        PN1.setVisible(true);
                    }
                }
            //}
        });
        
        RBTN3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                    if(RBTN3.isSelected() == true &&(RBTN2.isSelected() == true || RBTN4.isSelected() == true)){
                        JOptionPane.showMessageDialog(rootPane, "Another Radio Button Is Selected.");
                        RBTN3.setSelected(false);
                    }
                    
                    if(RBTN3.isSelected()){

                        Graphics g = PN1.getGraphics();
                        Graphics2D g2d = (Graphics2D)g;

                        g2d.setPaint(Color.BLACK);
                        g2d.setStroke(new BasicStroke(2));
                        g2d.draw(new Line2D.Double(50, 150, 50, 220));
                        g2d.draw(new Line2D.Double(50, 220, 550, 220));
                        
                        g2d.drawString("Amplitude", 25, 120);
                        g2d.drawString("Time", 570, 225);
                        g2d.drawString("0", 35, 220);
                        
                        str = TF.getText();
                        
                        int len = str.length();
                        int i,x=75,y=0;
                        
                        String s;
                        
                        if(str.compareTo("")!=0){
                            for(i  = 0;i<len-1;i++){
                                s = str.substring(i,i+1);
                                g2d.drawString(s, x, 165);
                                x = x + 50;
                            }
                            g2d.drawString(str.substring(i,i+1), x, 165);
                        }
                        
                        g2d.setPaint(Color.DARK_GRAY);
                        g2d.setStroke(new BasicStroke(4));
                        
                        x=50;
                        y=0;
                        
                        if(str.compareTo("")!=0){
                            if(str.charAt(0)=='0')
                                y = 245;
                            
                            if(str.charAt(0)=='1')
                                y = 195;
                        }
                        
                        for(i = 0; i < len; i++){
                            if(str.charAt(i)=='0'){
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                x = x + 25;
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x, y-j);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                y = y - 25;
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                
                                x = x + 25;
                                if(i<len-1 && str.charAt(i+1)=='0'){
                                    for(int j = 1; j <= 25;j++){
                                        try{
                                            g2d.drawLine(x, y, x, y+j);
                                            Thread.sleep(10);
                                        } catch(InterruptedException ex){ }
                                    }
                                y = y + 25;
                                }
                                
                                if(i<len-1 && str.charAt(i+1)=='1'){
                                    for(int j = 1; j <= 25;j++){
                                        try{
                                            g2d.drawLine(x, y, x, y-j);
                                            Thread.sleep(10);
                                        } catch(InterruptedException ex){ }
                                    }
                                    y = y - 25;
                                }
                            }
                            
                            if(str.charAt(i)=='1'){
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                x = x + 25;
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x, y+j);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                y = y + 25;
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                
                                x = x + 25;
                                if(i<len-1 && str.charAt(i+1)=='0'){
                                    for(int j = 1; j <= 25;j++){
                                        try{
                                            g2d.drawLine(x, y, x, y+j);
                                            Thread.sleep(10);
                                        } catch(InterruptedException ex){ }
                                    }
                                y = y + 25;
                                }
                                
                                if(i<len-1 && str.charAt(i+1)=='1'){
                                    for(int j = 1; j <= 25;j++){
                                        try{
                                            g2d.drawLine(x, y, x, y-j);
                                            Thread.sleep(10);
                                        } catch(InterruptedException ex){ }
                                    }
                                y = y - 25;
                                }
                            }
                        }
                    }
                    
                    else{
                        PN1.setVisible(false);
                        PN1.setVisible(true);
                    }
                //}
            }
        });
        
        RBTN4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    
                    if(RBTN4.isSelected() == true &&(RBTN2.isSelected() == true || RBTN3.isSelected() == true)){
                        JOptionPane.showMessageDialog(rootPane, "Another Radio Button Is Selected.");
                        RBTN4.setSelected(false);
                    }
                    
                    if(RBTN4.isSelected() == true){

                        Graphics g = PN1.getGraphics();
                        Graphics2D g2d = (Graphics2D)g;

                        g2d.setPaint(Color.BLACK);
                        g2d.setStroke(new BasicStroke(2));
                        g2d.draw(new Line2D.Double(80, 50, 80, 250));
                        g2d.draw(new Line2D.Double(80, 100, 580, 100));
                        g2d.draw(new Line2D.Double(80, 200, 580, 200));
                        
                        g2d.drawString("Amplitude", 50, 40);
                        g2d.drawString("Time", 590, 105);
                        g2d.drawString("Time", 590, 205);
                        g2d.drawString("Manchester", 7, 105);
                        g2d.drawString("Differential", 7, 195);
                        g2d.drawString("Manchester", 7, 210);
                        
                        
                        str = TF.getText();
                        
                        String s;
                        int i,x = 100,y = 0;
                        int len = str.length();
                        
                        if(str.compareTo("")!=0){
                            for(i  = 0;i<len-1;i++){
                                s = str.substring(i,i+1);
                                g2d.drawString(s, x, 60);
                                x = x + 50;
                            }
                            g2d.drawString(str.substring(i,i+1), x, 60);
                        }
                        
                        g2d.setPaint(Color.DARK_GRAY);
                        g2d.setStroke(new BasicStroke(4));
                        
                        x=80;
                        y=0;
                        
                        if(str.compareTo("")!=0){
                            if(str.charAt(0)=='0')
                                y = 75;
                            
                            if(str.charAt(0)=='1')
                                y = 125;
                        }
                        
                        for(i = 0; i < len; i++){
                            if(str.charAt(i)=='0'){
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                x = x + 25;
                                for(int j = 1;j <= 50 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x, y+j);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                y = y + 50;
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                x = x + 25;
                                
                                if(i<len-1 && str.charAt(i) == str.charAt(i+1)){
                                    if(str.charAt(i+1)=='0'){
                                        for(int j = 1; j <= 50; j++){
                                            try{
                                                g2d.drawLine(x, y, x, y-j);
                                                Thread.sleep(10);
                                            } catch(InterruptedException ex){ }
                                        }
                                    y = y - 50;
                                    }
                                    
                                    if(str.charAt(i+1)=='1'){
                                        for(int j = 1; j <= 50; j++){
                                            try{
                                                g2d.drawLine(x, y, x, y+j);
                                                Thread.sleep(10);
                                            } catch(InterruptedException ex){ }
                                        }
                                    y = y + 50;
                                    }
                                }
                            }
                            
                            if(str.charAt(i)=='1'){
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                x = x + 25;
                                
                                for(int j = 1;j <= 50 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x, y-j);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                y = y - 50;
                                
                                for(int j = 1;j <= 25 ;j++){
                                    try{
                                        g2d.drawLine(x, y, x+j, y);
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex){ }
                                }
                                
                                x = x + 25;
                                
                                if(i<len-1 && str.charAt(i) == str.charAt(i+1)){
                                    if(str.charAt(i+1)=='0'){
                                        for(int j = 1; j <= 50; j++){
                                            try{
                                                g2d.drawLine(x, y, x, y-j);
                                                Thread.sleep(10);
                                            } catch(InterruptedException ex){ }
                                        }
                                    y = y - 50;
                                    }
                                    
                                    if(str.charAt(i+1)=='1'){
                                        for(int j = 1; j <= 50; j++){
                                            try{
                                                g2d.drawLine(x, y, x, y+j);
                                                Thread.sleep(10);
                                            } catch(InterruptedException ex){ }
                                        }
                                    y = y + 50;
                                    }
                                }
                            }
                        }
                        
                        
                        x=80;
                        y = 175;
                        int hold = 0;                   
                        
                        for(i=0;i<len;i++){
                            if(str.charAt(i)=='0'){
                                if(y == 175){
                                    for(int j = 1; j <= 50; j++){
                                        try{
                                            g2d.draw(new Line2D.Double(x, y, x, y+j));
                                            Thread.sleep(10);
                                        } catch(InterruptedException ex) { }
                                    }
                                    y = y+50;
                                    hold = 1;
                                }
                                
                                if(hold == 0 && y == 225){
                                    for(int j = 1; j <= 50; j++){
                                        try{
                                            g2d.draw(new Line2D.Double(x, y, x, y-j));
                                            Thread.sleep(10);
                                        } catch(InterruptedException ex) { }
                                    }
                                    y = y - 50;
                                }
                                
                                hold = 0;
                            }

                                
                            if(y == 175){
                                for(int j = 1; j <= 25; j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, y, x + j, y));
                                        Thread.sleep(10);
                                    } catch(InterruptedException ex) { }
                                }
                                x = x + 25;
                                
                                for(int j = 1; j <= 50;j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, y, x, y+j));
                                        Thread.sleep(10);
                                    }catch(InterruptedException ex){ }
                                }
                                y = y + 50;
                                
                                for(int j = 1; j <= 25; j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, y, x+j, y));
                                        Thread.sleep(10);
                                    }catch(InterruptedException ex){ }
                                }
                                x = x + 25;
                                hold = 1;
                            }
                                
                            if(hold == 0 && y == 225){
                                for(int j = 1;j <= 25; j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, y, x+j, y));
                                        Thread.sleep(10);
                                    }  catch(InterruptedException ex){ }
                                }
                                x = x +25;
                                
                                for(int j = 1;j <= 50;j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, y, x, y-j));
                                        Thread.sleep(10);
                                    }  catch(InterruptedException ex){ }
                                }
                                y = y - 50;
                                
                                for(int j = 1;j <= 25; j++){
                                    try{
                                        g2d.draw(new Line2D.Double(x, y, x + j, y));
                                        Thread.sleep(10);
                                    }  catch(InterruptedException ex){ }
                                }
                                x = x + 25;
                            }
                            hold = 0;
                        }
                    }
                    
                    else{
                        PN1.setVisible(false);
                        PN1.setVisible(true);
                    }
                //}
            }
        });
        
        RBTN5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(TF.getText().compareTo("")==0){
                    JOptionPane.showMessageDialog(rootPane, "Input Field Is Empty. Please Insert Input.");
                    RBTN5.setSelected(false);
                }
                
                if(RBTN5.isSelected()==true && (RBTN1.isSelected()==true || RBTN6.isSelected()==true )){
                    JOptionPane.showMessageDialog(rootPane, "Another Radio Button is Selected.");
                    RBTN5.setSelected(false);
                }
                
                else{
                    if(RBTN5.isSelected()){

                        Graphics g = PN1.getGraphics();
                        Graphics2D g2d = (Graphics2D)g;

                        g2d.setPaint(Color.BLACK);
                        g2d.setStroke(new BasicStroke(2));
                        g2d.draw(new Line2D.Double(100, 50, 100, 250));
                        g2d.draw(new Line2D.Double(100, 100, 600, 100));
                        g2d.draw(new Line2D.Double(100, 200, 600, 200));
                        
                        g2d.drawString("Amplitude", 70, 40);
                        g2d.drawString("Time", 615, 105);
                        g2d.drawString("Time", 615, 205);
                        g2d.drawString("AMI", 70, 105);
                        g2d.drawString("Pseudoternary", 7, 205);
                        
                        
                        str = TF.getText();
                        
                        String s;
                        int i,x = 125,y = 0, hold = 0,count = 0;
                        int len = str.length();
                        
                        if(str.compareTo("")!=0){
                            for(i  = 0;i<len-1;i++){
                                s = str.substring(i,i+1);
                                g2d.drawString(s, x, 60);
                                x = x + 50;
                            }
                            g2d.drawString(str.substring(i,i+1), x, 60);
                        }
                        
                        g2d.setPaint(Color.DARK_GRAY);
                        g2d.setStroke(new BasicStroke(4));
                        
                        x=100;
                        y=100;
                        for(i=0;i<len;i++){
                            
                            if(str.charAt(i)=='1' && count%2 == 0){
                                if(i!=0){
                                    for(int j = 1; j <= 25; j++){
                                        try {
                                            g2d.draw(new Line2D.Double(x, y, x, y-j));
                                            Thread.sleep(10);
                                        } catch (InterruptedException ex) { }
                                    }
                                }
                                y = y - 25;
                                
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x + j, y));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                x = x + 50;
                                
                                for(int j = 1; j <= 25; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x, y + j));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                y = y + 25;
                                hold = 1;
                            }
                            
                            if(str.charAt(i)=='1' && count%2==1){
                                for(int j = 1; j <= 25; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x, y+j));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                y = y + 25;
                                
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x + j, y));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                x = x + 50;
                                
                                for(int j = 1; j <= 25; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x, y-j));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                y = y - 25;
                                hold = 1;
                            }
                            
                            if(hold == 1){
                                count++;
                                hold = 0;
                            }
                            
                            if(str.charAt(i)=='0'){
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, 100, x+j, 100));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                            x = x + 50;
                            }
                        }
                        
                        x = 100;
                        y = 200;
                        hold = count = 0;
                        
                        for(i=0;i<len;i++){
                            
                            if(str.charAt(i)=='0' && count%2 == 0){
                                if(i != 0){
                                    for(int j = 1; j <= 25; j++){
                                        try {
                                            g2d.draw(new Line2D.Double(x, y, x, y-j));
                                            Thread.sleep(10);
                                        } catch (InterruptedException ex) { }
                                    }
                                }
                                y = y - 25;
                                
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x + j, y));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                x = x + 50;
                                
                                for(int j = 1; j <= 25; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x, y + j));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                y = y + 25;
                                hold = 1;
                            }
                            
                            if(str.charAt(i)=='0' && count%2==1){
                                for(int j = 1; j <= 25; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x, y+j));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                y = y + 25;
                                
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x + j, y));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                x = x + 50;
                                
                                for(int j = 1; j <= 25; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, y, x, y-j));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                                y = y - 25;
                                hold = 1;
                            }
                            
                            if(hold == 1){
                                count++;
                                hold = 0;
                            }
                            
                            if(str.charAt(i)=='1'){
                                for(int j = 1; j <= 50; j++){
                                    try {
                                        g2d.draw(new Line2D.Double(x, 200, x+j, 200));
                                        Thread.sleep(10);
                                    } catch (InterruptedException ex) { }
                                }
                            x = x + 50;
                            }
                        }
                    }
                    
                    else{
                        PN1.setVisible(false);
                        PN1.setVisible(true);
                    }
                }
            }
        });
    } 
}
