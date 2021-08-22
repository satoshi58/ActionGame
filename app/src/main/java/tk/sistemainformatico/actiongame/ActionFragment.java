package tk.sistemainformatico.actiongame;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.lang.reflect.Method;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ActionFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_action, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RelativeLayout layout = (RelativeLayout)view.findViewById(R.id.action_layout);

        //acquire display size
        //display size
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        //real size
        Point realSize = new Point();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            // later than Android 4.2
            display.getRealSize(realSize);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            // later than Android 3.2
            try {
                Method getRawWidth = Display.class.getMethod("getRawWidth");
                Method getRawHeight = Display.class.getMethod("getRawHeight");
                int width = (Integer) getRawWidth.invoke(display);
                int height = (Integer) getRawHeight.invoke(display);
                realSize.set(width, height);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //layout size
        Point layoutSize = new Point();
        layoutSize.set(layout.getWidth(), layout.getHeight());
        //debug log
        Log.d("ActionFragment Log", "DisplaySize.x = " + displaySize.x + ", DisplaySize.y = " + displaySize.y);
        Log.d("ActionFragment Log", "realSize.x = " + realSize.x + ", realSize.y = " + realSize.y);
        Log.d("ActionFragment Log", "layoutSize.x = " + layoutSize.x + ", layoutSize.y = " + layoutSize.y);
        Log.d("ActionFragment Log", "layoutSize.x = " + layout.getWidth() + ", layoutSize.y = " + layout.getHeight());

        if(true){
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.block_brown);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageBitmap(bmp);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 0;
            imageView.setLayoutParams(layoutParams);
            layout.addView(imageView);
        }
        if(true){
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.block_gray);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageBitmap(bmp);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
            layoutParams.leftMargin = 150;
            layoutParams.topMargin = 150;
            imageView.setLayoutParams(layoutParams);
            layout.addView(imageView);
        }
        if(true){
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.block_gray);
            ImageView imageView = new ImageView(getContext());
            imageView.setImageBitmap(bmp);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
            layoutParams.leftMargin = 0;
            layoutParams.topMargin = 300;
            imageView.setLayoutParams(layoutParams);
            layout.addView(imageView);
        }

        //start handler
        final int flame = 32;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000 / flame);
            }
        };
        handler.post(runnable);
    }
}