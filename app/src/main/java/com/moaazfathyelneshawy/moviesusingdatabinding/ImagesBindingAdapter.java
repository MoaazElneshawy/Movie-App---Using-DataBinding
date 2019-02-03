package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImagesBindingAdapter {
    @BindingAdapter("image_src")
    public static void main(ImageView imageView , String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}
