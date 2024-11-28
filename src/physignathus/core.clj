(ns physignathus.core
  (:require [aleph.http :as aleph]
            ;[muuntaja.core :as muuntaja]
            [reitit.ring :as ring]
            [integrant.core :as ig]
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

(def config
  {:server/aleph {:port 8000 :handler app}})

(def dev-config
  (-> config
      (assoc :server/shadow {:profiles [:physignathus]})))

; Start and stop the web server
(defmethod ig/init-key :server/aleph [_ {:keys [handler port]}]
  (aleph/start-server handler {:port port}))
(defmethod ig/halt-key! :server/aleph [_ server]
  (.close server))

; Start and Stop the shadow.cljs server
(defmethod ig/init-key :server/shadow [_ {:keys [profiles]}]
  (-> `shadow.cljs.devtools.server/start!
      requiring-resolve
      (apply []))
  (-> `shadow.cljs.devtools.api/watch
      requiring-resolve
      (apply profiles)))
(defmethod ig/halt-key! :server/shadow [_ _]
  (-> `shadow.cljs.devtools.server/stop!
      requiring-resolve
      (apply [])))

#_(def system
   (ig/init config))

(def dev-system
  (ig/init dev-config))

(defn -main
  [& _args])

(comment
  (ig/halt! dev-system))
