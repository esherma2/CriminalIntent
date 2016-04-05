package com.bignerdranch.android.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by MCS on 3/24/2016.
 */
public class crimeSceneFragment extends DialogFragment {
    private static final String SUSPECT_IMAGE = "suspect_image";

    public static crimeSceneFragment newInstance(File photoFile){
        Bundle args = new Bundle();
        args.putSerializable(SUSPECT_IMAGE, photoFile);

        crimeSceneFragment fragment = new crimeSceneFragment();
        fragment.setArguments(args);

        return fragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        File photoFile = (File) getArguments().getSerializable(SUSPECT_IMAGE);
        Bitmap image = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.zoom_on_suspect, null);

        ImageView imageView = (ImageView) v.findViewById(R.id.suspect_image);
        imageView.setImageBitmap(image);

        return new AlertDialog.Builder(getActivity()).setView(imageView).create();
    }
}
