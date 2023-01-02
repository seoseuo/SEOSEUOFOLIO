package kr.ac.hallym.seoseuofolio

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kr.ac.hallym.seoseuofolio.databinding.ProjectCardViewBinding
import org.antlr.v4.runtime.misc.MurmurHash.finish

//------------ 프로젝트 어댑터

class ProjectViewHolder(val binding: ProjectCardViewBinding) : RecyclerView.ViewHolder(binding.root)

class ProjectAdapter(

    val contents1: MutableList<Int>?, val contents2:MutableList<String>?,
    val contents3:MutableList<String>?,val contents4:MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ProjectViewHolder(
            ProjectCardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val binding = (holder as ProjectViewHolder).binding
        binding.imageView.setImageResource(contents1!![position])
        binding.titleText.text = contents2!![position]
        binding.detailText.text = contents3!![position]
        binding.gitHubProject.text = contents4!![position]


        //리사이클러 뷰 수정 버튼 클릭 했을 때
        binding.editProject.setOnClickListener {
            val intent = Intent(binding.root.context, ProjectEditActivity::class.java)
            intent.putExtra("image_edit", R.drawable.upload)
            intent.putExtra("title_edit", contents2!![position])
            intent.putExtra("detail_edit", contents3!![position])
            intent.putExtra("link_edit", contents4!![position])

            //해당 item의 db _id값이 얼마인지 계산해서 intent로 담아줘야함.
            val db = ProjectDBHelper(binding.root.context).readableDatabase
            intent.putExtra("position", position)
            //상단에서 position 번째만큼 내려간 후 해당 커서를 업데이트 해주면 됌
            binding.root.context.startActivity(intent)
        }

        //삭제 버튼 클릭 했을 때
        binding.deleteProject.setOnClickListener {

            //1. db를 열어준다.
            //2. edit와 같은 원리로 _id 값을 계산하여 삭제 할 수 있도록 한다.

            val db = ProjectDBHelper(binding.root.context).writableDatabase
            //DB Helper를 열어준다.

            val cursor = db.rawQuery("SELECT _id FROM PRO_TB", null) //_id 속성들만 가져오기

            //DB에 아무 값도 없을 수 있다. 그러므로 체크해준다. try - catch 문으로

            try {
                cursor.moveToNext()
                // 커서가 처음 시작이 -1이어서 한번 앞으로 땡겨서 0에 위치하게 끔 해준다.

                // 3. position 값 만큼 다음으로 이동해준다.

                var i = 0;

                while(i<position) {
                    cursor.moveToNext()
                    i++
                }
                var id : Int = Integer.parseInt((cursor.getInt(0)).toString());

                db.execSQL("delete from PRO_TB WHERE _id=(?)", arrayOf(cursor.getInt(0)))
                Toast.makeText(binding.root.context, "프로젝트 게시물이 삭제되었습니다 .", Toast.LENGTH_SHORT).show()

            } catch (e : Exception) {
                Toast.makeText(binding.root.context, "프로젝트 게시물이 없습니다 .", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(binding.root.context,ProjectMainActivity::class.java)
            binding.root.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return contents1?.size ?: 0
    }

}


//------------ 프로젝트2 어댑터

class Project2Adapter(

    val contents1: MutableList<Int>?, val contents2:MutableList<String>?,
    val contents3:MutableList<String>?,val contents4:MutableList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ProjectViewHolder(
            ProjectCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val binding = (holder as ProjectViewHolder).binding
        binding.imageView.setImageResource(R.drawable.upload)
        binding.titleText.text = contents2!![position]
        binding.detailText.text = contents3!![position]
        binding.gitHubProject.text = contents4!![position]


        //리사이클러 뷰 수정 버튼 클릭 했을 때
        binding.editProject.setOnClickListener {
            val intent = Intent(binding.root.context, ProjectEditActivity::class.java)
            intent.putExtra("image_edit", R.drawable.upload)
            intent.putExtra("title_edit", contents2!![position])
            intent.putExtra("detail_edit", contents3!![position])
            intent.putExtra("link_edit", contents4!![position])

            //해당 item의 db _id값이 얼마인지 계산해서 intent로 담아줘야함.
            val db = ProjectDBHelper(binding.root.context).readableDatabase
            intent.putExtra("position", position)
            //상단에서 position 번째만큼 내려간 후 해당 커서를 업데이트 해주면 됌
            binding.root.context.startActivity(intent)
        }

        //삭제 버튼 클릭 했을 때
        binding.deleteProject.setOnClickListener {

            //1. db를 열어준다.
            //2. edit와 같은 원리로 _id 값을 계산하여 삭제 할 수 있도록 한다.

            val db = ProjectDBHelper(binding.root.context).writableDatabase
            //DB Helper를 열어준다.

            val cursor = db.rawQuery("SELECT _id FROM PRO_TB", null) //_id 속성들만 가져오기

            //DB에 아무 값도 없을 수 있다. 그러므로 체크해준다. try - catch 문으로

            try {
                cursor.moveToNext()
                // 커서가 처음 시작이 -1이어서 한번 앞으로 땡겨서 0에 위치하게 끔 해준다.

                // 3. position 값 만큼 다음으로 이동해준다.

                var i = 0;

                while(i<position) {
                    cursor.moveToNext()
                    i++
                }
                var id : Int = Integer.parseInt((cursor.getInt(0)).toString());

                db.execSQL("delete from PRO_TB WHERE _id=(?)", arrayOf(cursor.getInt(0)))
                Toast.makeText(binding.root.context, "프로젝트 게시물이 삭제되었습니다 .", Toast.LENGTH_SHORT).show()

            } catch (e : Exception) {
                Toast.makeText(binding.root.context, "프로젝트 게시물이 없습니다 .", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(binding.root.context,ProjectMainActivity::class.java)
            binding.root.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int {
        return contents1?.size ?: 0
    }

}