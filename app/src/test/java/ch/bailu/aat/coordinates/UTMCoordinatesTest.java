package ch.bailu.aat.coordinates;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UTMCoordinatesTest {

    @BeforeEach
    void setUp() throws AssertionError {
        testUTM();
    }

    @Test
    public void testUTM()  throws AssertionError {
        testUTM(48.024089, 7.789636, 5319686, 409755, 32);
        testUTM(-34.168281d,18.424966d, 6216188, 262641, 34);
        testUTM(51.624837d,-3.960800d, 5719750, 433491, 30);
        testUTM(47.617273d, -122.262268d, 5274027, 555437, 10);
    }

    @Test
    private void testUTM(double la, double lo, int n, int e , int z) throws AssertionError {
        UTMCoordinates utm = new UTMCoordinates(la,lo);

        assertEquals(z, utm.getZone());
        assertEquals(n, utm.getNorthing());
        assertEquals(e, utm.getEasting());
        assertEquals((la <0), utm.isInSouthernHemnisphere());

        LatLongE6 p=utm.toLatLongE6();
        assertEquals((int)la*1000, (int)(p.getLatitudeE6()/1e6)*1000);
        assertEquals((int)lo*1000, (int)(p.getLongitudeE6()/1e6)*1000);
        assertNotNull(utm.toString(),"tostring non è nullo");
    }



    @After
    void tearDown() {
    }
}