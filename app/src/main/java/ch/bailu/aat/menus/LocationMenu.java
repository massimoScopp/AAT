package ch.bailu.aat.menus;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;

import org.mapsforge.core.model.LatLong;

import ch.bailu.aat.R;
import ch.bailu.aat.coordinates.Coordinates;
import ch.bailu.aat.map.MapViewInterface;
import ch.bailu.aat.util.Clipboard;
import ch.bailu.aat.util.ui.AppLog;

public class LocationMenu extends AbsMenu{

    private final MapViewInterface map;
    private final Context context;
    private final Clipboard clipboard;

    private MenuItem send, view, copy, paste;
    
    
    public LocationMenu(MapViewInterface m) {
        map = m;
        context = m.getMContext().getContext();
        clipboard = new Clipboard(context);
    }


    @Override
    public void inflate(Menu menu) {
        send = menu.add(R.string.location_send);
        view = menu.add(R.string.location_view);
        copy = menu.add(R.string.clipboard_copy);
        paste = menu.add(R.string.clipboard_paste);
        
    }

    @Override
    public String getTitle() {
        return context.getString(R.string.location_title);
    }


    @Override
    public Drawable getIcon() {
        return null;
    }

     @Override
    public void prepare(Menu menu) {
        paste.setEnabled(clipboard.getText() != null);
    }

    
    @Override
    public boolean onItemClick(MenuItem item) {
        if (item == send) {
            send();

        } else if (item == view) {
            view();

        } else if (item == copy) {
            copy();

        } else if (item == paste) {
            paste();
        }
        return false;
    }

    

    private void paste() {
        final String s = clipboard.getText().toString();

        try {
            LatLong p = Coordinates.stringToGeoPoint(s);
            map.setCenter(p);
        } catch (NumberFormatException e) {
            AppLog.d(this, s);
        }

    }

    private void copy() {
        clipboard.setText("GEO location", Coordinates.geoPointToGeoUri(getCenter()));
    }

    private void view() {
        final Intent intent = new Intent(Intent.ACTION_VIEW);
        final LatLong center = getCenter();
        final Uri uri = Uri.parse(Coordinates.geoPointToGeoUri(center));

        intent.setData(uri);
        context.startActivity(Intent.createChooser(intent, uri.toString()));
    }


    private void send() {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        final LatLong center = getCenter();


        final String url = Coordinates.geoPointToGeoUri(center);
        final String desc = Coordinates.geoPointToDescription(center);
        final String body = desc+ "\n\n" + url;   


        intent.setType("label/plain");
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, url);
        intent.putExtra(android.content.Intent.EXTRA_TEXT, body);
        context.startActivity(Intent.createChooser(intent, url));
    }
    
    private LatLong getCenter() {
        return map.getMapViewPosition().getCenter();
    }
    
}
