package guru.springframework.joke.jokeapp.Controllers;


import guru.springframework.joke.jokeapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    public String showJoke(Model model){

        //Inserrer à l'attribut "joke" depuis le service pour l'appeler depuis notre page html
        model.addAttribute("joke",jokeService.getJoke());

        //return the view name
        return "chucknorris";
    }
}
