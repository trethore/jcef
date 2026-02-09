// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.input;

import org.cef.misc.EventFlags;

/**
 * Mouse event information used for direct mouse event injection via
 * {@code CefBrowser.sendCefMouseEvent}.
 */
public class CefMouseEvent {
    public static final int MOUSEEVENT_MOVED = 0;
    public static final int MOUSEEVENT_DRAGGED = 1;
    public static final int MOUSEEVENT_ENTERED = 2;
    public static final int MOUSEEVENT_EXITED = 3;
    public static final int MOUSEEVENT_PRESSED = 4;
    public static final int MOUSEEVENT_RELEASED = 5;

    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_LEFT = 1;
    public static final int BUTTON_MIDDLE = 2;
    public static final int BUTTON_RIGHT = 3;

    /**
     * Event type. One of {@code MOUSEEVENT_*}.
     */
    public int type = MOUSEEVENT_MOVED;

    /**
     * X coordinate relative to the browser view.
     */
    public int x = 0;

    /**
     * Y coordinate relative to the browser view.
     */
    public int y = 0;

    /**
     * Bit flags from {@link EventFlags}.
     */
    public int modifiers = 0;

    /**
     * Changed mouse button for press/release. One of {@code BUTTON_*}.
     */
    public int button = BUTTON_NONE;

    /**
     * Click count for press/release events.
     */
    public int click_count = 1;

    public CefMouseEvent() {}

    public CefMouseEvent(int type, int x, int y, int modifiers, int button, int click_count) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.modifiers = modifiers;
        this.button = button;
        this.click_count = click_count;
    }

    @Override
    public String toString() {
        return "CefMouseEvent[type=" + type + ", x=" + x + ", y=" + y + ", modifiers="
                + modifiers + ", button=" + button + ", click_count=" + click_count + "]";
    }
}
