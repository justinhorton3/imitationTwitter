package sftwitter

class Tweet {

    String content
    Date sent
    User author = new User()

    static constraints = {
        content(null:false, length:1..140)
    }
}
