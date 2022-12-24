package kr.ac.hallym.seoseuofolio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import kr.ac.hallym.seoseuofolio.databinding.ActivityCouncilMainBinding
import kr.ac.hallym.seoseuofolio.databinding.ActivityStudyMainBinding

class CouncilMainActivity : AppCompatActivity() , OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCouncilMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //어댑터에 프래그먼트 담는 변수 액티비티 바꿀 때 꼭 확인할 것
        val adapter = CouncilFragementPagerAdapter(this)

        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tabs,binding.viewpager) { tab, position ->
            when(position) {
                0-> tab.text = "그림"
                1-> tab.text = "A:BLE"
                2-> tab.text = "DEFY"
                
            }

        }.attach()

        //네비게이션 뷰 객체 설정
        binding.mainDrawerView.setNavigationItemSelectedListener(this)

    } //onCreate ---------------------------------------------------------------------------------

    override fun onBackPressed() {
        val intent = Intent(this,TestActivity::class.java)
        startActivity(intent)
        finish()
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

    //상단 좌측 뒤로가기 버튼 ->
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this,TestActivity::class.java)
        startActivity(intent)
        finish()
        return super.onOptionsItemSelected(item)
    }
}

class CouncilFragementPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragment:List<Fragment>
    init {
        fragment = listOf(GrimFragment(),AbleFragment(),DefyFragment())
    }


    override fun getItemCount(): Int = fragment.size

    override fun createFragment(position: Int): Fragment = fragment[position]

}


