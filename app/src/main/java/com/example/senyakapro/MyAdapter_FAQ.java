package com.example.senyakapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter_FAQ extends RecyclerView.Adapter<MyAdapter_FAQ.MyViewHolder> {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference("FAQ");



    ArrayList<Model_FAQ> mList;
    Context context;

    public MyAdapter_FAQ(Context context, ArrayList<Model_FAQ> mList) {

        this.mList = mList;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.s_item, parent, false);
        //notifyDataSetChange();
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model_FAQ model = mList.get(position);
        //String xxx=String.valueOf(model.getQuc());

        holder.question.setText(model.getQuc());
        holder.answer.setText(model.getAns());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView question,answer;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.Quseion);
            answer = itemView.findViewById(R.id.answer);
        }


    }


}
