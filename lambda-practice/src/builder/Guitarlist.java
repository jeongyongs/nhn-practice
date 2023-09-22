package builder;
public class Guitarlist {

    private int id;
    private String name;
    private String teamName;
    private String guitar;

    private Guitarlist(GuitarlistBuilder guitarlistBuilder) {
        this.id = guitarlistBuilder.id;
        this.name = guitarlistBuilder.name;
        this.teamName = guitarlistBuilder.teamName;
        this.guitar = guitarlistBuilder.guitar;
    }

    public static GuitarlistBuilder builder() {
        return new GuitarlistBuilder();
    }

    public static class GuitarlistBuilder {

        private int id;
        private String name;
        private String teamName;
        private String guitar;

        public GuitarlistBuilder id(int id) {
            this.id = id;
            return this;
        }

        public GuitarlistBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GuitarlistBuilder teamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public GuitarlistBuilder guitar(String guitar) {
            this.guitar = guitar;
            return this;
        }

        public Guitarlist build() {
            return new Guitarlist(this);
        }
    }

    @Override
    public String toString() {
        return "Guitarlist [id=" + id
                + ", name=" + name
                + ", teamName=" + teamName
                + ", guitar=" + guitar + "]";
    }
}


class Main {

    public static void main(String[] args) {
        Guitarlist guitarlist = Guitarlist.builder()
                                        .id(0)
                                        .name("name")
                                        .teamName("teamName")
                                        .guitar("guitar")
                                        .build();

        System.out.println(guitarlist);
    }
}
