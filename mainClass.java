package uni.praktikum.asprak;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nama: ");
        String nama = sc.next();
        System.out.print("NIM: ");
        int nim = sc.nextInt();
        System.out.print("Jenis Kelamin: ");
        String jenisKelamin = sc.next();
        System.out.print("Fakultas: ");
        String fakultas = sc.next();
        System.out.print("Program Studi: ");
        String prodi = sc.next();
        System.out.print("Semester: ");
        int semester = sc.nextInt();

        mahasiswa mhs = new mahasiswa(nama, nim, jenisKelamin, fakultas, prodi, semester);

        String generatedEmail = mhs.generateEmail();
        System.out.print("Email anda: " + generatedEmail + "\n\n");

        final int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Silakan login untuk masuk ke dalam akun anda");
            System.out.print("Masukkan email: ");
            String enterEmail = sc.next();
            sc.nextLine();

            System.out.print("Masukkan password: ");
            String enterPassword = sc.next();
            sc.nextLine();

            if (enterEmail.equals(generatedEmail) && enterPassword.equals("admin")) {
                System.out.println("Anda berhasil login");
                loggedIn = true;
                break;
            } else {
                attempts++;
                System.out.println("Email atau password yang dimasukkan salah");

                if (attempts == MAX_ATTEMPTS) {
                    System.out.println("Anda telah mencapai batas percobaan login. Akses ditolak.");
                }
            }
        }

        if (!loggedIn) {
            System.exit(0);
        }

        krs kartu = new krs(mhs, 5);

        for (int i = 1; i < 6; i++) {
            mataKuliah.daftarMatkul();
            System.out.println("Pilih mata kuliah:");
            int num = sc.nextInt();
            sc.nextLine();
            if (num > 0 && num <= mataKuliah.daftarMatkul.length) {
                String namaMatkul = mataKuliah.getNamaMatkul(num - 1);
                if (namaMatkul != null) {
                    mataKuliah mk = new mataKuliah(namaMatkul);
                    kartu.tambahMatkul(mk);
                    kartu.displayChosenCourses();
                } else {
                    System.out.println("Mata kuliah tidak ditemukan.");
                } 
            } else {
                System.out.println("Pilihan Invalid. Coba diulangi.");
                i--;
            }
        }

        System.out.println("\nKartu Rencana Studi:");
        System.out.println(mhs.print());
        System.out.println("Email: " + mhs.generateEmail());
        kartu.displayChosenCourses();

        sc.close();
    }
}