import java.util.Random;
import java.util.Random.*;

public class KI extends Thread{

  public KI(TicTacToeKI ttt){
    game=ttt;
    runs=true;
  }

  private boolean runs=false;

  public void run(){
    analysieren();
  }

 public TicTacToeKI game;

  public void ziehen(int i, int j){
    if(runs){
    game.buttons[i][j].setEnabled(false);
    game.jLB_Ausgabe.setText("Spieler 1 ist dran");
    game.buttons[i][j].setText("O");
    game.feld[i][j]=2;
    game.player--;
    game.done++;
    game.checkhor();
    game.checkver();
    game.checkdia();
    runs=false;
    }
  }

  /*public void diagstep(){

     boolean stept=false;
        switch(var){
          case 1:
          if((game.buttons[0][0].isEnabled())&&runs){
          ziehen(0,0);
          break;
          }else
          var++;
          case 2:
          if((game.buttons[0][2].isEnabled())&&runs){
          ziehen(0,2);
          break;
          }else
          var++;
          case 3:
          if((game.buttons[2][0].isEnabled())&&runs){
          ziehen(2,0);
          break;
          }else
          var++;
          case 4:
          if((game.buttons[2][2].isEnabled())&&runs){
          ziehen(2,2);
          break;
          }else if(stept==false){
            stept=true;
            var=1;
          }
        }
        switch(var){
          case 1:
          if((game.buttons[0][0].isEnabled())&&runs){
          ziehen(0,0);
          break;
          }else
          var++;
          case 2:
          if((game.buttons[0][2].isEnabled())&&runs){
          ziehen(0,2);
          break;
          }else
          var++;
          case 3:
          if((game.buttons[2][0].isEnabled())&&runs){
          ziehen(2,0);
          break;
          }else
          var++;
          case 4:
          if((game.buttons[2][2].isEnabled())&&runs){
          ziehen(2,2);
          break;
          }else if(stept==false){
            stept=true;
            var=1;
          }
        }
  }
  
  public void gradstep(){
      boolean stept=false;
        switch(var){
          case 1:
          if((game.buttons[0][1].isEnabled())&&runs){
          ziehen(0,1);
          break;
          }else
          var++;
          case 2:
          if((game.buttons[1][2].isEnabled())&&runs){
          ziehen(1,2);
          break;
          }else
          var++;
          case 3:
          if((game.buttons[2][1].isEnabled())&&runs){
          ziehen(2,1);
          break;
          }else
          var++;
          case 4:
          if((game.buttons[2][0].isEnabled())&&runs){
          ziehen(2,0);
          break;
          }else if(stept==false){
            stept=true;
            var=1;
          }
        }
        switch(var){
          case 1:
          if((game.buttons[0][1].isEnabled())&&runs){
          ziehen(0,1);
          break;
          }else
          var++;
          case 2:
          if((game.buttons[1][2].isEnabled())&&runs){
          ziehen(1,2);
          break;
          }else
          var++;
          case 3:
          if((game.buttons[2][1].isEnabled())&&runs){
          ziehen(2,1);
          break;
          }else
          var++;
          case 4:
          if((game.buttons[2][0].isEnabled())&&runs){
          ziehen(2,0);
          break;
          }else if(stept==false){
            stept=true;
            var=1;
          }
        }
  }*/
  
    public void trydefault(){
   if((game.buttons[0][1].isEnabled())&&runs){
     ziehen(0,1);
   }
   if((game.buttons[1][2].isEnabled())&&runs){
     ziehen(1,2);
   }
   if((game.buttons[2][1].isEnabled())&&runs){
     ziehen(2,1);
   }
   if((game.buttons[1][0].isEnabled())&&runs){
     ziehen(1,0);
   }
   if((game.buttons[0][0].isEnabled())&&runs){
     ziehen(0,0);
   }
   if((game.buttons[0][2].isEnabled())&&runs){
     ziehen(0,2);
   }
   if((game.buttons[2][2].isEnabled())&&runs){
     ziehen(2,2);
   }
   if((game.buttons[2][0].isEnabled())&&runs){
     ziehen(2,0);
   }
  }

  public boolean verrisk(int player){
    for(int i=0;i<=2;i++){
      if(((game.feld[i][0]==game.feld[i][1])&&(game.feld[i][0]==player))||((game.feld[i][0]==game.feld[i][2])&&(game.feld[i][0]==player))||((game.feld[i][1]==game.feld[i][2])&&(game.feld[i][2]==player)))
      {
          return true;
      }
    }
    return false;
  }

  public boolean horrisk(int player){
    for(int i=0;i<=2;i++){
      if(((game.feld[0][i]==game.feld[1][i])&&(game.feld[0][i]==player))||((game.feld[0][i]==game.feld[2][i])&&(game.feld[0][i]==player))||((game.feld[1][i]==game.feld[2][i])&&(game.feld[2][i]==player)))
      {
          return true;
      }
    }
    return false;
  }

  public boolean hsm(int player){
    if(game.feld[1][1]==player){
      return true;
    }
    return false;
  }

  public boolean diarisk1(int player){
    if((hsm(player)&&((game.feld[0][0]==player)||(game.feld[2][2]==player)))&&runs){
      return true;
    }
    else if((hsm(0)&&((game.feld[0][0]==player)&&(game.feld[2][2]==player)))&&runs){
      return true;
    }
    return false;
  }

  public boolean diarisk2(int player){
    if(hsm(player)&&((game.feld[0][2]==player)||(game.feld[2][0]==player))){
      return true;
    }
    else if(hsm(0)&&((game.feld[0][2]==player)&&(game.feld[2][0]==player))){
      return true;
    }
    return false;
  }

  public void verdo(int player){
    for(int i=0;i<=2;i++){
      if((((game.feld[i][0]==game.feld[i][1])&&(game.feld[i][0]==player))||((game.feld[i][0]==game.feld[i][2])&&(game.feld[i][0]==player))||((game.feld[i][1]==game.feld[i][2])&&(game.feld[i][2]==player)))&&runs)
      {
        for(int j=0;j<=2;j++){
          if((game.buttons[i][j].isEnabled())&&runs){
            ziehen(i,j);
          }
        }
      }
    }
  }

  public void hordo(int player){
    for(int i=0;i<=2;i++){
      if((((game.feld[0][i]==game.feld[1][i])&&(game.feld[0][i]==player))||((game.feld[0][i]==game.feld[2][i])&&(game.feld[0][i]==player))||((game.feld[1][i]==game.feld[2][i])&&(game.feld[2][i]==player)))&&runs)
      {
        for(int j=0;j<=2;j++){
          if((game.buttons[j][i].isEnabled())&&runs){
            ziehen(j,i);
          }
        }
      }
    }
  }

  public void dodiag1(){
    for(int i=0;i<=2;i++){
      if((game.buttons[i][i].isEnabled())&&runs){
        ziehen(i,i);
      }
    }
  }

  public void dodiag2(){
    if((game.buttons[0][2].isEnabled())&&runs){
      ziehen(0,2);
    }else if((game.buttons[1][1].isEnabled())&&runs){
      ziehen(1,1);
    }else if((game.buttons[2][0].isEnabled())&&runs){
      ziehen(2,0);
    }
  }
  
  public void risk(){
    for(int i=2;i>=1;i--){
      if((verrisk(i))&&runs){
        verdo(i);
      }if((horrisk(i))&&runs){
        hordo(i);
      }if((diarisk1(i))&&runs){
        dodiag1();
      }if((diarisk2(i))&&runs){
        dodiag2();
      }
  }
  }

  public void analysieren(){
    if(game.done==1&&game.feld[1][1]!=0){
      int var=new Random().nextInt(5)+1;
      switch(var){
        case 1:
        ziehen(0,0);
        case 2:
        ziehen(0,2);
        case 3:
        ziehen(2,0);
        case 4:
        ziehen(2,2);
        default:
        ziehen(0,0);
      }
    }else if(game.done==1&&game.feld[1][1]==0){
      ziehen(1,1);
    }
      risk();
      trydefault();
    }
}