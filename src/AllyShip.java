import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.CookieHandler;


public class AllyShip {
    private JButton[][] a;
    private Connection con;
    private int[][] ships = new int[10][10];
    private boolean yourplay = false;
    private int shiptype;
    private Warship warship;
    private int s1=4,s2=3,s3=2,s4=1;
    private boolean posit=false; //false = horizon true=vert

    public void setYourplay(boolean yourplay) {
        this.yourplay = yourplay;
    }

    public boolean getplay(){
        return yourplay;
    }
    public void setPosit(boolean posit) {
        this.posit = posit;
    }

    public void setShiptype(int shiptype) {
        this.shiptype = shiptype;
    }
    public int getShip(int i,int j){
        return ships[i][j];
    }
    public void setShip(int i, int j,int smth){
        ships[i][j]=smth;
    }

    public AllyShip(JButton[][] a, Warship warship) {
        this.a = a;
        this.warship = warship;
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 0; j++) {
                ships[i][j] = 0;
            }
        }


    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void ShipsListener() {
        for (int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                a[i][j]=new JButton(" ");
                final int finalI = i;
                final int finalJ = j;
                a[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!yourplay) {
                            switch (shiptype) {
                                case 1: {
                                    if (s1 == 0) {
                                        JOptionPane.showMessageDialog(warship, "Too much ships of this type, try to take another or click play");
                                    } else {
                                        a[finalI][finalJ].setBackground(Color.green);
                                        ships[finalI][finalJ] = 1;
                                        s1--;
                                    }
                                    break;
                                }
                                case 2: {
                                    if (s2 == 0) {
                                        JOptionPane.showMessageDialog(warship, "Too much ships of this type, try to take another or click play");
                                    } else {
                                        boolean gogoship = true;

                                        if (posit) {
                                            if (shiptype + finalI > ships.length) {
                                                JOptionPane.showMessageDialog(warship, "Your ship is out of sea, try another position");
                                                gogoship = false;
                                            } else {
                                                for (int i = 0; i < shiptype; i++) {
                                                    a[finalI + i][finalJ].setBackground(Color.green);
                                                    ships[finalI + i][finalJ] = 1;
                                                }
                                            }
                                        } else {
                                            if (shiptype + finalJ > ships.length) {
                                                JOptionPane.showMessageDialog(warship, "Your ship is out of sea, try another position");
                                                gogoship = false;
                                            } else {
                                                for (int i = 0; i < shiptype; i++) {
                                                    a[finalI][finalJ + i].setBackground(Color.green);
                                                    ships[finalI][finalJ + i] = 1;
                                                }
                                            }
                                        }

                                        if (gogoship) s2--;
                                    }
                                    break;
                                }
                                case 3: {
                                    if (s3 == 0) {
                                        JOptionPane.showMessageDialog(warship, "Too much ships of this type, try to take another or click play");

                                    } else {
                                        boolean gogoship = true;

                                        if (posit) {
                                            if (shiptype + finalI > ships.length) {
                                                JOptionPane.showMessageDialog(warship, "Your ship is out of sea, try another position");
                                                gogoship = false;
                                            } else {
                                                for (int i = 0; i < shiptype; i++) {
                                                    a[finalI + i][finalJ].setBackground(Color.green);
                                                    ships[finalI + i][finalJ] = 1;
                                                }
                                            }
                                        } else {
                                            if (shiptype + finalJ > ships.length) {
                                                JOptionPane.showMessageDialog(warship, "Your ship is out of sea, try another position");
                                                gogoship = false;
                                            } else {
                                                for (int i = 0; i < shiptype; i++) {
                                                    a[finalI][finalJ + i].setBackground(Color.green);
                                                    ships[finalI][finalJ + i] = 1;
                                                }
                                            }
                                        }

                                        if (gogoship) s3--;
                                    }
                                    break;
                                }
                                case 4: {
                                    if (s4 == 0) {
                                        JOptionPane.showMessageDialog(warship, "Too much ships of this type, try to take another or click play");

                                    } else {
                                        boolean gogoship = true;

                                        if (posit) {
                                            if (shiptype + finalI > ships.length) {
                                                JOptionPane.showMessageDialog(warship, "Your ship is out of sea, try another position");
                                                gogoship = false;
                                            } else {
                                                for (int i = 0; i < shiptype; i++) {
                                                    a[finalI + i][finalJ].setBackground(Color.green);
                                                    ships[finalI + i][finalJ] = 1;
                                                }
                                            }
                                        } else {
                                            if (shiptype + finalJ > ships.length) {
                                                JOptionPane.showMessageDialog(warship, "Your ship is out of sea, try another position");
                                                gogoship = false;
                                            } else {
                                                for (int i = 0; i < shiptype; i++) {
                                                    a[finalI][finalJ + i].setBackground(Color.green);
                                                    ships[finalI][finalJ + i] = 1;
                                                }
                                            }
                                        }

                                        if (gogoship) s4--;

                                    }
                                    break;
                                }
                            }
                }
            }
        });
    }
}



    }
}
