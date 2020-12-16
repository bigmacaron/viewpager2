package ga.catcat.fragmentviewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ga.catcat.fragmentviewpager2.fragments.*

class ExampleStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    var fragments : ArrayList<Fragment> = arrayListOf(
        FragmentA(),
        FragmentB(),
        FragmentC(),
        FragmentD()
    )
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }



}