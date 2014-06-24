package sftwitter

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

    void "test for tweet holding content"() {
        when: "tweet content is set"
        Tweet tweet = new Tweet(content:"The content of the tweet")
        then: "the content should be held"
        "The content of the tweet" == tweet.content

    }
}
