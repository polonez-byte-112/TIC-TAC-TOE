package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends JPanel implements ActionListener {

    public static final  int SCREEN_WIDTH=300;
    public static final  int SCREEN_HEIGHT=300;
    public static final int UNIT_SIZE=100;
    public  static final int AMOUNT_OF_SQUARES= (int)((SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE);
    public char symbolChart=' ';
    public JButton button1, button2,button3,button4,button5,button6,button7,button8,button9;
    public int choose;

    Color color = new Color(91,91,91);
    public boolean cpuWon;
    public boolean playerWon;
    Timer timer;

  //  boolean isSet=false;



    public int[] x= new int[AMOUNT_OF_SQUARES];
    public int[] y = new int[AMOUNT_OF_SQUARES];

    GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.darkGray);

        this.setFocusable(true);

        startPanel();



     this.setLayout(new GridLayout(3,3,10,10));



    }

    public void startPanel() {
        drawXorO();


    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        draw(g);

        setTimer(g);
        timer.start();



    }

    public void draw(Graphics g) {


/*
        for(int i=0; i<SCREEN_WIDTH/UNIT_SIZE;  i++){            g.setColor(Color.white);
            g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH, i*UNIT_SIZE);
        }
 */




// narysowac napis Game over jesli winner="cpu"





        if(playerWon==true){
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.PLAIN,20));

            g.drawString("Player Won", SCREEN_WIDTH/3, SCREEN_HEIGHT/2);

        }else {
            if (cpuWon == true) {
                g.setColor(Color.white);
                g.setFont(new Font("Arial", Font.PLAIN, 20));

                g.drawString("CPU Won", SCREEN_WIDTH / 3, SCREEN_HEIGHT / 2);
            } else {
                if((button1.isEnabled()==false)&&(button2.isEnabled()==false)&&(button3.isEnabled()==false)&&(button4.isEnabled()==false)&&(button5.isEnabled()==false)&&(button6.isEnabled()==false)&&(button7.isEnabled()==false)&&(button8.isEnabled()==false)&&(button9.isEnabled()==false))
            {

                if(playerWon==true){
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial", Font.PLAIN,20));

                    g.drawString("Player Won", SCREEN_WIDTH/3, SCREEN_HEIGHT/2);

                }else{
                    if (cpuWon == true) {
                        g.setColor(Color.white);
                        g.setFont(new Font("Arial", Font.PLAIN, 20));

                        g.drawString("CPU Won", SCREEN_WIDTH / 3, SCREEN_HEIGHT / 2);
                    }else{
                        g.setColor(Color.white);
                        g.setFont(new Font("Arial", Font.PLAIN, 20));

                        g.drawString("Game Over", SCREEN_WIDTH / 3, SCREEN_HEIGHT / 2);
                        g.drawString("Nobody Wins", SCREEN_WIDTH / 3, (SCREEN_HEIGHT / 2)+ 30);
                    }
                }

            }}
        }
        if((playerWon==true)||(cpuWon==true)||((button1.isEnabled()==false)&&(button2.isEnabled()==false)&&(button3.isEnabled()==false)&&(button4.isEnabled()==false)&&(button5.isEnabled()==false)&&(button6.isEnabled()==false)&&(button7.isEnabled()==false)&&(button8.isEnabled()==false)&&(button9.isEnabled()==false))){
            g.setColor(Color.white);
            button1.setVisible(false);
            button2.setVisible(false);
            button3.setVisible(false);
            button4.setVisible(false);
            button5.setVisible(false);
            button6.setVisible(false);
            button7.setVisible(false);
            button8.setVisible(false);
            button9.setVisible(false);

        }

    }



    public void drawXorO(){

        //Jak wyglada X
             button1= new JButton();
            button1.setText(""+symbolChart);
            button1.setBackground(color);
            button1.addActionListener(this);
            button1.setFocusPainted(false);
            button1.setActionCommand("b1");
           this.add(button1);

         button2=  new JButton();
        button2.setText(""+symbolChart);
        button2.setBackground(color);
        button2.addActionListener(this);
        button2.setFocusPainted(false);
        button2.setActionCommand("b2");
        this.add(button2);


         button3=  new JButton();
        button3.setText(""+symbolChart);
        button3.setBackground(color);
        button3.addActionListener(this);
        button3.setFocusPainted(false);
        button3.setActionCommand("b3");
        this.add(button3);

         button4=  new JButton();
        button4.setText(""+symbolChart);
        button4.setBackground(color);
        button4.addActionListener(this);
        button4.setFocusPainted(false);
        button4.setActionCommand("b4");
        this.add(button4);

         button5=  new JButton();
        button5.setText(""+symbolChart);
        button5.setBackground(color);
        button5.addActionListener(this);
        button5.setFocusPainted(false);
        button5.setActionCommand("b5");
        this.add(button5);

         button6=  new JButton();
        button6.setText(""+symbolChart);
        button6.setBackground(color);
        button6.addActionListener(this);
        button6.setFocusPainted(false);
        button6.setActionCommand("b6");
        this.add(button6);


         button7=  new JButton();
        button7.setText(""+symbolChart);
        button7.setBackground(color);
        button7.addActionListener(this);
        button7.setFocusPainted(false);
        button7.setActionCommand("b7");
        this.add(button7);

        button8=  new JButton();
        button8.addActionListener(this);
        button8.setBackground(color);
        button8.setActionCommand("b8");
        button8.setFocusPainted(false);
        button8.setText(""+symbolChart);
        this.add(button8);

         button9=  new JButton();
        button9.addActionListener(this);
        button9.setBackground(color);
        button9.setActionCommand("b9");
        button9.setFocusPainted(false);
        button9.setText(""+symbolChart);
        this.add(button9);



    }  //tworzy przyciski i przypisuje im charta

    public void checkCombinations(){


        String button1Text = button1.getText();
        String button2Text = button2.getText();
        String button3Text = button3.getText();
        String button4Text = button4.getText();
        String button5Text = button5.getText();
        String button6Text = button6.getText();
        String button7Text = button7.getText();
        String button8Text = button8.getText();
        String button9Text = button9.getText();

        if((button1Text.equals("X"))&&(button2Text.equals("X"))&&(button3Text.equals("X"))){playerWon=true; }
        if((button4Text.equals("X"))&&(button5Text.equals("X"))&&(button6Text.equals("X"))){playerWon=true; }
        if((button7Text.equals("X"))&&(button8Text.equals("X"))&&(button9Text.equals("X"))){playerWon=true; }

        if((button1Text.equals("X"))&&(button4Text.equals("X"))&&(button7Text.equals("X"))){playerWon=true; }
        if((button2Text.equals("X"))&&(button5Text.equals("X"))&&(button8Text.equals("X"))){playerWon=true; }
        if((button3Text.equals("X"))&&(button6Text.equals("X"))&&(button9Text.equals("X"))){playerWon=true; }

        if((button1Text.equals("X"))&&(button5Text.equals("X"))&&(button9Text.equals("X"))){playerWon=true; }
        if((button3Text.equals("X"))&&(button5Text.equals("X"))&&(button7Text.equals("X"))){playerWon=true; }


        if((button1Text.equals("O"))&&(button2Text.equals("O"))&&(button3Text.equals("O"))){cpuWon=true; }
        if((button4Text.equals("O"))&&(button5Text.equals("O"))&&(button6Text.equals("O"))){cpuWon=true; }
        if((button7Text.equals("O"))&&(button8Text.equals("O"))&&(button9Text.equals("O"))){cpuWon=true; }

        if((button1Text.equals("O"))&&(button4Text.equals("O"))&&(button7Text.equals("O"))){cpuWon=true; }
        if((button2Text.equals("O"))&&(button5Text.equals("O"))&&(button8Text.equals("O"))){cpuWon=true; }
        if((button3Text.equals("O"))&&(button6Text.equals("X"))&&(button9Text.equals("O"))){cpuWon=true; }

        if((button1Text.equals("O"))&&(button5Text.equals("O"))&&(button9Text.equals("O"))){cpuWon=true; }
        if((button3Text.equals("O"))&&(button5Text.equals("O"))&&(button7Text.equals("O"))){cpuWon=true; }




        }




    public void randomCPUShot(){

      choose=(int)((Math.random()*9)+1);
        System.out.println(choose);

          switch (choose){
              case 1: checkButton(button1); break;
              case 2: checkButton(button2); break;
              case 3: checkButton(button3); break;
              case 4: checkButton(button4); break;
              case 5: checkButton(button5); break;
              case 6: checkButton(button6); break;
              case 7: checkButton(button7); break;
              case 8: checkButton(button8); break;
              case 9: checkButton(button9); break;
              default: break;


          }
    }

    public void checkButton(JButton button)
    {   String text = button.getText();
        if((button1.isEnabled())||(button2.isEnabled())||(button3.isEnabled())||(button4.isEnabled())||(button5.isEnabled())||(button6.isEnabled())||(button7.isEnabled())||(button8.isEnabled())||(button9.isEnabled())){
            if(text.equals("X")){ randomCPUShot(); }
            else if(text.equals("O")){ randomCPUShot(); }else {

                symbolChart='O';
                switch (choose){
                    case 1: button1.setText(""+symbolChart); button1.setEnabled(false); break;
                    case 2: button2.setText(""+symbolChart);button2.setEnabled(false);break;
                    case 3: button3.setText(""+symbolChart);button3.setEnabled(false);break;
                    case 4: button4.setText(""+symbolChart);button4.setEnabled(false);break;
                    case 5: button5.setText(""+symbolChart);button5.setEnabled(false);break;
                    case 6: button6.setText(""+symbolChart);button6.setEnabled(false);break;
                    case 7: button7.setText(""+symbolChart);button7.setEnabled(false);break;
                    case 8: button8.setText(""+symbolChart);button8.setEnabled(false);break;
                    case 9: button9.setText(""+symbolChart);button9.setEnabled(false);break;
                    default:break;
                }
            }
        }else{
            System.out.println("Game Over");
            //Dodać automatyczny remis bo jezeli wczesniej by wygrano to by było widać
        }





    }


    public void setTimer(Graphics g){
        timer= new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkCombinations();
                draw(g);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "b1": button1.setEnabled(false); setSymbol(); button1.setText(""+symbolChart); randomCPUShot(); break;
            case "b2": button2.setEnabled(false); setSymbol(); button2.setText(""+symbolChart); randomCPUShot(); break;
            case "b3": button3.setEnabled(false); setSymbol(); button3.setText(""+symbolChart); randomCPUShot(); break;
            case "b4": button4.setEnabled(false); setSymbol(); button4.setText(""+symbolChart); randomCPUShot(); break;
            case "b5": button5.setEnabled(false); setSymbol(); button5.setText(""+symbolChart); randomCPUShot(); break;
            case "b6": button6.setEnabled(false); setSymbol(); button6.setText(""+symbolChart); randomCPUShot(); break;
            case "b7": button7.setEnabled(false); setSymbol(); button7.setText(""+symbolChart); randomCPUShot(); break;
            case "b8": button8.setEnabled(false); setSymbol(); button8.setText(""+symbolChart); randomCPUShot(); break;
            case "b9": button9.setEnabled(false); setSymbol(); button9.setText(""+symbolChart); randomCPUShot(); break;

            default :break;
        }
    repaint();
    }

    public void setSymbol() {
        symbolChart='X';
    }
}
