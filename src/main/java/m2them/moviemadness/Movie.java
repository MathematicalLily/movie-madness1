package m2them.moviemadness;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

//author Lily

public class Movie {

    private int movieId;
    private String movieTitle, summary, movieDuration,
            movieGenre, movieRelease, movieImageURL, movieTrailerURL;

    public Movie() {
    }

    public int getId() {
        return movieId;
    }

    public void setId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return movieTitle;
    }

    public void setTitle(String title) {
        this.movieTitle = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDuration() {
        return movieDuration;
    }

    public void setDuration(String duration) {
        this.movieDuration = duration;
    }

    public String getGenre() {
        return movieGenre;
    }

    public void setGenre(String genre) {
        this.movieGenre = genre;
    }

    public String getRelease() {
        return movieRelease;
    }

    public void setRelease(String release) {
        this.movieRelease = release;
    }

    public String getImageURL() {
        return movieImageURL;
    }

    public void setImageURL(String imageURL) {
        this.movieImageURL = imageURL;
    }

    public String getTrailerURL() {
        return movieTrailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.movieTrailerURL = trailerURL;
    }

    public Movie(int movieId, String title, String summary, String duration, String genre, String release, String imageURL, String trailerURL) {
        this.movieId = movieId;
        this.movieTitle = title;
        this.summary = summary;
        this.movieDuration = duration;
        this.movieGenre = genre;
        this.movieRelease = release;
        this.movieImageURL = imageURL;
        this.movieTrailerURL = trailerURL;
    }


    public static Comparator<Movie> idComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            int movie1 = m1.movieId;
            int movie2 = m2.movieId;
            return Integer.compare(movie1, movie2);
        }
    };

    public static Comparator<Movie> titleComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            String movie1 = m1.movieTitle.toLowerCase();
            String movie2 = m2.movieTitle.toLowerCase();
            return movie1.compareTo(movie2);
        }
    };

    public static Comparator<Movie> summaryComparator = new Comparator<Movie>() {
        @Override

        public int compare(Movie m1, Movie m2) {
            String movie1 = m1.summary.toLowerCase();
            String movie2 = m2.summary.toLowerCase();
            return movie1.compareTo(movie2);
        }
    };

    public static Comparator<Movie> durationComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            String movie1 = m1.movieDuration;
            String movie2 = m2.movieDuration;
            return movie1.compareTo(movie2);
        }
    };

    public static Comparator<Movie> genreComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            String movie1 = m1.movieGenre;
            String movie2 = m2.movieGenre;
            return movie1.compareTo(movie2);
        }
    };

    public static Comparator<Movie> releaseComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            Date movie1 = null, movie2 = null;
            try {
                movie1 = sdf.parse(m1.movieRelease);
                movie2 = sdf.parse(m2.movieRelease);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return movie1.compareTo(movie2);
        }
    };

    public static Comparator<Movie> ImageURLComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            String movie1 = m1.movieImageURL;
            String movie2 = m2.movieImageURL;
            return movie1.compareTo(movie2);
        }
    };

    public static Comparator<Movie> TrailerURLComparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie m1, Movie m2) {
            String movie1 = m1.movieTrailerURL;
            String movie2 = m2.movieTrailerURL;
            return movie1.compareTo(movie2);
        }
    };
}




