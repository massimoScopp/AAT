package ch.bailu.aat.map.layer.gpx;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.android.graphics.AndroidBitmap;

import ch.bailu.aat.map.MapContext;
import ch.bailu.aat.map.TwoNodes;
import ch.bailu.aat.services.InsideContext;
import ch.bailu.aat.services.ServiceContext;
import ch.bailu.aat.services.cache.ImageObjectAbstract;

public class WayLayer extends GpxLayer {

    private static final int MAX_VISIBLE_NODES=100;
    private static final int ICON_SIZE=20;

    private final MapContext mcontext;
    private final int icon_size;




    public WayLayer(MapContext mc) {
        mcontext = mc;

        icon_size = mcontext.getMetrics().getDensity().toPixel_i(ICON_SIZE);
    }



    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }

    @Override
    public void drawInside(MapContext mcontext) {
        new WayLayer.WayPainter().walkTrack(getGpxList());
    }

    @Override
    public boolean onTap(Point tapXY) {
        return false;
    }

    @Override
    public void onAttached() {

    }

    @Override
    public void onDetached() {

    }


    private class WayPainter extends GpxListPainter {


        private int count = 0;

        public WayPainter() {
            super(mcontext);


        }


        @Override
        public void drawEdge(TwoNodes nodes) {

        }


        @Override
        public void drawNode(final TwoNodes.PixelNode node) {
            if (node.isVisible() && count < MAX_VISIBLE_NODES) {

                final ServiceContext scontext = mcontext.getSContext();
                final android.graphics.Bitmap[] nodeDrawable = {null};

                new InsideContext(scontext) {
                    @Override
                    public void run() {
                        ImageObjectAbstract i = scontext.getIconMapService().getIconSVG(node.point,
                                icon_size);

                        if (i != null)
                            nodeDrawable[0] = i.getBitmap();
                    }
                };

                if (nodeDrawable[0] != null) {
                    mcontext.draw().bitmap(nodeDrawable[0], node.pixel);
                } else {
                    mcontext.draw().bitmap(
                            mcontext.draw().getNodeBitmap(),
                            node.pixel,
                            getColor());
                }

                count++;

            }
        }
    }
}
