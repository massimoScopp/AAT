package ch.bailu.aat.coordinates;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

public class UTMCoordinatesTest {

  @Before
  public void setUp(){
      testUTM();
  }

    @Test
    public void testUTM() throws AssertionError {

        UTMCoordinates utm = new UTMCoordinates(48.024089, 7.789636);
        double la = 48.024089;
        double lo = 7.789636;
        int n = 5319686;
        int e = 409755;
        int z = 32;
        assertEquals(z, utm.getZone());
        assertEquals(n, utm.getNorthing());
        assertEquals(e, utm.getEasting());
        assertEquals((la < 0), utm.isInSouthernHemnisphere());
        LatLongE6 p = utm.toLatLongE6();
        assertEquals((int) la * 1000, (int) (p.getLatitudeE6() / 1e6) * 1000);
        assertEquals((int) lo * 1000, (int) (p.getLongitudeE6() / 1e6) * 1000);
        assertNotNull(utm.toString(), "tostring non è nullo");
        assertEquals("Z 32U, E 409,755, N 5319,687",utm.toString());


        UTMCoordinates utm2 = new UTMCoordinates(-34.168281d, 18.424966d);
        la = -34.168281d;
        lo = 18.424966d;
        n = 6216188;
        e = 262641;
        z = 34;
        assertEquals(z, utm2.getZone());
        assertEquals(n, utm2.getNorthing());
        assertEquals(e, utm2.getEasting());
        assertEquals((la < 0), utm2.isInSouthernHemnisphere());
        p = utm2.toLatLongE6();
        assertEquals((int) la * 1000, (int) (p.getLatitudeE6() / 1e6) * 1000);
        assertEquals((int) lo * 1000, (int) (p.getLongitudeE6() / 1e6) * 1000);
        assertNotNull(utm2.toString(), "tostring non è nullo");
        assertEquals("Z 34J, E 262,641, N 6216,188",utm2.toString());


        UTMCoordinates utm3 = new UTMCoordinates(51.624837d, 3.960800d);
        la = 51.624837d;
        lo = 3.960800d;
        n = 5719750;
        e = 566509;
        z = 31;
        assertEquals(z, utm3.getZone());
        assertEquals(n, utm3.getNorthing());
        assertEquals(e, utm3.getEasting());
        assertEquals((la < 0), utm3.isInSouthernHemnisphere());
        p = utm3.toLatLongE6();
        assertEquals((int) la * 1000, (int) (p.getLatitudeE6() / 1e6) * 1000);
        assertEquals((int) lo * 1000, (int) (p.getLongitudeE6() / 1e6) * 1000);
        assertNotNull(utm3.toString(), "tostring non è nullo");
        assertEquals("Z 31U, E 566,509, N 5719,750",utm3.toString());


        UTMCoordinates utm4 = new UTMCoordinates(47.617273d, 122.262268d);
        la = 47.617273d;
        lo = 122.262268d;
        n = 5274027;
        e = 444563;
        z = 51;
        assertEquals(z, utm4.getZone());
        assertEquals(n, utm4.getNorthing());
        assertEquals(e, utm4.getEasting());
        assertEquals((la < 0), utm4.isInSouthernHemnisphere());
        p = utm4.toLatLongE6();
        assertEquals((int) la * 1000, (int) (p.getLatitudeE6() / 1e6) * 1000);
        assertEquals((int) lo * 1000, (int) (p.getLongitudeE6() / 1e6) * 1000);
        assertNotNull(utm4.toString(), "tostring non è nullo");
        String str = "Z 51T, E 444,563, N 5274,027";
        assertEquals(str,utm4.toString());
    }

    @After
    public void tearDown(){
    }
}

//kill 127 llll