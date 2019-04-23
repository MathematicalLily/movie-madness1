package m2them.moviemadness;

import java.util.Comparator;

public class Cast {



    private int id, movieID, actorID;
    private String role;


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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Cast(int id, int movieID, int actorID) {
        this.id = id;
        this.movieID = movieID;
        this.actorID = actorID;
    }

    public Cast() {
    }
    public static Comparator<Cast> idComparator = new Comparator<Cast>() {
        @Override
        public int compare(Cast c1, Cast c2) {
            int cast1 = c1.id;
            int cast2 = c2.id;
            return Integer.compare(cast1, cast2);
        }
    };
    public static Comparator<Cast> movieIDComparator = new Comparator<Cast>() {
        @Override
        public int compare(Cast c1, Cast c2) {
            int cast1 = c1.movieID;
            int cast2 = c2.movieID;
            return Integer.compare(cast1, cast2);
        }
    };
    public static Comparator<Cast> actorIDComparator = new Comparator<Cast>() {
        @Override
        public int compare(Cast c1, Cast c2) {
            int cast1 = c1.actorID;
            int cast2 = c2.actorID;
            return Integer.compare(cast1, cast2);
        }
    };
}
