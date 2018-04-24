package com.example.naaz.venuenavigator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.venues3d.DeselectionSource;
import com.here.android.mpa.venues3d.Level;
import com.here.android.mpa.venues3d.Space;
import com.here.android.mpa.venues3d.Venue;
import com.here.android.mpa.venues3d.VenueMapFragment;
import com.here.android.mpa.venues3d.VenueService;

public class VenueActivity extends AppCompatActivity {

    VenueMapFragment.VenueListener myVenueListener;
    VenueService.VenueServiceListener myVenueServicelistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);


        // Search for the VenueMapFragment
        final VenueMapFragment mapFragment = (VenueMapFragment)
                getFragmentManager().findFragmentById(R.id.map_fragment);

        // initialize the Map Fragment and
        // retrieve the map that is associated to the fragment
        mapFragment.init(new OnEngineInitListener() {
            @Override
            public void onEngineInitializationCompleted( OnEngineInitListener.Error error) {
                if (error == OnEngineInitListener.Error.NONE) {
                    // add listeners
                    mapFragment.addListener(myVenueListener);
                    mapFragment.getVenueService().addListener(myVenueServicelistener);
                    Map map = mapFragment.getMap();
                } else {
                    System.out.println("ERROR is" +error);
                    System.out.println("ERROR: Cannot initialize VenueMapFragment");
                }
            }
        });
    }


}
