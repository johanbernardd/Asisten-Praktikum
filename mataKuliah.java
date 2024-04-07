package uni.praktikum.utpasprakpemlan;

class mataKuliah {
    static String[] daftarMatkul =  {
        "Agama",
        "Bahasa Indonesia",
        "Bahasa Inggris",
        "Dasar Basis Data",
        "Matematika Komputasi",
        "Pemrograman Dasar",
        "Pemrograman Lanjut",
        "Statistika"
    };

    private String namaMatkul;

    public mataKuliah(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public static void daftarMatkul() {
        System.out.println("Daftar Mata Kuliah yang tersedia:");
        for (int i = 0; i < daftarMatkul.length; i++) {
            System.out.println((i + 1) + ". " + daftarMatkul[i]);
        }
        System.out.println();
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public static String getNamaMatkul(int index) {
        if (index >= 0 && index < daftarMatkul.length) {
            return daftarMatkul[index];
        } else {
            return null;
        }
    }
}