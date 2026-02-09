// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.input;

import org.cef.misc.EventFlags;

/**
 * Mouse wheel event information used for direct wheel event injection via
 * {@code CefBrowser.sendCefMouseWheelEvent}.
 */
public class CefMouseWheelEvent {
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
     * Horizontal wheel delta.
     */
    public int delta_x = 0;

    /**
     * Vertical wheel delta.
     */
    public int delta_y = 0;

    public CefMouseWheelEvent() {}

    public CefMouseWheelEvent(int x, int y, int modifiers, int delta_x, int delta_y) {
        this.x = x;
        this.y = y;
        this.modifiers = modifiers;
        this.delta_x = delta_x;
        this.delta_y = delta_y;
    }

    @Override
    public String toString() {
        return "CefMouseWheelEvent[x=" + x + ", y=" + y + ", modifiers=" + modifiers
                + ", delta_x=" + delta_x + ", delta_y=" + delta_y + "]";
    }
}
