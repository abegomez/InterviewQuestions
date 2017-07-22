package myapp.abrahamjohngomez.com.interviewchallenges

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewpager_layout.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus

class MainActivity : AppCompatActivity() {

    var frags = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var qa : QuestionAnswer = QuestionAnswer()
        qa.question = "What is this"
        qa.answer = "this is that"
//        var nestedMap : HashMap<Int, HashMap<String, String>> = HashMap()
//        nestedMap.put(1, hashMapOf("this" to "that"))
        storeFile(qa)
        var newReadfile = readQAFile()
        frags.add(Frag.newInstance(newReadfile.question, newReadfile.answer))

        val mCollectionPagerAdapter = CollectionPagerAdapter(supportFragmentManager, getFragments())
        val viewpager = findViewById(R.id.pagersingleitem) as ViewPager?
        viewpager!!.adapter = mCollectionPagerAdapter
    }

    fun storeFile(qa : QuestionAnswer) {
        val filename = "Problems.hash"
        var objectOutputStream : ObjectOutputStream
        var fileOutputStream: FileOutputStream

        try {
            fileOutputStream = this.openFileOutput(filename, Context.MODE_PRIVATE)
            objectOutputStream = ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(qa)
            objectOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun storeFile(nestedMap : HashMap<Int, HashMap<String, String>>) {
        val filename = "Problems.hash"
        var objectOutputStream : ObjectOutputStream
        var fileOutputStream: FileOutputStream

        try {
            fileOutputStream = this.openFileOutput(filename, Context.MODE_PRIVATE)
            objectOutputStream = ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(nestedMap)
            objectOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun readQAFile() : QuestionAnswer {
        var myHashmap = QuestionAnswer()
        try {
            val fileInputStream: FileInputStream =
                    FileInputStream(this.filesDir.toString() + "/Problems.hash")
            val objectInputStream: ObjectInputStream = ObjectInputStream(fileInputStream)
            myHashmap = objectInputStream.readObject() as QuestionAnswer
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return myHashmap

    }
    fun readFile() : Triple<Int, String, String> {
        var myHashmap = Triple<Int, String, String>(1,"nope", "nope")
        try {
            val fileInputStream: FileInputStream =
                    FileInputStream(this.filesDir.toString() + "/Problems.hash")
            val objectInputStream: ObjectInputStream = ObjectInputStream(fileInputStream)
            myHashmap = objectInputStream.readObject() as Triple<Int, String, String>
        } catch (e: Exception) {
            e.printStackTrace()
        }
            return myHashmap

    }
    fun readNestedHashFile() : HashMap<Int, HashMap<String, String>> {
        var myHashmap = HashMap<Int, HashMap<String, String>>()

        try {
            val fileInputStream: FileInputStream =
                    FileInputStream(this.filesDir.toString() + "/Problems.hash")
            val objectInputStream: ObjectInputStream = ObjectInputStream(fileInputStream)
            myHashmap = objectInputStream.readObject() as HashMap<Int, HashMap<String, String>>
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return myHashmap

    }
    fun getFragments(): ArrayList<Fragment> {

        frags.add(Frag.newInstance("hello", "hello"))
        frags.add(Frag.newInstance("hello", "hello"))
        frags.add(Frag.newInstance("hello", "hello"))
        frags.add(Frag.newInstance("hello", "hello"))
        frags.add(Frag.newInstance("hello", "hello"))
        return frags
    }
}
