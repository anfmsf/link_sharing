package link_sharing

import link_sharing.Seriousness
class Subscription {

    Date dateCreated
    Seriousness seriousness

    static belongsTo=[user:User,topic:Topic]

    static constraints = {
        user unique:'topic'  //because users must be unique for every topic
        seriousness (blank:false, nullable: false)
    }
}
