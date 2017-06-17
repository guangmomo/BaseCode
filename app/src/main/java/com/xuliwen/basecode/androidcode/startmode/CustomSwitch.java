package com.xuliwen.basecode.androidcode.startmode;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.sax.RootElement;
import android.util.AttributeSet;
import android.widget.Switch;

/**
 * Created by xlw on 2017/6/5.
 */

public class CustomSwitch extends Switch {
    private int customState;

    public CustomSwitch(Context context) {
        super(context);
    }

    public CustomSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setCustomState(int customState) {
        this.customState = customState;
    }

    public int getCustomState(){
        return customState;
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.state = customState;
        return ss;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCustomState(ss.state);
    }

    static class SavedState extends BaseSavedState {
        int state;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            state = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(state);
        }

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}