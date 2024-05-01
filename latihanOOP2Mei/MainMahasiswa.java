public class MainMahasiswa {
    public static void main(String[] args) {
        // Lakukan modifikasi data tambah mahasiswa ...
        DataMahasiswa.tambahMahasiswa(new Mahasiswa("Taylor Swift", "S1 Sistem Informasi", true));
        DataMahasiswa.tambahMahasiswa(new Mahasiswa("Ariana Grande", "S1 Teknologi Informasi", true));
        
        // Method tampilSemuaData
        DataMahasiswa.tampilSemuaData();

        // Method cariMahasiswa (jika data ada)
        DataMahasiswa.cariMahasiswa("Ariana Grande");
        // Method cariMahasiswa (jika data tidak ada)
        DataMahasiswa.cariMahasiswa("Taylor Swifties");

        // Method tampilMahasiswa (sebelum diupdate)
        DataMahasiswa.tampilMahasiswa();

        // Method tampilMahasiswa (setelah diupdate)
        DataMahasiswa.updateMahasiswa("Ariana Grande", "S2 Ilmu Komputer", false);
    }
}
