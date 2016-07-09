package com.che.app.weironggou.util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by zhaolong on 16/7/6.
 */
public class PullableListView extends ListView implements Pullable
{

    public PullableListView(Context context)
    {
        super(context);
    }

    public PullableListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public PullableListView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean canPullDown()
    {
        if (getCount() == 0)
        {
            return true;
        } else if (getFirstVisiblePosition() == 0
                && getChildAt(0).getTop() >= 0)
        {
            return true;
        } else
            return false;
    }

    @Override
    public boolean canPullUp()
    {
        if (getCount() == 0)
        {
            return true;
        } else if (getLastVisiblePosition() == (getCount() - 1))
        {
            if (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null
                    && getChildAt(
                    getLastVisiblePosition()
                            - getFirstVisiblePosition()).getBottom() <= getMeasuredHeight())
                return true;
        }
        return false;
    }
}

