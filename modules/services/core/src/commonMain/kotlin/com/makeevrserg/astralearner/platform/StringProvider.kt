package com.makeevrserg.astralearner.platform

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.StringDesc

interface StringProvider {
    /**
     * This function is needed to convert [StringDesc] to string from outside of Composable functions
     */
    fun toString(desc: StringDesc): String

    /**
     * This function is neede to convert [StringResource] to string from outside of Composable functions
     */
    fun toString(strRes: StringResource): String
}
