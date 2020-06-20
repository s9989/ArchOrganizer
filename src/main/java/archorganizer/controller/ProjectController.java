package archorganizer.controller;

import archorganizer.model.project.Project;
import archorganizer.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(value = "/show")
    public String show(@RequestParam(value = "id") Long id, Model model) {

        var result = projectRepository.findById(id);
        if (!result.isPresent()) {
            return "404";
        }
        model.addAttribute("project", result.get());
        return "project/show";
    }

    @GetMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "project/list";
    }

}
