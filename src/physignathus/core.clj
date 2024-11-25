(ns physignathus.core
  (:require [aleph.http :as aleph]
            ;[muuntaja.core :as muuntaja]
            [reitit.ring :as ring]
            [physignathus.mainpage :as mainpage]))
;[reitit.coercion.malli]))
;[reitit.ring.malli]))
;[malli.util :as mu]))

(def app
  (ring/ring-handler
    (ring/router
      ["/" {:get {:handler (fn [_] {:status 200
                                    :content-type "text/html"
                                    :body mainpage/mainpage})}}])
    (ring/routes
      (ring/create-file-handler {:path "/"
                                 :root "target/public"})
      (ring/create-default-handler
        {:not-found (constantly {:status 404, :body "404, not found"})
         :method-not-allowed (constantly {:status 405, :body "405, not allowed"})
         :not-acceptable (constantly {:status 406, :body "406, not acceptable"})}))))

(defonce server (atom nil)) 

(defn -main
  [& _args]
  (reset! server (aleph/start-server app {:port 8000})))

(defn restart-dev-server
  []
  (.close @server)
  (reset! server (aleph/start-server app {:port 8000})))

(defn dev-main
  [& _]
  (-> `shadow.cljs.devtools.server/start!
    requiring-resolve
    (apply []))
  (-> `shadow.cljs.devtools.api/watch
    requiring-resolve
    (apply [:physignathus]))
  (-main))

(comment
  (dev-main)
  (restart-dev-server)
  #_(-main))
