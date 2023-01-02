package kr.ac.hallym.seoseuofolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import kr.ac.hallym.seoseuofolio.databinding.ActivityTestBinding


class TestActivity : AppCompatActivity() , OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "화면 왼쪽 끝에서\n오른쪽으로 드래그해보세요.", Toast.LENGTH_SHORT).show()

        //바인딩

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //툴바 메뉴

        //네비게이션 뷰 객체 설정
        binding.mainDrawerView.setNavigationItemSelectedListener(this)

        //버튼 클릭 링크 이동
        binding.notion.setOnClickListener {
            val MyIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://chivalrous-saffron-326.notion.site/SEOSEUOFOLIO-67fb1bc68d0145edacba6979ef0fcd18"))
            startActivity(MyIntent)
        }

        binding.github.setOnClickListener {
            val MyIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/seoseuo/SEOSEUOFOLIO"))
            startActivity(MyIntent)
        }



    }


    //------------------------------------------------------



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //logout
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onOptionsItemSelected(item)
    }

    //네이게이션 이동
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home-> {
                val intent = Intent(this,TestActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_seoseuo-> {
                val intent = Intent(this,SeoMainActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_club-> {
                val intent = Intent(this,CouncilMainActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_study-> {
                val intent = Intent(this,StudyMainActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_project-> {
                val intent = Intent(this,ProjectMainActivity::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_dm-> {
                val intent = Intent(this,DmMainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return false
    }


    //뒤로가기->testAct
    var time :Long = 0

    override fun onBackPressed() {

        if (System.currentTimeMillis() - time >= 2000) {
            time = System.currentTimeMillis()
            Toast.makeText(applicationContext, "한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            finish()

        }
    }

}





