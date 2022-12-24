package kr.ac.hallym.seoseuofolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.ActivityProjectMainBinding
import kr.ac.hallym.seoseuofolio.databinding.FragmentProjectBinding


class ProjectFragment : Fragment() {
    lateinit var binding: FragmentProjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentProjectBinding.inflate(layoutInflater)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentProjectBinding.inflate(inflater,container,false)

        val contents1 = mutableListOf<Int>(
            R.drawable.calcurproject,
            R.drawable.seoseuolog,
            R.drawable.seoseuonews,
            R.drawable.imbeproject,
        )

        val intent = Intent(Intent.ACTION_VIEW)

        val contents2 = mutableListOf<String>("간단한 사칙연산 계산기","웹 프로젝트 SEOSEUOLOG","인터넷 신문 '서승일보'","무인 화재 경보 시스템")
        val contents3 = mutableListOf<String>(
            "안드로이드 스튜디오를 배우기 전, 처음으로 만들어본 간단한 사칙연산 계산기 입니다. 구글링을 통해 지식을 습득하여 만든 간단한 프로그램 입니다. 이 간단한 프로젝트를 통해 안드로이드 스튜디오를 보다 쉽게 접할 수 있었습니다.",
            "웹 프로젝트 서승로그입니다. Html5 , Css, Javascript를 통하여 구현하였고, SEOSEUOFLOIO의 웹 버전이라고 생각하시면 될 것 같습니다. 나만의 이력 웹 사이트를 만들고 싶었고, 학기 중 웹프로그래밍 강의를 통해 습득한 지식으로 구현해보았습니다.",
            "카타르 월드컵 16강 진출 기념으로 저만의 월드컵과 축구 관련 내용으로 인터넷 신문을 만들어보았습니다. 팝업, iframe, 실시간 기사, 달력 기능을 추가하였고, 후에는 더욱 더 정교한 디자인을 꾸려 실제로 서비스하는 인터넷 신문처럼 업그레이드 하는것이 목표입니다.",
            "Coap서버와 라즈베리파이, 온습도계 센서, 부저, led,lcd 모듈로 구현한 무인 점포를 주 클라이언트로 하는 무인 화재 경보 임베디드 시스템입니다. 이 시스템은 장치에 달린 온습도계 센서가 화재 시 발생 온도 이상을 감지하면 Gui Client를 통해 USER에게 상황 인지 및 조치 유도를 할 수 있습니다."
            )

        binding.recyclerviewProject.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewProject.adapter = AbleAdapter(contents1,contents2,contents3)
        binding.recyclerviewProject.addItemDecoration(
            DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        )



//
//        var intent2 = Intent(requireContext(),FragmentProjectBinding::class.java)   // 어답터에서 보낸 인텐트 받아오기
//        var uri : String = intent2.getStringExtra("link").toString()
//
//        if (uri=="no") {
//            Toast.makeText(requireContext(), "링크가 없습니다.", Toast.LENGTH_SHORT).show()
//        }
//        else {
//            intent2.setData(Uri.parse(uri))
//            startActivity(intent2) //값 옮겨넘어가기
//        }

        // Inflate the layout for this fragment
        return binding.root
    }
}




