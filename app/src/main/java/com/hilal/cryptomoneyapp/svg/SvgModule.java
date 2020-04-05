package com.hilal.cryptomoneyapp.svg;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;

import androidx.annotation.NonNull;

import java.io.InputStream;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;


@GlideModule
public class SvgModule extends AppGlideModule {
    @Override
    public void registerComponents(
            @NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        registry.register(SVG.class, PictureDrawable.class, new SvgDrawableTranscode())
                .append(InputStream.class, SVG.class, new SvgDecode());
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}