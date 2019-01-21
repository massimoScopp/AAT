package ch.bailu.aat.coordinates;


import org.junit.Test;


import static org.junit.Assert.*;

public class WGS84SexagesimalTest {
    WGS84Sexagesimal.Sexagesimal ws = new WGS84Sexagesimal.Sexagesimal(230.29325);
    WGS84Sexagesimal ws1 = new WGS84Sexagesimal(25.36,186.22);

    @Test
    public void getTest() {
        int deg = ws.getDegree();
        int sec = ws.getSecond();
        int min = ws.getMinute();

        assertEquals(230,deg);
        assertEquals(17,min);
        assertEquals(36,sec);
    }

    @Test
    public void getLatitude() {
        assertEquals("25° 21' 36''",ws1.getLatitude().toString() );
    }


    @Test
    public void getLatitudeChar() {
        assertEquals(78,ws1.getLatitudeChar() );
    }


    @Test
    public void toStringTest() {
        assertNotNull(ws.toString());
    }

    @Test
    public void getLongitude() {
        assertEquals("186° 13' 12''",ws1.getLongitude().toString());
    }

    @Test
    public void getLongitudeChar() {
        assertEquals(69,ws1.getLongitudeChar());}

    @Test
    public void getLongitudeChar1() {
    }
}