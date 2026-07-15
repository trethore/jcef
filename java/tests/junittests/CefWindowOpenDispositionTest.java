// Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package tests.junittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.handler.CefLifeSpanHandlerAdapter;
import org.cef.handler.CefRequestHandlerAdapter;
import org.cef.handler.CefWindowOpenDisposition;
import org.junit.jupiter.api.Test;

class CefWindowOpenDispositionTest {
    @Test
    void mapsKnownNativeValues() {
        CefWindowOpenDisposition[] values = CefWindowOpenDisposition.values();
        for (int i = 0; i < values.length; ++i) {
            assertEquals(values[i], CefWindowOpenDisposition.fromValue(i));
        }
    }

    @Test
    void mapsUnknownNativeValuesToUnknown() {
        assertEquals(CefWindowOpenDisposition.UNKNOWN,
                CefWindowOpenDisposition.fromValue(Integer.MIN_VALUE));
        assertEquals(
                CefWindowOpenDisposition.UNKNOWN, CefWindowOpenDisposition.fromValue(1000));
    }

    @Test
    void extendedCallbacksDelegateToLegacyAdapterMethods() {
        CefLifeSpanHandlerAdapter lifeSpanHandler = new CefLifeSpanHandlerAdapter() {
            @Override
            public boolean onBeforePopup(CefBrowser browser, CefFrame frame,
                    String targetUrl, String targetFrameName) {
                return true;
            }
        };
        assertTrue(lifeSpanHandler.onBeforePopup(null, null, 1, "https://example.test", "",
                CefWindowOpenDisposition.NEW_POPUP, true));

        CefRequestHandlerAdapter requestHandler = new CefRequestHandlerAdapter() {
            @Override
            public boolean onOpenURLFromTab(
                    CefBrowser browser, CefFrame frame, String targetUrl, boolean userGesture) {
                return true;
            }
        };
        assertTrue(requestHandler.onOpenURLFromTab(null, null, "https://example.test",
                CefWindowOpenDisposition.NEW_FOREGROUND_TAB, true));
    }
}
