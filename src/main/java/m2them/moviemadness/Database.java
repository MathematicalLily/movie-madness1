package m2them.moviemadness;

import org.sqlite.SQLiteConfig;

import java.util.ArrayList;

import java.sql.*;

import static java.lang.Class.forName;


public class Database {

//Author Sanjay

    private Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            con = DriverManager.getConnection("jdbc:sqlite:" + "data/MoviesDatabase.db");
            config.toProperties();
        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        }

        return con;
    }


    public static ArrayList<Actor> getActors() {
        return new ArrayList<Actor>();
    }

    //Author Sanjay
    public static ArrayList<Movie> getMovies(Connection con) {
        ArrayList<Movie> movies = new ArrayList<>();
        Statement stmt = null;

        try {
            String getMoviesQuery = "SELECT * FROM tblMovies";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getMoviesQuery);

            while (rs.next()) {

                Movie movie = new Movie();
                movie.setId(Integer.parseInt(
                        rs.getString("movie_id")));
                movie.setTitle(rs.getString("movie_title"));
                movie.setSummary(rs.getString("movie_summary"));
                movie.setDuration(rs.getString("movie_duration"));
                movie.setGenre(rs.getString("movie_genre"));
                movie.setRelease(rs.getString("movie_release_date"));
                movie.setImageURL(rs.getString("movie_cover_image"));
                movie.setTrailerURL(rs.getString("movie_trailer"));

                movies.add(movie);
            }


        } catch (Exception ex) {
            System.out.println(ex.getClass());
            ex.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movies;

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

    public static void main(String[] args) {

        Database db = new Database();
        db.getMovies(db.connectDB());

    }

}

