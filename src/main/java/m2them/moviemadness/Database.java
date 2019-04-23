package m2them.moviemadness;

import org.sqlite.SQLiteConfig;

import java.util.ArrayList;

import java.sql.*;

import static java.lang.Class.forName;



@SuppressWarnings("Duplicates")
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
                actor.setGender(rs.getString("actor_gender"));
                actor.setImageURL(rs.getString("actor_profile_image"));

                actors.add(actor);

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
    public static ArrayList<Movie> getMovies() {
        Connection con = connectDB();
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

                movie.setAverageScore(getAverageScore(movie));

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

    //Authors:Ingrid & Tom
    public static ArrayList<Actor> getActorsByMovie(Movie movie){

        Connection con = connectDB();
        ArrayList<Actor> actors = new ArrayList<>();
        Statement stmt = null;

        try {
            int id = movie.getId();
            String getActorsByMovieQuery =
                    "SELECT * " +
                            "FROM tblMovieCast " +
                            "INNER JOIN tblActors ON tblActors.actor_id=tblMovieCast.actor_id " +
                            "WHERE movie_id = " + id;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getActorsByMovieQuery);

            while (rs.next()) {
                Actor actor =new Actor();
                actor.setId(Integer.parseInt(
                        rs.getString("actor_id")));
                actor.setName(rs.getString("actor_name"));
                actor.setAge(Integer.parseInt(
                        rs.getString("actor_age")));
                actor.setGender(rs.getString("actor_gender"));
                actor.setImageURL(rs.getString("actor_profile_image"));
                actor.setRole(rs.getString("actor_role"));
                actors.add(actor);

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

    public static ArrayList<Review> getReviewsByMovie(Movie movie) {

        Connection con = connectDB();
        ArrayList<Review> reviews = new ArrayList<>();
        Statement stmt = null;

        try {
            int id = movie.getId();
            String getReviewByMovieQuery =
                    "SELECT tblReviews.* " +
                            "FROM tblMovies " +
                            "INNER JOIN tblReviews ON tblReviews.movie_id=tblMovies.movie_id " +
                            "WHERE tblMovies.movie_id = " + id;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getReviewByMovieQuery);

            while (rs.next()) {
                Review review =new Review();
                review.setId(Integer.parseInt(
                        rs.getString("review_id")));
                review.setComment(rs.getString("review_comment"));
                review.setUserID(Integer.parseInt(
                        rs.getString("user_id")));
                review.setDate(rs.getString("review_date"));
                review.setRating(Integer.parseInt
                        (rs.getString("review_rating")));
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

    //Authors: Tom, Ingrid, Lily
    public static Movie getMovieByTitle(String title) {

        Connection con = connectDB();
        Statement stmt = null;
        Movie movie = new Movie();

        try {
            String getMovieByNameQuery =
                    "SELECT * " +
                            "FROM tblMovies " +
                            "WHERE movie_title = '" + title + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(getMovieByNameQuery);

            while (rs.next()) {

                movie.setId(Integer.parseInt(
                        rs.getString("movie_id")));
                movie.setTitle(rs.getString("movie_title"));
                movie.setSummary(rs.getString("movie_summary"));
                movie.setDuration(rs.getString("movie_duration"));
                movie.setGenre(rs.getString("movie_genre"));
                movie.setRelease(rs.getString("movie_release_date"));
                movie.setImageURL(rs.getString("movie_cover_image"));
                movie.setTrailerURL(rs.getString("movie_trailer"));

                movie.setAverageScore(getAverageScore(movie));

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

        return movie;

    }

    //Authors: Lily & Tom
    public static double getAverageScore(Movie movie) {

        ArrayList<Review> reviews = getReviewsByMovie(movie);
        int[] scores = new int[reviews.size()];

        if (scores.length == 0) {
            return 0.0d;
        }

        for (Review review: reviews) {
            scores[reviews.indexOf(review)] = review.getRating();
        }

        int ratingTotal = 0;

        for (int i = 0; i < scores.length; i++) {
            ratingTotal += scores[i];
        }

        double average = Math.round((ratingTotal/scores.length) * 10);
        average = average/10;

        return average;

    }

//Sanjay
        public static ArrayList<Cast> getCasts(Connection con) {
            ArrayList<Cast> casts = new ArrayList<>();
            Statement stmt = null;

            try {
                String getCastsQuery = "SELECT * FROM tblMovieCast";
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
                review.setRating(Integer.parseInt(rs.getString("review_rating")));
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

