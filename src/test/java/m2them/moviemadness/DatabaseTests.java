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

        ArrayList<Movie> movies = Database.getMovies(Database.connectDB());

        assertNotNull(movies);

        assertNotEquals(movies.size(), 0);

    }

    @Test
    public void testMovieContents() {

        Movie fromDB = Database.getMovies(Database.connectDB()).get(0);

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

}
