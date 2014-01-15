package edu.unm.studentweb

@groovy.transform.Immutable
class Money {
    Long amount = 0L
    String currency = "USD"

    def plus(Money money) {
      new Money(amount: (this.amount + money.amount),
                currency:currency)
    }
}
