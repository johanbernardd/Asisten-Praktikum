package uni.praktikum.utpasprakpemlan;
class mahasiswa {
    String nama;
    int nim;
    String gender;
    String fakultas;
    String prodi;
    int semester;
    
    public mahasiswa(String nama, int nim, String gender, String fakultas, String prodi, 
        int semester) {
        this.nama = nama;
        this.nim = nim;
        this.gender = gender;
        this.fakultas = fakultas;
        this.prodi = prodi;
        this.semester = semester;
    }

    public String generateEmail() {
        String[] eachPart = nama.split(" ");
        String emailName = "";
        for (String each : eachPart) {
            emailName += each.toLowerCase();
        }

        String[] prodiParts = prodi.split("_");
        String prodiInitials = "";
        for (String part : prodiParts) {
            if (!part.isEmpty()) {
                prodiInitials += part.charAt(0);
            }
        }
        return emailName + "@" + fakultas.toLowerCase().replace(" ", "") + "." + prodiInitials.toLowerCase() + ".ac.id";
    }

    public String print() {
        return "Nama: " + nama + " | NIM: " + nim + " | Jenis Kelamin: " + gender + " | Fakultas: " + 
        fakultas + " | Program Studi: " + prodi + " | Semester: " + semester; 
    }
}