package m2them.moviemadness;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparatorTests {

    @Test
    void movieCompareTest() {

        ArrayList<Movie> movies = Database.getMovies(Database.connectDB());

        assertEquals(movies.get(0).getId(), 1);

        users.sort(Movie.idComparator);

        assertEquals(movies.get(0).getId(), 5);

    }

    @Test
    void userCompareTest() {

        ArrayList<User> users = Database.getUsers(Database.connectDB());

        assertEquals(users.get(0).getId(), 1);

        users.sort(User.idComparator);

        assertEquals(users.get(0).getId(), 25);

    }
}
