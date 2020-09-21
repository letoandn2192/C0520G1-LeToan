package dictionary;

import bo.DictionaryBO;
import bo.DictionaryBOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DictionaryController {
    private DictionaryBO dictionaryBO = new DictionaryBOImpl();

    @GetMapping("")
    public String search() {
        return "display";
    }

    @PostMapping("/search")
    public ModelAndView returnResult(@RequestParam String search) {
        String result = dictionaryBO.search(search);
        if (result == null) {
            result = "Not Found !!!";
        }
        return new ModelAndView("display", "result", result);
    }
}
