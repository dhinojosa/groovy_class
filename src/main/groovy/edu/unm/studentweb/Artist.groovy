package edu.unm.studentweb

import groovy.transform.Canonical

@Canonical
class Artist {
    def firstName
    def lastName
    def getFullName() {
        "$firstName $lastName"
    }
}
