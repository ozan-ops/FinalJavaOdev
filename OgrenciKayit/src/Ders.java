//ders sınıfının oluşturulması
public class Ders {
    private String dersAdi;
    private int dersKodu;
    private double dersKredi;
    private String dersSinifi;
    private String bolum;
    private String dersDili;
    private String ogretmenAdiSoyadi;

    public Ders(String dersAdi, int dersKodu, double dersKredi, String dersSinifi, String bolum, String dersDili, String ogretmenAdiSoyadi) {
        this.dersAdi = dersAdi;
        this.dersKodu = dersKodu;
        this.dersKredi = dersKredi;
        this.dersSinifi = dersSinifi;
        this.bolum = bolum;
        this.dersDili = dersDili;
        this.ogretmenAdiSoyadi = ogretmenAdiSoyadi;
    }

    public String getDersSinifi() {
        return dersSinifi;
    }

    public void setDersSinifi(String dersSinifi) {
        this.dersSinifi = dersSinifi;
    }

    public String getOgretmenAdiSoyadi() {
        return ogretmenAdiSoyadi;
    }

    public void setOgretmenAdiSoyadi(String ogretmenAdiSoyadi) {
        this.ogretmenAdiSoyadi = ogretmenAdiSoyadi;
    }

    public String toCSV() {
        //csv kayıt sıralamasını "Ders Kodu, Ders Adı, Ders Kredisi, Ders Durumu, Bölüm, Dil" olarak düzenleme
        return dersKodu + "," + dersAdi + "," + dersKredi + "," + dersSinifi + "," + bolum + "," + dersDili + "," + ogretmenAdiSoyadi;
    }
}
