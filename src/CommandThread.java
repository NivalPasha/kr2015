import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

/**
 * Created by Pavel on 23.12.2015.
 */
public class CommandThread extends Observable implements Runnable {
    private int port =5535;
    private Socket soc;
    private ServerSocket sersoc;
    private boolean busy=false;
    private Scanner scr;
    private String intext;
    private String ip;


    public String getIp() {
        return ip;
    }

    @Override
    public void run() {
        while (true){
            if(!busy){
                try {
                    busy=true;
                    sersoc= new ServerSocket(port);
                    soc=sersoc.accept();
                    scr = new Scanner(new InputStreamReader(soc.getInputStream()));
                  ip= soc.getInetAddress().toString().substring(1);
                    intext="^Connected";
                    setChanged();
                    notifyObservers(new String(intext));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                intext = scr.nextLine();
                setChanged();
                notifyObservers(new String(intext));
            }
        }

    }
    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
}
