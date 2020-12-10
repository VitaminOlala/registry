package controller;

import java.security.MessageDigest;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import sun.misc.BASE64Encoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.NguoiDungBusiness;
import enity.NguoiDung;

@Controller
public class NguoiDungAction extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4213060958129320987L;

	@RequestMapping("/dangKyNguoiDung")
    public String insign(@ModelAttribute("objNguoiDung") NguoiDung objNguoiDung, Model model, BindingResult result) {
        String pass = null;
        try {
            if (objNguoiDung.getMatKhau().length() != 0) {
                MessageDigest md;
                md = MessageDigest.getInstance("MD5");
                byte[] passAdmin = md.digest(objNguoiDung.getMatKhau().getBytes());
                
				BASE64Encoder encoder = new BASE64Encoder();
                pass = encoder.encode(passAdmin);
            }
        } catch (Exception e) {
        }
        String err = "";
        if ("Tên đăng nhập".equals(objNguoiDung.getTenDangNhap())) {
            err = err + "Thiếu tên đăng nhập\n";
        }
        if ("Mật khẩu".equals(objNguoiDung.getMatKhau())) {
            err = err + "Thiếu mật khẩu\n";
        }


        if ("Email".equals(objNguoiDung.getEmail())) {
            err = err + "Thiếu Email\n";
        }


        if ("Họ tên".equals(objNguoiDung.getHoTen())) {
            err = err + "Thiếu họ tên\n";
        }
        objNguoiDung.setMatKhau(pass);
        if (err.equals("")) {
            boolean signin = new NguoiDungBusiness().addNguoiDung(objNguoiDung);
            if (signin) {
                model.addAttribute("result", "Đăng kí thành công");
                return "DangKyNguoiDung";
            } else {
                model.addAttribute("objNguoiDung", new NguoiDung());
                model.addAttribute("result", "Đăng kí thất bại");
                model.addAttribute("err", "1");
                return "DangKyNguoiDung";
            }
        } else {
            model.addAttribute("objNguoiDung", new NguoiDung());
            model.addAttribute("result", err);
            return "DangKyNguoiDung";
        }

    }
  @RequestMapping(value="/listNguoiDung")
  public String themquyenadmin(Model model) {
	  List<NguoiDung> lstNguoiDung = new NguoiDungBusiness().listNguoiDung();
      model.addAttribute("lstNguoiDung",lstNguoiDung);

      return "QuanLiNguoiDung";
  } 
  public static final Pattern EMAIL_ADDRESS
  = Pattern.compile(
      "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
      "\\@" +
      "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
      "(" +
          "\\." +
          "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
      ")+"
  );
//  @RequestMapping("/prelogin")
//  public String login(Model model, HttpSession session) {
//      NguoiDung objNguoiDung = (NguoiDung) session.getAttribute("login");
//      if (objNguoiDung == null) {
//          model.addAttribute("NguoiDung", new NguoiDung());
//          return "DangKyNguoiDung";
//      } 

      
//  }  
}
