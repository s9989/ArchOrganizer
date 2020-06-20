package archorganizer.controller;

import archorganizer.model.project.Project;
import archorganizer.model.project.Stage;
import archorganizer.model.relations.Implementation;
import archorganizer.model.user.User;
import archorganizer.repository.ImplementationRepository;
import archorganizer.repository.StageRepository;
import archorganizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/stage")
public class StageController {

    @Autowired
    StageRepository stageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImplementationRepository implementationRepository;

    @GetMapping(value = "/show")
    public String show(@RequestParam(value = "id") Long id, Model model) {

        var result = stageRepository.findById(id);
        if (!result.isPresent()) {
            return "404";
        }
        model.addAttribute("stage", result.get());
        return "stage/show";
    }

    @GetMapping(value = "/expert/new")
    public String newExpert(@RequestParam(value = "id") Long id, Model model) {

        var result = stageRepository.findById(id);
        if (!result.isPresent()) {
            return "404";
        }

        model.addAttribute("stage", result.get());
        model.addAttribute("experts", userRepository.findExperts());
        return "stage/expert/new";
    }


    @GetMapping(value = "/expert/save")
    public String newExpert(@RequestParam(value = "id") Long id, @RequestParam(value = "expert_id") Long expertId, Model model) {

        var stageResult = stageRepository.findById(id);
        if (!stageResult.isPresent()) {
            return "404";
        }

        var userResult = userRepository.findById(expertId);
        if (!userResult.isPresent()) {
            return "404";
        }

        Stage stage = stageResult.get();
        User user = userResult.get();

        if (user.getExpert() == null) {
            return "500";
        }

        stage.addExpert(user.getExpert());
        stageRepository.save(stage);

        return "redirect:/stage/show?id=" + stage.getId();
    }

    @GetMapping(value = "/expert/delete")
    public String deleteExpert(@RequestParam(value = "id") Long id, @RequestParam(value = "expert_id") Long expertId, Model model) {

        var stageResult = stageRepository.findById(id);
        if (!stageResult.isPresent()) {
            return "404";
        }

        var userResult = userRepository.findById(expertId);
        if (!userResult.isPresent()) {
            return "404";
        }

        Stage stage = stageResult.get();
        User user = userResult.get();

        if (user.getExpert() == null) {
            return "500";
        }

        Implementation implementation = stage.getImplementation(user.getExpert());
        implementationRepository.delete(implementation);
        return "redirect:/stage/show?id=" + stage.getId();
    }

}
