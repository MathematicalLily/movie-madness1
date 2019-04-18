package m2them.moviemadness;

import org.sqlite.SQLiteConfig;

import java.util.ArrayList;

import java.sql.*;

import static java.lang.Class.forName;


public class Database {

//Author Sanjay

    static Connection connectDB() {
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


    public static ArrayList<Actor> getActors(Connection con) {
        ArrayList<Actor> actors = new ArrayList<>();
        Statement stmt = null;

        try {
            String getActorsQuery = "SELECT * FROM tblActors";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getActorsQuery);

            while (rs.next()) {

                Actor actor = new Actor();
                actor.setId(Integer.parseInt(
                        rs.getString("actor_id")));
                actor.setName(rs.getString("actor_name"));
                actor.setAge(Integer.parseInt(rs.getString("actor_age")));
                actor.setGender(rs.getString("actor_age"));
                actor.setImageURL(rs.getString("actor_profile_image"));

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
        return actors;
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

//Sanjay
        public static ArrayList<Cast> getCasts(Connection con) {
            ArrayList<Cast> casts = new ArrayList<>();
            Statement stmt = null;

            try {
                String getCastsQuery = "SELECT * FROM tblMovieCasts";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(getCastsQuery);

                while (rs.next()) {

                    Cast cast = new Cast();
                    cast.setId(Integer.parseInt(
                            rs.getString("movie_cast_id")));
                    cast.setMovieID(Integer.parseInt(rs.getString("movie_id")));
                    cast.setActorID(Integer.parseInt(rs.getString("actor_id")));


                    casts.add(cast);
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
            return casts;
    }

    public static ArrayList<User> getUsers(Connection con) {
        ArrayList<User> users = new ArrayList<>();
        Statement stmt = null;

        try {
            String getUsersQuery = "SELECT * FROM tblUsers";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getUsersQuery);

            while (rs.next()) {

                User user = new User();
                user.setId(Integer.parseInt(
                        rs.getString("user_id")));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("user_name"));
                user.setAge(Integer.parseInt(rs.getString("user_age")));
                user.setEmail(rs.getString("user_email"));
                user.setJoinDate(rs.getString("user_join_date"));






                users.add(user);
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
        return users;
    }

    public static ArrayList<Review> getReviews(Connection con) {
        ArrayList<Review> reviews = new ArrayList<>();
        Statement stmt = null;

        try {
            String getReviewsQuery = "SELECT * FROM tblReviews";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getReviewsQuery);

            while (rs.next()) {

                Review review = new Review();
                review.setId(Integer.parseInt(
                        rs.getString("review_id")));
                review.setUserID(Integer.parseInt(rs.getString("user_id")));
                review.setMovieID(Integer.parseInt(rs.getString("movie_id")));
                review.setComment(rs.getString("review_comment"));
                review.setRating(Integer.parseInt(rs.getString("review_date")));
                review.setDate(rs.getString("review_date"));






                reviews.add(review);
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
        return reviews;
    }

}

