 FixToolTip = {
    byteWrap:function(str,wrap) {
        var byteLength = 0;
        var result = "";
        var length = str.length;
         for (var i = 0; i < length; i++) {
             var c = str.charCodeAt(i);
             var cs = str.charAt(i);
             if ( (c >= 0x0 && c < 0x81) || (c == 0xf8f0) || (c >= 0xff61 && c < 0xffa0) || (c >= 0xf8f1 && c < 0xf8f4)) {
                 byteLength += 1;
             } else {
                 byteLength += 2;
             }
             if(wrap < byteLength) {
                 return result;
             }
             result += cs;
         }
         return result;
    },
    toolTip: function(select) {
             var selector = ".toolTip";

              if(select) {
                  selector = select + " .toolTip";
              }

              $(selector).each(function(){
                  var dom =$(this);
                  var wrap = dom.attr('wwrap');
                  var text = dom.text();
                  //ラップ
                  var wrapWord = FixToolTip.byteWrap(text,wrap);
                  //ラップされた場合
                  if(wrapWord != text) {
                      //ラップ文字に置換
                      dom.text(wrapWord+"..");

                      var val = '';
                      for (var i = 0; i < text.length; ++i) {
                          tmp = text.charAt(i);
                          switch (tmp) {
                          case "&": val += "&amp;"; break;
                          case "<": val += "&lt;"; break;
                          case ">": val += "&gt;"; break;
                          case "\"": val += "&quot;"; break;
                          default: val += tmp; break;
                          }
                      }
                      dom.attr('title', val);
                  }
                  else {
                      dom.removeClass('toolTip');
                  }
              });

              $(selector + '*').tooltip();
        }

}