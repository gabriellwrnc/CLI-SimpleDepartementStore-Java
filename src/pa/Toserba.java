/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa;

public abstract class Toserba implements utama {

    // overload
    public void notif(int stok, int hargaBarang) {
        System.out.println("Data Yang Telah Di Input Memiliki Stok " + stok +
                " Dengan Harga Satuan Sejumlah Rp." + hargaBarang);
    }

    public abstract void giat();

    private int tanggalMasuk;
    private int stok;
    private int harga;

    public Toserba(int Tanggal, int Stok, int Harga) {
        this.tanggalMasuk = Tanggal;
        this.stok = Stok;
        this.harga = Harga;
    }

    /**
     * @return the tanggalMasuk
     */
    public int getTanggalMasuk() {
        return tanggalMasuk;
    }

    /**
     * @param tanggalMasuk the tanggalMasuk to set
     */
    public void setTanggalMasuk(int tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    /**
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }
}

final class alatMasak extends Toserba {
    private String spesifikasiBarang, namaBarang;
    public final String tema = "Alat Masak";

    @Override
    public void giat() {
        System.out.println("--------------------------------------------");
        System.out.println("Berhasil Melakukan Perubahan Data Alat Masak");
    }

    public alatMasak(int Tanggal, int Stok, int Harga, String Nama, String spekB) {
        super(Tanggal, Stok, Harga);
        this.namaBarang = Nama;
        this.spesifikasiBarang = spekB;
    }

    /**
     * @return the spesifikasiBarang
     */
    public String getSpesifikasiBarang() {
        return spesifikasiBarang;
    }

    /**
     * @param spesifikasiBarang the spesifikasiBarang to set
     */
    public void setSpesifikasiBarang(String spesifikasiBarang) {
        this.spesifikasiBarang = spesifikasiBarang;
    }

    /**
     * @return the namaBarang
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getTema() {
        return tema;
    }

    public void tampil() {
        System.out.println("-- " + getNamaBarang() + " Di Masukkan Ke Data Kategori Alat Masak --");
    }

    public void ktg() {
        System.out.println("=======================================");
        System.out.println("Berhasil Menambahkan " + getNamaBarang() + " Ke Kategori Alat Masak");
    }

}

final class pengharumR extends Toserba {
    private String jenis, varian, merek;
    public final String tema = "Pengharum Ruangan";

    @Override
    public void giat() {
        System.out.println("-----------------------------------------------");
        System.out.println("Berhasil Melakukan Perubahan Data Pengharum Ruangan");
    }

    public pengharumR(int Tanggal, int Stok, int Harga, String Merek, String Jenis, String Varian) {
        super(Tanggal, Stok, Harga);
        this.merek = Merek;
        this.jenis = Jenis;
        this.varian = Varian;
    }

    /**
     * @return the jenis
     */
    public String getJenis() {
        return jenis;
    }

    /**
     * @param jenis the jenis to set
     */
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    /**
     * @return the varian
     */
    public String getVarian() {
        return varian;
    }

    /**
     * @param varian the varian to set
     */
    public void setVarian(String varian) {
        this.varian = varian;
    }

    /**
     * @return the merek
     */
    public String getMerek() {
        return merek;
    }

    /**
     * @param merek the merek to set
     */
    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTema() {
        return tema;
    }

    public void tampil() {
        System.out.println("-- " + jenis + " Di Masukkan ke Data Kategori Pengharum Ruangan --");
    }

    public void ktg() {
        System.out.println("================================================");
        System.out.println("Data Kategori Pengharum Ruangan Berhasil di Simpan");
    }
}
