package com.makeevrserg.astralearner.platform

import android.content.Context
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

actual class PlatformConfiguration(val context: Context) : StringProvider {
    val sharedPreferences = context.getSharedPreferences(
        "ASTRA_LEARNER",
        Context.MODE_PRIVATE
    )

    override fun toString(desc: StringDesc): String {
        return desc.toString(context)
    }

    override fun toString(strRes: StringResource): String = toString(strRes.desc())
}
