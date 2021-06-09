package com.example.attendance;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LuAdapterClass extends RecyclerView.Adapter<LuAdapterClass.ViewHolder> {
    List<AppModelClass> lecturer;
    Context context;
    DatabaseHelper databaseHelper;

    public LuAdapterClass(List<AppModelClass> lecturer, Context context) {
        this.lecturer = lecturer;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public LuAdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lecturer_update_list,parent,false);
        LuAdapterClass.ViewHolder viewHolder = new LuAdapterClass.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LuAdapterClass.ViewHolder holder, int position) {
        final AppModelClass appModelClass = lecturer.get(position);

        holder.ID.setText(Integer.toString(appModelClass.getId()));
        holder.uname.setText(appModelClass.getUname());
        holder.pass.setText(appModelClass.getPass());
        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringUname = holder.uname.getText().toString();
                String stringPass = holder.pass.getText().toString();

                databaseHelper.updateLecturer(new AppModelClass(appModelClass.getId(),stringUname,stringPass));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteLecturer(appModelClass.getId());
                lecturer.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return lecturer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ID;
        TextView uname;
        TextView pass;
        Button button_Edit;
        Button button_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ID = itemView.findViewById(R.id.txtId);
            uname = itemView.findViewById(R.id.txtUname);
            pass = itemView.findViewById(R.id.txtPass);
            button_delete = itemView.findViewById(R.id.btndelete);
            button_Edit = itemView.findViewById(R.id.btnedit);
        }
    }
}
