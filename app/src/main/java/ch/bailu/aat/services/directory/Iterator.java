package ch.bailu.aat.services.directory;

import java.io.Closeable;

import ch.bailu.aat.gpx.GpxInformation;

public class Iterator implements Closeable {
    public static final Iterator NULL = new Iterator();


    public interface OnCursorChangedListener {
        void onCursorChanged();
    }

    public static final OnCursorChangedListener NULL_LISTENER = new OnCursorChangedListener() {
        @Override
        public void onCursorChanged() {}
    };

    public boolean moveToPrevious() {return false;}


    public boolean moveToNext() {return false;}


    public boolean moveToPosition(int pos) {return false;}


    public int getCount() {
        return 0;
    }


    public int getPosition() {
        return 0;
    }


    public GpxInformation getInfo() {
        return GpxInformation.NULL;
    }


    public void query() {}


    @Override
    public void close() {}


    public void setOnCursorChangedLinsener(OnCursorChangedListener l) {}

}
