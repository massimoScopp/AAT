package ch.bailu.aat.views.graph;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

import ch.bailu.aat.dispatcher.DispatcherInterface;
import ch.bailu.aat.dispatcher.OnContentUpdatedInterface;
import ch.bailu.aat.gpx.GpxInformation;
import ch.bailu.aat.gpx.GpxList;
import ch.bailu.aat.gpx.interfaces.GpxType;
import ch.bailu.aat.preferences.SolidUnit;

public abstract class AbsGraphView extends ViewGroup implements OnContentUpdatedInterface {

    public final static int SAMPLE_WIDTH_PIXEL=5;

    private final SolidUnit sunit;
    private final StringBuilder builder = new StringBuilder();

    private boolean markerMode=false;

    private GpxList gpxCache = GpxList.NULL_TRACK;
    private int nodeIndex = -1;


    private boolean showLabel = true;



    public AbsGraphView(Context context, DispatcherInterface di, int... iid) {
        this(context);
        di.addTargets(this, iid);
    }


    public AbsGraphView(Context context) {
        super(context);
        setWillNotDraw(false);
        sunit = new SolidUnit(context);
    }



    @Override
    public void onContentUpdated(int iid, GpxInformation info) {
        onContentUpdated(iid, info, -1);
    }

    public void onContentUpdated(int iid, GpxInformation info, int i) {
        gpxCache = info.getGpxList();
        nodeIndex = i;

        invalidate();
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }


    @Override
    public void onDraw(Canvas c) {
        if (getWidth() > 0 && getHeight() > 0) {
            markerMode = gpxCache.getMarkerList().size() > getWidth() / SAMPLE_WIDTH_PIXEL;
            plot(c, gpxCache, nodeIndex, sunit, markerMode);
        }
    }


    public void showLabel(boolean b) {
        showLabel = b;
    }


    public String plotterLabel(int id, String unit) {
        if (showLabel) {
            builder.setLength(0);
            builder.append(getContext().getString(id));
            builder.append(" [");
            builder.append(unit);
            builder.append("]");
            if (markerMode) builder.append(".");
            return builder.toString();
        } else {
            return "";
        }

    }


    public abstract void plot(Canvas canvas, GpxList list,
                              int index, SolidUnit sunit, boolean markerMode);


    public void setVisibility(GpxInformation info) {
        if (info.isLoaded() && info.getType() == GpxType.ROUTE || info.getType() == GpxType.TRACK) {
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.GONE);
        }

    }
}
