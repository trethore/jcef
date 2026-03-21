// Copyright (c) 2024 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef;

/**
 * Browser initialization settings. Specify NULL or 0 to get the recommended
 * default values. The consequences of using custom values may not be well
 * tested. Many of these and other settings can also configured using command-
 * line switches.
 */
public class CefBrowserSettings {
    /**
     * The maximum rate in frames per second (fps) that CefRenderHandler::OnPaint
     * will be called for a windowless browser. The actual fps may be lower if
     * the browser cannot generate frames at the requested rate. The minimum
     * value is 1 and the maximum value is 60 (default 30). This value can also
     * be changed dynamically via {@code CefBrowser#setWindowlessFrameRate}
     */
    public int windowless_frame_rate = 0;

    /**
     * Set to true to enable shared textures for windowless rendering. When
     * enabled, CEF delivers GPU-backed frames via
     * {@code CefRenderHandler#onAcceleratedPaint} instead of CPU pixel buffers
     * via {@code CefRenderHandler#onPaint}.
     */
    public boolean shared_texture_enabled = false;

    /**
     * Set to true to let the client drive windowless frame production via
     * {@code CefBrowser#sendExternalBeginFrame()}.
     */
    public boolean external_begin_frame_enabled = false;

    public CefBrowserSettings() {}

    @Override
    public CefBrowserSettings clone() {
        CefBrowserSettings tmp = new CefBrowserSettings();
        tmp.windowless_frame_rate = windowless_frame_rate;
        tmp.shared_texture_enabled = shared_texture_enabled;
        tmp.external_begin_frame_enabled = external_begin_frame_enabled;
        return tmp;
    }
}
