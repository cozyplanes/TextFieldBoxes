package studio.carbonylgroup.textfieldboxes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Text Field Boxes
 * Created by CarbonylGroup on 2017/08/25
 */
public class ClipToBoundsView extends RelativeLayout {

    Context context;
    Path clipPath = new Path();
    Rect rect = new Rect();
    RectF rectF = new RectF();
    Float cornerRadius;
    Canvas canvas;

    public ClipToBoundsView(Context context) {

        super(context);
        this.context = context;
        init();
    }

    public ClipToBoundsView(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.context = context;
        init();
    }

    public ClipToBoundsView(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    protected void init() {
        cornerRadius = context.getResources().getDimension(R.dimen.text_field_boxes_corner_radius);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.getClipBounds(rect);
        rectF.set(rect);
        clipPath.addRoundRect(rectF, cornerRadius, cornerRadius, Path.Direction.CW);
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}
