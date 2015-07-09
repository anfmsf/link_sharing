package link_sharing

class User {

    String firstName
    String lastName
    String email
    String username
    String password
    String confirmPassword
    boolean admin
    boolean active
    byte[]  photo
    Date dateCreated
    Date lastUpdated

    static hasMany=[topics:Topic, subscriptions:Subscription, resources:Resource,readingItems:ReadingItem, resourceRatings:ResourceRating]



    static constraints = {
        photo (nullable:true, maxSize:1024*1024*5)
        email(email:true,blank:false,unique: true)
        confirmPassword password:true
        password (password:true,blank: false, nullable: false, validator: {password,obj->
            def password2=obj.confirmPassword
            password2 == password ? true : ['invalid.matchingpasswords']

        })
    }

    String toString()
    {
        return firstName+" "+lastName
    }
}
