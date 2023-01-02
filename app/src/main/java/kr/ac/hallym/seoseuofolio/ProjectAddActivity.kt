package kr.ac.hallym.seoseuofolio

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import kr.ac.hallym.seoseuofolio.databinding.ActivityProjectAddBinding
import java.io.ByteArrayOutputStream


class ProjectAddActivity : AppCompatActivity() {
    lateinit var binding: ActivityProjectAddBinding
    
    //bitMap -> reSource 변환 담아줄 전역변수
//    lateinit var bitToRes: Resources
//    lateinit var drawable: Drawable

    lateinit var sendBitmap: Bitmap



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityProjectAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        binding.imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add,menu)
        return super.onCreateOptionsMenu(menu)
    }

    // 갤러리 요청 런처
    var requestGalleryLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        try {

            val option = BitmapFactory.Options()

            // 이미지 로딩
            var inputStream = contentResolver.openInputStream(it.data!!.data!!)

            //사진 객체
            val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
            //bitmap 값이 실질적인 사진 값이 된다.

            bitmap?.let {
                binding.imageView.setImageBitmap(bitmap)
            } ?: let {
                Log.d("seo", "bitmap null")
            }

            inputStream!!.close()

        } catch (e: Exception) {
            Log.d("seo", "bitmap null")
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_add_save -> {

                if(binding.titleText.text.toString()=="") {
                    val myToast = Toast.makeText(applicationContext, "제목을 작성해주세요!", Toast.LENGTH_SHORT)
                    myToast.show()
                }

                else {

                    //Bitmap으로 넘겨주기 위해서 drawable -> bitmap -> Byte

//                    val imageBitmap = binding.imageView.drawable.toBitmap()
//
//                    //byte Array로 변경
//                    val sendBitmap = imageBitmap!!
//                    val stream = ByteArrayOutputStream() //이미지 인텐트 요소
//                    sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//                    sendByteArray = stream.toByteArray()

                    val resources: Resources = this.resources
                    val sendBitmap = BitmapFactory.decodeResource(resources, R.drawable.upload)

                    var image = BitmapToString(sendBitmap)
                    val title = binding.titleText.text.toString()
                    val detail = binding.detailText.text.toString()
                    val link = binding.gitHubText.text.toString()


                    val db = ProjectDBHelper(this).writableDatabase

                    db.execSQL("insert into PRO_TB(image,title,detail,link) values(?,?,?,?)",
                        arrayOf(image,title,detail,link))

                    val intent = Intent(this, ProjectMainActivity::class.java)


                    intent.putExtra("image",R.drawable.upload)
                    intent.putExtra("title", binding.titleText.text.toString())
                    intent.putExtra("detail", binding.detailText.text.toString())
                    intent.putExtra("link",binding.gitHubText.text.toString())
                    setResult(Activity.RESULT_OK, intent)

                    Toast.makeText(this, "프로젝트 게시물이 추가되었습니다 !", Toast.LENGTH_SHORT).show()

                    finish()
                }


            }
            else -> {
                goToMain()
            }
        }
        return true
    }


    //일반 뒤로가기 버튼
    override fun onBackPressed() {
        goToMain()
    }

    private fun goToMain() {
        val i = Intent(this, ProjectMainActivity::class.java)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(i)
    }

    fun StringToBitmap(encodedString: String?): Bitmap? {
        return try {
            val encodeByte: ByteArray = Base64.decode(encodedString, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: java.lang.Exception) {
            e.message
            null
        }
    }

    /*
     * Bitmap을 String형으로 변환
     * */
    fun BitmapToString(bitmap: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 70, baos)
        val bytes = baos.toByteArray()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

}



