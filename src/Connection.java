import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Pavel on 23.12.2015.
 */
public class Connection {
    private int port=5535;
    private PrintWriter pw;
    private Scanner scr;
    private Socket soc;
    public Connection(String ip) throws IOException {
        Socket soc = new Socket(ip,port);
        pw = new PrintWriter(soc.getOutputStream());
    }
    public void sendmsg(String text){
        pw.flush();
        pw.println(text+'\n');
        pw.flush();
    }
}
