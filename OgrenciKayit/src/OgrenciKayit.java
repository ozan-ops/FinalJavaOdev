import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.*;

public class OgrenciKayit extends JFrame {

    private JButton btn_Anasayfa;
    private JButton btn_DersKayit;
    private JLabel baslik;
    private JLabel lbl_Tc;
    private JPasswordField psw_TC;
    private JLabel lbl_Ad;
    private JTextField txt_Ad;
    private JLabel lbl_Soyad;
    private JTextField txt_Soyad;
    private JButton btn_OgrKayit;
    private JLabel lbl_Sınıf;
    private JComboBox cmb_Sinif;
    private JLabel lbl_DTarih;
    private JFormattedTextField frmtted_DTarih;
    private JLabel lbl_telNo;
    private JFormattedTextField frmtted_TelNo;
    private JLabel lbl_Ders;
    private JLabel lbl_Bolum;
    private JTextField txt_Bolum;
    private JComboBox cmb_Ders;
    private JButton btn_Kaydet;
    private javax.swing.JPanel JPanel;
    private JLabel lbl_ogrNo;
    private JTextField txt_OgrNo;
    private JTextField txt_Ara;
    private JLabel lblAra;
    private JTable ogrenciTablo;

    public OgrenciKayit() {
        //form görüntüsü
        setTitle("Öğrenci Oluştur");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(JPanel);

        //anasayfaya yönlendirme
        btn_Anasayfa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Anasayfa anasayfa = new Anasayfa();
                anasayfa.setVisible(true);

                //ders oluştur sayfasını kapat
                setVisible(false);
            }
        });

        DefaultTableModel tableModel = new DefaultTableModel();

        //csv dosyasından verileri oku
        String csvFile = "kaynaklar/Ogrenciler.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // İlk satır başlıklar olduğu için başlıkları ayarla
            String line = br.readLine();
            String[] headers = line.split(",");
            tableModel.setColumnIdentifiers(headers);

            // Geri kalan satırları oku ve tabloya ekle
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(data);
            }

            // DersTablo'ya modeli ata
            ogrenciTablo.setModel(tableModel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //ders kayıt sayfasına yönlendirme
        btn_DersKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ders oluşturma sayfasına giriş yap
                DersOlustur dersOlusturSayfasi = new DersOlustur();
                dersOlusturSayfasi.setVisible(true);

                //anasayfayı kapat
                setVisible(false);
            }
        });

        // öğrenci kaydetme butonu
        btn_Kaydet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String tc = new String(psw_TC.getPassword());
                    String ad = txt_Ad.getText();
                    String soyad = txt_Soyad.getText();
                    String ogrNoStr = txt_OgrNo.getText();
                    String dtarih = frmtted_DTarih.getText();
                    String telNo = frmtted_TelNo.getText();
                    String sinif = cmb_Sinif.getSelectedItem().toString();

                    //herhangi bir alan boşsa hata mesajı göster
                    if (tc.isEmpty() || ad.isEmpty() || soyad.isEmpty() || ogrNoStr.isEmpty() || dtarih.isEmpty() || telNo.isEmpty()) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Lütfen tüm alanları doldurunuz.");
                        return;
                    }

                    //TC numarası kontrolü
                    if (tc.length() != 11 || !tc.matches("\\d+")) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Geçersiz TC numarası. TC numarası 11 haneli ve sayılardan oluşmalıdır.");
                        return;
                    }

                    //ad kontrolü
                    if (ad.isEmpty() || !ad.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Geçersiz ad. Ad sadece harflerden oluşmalıdır.");
                        return;
                    }

                    //soyad kontrolü
                    if (soyad.isEmpty() || !soyad.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Geçersiz soyad. Soyad sadece harflerden oluşmalıdır.");
                        return;
                    }

                    //öğrenci No kontrolü
                    if (ogrNoStr.isEmpty() || !ogrNoStr.matches("\\d+")) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Geçersiz öğrenci numarası. Öğrenci numarası sayılardan oluşmalıdır.");
                        return;
                    }

                    //doğum Tarihi kontrolü
                    if (!dtarih.matches("\\d{2}/\\d{2}/\\d{4}")) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Geçersiz doğum tarihi formatı. Doğum tarihi gün/ay/yıl formatında olmalıdır.");
                        return;
                    }

                    //telefon Numarası kontrolü
                    if (!telNo.matches("05\\d{2} \\d{3} \\d{2} \\d{2}")) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Geçersiz telefon numarası. Telefon numarası 05XX XXX XX XX formatında olmalıdır.");
                        return;
                    }

                    String ders = cmb_Ders.getSelectedItem().toString();

                    //tüm kontroller başarılı ise, öğrenci bilgilerini kaydet
                    Ogrenci ogrenci = new Ogrenci(tc, ad, soyad, sinif, dtarih, telNo, ders, ogrNoStr);

                    try {
                        kaydetOgrenciBilgileri(ogrenci);
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Öğrenci bilgileri başarıyla kaydedildi!");

                        // Yeni veriyi ekledikten sonra JTable'ı güncelle
                        tableModel.addRow(new String[]{tc, ad, soyad, ogrNoStr, sinif, dtarih, telNo, ders});
                        ogrenciTablo.setModel(tableModel);

                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(OgrenciKayit.this, "Hata: Öğrenci bilgileri kaydedilemedi.");
                        ex.printStackTrace();
                    }
                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //bölümde değişiklik olunca olacaklar
        txt_Bolum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Öğrencinin bölümünü al
                String ogrenciBolumu = txt_Bolum.getText();

                //bölüme ait dersleri getir ve combobox'ı güncelle
                try {
                    String[] dersler = getBolumeAitDersler(ogrenciBolumu);
                    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(dersler);
                    cmb_Ders.setModel(model);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(OgrenciKayit.this, "Hata: Dersler yüklenirken bir hata oluştu.");
                }
            }
        });

        //arama yapma
        txt_Ara.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                String searchText = txt_Ara.getText().toLowerCase();
                filterTableByOgrnciID(searchText);
            }
        });
    }

    //tabloyu filtreleyen işlev
    private void filterTableByOgrnciID(String searchText) {
        DefaultTableModel tableModel = (DefaultTableModel) ogrenciTablo.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        ogrenciTablo.setRowSorter(sorter);

        if (searchText.length() == 0) {
            sorter.setRowFilter(null);
        } else {

            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 0)); //Öğrenci No sütununa göre arama
        }
    }

    //bölüme ait dersleri getirme
    private String[] getBolumeAitDersler(String bolum) throws IOException {
        String dosyaYolu = "kaynaklar/Dersler.csv";
        String[] dersler = new String[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String dersBolumu = parts[4]; //dersin bölümü sütunu
                if (dersBolumu.equals(bolum)) {
                    String dersAdi = parts[1]; //dersin Adı sütunu
                    dersler = append(dersler, dersAdi);
                }
            }
        }

        return dersler;
    }

    //dizi genişletme
    private String[] append(String[] arr, String element) {
        String[] newArr = new String[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = element;
        return newArr;
    }

    //öğrenci bilgilerini kaydetme
    private void kaydetOgrenciBilgileri(Ogrenci ogrenci) throws IOException {
        //CSV dosyasına yazmak için BufferedWriter kullanma
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("kaynaklar/Ogrenciler.csv", true))) {

            //öğrenci bilgilerini CSV dosyasına yazma
            writer.write(ogrenci.toCSV());
            writer.newLine();
        }
    }

    public static void main(String[] args) {
        new OgrenciKayit();
    }
}
