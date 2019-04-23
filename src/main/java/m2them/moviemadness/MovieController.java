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
    public String moviesIndex(Model model) {
        ArrayList<Movie> movies = Database.getMovies();
        movies.sort(Movie.releaseComparator);
        model.addAttribute("movies", movies);
        model.addAttribute("sortType", new SortType(3));
        return "index";
    }

    @RequestMapping("/")
    public String movieSort(Model model, @ModelAttribute("sortType") SortType sortType) {
        ArrayList<Movie> movies = Database.getMovies();
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
            case 4:
                movies.sort(Movie.releaseComparator.reversed());
                break;
            case 5:
                movies.sort(Movie.scoreComparator);
                break;
            case 6:
                movies.sort(Movie.scoreComparator.reversed());
                break;
        }
        model.addAttribute("movies", movies);
        return "index";
    }


    //request mapping
    @RequestMapping(value = "/view", method =  RequestMethod.GET)
    public String movieSort(Model model, @RequestParam("name") String title) {



        Movie movie = Database.getMovieByTitle(title);

        ArrayList<Actor> actors = Database.getActorsByMovie(movie);
        ArrayList<Review> reviews = Database.getReviewsByMovie(movie);
        model.addAttribute("actors", actors);
        model.addAttribute("reviews", reviews);
        model.addAttribute("movie", movie);


        return "movie";


    }


}






