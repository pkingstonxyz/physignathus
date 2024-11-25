(ns physignathus.core
  (:require [aleph.http :as aleph]
            ;[muuntaja.core :as muuntaja]
            [reitit.ring :as ring]))
            ;[reitit.coercion.malli]))
            ;[reitit.ring.malli]))
            ;[malli.util :as mu]))

(def app
  (ring/ring-handler
    (ring/router
      ["/" {:get {:handler (fn [_] {:status 200
                                    :content-type "text/html"
                                    :body "Hello"})}}])
    (ring/routes
          (ring/create-resource-handler {:path "/"})
          (ring/create-default-handler
             {:not-found (constantly {:status 404, :body "404, not found"})
              :method-not-allowed (constantly {:status 405, :body "405, not allowed"})
              :not-acceptable (constantly {:status 406, :body "406, not acceptable"})}))))


(defn -main
  [& _args]
  (aleph/start-server app {:port 8000}))
