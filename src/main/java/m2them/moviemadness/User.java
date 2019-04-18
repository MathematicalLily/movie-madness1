package m2them.moviemadness;

import java.util.Comparator;

public class User {

    private int id, age;
    private String username, password, name, email, joinDate;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public User(int id, int age, String username, String password, String name, String email, String joinDate) {
        this.id = id;
        this.age = age;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
    }
    public User() {
    }

    public static Comparator<User> userIdComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            int user1 = u1.id;
            int user2 = u2.id;
            return Integer.compare(user1, user2);
        }
    };
    public static Comparator<User> ageComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            int user1 = u1.age;
            int user2 = u2.age;

            return Integer.compare(user1, user2);
        }
    };
    public static Comparator<User> usernameComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            String user1 = u1.username.toUpperCase();
            String user2 = u2.username.toUpperCase();
            return user1.compareTo(user2);
        }
    };
    public static Comparator<User> passwordComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            String user1 = u1.password.toLowerCase();
            String user2 = u2.password.toUpperCase();

            return user1.compareTo(user2);
        }
    };
    public static Comparator<User> nameComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            String user1 = u1.name.toLowerCase();
            String user2 = u2.name.toUpperCase();

            return user1.compareTo(user2);
        }
    };
    public static Comparator<User> emailComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            String user1 = u1.email.toLowerCase();
            String user2 = u2.email.toUpperCase();

            return user1.compareTo(user2);
        }
    };
    public static Comparator<User> joinDateComparator = new Comparator<User>() {
        @Override
        public int compare(User u1, User u2) {
            String user1 = u1.joinDate.toLowerCase();
            String user2 = u2.joinDate.toUpperCase();

            return user1.compareTo(user2);
        }
    };


}