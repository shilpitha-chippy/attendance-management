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
public class VaAdapterClass extends RecyclerView.Adapter<VaAdapterClass.ViewHolder>{
    List<AttModelClass> attendence;
    List<AppModelClass> student;
    Context context;
    DatabaseHelper databaseHelper;
    TextView TStudents;
    TextView PStudents;
    TextView AStudents;

    public VaAdapterClass(List<AppModelClass> student, Context context, String date, String classs) {
        this.student = student;
        this.context = context;
        this.date = date;
        this.classs = classs;
    }

    //AttDatabaseHelper attDatabaseHelper;
    String date;
    String classs;

    public VaAdapterClass(List<AppModelClass> student, Context context) {
        this.student = student;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.view_attendance,parent,false);
        VaAdapterClass.ViewHolder viewHolder = new VaAdapterClass.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        final AppModelClass appModelClass = student.get(position);
//int p=0,a=0;
        holder.Rno.setText(Integer.toString(appModelClass.getId()));
        holder.Name.setText(appModelClass.getUname());
        // String Astatus=appModelClass.getPass();
        holder.Status.setText(appModelClass.getPass());
        /*if(Astatus.trim()=="PRESENT")
        {
            p++;
        }else if(Astatus.trim()=="ABSENT")
        {
            a++;
        }*/
     /*  TStudents.setText("Total : "+Integer.toString(appModelClass.getT()));
        PStudents.setText("Present : "+Integer.toString(appModelClass.getP()));
        AStudents.setText("Absent : "+Integer.toString(appModelClass.getA()));*/
    }



    @Override
    public int getItemCount() {
        return student.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Rno;
        TextView Name;
        TextView Status;
        /*TextView TStudents;
        TextView PStudents;
        TextView AStudents;*/

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Rno = itemView.findViewById(R.id.txtRnoV);
            Name = itemView.findViewById(R.id.txtNameV);
            Status = itemView.findViewById(R.id.txtStatusV);
          /*  TStudents = itemView.findViewById(R.id.txtTStudents);
            PStudents = itemView.findViewById(R.id.txtPStudents);
            AStudents = itemView.findViewById(R.id.txtAStudents);*/
        }
    }
}
