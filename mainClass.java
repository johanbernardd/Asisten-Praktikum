package uni.praktikum.utpasprakpemlan;
import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mataKuliah.daftarMatkul();
        
        String nama = sc.next();
        int nim = sc.nextInt();
        String jenisKelamin = sc.next();
        String fakultas = sc.next();
        String prodi = sc.next();
        int semester = sc.nextInt();
        sc.nextLine();

        mahasiswa mhs = new mahasiswa(nama, nim, jenisKelamin, fakultas, prodi, semester);

        String generatedEmail = mhs.generateEmail();
        System.out.print(generatedEmail + "\n\n");

        final int MAX_ATTEMPTS = 3;
        int attempts = 1;
        boolean loggedIn = false;

        while (attempts < MAX_ATTEMPTS) {
            String enterEmail = sc.next();
            sc.nextLine();

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
                    System.out.println("Email atau password yang dimasukkan salah");
                    System.out.println("Anda telah mencapai batas percobaan login. Akses ditolak.");
                }
            }
        }

        if (!loggedIn) {
            System.exit(0);
        }

        krs kartu = new krs(mhs, 5);

        String selected = sc.nextLine().trim();
        String[] selectedMataKuliah = selected.split(", ");

        for (String mataKuliahNum : selectedMataKuliah) {
            int num = Integer.parseInt(mataKuliahNum);
            if (num > 0 && num <= mataKuliah.daftarMatkul.length) {
                String namaMatkul = mataKuliah.getNamaMatkul(num - 1);
                if (namaMatkul != null) {
                    mataKuliah mk = new mataKuliah(namaMatkul);
                    kartu.tambahMatkul(mk);
                } else {
                    System.out.println("Mata kuliah tidak ditemukan.");
                }
            } else {
                System.out.println("Pilihan Invalid: " + mataKuliahNum);
            }
        }

        System.out.println("Kartu Rencana Studi:");
        System.out.println(mhs.print());
        System.out.println("Email: " + mhs.generateEmail());
        kartu.displayChosenCourses();

        sc.close();
    }
}