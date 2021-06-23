package com.example.colormyview3

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    

    val tag = "COLORS"
    var color: Int = R.color.gray
    var boxes = arrayOf(R.id.boxOne, R.id.boxTwo,R.id.boxThree,R.id.boxFour,R.id.boxFive)

    //val buttonReset = findViewById<Button>(R.id.buttonReset)
    lateinit var  prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        val shareButton = findViewById<FloatingActionButton>(R.id.shareButton)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TO SAVE IMAGE
        // -----------------------------------------------------------------------------
        // write permission to access the storage
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)

        // this is the card view whose screenshot
        // we will take in this article
        // get the view using fin view bt id
        val View = findViewById<View>(R.id.parentLayout)

        // on click of this button it will capture
        // screenshot and save into gallery
        val captureBUtton = findViewById<Button>(R.id.buttonSave)
        captureBUtton.setOnClickListener(){
            // get the bitmap of the view using
            // getScreenShotFromView method it is
            // implemented below
            val bitmap = getScreenShotFromView(View)

            // if bitmap is not null then
            // save it to gallery
            if (bitmap != null) {
                saveMediaToStorage(bitmap)
            }
        }
        //--------------------------------------------------------------------

        prefs = getSharedPreferences("colors", MODE_PRIVATE)
        for(box in boxes){
            findViewById<View>(box).setBackgroundResource(prefs.getInt("box-$box", R.color.gray))
        }

//        shareButton.setOnClickListener{
//            val intent = Intent(Intent.ACTION_SEND)
//            intent.putExtra(Intent.EXTRA_TEXT, "Voce ")
//            intent.type= "text/plain"
//            if(intent.resolveActivity(this.packageManager) != null){
//                    startActivity(intent)
//                }else   {
//                    Toast.makeText(this, "Você não tem um aplicativo compátvel", Toast.LENGTH_LONG)
//            }
//        }
    }
    // this method saves the image to gallery
    //-----------------------------------------------------------------------
    private fun saveMediaToStorage(bitmap: Bitmap) {
        // Generating a file name
        val filename = "${System.currentTimeMillis()}.jpg"

        // Output stream
        var fos: OutputStream? = null

        // For devices running android >= Q
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // getting the contentResolver
            this.contentResolver?.also { resolver ->

                // Content resolver will process the contentvalues
                val contentValues = ContentValues().apply {

                    // putting file information in content values
                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
                }

                // Inserting the contentValues to
                // contentResolver and getting the Uri
                val imageUri: Uri? = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)

                // Opening an outputstream with the Uri that we got
                fos = imageUri?.let { resolver.openOutputStream(it) }
            }
        } else {
            // These for devices running on android < Q
            val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            val image = File(imagesDir, filename)
            fos = FileOutputStream(image)
        }

        fos?.use {
            // Finally writing the bitmap to the output stream that we opened
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
            Toast.makeText(this , "Captured View and saved to Gallery" , Toast.LENGTH_SHORT).show()
        }
    }
    private fun getScreenShotFromView(v: View?): Bitmap? {
        // create a bitmap object
        var screenshot: Bitmap? = null
        try {
            // inflate screenshot object
            // with Bitmap.createBitmap it
            // requires three parameters
            // width and height of the view and
            // the background color
            screenshot = Bitmap.createBitmap(v!!.measuredWidth, v.measuredHeight, Bitmap.Config.ARGB_8888)
            // Now draw this bitmap on a canvas
            val canvas = Canvas(screenshot)
            v.draw(canvas)
        } catch (e: Exception) {
            Log.e("GFG", "Failed to capture screenshot because:" + e.message)
        }
        // return the bitmap
        return screenshot
    }
    //-----------------------------------------------------------------------

    fun onButtonClick(view: View){
        this.color = when(view.id){
            R.id.buttonRed -> R.color.red
            R.id.buttonYellow -> R.color.yellow
            else -> R.color.green
            //else -> return reset()
        }
    }
//    private fun reset( ){
//
//        for(box in boxes){
//            prefs = getSharedPreferences("colors", MODE_PRIVATE)
//            findViewById<View>(box).setBackgroundResource(prefs.getInt("box$box", R.color.gray))
//            Log.i("acesso", "box$box")
////            var id = view.id
////            with(prefs.edit()){
////                putInt("box-$id", color)
////                commit()
////            }
//        }
//    }
    fun onBoxClick(view: View){
        view.setBackgroundResource(this.color)
        var id = view.id
        with(prefs.edit()){
            putInt("box-$id", color)
            commit()
        }
    }
}