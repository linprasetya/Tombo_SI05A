/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Koneksi.Connect;
import com.mysql.jdbc.Statement;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

/**
 *
 * @author Trax
 */
public class frHome extends javax.swing.JFrame {

    /**
     * Creates new form frHome
     */
    Connection _Cnn;
    Connect Connect = new Connect();
    String idt,user,username;
    private final Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    public frHome(String id,String userlogin, String usernm) {
        initComponents();
        
        //_User = userlogin;
        
        switch (userlogin) {
            case "Teknisi":
                loginteknisi();
                user = "Teknisi";
                username = usernm;
                idt = id;
                break;
            case "Admin":
                loginadmin();
                username = usernm;
                user = "Admin";
                idt = id;
                break;
        }
        lblName.setText("Hai "+username );
        lblName1.setText("Selamat berbelanja");
    }
    
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnDarat = new javax.swing.JButton();
        mnTransaksi = new javax.swing.JButton();
        mnPengguna = new javax.swing.JButton();
        mnLogout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 153, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        btnDarat.setBackground(new java.awt.Color(0, 153, 204));
        btnDarat.setForeground(new java.awt.Color(255, 255, 255));
        btnDarat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/box-11433.png"))); // NOI18N
        btnDarat.setText("Daftar Barang");
        btnDarat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaratActionPerformed(evt);
            }
        });

        mnTransaksi.setBackground(new java.awt.Color(0, 153, 204));
        mnTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        mnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/shopping-cart-2025.png"))); // NOI18N
        mnTransaksi.setText("Transaksi");
        mnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransaksiActionPerformed(evt);
            }
        });

        mnPengguna.setBackground(new java.awt.Color(0, 153, 204));
        mnPengguna.setForeground(new java.awt.Color(255, 255, 255));
        mnPengguna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/user-information-319.png"))); // NOI18N
        mnPengguna.setText("Teknisi");
        mnPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPenggunaActionPerformed(evt);
            }
        });

        mnLogout.setBackground(new java.awt.Color(0, 153, 204));
        mnLogout.setForeground(new java.awt.Color(255, 255, 255));
        mnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/warning-sign-9760.png"))); // NOI18N
        mnLogout.setText("Logout");
        mnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLogoutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Day-Day Tubes");

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnPengguna, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mnTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDarat, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDarat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mnPengguna)
                .addGap(1, 1, 1)
                .addComponent(mnTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mnLogout)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDaratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaratActionPerformed
        // TODO add your handling code here:
        frBarang d = new frBarang(user);
        d.setVisible(true);
    }//GEN-LAST:event_btnDaratActionPerformed

    private void mnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLogoutActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Apakah anda ingin Log Out?",
                "Pertanyaan", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            frLogin login = new frLogin();
            dispose();
            login.setVisible(true);}
    }//GEN-LAST:event_mnLogoutActionPerformed

    private void mnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransaksiActionPerformed
        // TODO add your handling code here:
        frTransaksi x = new frTransaksi(user, idt);
        x.setVisible(true);
    }//GEN-LAST:event_mnTransaksiActionPerformed

    private void mnPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPenggunaActionPerformed
        // TODO add your handling code here:
        frTeknisi x = new frTeknisi(user,idt);
        x.setVisible(true);
    }//GEN-LAST:event_mnPenggunaActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDarat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JButton mnLogout;
    private javax.swing.JButton mnPengguna;
    private javax.swing.JButton mnTransaksi;
    // End of variables declaration//GEN-END:variables

    public void loginteknisi(){
        btnDarat.setEnabled(true);
        mnTransaksi.setEnabled(true);
        mnPengguna.setEnabled(true);
        mnLogout.setEnabled(true);
    }
    public void loginadmin(){
        btnDarat.setEnabled(true);
        mnTransaksi.setEnabled(true);
        mnPengguna.setEnabled(true);
        mnLogout.setEnabled(true);
    }    
    
private void aksi_logout(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                
            if (JOptionPane.showConfirmDialog(null, "Apakah anda ingin Keluar?",
                "Pertanyaan", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
            dispose();
            new frLogin().setVisible(true);
            }
                //new FrmLogin(kodelogin).setVisible(true);
            }

            private void setVisible(boolean b) {
                 //To change body of generated methods, choose Tools | Templates.
            }

            private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
                //To change body of generated methods, choose Tools | Templates.
            }
        });
}
}
