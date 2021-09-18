package tk.sistemainformatico.actiongame;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ComponentManager {
    List<Component> m_components = new ArrayList<>();
    Resources m_resources;
    Context m_context;
    Point m_frameSize = new Point(0,0);

    public ComponentManager(Resources resources, Context context){
        m_resources = resources;
        m_context = context;
    }
    public void setFrameSize(Point frameSize){
        m_frameSize.x = frameSize.x;
        m_frameSize.y = frameSize.y;
    }

    public ImageView addComponent(int id, Point size, Point offset){
        Component obj = new Component(m_resources, m_context, id, m_frameSize, size, offset);
        m_components.add(obj);
        return obj.getImageView();
    }

    public void shift(Point diff){
        for(Component component : m_components){
            component.move(diff);
        }
    }
}
