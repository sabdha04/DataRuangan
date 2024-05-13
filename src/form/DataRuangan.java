/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import java.sql.*; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
import java.awt.event.KeyEvent; 
import koneksi.koneksi;

/**
 *
 * @author sabdha
 */
public class DataRuangan extends javax.swing.JFrame {
private Connection conn = new koneksi().connect(); 
private DefaultTableModel tabmode; 
    /**
     * Creates new form DataRuangan
     */
    public DataRuangan() {
        initComponents();
        kosong(); 
        aktif(); 
        datatable();
        txtlokasi.disable();
        txtcatatan.disable();
    }
    protected void aktif(){ 
    txtkdruang.requestFocus(); 
    cbnama.setSelectedItem(null); 
    }
protected void kosong(){ 
          txtkdruang.setText(""); 
          cbnama.setSelectedItem(null); 
          txtlokasi.setText(""); 
          txtluas.setText(""); 
          txtkapasitas.setText(""); 
          txtharga.setText("");
          txtcatatan.setText("");
      }
protected void datatable(){ 
        Object[] Baris ={"Kode Ruangan","Nama Ruangan","Lokasi","Luas(m²)","Kapasitas","Harga Sewa","Catatan"}; 
          tabmode = new DefaultTableModel(null, Baris); 
          String cariitem=txtcari.getText(); 
        
          try { 
              String sql = "SELECT * FROM ruangan where kdruang like '%"+cariitem+"%' or nmruang like '%"+cariitem+"%' order by kdruang asc"; 
              java.sql.Statement stat = conn.createStatement(); 
              ResultSet hasil = stat.executeQuery(sql); 
              while (hasil.next()){ 
                  tabmode.addRow(new Object[]{ 
                    hasil.getString(1), 
                    hasil.getString(2), 
                    hasil.getString(3), 
                    hasil.getString(4), 
                    hasil.getString(5), 
                    hasil.getString(6),
                    hasil.getString(7) 
                }); 
              } 
              tableruang.setModel(tabmode); 
          } catch (Exception e) { 
               
          } 
}
 private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String sql = "insert into ruangan values (?,?,?,?,?,?,?)"; 
        try{ 
            PreparedStatement stat = conn.prepareStatement(sql); 
            stat.setString(1, txtkdruang.getText()); 
            stat.setString(2, cbnama.getSelectedItem().toString()); 
            stat.setString(3, txtlokasi.getText()); 
            stat.setString(4, txtluas.getText()); 
            stat.setString(5, txtkapasitas.getText()); 
            stat.setString(6, txtharga.getText()); 
            stat.setString(7, txtcatatan.getText()); 
         
            stat.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "data berhasil disimpan"); 
            kosong(); 
            txtkdruang.requestFocus(); 
        } 
        catch (SQLException e){ 
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e); 
        } 
        datatable(); 
    } 
  private void bubahActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try{ 
            String sql = "update ruangan set nmruang=?,lokasi=?,luas=?,kapasitas=?,harga=?,catatan=? where kdruang='"+txtkdruang.getText()+"'"; 
            PreparedStatement stat = conn.prepareStatement(sql); 
            stat.setString(1, cbnama.getSelectedItem().toString()); 
            stat.setString(2, txtlokasi.getText()); 
            stat.setString(3, txtluas.getText());
            stat.setString(4, txtkapasitas.getText()); 
            stat.setString(5, txtharga.getText()); 
            stat.setString(6, txtcatatan.getText()); 
 
            stat.executeUpdate(); 
            JOptionPane.showMessageDialog(null, "data berhasil diubah"); 
            kosong(); 
            txtkdruang.requestFocus(); 
        } 
        catch (SQLException e){ 
            JOptionPane.showMessageDialog(null, "data gagal diubah"+e); 
        }   
        datatable(); 
    }
  private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {                                        
        int ok = JOptionPane.showConfirmDialog(null,"hapus","konfirmasi dialog",JOptionPane.YES_NO_OPTION); 
        if (ok==0){ 
            String sql = "delete from ruangan where kdruang ='"+txtkdruang.getText()+"'"; 
            try{ 
                PreparedStatement stat = conn.prepareStatement(sql); 
                stat.executeUpdate(); 
                JOptionPane.showMessageDialog(null, "data berhasil dihapus"); 
                kosong(); 
                txtkdruang.requestFocus(); 
            } 
            catch (SQLException e){ 
                JOptionPane.showMessageDialog(null, "data gagal dihapus"+e); 
            } 
            datatable(); 
        }         
    } 
  private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {                                        
        kosong(); 
        datatable();         
 } 
  private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();         
    }
  private void tablebarangMouseClicked(java.awt.event.MouseEvent evt) {                                          
        int bar = tableruang.getSelectedRow(); 
        String a = tabmode.getValueAt(bar, 0).toString(); 
        String b = tabmode.getValueAt(bar, 1).toString(); 
        String c = tabmode.getValueAt(bar, 2).toString(); 
        String d = tabmode.getValueAt(bar, 3).toString(); 
        String e = tabmode.getValueAt(bar, 4).toString(); 
        String f = tabmode.getValueAt(bar, 5).toString(); 
        String g = tabmode.getValueAt(bar, 6).toString(); 
         
        txtkdruang.setText(a); 
        cbnama.setSelectedItem(b); 
        txtlokasi.setText(c); 
        txtluas.setText(d); 
        txtkapasitas.setText(e); 
        txtharga.setText(f); 
        txtcatatan.setText(g); 
}
 private void bcariActionPerformed(java.awt.event.ActionEvent evt) {                                       
        datatable(); 
    }
 private void txtcariKeyPressed(java.awt.event.KeyEvent evt) {                                    
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {      
            datatable(); 
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtkdruang = new javax.swing.JTextField();
        cbnama = new javax.swing.JComboBox<>();
        txtlokasi = new javax.swing.JTextField();
        txtluas = new javax.swing.JTextField();
        txtkapasitas = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableruang = new javax.swing.JTable();
        btncari = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        btnbatal = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtcatatan = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nama : Sabdha Putra Laudri");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        jLabel2.setText("Npm : 202143501480");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel3.setText("Data Ruangan ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jLabel4.setText("Kode Ruangan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel5.setText("Nama Ruangan ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel6.setText("Lokasi");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel7.setText("Luas m²");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel8.setText("Kapasitas");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel9.setText("Harga Sewa / Jam ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel10.setText("Catatan");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));
        getContentPane().add(txtkdruang, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, -1));

        cbnama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ruang Ballroom", "Ruang Laundry", "Ruang Gym", "Ruang Gudang" }));
        cbnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbnamaActionPerformed(evt);
            }
        });
        getContentPane().add(cbnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));
        getContentPane().add(txtlokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 200, -1));
        getContentPane().add(txtluas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, -1));
        getContentPane().add(txtkapasitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 200, -1));
        getContentPane().add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 200, -1));

        btnsimpan.setText("Save ");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, -1, -1));

        btnubah.setText("Edit");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });
        getContentPane().add(btnubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        btnhapus.setText("Delete");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Ruangan"));

        tableruang.setModel(new javax.swing.table.DefaultTableModel(
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
        tableruang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableruangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableruang);

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncari)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 810, 360));

        btnbatal.setText("Cancel");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnbatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        btnkeluar.setText("Exit");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        txtcatatan.setColumns(20);
        txtcatatan.setRows(5);
        jScrollPane2.setViewportView(txtcatatan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 240, 70));

        jLabel11.setText("Kelas : R6P");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbnamaActionPerformed
        // TODO add your handling code here:
        if(cbnama.getSelectedItem()=="Ruang Ballroom"){
          txtlokasi.setText("Lantai 10 no.23"); 
//          txtluas.setText("100"); 
//          txtkapasitas.setText("50"); 
//          txtharga.setText("500000");
          txtcatatan.setText("Dilarang merokok di dalam ruangan!!");
        }else if(cbnama.getSelectedItem()=="Ruang Laundry"){
          txtlokasi.setText("Lantai 2 no.4"); 
//          txtluas.setText("40"); 
//          txtkapasitas.setText("20"); 
//          txtharga.setText("50000");
          txtcatatan.setText("Dilarang membawa makanan dan minuman!!");
        }else if(cbnama.getSelectedItem()=="Ruang Gym"){
          txtlokasi.setText("Lantai 3 no.10"); 
//          txtluas.setText("80"); 
//          txtkapasitas.setText("40"); 
//          txtharga.setText("100000");
          txtcatatan.setText("Dilarang merusak alat-alat Gym!!");
        }else if(cbnama.getSelectedItem()=="Ruang Gudang"){
          txtlokasi.setText("Lantai 1 no.8"); 
//          txtluas.setText("50"); 
//          txtkapasitas.setText("25"); 
//          txtharga.setText("30000");
          txtcatatan.setText("Dilarang membawa barang yang termasuk kategori ilegal!!");
        }
    }//GEN-LAST:event_cbnamaActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        bsimpanActionPerformed(evt);
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
         bubahActionPerformed(evt);
    }//GEN-LAST:event_btnubahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         bhapusActionPerformed(evt);
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        // TODO add your handling code here:
         bbatalActionPerformed(evt);
    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
         bkeluarActionPerformed(evt);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        // TODO add your handling code here:
         bcariActionPerformed(evt);
    }//GEN-LAST:event_btncariActionPerformed

    private void tableruangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableruangMouseClicked
        // TODO add your handling code here:
         tablebarangMouseClicked(evt);
    }//GEN-LAST:event_tableruangMouseClicked
    
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
            java.util.logging.Logger.getLogger(DataRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataRuangan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> cbnama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableruang;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextArea txtcatatan;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtkapasitas;
    private javax.swing.JTextField txtkdruang;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtluas;
    // End of variables declaration//GEN-END:variables
}
