package com.waigres.helper

class ForegroundsTaskChecker (
    private val listRestrictedApp: List<String>
) {
    fun isRestricted (packageName: String): Boolean {
        val itemPackageName = listRestrictedApp.find { item -> packageName.equals(item, true) }

        return itemPackageName?.isNotEmpty() == true
    }
}