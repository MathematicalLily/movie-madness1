package m2them.moviemadness;

import java.util.ArrayList;

public class Database {

    static ArrayList<Actor> actors = new ArrayList<>();
    static ArrayList<Movie> movies = new ArrayList<>();
    static ArrayList<Cast> casts = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Review> reviews = new ArrayList<>();

    public static ArrayList<Actor> getActors() {
        return actors;
    }

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public static ArrayList<Cast> getCasts() {
        return casts;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Review> getReviews() {
        return reviews;
    }
}
