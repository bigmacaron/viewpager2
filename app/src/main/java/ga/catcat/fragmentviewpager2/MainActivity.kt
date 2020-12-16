package ga.catcat.fragmentviewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager2withFragments()

    }
    private fun initViewPager2(){
        var viewPager : ViewPager2 = viewPager2
        var adapter = ViewPagerViewAdapter()
        viewPager.adapter = adapter
        adapter.setNewUser(createExampleUserList())

        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 스와핑 방향

        var tabLayout : TabLayout = tablayout
        TabLayoutMediator(tabLayout, viewPager){
            tab,position ->
            tab.text = createExampleUserList()[position].firstName
        }.attach()
    }

    private fun initViewPager2withFragments(){
        var viewpager : ViewPager2 = viewPager2
        var adapter = ExampleStateAdapter(supportFragmentManager,lifecycle)
        viewpager.adapter = adapter

        var names:ArrayList<String> = arrayListOf("FragmentA","FragmentB","FragmentC","FragmentD")
        var tabLayout : TabLayout = tablayout
        TabLayoutMediator(tabLayout, viewpager){
                tab,position ->
            tab.text = names[position]
        }.attach()

    }

    private fun createExampleUserList() : ArrayList<User>{
        var export: ArrayList<User> = ArrayList()
        export.add(User("길동","홍"))
        export.add(User("기도","김"))
        export.add(User("동길","박"))
        export.add(User("길동","고"))

        return export

    }
}