public class Transaksi extends Barang {
    private String noFaktur; // Menggunakan String untuk menyimpan nomor faktur transaksi
    private int jumlahBeli;
    private double total;

    public Transaksi(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang);
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
        this.total = hitungTotal(jumlahBeli);
    }

    @Override
    // Menggunakan metode String untuk menampilkan detail transaksi
    public String toString() {
        return "No. Faktur: " + noFaktur + "\n" +
               "Kode Barang: " + kodeBarang + "\n" +
               "Nama Barang: " + namaBarang + "\n" +
               "Harga Barang: " + hargaBarang + "\n" +
               "Jumlah Beli: " + jumlahBeli + "\n" +
               "Total: " + total;
    }
}
