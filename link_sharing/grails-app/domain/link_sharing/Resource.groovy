package link_sharing

class Resource {
    String title
    String description
    User creator
    Date dateCreated
    Date lastUpdated


    static belongsTo=[topic:Topic]
    static hasMany=[readingItems:ReadingItem, resourceRatings:ResourceRating]

    static mapping = {
        tablePerHierarchy (false)
    }


    static constraints = {
        title (unique:'topic')
        description ( size:1..1000)

    }

    String toString()
    {
        return description;
    }
}
