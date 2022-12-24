package kr.ac.hallym.seoseuofolio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.FragmentDmBinding


class DmFragment : Fragment() {
    lateinit var adapter: SeoAdapter
    var title : MutableList<String>? = null
    var detail : MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDmBinding.inflate(inflater,container,false)

        val requestLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {

            it.data?.getStringExtra("title")?.let {
                title?.add(it)
                adapter.notifyDataSetChanged()
            }
            it.data?.getStringExtra("detail")?.let {
                detail?.add(it)
                adapter.notifyDataSetChanged()
            }
        }

        //자꾸 타이틀로 리사이클러뷰가 갱신됌 ㅜㅜ


        //추가하는 메소드드
       binding.add.setOnClickListener {
            val intent = Intent(requireContext(),DmAddActivity::class.java)
            requestLauncher.launch(intent)
        }

        title = mutableListOf<String>()
        detail = mutableListOf<String>()

        val db = DBHelper(requireContext()).readableDatabase
        val cursor = db.rawQuery("select * from TODO_TB",null)
        cursor.run {

            while(moveToNext()) {
                title?.add(cursor.getString(1))
                detail?.add(cursor.getString(2))
            }
        }

        //마지막 행 값 삭제하기 ★★★★★★★
        binding.del.setOnClickListener {
            val db = DBHelper(requireContext()).readableDatabase
            val cursor = db.rawQuery("SELECT _id FROM TODO_TB", null) //_id 속성들만 가져오기

            //먼저 카운트해서 있는지 확인, 없으면 이프문 처리
            Log.d("seoseuo!","${cursor.getColumnCount()}") //이 로그에서 1이라고 찍어줌

            if (!(cursor.moveToFirst())) { //열 개수가 0이라면? -> 없으면 0개인줄 알았는데 알고보니 1이었나보다 위의 로그를 참조하자
                Toast.makeText(requireContext(), "데이터를 추가해 주세요", Toast.LENGTH_SHORT).show()
            }
            else { //null이 아니면 ?
                 //커서 마지막으로 이동
//                var last = cursor.getInt(0) //_id 값 가져오기 0번째 1번쨰 2번쨰 / _id , title , detail
//                Log.d("seoseuo!", "$last")
                cursor.moveToLast()
                db.execSQL("delete from TODO_TB WHERE _id=(?)", arrayOf(cursor.getInt(0)))
                Toast.makeText(requireContext(), "마지막 행의 데이터가 삭제되었습니다.", Toast.LENGTH_SHORT).show()


                //액티비티 하나만 실행하고 나머지 코드는 다 지우는
                val i = Intent(requireContext(), DmMainActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            }
        }



       val layoutManager = LinearLayoutManager(requireContext())

        binding.recyclerviewDm.layoutManager = layoutManager
        adapter = SeoAdapter(title,detail)
        binding.recyclerviewDm.adapter=adapter
        binding.recyclerviewDm.addItemDecoration(
            DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        )

        return binding.root
        }
}