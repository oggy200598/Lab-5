package LAPTUAN5;
import java.util.Scanner;
interface Hinh{
    float pi=3.14f;
    void nhap();
    void xuat();
    float dienTich();
}
class HinhVuong implements Hinh{
    private float canh;
    public HinhVuong(){
        canh=0;
    }
    public HinhVuong(float canh){
        this.canh=canh;
    }
    @Override
    public void nhap() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap canh hinh vuong: ");
        canh = scanner.nextFloat();
    }
    @Override
    public void xuat() {
        System.out.println("Hinh Vuong - Canh: " + canh + ", Dien tich: " + dienTich());
    }
    @Override
    public float dienTich() {
        return canh * canh;
    }
}
class HinhChuNhat implements Hinh {
    private float dai;
    private float rong;

    public HinhChuNhat() {
        dai = rong = 0;
    }

    public HinhChuNhat(float dai, float rong) {
        this.dai=dai;
        this.rong=rong;
    }

    @Override
    public void nhap() {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        dai = scanner.nextFloat();
        System.out.print("Nhap chieu rong: ");
        rong = scanner.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh Chu Nhat - Dai: " + dai + ", Rong: " + rong + ", Dien tich: " + dienTich());
    }

    @Override
    public float dienTich() {
        return dai * rong;
    }
}
class HinhTron implements Hinh {
    private float banKinh;

    public HinhTron() {
        banKinh=0;
    }

    public HinhTron(float banKinh) {
        this.banKinh=banKinh;
    }

    @Override
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban kinh: ");
        banKinh = scanner.nextFloat();
    }

    @Override
    public void xuat() {
        System.out.println("Hinh Tron - Ban kinh: " + banKinh + ", Dien tich: " + dienTich());
    }

    @Override
    public float dienTich() {
        return pi * banKinh * banKinh;
    }
}
public class Bai02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Nhap so luong hinh: ");
        int n=scanner.nextInt();
        scanner.nextLine(); 

        Hinh[] ds = new Hinh[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap thong tin cho hinh thu " + (i + 1));
            System.out.println("1: Hinh Vuong");
            System.out.println("2: Hinh Chu Nhat");
            System.out.println("3: Hinh Tron");

            int chon;
            while (true) {
                System.out.print("Lua chon (1-3): ");
                chon = scanner.nextInt();
                if (chon >= 1 && chon <= 3) break;
                System.out.println("Chi duoc chon 1-3!");
            }

            switch (chon) {
                case 1:
                    ds[i] = new HinhVuong();
                    break;
                case 2:
                    ds[i] = new HinhChuNhat();
                    break;
                case 3:
                    ds[i] = new HinhTron();
                    break;
            }

            ds[i].nhap();
        }

        System.out.println("\nDanh sach cac hinh");
        for (Hinh h : ds) {
            h.xuat();
        }

        Hinh max = ds[0];
        for (int i = 1; i < n; i++) {
            if (ds[i].dienTich() > max.dienTich()) {
                max = ds[i];
            }
        }

        System.out.println("\nHinh co dien tich lon nhat");
        max.xuat();
    }
}
