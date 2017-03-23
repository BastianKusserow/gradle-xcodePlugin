package org.openbakery.util

import spock.lang.Specification

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by stefangugarel on 23/03/2017.
 */
class DateHelperSpecification extends Specification {

    DateHelper dateHelper


    def setup() {
        dateHelper = new DateHelper()
    }

    def "dateHelper parse valid date"() {
        when:
        def result = dateHelper.parseOpenSSLDate("invalid Date")

        then:
        def exception = thrown(ParseException)
        exception.message == "Unparseable date: \"invalid Date\""
    }

    def "dateHelper parse invalid date"() {
        when:
        def result = dateHelper.parseOpenSSLDate("Mar 20 10:16:40 2016 GMT")

        then:

        result.toString()  == "Sun Mar 20 11:16:40 CET 2016"
    }
}
