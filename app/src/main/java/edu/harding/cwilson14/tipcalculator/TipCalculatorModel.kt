package edu.harding.cwilson14.tipcalculator

/**
 * Created by cwilson14 on 9/4/2017.
 */

class TipCalculatorModel(bill: Float = 0F, tipPercent: Float = 0F) {

    var bill: Float=bill
        set(value) {
            field = value
            updateCalculations()
        }

    var tipPercent: Float = tipPercent
        set(value) {
            field = value
            updateCalculations()
        }

    var tipAmount: Float = 0F
        private set

    var total: Float = bill + tipAmount
        private set

    init {
        this.bill = bill
        this.tipPercent = tipPercent
        updateCalculations()
    }

    private fun updateCalculations() {
        tipAmount = bill * tipPercent
        total = bill + tipAmount
    }
}
