// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.misc;

import java.awt.Point;

/**
 * Class representing a point.
 */
public class CefPoint {
    public int x;
    public int y;

    public CefPoint() {}

    public CefPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CefPoint(Point point) {
        this(point != null ? point.x : 0, point != null ? point.y : 0);
    }

    public Point toPoint() {
        return new Point(x, y);
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
