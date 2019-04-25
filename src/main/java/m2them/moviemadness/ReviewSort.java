package m2them.moviemadness;

public class ReviewSort {

    private int sortType;
    private String movieName;

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public ReviewSort(int sortType, String movieName) {
        this.sortType = sortType;
        this.movieName = movieName;
    }
}
