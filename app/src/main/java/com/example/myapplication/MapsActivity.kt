package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private val LOCATION_PERMISSION_REQUEST=1

    private fun getLocationAccess(){
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
//            map.isMyLocationEnabled=true

        }
//        else
//            ActivityCompat.requestPermissions(this, arrayOf ())
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
       mMap = googleMap


        val bucharest = LatLng(44.439, 26.096)
        mMap.addMarker(MarkerOptions().position(bucharest).title("Marker in Bucharest"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bucharest, 15f))

        //locatie reciclat
        val unu = LatLng(44.434593587742924, 26.103121324271978)
        mMap.addMarker(MarkerOptions().position(unu).title("metal, aluminiu, sticla, plastic si pet"))
        val doi = LatLng(44.43076073309459, 26.111370986433492)
        mMap.addMarker(MarkerOptions().position(doi).title("metal, aluminiu, hartie, carton, plastic si pet"))

    }
}