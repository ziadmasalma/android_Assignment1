package com.example.assignment1;



import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class HolderAdapter
        extends RecyclerView.Adapter<HolderAdapter.ViewHolder>{
    private String question[];
    private String answer[];

    public HolderAdapter(String question[], String answer[]){
        this.question = question;
        this.answer = answer;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,  int position) {

        CardView cardView = holder.cardView;
        TextView txt = (TextView)cardView.findViewById(R.id.QA);
        txt.setText(question[position]);
        Spinner spinner = (Spinner)cardView.findViewById(R.id.spinner);
        spinner.setSelection(0);
        // fill in the spinner with the answer choices using the array answer
        ArrayAdapter<String> adapterd= new ArrayAdapter<String>(cardView.getContext(),android.R.layout.simple_spinner_item,answer);
        adapterd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapterd);

    }

    @Override
    public int getItemCount() {
        return answer.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
