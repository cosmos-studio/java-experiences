import beans.Someone
import beans.Speaker
import spock.lang.Specification

class SpockDemoSpec extends Specification {

    def setupSpec() {
        println "spec-setup"
    }

    def setup() {
        println "unit-setup"
    }

    def cleanup() {
        println "unit-clearnup"
    }

    def cleanupSpec() {
        println "spec-clearnup"
    }

    def "say hello v1"() {
        given:
        def hello = new Speaker()

        expect:
        hello.sayHello(name).equals("hello "+name)

        where:
        name << ["Jacob", "Jone"]
    }

    def "say Hello v2"() {
        given:
        def hello = new Speaker()
        def sb = Mock(Someone)
        sb.getName() >> name

        expect:
        hello.sayHello(sb) == "hello "+name

        where:
        name << ["someone1", "someone2"]
    }

    def "only a simple test"() {

        println ">> testing...."

        expect:
        1 == 1

    }

    def "computing the maximum of two numbers v1"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

    def "computing the maximum of two numbers v2"(int a, int b, int c) {
        println("testing ...")

        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }



}