package com.musicmakers

import org.scaloid.common._
import android.graphics.Color

class Main extends SActivity {
  implicit override val loggerTag = LoggerTag("MATT TAG")
  lazy val meToo = new STextView("Me too")
  lazy val redBtn = new SButton(R.string.red)
  lazy val webView = new SWebView()

  onCreate {
    contentView = new SVerticalLayout {
      style {
        case b: SButton => b.textColor(Color.RED).onClick(meToo.text = "PRESSED")
        case t: STextView => t textSize 10.dip
        case e: SEditText => e.backgroundColor(Color.YELLOW).textColor(Color.BLACK)
      }
      STextView("I am 10 dip tall")
      meToo.here
      STextView("I am 15 dip tall") textSize 15.dip // overriding
      new SLinearLayout {
        STextView("Button: ")
        redBtn.here
      }.wrap.here
      webView.here
      SEditText("Yellow input field fills the space").fill
    } padding 20.dip
    warn("Setting javascript enabled")
    webView.getSettings.setJavaScriptEnabled(true)
    warn("Loading the URL")
    webView.loadUrl("file:///android_asset/test.html")
  }

}
