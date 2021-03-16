package com.waigres.helper

import java.util.regex.Matcher
import java.util.regex.Pattern

class ParseFromWeb (val html: String) {

    // between <div class="syndicate"> and </ul>
    fun getListFunFact (): List<String> {
        val result = arrayListOf<String>()
        val pattern: Pattern = Pattern.compile("<div class=\"syndicate\">(.*?)</ul>", Pattern.DOTALL)
        val matcher: Matcher = pattern.matcher(html)
        var containListFunFact = ""
        while (matcher.find()) {
            containListFunFact += matcher.group(1)
        }
        val patternListFunFact: Pattern = Pattern.compile("<li>(.*?)</li>", Pattern.DOTALL)
        val matcherListFunFact: Matcher = patternListFunFact.matcher(containListFunFact)
        while (matcherListFunFact.find()) {
            result.add(matcherListFunFact.group(1)?:"")
        }
        return result
    }
}