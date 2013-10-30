/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hq.deskclock;

import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.util.Log;

public class AlarmInitReceiver extends BroadcastReceiver {

    /**
     * Sets alarm on ACTION_BOOT_COMPLETED.  Resets alarm on
     * TIME_SET, TIMEZONE_CHANGED
     * 鎺ュ彈寮�鏈哄惎鍔ㄥ畬鎴愮殑骞挎挱锛�
     * 璁剧疆闂归挓锛屽綋鏃跺尯鏀瑰彉涔熻缃�
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.v("wangxianming", "AlarmInitReceiver" + action);

        // Remove the snooze alarm after a boot.
        if (action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Alarms.saveSnoozeAlert(context, -1, -1);
        }

        Alarms.disableExpiredAlarms(context);
        Alarms.setNextAlert(context);
    }
}
