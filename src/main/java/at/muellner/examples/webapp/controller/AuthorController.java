package at.muellner.examples.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.muellner.examples.webapp.repository.AuthorRepository;

@Controller
public class AuthorController
{
    private AuthorRepository authorRepository;

    public AuthorController(final AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(final Model model)
    {
        // adds attribute authors (list of authors) to the model
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
