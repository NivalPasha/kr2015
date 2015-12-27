import javax.swing.*;
import java.io.IOException;

/**
 * Created by Pavel on 27.12.2015.
 */
public class ConToCon {
    private String text;
    private Connection con;
    private boolean isconnect=false;
    private JButton[][] a;
    private CommandThread ct;
    private  Warship warship;
    private JTextArea Fightlog;
    private JButton connectbut;
    private JTextField ip;
    private EnemyShip es;
    private AllyShip as;
    public ConToCon(){
        }

    public boolean getIsconnect(){
        return isconnect;
    }
    public void setIsconnect(boolean isconnect) {
        this.isconnect = isconnect;
    }

    public void Connect(String text,Connection con,CommandThread ct,Warship warship,JTextArea Fightlog,JButton connectbut,JTextField ip,EnemyShip es,JButton[][]a,AllyShip as){
        this.a=a;
        this.es=es;
        this.ip=ip;
        this.ct=ct;
        this.Fightlog=Fightlog;
        this.text=text;
        this.connectbut=connectbut;
        this.as=as;
        if(text.equals("^Connected")&&(!isconnect)) {
            try {
               warship.setCon(new Connection(ct.getIp()));
                es.setCon(warship.getCon());
                as.setCon(warship.getCon());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            ip.setVisible(false);
            connectbut.setVisible(false);
            for(int i=0;i<=9;i++){
                for (int j=0;j<=9;j++){
                    a[i][j].setEnabled(true);
                }
            }


        }
    }
    }
    

