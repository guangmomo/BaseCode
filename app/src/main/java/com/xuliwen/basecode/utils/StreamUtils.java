package com.xuliwen.basecode.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by xlw on 2017/6/4.
 */

public class StreamUtils {
    public static void close(Closeable closeable){
        if(closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeList(Closeable... closeableList){
        if(closeableList!=null){
                for(Closeable closeable : closeableList){
                    if(closeable!=null){
                        try {
                            closeable.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}
