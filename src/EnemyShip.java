import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Pavel on 27.12.2015.
 */
public class EnemyShip {
    private boolean turn=false;
    private JButton[][]e;
    private Connection con;
    private Warship warship;
    private int[][] enemyship=new int[10][10];
    private boolean enemyplay=false;

    public void setEnemyplay(boolean enemyplay) {
        this.enemyplay = enemyplay;
    }

    public void setEnemyship(int i,int j,int eng) {
        enemyship[i][j]=eng;
    }

    public EnemyShip(JButton[][]e,Warship warship) {
        this.e = e;
        this.warship=warship;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 0; j++) {
                enemyship[i][j] = 0;
            }
        }
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void ShipsListener() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                e[i][j] = new JButton(" ");
                final int finalI = i;
                final int finalJ = j;
                e[finalI][finalJ].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (turn) {
                            con.sendmsg("^ATTACK:" + finalI + " " + finalJ);
                            turn = false;
                        }
                    }
                });
            }

        }
    }
}
