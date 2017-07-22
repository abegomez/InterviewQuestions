package myapp.abrahamjohngomez.com.interviewchallenges

import android.content.Context
import java.io.FileOutputStream

/**
 * Created by ryuhyoko on 6/26/2017.
 */
data class Problem (
    var question: String = "Count number of bits set to 1 in an integer.",
    var answer: String = "" +
            "public static short countBits(int x) {\n" +
            "\tshort numBits = 0;\n" +
            "\twhile(x != 0) {\n" +
            "\t\tnumBits += (x & 1);\n" +
            "\t\tx >>>= 1;\n" +
            "\t}\n" +
            "\treturn numBits;\n}"

) {

}