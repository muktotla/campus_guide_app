package com.lysofts.campusguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        intent = new Intent(MainActivity.this, MapsActivity.class);
    }

    public void goToPlay(View view) {
        intent.putExtra("name","PSB Academy STEM Campus");
        LatLng to_location = new LatLng(1.33755410018,103.848309011);
        Bundle bundle  = new Bundle();
        bundle.putParcelable("to_location", to_location);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToLab(View view) {
        intent.putExtra("name","PSB Academy STEM Campus");
        LatLng to_location = new LatLng(1.33755410018,103.848309011);
        Bundle bundle  = new Bundle();
        bundle.putParcelable("to_location", to_location);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToGYM(View view) {
        intent.putExtra("name","PSB Academy STEM Campus");
        LatLng to_location = new LatLng(1.33755410018,103.848309011);
        Bundle bundle  = new Bundle();
        bundle.putParcelable("to_location", to_location);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToCafe(View view) {
    }

    public void goToLibrary(View view) {
        intent.putExtra("name","PSB Academy STEM Campus");
        LatLng to_location = new LatLng(1.33755410018,103.848309011);
        Bundle bundle  = new Bundle();
        bundle.putParcelable("to_location", to_location);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToSecurity(View view) {
        intent.putExtra("name","PSB Academy STEM Campus");
        LatLng to_location = new LatLng(1.33755410018,103.848309011);
        Bundle bundle  = new Bundle();
        bundle.putParcelable("to_location", to_location);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goStudentClub(View view) {
        intent.putExtra("name","PSB Academy Myanmar Student Club");
        LatLng to_location = new LatLng(1.28742, 103.83001);
        Bundle bundle  = new Bundle();
        bundle.putParcelable("to_location", to_location);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToAdmin(View view) {
        intent.putExtra("name","PSB Academy STEM Campus");
        LatLng to_location = new LatLng(1.33755410018,103.848309011);
        Bundle bundle  = new Bundle();
        bundle.putParcelable("to_location", to_location);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        firebaseAuth.signOut();
    }
}
