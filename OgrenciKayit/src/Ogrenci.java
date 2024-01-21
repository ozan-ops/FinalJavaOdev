public class Ogrenci {
    private String tc;
    private String ad;
    private String soyad;
    private String sinif;
    private String dogumTarihi;
    private String telefonNo;
    private String ders;
    private String ogrNo;  // Öğrenci numarası

    public Ogrenci(String tc, String ad, String soyad, String sinif, String dogumTarihi, String telefonNo, String ders, String ogrNo) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.sinif = sinif;
        this.dogumTarihi = dogumTarihi;
        this.telefonNo = telefonNo;
        this.ders = ders;
        this.ogrNo = ogrNo;
    }

    //CSV kaydetme
    public String toCSV() {
        return tc + "," + ad + "," + soyad + "," + ogrNo + "," + sinif + "," + dogumTarihi + "," + telefonNo + "," + ders;
    }
}
