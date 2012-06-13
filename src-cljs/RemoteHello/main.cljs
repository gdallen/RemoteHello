(ns RemoteHello.main
  (:require [crate.core :as crate]
            [fetch.remotes :as remotes]
            [fetch.core :as core]
            [jayq.core :as jq])
  (:use-macros [crate.macros :only [defpartial]])
  (:require-macros [fetch.macros :as fm])
)

;(js/alert "start")

(def enter-key 13)
(defn- key-pressed [key-code func event]
  "if keypressed = keycode then call func"
  (when (= (.-keyCode event) key-code)
    (func)))

(defn return-key-pressed [f]
  (partial key-pressed enter-key f))

(def selectors
  (hash-map
    :message (jq/$ :#tag)
    :hellobox (jq/$ :#hellobox)))

(defn get-value [selector]
  "Get the vlaue of a slector, e.g. an input box"
  (let [value (jq/val selector)]
    (when (not= value "")
      value)))


(defn get-message []
  "Gets the value of the message input box"
  (get-value (selectors :message)))

(defn load-hello []
  "Function that sends name back to the server"
  (when-let [tag (get-message)]
    (fm/remote (load-hello tag) [remote-message]
      (when-not (= [] remote-message)
        (display-message remote-message)
      ))))

(defpartial part-message [msg]
  [(keyword (str "div#msg"))
    [:p.text msg]])

(defn display-message [message]
  (jq/prepend (selectors :hellobox)
    (crate/html [:p (part-message message)])))

(jq/bind (selectors :message) :keypress (return-key-pressed load-hello))

;(js/alert "still working")
