package m2them.moviemadness;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTests {

    @Test
    public void testConnectionExists() {
        assertNotNull(Database.connectDB());
    }

    @Test
    public void testMoviesReceived() {

        ArrayList<Movie> movies = Database.getMovies();

        assertNotNull(movies);

        assertNotEquals(movies.size(), 0);

    }

    @Test
    public void testMovieContents() {

        Movie fromDB = Database.getMovies().get(0);

        Movie hellboy = new Movie(1, "Hellboy",
                "Based on the graphic novels by Mike Mignola, Hellboy, caught between the worlds of the supernatural and human, battles an ancient sorceress bent on revenge.",
                "120 min", "Action, Adventure, Fantasy, Horror, Sci-Fi", "12 Apr 2019",
                "https://m.media-amazon.com/images/M/MV5BYTMyYjg0MTItYTcyZS00MmRiLWIxNWQtYTRiZjRkYWMxZGNkXkEyXkFqcGdeQXVyNjg2NjQwMDQ@._V1_SX300.jpg",
                "https://www.youtube.com/watch?v=ZsBO4b3tyZg"
                );

        assertEquals(fromDB.getId(), hellboy.getId());
        assertEquals(fromDB.getTitle(), hellboy.getTitle());
        assertEquals(fromDB.getSummary(), hellboy.getSummary());
        assertEquals(fromDB.getDuration(), hellboy.getDuration());
        assertEquals(fromDB.getGenre(), hellboy.getGenre());
        assertEquals(fromDB.getRelease(), hellboy.getRelease());
        assertEquals(fromDB.getImageURL(), hellboy.getImageURL());
        assertEquals(fromDB.getTrailerURL(), hellboy.getTrailerURL());

    }

    @Test
    public void testActorContents() {

        Actor fromDB = Database.getActors(Database.connectDB()).get(0);

        Actor bLarson = new Actor(1, 29,
                "Brie Larson", "Female",
                "http://www.gstatic.com/tv/thumb/persons/230638/230638_v9_ba.jpg");

        assertEquals(fromDB.getId(), bLarson.getId());
        assertEquals(fromDB.getAge(), bLarson.getAge());
        assertEquals(fromDB.getName(), bLarson.getName());
        assertEquals(fromDB.getGender(), bLarson.getGender());
        assertEquals(fromDB.getImageURL(), bLarson.getImageURL());
    }

}
