package link_sharing

//import grails.plugin.mail.MailService

class LoginController {
  //  def mailService;

    def index() {
        session["user"]=null
        params.max = params.max ?: 4
        List<Resource> rList = Resource.listOrderByLastUpdated(max: 4, order: "desc")

        List<Topic> top =Topic.findAllByVisibility("PUBLIC")

        List<Resource> Allresources=Resource.findAllByTopicInList(top)

        List<Resource> topposts=ResourceRating.createCriteria().list([max:5]) {
            projections{
                groupProperty("resource")
                avg("score",'avg')

            }
            order('avg','desc')
            inList('resource',Allresources)

        }*.getAt(0)


        List<Topic> topicList = Topic.list(params)
        render(view: 'login', model: [resources: rList, total: Resource.count(), topic: topposts])

    }
    def login = {
        render params
        String u = params.username;
        String p = params.password;
        print(u)
        User u1 = User.findByUsername(u)
        if (u1?.password == p) {

            session["user"] = u1.username;
            if (u1.active==true) {
                if(u1.admin==true)
                    redirect(controller: "user",action: "adminuser")
                else
                    redirect(controller: "Dashboard", action: "index")
            }
            else
                render("<h1>Account Block By Admin</h1>")
        } else {
            render("<h1>Invalid Username / Password</h1>");
        }
    }
    def recent = {
    /*    String email = params.email

        User user = User.findByEmail(email)
        if (user) {
            mailService.sendMail {

                to user.email
                subject "Link Sharing Application Password"
                body "Your Password For Link Sharing Application is " + user.password
                render(view: "/login/login")
            }
            println("Email Sent")

        } else {
            println("No User Found  ")
        }  */
    }

    def register() {

        User u2 = new User(params);

      //  def file = request.getFile('photo')


     //   if (!file.empty) {
           // //  u2.photoName = file.contentType
       //     u2.photo = file.getBytes()

            if (u2.validate()) {

                u2.save(failOnError: true)
                session["user"] = u2.username;
                redirect(controller: "dashboard",action: "index")
            } else {
                render("<h1>Error</h1>");
            }
      //  }
    }
}