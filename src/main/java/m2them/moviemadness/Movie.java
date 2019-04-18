package m2them.moviemadness;

public class Movie {

    private int id;
    private String title, summary, duration,
            genre, release, imageURL, trailerURL;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public Movie(int id, String title, String summary, String duration, String genre, String release, String imageURL, String trailerURL) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.duration = duration;
        this.genre = genre;
        this.release = release;
        this.imageURL = imageURL;
        this.trailerURL = trailerURL;
    }
}
