import java.util.*

/*
    This file runs bubble sort and selective sort 5000 times using
    randomly generated lists.
 */

fun main(args: Array<String>) {

}

fun bubble(array: Array<Int>) {
    val length = array.size
    for (i in (length..1)) {
        for (j in (1..i)) {
            if (array[j-1] > array[j]) {
                array[j-1] = array[j]
                array[j] = array[j-1]
            }
        }
    }
}

fun selection(array: Array<Int>) {

}


/*
    Extension methods
 */
fun ArrayList<Int>.randoms(length: Int) {
    //Add 500 random integers to the list
    for (i in 0..length) {
        this.add(Random().nextInt((10000 + 1) - 0) + 0)
    }
}

fun ClosedRange<Int>.random() : Int = Random().nextInt((endInclusive + 1) - start) + start
