package com.nwq.function.scheduling.executer.fight.rule

import com.nwq.function.scheduling.core_code.img.ColorIdentificationRule

object DialogueColorRule : ColorIdentificationRule {
    override fun verificationRule(red: Int, green: Int, blue: Int): Boolean {
        return if (green > 140) {
            if (green > red * 2.3 && green > blue + 18) {
                true
            } else {
                false
            }
        } else if (green > 110) {
            if (green > red * 2.1 && green > blue + 12) {
                true
            } else {
                false
            }
        } else if (green > 90) {
            if (green > red * 2 && green > blue + 10) {
                true
            } else {
                false
            }
        } else if (green > 70) {
            if (green > red * 1.8 && green > blue + 9) {
                true
            } else {
                false
            }
        } else if (green > 60) {
            if (green > red + 20 && green > blue + 5) {
                true
            } else {
                false
            }
        } else {
            false
        }
    }
}