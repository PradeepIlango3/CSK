public class DVD {
    public String name;
    public int releaseYear;
    public String director;
    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }
    public String toString() {
        return name + ", directed by" + director + ", released in" + releaseYear;
    }

    public static void main(String[] args) {
        DVD[] dvds = new DVD[15];
        DVD leo = new DVD("LEO", 2023, "Lokesh K");
        dvds[0] = leo;
        System.out.println(dvds[0]);
        System.out.println(dvds[1]);
    }
}
