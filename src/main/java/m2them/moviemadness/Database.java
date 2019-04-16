package m2them.moviemadness;

import org.sqlite.SQLiteConfig;

import java.util.ArrayList;

import java.sql.*;

import static java.lang.Class.forName;


public class Database {

//Author Sanjay

    private Connection connectDB(){
            Connection con = null;
        try{
            class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            con = DriverManager.getConnection("jdbc:sqlite:"+"data/MoviesDatabase.db");
            config.toProperties();
        } catch (Exception ex){
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }

        return con;
    }


    public static ArrayList<Actor> getActors() {
        return new ArrayList<Actor>();
    }

    public static ArrayList<Movie> getMovies() {
        return new ArrayList<Movie>();
    }

    public static ArrayList<Cast> getCasts() {
        return new ArrayList<Cast>();
    }

    public static ArrayList<User> getUsers() {
        return new ArrayList<User>();
    }

    public static ArrayList<Review> getReviews() {
        return new ArrayList<Review>();
    }
}
