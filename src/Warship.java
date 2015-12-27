
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pavel
 */
public class Warship extends javax.swing.JFrame implements Observer{
    private JButton[][] a =new JButton[10][10];
    private JButton[][] e=new JButton[10][10];

    private CommandDeterminant cd=new CommandDeterminant();
    private int [][]enemyship=new int[10][10];
    private Connection con;
    private static CommandThread ct;
    private static Warship warship;
    private AllyShip as;
    private EnemyShip es;
    private ConToCon conto=new ConToCon();



    public Warship() {
        initComponents();
    }


    public Connection getCon() {
        return con;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        GridBagConstraints gbc;
        sendchat = new javax.swing.JTextField();
        turntimer = new javax.swing.JProgressBar();
        turnfield = new javax.swing.JTextArea();
        YourMap = new javax.swing.JPanel();
        playbut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Fightlog = new javax.swing.JTextArea();
        sendbut = new javax.swing.JButton();
        connectbut = new javax.swing.JButton();
        ip = new javax.swing.JTextField();
        EnemyMap = new javax.swing.JPanel();
        menubar = new javax.swing.JMenuBar();
        Shiptype = new javax.swing.JMenu();
        x4 = new javax.swing.JMenuItem();
        x3 = new javax.swing.JMenuItem();
        x2 = new javax.swing.JMenuItem();
        x1 = new javax.swing.JMenuItem();
        pos = new javax.swing.JMenu();
        vertical = new javax.swing.JMenuItem();
        horizon = new javax.swing.JMenuItem();
        as=new AllyShip(a,warship);
        as.ShipsListener();
        es=new EnemyShip(e,warship);
        es.ShipsListener();
        for (int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                a[i][j].setEnabled(false);
                e[i][j].setEnabled(false);
            }
        }
        turnfield.setEnabled(false);
        turnfield.setText("YOUR TURN");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setPreferredSize(new java.awt.Dimension(1100, 700));
        setMaximumSize(new java.awt.Dimension(1100,700));

        turnfield.setColumns(20);
        turnfield.setFont(new java.awt.Font("Vani", 0, 24)); // NOI18N
        turnfield.setRows(5);

        EnemyMap.setLayout(new java.awt.GridBagLayout());
        for(int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                gbc=new GridBagConstraints();
                gbc.gridy=i;
                gbc.gridx=j;
                EnemyMap.add(a[i][j],gbc);
            }
        }

        YourMap.setLayout(new java.awt.GridBagLayout());
        for(int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                gbc=new GridBagConstraints();
                gbc.gridy=i;
                gbc.gridx=j;
                YourMap.add(e[i][j],gbc);
            }
        }
        playbut.setText("Play");
        playbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbutActionPerformed(evt);
            }
        });

        Chat.setColumns(20);
        Chat.setRows(5);
        Chat.setMinimumSize(new java.awt.Dimension(100, 50));
        jScrollPane1.setViewportView(Chat);

        Fightlog.setColumns(20);
        Fightlog.setRows(5);
        Fightlog.setMinimumSize(new java.awt.Dimension(100, 50));
        jScrollPane2.setViewportView(Fightlog);

        sendbut.setText("Send");
        sendbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendbutActionPerformed(evt);
            }
        });

        connectbut.setText("Connect");
        connectbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    con=new Connection(ip.getText());
                   conto.setIsconnect(true);
                    ip.setVisible(false);
                    connectbut.setVisible(false);
                    for(int i=0;i<=9;i++){
                        for (int j=0;j<=9;j++){
                            a[i][j].setEnabled(true);
                        }
                    }
                    as.setCon(con);
                    es.setCon(con);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        Shiptype.setText("ShipType");

        x4.setText("Battleship");
        x4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x4ActionPerformed(evt);
            }
        });
        Shiptype.add(x4);

        x3.setText("Destroyer");
        x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x3ActionPerformed(evt);
            }
        });
        Shiptype.add(x3);

        x2.setText("Submarine");
        x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2ActionPerformed(evt);
            }
        });
        Shiptype.add(x2);

        x1.setText("Patrol boat");
        x1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x1ActionPerformed(evt);
            }
        });
        Shiptype.add(x1);

        menubar.add(Shiptype);

        pos.setText("Position");

        vertical.setText("Vertical");
        vertical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verticalActionPerformed(evt);
            }
        });
        pos.add(vertical);

        horizon.setText("Horizontal");
        horizon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horizonActionPerformed(evt);
            }
        });
        pos.add(horizon);

        menubar.add(pos);
        Chat.setEnabled(false);
        Fightlog.setEnabled(false);
        setJMenuBar(menubar);
        sendchat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageTextKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(EnemyMap, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(turnfield, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(playbut)
                                                                .addGap(69, 69, 69))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(connectbut)
                                                                .addGap(92, 92, 92))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(turntimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addComponent(ip))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(YourMap, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(sendbut)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(sendchat))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(278, 278, 278))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(playbut)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(turnfield, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(connectbut)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(YourMap, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(EnemyMap, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sendchat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sendbut)))
                                        .addComponent(turntimer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(15, Short.MAX_VALUE))

        );

        pack();
    }// </editor-fold>



    private void playbutActionPerformed(java.awt.event.ActionEvent evt) {
       as.setYourplay(true);
        con.sendmsg("^IPLAY");
        if(conto.getIsconnect()) es.setTurn(true);
        else{
            turnfield.setText("ENEMY TURN");
        }
        playbut.setEnabled(false);
    }
    private void messageTextKeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            String texts=sendchat.getText();
            sendchat.setText("");
            Chat.append("You: " + texts + "\n");
            con.sendmsg("MESSAGE" + texts + "\n");
        }
    }
    private void sendbutActionPerformed(java.awt.event.ActionEvent evt) {
        String texts=sendchat.getText();
        sendchat.setText("");
        Chat.append("You: " + texts + "\n");
        con.sendmsg("MESSAGE" + texts + "\n");
    }
    private void x4ActionPerformed(java.awt.event.ActionEvent evt) {
        as.setShiptype(4);
    }

    private void x2ActionPerformed(java.awt.event.ActionEvent evt) {
        as.setShiptype(2);
    }

    private void x3ActionPerformed(java.awt.event.ActionEvent evt) {
       as.setShiptype(3);
    }

    private void verticalActionPerformed(java.awt.event.ActionEvent evt) {
       as.setPosit(true);
    }

    private void horizonActionPerformed(java.awt.event.ActionEvent evt) {
       as.setPosit(false);
    }

    private void x1ActionPerformed(java.awt.event.ActionEvent evt) {
        as.setShiptype(1);
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Warship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Warship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Warship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Warship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               warship=new Warship();
                ct=new CommandThread();
                ct.addObserver(warship);
                warship.setResizable(false);
                warship.setVisible(true);
                ct.start();

            }
        });
    }

    // Variables declaration - do not modify
    private String text;
    private javax.swing.JTextArea Chat;
    private javax.swing.JPanel EnemyMap;
    private javax.swing.JTextArea Fightlog;
    private javax.swing.JMenu Shiptype;
    private javax.swing.JPanel YourMap;
    private javax.swing.JButton connectbut;
    private javax.swing.JMenuItem horizon;
    private javax.swing.JTextField ip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JButton playbut;
    private javax.swing.JMenu pos;
    private javax.swing.JButton sendbut;
    private javax.swing.JTextArea turnfield;
    private javax.swing.JMenuItem vertical;
    private javax.swing.JMenuItem x1;
    private javax.swing.JMenuItem x2;
    private javax.swing.JMenuItem x3;
    private javax.swing.JMenuItem x4;
    private javax.swing.JProgressBar turntimer;
    private javax.swing.JTextField sendchat;

    @Override
    public void update(Observable o, Object arg) {
         text =(String)arg;
        conto.Connect(text,con,ct,warship,Fightlog,connectbut,ip,es,a,as);
        cd.Determinate(text,es,Fightlog,e,turnfield,as,a,con,Chat);
        if (text.equals("^Turn")) {es.setTurn(true);
            Fightlog.append(">> Your turn\n");
        }
        }
    }
