// Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.handler;

/** Describes how a requested navigation should be opened. */
public enum CefWindowOpenDisposition {
    UNKNOWN(0),
    CURRENT_TAB(1),
    SINGLETON_TAB(2),
    NEW_FOREGROUND_TAB(3),
    NEW_BACKGROUND_TAB(4),
    NEW_POPUP(5),
    NEW_WINDOW(6),
    SAVE_TO_DISK(7),
    OFF_THE_RECORD(8),
    IGNORE_ACTION(9),
    SWITCH_TO_TAB(10),
    NEW_PICTURE_IN_PICTURE(11),
    NEW_SPLIT_VIEW(12);

    private final int value;

    CefWindowOpenDisposition(int value) {
        this.value = value;
    }

    /**
     * Returns the disposition matching the native CEF value. Unknown and future values map to
     * {@link #UNKNOWN}.
     */
    public static CefWindowOpenDisposition fromValue(int value) {
        for (CefWindowOpenDisposition disposition : values()) {
            if (disposition.value == value) return disposition;
        }
        return UNKNOWN;
    }
}
