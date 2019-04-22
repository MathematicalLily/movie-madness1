package m2them.moviemadness;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class MovieController {

    @GetMapping({"/index", "/"})
    public String moviesIndex(Model model){
        ArrayList<Movie> movies = Database.getMovies(Database.connectDB());
        model.addAttribute("movies", movies);
        return "index";
        }

    }





