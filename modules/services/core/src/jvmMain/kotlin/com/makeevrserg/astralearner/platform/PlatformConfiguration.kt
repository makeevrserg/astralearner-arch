package com.makeevrserg.astralearner.platform

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import java.util.prefs.Preferences

actual class PlatformConfiguration : StringProvider {
    val preferences = Preferences.userRoot()
    override fun toString(desc: StringDesc): String {
        return desc.localized()
    }
    override fun toString(strRes: StringResource): String = toString(strRes.desc())
}
