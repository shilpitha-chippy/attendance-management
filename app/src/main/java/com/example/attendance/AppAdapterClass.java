package com.example.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AppAdapterClass extends RecyclerView.Adapter<AppAdapterClass.ViewHolder>{
//getting data from model
    List<AppModelClass> lecturer;
    Context context;
    DatabaseHelper databaseHelper;

    public AppAdapterClass(List<AppModelClass> lecturer, Context context) {
        this.lecturer = lecturer;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    //creates view of lecturer
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lecturer_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    //bind data with list of items
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final AppModelClass appModelClass = lecturer.get(position);

        holder.ID.setText(Integer.toString(appModelClass.getId()));
        holder.uname.setText(appModelClass.getUname());
        holder.pass.setText(appModelClass.getPass());

    }

    @Override
    //indicates how many lecturers are there
    public int getItemCount() {
        return lecturer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView ID;
        TextView uname;
        TextView pass;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = itemView.findViewById(R.id.txtId);
            uname = itemView.findViewById(R.id.txtUname);
            pass = itemView.findViewById(R.id.txtPass);

        }
    }

}