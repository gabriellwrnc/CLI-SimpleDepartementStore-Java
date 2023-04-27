package pa;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Pa {
    public static final void descData() {
        System.out.println("=========================================");
        System.out.println("Data Yang Telah Disimpan Di Dalam Sistem");
    }

    static ArrayList<alatMasak> amsk = new ArrayList<alatMasak>();
    static ArrayList<pengharumR> pRuang = new ArrayList<pengharumR>();
    static HashMap<String, User> users = new HashMap<>();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        User admin = new User("admin", "admin123", "admin");
        User user = new User("gabriel", "gabriel123", "user");
        alatMasak am = new alatMasak(20, 200, 20000, "Panci", "Stainless Steel");
        pengharumR pr = new pengharumR(20, 150, 15000, "Stella", "Spray", "Lavender");
        users.put(admin.getUsername(), admin);
        users.put(user.getUsername(), user);
        amsk.add(am);
        pRuang.add(pr);

        while (true) {
            System.out.println("\n------ T O S E R B A   N A D A R I E L ------");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit Program\n");
            System.out.print("Masukkan Pilihan Anda: ");
            try {
                int pilihanAuth = Integer.parseInt(br.readLine());
                System.out.println("\n\n");
                while (true) {
                    if (pilihanAuth == 1) {
                        System.out.println("\n------ L O G I N ------");
                        System.out.print("Username: ");
                        String username = br.readLine();
                        System.out.print("Password: ");
                        String password = br.readLine();
                        System.out.println("\n\n");

                        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
                            String accessLevel = users.get(username).getAccessLevel();
                            System.out.println("Login Berhasil !!");
                            System.out.println("Selamat Datang " + username + " !!");
                            if (accessLevel.equals("admin")) {
                                while (true) {
                                    System.out.println("\n------ Pendataan Toserba Nadariel ------");
                                    System.out.println("[1] Menambahkan Data Barang");
                                    System.out.println("[2] Menampilkan Data Barang");
                                    System.out.println("[3] Mengupdate Data Barang");
                                    System.out.println("[4] Menghapus Data Barang");
                                    System.out.println("[5] Logout Akun");
                                    System.out.println("[6] Exit Program\n");
                                    try {
                                        System.out.print("Masukkan Pilihan Anda: ");
                                        int pilihan = Integer.parseInt(br.readLine());
                                        System.out.println("\n\n");
                                        if (pilihan == 1) {
                                            create();
                                        } else if (pilihan == 2) {
                                            while (true) {
                                                try {
                                                    System.out.println("----- L I H A T -----");
                                                    System.out.print("[1] Data Alat Masak\n"
                                                            + "[2] Data Pengharum Ruangan\n"
                                                            + "Masukkan Pilihan Anda: ");
                                                    int choice = Integer.parseInt(br.readLine());
                                                    if (choice == 1) {
                                                        System.out.println("\n\n");
                                                        read();
                                                        descData();
                                                        break;
                                                    } else if (choice == 2) {
                                                        System.out.println("\n\n");
                                                        read2();
                                                        descData();
                                                        break;
                                                    } else {
                                                        System.out.println("\n");
                                                        System.out.println("Pilihan Anda Tidak Tersedia !!");
                                                        System.out.println("\n\n");
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println(
                                                            "Input yang diberikan tidak valid. Harap masukkan angka yang valid.");
                                                }

                                            }
                                        } else if (pilihan == 3) {
                                            System.out.println("\n\n");
                                            up();
                                        } else if (pilihan == 4) {
                                            System.out.println("\n\n");
                                            del();
                                        } else if (pilihan == 5) {
                                            System.out.println("Logout Berhasil !!");
                                            break;

                                        } else if (pilihan == 6) {
                                            exit();
                                            System.exit(0);
                                        } else {
                                            System.out.println("Pilihan Anda Tidak Tersedia !!");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println(
                                                "Input yang diberikan tidak valid. Harap masukkan angka yang valid.");
                                    }

                                }
                            } else if (accessLevel.equals("user")) {
                                while (true) {
                                    System.out.println("\n------ Penjualan Toserba Nadariel ------");
                                    System.out.println("[1] Pembelian barang");
                                    System.out.println("[2] Read barang");
                                    System.out.println("[3] Logout Akun");
                                    System.out.println("[4] Exit Program\n");
                                    try {
                                        System.out.print("Masukkan Pilihan Anda: ");
                                        int pil = Integer.parseInt(br.readLine());
                                        System.out.println("\n\n");
                                        if (pil == 1) {
                                            beli();
                                        } else if (pil == 2) {
                                            baca();
                                        } else if (pil == 3) {
                                            System.out.println("Logout Berhasil !!");
                                            break;
                                        } else if (pil == 4) {
                                            exit();
                                            System.exit(0);
                                        } else {
                                            System.out.println("Pilihan Anda Tidak Tersedia !!");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println(
                                                "Input yang diberikan tidak valid. Harap masukkan angka yang valid.");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Username atau password anda salah !!");
                        }
                    } else if (pilihanAuth == 2) {
                        System.out.println("\n------ R E G I S T E R ------");
                        System.out.print("Username: ");
                        String username = br.readLine();
                        System.out.print("Password: ");
                        String password = br.readLine();
                        String accessLevel = "user";
                        System.out.println("\n\n");

                        if (users.containsKey(username)) {
                            System.out.println("Username sudah terdaftar !!");
                        } else {
                            User newUser = new User(username, password, accessLevel);
                            users.put(username, newUser);
                            System.out.println("Register Berhasil !!");
                            System.out.println("Silahkan Lakukan Login");
                            break;
                        }
                    } else if (pilihanAuth == 3) {
                        exit();
                        System.exit(0);
                    } else {
                        System.out.println("Pilihan Anda Tidak Tersedia !!");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Input yang diberikan tidak valid. Harap masukkan angka yang valid.");
            }

        }
    }

    public static void create() throws IOException {

        System.out.println("--- K A T E G O R I ---");
        System.out.print("[1] Alat Masak\n"
                + "[2] Pengharum Ruangan\n"
                + "Masukkan Pilihan Anda: ");
        int plhn = Integer.parseInt(br.readLine());
        if (plhn == 1) {
            System.out.println("\n------ C R E A T E ------ ");

            System.out.println("Kategori: Alat Masak");

            System.out.print("Nama Barang: ");
            String namaBarang = br.readLine();

            System.out.print("Tanggal Masuk: ");
            int tanggalMasuk = Integer.parseInt(br.readLine());

            System.out.print("Stok Barang: ");
            int stok = Integer.parseInt(br.readLine());

            System.out.print("Harga Barang Satuan: ");
            int hargaBarang = Integer.parseInt(br.readLine());

            System.out.print("Spesifikasi Barang: ");
            String spek = br.readLine();
            alatMasak amk = new alatMasak(tanggalMasuk, stok, hargaBarang, namaBarang, spek);
            amsk.add(amk);
            System.out.println("\n");
            amk.notif(stok, hargaBarang); // OVERLOADING
            System.out.println("\n");
            amk.ktg();
            amk.tampil();
            System.out.println("\n\n");
        } else if (plhn == 2) {
            System.out.println("\n\n");
            System.out.println("------ C R E A T E ------ ");

            System.out.println("Kategori: Pengharum Ruangan");

            System.out.print("Merek Barang: ");
            String merekBrg = br.readLine();

            System.out.print("Tanggal Masuk: ");
            int tanggalMasuk = Integer.parseInt(br.readLine());

            System.out.print("Stok Barang: ");
            int stok = Integer.parseInt(br.readLine());

            System.out.print("Harga Barang Satuan: ");
            int hargaBarang = Integer.parseInt(br.readLine());

            System.out.print("Jenis Pengharum Ruangan: ");
            String jenis = br.readLine();

            System.out.print("Varian Pengharum Ruangan: ");
            String varian = br.readLine();

            pengharumR pR = new pengharumR(tanggalMasuk, stok, hargaBarang, merekBrg, jenis, varian);
            pRuang.add(pR);
            System.out.println("\n");
            pR.notif(stok, hargaBarang); // OVERLOADING
            System.out.println("\n");
            pR.ktg();
            pR.tampil();
            System.out.println("\n\n");
        } else {
            System.out.println("Pilihan Anda Tidak Tersedia !!");
            System.out.println("\n\n");
        }

    }

    public static void read() throws IOException {
        for (int i = 0; i < amsk.size(); i++) {
            System.out.println("\n\n");
            System.out.println("Barang nomor " + (i + 1));
            System.out.println("Kategori Barang: Alat Masak");
            System.out.println("Nama Barang: " + amsk.get(i).getNamaBarang());
            System.out.println("Tanggal Masuk: " + amsk.get(i).getTanggalMasuk());
            System.out.println("Stok Barang: " + amsk.get(i).getStok());
            System.out.println("Harga Persatuan: " + amsk.get(i).getHarga());
            System.out.println("Spek Barang: " + amsk.get(i).getSpesifikasiBarang());
            System.out.println("\n");
        }
    }

    public static void read2() throws IOException {
        for (int i = 0; i < pRuang.size(); i++) {
            System.out.println("\n\n");
            System.out.println("Barang nomor " + (i + 1));
            System.out.println("Kategori Barang: Pengharum Ruangan");
            System.out.println("Merek Barang: " + pRuang.get(i).getMerek());
            System.out.println("Tanggal Masuk: " + pRuang.get(i).getTanggalMasuk());
            System.out.println("Stok Barang: " + pRuang.get(i).getStok());
            System.out.println("Harga Persatuan: " + pRuang.get(i).getHarga());
            System.out.println("Jenis Barang: " + pRuang.get(i).getJenis());
            System.out.println("Varian Barang: " + pRuang.get(i).getVarian());
            System.out.println("\n");
        }
    }

    public static void up() throws IOException {
        while (true) {
            System.out.println("----- U P D A T E -----");
            System.out.print("[1] Update Data Alat Masak\n"
                    + "[2] Update Data Pengharum Ruangan\n"
                    + "masukkan Pilihan Anda: ");
            int ch = Integer.parseInt(br.readLine());
            if (ch == 1) {
                System.out.println("\n---- Data Alat Masak -----");
                for (int i = 0; i < amsk.size(); i++) {
                    System.out.println("Barang nomor " + (i + 1));
                    System.out.println("Kategori Barang: Alat Masak");
                    System.out.println("Nama Barang: " + amsk.get(i).getNamaBarang());
                    System.out.println("Tanggal Masuk: " + amsk.get(i).getTanggalMasuk());
                    System.out.println("Stok Barang: " + amsk.get(i).getStok());
                    System.out.println("Harga Persatuan: " + amsk.get(i).getHarga());
                    System.out.println("Spek Barang: " + amsk.get(i).getSpesifikasiBarang());
                    System.out.println("\n\n");
                }
                System.out.print("Nomor barang yang akan di update: ");
                int ubah = Integer.parseInt(br.readLine());
                if (ubah > 0 && ubah <= amsk.size()) {
                    System.out.println("\n\n");
                    System.out.println("Kategori: Alat Masak");
                    System.out.print("Nama Barang: ");
                    amsk.get(ubah - 1).setNamaBarang(br.readLine());
                    System.out.print("Tanggal Masuk: ");
                    amsk.get(ubah - 1).setTanggalMasuk(Integer.parseInt(br.readLine()));
                    System.out.print("Stok Barang: ");
                    amsk.get(ubah - 1).setStok(Integer.parseInt(br.readLine()));
                    System.out.print("Harga Barang: ");
                    amsk.get(ubah - 1).setHarga(Integer.parseInt(br.readLine()));
                    System.out.print("Spek Barang: ");
                    amsk.get(ubah - 1).setSpesifikasiBarang(br.readLine());
                    System.out.println("\n");
                    amsk.get(0).giat();
                    System.out.println("\n\n");
                    break;
                } else {
                    System.out.println("\n");
                    System.out.println("Nomor Barang Tidak Tersedia!!");
                    System.out.println("\n\n");
                }
            } else if (ch == 2) {
                System.out.println("\n---- Data Pengharum Ruangan ----");
                for (int i = 0; i < pRuang.size(); i++) {
                    System.out.println("Barang nomor " + (i + 1));
                    System.out.println("Kategori Barang: Pengharum Ruangan");
                    System.out.println("Merek Barang: " + pRuang.get(i).getMerek());
                    System.out.println("Tanggal Masuk: " + pRuang.get(i).getTanggalMasuk());
                    System.out.println("Stok Barang: " + pRuang.get(i).getStok());
                    System.out.println("Harga Persatuan: " + pRuang.get(i).getHarga());
                    System.out.println("Jenis Barang: " + pRuang.get(i).getJenis());
                    System.out.println("Varian Barang: " + pRuang.get(i).getVarian());
                    System.out.println("\n\n");
                }
                System.out.print("Nomor barang yang kan di update: ");
                int ubah = Integer.parseInt(br.readLine());
                if (ubah > 0 && ubah <= pRuang.size()) {
                    System.out.println("\n\n");
                    System.out.println("Kategori: Pengharum Ruangan");
                    System.out.print("Merek Barang: ");
                    pRuang.get(ubah - 1).setMerek(br.readLine());
                    System.out.print("Tanggal Masuk: ");
                    pRuang.get(ubah - 1).setTanggalMasuk(Integer.parseInt(br.readLine()));
                    System.out.print("Stok Barang: ");
                    pRuang.get(ubah - 1).setStok(Integer.parseInt(br.readLine()));
                    System.out.print("Harga Barang: ");
                    pRuang.get(ubah - 1).setHarga(Integer.parseInt(br.readLine()));
                    System.out.print("Jenis Barang: ");
                    pRuang.get(ubah - 1).setJenis(br.readLine());
                    System.out.print("Varian Barang: ");
                    pRuang.get(ubah - 1).setVarian(br.readLine());
                    System.out.println("\n");
                    pRuang.get(0).giat();
                    System.out.println("\n\n");
                    break;
                } else {
                    System.out.println("Nomor Barang Tidak Tersedia !!");
                }
            } else {
                System.out.println("\n");
                System.out.println("Pilihan Anda Tidak Tersedia !!");
                System.out.println("\n\n");
            }
        }
    }

    public static void del() throws IOException {
        while (true) {
            System.out.println("------ D E L E T E ------");
            System.out.print("[1] Delete Data Alat Masak\n"
                    + "[2] Delete Data Pengharum Ruangan\n"
                    + "Masukkan Pilihan Anda: ");
            int chs = Integer.parseInt(br.readLine());
            if (chs == 1) {
                System.out.println("\n---- Data Alat Masak -----");
                for (int i = 0; i < amsk.size(); i++) {
                    System.out.println("Barang nomor " + (i + 1));
                    System.out.println("Kategori Barang: Alat Masak");
                    System.out.println("Nama Barang: " + amsk.get(i).getNamaBarang());
                    System.out.println("Tanggal Masuk: " + amsk.get(i).getTanggalMasuk());
                    System.out.println("Stok Barang: " + amsk.get(i).getStok());
                    System.out.println("Harga Persatuan: " + amsk.get(i).getHarga());
                    System.out.println("Spek Barang: " + amsk.get(i).getSpesifikasiBarang());
                    System.out.println("\n\n");
                }
                System.out.print("Index yang akan dihapus: ");
                int delete = Integer.parseInt(br.readLine());
                if (delete > 0 && delete <= amsk.size()) {
                    System.out.println("\n");
                    amsk.get(0).giat();
                    amsk.remove(delete - 1);
                    System.out.println("\n\n");
                    break;
                } else {
                    System.out.println("\n");
                    System.out.println("Nomor Anda Tidak Tersedia !!");
                    System.out.println("\n\n");
                }

            } else if (chs == 2) {
                System.out.println("\n---- Data Pengharum Ruangan -----");
                for (int i = 0; i < pRuang.size(); i++) {
                    System.out.println("Barang nomor " + (i + 1));
                    System.out.println("Kategori Barang: Pengharum Ruangan");
                    System.out.println("Merek Barang: " + pRuang.get(i).getMerek());
                    System.out.println("Tanggal Masuk: " + pRuang.get(i).getTanggalMasuk());
                    System.out.println("Stok Barang: " + pRuang.get(i).getStok());
                    System.out.println("Harga Persatuan: " + pRuang.get(i).getHarga());
                    System.out.println("Jenis Barang: " + pRuang.get(i).getJenis());
                    System.out.println("Varian Barang: " + pRuang.get(i).getVarian());
                    System.out.println("\n\n");
                }
                System.out.print("Nomor barang yang akan dihapus: ");
                int delete = Integer.parseInt(br.readLine());
                if (delete > 0 && delete <= amsk.size()) {
                    System.out.println("\n");
                    amsk.get(0).giat();
                    amsk.remove(delete - 1);
                    System.out.println("\n\n");
                    break;
                } else {
                    System.out.println("\n");
                    System.out.println("Nomor Anda Tidak Tersedia !!");
                    System.out.println("\n\n");
                }
            } else {
                System.out.println("Pilihan Anda Tidak Tersedia !!");
            }
        }
    }

    public static void beli() throws IOException {
        while (true) {
            System.out.println("\n\n");
            System.out.println("---Selamat Datang Di Toserba Nadariel---");
            System.out.println("========================================");
            System.out.println("           Kategori Belanja          ");
            System.out.println("========================================");
            System.out.print("[1] Alat Masak\n"
                    + "[2] Pengharum Ruangan\n");
            System.out.print("Masukkan Pilihan Anda: ");
            int dplh = Integer.parseInt(br.readLine());
            System.out.println("\n");
            if (dplh == 1) {
                System.out.println("Barang Yang Tersedia: ");
                System.out.println("-----------------------\n");
                for (int i = 0; i < amsk.size(); i++) {
                    System.out.println("Barang nomor " + (i + 1));
                    System.out.println("Kategori Barang: Alat Masak");
                    System.out.println("Nama Barang: " + amsk.get(i).getNamaBarang());
                    System.out.println("Stok Barang: " + amsk.get(i).getStok());
                    System.out.println("Harga Persatuan: " + amsk.get(i).getHarga());
                    System.out.println("Spek Barang: " + amsk.get(i).getSpesifikasiBarang());
                    System.out.println("\n\n");

                }
                System.out.println("\n");
                System.out.print("Pilih Nomor Barang Yang Akan Dibeli: ");
                int brg = Integer.parseInt(br.readLine());
                if (brg > 0 && brg <= amsk.size()) {
                    amsk.get(brg - 1).getNamaBarang();
                    System.out.print("Stok Yang akan dibeli: ");
                    int stk = Integer.parseInt(br.readLine());
                    amsk.get(brg - 1).getStok();
                    if (stk > amsk.get(brg - 1).getStok()) {
                        System.out.println("Stok Kurang!!");
                        break;
                    } else if (stk <= amsk.get(brg - 1).getStok()) {
                        int itung = amsk.get(brg - 1).getStok() - stk;
                        int harga = stk * amsk.get(brg - 1).getHarga();
                        System.out.println("Stok Sisa:  " + itung);
                        System.out.println("Harga: " + harga);
                        System.out.println("Berhasil dibeli!!");
                        amsk.get(brg - 1).setStok(itung);
                        break;
                    }
                } else {
                    System.out.println("\n");
                    System.out.println("Nomor Tidak Tersedia!!");
                }
            } else if (dplh == 2) {
                System.out.println("Barang Yang Tersedia: ");
                System.out.println("-----------------------\n");
                for (int i = 0; i < pRuang.size(); i++) {
                    System.out.println("Barang nomor " + (i + 1));
                    System.out.println("Kategori Barang: Pengharum Ruangan");
                    System.out.println("Merek Barang: " + pRuang.get(i).getMerek());
                    System.out.println("Stok Barang: " + pRuang.get(i).getStok());
                    System.out.println("Harga Persatuan: " + pRuang.get(i).getHarga());
                    System.out.println("Jenis Barang: " + pRuang.get(i).getJenis());
                    System.out.println("Varian Barang: " + pRuang.get(i).getVarian());
                    System.out.println("\n\n");

                }
                System.out.println("\n");
                System.out.print("Pilih Nomor Barang Yang Akan Dibeli: ");
                int brg = Integer.parseInt(br.readLine());
                if (brg > 0 && brg <= pRuang.size()) {
                    pRuang.get(brg - 1).getJenis();
                    System.out.print("Stok Yang akan dibeli: ");
                    int stk = Integer.parseInt(br.readLine());
                    amsk.get(brg - 1).getStok();
                    if (stk > pRuang.get(brg - 1).getStok()) {
                        System.out.println("Stok Kurang!!");
                        break;
                    } else if (stk < pRuang.get(brg - 1).getStok()) {
                        int itung = pRuang.get(brg - 1).getStok() - stk;
                        int harga = stk * pRuang.get(brg - 1).getHarga();
                        System.out.println("Stok Sisa:  " + itung);
                        System.out.println("Harga: " + harga);
                        System.out.println("Berhasil dibeli!!");
                        pRuang.get(brg - 1).setStok(itung);
                        break;
                    }
                } else {
                    System.out.println("Nomor Tidak Tersedia!!");
                }
            } else {
                System.out.println("\n");
                System.out.println("Pilihan Anda Tidak Tersedia !!");
            }
        }
    }

    public static void baca() throws IOException {
        while (true) {
            System.out.println("--- Data Barang Yang Tersedia ---");
            System.out.print("[1]Data Alat Masak\n"
                    + "[2]Data Pengharum Ruangan\n"
                    + "Masukkan Pilihan: ");
            int pilihan = Integer.parseInt(br.readLine());
            if (pilihan == 1) {
                read();
                break;
            } else if (pilihan == 2) {
                read2();
                break;
            } else {
                System.out.println("Pilihan Anda Tidak Tersedia !!");
            }
        }
    }

    public static void exit() throws IOException {
        System.out.println("============================");
        System.out.println("Pendataan Toserba Berakhir");
        System.out.println("============================");
    }
}
