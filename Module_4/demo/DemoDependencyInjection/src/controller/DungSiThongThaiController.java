package controller;

import model.DependencyInjection.DungSiThongThai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DungSiThongThaiController {

    @Autowired
    DungSiThongThai dungSiThongThai;

    @GetMapping("/dungsithongthai")
    public String dungsithongthai(Model model) {
        String ketqua = dungSiThongThai.thucHienNhiemVu();

        model.addAttribute("ketqua", ketqua);
        return "dungsithongthai";
    }
}
