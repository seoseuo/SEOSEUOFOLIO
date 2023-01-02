package kr.ac.hallym.seoseuofolio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.hallym.seoseuofolio.databinding.FragmentSeoBinding


class SeoFragment : Fragment() {
    lateinit var binding: FragmentSeoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentSeoBinding.inflate(layoutInflater)

        val contents1 = mutableListOf<String>() //큰 글씨 -> 연도, 타이틀
        val contents2 = mutableListOf<String>() //작은글씨 -> 내용 약력

        contents1.add("주요이력\uD83D\uDD0D")
        contents2.add("저의 이력들 중 중요하다고 생각도는 것들을 모아보았습니다.")

        contents1.add("\uD83C\uDFC6수상내역\uD83C\uDFC6")
        contents2.add("2021 2-2 학기우등 (4.32)\n2022 3-1 학기우등 (4.3)")

        contents1.add("\uD83D\uDCDA학술 활동\uD83D\uDCDA")
        contents2.add("2021 2-2\n" +
                "[특강] 오픈소스SW 라이선스 교육 이수\n" +
                "[SW Week 대회] GitHub 이력서 콘테스트 해커톤 참여\n" +
                "소융인의 날 - 소융대 도전골든벨 참여\n\n" +
                "2022 3-1\n" +
                "학술동아리 [노네임] 자바프로그래밍I 멘토링 진행\n\n" +
                "2022 3-2\n" +
                "개인 멘토링 자바프로그래밍I 멘토링 진행\n" +
                "[특강] (주)소이넷★ AI엔진 개발 특강\n" +
                "[특강] 게임개발자에게 요구되는 역량이란?\n" +
                "[SW Week 대회] GitHub 이력서 콘테스트 해커톤 참여")

        contents1.add("\uD83D\uDC68\u200D\uD83D\uDCBB교내외 및 자치활동\uD83D\uDC69\u200D\uD83D\uDCBB")
        contents2.add("2021 2-2\n" +
                "총학생회후보 선거본부 [H-all] 선거운동원\n\n" +
                "2022 3-1\n" +
                "정보과학대학 학생자치기구 [A:BLE] 체육부장\n" +
                "과 축구동아리 [DEFY] 부회장\n\n" +
                "2022 3-2\n" +
                "한림대학교 대동제 축제준비위원회 무대팀원\n"+
                "23년도 정과대학생회후보 선거본부 [SEASON] 선거본부장")

        contents1.add("총이력\uD83D\uDCC3")
        contents2.add("제가 해왔던 모든 활동들입니다.")


        contents1.add("2018 1-1")
        contents2.add("한림대학교 [IT계열] 입학\n" +
                "과 학술동아리 [멀티플렉스] 부원\n" +
                "과 축구동아리 [DEFY] 기장\n" +
                "중앙 배구동아리 [SKY] 부원\n" +
                "공과대학 체육대회 [DEFY B팀] 선수 축구경기 출전")

        contents1.add("2018 2-2")
        contents2.add("한림대학교X강원대학교 스포츠교류전 [한강전]\n배구선수 출전\n" +
                "교내 자체 리그 [인트라뮤랄리그] DEFY 축구선수 출전\n")

        contents1.add("2019 2-1")
        contents2.add("전공선택 [(주)스마트IOT , (부) 빅데이터]\n" +
                "소프트웨어융합대학 체육대회 [DEFY] 선수 축구경기 출전")

        contents1.add("2019")
        contents2.add("입대휴학\n" +
                "제 5 보병사단 신병교육대 입소")

        contents1.add("2021")
        contents2.add("제 8 기동사단 공병대대 통신병 병장 만기전역\n" +
                "복학")

        contents1.add("2021 2-2")
        contents2.add("총학생회후보 선거본부 [H-all] 선거운동원\n" +
                "학기우등 [4.32]")

        contents1.add("2022 3-1")
        contents2.add("정보과학대학 학생자치기구 [A:BLE] 체육부장\n" +
                "과 축구동아리 [DEFY] 부회장\n" +
                "과 축구동아리 [일레븐] 부원\n" +
                "과 학술동아리 [노네임] 부원\n" +
                "학술동아리 [노네임] 자바프로그래밍I 멘토링 진행\n" +
                "학기우등 [4.3]")

        contents1.add("2022 3-2")
        contents2.add("한림대학교 대동제 축제준비위원회 무대팀원\n" +
                "개인 멘토링 자바프로그래밍I 멘토링 진행\n" +
                "정보과학대학 체육대회 [DEFY] 선수 축구경기 출전\n" +
                "정과대학생회후보 선거본부 [SEASON] 선거본부장")

        contents1.add("자격증\uD83D\uDCB3")
        contents2.add("열심히 준비하여 늘릴 것 입니다.")

        contents1.add("국가 자격증")
        contents2.add("운전면허 - 2종 보통")


        contents1.add("MOS")
        contents2.add("Word-Expert\nExcel-Expert")

        //프레그먼트에서 context 접근 할 때 requireContext()를 사용해준다.

        binding.recyclerviewSeo1.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerviewSeo1.adapter = SeoAdapter(contents1,contents2)
        binding.recyclerviewSeo1.addItemDecoration(
            DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL)
        )

        //버튼 클릭 링크 이동
        binding.github.setOnClickListener {
            val MyIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/seoseuo/seoseuo"))
            startActivity(MyIntent)
        }

        binding.notion.setOnClickListener {
            val MyIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.notion.so/d75c5abeb41a46519151ae95681db854"))
            startActivity(MyIntent)
        }

        binding.insta.setOnClickListener {
            val MyIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/seuio__/"))
            startActivity(MyIntent)
        }

       return binding.root
    }




}