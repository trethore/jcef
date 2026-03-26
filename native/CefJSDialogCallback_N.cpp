// Copyright (c) 2014 The Chromium Embedded Framework Authors. All rights
// reserved. Use of this source code is governed by a BSD-style license that
// can be found in the LICENSE file.

#include "CefJSDialogCallback_N.h"
#include "include/base/cef_callback.h"
#include "include/cef_jsdialog_handler.h"
#include "include/cef_task.h"
#include "include/wrapper/cef_closure_task.h"
#include "jni_scoped_helpers.h"
#include "jni_util.h"

namespace {

CefRefPtr<CefJSDialogCallback> GetSelf(jlong self) {
  return reinterpret_cast<CefJSDialogCallback*>(self);
}

void ClearSelf(JNIEnv* env, jobject obj) {
  // Clear the reference added in JSDialogHandler::OnJSDialog and
  // JSDialogHandler::OnBeforeUnloadDialog.
  SetCefForJNIObject<CefJSDialogCallback>(env, obj, nullptr,
                                          "CefJSDialogCallback");
}

void ContinueOnUIThread(CefRefPtr<CefJSDialogCallback> callback,
                        bool success,
                        CefString user_input) {
  callback->Continue(success, user_input);
}

}  // namespace

JNIEXPORT void JNICALL
Java_org_cef_callback_CefJSDialogCallback_1N_N_1Continue(JNIEnv* env,
                                                         jobject obj,
                                                         jlong self,
                                                         jboolean jsuccess,
                                                         jstring juser_input) {
  CefRefPtr<CefJSDialogCallback> callback = GetSelf(self);
  if (!callback)
    return;

  const bool success = (jsuccess != JNI_FALSE);
  CefString user_input = GetJNIString(env, juser_input);

  if (CefCurrentlyOn(TID_UI)) {
    callback->Continue(success, user_input);
  } else {
    CefPostTask(TID_UI, CefCreateClosureTask(base::BindOnce(
                            &ContinueOnUIThread, callback, success,
                            user_input)));
  }

  ClearSelf(env, obj);
}
