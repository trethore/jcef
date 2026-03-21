// Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.browser;

import org.cef.CefBrowserSettings;
import org.cef.CefClient;

import java.awt.Point;

/**
 * Public base class for custom windowless browser implementations.
 *
 * <p>This fork does not provide the old built-in JOGL OSR browser anymore.
 * Instead, applications can extend this class and provide their own
 * renderer-agnostic integration using {@code CefRenderHandler} callbacks such
 * as {@code onPaint} or {@code onAcceleratedPaint}.
 */
public abstract class CefBrowserWindowless extends CefBrowser_N {
    protected CefBrowserWindowless(CefClient client, String url, CefRequestContext context,
            CefBrowserSettings settings) {
        this(client, url, context, null, null, settings);
    }

    protected CefBrowserWindowless(CefClient client, String url, CefRequestContext context,
            CefBrowserWindowless parent, Point inspectAt, CefBrowserSettings settings) {
        super(client, url, context, parent, inspectAt, settings);
    }

    protected abstract CefBrowserWindowless createDevToolsBrowserWindowless(CefClient client,
            String url, CefRequestContext context, CefBrowserWindowless parent, Point inspectAt);

    @Override
    protected final CefBrowserWindowless createDevToolsBrowser(CefClient client, String url,
            CefRequestContext context, CefBrowser_N parent, Point inspectAt) {
        CefBrowserWindowless windowlessParent =
                parent instanceof CefBrowserWindowless ? (CefBrowserWindowless) parent : null;
        return createDevToolsBrowserWindowless(client, url, context, windowlessParent,
                inspectAt);
    }
}
