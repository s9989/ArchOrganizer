package archorganizer.controller;

import archorganizer.model.project.Project;
import archorganizer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(value = "/project/show")
    public String show(@RequestParam(value = "id") Long id, Model model) {

        var result = projectRepository.findById(id);
        if (!result.isPresent()) {
            return "404";
        }
        System.out.println("show " + id);
        model.addAttribute("project", result.get());
        return "project/show";
    }

    @GetMapping(value = "/project/edit")
    public String edit(@RequestParam(value = "id") int id, Model model) {
        System.out.println("edit " + id);
        model.addAttribute("id", id);
        return "project/edit";
    }

    @GetMapping(value = "/project/list")
    public String list(Model model) {
        System.out.println("list");
        model.addAttribute("projects", projectRepository.findAll());
        return "project/list";
    }

}
