// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.misc;

import java.awt.Rectangle;

/**
 * Class representing a rectangle.
 */
public class CefRect {
    public int x;
    public int y;
    public int width;
    public int height;

    public CefRect() {}

    public CefRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public CefRect(Rectangle rectangle) {
        this(rectangle != null ? rectangle.x : 0, rectangle != null ? rectangle.y : 0,
                rectangle != null ? rectangle.width : 0, rectangle != null ? rectangle.height : 0);
    }

    public Rectangle toRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public void set(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
