import groovy.transform.Canonical

def list = [1, 2, 3, 4, 5, 6]
println(list.collect { it**3 })
println(list.each { println(it + 1) })
def divBy3Predicate = { it % 3 == 0 }
println(list.find(divBy3Predicate))
println(list.findAll(divBy3Predicate))

def set = [5, 6, 1, 2, 9, 8, 15, 1] as Set
println(set.sort { x, y ->
    println("x:$x y:$y")
    y<=>x
})

@Canonical
class Student {
    def name
    def unm_id
    def status
}

students = [
        new Student(name: "Failure Simpson",
                unm_id: "12398123",
                status: "Y"),
        new Student(name: "John Appleseed",
                unm_id: "12398122",
                status: "N"),
        new Student(name: "Jane Motts",
                unm_id: "12398322",
                status: "Y"),
        new Student(name: "Carlos Jimenez",
                unm_id: "12319322",
                status: "N")]

students.findAll{it.name.startsWith('J')}.collect{
    it.status = (it.status == 'Y' ? 'N' : 'Y')
}

//students.findAll{it.status == 'N'}.collect{it.status = 'Y'}

println(students)
//[Student(Failure Simpson, 12398123, Y),
// Student(John Appleseed, 12398122, Y),
// Student(Jane Motts, 12398322, N),
// Student(Carlos Jimenez, 12319322, N)]