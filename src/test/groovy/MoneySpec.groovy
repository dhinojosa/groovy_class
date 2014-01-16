import edu.unm.studentweb.Money
import spock.lang.Specification

class MoneySpec extends Specification {
    def "Create an immutable Money object"() {
        setup:
        def tenDollars = new Money(amount: 10,
                currency: "USD")
        when:
        tenDollars.amount = 20

        then:
        thrown ReadOnlyPropertyException
    }

    def "Should be able to add two money objects together with the same currency"() {
        setup:
        def oneDollar = new Money(amount: 1, currency: "USD")
        def twelveDollars =
                new Money(amount: 12, currency: "USD")

        when:
        def total = oneDollar + twelveDollars

        then:
        total == new Money(amount: 13, currency: "USD")
        oneDollar.amount == 1
        twelveDollars.amount == 12
    }

    def "Should not allow currency differences"() {
        setup:
        def oneDollar = new Money(amount: 1, currency: "USD")
        def twelveEuros =
                new Money(amount: 12, currency: "EUR")

        when:
        oneDollar + twelveEuros

        then:
        thrown IllegalStateException
    }

    def "should be able minus two Money objects"() {
        setup:
        def oneDollar = new Money(amount: 1, currency: "USD")
        def twelveDollars =
                new Money(amount: 12, currency: "USD")

        when:
        def total = oneDollar - twelveDollars

        then:
        total == new Money(amount: -11, currency: "USD")
    }

    def "minus() should not allow currency differences"() {
        setup:
        def oneDollar = new Money(amount: 1, currency: "USD")
        def twelveEuros =
                new Money(amount: 12, currency: "EUR")

        when:
        oneDollar - twelveEuros

        then:
        thrown IllegalStateException
    }

    def "Money objects should be comparable"() {
        setup:
        def oneDollar = new Money(amount: 1, currency: "USD")
        def twelveDollars =
                new Money(amount: 12, currency: "USD")

        when:
        def result = oneDollar.compareTo(twelveDollars)

        then:
        result < 0
    }

    def "Money table"() {
        expect:
        amount1 <=> amount2 == result

        where:
        amount1               | amount2               | result
        new Money(123, "USD") | new Money(3, "USD")   | +1
        new Money(1, "USD")   | new Money(3, "USD")   | -1
        new Money(3, "USD")   | new Money(3, "USD")   | 0
        new Money(-13, "USD") | new Money(-13, "USD") | 0
    }

    def "test Sorting With A Sorted Set"() {
        setup:
        def s =
        [new Money(123, "USD"), new Money(3, "USD")] as SortedSet

        expect:
        s.first() == new Money(3, "USD")
    }

    def "Money should increment and decrement"() {
        setup:
        def baseAmount = new Money(500, "USD")

        expect:
        ++baseAmount == new Money(501, "USD")
        --baseAmount == new Money(500, "USD")
    }

    def "We now have our own ranges"() {
        setup:
        def moneyRange = new Money(5, "USD") .. new Money(10, "USD")

        expect:
        for (i in moneyRange) {
            println(i)
        }

        moneyRange[0] == new Money(5, "USD")
        moneyRange[1] == new Money(6, "USD")
        moneyRange[2] == new Money(7, "USD")
        moneyRange[4] == new Money(9, "USD")
    }
}
