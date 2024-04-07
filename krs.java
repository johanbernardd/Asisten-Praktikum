package uni.praktikum.utpasprakpemlan;

class krs {
    private mahasiswa maha;
    private mataKuliah[] daftarMatkul;
    private int jumlahMatkul;

    public krs(mahasiswa maha, int maxMatkul) {
        this.maha = maha;
        this.daftarMatkul = new mataKuliah[maxMatkul];
        this.jumlahMatkul = 0;
    }

    public void tambahMatkul(mataKuliah mk) {
        if (jumlahMatkul < 5) {
            daftarMatkul[jumlahMatkul] = mk;
            jumlahMatkul++;
        } else {
            System.out.println("Status: Jumlah maksimal mengambil mata kuliah tercapai");
        }
    }

    public void displayChosenCourses() {
        System.out.println("\nMata Kuliah yang telah dipilih:");
        int count = 0;
        for (mataKuliah chosenMk : daftarMatkul) {
            if (chosenMk != null) {
                System.out.print(chosenMk.getNamaMatkul());
                if (count < jumlahMatkul - 1) {
                    System.out.print(", ");
                }
                count++;
            }
        }
    }
}