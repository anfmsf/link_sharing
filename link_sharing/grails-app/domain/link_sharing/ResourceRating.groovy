package link_sharing

class ResourceRating {

    Integer score

    static belongsTo=[resource:Resource, user:User]

    String toString()
    {
        return score
    }
    static constraints = {
    }
}