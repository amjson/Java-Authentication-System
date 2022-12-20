/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import DB.DBConnection;
import DB.UserCredentials;
import DB.UserPageLogout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author JoeAlpha
 */
public class Page6_Settings extends javax.swing.JFrame implements Runnable {
    SimpleDateFormat timeFormat;// setting variable for time Format
    SimpleDateFormat dayFormat;// setting variable for day Format
    SimpleDateFormat dateFormat;// setting variable for date Format
    String time; // setting variable for current time
    String day; // setting variable for day
    String date; // setting variable for date

    /**
     * Creates new form Page2_Dashboard
     */
    public Page6_Settings() {        
        initComponents();

        // center the form
        this.setLocationRelativeTo(this);
        
        Thread t = new Thread(this);
        t.start();
        
        // displaying users info
        sideBarFname.setText(UserCredentials.firstname);
        sideBarLname.setText(UserCredentials.lastname);
        sideBarEmail.setText(UserCredentials.email);
        lblFname.setText(UserCredentials.firstname);
        lblLname.setText(UserCredentials.lastname);
        lblEmail.setText(UserCredentials.email);
    }
    
    PreparedStatement sqlQueryCheck;
    PreparedStatement sqlQueryUpdate;
    PreparedStatement sqlQueryLogout;
    ResultSet res;
    Connection conn;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        sideBarEmail = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sideBarFname = new javax.swing.JLabel();
        sideBarLname = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        txtDashboard = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        txtSettings = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtDay = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblFname = new javax.swing.JLabel();
        lblLname = new javax.swing.JLabel();
        jPanel85 = new javax.swing.JPanel();
        jPanel86 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        PasswordLine3 = new javax.swing.JLabel();
        txtConfirmPwd = new javax.swing.JPasswordField();
        pwdError3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        PasswordLine1 = new javax.swing.JLabel();
        pwdError1 = new javax.swing.JLabel();
        txtCurrentPwd = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        PasswordLine2 = new javax.swing.JLabel();
        pwdError2 = new javax.swing.JLabel();
        txtNewPwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(java.awt.SystemColor.textHighlight);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Auth");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel20.setText("System");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 17, 150, -1));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/holder1.png"))); // NOI18N
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 40, 40));

        sideBarEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sideBarEmail.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(sideBarEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 21, 135, 20));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setOpaque(true);
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 50, 160, 1));

        sideBarFname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sideBarFname.setForeground(java.awt.Color.white);
        sideBarFname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(sideBarFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 0, 67, 20));

        sideBarLname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sideBarLname.setForeground(java.awt.Color.white);
        sideBarLname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(sideBarLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 0, 67, 20));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 60));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setOpaque(false);
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDashboard.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtDashboard.setForeground(new java.awt.Color(255, 255, 255));
        txtDashboard.setText("Dashboard");
        txtDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDashboardMouseClicked(evt);
            }
        });
        jPanel34.add(txtDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home.png"))); // NOI18N
        jPanel34.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, 150, 30));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setOpaque(false);
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSettings.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtSettings.setForeground(new java.awt.Color(255, 255, 255));
        txtSettings.setText("Settings");
        txtSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSettingsMouseClicked(evt);
            }
        });
        jPanel39.add(txtSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/settings.png"))); // NOI18N
        jPanel39.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 200, 150, 30));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setOpaque(false);
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Logout");
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel32.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 0, -1, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Logout.png"))); // NOI18N
        jPanel32.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 30, 26));

        jPanel2.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 320, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 400));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        jLabel12.setText("My Settings");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 160, 30));

        txtTime.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jPanel5.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 90, 17));

        txtDate.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 120, 17));

        txtDay.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 15)); // NOI18N
        txtDay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(txtDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 100, 17));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 1, 600, 90));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));
        jPanel75.setOpaque(false);
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setOpaque(false);
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logoBig.png"))); // NOI18N
        jPanel83.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 130));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(java.awt.SystemColor.windowBorder);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Welcome");
        jPanel83.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 210, 20));

        lblEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jPanel83.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 25));

        lblFname.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jPanel83.add(lblFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 105, 25));

        lblLname.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblLname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel83.add(lblLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 170, 105, 25));

        jPanel75.add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 240));

        jPanel85.setBackground(new java.awt.Color(255, 255, 255));
        jPanel85.setOpaque(false);
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel86.setBackground(new java.awt.Color(255, 255, 255));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel116.setText("3");
        jPanel86.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 35, 130, 20));

        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel117.setText("Manager Accounts");
        jPanel86.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, 130, 20));

        jPanel85.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 180, 70));

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lock.png"))); // NOI18N
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        PasswordLine3.setBackground(java.awt.Color.darkGray);
        PasswordLine3.setOpaque(true);
        jPanel8.add(PasswordLine3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 195, 1));

        txtConfirmPwd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtConfirmPwd.setForeground(java.awt.Color.gray);
        txtConfirmPwd.setText("yourpassword");
        txtConfirmPwd.setBorder(null);
        txtConfirmPwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmPwdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmPwdFocusLost(evt);
            }
        });
        jPanel8.add(txtConfirmPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 3, 140, 27));

        pwdError3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        pwdError3.setForeground(java.awt.Color.red);
        jPanel8.add(pwdError3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 34, 180, 16));

        jPanel85.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 200, 50));

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lock.png"))); // NOI18N
        jPanel9.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        PasswordLine1.setBackground(java.awt.Color.darkGray);
        PasswordLine1.setOpaque(true);
        jPanel9.add(PasswordLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 195, 1));

        pwdError1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        pwdError1.setForeground(java.awt.Color.red);
        jPanel9.add(pwdError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 34, 180, 16));

        txtCurrentPwd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtCurrentPwd.setForeground(java.awt.Color.gray);
        txtCurrentPwd.setText("yourpassword");
        txtCurrentPwd.setBorder(null);
        txtCurrentPwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCurrentPwdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCurrentPwdFocusLost(evt);
            }
        });
        jPanel9.add(txtCurrentPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 3, 140, 27));

        jPanel85.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 200, 50));

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Lock.png"))); // NOI18N
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        PasswordLine2.setBackground(java.awt.Color.darkGray);
        PasswordLine2.setOpaque(true);
        jPanel10.add(PasswordLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 195, 1));

        pwdError2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        pwdError2.setForeground(java.awt.Color.red);
        jPanel10.add(pwdError2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 34, 180, 16));

        txtNewPwd.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNewPwd.setForeground(java.awt.Color.gray);
        txtNewPwd.setText("yourpassword");
        txtNewPwd.setBorder(null);
        txtNewPwd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNewPwdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNewPwdFocusLost(evt);
            }
        });
        txtNewPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNewPwdKeyReleased(evt);
            }
        });
        jPanel10.add(txtNewPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 3, 140, 27));

        jPanel85.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 200, 50));

        jButton1.setBackground(java.awt.SystemColor.textHighlight);
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Update");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel85.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 90, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(java.awt.SystemColor.windowBorder);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Confirm Password:");
        jPanel85.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(java.awt.SystemColor.windowBorder);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Current Password:");
        jPanel85.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 20));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(java.awt.SystemColor.windowBorder);
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("New Password:");
        jPanel85.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, 20));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("Clear");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel85.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 50, 30));

        jPanel75.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 300, 250));

        jLabel13.setBackground(java.awt.Color.lightGray);
        jLabel13.setOpaque(true);
        jPanel75.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 1, 245));

        jPanel40.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, -1));

        jPanel1.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 560, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDashboardMouseClicked
        // Go to dashboard
        Page5_Dashboard dash = new Page5_Dashboard();
        this.dispose();
        dash.setVisible(true);
    }//GEN-LAST:event_txtDashboardMouseClicked

    private void txtSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSettingsMouseClicked
        // Go to settings
        Page6_Settings settings = new Page6_Settings();
        this.dispose();
        settings.setVisible(true);
    }//GEN-LAST:event_txtSettingsMouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        // operation for login out
        String email = lblEmail.getText();
        
        try {
            conn = DBConnection.setConnection();
            sqlQueryLogout = conn.prepareStatement("update tbl_users SET status='Offline' WHERE email=? ");
            sqlQueryLogout.setString(1, email);
            
            //if the logout is successfully the state of executeUpdate() will be 1
            if (sqlQueryLogout.executeUpdate() != 0) {
                // redirect to login
                Page1_Login login = new Page1_Login();

                // logout function
                UserPageLogout.logMeOut(this, login);
            }
        } catch (Exception ex) {
            Logger.getLogger(Page6_Settings.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel25MouseClicked

    /**
     * Form validation
     */
    private void txtCurrentPwdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCurrentPwdFocusGained
        // operation that occur when this field is clicked
        String pwd = String.valueOf(txtCurrentPwd.getPassword());   // get the password in text format (not in password/**** format)

        if(pwd.trim().toLowerCase().equals("yourpassword")){
            txtCurrentPwd.setText("");
            txtCurrentPwd.setForeground(Color.black);
            PasswordLine1.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtCurrentPwdFocusGained

    private void txtCurrentPwdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCurrentPwdFocusLost
        // operation that occur when this field is not clicked
        String pwd = String.valueOf(txtCurrentPwd.getPassword());   // get the password in text format (not in password/**** format)

        if(pwd.trim().equals("") || pwd.trim().equals("yourpassword")){
            txtCurrentPwd.setText("yourpassword");
            txtCurrentPwd.setForeground(Color.gray);
            PasswordLine1.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtCurrentPwdFocusLost

    private void txtNewPwdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPwdFocusGained
        // operation that occur when this field is clicked
        String pwd = String.valueOf(txtNewPwd.getPassword());   // get the password in text format (not in password/**** format)

        if(pwd.trim().toLowerCase().equals("yourpassword")){
            txtNewPwd.setText("");
            txtNewPwd.setForeground(Color.black);
            PasswordLine2.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtNewPwdFocusGained

    private void txtNewPwdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNewPwdFocusLost
        // operation that occur when this field is not clicked
        String pwd = String.valueOf(txtNewPwd.getPassword());   // get the password in text format (not in password/**** format)

        if(pwd.trim().equals("") || pwd.trim().equals("yourpassword")){
            txtNewPwd.setText("yourpassword");
            txtNewPwd.setForeground(Color.gray);
            PasswordLine2.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtNewPwdFocusLost

    private void txtNewPwdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewPwdKeyReleased
        String PATTERN = "^[a-zA-Z0-9_!@#$%^&*-?]{10,30}$";
        Pattern patt   = Pattern.compile(PATTERN);
        Matcher match  = patt.matcher(txtNewPwd.getText());

        if(!match.matches()) {
            pwdError2.setText("Invalid Password/Its too short!");
        } else {
            pwdError2.setText(null);
        }
    }//GEN-LAST:event_txtNewPwdKeyReleased

    private void txtConfirmPwdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPwdFocusGained
        // operation that occur when this field is clicked
        String pwd = String.valueOf(txtConfirmPwd.getPassword());   // get the password in text format (not in password/**** format)

        if(pwd.trim().toLowerCase().equals("yourpassword")){
            txtConfirmPwd.setText("");
            txtConfirmPwd.setForeground(Color.black);
            PasswordLine3.setBackground(new Color(0,102,255));
        }
    }//GEN-LAST:event_txtConfirmPwdFocusGained

    private void txtConfirmPwdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmPwdFocusLost
        // operation that occur when this field is not clicked
        String pwd = String.valueOf(txtConfirmPwd.getPassword());   // get the password in text format (not in password/**** format)

        if(pwd.trim().equals("") || pwd.trim().equals("yourpassword")){
            txtConfirmPwd.setText("yourpassword");
            txtConfirmPwd.setForeground(Color.gray);
            PasswordLine3.setBackground(Color.black);
        }
    }//GEN-LAST:event_txtConfirmPwdFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // operation of updating the password
        String email = lblEmail.getText();
        
        String current  = String.valueOf(txtCurrentPwd.getPassword());
        String newpwd   = String.valueOf(txtNewPwd.getPassword());
        String confpwd  = String.valueOf(txtConfirmPwd.getPassword());

        // checking if any field is empty before submitting the form
        if(current.trim().equals("") || current.trim().equals("yourpassword")){
            pwdError1.setText("Password is missing!");
        }
        else if(newpwd.trim().equals("") || newpwd.trim().equals("yourpassword")){
            pwdError2.setText("Password is missing!");
        }
        else if(confpwd.trim().equals("") || confpwd.trim().equals("yourpassword")){
            pwdError3.setText("Password is missing!");
        }
        else {  
            try {
                // checking if user credential already exist
                conn = DBConnection.setConnection();
                sqlQueryCheck = conn.prepareStatement("select * from tbl_users where email=?");
                sqlQueryCheck.setString(1, email);
                res = sqlQueryCheck.executeQuery();
            
                // if email is in the database then Proceed
                if(res.next()){
                    // retrieve the password in the db
                    String retrievePass = res.getString("password");
                
                    // checking if password provided matches with the one in the database
                    if (retrievePass.equals(current)) {
                        // checking if new password is the same as confirm password
                        if (newpwd.equals(confpwd)) {
                            // update the password which is in the database
                            sqlQueryUpdate = conn.prepareStatement("update tbl_users SET password=? WHERE email=? ");
                            sqlQueryUpdate.setString(1, newpwd);
                            sqlQueryUpdate.setString(2, email);
                        
                            if (sqlQueryUpdate.executeUpdate() != 0) {
                                // Show success mesage
                                JOptionPane.showMessageDialog(this, "Password changed successfully.");
                                JOptionPane.showMessageDialog(this, "Next time use your new password to login");

                                txtCurrentPwd.setText("yourpassword");
                                txtNewPwd.setText("yourpassword");
                                txtConfirmPwd.setText("yourpassword");

                                // redirect the user to profile page
                                new Page5_Dashboard().setVisible(true);
                                this.dispose();

                                return;
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "Confirm Password doesn't match with new Password!");
                            txtConfirmPwd.setText("");

                            txtConfirmPwd.requestFocus();
                        }
                    }
                    else {
                        pwdError1.setText("Invalid Password!");
                        txtCurrentPwd.setText("");

                        txtCurrentPwd.requestFocus();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Page6_Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        txtCurrentPwd.setText("");
        pwdError1.setText(null);
        if(txtCurrentPwd.getText().trim().equals("")){
            txtCurrentPwd.setText("yourpassword");
            txtCurrentPwd.setForeground(Color.gray);
            PasswordLine1.setBackground(Color.black);
        }
        
        txtNewPwd.setText("");
        pwdError2.setText(null);
        if(txtNewPwd.getText().trim().equals("")){
            txtNewPwd.setText("yourpassword");
            txtNewPwd.setForeground(Color.gray);
            PasswordLine2.setBackground(Color.black);
        }
        
        txtConfirmPwd.setText("");
        pwdError3.setText(null);
        if(txtConfirmPwd.getText().trim().equals("")){
            txtConfirmPwd.setText("yourpassword");
            txtConfirmPwd.setForeground(Color.gray);
            PasswordLine3.setBackground(Color.black);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Page6_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Page6_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Page6_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page6_Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page6_Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PasswordLine1;
    private javax.swing.JLabel PasswordLine2;
    private javax.swing.JLabel PasswordLine3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFname;
    private javax.swing.JLabel lblLname;
    private javax.swing.JLabel pwdError1;
    private javax.swing.JLabel pwdError2;
    private javax.swing.JLabel pwdError3;
    private javax.swing.JLabel sideBarEmail;
    private javax.swing.JLabel sideBarFname;
    private javax.swing.JLabel sideBarLname;
    private javax.swing.JPasswordField txtConfirmPwd;
    private javax.swing.JPasswordField txtCurrentPwd;
    private javax.swing.JLabel txtDashboard;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtDay;
    private javax.swing.JPasswordField txtNewPwd;
    private javax.swing.JLabel txtSettings;
    private javax.swing.JLabel txtTime;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(true) {
            try {
                timeFormat = new SimpleDateFormat("hh:mm:ss a");
                time = timeFormat.format(Calendar.getInstance().getTime());
                txtTime.setText(time);

                dayFormat = new SimpleDateFormat("EEEE");
                day = dayFormat.format(Calendar.getInstance().getTime());
                txtDay.setText(day);

                dateFormat = new SimpleDateFormat("dd MMM yyyy"); // setting the time
                date = dateFormat.format(Calendar.getInstance().getTime());// getting current date
                txtDate.setText(date);// displaying the date to the user
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}