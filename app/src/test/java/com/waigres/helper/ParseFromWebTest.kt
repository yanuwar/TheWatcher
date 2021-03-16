package com.waigres.helper

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

class ParseFromWebTest {
    val html = "New Note 1\n" +
            "\n" +
            "         <!DOCTYPE html>\n" +
            "    <html itemscope itemtype=\"http://schema.org/WebPage\" lang=\"en\">\n" +
            "    <head>\n" +
            "    \t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
            "    \t<meta charset=\"UTF-8\"/>\n" +
            "    \t<meta name = \"viewport\" content = \"user-scalable=no, initial-scale=1.0, width=device-width\" />\n" +
            "    \t<meta itemprop=\"name\" content=\"Kids Environment Kids Health  - National Institute of Environmental Health Sciences\" />\n" +
            "    \t\t\t<meta itemprop=\"description\" content=\"Trivia refer to bits of information, often of little importance.\" />\n" +
            "    \t\t<meta name=\"description\" content=\"Trivia refer to bits of information, often of little importance.\" />\n" +
            "    \t\t<meta property=\"og:title\" content=\"Fun Facts and Trivia\" />\n" +
            "    \t<meta property=\"og:site_name\" content=\"Kids Environment Kids Health  - National Institute of Environmental Health Sciences\" />\n" +
            "    \t<meta property=\"og:url\" content=\"https://kids.niehs.nih.gov/games/riddles/jokes/fun-facts-and-trivia/index.htm\" />\n" +
            "    \t<meta property=\"og:description\" content=\"Trivia refer to bits of information, often of little importance.\" />\n" +
            "    \t<meta property=\"og:type\" content=\"website\" />\n" +
            "    \t<meta property=\"og:image\" content=\"https://kids.niehs.nih.gov/games/assets/img855717.jpg\" />\n" +
            "    \t<meta property=\"og:image:type\" content=\"image/jpeg\" />\n" +
            "    \t<meta name=\"twitter:card\" content=\"summary_large_image\" />\n" +
            "    \t<meta name=\"twitter:site\" content=\"@NIEHS\" />\n" +
            "    \t<meta name=\"twitter:creator\" content=\"@NIEHS\" />\n" +
            "    \t<meta name=\"twitter:url\" content=\"https://kids.niehs.nih.gov/games/riddles/jokes/fun-facts-and-trivia/index.htm\" />\n" +
            "    \t<meta name=\"twitter:title\" content=\"Fun Facts and Trivia - Kids Environment Kids Health  - NIEHS\">\n" +
            "    \t<meta name=\"twitter:description\" content=\"Trivia refer to bits of information, often of little importance.\" />\n" +
            "    \t<meta name=\"twitter:image\" content=\"https://kids.niehs.nih.gov/games/assets/img855717.jpg\" />\n" +
            "    \t<meta itemprop=\"image\" content=\"https://kids.niehs.nih.gov/games/assets/img855717.jpg\" />\n" +
            "    \t<meta name=\"twitter:image:alt\" content=\"Trivia image - six letters in different colors\" />\n" +
            "    \t\t\t\t\t<link rel=\"canonical\" href=\"https://kids.niehs.nih.gov/games/riddles/jokes/fun-facts-and-trivia/index.htm\" />\n" +
            "    \t\t<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"https://kids.niehs.nih.gov/resources/images/apple-touch-icons/touch-icon-114-114.png\" />\n" +
            "    \t<link rel=\"apple-touch-icon\" sizes=\"1024x1024\" href=\"https://kids.niehs.nih.gov/resources/images/apple-touch-icons/touch-icon-1024-1024.png\" />\n" +
            "    \t\t<meta name=\"msapplication-TileImage\" content=\"https://kids.niehs.nih.gov/resources/images/apple-touch-icons/touch-icon-114-114.png\" />\n" +
            "    \t<meta name=\"msapplication-TileColor\" content='#7f1e57' />\n" +
            "    \t<title>Fun Facts and Trivia - Kids Environment Kids Health  - National Institute of Environmental Health Sciences</title>\n" +
            "    \t\t\t<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://kids.niehs.nih.gov/resources/images/favicons/kids.ico\" />\n" +
            "    \t\t\t<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"https://kids.niehs.nih.gov/resources/images/favicons/kids.ico\" />\n" +
            "    \t\t<link rel=\"stylesheet\" type=\"text/css\" media=\"only screen\" href=\"https://kids.niehs.nih.gov/resources/stylesheets/screen.css\" />\n" +
            "    \t<link rel=\"stylesheet\" type=\"text/css\" media=\"only print\" href=\"https://kids.niehs.nih.gov/resources/stylesheets/print.css\" />\n" +
            "    \t<link rel=\"stylesheet\" type=\"text/css\" media=\"only screen\" href=\"https://kids.niehs.nih.gov/resources/stylesheets/coronavirus-emergency-banner.css\" />\n" +
            "    \t\t<!--[if IE]>\n" +
            "    \t<link rel=\"stylesheet\" type=\"text/css\" href=\"https://kids.niehs.nih.gov/resources/stylesheets/ie.css\" />\n" +
            "    \t<![endif]-->\n" +
            "    \t<!-- Google Tag Manager -->\n" +
            "    <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push(\n" +
            "    \n" +
            "    {'gtm.start': new Date().getTime(),event:'gtm.js'}\n" +
            "    \n" +
            "    );var f=d.getElementsByTagName(s)[0],\n" +
            "    j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=\n" +
            "    'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);\n" +
            "    })(window,document,'script','dataLayer','GTM-M2B8CZJ');</script>\n" +
            "    <!-- End Google Tag Manager -->\n" +
            "2021-03-16 11:50:00.833 2167-2167/com.waigres E/test: <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\" integrity=\"sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=\" crossorigin=\"anonymous\"></script>\n" +
            "    \t<script src=\"https://content.jwplatform.com/libraries/QByAZTNU.js\" type=\"text/javascript\"></script>\n" +
            "    \t\t</head><body><div class=\"kids-site-wrapper\">\n" +
            "    \t<div class=\"kids-notifications\">\t<a class=\"kids-notification-skip-navigation-link\" href='#skip-nav' tabindex=\"1\"><div class=\"kids-notification-skip-navigation\">Skip Navigation</div></a>\t<div class=\"kids-notification-emergency-link\"></div></div>\n" +
            "        <div class=\"usa-banner\">\n" +
            "          <div class=\"usa-accordion\">\n" +
            "            <header class=\"usa-banner-header\">\n" +
            "              <div class=\"usa-grid usa-banner-inner\">\n" +
            "              <img src=\"https://www.niehs.nih.gov/web-resources/images/favicon-57.png\" alt=\"U.S. flag\">\n" +
            "              <p>An official website of the United States government</p>\n" +
            "              <button title=\"usa-banner\" aria-label=\"usa-banner\" class=\"usa-accordion-button usa-banner-button\" aria-expanded=\"false\" aria-controls=\"gov-banner\">\n" +
            "                <span class=\"usa-banner-button-text\">Here's how you know</span>\n" +
            "              </button>\n" +
            "              </div>\n" +
            "            </header>\n" +
            "            <div class=\"usa-banner-content usa-accordion-content usa-closed\" id=\"gov-banner\">\n" +
            "              <div class=\"usa-banner-guidance-gov usa-width-one-half\">\n" +
            "                <img class=\"usa-banner-icon usa-media_block-img\" src=\"https://www.niehs.nih.gov/web-resources/images/dot-gov.svg\" alt=\"Dot gov\">\n" +
            "                <div class=\"usa-media_block-body\"> \n" +
            "                  <p>\n" +
            "                    <strong>The .gov means it’s official.</strong>\n" +
            "                    <br>\n" +
            "                    Federal government websites often end in .gov or .mil. Before sharing sensitive information, make sure you’re on a federal government site.\n" +
            "                  </p>\n" +
            "                </div>\n" +
            "              </div>\n" +
            "              <div class=\"usa-banner-guidance-ssl usa-width-one-half\">\n" +
            "                <img class=\"usa-banner-icon usa-media_block-img\" src=\"https://www.niehs.nih.gov/web-resources/images/icon-https.svg\"  alt=\"Https\">\n" +
            "                <div class=\"usa-media_block-body\">\n" +
            "                  <p>\n" +
            "                    <strong>The site is secure.</strong>\n" +
            "                    <br>\n" +
            "                    The <strong>https://</strong> ensures that you are connecting to the official website and that any information you provide is encrypted and transmitted securely.\n" +
            "                  </p>\n" +
            "                </div>\n" +
            "              </div>\n" +
            "            </div>\n" +
            "          </div>\n" +
            "        </div>\n" +
            "    \t<div class=\"clearfix\"></div>\n" +
            "    \t<!--  Coronavirus Emergency infromation -->\n" +
            "      <div class=\"coronavirus_emergency_message-wrapper\">\n" +
            "        <div id=\"coronavirus_emergency_message\" class=\"coronavirus_emergency_message\">\n" +
            "            <h2 class=\"top\">COVID-19 is an emerging, rapidly evolving situation.</h2>\n" +
            "            <p>Get the <a href=\"https://www.coronavirus.gov\" >latest public health information from CDC</a>.</p>\n" +
            "        \t<p>Get the <a href=\"https://combatcovid.hhs.gov\">latest research information from NIH</a>.</p>\n" +
            "        </div>\n" +
            "      </div>\n" +
            "    <!--  END Coronavirus Emergency infromation -->\n" +
            "    <header class=\"nav-container\">\n" +
            "    \t<div id=\"header-content\">\n" +
            "    \t\t<div id=\"header-logos\">\n" +
            "    \t\t\t<img alt=\"National Institute of Environmental Health Sciences (NIEHS)\" class=\"print-logo print-only\" width=\"300\" height=\"56\" src=\"https://kids.niehs.nih.gov/resources/images/logo-niehs-print.gif\"/>\n" +
            "    \t\t\t<a href=\"https://www.niehs.nih.gov/\"><div id=\"logo-niehs\" aria-label=\"NIEHS logo\"></div></a>\n" +
            "    \t\t\t<a href=\"https://kids.niehs.nih.gov\"><div class=\"logo-kids\"><span class=\"kids-logo-color-one\" title=\"Kids Environment\">Kids Environment</span> <span class=\"kids-logo-color-two\" title=\"Kids Health\">Kids Health</span></div></a>\n" +
            "    \t\t\t<div class=\"print-only logo-kids\"><span class=\"kids-logo-color-one\" title=\"Kids Environment\">Kids Environment</span> <span class=\"kids-logo-color-two\" title=\"Kids Health\">Kids Health</span></div>\n" +
            "    \t\t</div>\n" +
            "    \t\t\t\t\t\t\t<div class=\"kids-nav-wrapper\">\n" +
            "    \t\t\t<div id=\"mobileNavButton\" class=\"hideForTabletDesktop lines-button \"> Menu <span class=\"lines\"></span> </div>\n" +
            "    \t\t\t<div id=\"header-search\">\n" +
            "2021-03-16 11:50:00.833 2167-2167/com.waigres E/test: \t\t\t\t<div id=\"search-form\">\n" +
            "    \t\t\t\t\t<form action=\"https://seek.niehs.nih.gov/texis/search/\" method=\"get\">\n" +
            "                            <label for=\"pr\" class=\"hidden-input\">Search</label>\n" +
            "    \t\t\t\t\t\t<input class=\"hidden-input\" name=\"pr\" id=\"pr\" value=\"internet-kids\" type=\"text\" title=\"pr\" aria-label=\"pr\" />\n" +
            "                            <label for=\"search\" class=\"hidden-input\">Search Kids Pages</label>\n" +
            "    \t\t\t\t\t\t<input type=\"search\" name=\"query\" id=\"search\" placeholder=\"Search Kids Pages\" title=\"search\" aria-label=\"search\" />\n" +
            "    \t\t\t\t\t\t<button id=\"search-button\" title=\"submit\" type=\"submit\" value=\"submit\" title=\"submit\" aria-label=\"submit\" ></button>\n" +
            "    \t\t\t\t\t</form>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t</div>\n" +
            "    \t\t\t<div id=\"header-nav\">\n" +
            "    \t\t\t\t<div class=\"nav\">\n" +
            "    \t\t\t\t\t<nav>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-topics\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-topics\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/index.htm\" class=\"nav-topics-a\">\t\t\t\t\t\t\t<div class=\"icon\" id=\"topics\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Topics</span></a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"subpages subtopics\">\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/chemicals/index.htm\">Chemicals</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/climate-change/index.htm\">Climate Change</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/environment-health/index.htm\">Environment &amp; Health</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/healthy-living/index.htm\">Healthy Living</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/pollution/index.htm\">Pollution</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/reduce/index.htm\">Reduce, Reuse, Recycle</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/how-science-works/index.htm\">Science &#8211; How It Works</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/natural-world/index.htm\">The Natural World</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t</li>\n" +
            "    \t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-games\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-games\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/index.htm\" class=\"nav-games-a\">\t\t\t\t\t\t\t<div class=\"icon\" id=\"games\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Games</span></a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"subpages subgames\">\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/brainteasers/index.htm\">Brainteasers</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/emojis/_index.cfm\">Emoji Games</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/puzzles/index.htm\">Puzzles</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/riddles/index.htm\">Riddles</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/songs/index.htm\">Songs</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t</li>\n" +
            "    \t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-activities\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-activities\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/index.htm\" class=\"nav-activities-a\">\t\t\t\t\t\t\t<div class=\"icon\" id=\"activities\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Activities</span></a>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"subpages subactivities\">\n" +
            "2021-03-16 11:50:00.833 2167-2167/com.waigres E/test: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/be-a-scientist/index.htm\">Be a Scientist</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/coloring/index.htm\">Coloring</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/connect-the-dots/index.htm\">Connect the Dots</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/science-experiments/index.htm\">Science Experiments</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/stories/index.htm\">Stories</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t</li>\n" +
            "    \t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-lessons\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-lessons\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/lessons/index.htm\" class=\"nav-lessons-a\">\t\t\t\t\t\t\t<div class=\"icon\" id=\"lessons\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Lessons</span></a>\t\t\t\t\t\t\t\t\t\t\t\t\t</li>\n" +
            "    \t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</nav>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t</div>\n" +
            "    \t\t</div>\n" +
            "    \t</div>\n" +
            "    <script>NS_CSM_td=285142444;NS_CSM_pd=275116665;NS_CSM_u=\"/clm10\";NS_CSM_col=\"af_collector_logstream_157.98.96.21\";</script><script type=\"text/javascript\">function sendTimingInfoInit(){setTimeout(sendTimingInfo,0)}function sendTimingInfo(){var wp=window.performance;if(wp){var c1,c2,t;c1=wp.timing;if(c1){var cm={};cm.ns=c1.navigationStart;if((t=c1.unloadEventStart)>0)cm.us=t;if((t=c1.unloadEventEnd)>0)cm.ue=t;if((t=c1.redirectStart)>0)cm.rs=t;if((t=c1.redirectEnd)>0)cm.re=t;cm.fs=c1.fetchStart;cm.dls=c1.domainLookupStart;cm.dle=c1.domainLookupEnd;cm.cs=c1.connectStart;cm.ce=c1.connectEnd;if((t=c1.secureConnectionStart)>0)cm.scs=t;cm.rqs=c1.requestStart;cm.rss=c1.responseStart;cm.rse=c1.responseEnd;cm.dl=c1.domLoading;cm.di=c1.domInteractive;cm.dcls=c1.domContentLoadedEventStart;cm.dcle=c1.domContentLoadedEventEnd;cm.dc=c1.domComplete;if((t=c1.loadEventStart)>0)cm.ls=t;if((t=c1.loadEventEnd)>0)cm.le=t;cm.tid=NS_CSM_td;cm.pid=NS_CSM_pd;cm.ac=NS_CSM_col;var xhttp=new XMLHttpRequest();if(xhttp){var JSON=JSON||{};JSON.stringify=JSON.stringify||function(ob){var t=typeof(ob);if(t!=\"object\"||ob===null){if(t==\"string\")ob='\"'+ob+'\"';return String(ob);}else{var n,v,json=[],arr=(ob&&ob.constructor==Array);for(n in ob){v=ob[n];t=typeof(v);if(t==\"string\")v='\"'+v+'\"';else if(t==\"object\"&&v!==null)v=JSON.stringify(v);json.push((arr?\"\":'\"'+n+'\":')+String(v));}return(arr?\"[\":\"{\")+String(json)+(arr?\"]\":\"}\");}};xhttp.open(\"POST\",NS_CSM_u,true);xhttp.send(JSON.stringify(cm));}}}}if(window.addEventListener)window.addEventListener(\"load\",sendTimingInfoInit,false);else if(window.attachEvent)window.attachEvent(\"onload\",sendTimingInfoInit);else window.onload=sendTimingInfoInit;</script></header>\n" +
            "    <div id=\"mobile-header-nav\">\n" +
            "    \t<div class=\"nav\">\n" +
            "    \t\t<nav>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-topics\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-topics\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/index.htm\" class=\"nav-topics-a\">\n" +
            "    \t\t\t\t\t\t\t<div class=\"icon\" id=\"topics\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Topics</span> </a>\n" +
            "2021-03-16 11:50:00.833 2167-2167/com.waigres E/test: \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"expand_button\">Expand<span class=\"expand_lines\"></span> </div>\t\t\t\t\t\t\t\t<ul class=\"subpages subtopics\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/chemicals/index.htm\">Chemicals</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/climate-change/index.htm\">Climate Change</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/environment-health/index.htm\">Environment &amp; Health</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/healthy-living/index.htm\">Healthy Living</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/pollution/index.htm\">Pollution</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/reduce/index.htm\">Reduce, Reuse, Recycle</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/how-science-works/index.htm\">Science &#8211; How It Works</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/natural-world/index.htm\">The Natural World</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\t\t\t\t</li>\t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-games\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-games\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/index.htm\" class=\"nav-games-a\">\n" +
            "    \t\t\t\t\t\t\t<div class=\"icon\" id=\"games\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Games</span> </a>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"expand_button\">Expand<span class=\"expand_lines\"></span> </div>\t\t\t\t\t\t\t\t<ul class=\"subpages subgames\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/brainteasers/index.htm\">Brainteasers</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/emojis/_index.cfm\">Emoji Games</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/puzzles/index.htm\">Puzzles</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/riddles/index.htm\">Riddles</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/songs/index.htm\">Songs</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\t\t\t\t</li>\t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-activities\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-activities\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/index.htm\" class=\"nav-activities-a\">\n" +
            "    \t\t\t\t\t\t\t<div class=\"icon\" id=\"activities\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Activities</span> </a>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"expand_button\">Expand<span class=\"expand_lines\"></span> </div>\t\t\t\t\t\t\t\t<ul class=\"subpages subactivities\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/be-a-scientist/index.htm\">Be a Scientist</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/coloring/index.htm\">Coloring</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/connect-the-dots/index.htm\">Connect the Dots</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/science-experiments/index.htm\">Science Experiments</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/stories/index.htm\">Stories</a></li>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\t\t\t\t</li>\t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"menu-item menu-lessons\">\n" +
            "    \t\t\t\t\t<ul id=\"nav-lessons\">\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/lessons/index.htm\" class=\"nav-lessons-a\">\n" +
            "    \t\t\t\t\t\t\t<div class=\"icon\" id=\"lessons\" alt=\"Navigation Icon, Click to Explore\"> </div>\n" +
            "    \t\t\t\t\t\t\t<span class=\"nav-roll-forced\">Lessons</span> </a>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t</li>\t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</nav>\n" +
            "    \t</div>\n" +
            "    </div>\n" +
            "    \n" +
            "    <div class=\"kids-body-wrapper\">\n" +
            "    \n" +
            "    \t\t \t\t\t\n" +
            "    <!-- SKIPNAV ANCHOR -->\n" +
            "    <div id=\"skip-nav\" name=\"skip-nav\" tabindex=\"-1\"></div>\n" +
            "    \n" +
            "    <section class=\"kids-page-heading kids-games-heading\">\n" +
            "    \t<div class=\"kids-heading\">\n" +
            "2021-03-16 11:50:00.833 2167-2167/com.waigres E/test: \t\t<h1 class=\"kids-heading-title\">Fun Facts and Trivia</h1>\n" +
            "    \t</div>\n" +
            "    </section>\n" +
            "    \t\t\t<div class=\"primary-section left\">\n" +
            "    \t<div class=\"kids-breadcrumbs\">\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"kids-breadcrumbs__item-holder\">\n" +
            "    \t\t\t<a class=\"kids-breadcrumbs__item c--ancestor\" href=\"/index.htm\">Kids Homepage</a>\t\t\t<div class=\"kids-breadcrumbs__arrow\"></div>\n" +
            "    \t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"kids-breadcrumbs__item-holder\">\n" +
            "    \t\t\t<div class=\"kids-breadcrumbs__arrow c--inset\"></div>\n" +
            "    \t\t\t<a class=\"kids-breadcrumbs__item c--parent\" href=\"/games/index.htm\">Games</a>\t\t\t<div class=\"kids-breadcrumbs__arrow\"></div>\n" +
            "    \t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"kids-breadcrumbs__item-holder\">\n" +
            "    \t\t\t<div class=\"kids-breadcrumbs__arrow c--inset\"></div>\n" +
            "    \t\t\t<a class=\"kids-breadcrumbs__item c--parent\" href=\"/games/riddles/index.htm\">Riddles</a>\t\t\t<div class=\"kids-breadcrumbs__arrow\"></div>\n" +
            "    \t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"kids-breadcrumbs__item-holder\">\n" +
            "    \t\t\t<div class=\"kids-breadcrumbs__arrow c--inset\"></div>\n" +
            "    \t\t\t<a class=\"kids-breadcrumbs__item c--parent\" href=\"/games/riddles/jokes/index.htm\">Jokes</a>\t\t\t<div class=\"kids-breadcrumbs__arrow\"></div>\n" +
            "    \t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"kids-breadcrumbs__item-holder\">\n" +
            "    \t\t\t<div class=\"kids-breadcrumbs__arrow c--inset\"></div>\n" +
            "    \t\t\t<a class=\"kids-breadcrumbs__item c--selected\" href=\"/games/riddles/jokes/fun-facts-and-trivia/index.htm\">Fun Facts and Trivia</a>\n" +
            "    \t\t\t<div class=\"kids-breadcrumbs__arrow c--selected\"></div>\n" +
            "    \t\t</div>\n" +
            "    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "    </div>\n" +
            "    \t\n" +
            "    <div class=\"syndicate\">\n" +
            "    \t<h1 style=\"display:none\"> Fun Facts and Trivia</h1>\n" +
            "        <section class=\"primary-section left\">\n" +
            "    <a name=\"a783264\" id=\"a783264\" class=\"kids-anchor\"></a>\n" +
            "    \t\t\t\n" +
            "    <h3>Bet you didn't know.....</h3>\n" +
            "    \n" +
            "    <ul>\n" +
            "    <li>It is impossible for most people to lick their own elbow. (try it!)</li>\n" +
            "    \n" +
            "    <li>A crocodile cannot stick its tongue out.</li>\n" +
            "    \n" +
            "    <li>A shrimp's heart is in its head.</li>\n" +
            "    \n" +
            "    <li>It is physically impossible for pigs to look up into the sky.</li>\n" +
            "    \n" +
            "    <li>The \"sixth sick sheik's sixth sheep's sick\" is believed to be the toughest tongue twister in the English language.</li>\n" +
            "    \n" +
            "    <li>If you sneeze too hard, you could fracture a rib.</li>\n" +
            "    \n" +
            "    <li>Wearing headphones for just an hour could increase the bacteria in your ear by 700 times.</li>\n" +
            "    \n" +
            "    <li>In the course of an average lifetime, while sleeping you might eat around 70 assorted insects and 10 spiders, or more.</li>\n" +
            "    \n" +
            "    <li>Some lipsticks contain fish scales.</li>\n" +
            "    \n" +
            "    <li>Cat urine glows under a black-light.</li>\n" +
            "    \n" +
            "    <li>Like fingerprints, everyone's tongue print is different.</li>\n" +
            "    \n" +
            "    <li>Rubber bands last longer when refrigerated.</li>\n" +
            "    \n" +
            "    <li>There are 293 ways to make change for a dollar.</li>\n" +
            "    \n" +
            "    <li>The average person's left hand does 56% of the typing (when using the proper position of the hands on the keyboard; Hunting and pecking doesn't count!).</li>\n" +
            "    \n" +
            "    <li>A shark is the only known fish that can blink with both eyes.</li>\n" +
            "    \n" +
            "    <li>The longest one-syllable words in the English language are \"scraunched\" and \"strengthed.\" Some suggest that \"squirreled\" could be included, but squirrel is intended to be pronounced as two syllables (squir-rel) according to most dictionaries. \"Screeched\" and \"strengths\" are two other long one-syllable words, but they only have 9 letters.</li>\n" +
            "    \n" +
            "    <li>\"Dreamt\" is the only English word that ends in the letters \"mt\".</li>\n" +
            "    \n" +
            "    <li>Almonds are a member of the peach family.</li>\n" +
            "    \n" +
            "    <li>Maine is the only state that has a one-syllable name.</li>\n" +
            "    \n" +
            "    <li>There are only four words in the English language which end in \"dous\": tremendous, horrendous, stupendous, and hazardous.</li>\n" +
            "    \n" +
            "    <li>Los Angeles' full name is \"El Pueblo de Nuestra Senora la Reina de los Angeles de Porciuncula\"</li>\n" +
            "    \n" +
            "    <li>A cat has 32 muscles in each ear.</li>\n" +
            "    \n" +
            "    <li>An ostrich's eye is bigger than its brain.</li>\n" +
            "    \n" +
            "    <li>Tigers have striped skin, not just striped fur.</li>\n" +
            "    \n" +
            "    <li>In many advertisements, the time displayed on a watch is 10:10.</li>\n" +
            "2021-03-16 11:50:00.833 2167-2167/com.waigres E/test: <li>The characters Bert and Ernie on Sesame Street were named after Bert the cop and Ernie the taxi driver in Frank Capra's \"It's a Wonderful Life.\"</li>\n" +
            "    \n" +
            "    <li>A dime has 118 ridges around the edge.</li>\n" +
            "    \n" +
            "    <li>The giant squid has the largest eyes in the world.</li>\n" +
            "    \n" +
            "    <li>Most people fall asleep in seven minutes.</li>\n" +
            "    \n" +
            "    <li>\"Stewardesses\" is the longest word that is typed with only the left hand.</li>\n" +
            "    </ul>\n" +
            "    \t\n" +
            "    \t\n" +
            "    </section>\n" +
            "        <section class=\"secondary-section left\">\n" +
            "        \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"callout-box topics\">\n" +
            "    \t<div class=\"callout-badge\">\n" +
            "    \t\t<img alt=\"green apple\" src=\"/assets/images/sidebar/img21588.png\" data-id=\"21588\" />\n" +
            "    \t</div>\n" +
            "    \t<div class=\"callout-title\">\n" +
            "    \t\t<h5>Other stuff you might like ...</h5>\n" +
            "    \t\t<h5 class=\"callout-title-inner\">Healthy Living</h5>\n" +
            "    \t</div>\n" +
            "    \t<div class=\"callout-subtitle\">Find out about staying healthy as you grow up.</div>\n" +
            "    \t\t<a href=\"/topics/healthy-living/index.htm\"><div class=\"callout-button\">Go! </div></a>\n" +
            "    </div>\n" +
            "                </section>\n" +
            "    </div>\n" +
            "    <a href='#' class=\"back-to-top-href\"><div class=\"back-to-top topics\" tabindex=\"0\" style=\"bottom: 0px;\"><div class=\"back-to-top__text\">Back to Top</div></div></a>\n" +
            "    \t\t\t<div class=\"kids-spacer\"></div>\n" +
            "    \t<footer>\n" +
            "    \t<div class=\"little-kids-content mobile\">\n" +
            "    \t\t<div class=\"little-kids-about\">\n" +
            "    \t\t\tCheck out games<br/> and songs for <br/>little kids!\n" +
            "    \t\t</div>\n" +
            "    \t\t<a class=\"little-kids-link\" href=\"https://kids.niehs.nih.gov/little-kids/\" aria-label=\"Little Kids\">\t\t\t\t\t\t<div class=\"little-kids mobile\"></div>\t\t</a>\t</div>\n" +
            "    \t<div id=\"footer-container\">\n" +
            "    \t\t<ul id=\"footer-navigation\">\n" +
            "    \t\t\t<li>\n" +
            "    \t\t\t\t<div class=\"footer-links\">\n" +
            "    \t\t\t\t\t<ul>\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/topics/\">Topics</a></li>\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/games/\">Games</a></li>\n" +
            "    \t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t</li>\n" +
            "    \t\t\t<li>\n" +
            "    \t\t\t\t<div class=\"footer-links\">\n" +
            "    \t\t\t\t\t<ul>\n" +
            "    \t\t\t\t\t\t<li><a href=\"https://kids.niehs.nih.gov/activities/\">Activities</a></li>\n" +
            "    \t\t\t\t\t\t<li class=\"unfloat\"><a href=\"https://kids.niehs.nih.gov/lessons/\">Lessons</a></li>\n" +
            "    \t\t\t\t\t</ul>\n" +
            "    \t\t\t\t</div>\n" +
            "    \t\t\t</li>\n" +
            "    \t\t</ul>\n" +
            "    \t\t<a class=\"little-kids-link\" href=\"https://kids.niehs.nih.gov/little-kids/\"><div id=\"little-kids\" class=\"little-kids but-mobile\"></div></a>\n" +
            "    \t\t<div class=\"hr\"></div>\n" +
            "    \t\t<ul id=\"footer-navigation-sub\">\n" +
            "    \t\t\t<li><a href=\"https://kids.niehs.nih.gov/about/\">About</a></li>\n" +
            "    \t\t\t<li><a href=\"https://kids.niehs.nih.gov/contact/\">Contact Us</a></li>\n" +
            "    \t\t\t<li><a href=\"https://www.niehs.nih.gov/about/foia/\">Freedom of Information Act</a></li>\n" +
            "    \t\t\t<li><a href=\"https://kids.niehs.nih.gov/little-kids/\">Little Kids</a></li>\n" +
            "    \t\t\t<li><a href=\"https://oig.hhs.gov/\">Office of the Inspector General</a></li>\n" +
            "    \t\t\t<li><a href=\"https://kids.niehs.nih.gov/sitemap/\">Site Map</a></li>\n" +
            "    \t\t\t<li><a href=\"https://kids.niehs.nih.gov/about/web-policies/\">Web Policies</a></li>\n" +
            "    \t\t</ul>\n" +
            "    \t\t<p id=\"footer-about\"><span id=\"footer-content\" class=\"but-mobile\">NIEHS Kids&#39; Pages are supported by the <a href=\"https://www.niehs.nih.gov/about/od/ocpl/\">NIEHS Office of Communications and Public Liaison</a>. <br/>111 T.W. Alexander Drive, Durham, NC 27709</span></p>\n" +
            "    \t\t\t\t\t\t<div class=\"kids-request-update\"><a id=\"updateThisPage\" target=\"_blank\" title=\"NIEHS Staff: Request an Update of This Webpage\" href='#' class=\"kids-request-update__link\">NIEHS Staff: Request an Update of This Webpage</a></div>\n" +
            "    \t\t<div class=\"kids-last-reviewed-date\">Last Reviewed: April 14, 2016</div>\n" +
            "    \t\t<div class=\"organizations\">\t\t\t<a href=\"https://www.hhs.gov/\" target=\"_blank\" title=\"Department of Health &amp; Human Services\"><img alt=\"Department of Health and Human Services (HHS)\" class=\"logo-niehs-grayscale hhs\" src=\"https://kids.niehs.nih.gov/resources/images/hhs-logo.png\"/></a>\t\t\t<a href=\"https://www.usa.gov/\" target=\"_blank\" title=\"USA.gov\"><img alt=\"United States Government (USA GOV)\" class=\"logo-niehs-grayscale usagov\" src=\"https://kids.niehs.nih.gov/resources/images/ftr-usagov.png\"/></a>\t\t</div>\n" +
            "    \t</div>\n" +
            "    </footer>\n" +
            "    </div><!-- close kids-body-wrapper -->\n" +
            "2021-03-16 11:50:00.833 2167-2167/com.waigres E/test: </div><!-- close kids-site-wrapper -->\n" +
            "    <script src=\"https://kids.niehs.nih.gov/resources/javascript/main.js\"></script>\n" +
            "    <script type=\"text/javascript\" src=\"https://s7.addthis.com/js/300/addthis_widget.js#pubid=ra-56953cbef0b40a1a\" async></script>\n" +
            "    </body>\n" +
            "    </html>"
    @Test
    fun getListFunFactTest() {
        val expectedResult = arrayListOf<String>()
        expectedResult.add("It is impossible for most people to lick their own elbow. (try it!)")
        expectedResult.add("A crocodile cannot stick its tongue out.")
        expectedResult.add("A shrimp's heart is in its head.")
        expectedResult.add("It is physically impossible for pigs to look up into the sky.")
        expectedResult.add("The \"sixth sick sheik's sixth sheep's sick\" is believed to be the toughest tongue twister in the English language.")
        expectedResult.add("If you sneeze too hard, you could fracture a rib.")
        expectedResult.add("Wearing headphones for just an hour could increase the bacteria in your ear by 700 times.")
        expectedResult.add("In the course of an average lifetime, while sleeping you might eat around 70 assorted insects and 10 spiders, or more.")
        expectedResult.add("Some lipsticks contain fish scales.")
        expectedResult.add("Cat urine glows under a black-light.")
        expectedResult.add("Like fingerprints, everyone's tongue print is different.")
        expectedResult.add("Rubber bands last longer when refrigerated.")
        expectedResult.add("There are 293 ways to make change for a dollar.")
        expectedResult.add("The average person's left hand does 56% of the typing (when using the proper position of the hands on the keyboard; Hunting and pecking doesn't count!).")
        expectedResult.add("A shark is the only known fish that can blink with both eyes.")
        expectedResult.add("The longest one-syllable words in the English language are \"scraunched\" and \"strengthed.\" Some suggest that \"squirreled\" could be included, but squirrel is intended to be pronounced as two syllables (squir-rel) according to most dictionaries. \"Screeched\" and \"strengths\" are two other long one-syllable words, but they only have 9 letters.")
        expectedResult.add("\"Dreamt\" is the only English word that ends in the letters \"mt\".")
        expectedResult.add("Almonds are a member of the peach family.")
        expectedResult.add("Maine is the only state that has a one-syllable name.")
        expectedResult.add("There are only four words in the English language which end in \"dous\": tremendous, horrendous, stupendous, and hazardous.")
        expectedResult.add("Los Angeles' full name is \"El Pueblo de Nuestra Senora la Reina de los Angeles de Porciuncula\"")
        expectedResult.add("A cat has 32 muscles in each ear.")
        expectedResult.add("An ostrich's eye is bigger than its brain.")
        expectedResult.add("Tigers have striped skin, not just striped fur.")
        expectedResult.add("In many advertisements, the time displayed on a watch is 10:10.")
        expectedResult.add("The characters Bert and Ernie on Sesame Street were named after Bert the cop and Ernie the taxi driver in Frank Capra's \"It's a Wonderful Life.\"")
        expectedResult.add("A dime has 118 ridges around the edge.")
        expectedResult.add("The giant squid has the largest eyes in the world.")
        expectedResult.add("Most people fall asleep in seven minutes.")
        expectedResult.add("\"Stewardesses\" is the longest word that is typed with only the left hand.")
        Assert.assertEquals(expectedResult.toList(), ParseFromWeb(html).getListFunFact())
    }
    @Test
    fun getListFunFactTest_EmptyString() {
        val expectedResult = arrayListOf<String>()
        Assert.assertEquals(expectedResult.toList(), ParseFromWeb("").getListFunFact())
    }
    @Test
    fun getListFunFactTest_DifferentBetweenContent() {
        val html = "<Html>" +
                "<div class=\"syndicates\">" +
                "<li>test</li>" +
                "</ul>" +
                "</Html>"
        val expectedResult = arrayListOf<String>()
        Assert.assertEquals(expectedResult.toList(), ParseFromWeb(html).getListFunFact())
    }
    @Test
    fun getListFunFactTest_simpleTest() {
        val html = "<Html>" +
                "<div class=\"syndicate\">" +
                "<li>test</li>" +
                "</ul>" +
                "</Html>"
        val expectedResult = arrayListOf<String>()
        expectedResult.add("test")
        Assert.assertEquals(expectedResult.toList(), ParseFromWeb(html).getListFunFact())
    }
}