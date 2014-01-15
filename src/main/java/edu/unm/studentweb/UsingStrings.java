package edu.unm.studentweb;

/**
 * Created by dhino_000 on 1/15/14.
 */
public class UsingStrings {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setFirstName("Bob");
        e.setLastName("Barker");

        Employee f = new Employee();
        f.setFirstName("Bob");
        f.setLastName("Barker");

//        System.out.println(e.equals(f));
//        System.out.println(e == f);

        String a = "Bob Sagat";
        String b = "Bob Sagat";
        String c = new String("Bob Sagat");


        System.out.println(a == b);
        System.out.println(b == c);

        String d = c.intern();
        System.out.println(b == d);

        System.out.println(a.equals(d));
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

    }
}
