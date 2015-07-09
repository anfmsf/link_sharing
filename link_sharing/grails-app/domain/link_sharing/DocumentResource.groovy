package link_sharing

class DocumentResource extends Resource {
    String filepath

    static constraints = {
        filepath (blank: false, nullable: false)
    }
}
