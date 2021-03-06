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

package uk.co.alt236.resourcemirror;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.alt236.resourcemirror.reflectors.AnimationReflector;
import uk.co.alt236.resourcemirror.reflectors.AnimatorReflector;
import uk.co.alt236.resourcemirror.reflectors.ArrayLoaderReflector;
import uk.co.alt236.resourcemirror.reflectors.AttrReflector;
import uk.co.alt236.resourcemirror.reflectors.BooleanReflector;
import uk.co.alt236.resourcemirror.reflectors.ColorReflector;
import uk.co.alt236.resourcemirror.reflectors.DimenReflector;
import uk.co.alt236.resourcemirror.reflectors.DrawableReflector;
import uk.co.alt236.resourcemirror.reflectors.FractionReflector;
import uk.co.alt236.resourcemirror.reflectors.IdReflector;
import uk.co.alt236.resourcemirror.reflectors.IntegerReflector;
import uk.co.alt236.resourcemirror.reflectors.InterpolatorReflector;
import uk.co.alt236.resourcemirror.reflectors.LayoutReflector;
import uk.co.alt236.resourcemirror.reflectors.MenuReflector;
import uk.co.alt236.resourcemirror.reflectors.MipMapReflector;
import uk.co.alt236.resourcemirror.reflectors.PluralsReflector;
import uk.co.alt236.resourcemirror.reflectors.RawReflector;
import uk.co.alt236.resourcemirror.reflectors.ReflectorFactory;
import uk.co.alt236.resourcemirror.reflectors.StringReflector;
import uk.co.alt236.resourcemirror.reflectors.StyleReflector;
import uk.co.alt236.resourcemirror.reflectors.StyleableReflector;
import uk.co.alt236.resourcemirror.reflectors.XmlReflector;
import uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector;

public class Mirror {
    private static final Object MAP_LOCK = new Object();
    private static final Map<String, Mirror> MAP_OF_MIRRORS = new HashMap<>();

    private final ReflectorFactory mReflectorFactory;
    private final String mPackageName;

    private Mirror(@NonNull final String packageName) {
        mPackageName = packageName;
        mReflectorFactory = new ReflectorFactory(mPackageName);
    }

    /**
     * Gets the appropriate Resource loader for the requested {@link ResourceType};
     *
     * @param resource the {@link ResourceType} needed.
     * @return the {@link uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector} requested
     * @throws java.lang.IllegalArgumentException if an unknown or null {@link ResourceType} is requested.
     */
    public ResourceReflector get(@NonNull final ResourceType resource) {
        return mReflectorFactory.get(resource);
    }

    @NonNull
    public AnimationReflector getAnimations() {
        return mReflectorFactory.getAnimations();
    }

    @NonNull
    public AnimatorReflector getAnimators() {
        return mReflectorFactory.getAnimators();
    }

    @NonNull
    public ArrayLoaderReflector getArrays() {
        return mReflectorFactory.getArrays();
    }

    @NonNull
    public AttrReflector getAttrs() {
        return mReflectorFactory.getAttrs();
    }

    @NonNull
    public BooleanReflector getBooleans() {
        return mReflectorFactory.getBooleans();
    }

    @NonNull
    public ColorReflector getColors() {
        return mReflectorFactory.getColors();
    }

    @NonNull
    public DimenReflector getDimens() {
        return mReflectorFactory.getDimens();
    }

    @NonNull
    public DrawableReflector getDrawables() {
        return mReflectorFactory.getDrawables();
    }

    @NonNull
    public FractionReflector getFractions() {
        return mReflectorFactory.getFractions();
    }

    @NonNull
    public IdReflector getIds() {
        return mReflectorFactory.getIds();
    }

    @NonNull
    public IntegerReflector getIntegers() {
        return mReflectorFactory.getIntegers();
    }

    @NonNull
    public InterpolatorReflector getInterpolators() {
        return mReflectorFactory.getInterpolators();
    }

    @NonNull
    public LayoutReflector getLayouts() {
        return mReflectorFactory.getLayouts();
    }

    @NonNull
    public MenuReflector getMenus() {
        return mReflectorFactory.getMenus();
    }

    @NonNull
    public MipMapReflector getMipMaps() {
        return mReflectorFactory.getMipMaps();
    }

    @NonNull
    public PluralsReflector getPlurals() {
        return mReflectorFactory.getPlurals();
    }

    @NonNull
    public RawReflector getRaws() {
        return mReflectorFactory.getRaws();
    }

    @NonNull
    public StringReflector getStrings() {
        return mReflectorFactory.getStrings();
    }

    @NonNull
    public StyleableReflector getStyleables() {
        return mReflectorFactory.getStyleables();
    }

    @NonNull
    public StyleReflector getStyles() {
        return mReflectorFactory.getStyles();
    }

    @NonNull
    public XmlReflector getXmls() {
        return mReflectorFactory.getXmls();
    }

    @NonNull
    public String getPackageName() {
        return mPackageName;
    }

    /**
     * Retrieves a list of all Resource types that the R class is aware of.
     *
     * @return the list of Resource types.
     */
    @NonNull
    public List<String> getResourceTypes() {
        return getDrawables().getAllResourceTypes();
    }

    public static void clear() {
        synchronized (MAP_LOCK) {
            MAP_OF_MIRRORS.clear();
        }
    }

    public static int getNumberOfMirrors() {
        synchronized (MAP_LOCK) {
            return MAP_OF_MIRRORS.size();
        }
    }

    /**
     * Returns an instance of the {@link Mirror}
     *
     * @param context A standard Android context. It cannot be null.
     * @return The instance of the {@link Mirror}
     */
    @NonNull
    public static Mirror of(@NonNull final Context context) {
        return of(getPackageName(context));
    }

    /**
     * Returns an instance of the {@link Mirror}
     *
     * @param packageName The package name to try and reflect off.
     * @return The instance of the {@link Mirror}
     */
    @NonNull
    public static Mirror of(@NonNull final String packageName) {
        synchronized (MAP_LOCK) {
            if (!MAP_OF_MIRRORS.containsKey(packageName)) {
                MAP_OF_MIRRORS.put(packageName, new Mirror(packageName));
            }
        }

        return MAP_OF_MIRRORS.get(packageName);
    }

    /**
     * Returns the package name associated with a given {@link Context}.
     * This method is used internally by {@link Mirror#of(Context)}.
     *
     * @param context A standard Android context. It cannot be null.
     * @return The package name.
     */
    public static String getPackageName(@NonNull final Context context) {
        return context.getApplicationContext().getPackageName();
    }
}
