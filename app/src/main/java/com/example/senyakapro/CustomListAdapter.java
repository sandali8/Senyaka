package com.example.senyakapro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<DataSet> {


    ArrayList<DataSet> dataSet;
    Context context;
    public  CustomListAdapter(Context context, ArrayList<DataSet> dataSet) {
        super(context, R.layout.table_row_item, dataSet);
        this.dataSet = dataSet;
        this.context = context;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.table_row_item, parent,false);

        TextView nicNumber = (TextView) rowView.findViewById(R.id.column1);
        TextView bookedDate = (TextView) rowView.findViewById(R.id.column2);
        TextView vehicleID = (TextView) rowView.findViewById(R.id.column3);
        TextView paymentType = (TextView) rowView.findViewById(R.id.column4);
        TextView total = (TextView) rowView.findViewById(R.id.column5);

        nicNumber.setText(dataSet.get(position).NIC);
        bookedDate.setText(dataSet.get(position).bookedDate);
        vehicleID.setText(dataSet.get(position).vehicleID);
        paymentType.setText(dataSet.get(position).paymentType);
        total.setText(dataSet.get(position).total);

        return rowView;

    };
}

class DataSet implements Serializable {
    String NIC;
    String bookedDate;
    String vehicleID;
    String paymentType;
    String total;


}





