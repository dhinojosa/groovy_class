import edu.unm.studentweb.Artist
import spock.lang.Specification

/**
 * Created by dhino_000 on 1/14/14.
 */

class ArtistSpec extends Specification {

   def "Create an artist and get firstName, lastName, fullName"() {
     setup:
        def artist = new Artist("Lionel", "Ritchie")

     when:
       def firstName = artist.firstName
       def lastName = artist.lastName

     then:
        artist.firstName == artist.getFirstName()
        firstName == "Lionel"
        lastName == "Ritchie"
        artist.fullName == "Lionel Ritchie"
   }

   def "We can call .class.name on anything including Phil"() {
      setup:
        def phil = new Artist("Phil", "Collins")
      when:
        def className = 'edu.unm.studentweb.Artist'
      then:
        phil.class.name == className
   }

   def "Testing Flexible Init"() {
       setup:
         def corey = new Artist(lastName: 'Hart',
                                firstName: 'Corey')
       expect:
         corey.firstName == 'Corey'
         corey.lastName == 'Hart'
   }

   def "Testing the toString(), hashCode(), and equals()"() {
        setup:
          def englebert = new Artist(firstName: "Englebert",
                                     lastName: "Humperdinck")

          def englebert2 = new Artist(firstName: "Englebert",
                                     lastName: "Humperdinck")

          def torme = new Artist(firstName: "Mel",
                                 lastName: "Torme")

       expect:
          englebert.toString() == "Artist(Englebert, Humperdinck)"
          englebert == englebert2
          englebert2 == englebert
          englebert != torme
          englebert == "54"
   }
}
