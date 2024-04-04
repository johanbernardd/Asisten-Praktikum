package uni.praktikum.asprak;

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
        return emailName + "@" + prodi.toLowerCase() + "." + fakultas.toLowerCase().replace(" ", "") + ".ac.id";
    }

    public String print() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nJenis Kelamin: " + gender + "\nFakultas: " + 
        fakultas + "\nProgram Studi: " + prodi + "\nSemester: " + semester; 
    }
}