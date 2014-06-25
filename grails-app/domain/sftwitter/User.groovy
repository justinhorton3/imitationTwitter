package sftwitter

class User {

    String name

    static constraints = {
        name(null:false)
    }
    def String toString(){
        return name
    }
}
