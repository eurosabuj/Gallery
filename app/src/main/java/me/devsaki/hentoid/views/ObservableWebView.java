package me.devsaki.hentoid.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * WebView implementation with scroll listener
 * http://stackoverflow.com/questions/14752523/how-to-make-a-scroll-listener-for-webview-in-android
 */
public class ObservableWebView extends WebView {
    private OnScrollChangedCallback mOnScrollChangedCallback;

    public ObservableWebView(final Context context) {
        super(context);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public ObservableWebView(final Context context, final AttributeSet attrs, final int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(final int l, final int t, final int oldl, final int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedCallback != null) mOnScrollChangedCallback.onScroll(l, t);
    }

    public OnScrollChangedCallback getOnScrollChangedCallback() {
        return mOnScrollChangedCallback;
    }

    public void setOnScrollChangedCallback(final OnScrollChangedCallback onScrollChangedCallback) {
        mOnScrollChangedCallback = onScrollChangedCallback;
    }

    /**
     * Implement in the activity/fragment/view that you want to listen to the WebView
    */
    public interface OnScrollChangedCallback {
        void onScroll(int l, int t);
    }
}