package edu.harding.cwilson14.tipcalculator

/**
 * Created by cwilson14 on 9/4/2017.
 */

class TipCalculatorModel(bill: Float = 0F, tipPercent: Float = 0F) {

    var bill: Float=bill
    var tipPercent: Float = tipPercent
    var tipAmount: Float = bill * tipPercent
        private set
    var total: Float = bill + tipAmount
        private set

    init {
        this.bill = bill
        this.tipPercent = tipPercent
    }
}
