package enity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@SuppressWarnings("unused")
@Entity
@Table(name = "NguoiDung")//Annotation
public class NguoiDung implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6079957982224749916L;
	public NguoiDung(){
		
	}
	@Column(name = "TenDangNhap", nullable = false, length = 50)
	public String tenDangNhap;
	@Column(name = "MatKhau", nullable = false, length = 50)
	private String matKhau;
	
	private String rmatKhau;
	@Column(name = "HoTen", nullable = false, length = 30)
	private String hoTen;

	@Column(name = "Email", nullable = true, length = 50)
	private String email;
	@Column(name = "DienThoai", nullable = true, length = 20)
	private String dienThoai;
	public Date getNgayTao() {
		return ngayTao;
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public int getVaiTroId() {
		return vaiTroId;
	}
	public void setVaiTroId(int vaiTroId) {
		this.vaiTroId = vaiTroId;
	}
	public String getRmatKhau() {
		return rmatKhau;
	}
	public void setRmatKhau(String rmatKhau) {
		this.rmatKhau = rmatKhau;
	}	
	private Date ngayTao;
	private int vaiTroId;	
	private VaiTro vaiTro;

	public VaiTro getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(VaiTro vaiTro) {
		this.vaiTro = vaiTro;
	}
	@Column(name = "DiaChi", nullable = true, length = 250)
	private String diaChi;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdUser", unique = true, nullable = false)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "NguoiDung [tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", rmatKhau=" + rmatKhau + ", hoTen="
				+ hoTen + ", email=" + email + ", dienThoai=" + dienThoai + ", ngayTao=" + ngayTao + ", vaiTroId="
				+ vaiTroId + ", vaiTro=" + vaiTro + ", diaChi=" + diaChi + ", id=" + id + "]";
	}	
}
