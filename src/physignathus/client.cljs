(ns physignathus.client
  (:require [uix.core :refer [defui $]]
            [uix.dom]
            [refx.alpha :as refx]))

(defui app []
  ($ :p "yes got it"))

(defonce root
  (uix.dom/create-root (js/document.getElementById "root")))

(defn start
  []
  #_(refx/dispatch-sync [:init-db])
  (uix.dom/render-root ($ app) root)
  (prn :start))

(defn after-load
  []
  (uix.dom/render-root ($ app) root)
  (prn :after-load))
