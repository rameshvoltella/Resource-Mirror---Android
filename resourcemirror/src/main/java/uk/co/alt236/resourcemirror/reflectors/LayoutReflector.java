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

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirror.reflectors.base.AbstractResourceReflector;

public final class LayoutReflector extends AbstractResourceReflector {
    private static final ResourceType RESOURCE_TYPE = ResourceType.LAYOUT;
    private final String TAG = getClass().getSimpleName();

    protected LayoutReflector(final String packageName) {
        super(packageName);
    }

    @NonNull
    @Override
    protected String getLogTag() {
        return TAG;
    }

    @NonNull
    @Override
    public ResourceType getResourceType() {
        return RESOURCE_TYPE;
    }

    @LayoutRes
    @Override
    public int getResourceId(@NonNull final String resourceName) {
        return super.getResourceId(resourceName);
    }

    @LayoutRes
    @Override
    public int getResourceId(@NonNull final String resourceName, final String family) {
        return super.getResourceId(resourceName, family);
    }

    @LayoutRes
    @Override
    public int optResourceId(@NonNull final String resourceName,
                             @LayoutRes final int fallbackResourceId) {
        return super.optResourceId(resourceName, fallbackResourceId);
    }

    @LayoutRes
    @Override
    public int optResourceId(@NonNull final String resourceName,
                             @Nullable final String family,
                             @LayoutRes final int fallbackResourceId) {
        return super.optResourceId(resourceName, family, fallbackResourceId);
    }
}
