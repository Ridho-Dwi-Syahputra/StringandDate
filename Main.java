import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static int fakturCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        if (!login.logIn(scanner)) {
            System.out.println("Login gagal. Program dihentikan.");
            return;
        }

        System.out.println("Selamat Datang di Supermarket TefaMart");
        Date currentDate = new Date(); 
        // Membuat objek Date untuk mendapatkan waktu saat ini
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'pada' hh:mm:ss a zzz"); 
        // Menggunakan SimpleDateFormat untuk memformat waktu sesuai pola tertentu
        System.out.println("Tanggal dan Waktu: " + ft.format(currentDate)); 
        // Menampilkan tanggal dan waktu yang telah diformat

        String lanjut; // Menggunakan String untuk menyimpan jawaban user apakah ingin melanjutkan transaksi
        do {
            try {
                System.out.print("\nMasukkan Nama Barang: ");
                String namaBarang = scanner.nextLine().trim().toUpperCase(); 
                // Menggunakan String untuk menyimpan nama barang, diubah ke huruf kapital menggunakan toUpperCase()
                // trim() digunakan untuk menghapus spasi di awal dan akhir input

                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine().trim(); 
                // Menggunakan String untuk menyimpan kode barang, trim() untuk menghapus spasi di awal dan akhir input

                System.out.print("Masukkan Harga Barang: ");
                double hargaBarang = Double.parseDouble(scanner.nextLine()); 
                // Tidak menggunakan String langsung di sini, tetapi input diambil sebagai String dan diubah menjadi double

                if (hargaBarang <= 0) {
                    throw new IllegalArgumentException("Harga barang harus lebih dari 0!");
                }

                System.out.print("Masukkan Jumlah Beli: ");
                int jumlahBeli = Integer.parseInt(scanner.nextLine()); 
                // Tidak menggunakan String langsung di sini, tetapi input diambil sebagai String dan diubah menjadi int

                if (jumlahBeli <= 0) {
                    throw new IllegalArgumentException("Jumlah beli harus lebih dari 0!");
                }

                String noFaktur = "FTR" + String.format("%03d", fakturCounter++); 
                // Menggunakan String untuk menyimpan nomor faktur yang diformat dengan 3 digit angka
                Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

                System.out.println("\n+----------------------------------------------------+");
                System.out.println(transaksi); 
                // Menampilkan detail transaksi menggunakan metode toString dari kelas Transaksi
                System.out.println("+----------------------------------------------------+");
                System.out.println("Kasir: Ridho Dwi Syahputra");
                System.out.println("+----------------------------------------------------+");

            } catch (NumberFormatException e) {
                System.out.println("Error: Input harus berupa angka untuk harga barang atau jumlah beli!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Terjadi kesalahan yang tidak diketahui.");
            }

            System.out.print("\nApakah Anda ingin memasukkan transaksi lain? (YA/TIDAK): ");
            lanjut = scanner.nextLine().trim(); 
            // Menggunakan String untuk menyimpan jawaban user, trim() untuk menghapus spasi di awal dan akhir input
        } while (lanjut.equalsIgnoreCase("YA")); 
        // equalsIgnoreCase digunakan untuk membandingkan String tanpa memperhatikan huruf besar atau kecil

        scanner.close();
        System.out.println("Terima kasih telah menggunakan program ini.");
    }
}
