package com.olayinkapeter.movetracr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olayinkapeter.movetracr.Room.Track;

import java.util.List;

public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.TracksViewHolder> {
    private Context context;
    private List<Track> trackList;

    public TracksAdapter(Context context, List<Track> trackList) {
        this.context = context;
        this.trackList = trackList;
    }

    @Override
    public TracksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tracks_list, parent, false);
        return new TracksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TracksViewHolder holder, int position) {
        Track track = trackList.get(position);
        holder.textStartPoint.setText(track.getStartPoint());
        holder.textFinishPoint.setText(track.getFinishPoint());
        holder.textFinishTime.setText(track.getFinishedTime());
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    class TracksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textFinishTime, textStartPoint, textFinishPoint;

        public TracksViewHolder(View itemView) {
            super(itemView);

            textFinishTime = itemView.findViewById(R.id.textFinishTime);
            textStartPoint = itemView.findViewById(R.id.textStartPoint);
            textFinishPoint = itemView.findViewById(R.id.textFinishPoint);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Track track = trackList.get(getAdapterPosition());
//
//            Intent intent = new Intent(context, TracksListActivity.class);
//            intent.putExtra("track", track);
//
//            context.startActivity(intent);
        }
    }
}
