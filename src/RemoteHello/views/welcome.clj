(ns RemoteHello.views.welcome
  (:require [RemoteHello.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [noir.fetch.remotes :only [defremote]]))

(defremote load-hello [msg]
  (str "Remote Hello - " msg))

(defpage "/welcome" []
         (common/layout
           [:dev#header
             [:h2.pagetitle "Test Hello World Application"]]
           [:p "Enter input message and hit enter."]
           [:div#mytest
              [:input#tag {type "text"}]]
           [:dev#hellobox
              [:div#hello]]
))
