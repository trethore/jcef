// Copyright (c) 2026 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

#include "CefRunContextMenuCallback_N.h"
#include "include/cef_context_menu_handler.h"
#include "jni_scoped_helpers.h"

namespace {

CefRefPtr<CefRunContextMenuCallback> GetSelf(jlong self) {
  return reinterpret_cast<CefRunContextMenuCallback*>(self);
}

void ClearSelf(JNIEnv* env, jobject obj) {
  // Clear the reference added in ContextMenuHandler::RunContextMenu.
  SetCefForJNIObject<CefRunContextMenuCallback>(env, obj, nullptr,
                                                "CefRunContextMenuCallback");
}

}  // namespace

JNIEXPORT void JNICALL
Java_org_cef_callback_CefRunContextMenuCallback_1N_N_1Continue(
    JNIEnv* env,
    jobject obj,
    jlong self,
    jint command_id,
    jint event_flags) {
  CefRefPtr<CefRunContextMenuCallback> callback = GetSelf(self);
  if (!callback)
    return;

  callback->Continue(command_id, static_cast<cef_event_flags_t>(event_flags));
  ClearSelf(env, obj);
}

JNIEXPORT void JNICALL
Java_org_cef_callback_CefRunContextMenuCallback_1N_N_1Cancel(JNIEnv* env,
                                                             jobject obj,
                                                             jlong self) {
  CefRefPtr<CefRunContextMenuCallback> callback = GetSelf(self);
  if (!callback)
    return;

  callback->Cancel();
  ClearSelf(env, obj);
}
