package tk.sistemainformatico.actiongame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Component {
    int m_id;
    Rect m_offset = new Rect(0,0,0,0);
    Point m_size = new Point(0,0);
    ImageView m_imageView;
    Component(Resources res, Context context, int id, Point frameSize, Point size, Point offset){
        //initialize members
        m_id = id;
        m_size.x = size.x;
        m_size.y = size.y;
        m_offset.left   = offset.x;
        m_offset.right  = frameSize.x - offset.x - m_size.x;
        m_offset.top    = offset.y;
        m_offset.bottom = frameSize.y - offset.y - m_size.y;
        //imageview
        Bitmap bmp = BitmapFactory.decodeResource(res, id);
        m_imageView = new ImageView(context);
        m_imageView.setImageBitmap(bmp);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m_size.x, m_size.y);
        layoutParams.leftMargin   = m_offset.left;
        layoutParams.rightMargin  = m_offset.right;
        layoutParams.topMargin    = m_offset.top;
        layoutParams.bottomMargin = m_offset.bottom;
        m_imageView.setLayoutParams(layoutParams);
    }

    public ImageView getImageView(){
        return m_imageView;
    }

    public void move(Point offset){
        //calculate new offset
        m_offset.left += offset.x;
        m_offset.right -= offset.x;
        m_offset.top += offset.y;
        m_offset.bottom -= offset.y;
        //update imageview
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m_size.x, m_size.y);
        layoutParams.leftMargin   = m_offset.left;
        layoutParams.rightMargin  = m_offset.right;
        layoutParams.topMargin    = m_offset.top;
        layoutParams.bottomMargin = m_offset.bottom;
        m_imageView.setLayoutParams(layoutParams);
        return;
    }
}
