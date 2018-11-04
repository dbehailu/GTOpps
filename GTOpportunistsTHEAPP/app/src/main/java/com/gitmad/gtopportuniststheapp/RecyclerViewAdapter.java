package com.gitmad.gtopportuniststheapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import android.support.annotation.NonNull;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Pin> pins;

    public RecyclerViewAdapter(ArrayList<Pin> pins) {
        this.pins = pins;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_pin, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        //bind data to widgets
        holder.eventTitle.setText(pins.get(position).getTitle());
        holder.textUpVote.setText(Integer.toString(pins.get(position).getUpVotes()));
        holder.textDownVote.setText(Integer.toString(pins.get(position).getDownVotes()));

        //get location that corresponds to position
        holder.pin = pins.get(position);

        holder.parentLayout.setOnClickListener((view) -> {
                Context mContext = view.getContext();
                Intent intent = new Intent(mContext, PinDetailActivity.class);

                intent.putExtra("pin_title", holder.pin.getTitle());
                intent.putExtra("pin_description", holder.pin.getDescription());
                intent.putExtra("pin_latitude", Double.toString(holder.pin.getLatitude()));
                intent.putExtra("pin_longitude", Double.toString(holder.pin.getLongitude()));
                intent.putExtra("pin_begin", Integer.toString(holder.pin.getBeginTime()));
                intent.putExtra("pin_end", Integer.toString(holder.pin.getEndTime()));
                intent.putExtra("pin_user", holder.pin.getUser());
                intent.putExtra("pin_upVote", Integer.toString(holder.pin.getUpVotes()));
                intent.putExtra("pin_downVote", Integer.toString(holder.pin.getDownVotes()));

                mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return pins.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView eventTitle;
        public FloatingActionButton buttonUpVote;
        public TextView textUpVote;
        public FloatingActionButton buttonDownVote;
        public TextView textDownVote;

        public Pin pin;

        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            eventTitle = itemView.findViewById(R.id.text_title);

            buttonUpVote = itemView.findViewById(R.id.fab_upVote);
            textUpVote = itemView.findViewById(R.id.text_upVote);

            buttonDownVote = itemView.findViewById(R.id.fab_downVote);
            textDownVote = itemView.findViewById(R.id.text_downVote);

            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
