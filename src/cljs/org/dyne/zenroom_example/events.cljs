(ns org.dyne.zenroom-example.events
  (:require
   [org.dyne.zenroom-example.db :as db]
   [re-frame.core :as re-frame]
   [zenroom :default zenroom]))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/initial-db))

(re-frame/reg-fx
 ::zenroom
 (fn [script]
   (doto zenroom
     (.script script)
     (.print (fn [s] (re-frame/dispatch [::zenroom-printed s])))
     (.success (fn [] (re-frame/dispatch [::zenroom-success true])))
     (.error (fn [] (re-frame/dispatch [::zenroom-success false])))
     .zenroom-exec)))

(re-frame/reg-event-fx
 ::script-submitted
 (fn [_ [_ script]]
   (println ::submitted {:script script})
   {::zenroom script}))

(re-frame/reg-event-db
 ::zenroom-printed
 (fn [db [_ result]]
   (println ::printed {:result result})
   (update db ::db/zenroom-results conj result)))

(re-frame/reg-event-db
 ::zenroom-success
 (fn [db [_ success?]]
   (println ::success {:succes? success?})
   (assoc db ::db/zenroom-success? success?)))
