package kr.ac.hallym.seoseuofolio

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.core.graphics.drawable.toBitmap
import kr.ac.hallym.seoseuofolio.databinding.ActivityProjectEditBinding
import org.antlr.v4.runtime.misc.MurmurHash.finish
import java.util.*
import kotlin.math.log


class ProjectEditActivity : AppCompatActivity() {
    lateinit var binding: ActivityProjectEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProjectEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //변수들 정리

//      var image_edit : ~~~~~

        binding.imageView.setImageResource(intent.getIntExtra("image_edit",0))
        binding.titleText.setText(intent.getStringExtra("title_edit"))
        binding.detailText.setText(intent.getStringExtra("detail_edit"))
        binding.gitHubText.setText(intent.getStringExtra("link_edit"))


        //이미지 버튼 클릭 리스너
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
            inputStream!!.close()
            inputStream = null

            bitmap?.let {
                binding.imageView.setImageBitmap(bitmap)
            } ?: let {
                Log.d("seo", "bitmap null")
            }

        } catch (e: Exception) {
            Log.d("seo", "bitmap null")
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_add_save -> { //저장 버튼 클릭 시.

                if(binding.titleText.text.toString()=="") {
                    val myToast = Toast.makeText(applicationContext, "제목을 작성해주세요!", Toast.LENGTH_SHORT)
                    myToast.show()
                }

                else {

                    val title = binding.titleText.text.toString()

                    val detail = binding.detailText.text.toString()
                    val link = binding.gitHubText.text.toString()


                    val db = ProjectDBHelper(this).writableDatabase
                    //DB Helper를 열어준다.

                    //내가 생각한 답 :
                    //상단에서 position 번째만큼 내려간 후 해당 커서를 업데이트 해주면 됌
                    //_id 값은 중간에 삭제되면 갱신되지 않고 그대로 쌓이지만 ex) 1,2,3 - 2삭제 -> 1,3
                    //오름 차순이기 때문에 position 만큼 다음으로 이동하면 원하는 값이 나옴.

                    // 1. position값을 받아온다.
                    val position = intent.getIntExtra("position",0)

                    // 2. 커서로 _id 행을 꺼내온다. (몇번째 값을 바꿔줄건지에 대한 지표)
                    val cursor = db.rawQuery("SELECT _id FROM PRO_TB", null) //_id 속성들만 가져오기

                    cursor.moveToNext()
                    // 커서가 처음 시작이 -1이어서 한번 앞으로 땡겨서 0에 위치하게 끔 해준다.


//                    Log.d("서승","커서 타이틀 값 => ${cursor.getString(2)}")

                    // 3. position 값 만큼 다음으로 이동해준다.
                    // 3-1. 현재 image값은 업데이트 항목으로 안넣었음. image 업로드 확인하고 넣을 것.
                    var i = 0;


                    while(i<position) {
                        cursor.moveToNext()
                        i++
                    }

                    var id : Int = Integer.parseInt((cursor.getInt(0)).toString());

                    Log.d("서승","커서 아이디 값 => $id")
                    Log.d("서승","내가 선택한 아이템의 position 값 => $position")

                    Log.d("서승","title => $title")
                    Log.d("서승","detail => $detail")
                    Log.d("서승","link => $link")
                    // 4. cursor가 가르키는 _id 값이 있는 행의 칼럼들을 업데이트 해주면 된다.




                    db.execSQL("UPDATE PRO_TB SET title=(?), detail=(?), link=(?) WHERE _id=(?)",
                        arrayOf(title,detail,link,id)) //arratOf로 처리해줘야 값이 들어갔다.

                    //sqlite 문으로 해당 행의 칼럼 값들을 바꿔주고 intent로 넘어간다.

                    Toast.makeText(this, "프로젝트 게시물이 수정되었습니다 !", Toast.LENGTH_SHORT).show()

                    goToMain()
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

}



