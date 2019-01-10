package ch.bailu.aat.coordinates;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CH1903CoordinatesTest {

    @BeforeEach
    void setUp() {
        testCH1903();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public  void testCH1903()  throws AssertionError {
        int n=CH1903Coordinates.BERNE_SIX;
        int e=CH1903Coordinates.BERNE_SIY;

        CH1903Coordinates ch1 = new CH1903Coordinates(e,n);
        CH1903Coordinates ch2 = new CH1903Coordinates(ch1.toLatLongE6());

        assertEquals(n, ch2.getNorthing());
        assertEquals(e, ch2.getEasting());

        /*
        CH1903Coordinates ch4 = new CH1903Coordinates(Sexagesimal.toDecimalDegree(46, 2, 38.87f),
                                                    Sexagesimal.toDecimalDegree(8,43, 49.79f));


        assertEquals(700000, ch4.getEasting());
        assertEquals(100000, ch4.getNorthing());


        GeoPoint p = ch4.toLatLongE6();
        assertEquals((int)Math.round(Sexagesimal.toDecimalDegree(46, 2, 38.87f)*1e6d), p.getLatitudeE6());
        */
    }
}