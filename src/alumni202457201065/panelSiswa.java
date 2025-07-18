 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package alumni202457201065;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author sitin
 */
public class panelSiswa extends javax.swing.JPanel {
  



    /** Creates new form panelSiswa */
public panelSiswa() {
         initComponents();
         reset();
         load_table_siswa();
         comboKelas();
   
      }
void reset(){
        tNis.setText(null);
        tNamaSiswa.setText(null);
        cJenisKelamin.setSelectedItem(null);
        tTempatLahir.setText(null);
        tTanggal.setCalendar(null);
        tHp.setText(null);
        cKelas.setSelectedItem(null);
        tAlamat.setText(null);
        tFoto.setIcon(null);
        tFoto.setText("Foto");
        tFotoPath.setText(null);
}
void comboKelas(){

    try {
        String sql = "SELECT * FROM kelas";
        Connection conn = koneksi.konek();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            cKelas.addItem(resultSet.getString("id_kelas"));
        }
    } catch (SQLException e) {
    }
    cKelas.setSelectedItem(null);
}
void load_table_siswa(){
    DefaultTableModel model = new DefaultTableModel();

    model.addColumn("NIS");
    model.addColumn("Nama Siswa");
    model.addColumn("L/P");
    model.addColumn("Tempat Lahir");
    model.addColumn("Tgl Lahir");
    model.addColumn("Kelas");
    model.addColumn("Hp");
    model.addColumn("Alamat");
    
   String sql = "SELECT * FROM siswa";

     try {
        Connection conn = koneksi.konek();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()) {
            
            String nis = rs.getString("nis");
            String namaSiswa = rs.getString("nama_siswa");
            String jenisKelamin = rs.getString("gender");
            String tempatLahir = rs.getString("tempat_lahir");
            String tglLahir = rs.getString("tgl_lahir");
            String kelas = rs.getString("id_kelas");
            String hp = rs.getString("no_hp");
            
            Object[] baris = {nis, namaSiswa, jenisKelamin, tempatLahir, tglLahir, kelas, hp};
            model.addRow(baris);
            
        }
    } catch (SQLException sQLException) {
JOptionPane.showMessageDialog(null,"Gagal mengambil data!");
         System.out.println(sQLException);
    }
tblSiswa.setModel(model);
}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSiswa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSiswa = new javax.swing.JTable();
        bTambah1 = new javax.swing.JButton();
        bUbah1 = new javax.swing.JButton();
        bHapus1 = new javax.swing.JButton();
        bReset1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jExit = new javax.swing.JButton();
        tNis = new javax.swing.JTextField();
        tNamaSiswa = new javax.swing.JTextField();
        tTempatLahir = new javax.swing.JTextField();
        tAlamat = new javax.swing.JTextField();
        tHp = new javax.swing.JTextField();
        cJenisKelamin = new javax.swing.JComboBox<>();
        cKelas = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        tFoto = new javax.swing.JLabel();
        tFotoPath = new javax.swing.JLabel();
        tTanggal = new com.toedter.calendar.JDateChooser();

        tblSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "Nama Siswa", "Jenis Kelamin", "Tempat Lahir", "Hp", "Kelas", "Alamat", "Foto"
            }
        ));
        tblSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSiswaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSiswa);

        bTambah1.setBackground(new java.awt.Color(0, 204, 102));
        bTambah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumni202457201065/gambar/icons8-plus-20.png"))); // NOI18N
        bTambah1.setText("Tambah");
        bTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambah1ActionPerformed(evt);
            }
        });

        bUbah1.setBackground(new java.awt.Color(255, 204, 51));
        bUbah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumni202457201065/gambar/icons8-modify-20.png"))); // NOI18N
        bUbah1.setText("Ubah");
        bUbah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah1ActionPerformed(evt);
            }
        });

        bHapus1.setBackground(new java.awt.Color(255, 51, 51));
        bHapus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumni202457201065/gambar/icons8-delete-20.png"))); // NOI18N
        bHapus1.setText("Hapus");
        bHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus1ActionPerformed(evt);
            }
        });

        bReset1.setBackground(new java.awt.Color(51, 153, 235));
        bReset1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumni202457201065/gambar/icons8-change-20.png"))); // NOI18N
        bReset1.setText("Reset");
        bReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReset1ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(102, 153, 255));

        jLabel14.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Data Siswa");

        jExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumni202457201065/gambar/icons8-exit-48.png"))); // NOI18N
        jExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 856, Short.MAX_VALUE)
                .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tAlamat.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        cJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        cKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));

        jLabel15.setText("NIS");

        jLabel16.setText("Nama");

        jLabel17.setText("Jenis Kelamin");

        jLabel18.setText("Tempat Lahir");

        jLabel19.setText("Tanggal Lahir");

        jLabel20.setText("Hp");

        jLabel21.setText("Kelas");

        jLabel22.setText("Alamat");

        tFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tFoto.setText("Foto");
        tFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tFotoMouseClicked(evt);
            }
        });

        tFotoPath.setForeground(new java.awt.Color(242, 242, 242));
        tFotoPath.setText("jLabel1");

        tTanggal.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout panelSiswaLayout = new javax.swing.GroupLayout(panelSiswa);
        panelSiswa.setLayout(panelSiswaLayout);
        panelSiswaLayout.setHorizontalGroup(
            panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSiswaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSiswaLayout.createSequentialGroup()
                        .addComponent(bTambah1)
                        .addGap(16, 16, 16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tNis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addComponent(tNamaSiswa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addComponent(cJenisKelamin, javax.swing.GroupLayout.Alignment.TRAILING, 0, 282, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addComponent(tTempatLahir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tTanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelSiswaLayout.createSequentialGroup()
                        .addComponent(bUbah1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(bHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(tHp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(322, 322, 322))
            .addGroup(panelSiswaLayout.createSequentialGroup()
                .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSiswaLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tFotoPath)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSiswaLayout.setVerticalGroup(
            panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSiswaLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel15))
                .addGap(6, 6, 6)
                .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSiswaLayout.createSequentialGroup()
                        .addComponent(tNis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel16)
                        .addGap(1, 1, 1)
                        .addComponent(tNamaSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel17)
                        .addGap(6, 6, 6)
                        .addComponent(cJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel18)
                        .addGap(6, 6, 6)
                        .addComponent(tTempatLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelSiswaLayout.createSequentialGroup()
                        .addComponent(tHp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel21)
                        .addGap(1, 1, 1)
                        .addComponent(cKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addGap(6, 6, 6)
                        .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(panelSiswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bUbah1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tFotoPath)
                .addContainerGap(498, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReset1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_bReset1ActionPerformed

    private void bHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus1ActionPerformed
        // TODO add your handling code here:
        try {
            String nis = tNis.getText();
            String sql = "DELETE FROM siswa WHERE nis=?";
            
            Connection conn = koneksi.konek();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nis);
            statement.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil dihspus!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
        }
        load_table_siswa();
        reset();
         
        
    }//GEN-LAST:event_bHapus1ActionPerformed

    private void bUbah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah1ActionPerformed
        // TODO add your handling code here:
        // Mengambil NIS dari field input
            String nis = tNis.getText();

            // Mengambil Nama Siswa dari field input
            String namaSiswa = tNamaSiswa.getText();

            // Mengambil nilai dari combo box jenis kelamin dan mengubah menjadi String
            String jenisKelamin = cJenisKelamin.getSelectedItem().toString();

            // Variabel untuk menyimpan kode jenis kelamin ('L' atau 'P')
            String jK = null;

            // Mengambil Tempat Lahir dari field input
            String tempatLahir = tTempatLahir.getText();

            // Mengambil tanggal lahir dari komponen kalender
            Date tglLahirDate = tTanggal.getDate();

            // Mengubah tanggal lahir menjadi format "yyyy-MM-dd"
            String tglLahir = new SimpleDateFormat("yyyy-MM-dd").format(tglLahirDate);

            // Mengambil Nomor HP dari field input
            String hp = tHp.getText();

            // Mengambil Kelas dari combo box
            String kelas = cKelas.getSelectedItem().toString();

            // Mengambil Alamat dari field input
            String alamat = tAlamat.getText();

            // Mengambil path file foto dari field input tersembunyi
            String filePath = tFotoPath.getText();

            // Mengonversi pilihan jenis kelamin ke kode (L/P)
            switch (jenisKelamin) {
                case "Laki - laki":
                    jK = "L";
                    break;
                case "Perempuan":
                    jK = "P";
                    break;
                default:
                    jK = null;
                    break;
            }

            // Variabel untuk menyimpan path foto asli yang tersimpan di database
            String fotoAsli = null;

            try {
                // Query untuk mengambil path foto berdasarkan NIS
                String sql = "SELECT foto FROM siswa WHERE nis = ?";
                Connection conn = koneksi.konek();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nis);
                ResultSet rs = ps.executeQuery();

                // Jika data ditemukan, simpan path foto ke variabel fotoAsli
                if (rs.next()) {
                    fotoAsli = rs.getString("foto");
                }
            } catch (SQLException e) {
                // Tampilkan pesan jika gagal mengambil foto dari database
                JOptionPane.showMessageDialog(null, "Gagal mengambil foto asli: " + e.getMessage());
            }

            // Menentukan apakah foto diubah oleh pengguna
            boolean fotoDiubah = (fotoAsli == null && !filePath.isEmpty())
                    || (fotoAsli != null && !fotoAsli.equals(filePath));

            // Jika foto diubah, variabel 'foto' akan diisi dengan path baru
            String foto = fotoAsli;

            if (fotoDiubah) {
                try {
                    // Ambil file dari path baru
                    File sourceFile = new File(filePath);

                    // Dapatkan ekstensi file
                    String extension = filePath.substring(filePath.lastIndexOf('.') + 1);

                    // Buat nama file baru berdasarkan waktu agar unik
                    String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                    String destinationPath = "src/foto/foto-" + timestamp + "." + extension;

                    // Salin file ke folder tujuan
                    File destFile = new File(destinationPath);
                    Files.copy(sourceFile.toPath(), destFile.toPath());

                    // Simpan path tujuan ke variabel 'foto'
                    foto = destinationPath;

                } catch (Exception e) {
                    // Tampilkan pesan jika gagal upload file
                    JOptionPane.showMessageDialog(null, "Gagal upload file: " + e.getMessage());
                }
            }

            try {
                // Query SQL berbeda tergantung apakah foto diubah atau tidak
                String sql2;
                if (fotoDiubah) {
                    sql2 = "UPDATE siswa SET nama_siswa=?, gender=?, tempat_lahir=?, "
                            + "tgl_lahir=?, alamat=?, no_hp=?, id_kelas=?, foto=? WHERE nis=?";
                } else {
                    sql2 = "UPDATE siswa SET nama_siswa=?, gender=?, tempat_lahir=?, "
                            + "tgl_lahir=?, alamat=?, no_hp=?, id_kelas=? WHERE nis=?";
                }

                // Membuka koneksi ke database
                Connection conn = koneksi.konek();

                // Menyiapkan statement untuk eksekusi SQL
                PreparedStatement statement = conn.prepareStatement(sql2);

                // Menetapkan parameter umum
                statement.setString(1, namaSiswa);
                statement.setString(2, jK);
                statement.setString(3, tempatLahir);
                statement.setString(4, tglLahir);
                statement.setString(5, alamat);
                statement.setString(6, hp);
                statement.setString(7, kelas);

                // Jika foto diubah, tetapkan parameter tambahan
                if (fotoDiubah) {
                    statement.setString(8, foto);
                    statement.setString(9, nis);
                } else {
                    statement.setString(8, nis);
                }

                // Eksekusi perintah update
                statement.execute();

                // Tampilkan pesan sukses
                JOptionPane.showMessageDialog(null, "Data berhasil diubah!");

            } catch (SQLException e) {
                // Tampilkan pesan jika update gagal
                JOptionPane.showMessageDialog(null, "Gagal memperbarui data: " + e.getMessage());
            }

            // Muat ulang tabel agar perubahan terlihat
            load_table_siswa();

            // Kosongkan form setelah proses selesai
            reset();
    }//GEN-LAST:event_bUbah1ActionPerformed

    private void bTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambah1ActionPerformed
        // TODO add your handling code here:
        // Mengambil teks dari field NIS
        String nis = tNis.getText();

        // Mengambil teks dari field Nama Siswa
        String namaSiswa = tNamaSiswa.getText();

        // Mengambil item yang dipilih dari combo box jenis kelamin dan mengubahnya menjadi string
        String jenisKelamin = cJenisKelamin.getSelectedItem().toString();

        // Variabel untuk menyimpan hasil konversi jenis kelamin (L/P)
        String jK = null;

        // Mengambil teks dari field Tempat Lahir
        String tempatLahir = tTempatLahir.getText();

        // Mengambil tanggal dari komponen kalender
        Date tglLahirDate = tTanggal.getDate();

        // Mengubah tanggal lahir menjadi format "yyyy-MM-dd"
        String tglLahir = new SimpleDateFormat("yyyy-MM-dd").format(tglLahirDate);

        // Mengambil teks dari field nomor HP
        String hp = tHp.getText();

        // Mengambil item yang dipilih dari combo box kelas
        String kelas = cKelas.getSelectedItem().toString();

        // Mengambil teks dari field alamat
        String alamat = tAlamat.getText();

        // Mengambil path file dari label path foto
        String filePath = tFotoPath.getText();

        // Konversi jenis kelamin dari teks menjadi kode (L atau P)
        switch (jenisKelamin) {
            case "Laki - laki":
                jK = "L";
                break;
            case "Perempuan":
                jK = "P";
                break;
            default:
                jK = null;
                break;
        }

        // Variabel untuk menyimpan path file foto tujuan
        String foto = null;

        // Mengecek apakah ada path file foto yang dipilih
        if (filePath.length() != 0) {
            try {
                // Menyimpan path sumber file
                String sourcePath = filePath;
                File sourceFile = new File(sourcePath);

                // Menentukan folder tujuan untuk menyimpan foto
                String destinationFolderPath = "src/foto/";
                File destinationFolder = new File(destinationFolderPath);

                // Jika folder tujuan belum ada, buat folder tersebut
                if (!destinationFolder.exists()) {
                    destinationFolder.mkdir();
                }

                // Mengambil ekstensi file (contoh: jpg, png, dll)
                String extension = sourcePath.substring(sourcePath.lastIndexOf('.') + 1);

                // Membuat nama file baru yang unik berdasarkan timestamp
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String destinationFileName = "foto-" + timestamp + "." + extension;

                // Membuat file tujuan dengan path dan nama file baru
                File destinationFile = new File(destinationFolderPath + destinationFileName);

                // Menyalin file dari sumber ke tujuan
                Files.copy(sourceFile.toPath(), destinationFile.toPath());

                // Menyimpan path foto yang telah dipindahkan
                foto = destinationFile.getPath();

            } catch (Exception e) {
                // Menampilkan pesan error jika gagal mengupload file
                JOptionPane.showMessageDialog(null, "Gagal upload file: " + e.getMessage());
            }
        } else {
            // Jika tidak ada file yang dipilih, set null
            foto = null;
        }

        try {
            // Query SQL untuk menyimpan data siswa ke database
            String sql = "INSERT INTO siswa(nis,nama_siswa,gender,tempat_lahir,tgl_lahir,alamat,no_hp,id_kelas,foto)"
                    + " VALUES(?,?,?,?,?,?,?,?,?)";

            // Membuka koneksi ke database
            Connection conn = koneksi.konek();

            // Menyiapkan statement SQL dengan parameter
            PreparedStatement statement = conn.prepareStatement(sql);

            // Mengisi nilai parameter satu per satu
            statement.setString(1, nis);
            statement.setString(2, namaSiswa);
            statement.setString(3, jK);
            statement.setString(4, tempatLahir);
            statement.setString(5, tglLahir);
            statement.setString(6, alamat);
            statement.setString(7, hp);
            statement.setString(8, kelas);
            statement.setString(9, foto);

            // Menjalankan query penyimpanan
            statement.execute();

            // Menampilkan pesan bahwa data berhasil disimpan
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        } catch (SQLException e) {
            // Menampilkan pesan jika terjadi kesalahan saat menyimpan data
            JOptionPane.showMessageDialog(null, "Data gagal disimpan!");
        }

        // Memuat ulang data siswa ke tabel
        load_table_siswa();

        // Mengosongkan semua input form setelah data disimpan
        reset();
    }//GEN-LAST:event_bTambah1ActionPerformed

    private void jExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExitActionPerformed
        // TODO add your handling code here:
        panelSiswa.setVisible(false);
    }//GEN-LAST:event_jExitActionPerformed

    private void tblSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSiswaMouseClicked
        // TODO add your handling code here:
      // Mengambil indeks baris yang diklik pada tabel siswa
int baris = tblSiswa.rowAtPoint(evt.getPoint());

// Mengambil nilai dari kolom pertama (NIS) pada baris yang diklik dan mengubah ke String
String nis = tblSiswa.getValueAt(baris, 0).toString();

// Mengambil nilai dari kolom kedua (Nama Siswa)
String namaSiswa = tblSiswa.getValueAt(baris, 1).toString();

// Mengambil objek dari kolom ketiga (Jenis Kelamin)
Object jkObj = tblSiswa.getValueAt(baris, 2);

// Mengambil objek dari kolom keempat (Tempat Lahir)
Object tempatObj = tblSiswa.getValueAt(baris, 3);

// Mengambil objek dari kolom kelima (Tanggal Lahir)
Object tglObj = tblSiswa.getValueAt(baris, 4);

// Mengambil objek dari kolom keenam (Kelas)
Object kelasObj = tblSiswa.getValueAt(baris, 5);

// Mengambil objek dari kolom ketujuh (Nomor HP)
Object hpObj = tblSiswa.getValueAt(baris, 6);

// Menampilkan nilai NIS pada field input dan membuatnya tidak bisa diubah
tNis.setText(nis);
tNis.setEditable(false);

// Menampilkan nama siswa ke field input
tNamaSiswa.setText(namaSiswa);

// Mengonversi objek menjadi string, jika null maka hasilnya null atau string kosong
String jenisKelamin = (jkObj != null) ? jkObj.toString() : null;
String tempatLahir = (tempatObj != null) ? tempatObj.toString() : "";
String tglLahir = (tglObj != null) ? tglObj.toString() : null;
String idKelas = (kelasObj != null) ? kelasObj.toString() : null;
String noHP = (hpObj != null) ? hpObj.toString() : "";

// Menampilkan tempat lahir, no HP, dan memilih kelas sesuai data
tTempatLahir.setText(tempatLahir);
tHp.setText(noHP);
cKelas.setSelectedItem(idKelas);

// Jika tanggal lahir tidak null dan tidak kosong, ubah ke format Date dan tampilkan di komponen kalender
if (tglLahir != null && !tglLahir.isEmpty()) {
    try {
        tTanggal.setDate(java.sql.Date.valueOf(tglLahir));
    } catch (IllegalArgumentException e) {
        // Jika gagal parsing tanggal, kosongkan field tanggal
        tTanggal.setDate(null);
    }
} else {
    tTanggal.setDate(null);
}

// Konversi kode jenis kelamin ke bentuk tampilan yang dipahami pengguna
switch (jenisKelamin) {
    case "L":
        cJenisKelamin.setSelectedItem("Laki - laki");
        break;
    case "P":
        cJenisKelamin.setSelectedItem("Perempuan");
        break;
    default:
        cJenisKelamin.setSelectedItem(null);
        break;
}

try {
    // Query untuk mengambil data alamat dan foto berdasarkan NIS
    String sql = "SELECT alamat, foto FROM siswa WHERE nis = ?";

    // Membuka koneksi ke database
    Connection conn = koneksi.konek();

    // Menyiapkan statement SQL dengan parameter
    PreparedStatement ps = conn.prepareStatement(sql);

    // Mengisi parameter dengan NIS
    ps.setString(1, nis);

    // Menjalankan query dan menyimpan hasilnya
    ResultSet rs = ps.executeQuery();

    // Jika data ditemukan
    if (rs.next()) {
        // Mengambil alamat dan foto dari hasil query
        String alamat = rs.getString("alamat");
        String foto = rs.getString("foto");

        // Menampilkan alamat ke field input
        tAlamat.setText(alamat);

        // Jika path foto tidak kosong, tampilkan gambar ke label foto
        if (foto != null && !foto.isEmpty()) {
            ImageIcon icon = new ImageIcon(foto);
            Image image = icon.getImage().getScaledInstance(tFoto.getWidth(), tFoto.getHeight(), Image.SCALE_SMOOTH);
            tFotoPath.setText(foto);
            tFoto.setText(null);
            tFoto.setIcon(new ImageIcon(image));
        } else {
            // Jika tidak ada foto, set teks "Foto" dan hapus icon
            tFoto.setText("Foto");
            tFoto.setIcon(null);
        }
    }
} catch (SQLException e) {
    // Menampilkan error ke konsol jika terjadi kesalahan SQL
    System.err.println(e.getMessage());
}

    }//GEN-LAST:event_tblSiswaMouseClicked

    private void tFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tFotoMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (file != null) {
                    ImageIcon icon = new ImageIcon(file.toString());
                    
                    Image image = icon.getImage().getScaledInstance(tFoto.getWidth(), tFoto.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon ic = new ImageIcon(image);
                    tFoto.setText(null);
                    tFoto.setIcon(ic);
                    
                    String filename = file.getAbsolutePath();
                    tFotoPath.setText(filename);
                }
            } else {
                System.out.println("Pemilihan file dibatalkan oleh pengguna.");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error Upload: " + e.getMessage());
        }
    }//GEN-LAST:event_tFotoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus1;
    private javax.swing.JButton bReset1;
    private javax.swing.JButton bTambah1;
    private javax.swing.JButton bUbah1;
    private javax.swing.JComboBox<String> cJenisKelamin;
    private javax.swing.JComboBox<String> cKelas;
    private javax.swing.JButton jExit;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelSiswa;
    private javax.swing.JTextField tAlamat;
    private javax.swing.JLabel tFoto;
    private javax.swing.JLabel tFotoPath;
    private javax.swing.JTextField tHp;
    private javax.swing.JTextField tNamaSiswa;
    private javax.swing.JTextField tNis;
    private com.toedter.calendar.JDateChooser tTanggal;
    private javax.swing.JTextField tTempatLahir;
    private javax.swing.JTable tblSiswa;
    // End of variables declaration//GEN-END:variables

}
