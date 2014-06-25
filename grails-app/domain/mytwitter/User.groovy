package mytwitter

class User {

    String name

    static hasMany = [tweets: Tweet]
    static constraints = {

        name blank:false, nullable:false, matches: /^[a-zA-Z0-9]{2,20}$/

    }

    @Override
    String toString(){
        return name
    }

}
