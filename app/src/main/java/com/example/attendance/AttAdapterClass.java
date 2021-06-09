package com.example.attendance;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class AttAdapterClass extends RecyclerView.Adapter<AttAdapterClass.ViewHolder>{
    List<AttModelClass> attendence;
    List<AppModelClass> student;
    Context context;
    DatabaseHelper databaseHelper;
    //AttDatabaseHelper attDatabaseHelper;
    String date;
    String classs;

    public AttAdapterClass(List<AppModelClass> student, Context context) {
        this.student = student;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
        //attDatabaseHelper = new AttDatabaseHelper(context);
    }

   /* public AttAdapterClass( Context context, long date, String classs) {

        this.context = context;
        this.date = date;
        this.classs = classs;
        databaseHelper = new DatabaseHelper(context);
        //attDatabaseHelper = new AttDatabaseHelper(context);
    }*/

    public AttAdapterClass(List<AppModelClass> student, Context context, String date, String classs) {
        this.student = student;
        this.context = context;
        this.date = date;
        this.classs = classs;
        databaseHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mark_attendance,parent,false);
        AttAdapterClass.ViewHolder viewHolder = new AttAdapterClass.ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//displays the data @ specified position
        final AppModelClass appModelClass = student.get(position);

        holder.Rno.setText(Integer.toString(appModelClass.getId()));
        holder.Name.setText(appModelClass.getUname());
        holder.Present.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int stringRno = Integer.parseInt(holder.Rno.getText().toString());
                String stringName = holder.Name.getText().toString();
                String status="PRESENT";
                AttModelClass attModelClass;
String Date=date;
                databaseHelper.addAttendance(new AttModelClass(date,classs,stringRno,stringName,status));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());



            }
        });
        holder.Absent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int stringRno = Integer.parseInt(holder.Rno.getText().toString());
                String stringName = holder.Name.getText().toString();
                String status="ABSENT";
                AttModelClass attModelClass;
                String Date=date;
                databaseHelper.addAttendance(new AttModelClass(date,classs,stringRno,stringName,status));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Rno;
        TextView Name;

        Button Present;
        Button Absent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Rno = itemView.findViewById(R.id.txtRno);
            Name = itemView.findViewById(R.id.txtName);

            Present = itemView.findViewById(R.id.btnPresent);
            Absent = itemView.findViewById(R.id.btnAbsent);
        }
    }
}
