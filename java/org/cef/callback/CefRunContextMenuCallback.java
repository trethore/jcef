// Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

package org.cef.callback;

/**
 * Callback interface used for continuation of custom context menu display.
 */
public interface CefRunContextMenuCallback {
    /**
     * Complete context menu display by selecting the specified command.
     *
     * @param commandId The id of the selected command.
     * @param eventFlags A combination of event flags defined by
     *      {@link org.cef.misc.EventFlags}.
     */
    public void Continue(int commandId, int eventFlags);

    /**
     * Cancel context menu display.
     */
    public void Cancel();
}
