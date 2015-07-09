import link_sharing.DocumentResource
import link_sharing.LinkResource
import link_sharing.ReadingItem
import link_sharing.Resource
import link_sharing.ResourceRating
import link_sharing.Seriousness
import link_sharing.Subscription
import link_sharing.Topic
import link_sharing.User
import link_sharing.Visibility

class BootStrap {

    def init = { servletContext ->
        createUsers();
        createTopics();
     //   createResources();
    //    createReadingItems();
     //   createRatings();
     //   createSubscriptions*/

    }



   void createUsers()
    {
        User u1 = new User(firstName: "Faizan", lastName: "Equebal", username: "faiz123", password: "123456", confirmPassword: "123456", admin: "true", active: "true", photo: null, dateCreated: null, lastUpdate: null,email:"faizan.equbal@gmail.com");
        u1.save(flush:true,failOnError: true);
        User u2 = new User(firstName: "Rohit", lastName: "Mehlawat", username: "rohit123", password: "112233", confirmPassword:  "112233", admin: "false", active: "true", photo: null, dateCreated: null, lastUpdate: null,email:"flyboys2k15@gmail.com");
        u2.save(flush:true,failOnError: true);
    }
    void createTopics()
    {
        List users = User.list();
        users.each { u1 ->
            5.times {
                Topic topic = new Topic(name: "php MVC ${it+1}",visibility: Visibility.PUBLIC )
                u1.addToTopics(topic);
                u1.addToSubscriptions(new Subscription(topic: topic, seriousness: Seriousness.SERIOUS));
                u1.save(flush:true,failonerror:true)
            }
        }

    }

    /*void createResources() {
        List topics=Topic.list();
        topics.eachWithIndex {  topic,index->

            User user=User.findById(index%2+1)

            topic.addToResources(
                    new LinkResource(creator:user, title:"link tittle ${index+1}",description:"link tiitle${index+1}	descripion", url:"https://grails.github.io/grails-doc/link${index+1}"  )
            )

            topic.addToResources(
                    new  DocumentResource(creator:user, title:"document tittle ${index+1}",description:" document tiitle${index+1}descripion", filePath:"//filepath/grails.github.io/grails-doc/link${index+1}"  )
            )
            topic.save(flush: true, failOnError: true);
            println("Started")
        }
    }*/
  /*  void createReadingItems(){

        int size=Resource.list().size()-1;
        List<Resource> r=Resource.list()
        User.list().each{user->

            user.addToReadingItems(new ReadingItem(resource: r.get(Math.abs(1)),isRead:true))
            user.addToReadingItems(new ReadingItem(resource: r.get(Math.abs(1)),isRead:true))
            user.addToReadingItems(new ReadingItem(resource: r.get(Math.abs(2)),isRead:true))
            user.save(failOnError: true)

        }

    } */
    def destroy = {
    }


}
