(ns ^:figwheel-hooks dev.milt.personal-site
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]))


(defn multiply [a b] (* a b))


(defn get-app-element []
  (gdom/getElement "app"))

(defn headshot
  []
  [:img.headshot
   {:src "img/milt_github.jpeg"
    :alt "picture_of_milt"}])

(defn links
  []
  [:ul.links
   [:li
    [:a {:href "https://github.com/milt"}
     "github"]]
   [:li
    [:a {:href "https://twitter.com/miltreder"}
     "@miltreder"]]
   [:li
    [:a {:href "https://www.yetanalytics.com"}
     "yet"]]])

(defn header
  []
  [:header
   [headshot]
   [:div.name
    [:div.title "Milt Reder"]
    [:div.subtitle
     "VP Engineering @ Yet Analytics Inc."]]
   [links]])

(defn footer
  []
  [:footer
   "Ⓒ 2020 Milton Reder"
   [:span
    "Made with "
    [:a {:href "https://clojurescript.org"}
     "ClojureScript"]
    " and "
    [:a {:href "https://figwheel.org/"}
     "Figwheel"]
    ", which you should try."]])

(defn content
  []
  [:main.content
   [:section
    [:h2
     "Hi!"]
    [:p "My name is Milt, and I spend most of my time building things with "
     [:a {:href "https://clojure.org/"}
      "Clojure"]
     " and "
     [:a {:href "https://clojurescript.org/"}
      "ClojureScript"]
     "."]
    [:p "I usually build them at "
     [:a {:href "https://www.yetanalytics.com/"}
      "Yet Analytics"]
     " alongside a very clever group of people. "]]])

(defn main []
  [:div.site
   [header]
   [content]
   [footer]])

(defn mount [el]
  (reagent/render-component [main] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
