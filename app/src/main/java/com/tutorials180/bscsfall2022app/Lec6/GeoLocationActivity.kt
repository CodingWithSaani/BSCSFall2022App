package com.tutorials180.bscsfall2022app.Lec6

import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.tutorials180.bscsfall2022app.R
import com.tutorials180.bscsfall2022app.databinding.ActivityGeoLocationBinding
import java.util.*

class GeoLocationActivity : AppCompatActivity(),LocationListener {
    private lateinit var mGeoLocationActivityBinding:ActivityGeoLocationBinding
    private lateinit var mLocationManager: LocationManager

    private lateinit var mGeoCoder:Geocoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mGeoLocationActivityBinding = ActivityGeoLocationBinding.inflate(layoutInflater)
        setContentView(mGeoLocationActivityBinding.root)

        listeners()
    }

    private fun listeners()
    {
        try
        {
            mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            mGeoCoder = Geocoder(GeoLocationActivity@this, Locale.getDefault())

            mGeoLocationActivityBinding.geoWorkingGetLocBtn.setOnClickListener {
                getCheckPermissionForLocation()
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun getCheckPermissionForLocation() {
        try
        {
            if(ActivityCompat.checkSelfPermission(applicationContext,android.Manifest.permission.ACCESS_COARSE_LOCATION)==PackageManager.PERMISSION_GRANTED)
            {
                mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,5.0f,this)
            }
            else
            {
                ActivityCompat.requestPermissions(GeoLocationActivity@this,
                arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION),
                    104
                )
            }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    override fun onLocationChanged(location: Location) {
        mGeoLocationActivityBinding.geoWorkingLatTv.text = location.latitude.toString()
        mGeoLocationActivityBinding.geoWorkingLangTv.text = location.longitude.toString()

        doReverseGeoCoding(location)
    }

    private fun doReverseGeoCoding(location: Location) {
        try
        {
                val address = mGeoCoder.getFromLocation(location.latitude,location.longitude,1)
                val streetAddress = address[0].getAddressLine(0)

                val town = address[0].subLocality
                val city = address[0].adminArea

                val postalCode = address[0].postalCode
                val country = address[0].countryName

                mGeoLocationActivityBinding.geoWorkingAddressTv.text = "Street Address:${streetAddress} \n" +
                        "Town: ${town} \n City: ${city} \n Postal Code:${postalCode}" +
                        "\n Country: ${country}"
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 104 && grantResults.isNotEmpty())
        {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(applicationContext, "Permission for location granted", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {

        }
    }



















}