import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 13.02.2012
  * @Sebastian Liesert
  */

public class TicTacToe extends JFrame {
  // Anfang Attribute
  private JButton jBTN_Start = new JButton();
  private int player=1;
  private JLabel jLB_Ausgabe = new JLabel();
  private JButton buttons[][]=new JButton[3][3];
  private boolean runs=false;
  private int[][] feld=new int[3][3];
  private int count;
  // Ende Attribute

  public TicTacToe(String title) {
    // Frame-Initialisierung
    super(title);
        for(int i=0;i<=2;i++){
      for(int j=0;j<=2;j++){
        buttons[i][j]=new JButton();
        feld[i][j]=0;
      }
    }
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 252; 
    int frameHeight = 327;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    jBTN_Start.setBounds(16, 8, 73, 25);
    jBTN_Start.setText("Start");
    jBTN_Start.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jBTN_Start_ActionPerformed(evt);
      }
    });
    jBTN_Start.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jBTN_Start);
    buttons[0][0].setBounds(16, 40, 65, 65);
    buttons[0][0].setText("");
    buttons[0][0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons00_ActionPerformed(evt);
      }
    });
    cp.add(buttons[0][0]);
    buttons[0][1].setBounds(88, 40, 65, 65);
    buttons[0][1].setText("");
    buttons[0][1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons01_ActionPerformed(evt);
      }
    });
    cp.add(buttons[0][1]);
    buttons[0][2].setBounds(160, 40, 65, 65);
    buttons[0][2].setText("");
    buttons[0][2].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons02_ActionPerformed(evt);
      }
    });
    cp.add(buttons[0][2]);
    buttons[1][0].setBounds(16, 112, 65, 65);
    buttons[1][0].setText("");
    buttons[1][0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons10_ActionPerformed(evt);
      }
    });
    cp.add(buttons[1][0]);
    buttons[1][1].setBounds(88, 112, 65, 65);
    buttons[1][1].setText("");
    buttons[1][1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons11_ActionPerformed(evt);
      }
    });
    cp.add(buttons[1][1]);
    buttons[1][2].setBounds(160, 112, 65, 65);
    buttons[1][2].setText("");
    buttons[1][2].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons12_ActionPerformed(evt);
      }
    });
    cp.add(buttons[1][2]);
    buttons[2][0].setBounds(16, 184, 65, 65);
    buttons[2][0].setText("");
    buttons[2][0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons20_ActionPerformed(evt);
      }
    });
    cp.add(buttons[2][0]);
    buttons[2][1].setBounds(88, 184, 65, 65);
    buttons[2][1].setText("");
    buttons[2][1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons21_ActionPerformed(evt);
      }
    });
    cp.add(buttons[2][1]);
    buttons[2][2].setBounds(160, 184, 65, 65);
    buttons[2][2].setText("");
    buttons[2][2].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        buttons22_ActionPerformed(evt);
      }
    });
    cp.add(buttons[2][2]);
    jLB_Ausgabe.setBounds(16, 264, 212, 24);
    jLB_Ausgabe.setText("");
    jLB_Ausgabe.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(jLB_Ausgabe);
    buttons[2][2].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[2][2].setBounds(160, 184, 65, 65);
    buttons[2][1].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[2][1].setBounds(88, 184, 65, 65);
    buttons[2][0].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[2][0].setBounds(16, 184, 65, 65);
    buttons[1][2].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[1][2].setBounds(160, 112, 65, 65);
    buttons[1][1].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[1][1].setBounds(88, 112, 65, 65);
    buttons[1][0].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[1][0].setBounds(16, 112, 65, 65);
    buttons[0][2].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[0][2].setBounds(160, 40, 65, 65);
    buttons[0][1].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[0][1].setBounds(88, 40, 65, 65);
    buttons[0][0].setFont(new Font("Dialog", Font.PLAIN, 13));
    buttons[0][0].setBounds(16, 40, 65, 65);
    // Ende Komponenten

    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden
  
  public void checkver(){
      for(int i=0;i<=2;i++){
        if((feld[i][0]==1)&&(feld[i][1]==1)&&(feld[i][2]==1)){
          runs=false;
          jLB_Ausgabe.setText("Spieler 1 gewinnt");
        }
        if((feld[i][0]==2)&&(feld[i][1]==2)&&(feld[i][2]==2)){
          runs=false;
          jLB_Ausgabe.setText("Spieler 2 gewinnt");
        }
      }
      if(count==9){
        runs=false;
        jLB_Ausgabe.setText("Kein Gewinner");
      }
  }
  
  public void checkhor(){
    for(int i=0;i<=2;i++){
      if((feld[0][i]==1)&&(feld[1][i]==1)&&(feld[2][i]==1)){
        runs=false;
        jLB_Ausgabe.setText("Spieler 1 gewinnt");
      }
      if((feld[0][i]==2)&&(feld[1][i]==2)&&(feld[2][i]==2)){
        runs=false;
        jLB_Ausgabe.setText("Spieler 2 gewinnt");
      }
    }
  }
  
  public void checkdia(){
    int ol=feld[0][0];
    int or=feld[0][2];
    int m=feld[1][1];
    int ul=feld[2][0];
    int ur=feld[2][2];
    if((or==1)&&(m==1)&&(ul==1)){
      runs=false;
      jLB_Ausgabe.setText("Spieler 1 gewinnt");
    }else if((or==2)&&(m==2)&&(ul==2)){
      runs=false;
      jLB_Ausgabe.setText("Spieler 2 gewinnt");
    }
    if((ol==1)&&(m==1)&&(ur==1)){
      runs=false;
      jLB_Ausgabe.setText("Spieler 1 gewinnt");
    }else if((ol==2)&&(m==2)&&(ur==2)){
      runs=false;
      jLB_Ausgabe.setText("Spieler 2 gewinnt");
    }
  }
  
  public void jBTN_Start_ActionPerformed(ActionEvent evt) {
    for(int i=0;i<=2;i++){
      for(int j=0;j<=2;j++){
        buttons[i][j].setEnabled(true);
        buttons[i][j].setText("");
        feld[i][j]=0;
      }
    }
    player=1;
    runs=true;
    jLB_Ausgabe.setText("Spiel gestartet");
    count=0;
  }

  public void buttons00_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[0][0].setText("X");
        buttons[0][0].setEnabled(false);
        feld[0][0]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[0][0].setText("O");
        buttons[0][0].setEnabled(false);
        feld[0][0]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkhor();
      checkdia();
    }
  }

  public void buttons01_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[0][1].setText("X");
        buttons[0][1].setEnabled(false);
        feld[0][1]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[0][1].setText("O");
        buttons[0][1].setEnabled(false);
        feld[0][1]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkhor();
      checkdia();
    }
  }

  public void buttons02_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[0][2].setText("X");
        buttons[0][2].setEnabled(false);
        feld[0][2]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[0][2].setText("O");
        buttons[0][2].setEnabled(false);
        feld[0][2]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkhor();
      checkdia();
    }
  }

  public void buttons10_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[1][0].setText("X");
        buttons[1][0].setEnabled(false);
        feld[1][0]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[1][0].setText("O");
        buttons[1][0].setEnabled(false);
        feld[1][0]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkhor();
      checkdia();
    }
  }

  public void buttons11_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[1][1].setText("X");
        buttons[1][1].setEnabled(false);
        feld[1][1]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[1][1].setText("O");
        buttons[1][1].setEnabled(false);
        feld[1][1]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkhor();
      checkdia();
    }
  }

  public void buttons12_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[1][2].setText("X");
        buttons[1][2].setEnabled(false);
        feld[1][2]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[1][2].setText("O");
        buttons[1][2].setEnabled(false);
        feld[1][2]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkhor();
      checkdia();
    }
  }

  public void buttons20_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[2][0].setText("X");
        buttons[2][0].setEnabled(false);
        feld[2][0]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[2][0].setText("O");
        buttons[2][0].setEnabled(false);
        feld[2][0]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkdia();
      checkhor();
    }
  }

  public void buttons21_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[2][1].setText("X");
        buttons[2][1].setEnabled(false);
        feld[2][1]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[2][1].setText("O");
        buttons[2][1].setEnabled(false);
        feld[2][1]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkhor();
      checkdia();
    }
  }

  public void buttons22_ActionPerformed(ActionEvent evt) {
    if(runs){
      if(player==1){
        buttons[2][2].setText("X");
        buttons[2][2].setEnabled(false);
        feld[2][2]=player;
        player++;
        jLB_Ausgabe.setText("Spieler 2 ist dran");
      }
      else{
        buttons[2][2].setText("O");
        buttons[2][2].setEnabled(false);
        feld[2][2]=player;
        player--;
        jLB_Ausgabe.setText("Spieler 1 ist dran");
      }
      count++;
      checkver();
      checkdia();
      checkhor();
    }
  }

  // Ende Methoden

  public static void main(String[] args) {
    new TicTacToe("TicTacToe");
  }
}
