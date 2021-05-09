package com.example.senyakapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class vehicalAdapter extends RecyclerView.Adapter<vehicalAdapter.MyViewHolder> {

        private FirebaseDatabase db =  FirebaseDatabase.getInstance();
        private DatabaseReference root = db.getReference("Bokking");

    ArrayList<Model>mlist;
    Context context;

    public vehicalAdapter ( Context context ,ArrayList<Model> mlist){

        this.mlist = mlist;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item ,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Model model = mlist.get(position);

        String id2 = String.valueOf(model.getId());
        holder.id.setText(id2);
        holder.name.setText(model.getName());
        holder.passenger.setText(model.getPassenger());
        holder.trans.setText(model.getTrans());
        holder.place.setText(model.getPlace());

       holder.del1.setOnClickListener(new View.OnClickListener() { //delete
            @Override
            public void onClick(View v) {



                root.child(id2).removeValue();
                Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
         TextView id,name,passenger,trans,place,del1;

         public MyViewHolder(@NonNull View itemView) {
             super(itemView);

             id = itemView.findViewById(R.id.VidV0);
             name = itemView.findViewById(R.id.VidV1);
             passenger = itemView.findViewById(R.id.VidV2);
             trans = itemView.findViewById(R.id.VidV3);
             place = itemView.findViewById(R.id.VidV4);
             del1 = itemView.findViewById(R.id.del1);

         }
     }
}

