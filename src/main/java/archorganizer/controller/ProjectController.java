package archorganizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

    @GetMapping(name="project_show", value = "/project/show")
    public String show(@RequestParam(value = "id") int id, Model model) {
        System.out.println("show " + id);
        model.addAttribute("id", id);
        return "project/show";
    }

    @GetMapping(name="project_edit", value = "/project/edit")
    public String edit(@RequestParam(value = "id") int id, Model model) {
        System.out.println("edit " + id);
        model.addAttribute("id", id);
        return "project/edit";
    }

}
