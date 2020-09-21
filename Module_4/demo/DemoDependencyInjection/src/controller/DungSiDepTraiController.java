package controller;

import model.NoDependencyInjection.DungSiDepTrai;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DungSiDepTraiController {

    @GetMapping("/dungsideptrai")
    public String DungSiHanhDong(ModelMap model) {
        DungSiDepTrai dungSiDepTrai = new DungSiDepTrai();
        String ketqua = dungSiDepTrai.thucHienNhiemVu();
        model.addAttribute("ketqua", ketqua);
        return "dungsideptrai";
    }
}
