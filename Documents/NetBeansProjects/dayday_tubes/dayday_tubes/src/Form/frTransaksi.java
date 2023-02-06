/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Koneksi.Connect;
import com.mysql.jdbc.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Trax
 */
public class frTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form frPengguna
     */
    public boolean addNew;
    public int row;
    public String username;
    public frTransaksi(String userlogin, String usernm) {
        initComponents();
        username = usernm;
        switch (userlogin) {
            case "Teknisi":
                tambah.setEnabled(true);
                cmbpesan.setEnabled(false);
                Print.setEnabled(false);
                edit.setEnabled(true);
                Search.setEnabled(true);
                break;
        }
        
        row = 0;
        loadData();
        dataFromDataBaseToComboBox(userlogin,username);
    }
    
    public void dataFromDataBaseToComboBox(String user1,String idt){
        try {
        Statement statement=(Statement)Connect.GetConnection().createStatement();
        ResultSet res=statement.executeQuery("select * from barang");
            
            while (res.next()) {                
                cmbBarang.addItem(res.getString(1)+" | "+res.getString(2)+" | "+res.getString(3));
            }
            res.last();
            int jumlahdata = res.getRow();
            res.first();
        if("Teknisi".equals(user1)){
        ResultSet res1=statement.executeQuery("select * from teknisi where kode_teknisi='"+idt+"'");
            
            while (res1.next()) {                
                cmbpesan.addItem(res1.getString(1)+" | "+res1.getString(2)+" | "+res1.getString(5));
            }
            res1.last();
            int jumlahdata1 = res1.getRow();
            res1.first();
        }else{
            ResultSet res1=statement.executeQuery("select * from teknisi");
            
            while (res1.next()) {                
                cmbpesan.addItem(res1.getString(1)+" | "+res1.getString(2)+" | "+res1.getString(5));
            }
            res1.last();
            int jumlahdata1 = res1.getRow();
            res1.first();
        }
            
            
        } catch (Exception e) {
        }
    }

    public void loadData(){
        
        try {
          Statement st = (Statement)Connect.GetConnection().createStatement(); 
          ResultSet res2=st.executeQuery("select * from transaksi order by no_order desc");
          res2.next();
          pesan.setText("No terakhir: "+res2.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(frTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
        DefaultTableModel models=new DefaultTableModel();
        models.addColumn("No Order");
        models.addColumn("Kode Barang");
        models.addColumn("Nama Barang");
        models.addColumn("Kode Teknisi");
        models.addColumn("Nama Teknisi");
        models.addColumn("Jumlah Ambil");
        models.addColumn("Tanggal Ambil");

        tabel.setModel(models);
        try {
        Statement statement=(Statement)Connect.GetConnection().createStatement();
        ResultSet res=statement.executeQuery("select transaksi.*, barang.nm_barang, teknisi.username from transaksi JOIN barang ON transaksi.kd_barang = barang.kd_barang JOIN teknisi on transaksi.kd_teknisi=teknisi.kode_teknisi");
        while(res.next())
        {
        models.addRow(new Object[]{
        res.getString("no_order"),
        res.getString("kd_barang"),
        res.getString("nm_barang"),
        res.getString("kd_teknisi"),
        res.getString("username"),
        res.getString("jml_ambil"),
        res.getString("tgl_ambil"),
        });
        tabel.setModel(models);
        }
        }catch (Exception e){
        JOptionPane.showMessageDialog(rootPane,"Tidak Ada Data");
        }
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        edit = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Print1 = new javax.swing.JButton();
        cmbBarang = new javax.swing.JComboBox<>();
        tambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnKembali = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtjml = new javax.swing.JTextField();
        Print = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtorder = new javax.swing.JTextField();
        cmbpesan = new javax.swing.JComboBox<>();
        pesan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel4.setText("Barang              :");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Form Transaksi");

        edit.setBackground(new java.awt.Color(0, 153, 204));
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pencil-9479.png"))); // NOI18N
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        Print1.setBackground(new java.awt.Color(0, 153, 204));
        Print1.setForeground(new java.awt.Color(255, 255, 255));
        Print1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/search-2911.png"))); // NOI18N
        Print1.setText("Search");
        Print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print1ActionPerformed(evt);
            }
        });

        cmbBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBarangActionPerformed(evt);
            }
        });

        tambah.setBackground(new java.awt.Color(0, 153, 204));
        tambah.setForeground(new java.awt.Color(255, 255, 255));
        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/plus-321.png"))); // NOI18N
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        jLabel6.setText("Pengambilan      :");

        hapus.setBackground(new java.awt.Color(0, 153, 204));
        hapus.setForeground(new java.awt.Color(255, 255, 255));
        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/trash-347.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        btnKembali.setBackground(new java.awt.Color(0, 153, 204));
        btnKembali.setForeground(new java.awt.Color(255, 255, 255));
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/exit-2860.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(0, 153, 204));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/convert-3215.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel7.setText("Jumlah Ambil     :");

        Print.setBackground(new java.awt.Color(0, 153, 204));
        Print.setForeground(new java.awt.Color(255, 255, 255));
        Print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer-1434.png"))); // NOI18N
        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });

        jLabel8.setText("No Order           :");

        cmbpesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbpesanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Print, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Print1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtjml, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addComponent(cmbBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbpesan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtorder, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbpesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtjml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah)
                    .addComponent(hapus)
                    .addComponent(btnKembali)
                    .addComponent(btnReset)
                    .addComponent(edit))
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Print1)
                    .addComponent(Print))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        try {
        String barang = (String)cmbBarang.getSelectedItem();
        String[] hasil = barang.split(" | ");
        String hsl_brg = hasil[0];
        String pesan = (String)cmbpesan.getSelectedItem();
        String[] hasilp = pesan.split(" | ");
        String hsl_psn = hasilp[0];
        
        String kode = txtorder.getText();
        int jml = Integer.parseInt(txtjml.getText());
        System.out.print(hsl_psn+" "+hsl_brg+" "+jml);
          Statement st = (Statement)Connect.GetConnection().createStatement(); 
          ResultSet res2=st.executeQuery("select * from transaksi where no_order='"+kode+"'");
          res2.next();
          int jml_belum= Integer.parseInt(res2.getString(4));
          
        Statement st1 = (Statement)Connect.GetConnection().createStatement(); 
          ResultSet res3=st1.executeQuery("select * from barang where kd_barang='"+hsl_brg+"'");
          res3.next();
          int jml_barang= Integer.parseInt(res3.getString(3));
          int total;
          if(jml>jml_belum){
              int hasil1 = jml - jml_belum;
              total = jml_barang - hasil1;
          }else{
              int hasil1 = jml_belum - jml;
              total = jml_barang + hasil1;
          }
        try{
                Statement stm = (Statement) Connect.GetConnection().createStatement();
                stm.execute("UPDATE transaksi SET "
                        + "kd_barang = '" + hsl_brg + "', "
                        + "kd_teknisi = '" + hsl_psn + "', "
                        + "jml_ambil = '" + jml + "'"
                    + "WHERE no_order = '" + kode + "';");
                stm.execute("UPDATE barang SET "
                        + "jml_barang = '" + total + "' "
                    + "WHERE kd_barang = '" + hsl_brg + "';");
                stm.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!","SIMPAN DATA",JOptionPane.INFORMATION_MESSAGE);
            }
            catch (Exception t){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!","SIMPAN DATA",JOptionPane.INFORMATION_MESSAGE);
            }
            loadData();
        } catch (SQLException ex) {
            Logger.getLogger(frTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        try {
        String barang = (String)cmbBarang.getSelectedItem();
        String[] hasil = barang.split(" | ");
        String hsl_brg = hasil[0];
        String pesan = (String)cmbpesan.getSelectedItem();
        String[] hasilp = pesan.split(" | ");
        String hsl_psn = hasilp[0];
        
        String kode = txtorder.getText();
        int jml = Integer.parseInt(txtjml.getText());
          
        Statement st1 = (Statement)Connect.GetConnection().createStatement(); 
          ResultSet res3=st1.executeQuery("select * from barang where kd_barang='"+hsl_brg+"'");
          res3.next();
          int jml_barang= Integer.parseInt(res3.getString(3));
          int total = jml_barang-jml;
          
            if("".equals(txtorder)){
                JOptionPane.showMessageDialog(null, "Harap Isi Semua Data!");
            } else{
                try{
                    Statement stm = (Statement) Connect.GetConnection().createStatement();
                    stm.execute("INSERT into transaksi VALUES ('" + kode + "','" + hsl_brg + "','"+ hsl_psn + "','"+ jml + "', null);");
                    stm.execute("UPDATE barang SET "
                        + "jml_barang = '" + total + "' "
                    + "WHERE kd_barang = '" + hsl_brg + "';");
                    stm.close();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!","SIMPAN DATA",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (Exception t){
                    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!","SIMPAN DATA",JOptionPane.INFORMATION_MESSAGE);
                }
                loadData();
            }
            } catch (SQLException ex) {
            Logger.getLogger(frTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tambahActionPerformed

    public void textKosong(){
        txtorder.setText("");
        
    }
    
    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try {
        String kode = txtorder.getText();
        int jml = Integer.parseInt(txtjml.getText());
        String barang = (String)cmbBarang.getSelectedItem();
        String[] hasil = barang.split(" | ");
        String hsl_brg = hasil[0];
        Statement st1 = (Statement)Connect.GetConnection().createStatement(); 
          ResultSet res3=st1.executeQuery("select * from barang where kd_barang='"+hsl_brg+"'");
          res3.next();
          int jml_barang= Integer.parseInt(res3.getString(3));
          int total = jml_barang+jml;
        int Pilih = JOptionPane.showConfirmDialog(null,"Anda Yakin Data Akan Dihapus??","HAPUS DATA",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(Pilih == JOptionPane.YES_OPTION){
            try{
                Statement stm = (Statement) Connect.GetConnection().createStatement();
                stm.execute("DELETE from transaksi WHERE no_order = '" + kode + "';");
                stm.execute("UPDATE barang SET "
                        + "jml_barang = '" + total + "' "
                    + "WHERE kd_barang = '" + hsl_brg + "';");
                stm.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
            }
            catch (Exception t){
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!");
            }
            loadData();
            row = 0;
        }
        else if(Pilih == JOptionPane.NO_OPTION){
        }
        } catch (SQLException ex) {
            Logger.getLogger(frTransaksi.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_hapusActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        setRowTbl();
        setField();
    }//GEN-LAST:event_tabelMouseClicked

    private void Print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print1ActionPerformed
        // TODO add your handling code here:
        try
        {
            Statement st = (Statement) Connect.GetConnection().createStatement();
            String search = Search.getText();
            ResultSet rs = st.executeQuery("select transaksi.*, barang.nm_barang, teknisi.username from transaksi JOIN barang ON transaksi.kd_barang = barang.kd_barang JOIN teknisi on transaksi.kd_teknisi=teknisi.kode_teknisi WHERE transaksi.no_order like '%"+search+"%' OR barang.nm_barang like '%"+search+"%' OR transaksi.jml_ambil like '%"+search+"%' OR teknisi.username like '%"+search+"%' OR barang.kd_barang like '%"+search+"%' OR teknisi.kode_teknisi like '%"+search+"%'");
            DefaultTableModel dtm = (DefaultTableModel) tabel.getModel();

            dtm.setRowCount(0);
            String [] data = new String[7];
            int i = 1;

            while(rs.next())
            {
                data[0] = rs.getString("no_order");
                data[1] = rs.getString("kd_barang");
                data[2] = rs.getString("nm_barang");
                data[3] = rs.getString("kd_teknisi");
                data[4] = rs.getString("username");
                data[5] = rs.getString("jml_ambil");
                data[6] = rs.getString("tgl_ambil");
                dtm.addRow(data);
                i++;
            }
            rs.close();
            Search.setText("");
        }
        catch(Exception ex)  {
            JOptionPane.showMessageDialog(null,"Data yang Anda cari Tidak dapat Ditemukan");
            System.err.println("error (search) : " +ex);
        }
    }//GEN-LAST:event_Print1ActionPerformed

    private void cmbBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBarangActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbBarangActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        textKosong();
    }//GEN-LAST:event_btnResetActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        // TODO add your handling code here:
        try{
            HashMap parameter = new HashMap();
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/db_tubes","root","");
            File file= new File("src/Form/Transaksi.jasper");
            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, cn);
            JasperViewer.viewReport(jp, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null,
                "Data Tidak Dapat di Cetak !!!!!"+"\n"+ e.getMessage(), "Cetak Data",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }                               
    }//GEN-LAST:event_PrintActionPerformed

    private void cmbpesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbpesanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbpesanActionPerformed

    public void setRowTbl(){
    row = tabel.getSelectedRow();
    }
    public void setField(){
    txtorder.setText((String)tabel.getValueAt(row,0));
    txtjml.setText((String)tabel.getValueAt(row,5));
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Print;
    private javax.swing.JButton Print1;
    private javax.swing.JTextField Search;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cmbBarang;
    private javax.swing.JComboBox<String> cmbpesan;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel pesan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField txtjml;
    private javax.swing.JTextField txtorder;
    // End of variables declaration//GEN-END:variables
}
