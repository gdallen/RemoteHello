(ns RemoteHello.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "RemoteHello"]
               (include-css "/css/reset.css")
               (include-js "https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js")
              ]
              [:body
               [:div#wrapper
                content]
               (include-js "/cljs/main.js")]))
