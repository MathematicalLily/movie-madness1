package m2them.moviemadness;

public class Cast {



    private int id, movieID, actorID;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public Cast(int id, int movieID, int actorID) {
        this.id = id;
        this.movieID = movieID;
        this.actorID = actorID;
    }

    public Cast() {
    }
}
