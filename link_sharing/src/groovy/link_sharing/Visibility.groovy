package link_sharing

/**
 * Created by faizan on 7/7/2015.
 */
enum Visibility {
    PUBLIC("Public"),PRIVATE("Private")
    private final String name;

    Visibility(String name)
    {
        this.name=name

    }
    public String getValue() { return this.name }

    String toString()
    { return this.name
    }

}