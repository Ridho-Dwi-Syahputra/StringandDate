public class Barang {
    protected String kodeBarang; // Menggunakan tipe data String untuk menyimpan kode barang
    protected String namaBarang; // Menggunakan tipe data String untuk menyimpan nama barang
    protected double hargaBarang;

    public Barang(String kodeBarang, String namaBarang, double hargaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
    }

    public double hitungTotal(int jumlahBeli) {
        return hargaBarang * jumlahBeli;
    }

    @Override
    // Menggunakan metode String untuk menampilkan detail barang dalam format tertentu
    public String toString() {
        return "Nama Barang: " + namaBarang + "\n" +
               "Kode Barang: " + kodeBarang + "\n" +
               "Harga Barang: " + hargaBarang;
    }
}
