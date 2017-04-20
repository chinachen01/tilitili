package com.focus.tilitili.component.net;

import com.focus.tilitili.app.App;

import java.io.File;

/**
 * Created by focus on 17/4/20.
 */

public class Constants {
    //================= PATH ====================
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";
}
