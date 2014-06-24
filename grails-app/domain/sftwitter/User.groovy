package sftwitter

class User {

    String name

    static constraints = {
        name(null:false)
    }
    def String user(){
        return name
    }
}
