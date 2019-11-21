/*
 * Copyright (C) 2013-2017 microG Project Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.microg.safeparcel;

import android.os.Parcelable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface SafeParcelable extends Parcelable {
    @Deprecated
    String NULL = "SAFE_PARCELABLE_NULL_STRING";
    int SAFE_PARCEL_OBJECT_MAGIC = 0x4F45;
    @Deprecated
    int SAFE_PARCEL_MAGIC = SAFE_PARCEL_OBJECT_MAGIC;

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Field {
        int value();

        boolean mayNull() default false;

        Class subClass() default SafeParcelable.class;

        boolean useValueParcel() default false;

        long versionCode() default -1;
    }
}
