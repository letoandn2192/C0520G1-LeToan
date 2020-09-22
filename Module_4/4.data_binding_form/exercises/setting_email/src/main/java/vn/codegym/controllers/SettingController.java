package vn.codegym.controllers;

import vn.codegym.service.SettingService;
import vn.codegym.model.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    @Autowired
    private SettingService settingService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("setting", settingService.getSetting());
        return "list";
    }

    @GetMapping("/editForm")
    public ModelAndView getForm() {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("languageList", settingService.getLanguageList());
        modelAndView.addObject("pageSizeList", settingService.getPageSizeList());
        modelAndView.addObject("setting", settingService.getSetting());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editSetting (@ModelAttribute Setting setting) {
        settingService.edit(setting);
        return "redirect:/";
    }
}
