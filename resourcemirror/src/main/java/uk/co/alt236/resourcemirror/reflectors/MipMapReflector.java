/*
 * Copyright 2015 Alexandros Schillings
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

package uk.co.alt236.resourcemirror.reflectors;


import android.util.Log;

import uk.co.alt236.resourcemirror.reflectors.base.AbstractResourceReflector;
import uk.co.alt236.resourcemirror.util.ResourceType;

public final class MipMapReflector extends AbstractResourceReflector {
    private static final ResourceType RESOURCE_TYPE = ResourceType.MIPMAP;
    private final String TAG = getClass().getName();

    private MipMapReflector() {
        // We should never be here...
        super(null);
        Log.e(TAG, THE_DEFAULT_CONSTRUCTOR_WAS_CALLED);
        throw new IllegalStateException(THE_DEFAULT_CONSTRUCTOR_WAS_CALLED);

    }

    protected MipMapReflector(final String packageName) {
        super(packageName);
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    public ResourceType getResourceType() {
        return RESOURCE_TYPE;
    }
}
