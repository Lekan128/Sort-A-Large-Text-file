import java.io.File
import java.io.InputStream

fun main() {

  //replace "/Users/Documents/untitled/src/main/resources/from.txt" with your path name you are sorting from
    val inputStream : InputStream = File("/Users/Documents/untitled/src/main/resources/from.txt").inputStream()

    //replace "/Users/Documents/untitled/src/main/resources/to.txt" with the path name you writing into
    val writtenFile = File("/Users/Documents/untitled/src/main/resources/to.txt")

    var arrayList = ArrayList<String>()


    var runnable = Runnable {
        inputStream.bufferedReader().forEachLine {
            for (string in sortSentenceIntoArrayList(it.lowercase())){
                if (string != " " && !isElementPresentInArrayList(string, arrayList)){
                    writtenFile.appendText(string + "\n")
                    arrayList.add(string)
                }
            }

        }
    }

    var thread : Thread = Thread(runnable)
    thread.start()
    
    /*
    * DONE FOR THE MAIN PART
    */
    
    
}
