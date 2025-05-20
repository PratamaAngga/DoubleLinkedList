package dll;

public class DoubleLinkedList20 {
    Node20 head;
    Node20 tail;

    public DoubleLinkedList20() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa20 data) {
        Node20 newNode = new Node20(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Data berhasil ditambahkan di awal.");
    }

    public void addLast(Mahasiswa20 data) {
        Node20 newNode = new Node20(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Data berhasil ditambahkan di akhir.");
    }

    public void insertAfter(String keyNim, Mahasiswa20 data) {
        Node20 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node20 newNode = new Node20(data);

        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);

    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong.");
            return;
        }
        Node20 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang bisa dihapus.");
        } else {
            Node20 removedNode = head;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            }
            System.out.print("Data sudah berhasil dihapus. Data yang terhapus adalah: ");
            removedNode.data.tampil();
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang bisa dihapus.");
        } else {
            Node20 removedNode = tail;

            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
            }

            System.out.print("Data sudah berhasil dihapus. Data yang terhapus adalah: ");
            removedNode.data.tampil();
        }
    }

    public int size() {
        int count = 0;
        Node20 current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void add(int index, Mahasiswa20 data) {
        if (index < 0 || index > size()) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            Node20 newNode = new Node20(data);
            Node20 current = head;

            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;

            System.out.println("Data berhasil ditambahkan di indeks ke-" + index);
        }
    }

    public void removeAfter(String keyNim) {
        Node20 current = head;

        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Node setelah NIM tersebut tidak ditemukan atau kosong.");
            return;
        }

        Node20 removedNode = current.next;

        if (removedNode == tail) {
            tail = current;
            current.next = null;
        } else {
            current.next = removedNode.next;
            removedNode.next.prev = current;
        }

        System.out.print("Node setelah NIM " + keyNim + " berhasil dihapus: ");
        removedNode.data.tampil();
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size() - 1) {
            removeLast();
        } else {
            Node20 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;

            System.out.print("Data di indeks ke-" + index + " berhasil dihapus: ");
            current.data.tampil();
        }
    }

    public void getFirst() {
        if (!isEmpty()) {
            System.out.print("Data pertama: ");
            head.data.tampil();
        } else {
            System.out.println("Linked list kosong.");
        }
    }

    public void getLast() {
        if (!isEmpty()) {
            System.out.print("Data terakhir: ");
            tail.data.tampil();
        } else {
            System.out.println("Linked list kosong.");
        }
    }

    public void getIndex(int index) {
        if (index < 0 || index >= size()) {
            System.out.println("Indeks di luar jangkauan.");
            return;
        }

        Node20 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        System.out.print("Data di indeks ke-" + index + ": ");
        current.data.tampil();
    }
}
