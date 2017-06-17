package com.xuliwen.basecode.javacode.xuliehua.pacelable;

/**
 * Created by xlw on 2017/6/4.
 */

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by dongyayun on 16/1/17.
 */
public class ParcelableUtil {
    public static byte[] marshall(Parcelable parceable) {
        Parcel parcel = Parcel.obtain();
        parcel.setDataPosition(0);
        parceable.writeToParcel(parcel, 0);
        byte[] bytes = parcel.marshall();

        Log.d("ParcelableTest", "bytes = " + String.valueOf(bytes) + "parcel" + parcel.toString());
        parcel.recycle();
        return bytes;
    }

    public static Parcel unMarshall(byte[] bytes) {
        Parcel parcel = Parcel.obtain();
        parcel.unmarshall(bytes, 0, bytes.length);
        parcel.setDataPosition(0);
        return parcel;
    }

}