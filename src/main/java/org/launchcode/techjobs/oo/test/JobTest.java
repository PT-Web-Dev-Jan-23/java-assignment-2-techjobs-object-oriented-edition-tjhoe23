package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //testSettingJobId checks each object to have a unique ID that is an integer
    @Test
    public void testSettingJobId() {
       Job test1 = new Job();
       Job test2 = new Job();
       assertNotEquals(test1.getId(), test2.getId());
    }

    //testJobConstructorSetsAllFields checks job objects to have 6 fields, with respective data types
    @Test
    public void testJobConstructorSetsAllFields() {
        Job test3 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(test3.getName() instanceof String);
        assertTrue(test3.getEmployer() instanceof Employer);
        assertTrue(test3.getLocation() instanceof Location);
        assertTrue(test3.getPositionType() instanceof PositionType);
        assertTrue(test3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", test3.getName());
        assertEquals("ACME", test3.getEmployer().getValue());
        assertEquals("Desert", test3.getLocation().getValue());
        assertEquals("Quality control", test3.getPositionType().getValue());
        assertEquals("Persistence", test3.getCoreCompetency().getValue());

    }

    //testJobsForEquality checks that the fields are NOT equal if id values are different, even with identical fields
    @Test
    public void testJobsForEquality() {
        Job test4 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job test5 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(test4.equals(test5));
    }

    //testToStringStartsAndEndsWithNewLine checks if toString beigns and ends with \n
    //pass job object, return string with blank line before & after job info
    //string contains label for each field, followed by data from that field
    //each field has its own line
    //"Data not available" if field is empty
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test6 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals('\n', test6.toString().charAt(0));
        assertEquals('\n', test6.toString().charAt(test6.toString().length()-1));
    }

    //testToStringContainsCorrectLabelAndData
    //return with blank line before and after
    //contains
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test7 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals("\nID: " + test7.getId() + "\nName: Product tester\nEmployer: ACME" +
                                "\nLocation: Desert\nPosition Type: Quality control" +
                                    "\nCore Competency: Persistence\n", test7.toString());
    }

    //testToStringHandlesEmptyField
    //If field is empty, add "Data not available" after the label
    @Test
    public void testToStringHandlesEmptyField() {
        Job test8 = new Job("Product tester", new Employer(""),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency(""));

        assertEquals("\nID: " + test8.getId() + "\nName: Product tester\nEmployer: Data not available" +
                "\nLocation: Desert\nPosition Type: Quality control" +
                "\nCore Competency: Data not available\n", test8.toString());
    }

}
