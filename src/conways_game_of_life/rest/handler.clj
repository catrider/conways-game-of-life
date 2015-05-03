(ns conways-game-of-life.rest.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :refer [file-response resource-response
                                        status content-type]]
            [clojure.java.io :as io]))

(defroutes app-routes
  (GET "/" [] (io/resource "public/index.html"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
