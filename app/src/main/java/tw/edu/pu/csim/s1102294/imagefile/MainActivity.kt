package tw.edu.pu.csim.s1102294.imagefile

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.app.Activity
import android.graphics.Bitmap
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1
    private var img: ImageView? = null
    lateinit var photo: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
        photo = findViewById(R.id.photo)

        photo.setOnClickListener {
            openPhotoAlbum()
        }
    }

    private fun openPhotoAlbum() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            val selectedImageUri = data.data
            img?.setImageURI(selectedImageUri)
            // You can do further processing with the selected image URI
        }
    }
}