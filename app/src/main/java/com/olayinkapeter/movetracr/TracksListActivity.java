package com.olayinkapeter.movetracr;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.olayinkapeter.movetracr.Room.DatabaseClient;
import com.olayinkapeter.movetracr.Room.Track;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TracksListActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackslist);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getTracks();
    }

    private void getTracks() {
        class GetTracks extends AsyncTask<Void, Void, List<Track>> {

            @Override
            protected List<Track> doInBackground(Void... voids) {
                List<Track> trackList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .trackDao()
                        .getAll();
                return trackList;
            }

            @Override
            protected void onPostExecute(List<Track> tracks) {
                super.onPostExecute(tracks);
                TracksAdapter adapter = new TracksAdapter(TracksListActivity.this, tracks);
                recyclerView.setAdapter(adapter);
            }
        }

        GetTracks getTracks = new GetTracks();
        getTracks.execute();
    }
}
