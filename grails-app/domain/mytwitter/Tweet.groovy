package mytwitter

class Tweet {

    String content
    Date dateCreated

    static belongsTo = [user: User]
    static constraints = {

        content blank:false, nullable:false, size:1..120

    }
}
