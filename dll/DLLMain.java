package dll;
import java.util.Scanner;
public class DLLMain {
    public static void main(String[] args) {
        DoubleLinkedList20 list = new DoubleLinkedList20();
        Scanner scan = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Double Linked List Mahasiswa");
            System.out.println("1. Tambah di awal");
            System.out.println("2. Tambah di akhir");
            System.out.println("3. Hapus dari awal");
            System.out.println("4. Hapus dari akhir");
            System.out.println("5. Tampilkan data");
            System.out.println("6. Cari Mahasiswa berdasarkan NIM");
            System.out.println("7. Tambah setelah NIM tertentu");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    Mahasiswa20 mhs = inputMahasiswa(scan);
                    list.addFirst(mhs);
                    break;
                
                case 2:
                    Mahasiswa20 mhs1 = inputMahasiswa(scan);
                    list.addLast(mhs1);
                    break;
                    
                
                // case 3:
                //     list.removeFirst();
                //     break;
                
                // case 4:
                //     list.removeLast();
                //     break;
                
                case 5:
                    list.print();
                    break;
                
                // case 6:
                //     System.out.print("Masukan NIM yang dicari: ");
                //     String nim = scan.nextLine();
                //     Node20 found = list.search(nim);
                //     if (found != null) {
                //         System.out.println("Data ditemukan:");
                //         found.data.tampil();
                //     } else {
                //         System.out.println("Data tidak ditemukan.");
                //     }
                //     break;

                case 7:
                    System.out.print("Masukkan NIM yang ingin disisipi setelahnya: ");
                    String nimKey = scan.nextLine();
                    Mahasiswa20 newData = inputMahasiswa(scan);
                    list.insertAfter(nimKey, newData);
                    break;

                
                case 0:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihan != 0);
        scan.close();
    }
    public static Mahasiswa20 inputMahasiswa(Scanner scan) {
        System.out.print("Masukkan NIM     : ");
        String nim = scan.nextLine();
        System.out.print("Masukkan Nama    : ");
        String nama = scan.nextLine();
        System.out.print("Masukkan Kelas   : ");
        String kelas = scan.nextLine();
        System.out.print("Masukkan IPK     : ");
        double ipk = scan.nextDouble();
        scan.nextLine();
        return new Mahasiswa20(nim, nama, kelas, ipk);
    }

}
