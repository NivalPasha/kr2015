import javax.swing.*;
import java.awt.*;

/**
 * Created by Pavel on 27.12.2015.
 */
public class CommandDeterminant {
    public CommandDeterminant(){

    }
    public void Determinate(String text,EnemyShip es,JTextArea Fightlog,JButton[][]e,JTextArea turnfield,AllyShip as,JButton[][]a,Connection con,JTextArea Chat){
        if(text.length()>=5){
            if (text.substring(0, 4).equals("^HIT")) {

                es.setEnemyship(Integer.parseInt(text.substring(5, 6)), Integer.parseInt(text.substring(7, 8)), 2);
                e[Integer.parseInt(text.substring(5, 6))][Integer.parseInt(text.substring(7, 8))].setBackground(Color.red);
                Fightlog.append(">> You shooted in enemy's position: " + (Integer.parseInt(text.substring(5, 6)) + 1) + " " + (Integer.parseInt(text.substring(7, 8))+1)+" and hitted \n");
                es.setTurn(true);
                Fightlog.append(">> Your turn\n");
            } else {
                if (text.substring(0, 5).equals("^MISS")) {
                    es.setEnemyship(Integer.parseInt(text.substring(6, 7)),Integer.parseInt(text.substring(8, 9)),1);
                    e[Integer.parseInt(text.substring(6, 7))][Integer.parseInt(text.substring(8, 9))].setBackground(Color.blue);
                    turnfield.setText("ENEMY TURN");
                    Fightlog.append(">> You shooted in enemy's position: " + (Integer.parseInt(text.substring(6, 7)) + 1) + " " + (Integer.parseInt(text.substring(8, 9))+1)+" and missed\n");
                    Fightlog.append(">> Enemy's turn\n");
                    es.setTurn(false);
                } else {
                    if (text.equals("^IPLAY")) {
                        es.setEnemyplay(true);
                        for (int i = 0; i <= 9; i++) {
                            for (int j = 0; j <= 9; j++) {
                                e[i][j].setEnabled(true);
                            }
                        }
                    } else {
                        if(text.length()>=7) {
                            if(text.substring(0,7).equals("MESSAGE")) Chat.append("Enemy: "+text.substring(7)+"\n");
                            if (text.substring(0, 7).equals("^ATTACK")) {
                                int i = Integer.parseInt(text.substring(8, 9));
                                int j = Integer.parseInt(text.substring(10, 11));
                                if (as.getShip(i,j) == 1) {
                                    as.setShip(i,j,2);
                                    a[i][j].setBackground(Color.red);
                                    con.sendmsg("^HIT:" + i + " " + j);
                                    Fightlog.append(">> Enemy shooted in your poisiton: "+(i+1)+" "+(j+1)+" and hitted\n" );
                                    Fightlog.append(">> Enemy's turn\n");
                                }
                                if (as.getShip(i,j) == 0) {
                                    as.setShip(i,j,3);
                                    a[i][j].setBackground(Color.blue);
                                    con.sendmsg("^MISS:" + i + " " + j);
                                    Fightlog.append(">> Enemy shooted in your poisiton: " + (i + 1) + " " + (j + 1) + " and missed\n");
                                    es.setTurn(true);
                                    Fightlog.append(">> Your turn\n");
                                    turnfield.setText("YOUR TURN");
                                }
                                if(as.getShip(i,j)==2||as.getShip(i,j)==3){
                                    con.sendmsg("^Turn");
                                    turnfield.setText("ENEMY TURN");
                                    Fightlog.append(">> Enemy's turn\n");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
