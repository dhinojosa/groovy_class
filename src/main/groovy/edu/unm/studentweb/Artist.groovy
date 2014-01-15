package edu.unm.studentweb

/**
 * Created by dhino_000 on 1/14/14.
 */
class Artist {
    def firstName
    def lastName

    Artist() {}

    //CTRL+SHIFT+T shift to test
    Artist(firstName, lastName) {
       this.firstName = firstName
       this.lastName = lastName
    }

    def getFirstName() {
        if (firstName == 'Lionel') println('Oooh. I love Lionel')
        firstName
    }

    def getFullName() {
        "$firstName $lastName"
    }

    //Groovied
    @Override
    String toString() {
       "Artist($firstName, $lastName)"
    }

    @Override
    boolean equals(o) {
        if (!(o instanceof Artist)) return false
        o.firstName.equals(firstName) &&
        o.lastName.equals(lastName)
    }
}
