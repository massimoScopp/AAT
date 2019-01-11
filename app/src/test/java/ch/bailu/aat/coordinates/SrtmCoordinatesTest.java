package ch.bailu.aat.coordinates;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SrtmCoordinatesTest {

    double la = 48.024089;
    double lo = 7.789636;
    SrtmCoordinates sc = new SrtmCoordinates(la,lo);
    int la1 = 69;
    int lo1 = 32;
    SrtmCoordinates sc1 = new SrtmCoordinates(la1,lo1);


    @AfterEach
    void tearDown() {
    }

    @Test
    void toLaStringTest() {
        assertEquals("N48",sc.toLaString());
    }

    @Test
    void toLoString() {
        assertEquals("E007",sc.toLoString());}


    @Test
    void toExtString() {
        System.out.println(sc.toExtString());
        assertEquals("N48/N48E007",sc.toExtString());
    }

    @Test
    void toURL() {
        assertNotNull(sc.toURL());

    }

    @Test
    void toFile() {

    }

}