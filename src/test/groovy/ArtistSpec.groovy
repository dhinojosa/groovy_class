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
          englebert.toString() == "edu.unm.studentweb.Artist(Englebert, Humperdinck)"
          englebert == englebert2
          englebert2 == englebert
          englebert != torme
          englebert != "54"
          englebert.is(englebert)

          englebert.hashCode() == englebert.hashCode() //This rule has to pass
          englebert.hashCode() == englebert2.hashCode()

          //trying out a list
          def list = [1,2,3,4,5,5,6]
          list.size() == 7
          println list.class.name

          /* Sets have to be unique!*/
          Set set = [1,2,3,4,5,5,6] //coercion
          set.class.name.contains('Set')
          println (set.class.name)
          set.size() == 6
          println (set)

          Set artistSet = [englebert,englebert,torme,englebert2]
          artistSet.size() == 2


   }
}
