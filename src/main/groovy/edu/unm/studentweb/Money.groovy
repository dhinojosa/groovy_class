package edu.unm.studentweb

@groovy.transform.Immutable
class Money implements Comparable<Money> {
    Long amount = 0L
    String currency = "USD"


    def plus(Money money) {
        checkMatchingCurrency(money)

        new Money(amount: (this.amount + money.amount),
                currency:currency)
    }

    private void checkMatchingCurrency(Money money) {
        if (this.currency != money.currency)
            throw new IllegalStateException("Currencies don't match")
    }

    def minus(Money money) {
        checkMatchingCurrency(money)

        new Money(amount: (this.amount - money.amount),
                currency:currency)
    }

    @Override
    int compareTo(Money money) {
       this.amount <=> money.amount
    }

    Money next() {
        new Money(amount + 1, currency)
    }

    Money previous() {
        new Money(amount - 1, currency)
    }
}
