/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Frame;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author bangkun
 */
public class Admin extends javax.swing.JPanel {
    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    DefaultTableModel model;
    
    public Admin() {
        initComponents();
        koneksiDB db = new koneksiDB();
        db.connect();
        con = db.connection;
        stm = db.statement;  
        kosongkanForm();
        tampilkanData();
        btnsimpan.setEnabled(false);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
    }
    public void kosongkanForm(){
        txadmin.setText(null);
        txkaryawan.setText(null);
        txusername.setText(null);
        txpassword.setText(null);
    }
    public void tampilkanData(){
        model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("Id Admin");
        model.addColumn("Id Karyawan");
        model.addColumn("Username");
        model.addColumn("Password");
        
        try{
            int no = 1;
            sql = "Select * from admin";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                model.addRow(new Object[]{no++, rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
                tbAdmin.setModel(model);
                
            }
        }catch(SQLException e){
            System.out.println("ERROR : "+e.getMessage());
        }
    }

    public void idOtomatis(String tabel, int digitNol, int digitAngka){
        
        try {
            sql ="select id_"+tabel+" from "+tabel+" order by id_"+tabel+" desc";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                String cekID = rs.getString("id_"+tabel+"").substring(digitAngka);
                int AN =Integer.parseInt(cekID)+1;
                String id = Integer.toString(AN);
                String a = String.format("%0"+digitNol+"d", AN);
                if(tabel.equalsIgnoreCase("admin")){
                    txadmin.setText("AD"+a);
                }else if(tabel.equalsIgnoreCase("karyawan")){
                    txkaryawan.setText("KAR"+a);
                }
            }else{
                if(tabel.equalsIgnoreCase("admin")){
                    txadmin.setText("AD001");
                }else if(tabel.equalsIgnoreCase("karyawan")){
                    txkaryawan.setText("KAR01");
                }
                
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAdmin = new javax.swing.JTable();
        btntambah = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txadmin = new javax.swing.JTextField();
        txkaryawan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txusername = new javax.swing.JTextField();
        txpassword = new javax.swing.JTextField();
        txcari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("DATA ADMIN");

        tbAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        tbAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAdmin);

        btntambah.setBackground(new java.awt.Color(153, 153, 255));
        btntambah.setText("TAMBAH");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        btnsimpan.setBackground(new java.awt.Color(153, 153, 255));
        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(153, 153, 255));
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnhapus.setBackground(new java.awt.Color(153, 153, 255));
        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        jLabel2.setText("ID ADMIN");

        jLabel3.setText("ID KARYAWAN");

        txadmin.setEnabled(false);

        txkaryawan.setEnabled(false);

        jLabel4.setText("USERNAME");

        jLabel5.setText("PASSWORD");

        txcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txcariKeyReleased(evt);
            }
        });

        jLabel6.setText("Cari : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txadmin)
                                    .addComponent(txkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(28, 28, 28)
                                        .addComponent(txusername, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txcari, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntambah)
                                    .addGap(78, 78, 78)
                                    .addComponent(btnsimpan)
                                    .addGap(56, 56, 56)
                                    .addComponent(btnedit)
                                    .addGap(77, 77, 77)
                                    .addComponent(btnhapus))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 236, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txkaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntambah)
                    .addComponent(btnsimpan)
                    .addComponent(btnedit)
                    .addComponent(btnhapus))
                .addGap(127, 127, 127))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        btnsimpan.setEnabled(false);
        btntambah.setEnabled(true);    
        if (btnsimpan.getText().equalsIgnoreCase("BATAL")){
                kosongkanForm();
                btnsimpan.setText("SIMPAN");
                btnsimpan.setEnabled(false);
                btnedit.setEnabled(false);
                btnhapus.setEnabled(false);
                
        }else if(btnsimpan.getText().equalsIgnoreCase("SIMPAN")){
            try {
                sql = "INSERT INTO admin VALUES ('"+txadmin.getText()+"','"+txkaryawan.getText()+"','"+txusername.getText()+"','"+txpassword.getText()+"')";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
                tampilkanData();
                kosongkanForm();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Data gagal disimpan, "+ e.getMessage());
            }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
       if(btntambah.getText().equalsIgnoreCase("TAMBAH")){
            idOtomatis("admin",3,2);
            idOtomatis("karyawan",2,3);
            btnsimpan.setText("SIMPAN");
            btntambah.setText("REFRESH");
            btnsimpan.setEnabled(true);
        }else if(btntambah.getText().equalsIgnoreCase("REFRESH")){
            btntambah.setText("TAMBAH");
            DefaultTableModel model = (DefaultTableModel)tbAdmin.getModel();
            model.setRowCount(0);
            tampilkanData();
            kosongkanForm();
            btnsimpan.setEnabled(false);
        }
    }//GEN-LAST:event_btntambahActionPerformed

    private void tbAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAdminMouseClicked
        txadmin.setText(tbAdmin.getValueAt(tbAdmin.getSelectedRow(), 1).toString());
        txkaryawan.setText(tbAdmin.getValueAt(tbAdmin.getSelectedRow(), 2).toString());
        txusername.setText(tbAdmin.getValueAt(tbAdmin.getSelectedRow(), 3).toString());
        txpassword.setText(tbAdmin.getValueAt(tbAdmin.getSelectedRow(), 4).toString());
        btntambah.setEnabled(false);
        btnedit.setEnabled(true);
        btnhapus.setEnabled(true);
        btnsimpan.setEnabled(true);
        btnsimpan.setText("BATAL");
    }//GEN-LAST:event_tbAdminMouseClicked

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
            btntambah.setEnabled(true);
            btnsimpan.setEnabled(false);
            btnedit.setEnabled(false);
            btnhapus.setEnabled(false);
        try{
            sql = "update admin set id_karyawan='"+txkaryawan.getText()+"',username='"+txusername.getText()+"',password='"+txpassword.getText()+"' where id_admin ='"+txadmin.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            tampilkanData();
            kosongkanForm();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data gagal diupdate, "+ e.getMessage());
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        btntambah.setEnabled(true);
        btnsimpan.setEnabled(false);
        btnedit.setEnabled(false);
        btnhapus.setEnabled(false);
        try {
            sql = "delete from admin where id_admin='"+txadmin.getText()+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            tampilkanData();
            kosongkanForm();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data gagal dihapus, "+ e.getMessage());
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txcariKeyReleased
        String cari = txcari.getText();
        TableRowSorter tr = new TableRowSorter(model);
        tbAdmin.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(cari)); 
    }//GEN-LAST:event_txcariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAdmin;
    private javax.swing.JTextField txadmin;
    private javax.swing.JTextField txcari;
    private javax.swing.JTextField txkaryawan;
    private javax.swing.JTextField txpassword;
    private javax.swing.JTextField txusername;
    // End of variables declaration//GEN-END:variables
}
