package m2them.moviemadness;

import java.util.Comparator;

public class Actor {

    private int id, age;
    private String name, gender, imageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Actor(int id, int age, String name, String gender, String imageURL) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.imageURL = imageURL;
    }

    public Actor() {
    }
    public static Comparator<Actor> idComparator = new Comparator<Actor>() {
        @Override
        public int compare(Actor a1, Actor a2) {
            int actor1 = a1.id;
            int actor2 = a2.id;
            return Integer.compare(actor1, actor2);
        }
    };
    public static Comparator<Actor> ageComparator = new Comparator<Actor>() {
        @Override
        public int compare(Actor a1, Actor a2) {
            int actor1 = a1.age;
            int actor2 = a2.age;
            return Integer.compare(actor1, actor2);
        }
    };
    public static Comparator<Actor> nameComparator = new Comparator<Actor>() {
        @Override
        public int compare(Actor a1, Actor a2) {
            String actor1 = a1.name.toLowerCase();
            String actor2 = a2.name.toLowerCase();
            return actor1.compareTo(actor2);
        }
    };
    public static Comparator<Actor> genderComparator = new Comparator<Actor>() {
        @Override
        public int compare(Actor a1, Actor a2) {
            String actor1 = a1.gender.toLowerCase();
            String actor2 = a2.gender.toLowerCase();
            return actor1.compareTo(actor2);
        }
    };
    public static Comparator<Actor> imgURLComparator = new Comparator<Actor>() {
        @Override
        public int compare(Actor a1, Actor a2) {
            String actor1 = a1.imageURL.toLowerCase();
            String actor2 = a2.imageURL.toLowerCase();
            return actor1.compareTo(actor2);
        }
    };
}
