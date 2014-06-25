package mytwitter

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tweet)
class TweetSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {

        when:
        def user = new User(name:"test")
        def tweet = new Tweet(user:user, content: "This is my tweet")

        then:
        tweet.user.name == "test"
    }
}
