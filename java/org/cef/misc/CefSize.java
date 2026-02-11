// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.misc;

import java.awt.Dimension;

/**
 * Class representing a size.
 */
public class CefSize {
    public int width;
    public int height;

    public CefSize() {}

    public CefSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public CefSize(Dimension dimension) {
        this(dimension != null ? dimension.width : 0, dimension != null ? dimension.height : 0);
    }

    public Dimension toDimension() {
        return new Dimension(width, height);
    }

    public void set(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
