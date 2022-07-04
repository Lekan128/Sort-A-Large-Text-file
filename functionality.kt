fun sortSentenceIntoArrayList(sentence : String) : ArrayList<String>{
    var array = splitStringIntoArray(sentence)

    var arrayOfLetters = changeToAnArrayOfOnlyLetters(array)

    return wordsQuickSort(arrayOfLetters)
}

fun wordsQuickSort(data: ArrayList<String>): ArrayList<String>{


    if(data.size < 2) return  data
    if (getWordsPivot(data) == null) return data
    var pivot = getWordsPivot(data)

    var smallerArray = ArrayList<String>()
    var biggerArray = ArrayList<String>()

    data.remove(pivot)

    for (element in data){
        if(element > pivot!!) biggerArray.add(element)
        else smallerArray.add(element)
    }

    smallerArray = wordsQuickSort(smallerArray)
    biggerArray = wordsQuickSort(biggerArray)

    smallerArray.add(pivot!!)

    return smallerArray.plus(biggerArray) as ArrayList<String>
}

fun splitStringIntoArray(s : String) : ArrayList<String> {
    var delimiter = " "

    var list = s.split(delimiter)
//    var array = list.toTypedArray()

    var arrayList = list.toCollection(ArrayList())
    return arrayList
}

/*
*To know which word is greater
*I have to compare their letters
*
* an is greater function
* returns true if the first word is greatr than the second
* if(st1>st2) then st1 comes after st2 in a dictionary
* */
fun getWordsPivot(list : ArrayList<String>) : String? {
    var increment = 0

    while (increment < list.size-1){
        if (list[increment] > list[increment+1]) return list[increment]
        ++increment
    }

    return null;

}

private  fun isAlphabet (char: Char): Boolean {
    return (char == 'a' || char == 'b' || char == 'c' || char == 'd' || char == 'e' || char == 'f' ||
            char == 'g' || char == 'h' || char == 'i' || char == 'j' || char == 'k' || char == 'l' ||
            char == 'm' || char == 'n' || char == 'o' || char == 'p' || char == 'q' || char == 'r' ||
            char == 's' || char == 't' || char == 'u' || char == 'v' || char == 'w' || char == 'x' ||
            char == 'y' || char == 'z'
            ||
            char == 'A' || char == 'B' || char == 'C' || char == 'D' || char == 'E' || char == 'F' ||
            char == 'G' || char == 'H' || char == 'I' || char == 'J' || char == 'K' || char == 'L' ||
            char == 'M' || char == 'N' || char == 'O' || char == 'P' || char == 'Q' || char == 'R' ||
            char == 'S' || char == 'T' || char == 'U' || char == 'V' || char == 'W' || char == 'X' ||
            char == 'Y' || char == 'Z')

    //return true if it is an alphabet else return false
}

fun changeToStringWithOnlyLetters(string : String) : String{
    for(char in string){
        if (!isAlphabet(char)) try{
            var replacement = string.replace(char.toString() , "")
            return changeToStringWithOnlyLetters(replacement)
        } catch (e : Exception){
            println(string)
        }
    }
    return string
}

fun changeToAnArrayOfOnlyLetters(array : ArrayList<String>) : ArrayList<String>{

    for (string in array){
        val replace = changeToStringWithOnlyLetters(string)
        if (replace != string){
            array.remove(string)
            array.add(replace)
            return changeToAnArrayOfOnlyLetters(array)
        }
    }

    return array
}

fun isElementPresentInArrayList(element : String, arrayList : ArrayList<String>) : Boolean{
    for(content in arrayList){
        if (element == content){
            return true
        }
    }
    return false
}
