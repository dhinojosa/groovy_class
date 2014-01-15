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
          def oneDollar = new Money(amount:1, currency:"USD")
          def twelveDollars =
                  new Money(amount:12, currency:"USD")

        when:
          def total = oneDollar.plus(twelveDollars)

        then:
          total == new Money(amount:13, currency: "USD")
          //Remind myself to talk about this next item
          oneDollar.amount == 1
          twelveDollars.amount == 12

    }

    def "Should not allow currency differences"() {}
}
