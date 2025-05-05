package LAPTUAN5;
import java.util.ArrayList;
import java.util.Scanner;
abstract class NhanVien{
    protected String maNhanVien;
    protected String tenNhanVien;
    protected String trinhDo;
    protected double luongCoBan;
    public NhanVien(){
        this.maNhanVien="";
        this.tenNhanVien="";
        this.trinhDo="";
        this.luongCoBan=0.0;
    }
    public NhanVien(String maNhanVien, String tenNhanVien, String trinhDo){
        this.maNhanVien=maNhanVien;
        this.tenNhanVien=tenNhanVien;
        this.trinhDo=trinhDo;
        this.luongCoBan=0.0;
    }
    public String getMaNhanVien(){
        return maNhanVien;
    }
    public String getTenNhanVien(){
        return tenNhanVien;
    }
    public String getTrinhDo(){
        return trinhDo;
    }
    public double getLuongCoBan(){
        return luongCoBan;
    }
    public void setLuongCoBan(double luongCoBan){
        this.luongCoBan=luongCoBan;
    }
    public void nhap(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        this.maNhanVien=scanner.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        this.tenNhanVien=scanner.nextLine();
        System.out.print("Nhap trinh do: ");
        this.trinhDo=scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        this.luongCoBan=scanner.nextDouble();
    }
    public void xuat(){
        System.out.println("Ma nhan vien: " + maNhanVien + ", Ten nhan vien: " + tenNhanVien + ", Trinh do: " + trinhDo + ", Luong co ban: " + luongCoBan);
    }
    public abstract double tinhLuong();
}
class QuanLy extends NhanVien{
    private String chuyenMon;
    private double phuCapChucVu;
    public QuanLy(){
        super();
        chuyenMon="";
        phuCapChucVu=0.0;
    }
    public QuanLy(String maNhanVien, String tenNhanVien, String trinhDo, String chuyenMon, double phuCapChucVu){
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon=chuyenMon;
        this.phuCapChucVu=phuCapChucVu;
    }
    public String getChuyeMon(){
        return chuyenMon;
    }
    public double getPhuCapChucVu(){
        return phuCapChucVu;
    }
    @Override
    public void nhap(){
        super.nhap();
        Scanner scanner=new Scanner(System.in);
         System.out.print("Nhap chuyen mon: ");
        this.chuyenMon= scanner.nextLine();
        System.out.print("Nhap phu cap chuc vu: ");
        this.phuCapChucVu= scanner.nextDouble();
    }
    @Override 
    public void xuat(){
        super.xuat();
        System.out.println("Chuyen mon: " + chuyenMon + ", Phu cap chuc vu: " + phuCapChucVu);
    }
    @Override 
    public double tinhLuong(){
        return luongCoBan + phuCapChucVu;
    }
}
class NghienCuu extends NhanVien{
    private String chuyenMon;
    private double phuCapDocHai;
    public NghienCuu(){
        super();
        chuyenMon="";
        phuCapDocHai=0.0;
    }
    public NghienCuu(String maNhanVien, String tenNhanVien, String trinhDo, String chuyenMon, double phuCapDocHai){
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon=chuyenMon;
        this.phuCapDocHai=phuCapDocHai;
    }
    public String getChuyenMon(){
        return chuyenMon;
    }
    public double getPhuCapDocHai(){
        return phuCapDocHai;
    }
    @Override 
    public void nhap(){
        super.nhap();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        this.chuyenMon=scanner.nextLine();
        System.out.print("Nhap phu cap doc hai: ");
        this.phuCapDocHai=scanner.nextDouble();
    }
    public void xuat(){
        super.xuat();
        System.out.println("Chuyen mon: " + chuyenMon + ", Phu cap doc hai: " + phuCapDocHai);
    }
    @Override 
    public double tinhLuong(){
        return luongCoBan + phuCapDocHai;
    }
}
class PhucVu extends NhanVien{
    public PhucVu(){
        super();
    }
    public PhucVu(String maNhanVien, String tenNhanVien, String trinhDo){
        super(maNhanVien, tenNhanVien, trinhDo);
    }
    @Override 
    public void nhap(){
        super.nhap();
    }
    @Override
    public void xuat(){
        super.xuat();
    }
    @Override
    public double tinhLuong(){
        return luongCoBan;
    }
}
public class Bai01{
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        ArrayList<NhanVien>danhSachNhanVien=new ArrayList<>();
        QuanLy quanLy=new QuanLy("QL001", "Nguyen Van A", "Dai hoc", "Quan tri", 2000000);
        System.out.println("THONG TIN QUAN LY");
        quanLy.xuat();
        System.out.println("Luong: " +quanLy.tinhLuong());
        System.out.println();
        NghienCuu nghienCuu=new NghienCuu("NC001", "Tran Thi B", "Thac si", "Hoa Hoc", 1500000);
        System.out.println("THONG TIN NGHIEN CUU");
        nghienCuu.xuat();
        System.out.println("Luong: " + nghienCuu.tinhLuong());
        System.out.println();
        PhucVu phucVu=new PhucVu("PV001", "Le Van C", "Trung Cap");
        phucVu.setLuongCoBan(5000000);
        System.out.println("THONG TIN PHUC VU");
        phucVu.xuat();
        System.out.println("Luong: " + phucVu.tinhLuong());
        System.out.println();
        danhSachNhanVien.add(quanLy);
        danhSachNhanVien.add(nghienCuu);
        danhSachNhanVien.add(phucVu);
        System.out.println("Danh sach nhan vien");
        for (NhanVien nv:danhSachNhanVien) {
            nv.xuat();
            System.out.println("Luong: " + nv.tinhLuong());
        }
    }
}