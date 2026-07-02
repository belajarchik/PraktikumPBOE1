// Joshua Satria Kusuma
// 24060124130113
//　E1
package jdbc.program;

import jdbc.model.Mahasiswa;
import jdbc.service.MysqlMahasiswaService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * JFrameUtama — GUI utama untuk mengelola data mahasiswa via JDBC.
 *
 * Fitur yang tersedia:
 * - Ambil Semua Data (Read / getAll)
 * - Tambahkan mahasiswa baru (Create / add)
 * - Edit nama mahasiswa (Update)
 * - Hapus mahasiswa (Delete)
 * - Reset indeks auto-increment
 */
public class JFrameUtama extends JFrame {

    // -------------------------------------------------------------------------
    // Service layer
    // -------------------------------------------------------------------------
    private final MysqlMahasiswaService service = new MysqlMahasiswaService();

    // -------------------------------------------------------------------------
    // Komponen GUI — Tabel
    // -------------------------------------------------------------------------
    private final DefaultTableModel tableModel;
    private final JTable tabelMahasiswa;

    // -------------------------------------------------------------------------
    // Komponen GUI — Panel kanan (kontrol)
    // -------------------------------------------------------------------------
    private final JLabel lblJudul = new JLabel("Kelola Data Mahasiswa");
    private final JButton btnAmbilSemua = new JButton("Ambil Semua Data");

    // -- Tambah
    private final JLabel lblNama = new JLabel("nama :");
    private final JTextField tfNama = new JTextField(20);
    private final JButton btnTambah = new JButton("Tambahkan");

    // -- Edit
    private final JTextField tfEditId = new JTextField(5);
    private final JTextField tfEditNama = new JTextField(15);
    private final JButton btnEdit = new JButton("Edit");

    // -- Hapus
    private final JTextField tfHapusId = new JTextField(5);
    private final JTextField tfHapusNama = new JTextField(15);
    private final JButton btnHapus = new JButton("Hapus");

    // -- Reset
    private final JButton btnReset = new JButton("Reset Indeks");
    private final JLabel lblInfo = new JLabel("Index di reset ke 0");

    // =========================================================================
    // Constructor
    // =========================================================================
    public JFrameUtama() {
        super("Sistem Manajemen Data Mahasiswa");

        // -- Setup tabel --
        String[] kolom = { "ID", "NAMA" };
        tableModel = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false; // tabel hanya untuk tampilan
            }
        };
        tabelMahasiswa = new JTable(tableModel);
        tabelMahasiswa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelMahasiswa.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabelMahasiswa.getColumnModel().getColumn(1).setPreferredWidth(150);

        // Klik baris tabel → isi field edit & hapus otomatis
        tabelMahasiswa.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tabelMahasiswa.getSelectedRow();
                if (row >= 0) {
                    String id = tableModel.getValueAt(row, 0).toString();
                    String nama = tableModel.getValueAt(row, 1).toString();
                    tfEditId.setText(id);
                    tfEditNama.setText(nama);
                    tfHapusId.setText(id);
                    tfHapusNama.setText(nama);
                }
            }
        });

        // -- Layout --
        buildUI();

        // -- Event listeners --
        registerListeners();

        // -- Konfigurasi frame --
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                service.closeConnection();
                dispose();
                System.exit(0);
            }
        });

        pack();
        setMinimumSize(new Dimension(600, 420));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // =========================================================================
    // buildUI — Menyusun semua komponen ke dalam frame
    // =========================================================================
    private void buildUI() {
        setLayout(new BorderLayout(8, 8));

        // -- Panel kiri: tabel --
        JScrollPane scrollPane = new JScrollPane(tabelMahasiswa);
        scrollPane.setPreferredSize(new Dimension(200, 380));
        scrollPane.setBorder(BorderFactory.createTitledBorder("Data Mahasiswa"));
        add(scrollPane, BorderLayout.WEST);

        // -- Panel kanan: kontrol --
        JPanel panelKontrol = new JPanel();
        panelKontrol.setLayout(new BoxLayout(panelKontrol, BoxLayout.Y_AXIS));
        panelKontrol.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Judul
        lblJudul.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblJudul.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelKontrol.add(lblJudul);
        panelKontrol.add(Box.createVerticalStrut(10));

        // Tombol ambil semua
        btnAmbilSemua.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelKontrol.add(btnAmbilSemua);
        panelKontrol.add(Box.createVerticalStrut(12));

        // -- Tambah --
        panelKontrol.add(createSeparatorLabel("── Tambah ──"));
        lblNama.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelKontrol.add(lblNama);
        tfNama.setAlignmentX(Component.LEFT_ALIGNMENT);
        tfNama.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
        panelKontrol.add(tfNama);
        panelKontrol.add(Box.createVerticalStrut(4));
        btnTambah.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelKontrol.add(btnTambah);
        panelKontrol.add(Box.createVerticalStrut(12));

        // -- Edit --
        panelKontrol.add(createSeparatorLabel("── Edit ──"));
        JPanel panelEdit = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        tfEditId.setPreferredSize(new Dimension(50, 26));
        tfEditNama.setPreferredSize(new Dimension(160, 26));
        panelEdit.add(tfEditId);
        panelEdit.add(tfEditNama);
        panelEdit.add(btnEdit);
        panelEdit.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelKontrol.add(panelEdit);
        panelKontrol.add(Box.createVerticalStrut(8));

        // -- Hapus --
        panelKontrol.add(createSeparatorLabel("── Hapus ──"));
        JPanel panelHapus = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        tfHapusId.setPreferredSize(new Dimension(50, 26));
        tfHapusNama.setPreferredSize(new Dimension(160, 26));
        tfHapusNama.setEditable(false);
        tfHapusNama.setBackground(new Color(230, 230, 230));
        panelHapus.add(tfHapusId);
        panelHapus.add(tfHapusNama);
        panelHapus.add(btnHapus);
        panelHapus.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelKontrol.add(panelHapus);
        panelKontrol.add(Box.createVerticalStrut(12));

        // -- Reset --
        panelKontrol.add(createSeparatorLabel("── Lain-lain ──"));
        JPanel panelReset = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        panelReset.add(btnReset);
        panelReset.add(lblInfo);
        panelReset.setAlignmentX(Component.LEFT_ALIGNMENT);
        panelKontrol.add(panelReset);

        add(panelKontrol, BorderLayout.CENTER);
    }

    // =========================================================================
    // registerListeners — Mendaftarkan semua ActionListener
    // =========================================================================
    private void registerListeners() {

        // -- Ambil semua data --
        btnAmbilSemua.addActionListener(e -> refreshTabel());

        // -- Tambah mahasiswa --
        btnTambah.addActionListener(e -> {
            String nama = tfNama.getText().trim();
            if (nama.isEmpty()) {
                showWarning("Nama tidak boleh kosong.");
                return;
            }
            // id diabaikan karena AUTO_INCREMENT di database
            Mahasiswa mhs = new Mahasiswa(0, nama);
            service.add(mhs);
            tfNama.setText("");
            refreshTabel();
        });

        // -- Edit mahasiswa --
        btnEdit.addActionListener(e -> {
            String idStr = tfEditId.getText().trim();
            String nama = tfEditNama.getText().trim();
            if (idStr.isEmpty() || nama.isEmpty()) {
                showWarning("ID dan Nama harus diisi untuk edit.");
                return;
            }
            try {
                int id = Integer.parseInt(idStr);
                Mahasiswa mhs = service.getById(id);
                if (mhs == null) {
                    showWarning("Mahasiswa dengan ID " + id + " tidak ditemukan.");
                    return;
                }
                System.out.println("Akan diupdate data lama: " + mhs);
                mhs.setNama(nama);
                System.out.println("dengan data baru: " + mhs);
                service.update(mhs);
                clearEditHapusFields();
                refreshTabel();
            } catch (NumberFormatException ex) {
                showWarning("ID harus berupa angka.");
            }
        });

        // -- Hapus mahasiswa --
        btnHapus.addActionListener(e -> {
            String idStr = tfHapusId.getText().trim();
            if (idStr.isEmpty()) {
                showWarning("Sorot baris pada tabel atau isi ID untuk hapus.");
                return;
            }
            try {
                int id = Integer.parseInt(idStr);
                Mahasiswa mhs = service.getById(id);
                if (mhs == null) {
                    showWarning("Mahasiswa dengan ID " + id + " tidak ditemukan.");
                    return;
                }
                int konfirmasi = JOptionPane.showConfirmDialog(
                        this,
                        "Hapus mahasiswa: " + mhs + " ?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION);
                if (konfirmasi == JOptionPane.YES_OPTION) {
                    System.out.println("akan di delete: " + mhs);
                    service.delete(id);
                    clearEditHapusFields();
                    refreshTabel();
                }
            } catch (NumberFormatException ex) {
                showWarning("ID harus berupa angka.");
            }
        });

        // -- Reset indeks --
        btnReset.addActionListener(e -> {
            if (!service.isEmpty()) {
                showWarning("Tabel tidak kosong. Kosongkan tabel terlebih dahulu sebelum reset indeks.");
                return;
            }
            service.indexReset();
            lblInfo.setText("Index di reset ke 1");
            refreshTabel();
        });
    }

    // =========================================================================
    // Utilitas internal
    // =========================================================================

    /** Muat ulang semua data dari database ke tabel GUI */
    private void refreshTabel() {
        tableModel.setRowCount(0); // kosongkan baris lama
        List<Mahasiswa> list = service.getAll();
        for (Mahasiswa m : list) {
            tableModel.addRow(new Object[] { m.getId(), m.getNama() });
        }
    }

    /** Kosongkan field edit & hapus */
    private void clearEditHapusFields() {
        tfEditId.setText("");
        tfEditNama.setText("");
        tfHapusId.setText("");
        tfHapusNama.setText("");
    }

    /** Tampilkan dialog peringatan */
    private void showWarning(String pesan) {
        JOptionPane.showMessageDialog(this, pesan, "Peringatan", JOptionPane.WARNING_MESSAGE);
    }

    /** Buat label separator tipis */
    private JLabel createSeparatorLabel(String teks) {
        JLabel lbl = new JLabel(teks);
        lbl.setFont(new Font("SansSerif", Font.ITALIC, 11));
        lbl.setForeground(Color.GRAY);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lbl;
    }

    // =========================================================================
    // main — Entry point
    // =========================================================================
    public static void main(String[] args) {
        // Gunakan Look and Feel sistem agar tampilan lebih native
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
        }

        SwingUtilities.invokeLater(JFrameUtama::new);
    }
}
