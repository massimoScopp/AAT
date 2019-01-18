package ch.bailu.aat.coordinates;

import org.junit.After;

import org.junit.Test;


import static org.junit.Assert.*;


public class SrtmCoordinatesTest {

    double la = 48.024089;
    double lo = 7.789636;
    SrtmCoordinates sc = new SrtmCoordinates(la,lo);
    int la1 = 69;
    int lo1 = 32;
    SrtmCoordinates sc1 = new SrtmCoordinates(la1,lo1);


    @After
    public void tearDown() {
    }

    @Test
    public void toLaStringTest() {
        assertEquals("N48",sc.toLaString());
    }

    @Test
    public void toLoString() {
        assertEquals("E007",sc.toLoString());}


    @Test
    public void toExtString() {
        System.out.println(sc.toExtString());
        assertEquals("N48/N48E007",sc.toExtString());
    }

    @Test
    public void toURL() {
        assertNotNull(sc.toURL());

    }

    @Test
    public void toFile() {

    }

}