package archorganizer.controller;

import archorganizer.model.document.Document;
import archorganizer.model.document.Guidelines;
import archorganizer.model.document.Invoice;
import archorganizer.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/document")
public class DocumentController {

    @Autowired
    DocumentRepository documentRepository;

    @GetMapping(value = "/show")
    public String show(@RequestParam(value = "id") Long id, Model model) {

        var result = documentRepository.findById(id);
        if (!result.isPresent()) {
            return "404";
        }

        Document document = result.get();

        model.addAttribute("document", document);

        String template = "document/elaboration";

        if (document instanceof Invoice) {
            template = "document/invoice";
        }

        if (document instanceof Guidelines) {
            template = "document/guidelines";
        }

        return template;
    }

}
