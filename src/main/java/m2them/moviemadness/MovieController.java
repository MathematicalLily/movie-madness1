package m2them.moviemadness;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller()
public class MovieController {

    @GetMapping({"/index", "/"})
    public String moviesIndex(Model model){
        ArrayList<Movie> movies = Database.getMovies(Database.connectDB());
        movies.sort(Movie.titleComparator);
        model.addAttribute("movies", movies);
        model.addAttribute("sortType", new SortType(1));
        return "index";
        }

        @RequestMapping("/")
        public String movieSort(Model model, @ModelAttribute("sortType") SortType sortType) {
            ArrayList<Movie> movies = Database.getMovies(Database.connectDB());
            switch (sortType.getSortType()) {
                case 1:
                    movies.sort(Movie.titleComparator);
                    break;
                case 2:
                    movies.sort(Movie.titleComparator.reversed());
                    break;
                case 3:
                    movies.sort(Movie.releaseComparator);
                    break;
            }
            model.addAttribute("movies", movies);
            return "index";
        }

    }





