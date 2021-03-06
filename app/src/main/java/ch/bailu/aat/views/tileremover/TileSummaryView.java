package ch.bailu.aat.views.tileremover;


import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import ch.bailu.aat.preferences.SolidTrimIndex;
import ch.bailu.aat.services.tileremover.SourceSummaryInterface;

public class TileSummaryView implements View.OnClickListener {
    private final RadioButton radioButton;
    private final TextView textView;
    private final RadioGroup parent;

    public TileSummaryView(RadioGroup p, int id) {
        parent = p;

        radioButton = new RadioButton(p.getContext());
        radioButton.setId(id);
        radioButton.setOnClickListener(this);

        textView = new TextView(p.getContext());

        p.addView(radioButton);
        p.addView(textView);
    }

    public void destroy() {
        parent.removeView(radioButton);
        parent.removeView(textView);
    }

    public void setTitle(String title) {
        radioButton.setText(title);
    }


    public StringBuilder displaySummaryReport(StringBuilder builder, SourceSummaryInterface summary) {
        builder.setLength(0);
        textView.setText(summary.buildReport(builder).toString());

        return builder;
    }


    public void select() {
        radioButton.toggle();
    }

    public void select(int selected) {
        if (radioButton.getId() == selected) {
            select();
        }
    }


    @Override
    public void onClick(View v) {
        new SolidTrimIndex(parent.getContext()).setValue(v.getId());
    }
}
