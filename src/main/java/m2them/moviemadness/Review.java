package m2them.moviemadness;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Review {

    private int id, userID, movieID, rating;
    private String comment, date, username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Review() {
    }

    public Review(int id, int userID, int movieID, int rating, String comment, String date) {
        this.id = id;
        this.userID = userID;
        this.movieID = movieID;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public static Comparator<Review> idComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {
            int review1 = r1.id;
            int review2 = r2.id;
            return Integer.compare(review1, review2);
        }
    };

    public static Comparator<Review> userIDComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {
            int review1 = r1.userID;
            int review2 = r2.userID;
            return Integer.compare(review1, review2);
        }
    };

    public static Comparator<Review> movieIDComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {
            int review1 = r1.movieID;
            int review2 = r2.movieID;
            return Integer.compare(review1, review2);
        }
    };

    public static Comparator<Review> ratingComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {
            int review1 = r1.rating;
            int review2 = r2.rating;
            return Integer.compare(review1, review2);
        }
    };

    public static Comparator<Review> commentComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {
            String review1 = r1.comment.toLowerCase();
            String review2 = r2.comment.toLowerCase();
            return review1.compareTo(review2);
        }
    };

    public static Comparator<Review> dateComparator = new Comparator<Review>() {
        @Override
        public int compare(Review r1, Review r2) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            Date review1 = null, review2 = null;
            try {
                review1 = sdf.parse(r1.date);
                review2 = sdf.parse(r2.date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return review2.compareTo(review1);
        }
    };
}
