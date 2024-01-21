import javax.swing.*;
import java.awt.event.*;

public class Anasayfa extends JFrame {
    private JButton btn_dersOlustur;
    private JButton btn_ogrenciKayit;
    private javax.swing.JPanel JPanel;
    private JButton ogrtmnKayit;

    public Anasayfa() {
        //genel form özellikleri
        setTitle("Anasayfa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,  300);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(JPanel);

        //ders kayıt sayfasına yönlendirme
        btn_dersOlustur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ders oluşturma sayfasına giriş yap
                DersOlustur dersOlusturSayfasi = new DersOlustur();
                dersOlusturSayfasi.setVisible(true);

                //anasayfayı kapat
                setVisible(false);
            }
        });

        //öğrenci kayıt sayfasına yönlendirme
        btn_ogrenciKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //öğrenci oluşturma sayfasına giriş yap
                OgrenciKayit ogrenciKayitSayfasi = new OgrenciKayit();
                ogrenciKayitSayfasi.setVisible(true);

                //anasayfayı kapat
                setVisible(false);
            }
        });

        //öğretmen kayıt sayfasına giriş yapma
        ogrtmnKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //öğrenci oluşturma sayfasına giriş yap
                OgretmenKayit ogretmenkayitSayfasi = new OgretmenKayit();
                ogretmenkayitSayfasi.setVisible(true);

                //anasayfayı kapat
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new Anasayfa();
    }
}
