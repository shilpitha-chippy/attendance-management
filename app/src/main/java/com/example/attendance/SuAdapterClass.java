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

public class SuAdapterClass extends RecyclerView.Adapter<SuAdapterClass.ViewHolder>{
    List<AppModelClass> student;
    Context context;
    DatabaseHelper databaseHelper;
    String classs;
    public SuAdapterClass(List<AppModelClass> student, Context context, String classs) {
        this.student = student;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        this.classs=classs;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.student_update_list,parent,false);
        SuAdapterClass.ViewHolder viewHolder = new SuAdapterClass.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AppModelClass appModelClass = student.get(position);

        holder.rollno.setText(Integer.toString(appModelClass.getId()));
        //holder..setText(appModelClass.getRno());
        holder.name.setText(appModelClass.getUname());
        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringRollNo = holder.rollno.getText().toString();
                String stringName = holder.name.getText().toString();

                databaseHelper.updateStudent(new AppModelClass(stringRollNo,stringName),classs );
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });
        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteStudent(appModelClass.getId(),classs);
                student.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView rollno;
        TextView name;
        Button button_Edit;
        Button button_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rollno = itemView.findViewById(R.id.txtRollNo);
            name = itemView.findViewById(R.id.txtName);
            button_delete = itemView.findViewById(R.id.btndeleteS);
            button_Edit = itemView.findViewById(R.id.btneditS);
        }
    }
}
