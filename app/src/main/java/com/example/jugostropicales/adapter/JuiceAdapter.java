package com.example.jugostropicales.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.jugostropicales.R;
import com.example.jugostropicales.model.Juice;

public class JuiceAdapter extends BaseAdapter {

    private Context context;
    private List<Juice> items;

    public JuiceAdapter(Context context, List<Juice> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Juice getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if(vista == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.layout_juice,null);

            viewHolder.jugo = vista.findViewById(R.id.jugo);
            viewHolder.jugoNombre = vista.findViewById(R.id.jugoNombre);
            viewHolder.jugoPrecio = vista.findViewById(R.id.jugoPrecio);
            vista.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vista.getTag();
        }

        Juice jugoActual = items.get(position);
        viewHolder.jugo.setImageResource(jugoActual.getImagen());
        viewHolder.jugoNombre.setText(jugoActual.getNombre());
        viewHolder.jugoPrecio.setText(jugoActual.getPrecio());
        return vista;
    }

    static class ViewHolder {
        ImageView jugo;
        TextView jugoNombre;
        TextView jugoPrecio;
    }
}
