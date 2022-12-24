package kr.ac.hallym.seoseuofolio

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kr.ac.hallym.seoseuofolio.databinding.ActivityDmAddBinding


class DmAddActivity : AppCompatActivity() {
    lateinit var binding: ActivityDmAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDmAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_add_save -> {
                val title = binding.titleText.text.toString()
                val detail = binding.detailText.text.toString()

                val db = DBHelper(this).writableDatabase

                db.execSQL("insert into TODO_TB(title,detail) values(?,?)",
                    arrayOf<String>(title,detail))

                val intent = Intent(this, DmFragment::class.java)
                intent.putExtra("title", binding.titleText.text.toString())
                intent.putExtra("detail", binding.detailText.text.toString())
                setResult(Activity.RESULT_OK, intent)

                finish()

                return true
            }
            else -> {
                val intent = Intent(this,DmMainActivity::class.java)
                startActivity(intent)
                finish()
                return super.onOptionsItemSelected(item)
            }
        }
    }

    //일반 뒤로가기 버튼
    override fun onBackPressed() {
        val intent = Intent(this,DmMainActivity::class.java)
        startActivity(intent)
        finish()

        }
    }



