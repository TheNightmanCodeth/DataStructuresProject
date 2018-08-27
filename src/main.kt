import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.measureTimeMillis

/*
    This file runs bubble sort and selective sort 5000 times using
    randomly generated lists.
 */

fun main(args: Array<String>) {
    val length: Array<Int> = arrayOf(500, 2500, 5000)
    val bubbleResults: ArrayList<Long> = arrayListOf()
    val selectionResuts: ArrayList<Long> = arrayListOf()
    //MeasureTimeMillis is a built-in function
    for (i in (0..2)) {
        //run 1000 times
        for (j in (0..1000)) {
            val executionTime = measureTimeMillis {
                val values:ArrayList<Int> = arrayListOf()
                values.randoms(length[i])
                bubble(values)
            }
            bubbleResults.add(executionTime)
        }
        for (k in (0..1000)) {
            val executionTimeSelection = measureTimeMillis {
                val vals: ArrayList<Int> = arrayListOf()
                vals.randoms(length[i])
                selection(vals)
            }
            selectionResuts.add(executionTimeSelection)
        }
    }
    print("Bubble average: ${bubbleResults.average()}")
    print("Selection average: ${selectionResuts.average()}")
}

fun bubble(array: ArrayList<Int>) {
    val length = array.size - 1
    for (i in (length.downTo(1))) {
        for (j in (1..i)) {
            if (array[j-1] > array[j]) {
                array[j-1] = array[j]
                array[j] = array[j-1]
            }
        }
    }
}

fun selection(array: ArrayList<Int>) {
    var i: Int
    var j: Int
    var iMin: Int
    for (i in (0..(array.size-1))) {
        iMin = i

        for(j in (i+1..(array.size-1))) {
            if (array[j] < array[iMin]) {
                iMin = i
            }
        }
        if (iMin != i) {
            array[i] = array[iMin]
            array[iMin] = array[i]
        }
    }
}


/*
    Extension methods
 */
fun ArrayList<Int>.randoms(length: Int){
    //Add 500 random integers to the list
    for (i in 0..length) {
        this.add(Random().nextInt((10000 + 1) - 0) + 0)
    }
}

fun ClosedRange<Int>.random() : Int = Random().nextInt((endInclusive + 1) - start) + start
