package kr.ac.hallym.seoseuofolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.FragmentStudyOneBinding


class StudyOneFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentStudyOneBinding.inflate(inflater,container,false)

        val contents1 = mutableListOf<Int>(
            R.drawable.javalogo,
            R.drawable.sslogo,
            R.drawable.mysqllogo,
            R.drawable.opensourcelogo,
            R.drawable.computerlogo,
            R.drawable.clogo,
            R.drawable.oslogo,
            R.drawable.dslogo,
            R.drawable.programinglogo,
            R.drawable.algologo,
            R.drawable.digitallogo,
            R.drawable.weblogo,
            R.drawable.androidstudio,
            R.drawable.imbelogo
        )

        val contents2 = mutableListOf<String>()
        val contents3 = mutableListOf<String>()


        contents2.add("자바프로그래밍")
        contents3.add("이클립스를 통해 객체지향 프로그래밍인 자바 프로그래밍 기술을 터득합니다.")

        contents2.add("신호 및 시스템")
        contents3.add("주파수와 주기, 오일러, 퓨리에 변환 등, 신호의 원리를 배웁니다.")

        contents2.add("데이터베이스기초")
        contents3.add("MySql을 통한 데이터베이스 구축과 이론적 지식을 함께 배웁니다.")

        contents2.add("오픈소스SW의 이해")
        contents3.add("리눅스, 아파치, 텐서플로우 등의 오픈 소스를 실습하고, 깃과 깃허브를 사용합니다.")

        contents2.add("컴퓨터구조")
        contents3.add("하드웨어의 초기서부터 배움을 시작하고 로직웍스와 어셈블리언어를 실습을 통해 공부합니다.")

        contents2.add("C프로그래밍")
        contents3.add("vsCode를 이용하여 C프로그래밍을 공부하며 함수, 구조체, 공용체 등 기반을 터득합니다.")

        contents2.add("운영체제")
        contents3.add("OS가 어떻게 동작하고 작동하는지에 대해 수많은 이론을 통해 공부하여 OS의 동작 원리를 이해합니다.")

        contents2.add("자료구조")
        contents3.add("재귀함수, 배열, 리스트의 구조를 이해하고 이클립스를 통해 직접 데이터를 넣어 실습하였습니다.")

        contents2.add("프로그래밍어론")
        contents3.add("프로그래밍 언어의 역사를 공부하며, 여태까지 개발된 언어들을 공부하며 현재까지 어떻게 오게 되었는지 배웁니다.")

        contents2.add("알고리즘")
        contents3.add("리스트, 트리, 그래프, 힙 정렬을 이해하며 동작원리를 직접 구현해내어 복잡한 알고리즘이 어떻게 동작하는지 이해합니다.")

        contents2.add("디지털 신호처리")
        contents3.add("신호 및 시스템 과목에서 이해한 신호들의 이론적 지식을 파이썬에 직접 대입하여 결과물을 도출해냅니다.")

        contents2.add("웹 프로그래밍")
        contents3.add("Html5, Css, JavaScript, Jquery를 통하여 직접 웹 사이트를 구축하며, 웹 구조가 어떻게 구성되는지 이해합니다.")

        contents2.add("모바일 프로그래밍")
        contents3.add("코틀린과 안드로이드 스튜디오를 통한 실습을 공부하며 안드로이드 어플리케이션의 구성을 이해하고 직접 어플리케이션을 만듭니다.")

        contents2.add("임베디드 시스템")
        contents3.add("이론 수업을 통해 임베디드의 지식을 얻어가며, 라즈베리파이를 사용하여 여러 실습 동작들을 만들어내고 프로젝트를 구상해냅니다.")

        //프레그먼트에서 context 접근 할 때 requireContext()를 사용해준다.

        binding.recyclerviewStudy.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewStudy.adapter = StudyAdapter(contents1,contents2, contents3)
        binding.recyclerviewStudy.addItemDecoration(
            DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        )
//


        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_seo, container, false)
        return binding.root

    }
}

